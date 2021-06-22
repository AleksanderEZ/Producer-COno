package fastfood;

//Modifique y añada lo que crea necesarios

public class Puesto {
    private volatile int racionesPapas;
    private volatile int hamburguesas;
    private int maxRacionesPapas;
    private int maxHamburguesas;
    private volatile boolean abierto;
    public Puesto(int maxRacionesPapas, int maxHamburguesas){
        this.racionesPapas = 0;
        this.hamburguesas = 0;
        this.maxRacionesPapas = maxRacionesPapas;
        this.maxHamburguesas = maxHamburguesas;
    }
    public synchronized void abre() {
        Simulador.log("Puesto abierto");
        this.abierto = true;
        notifyAll();
    }
    public synchronized void cierra() {
        Simulador.log("Puesto cerrado");
        this.abierto = false;
        notifyAll();
    }
    public boolean estáAbierto() {
        boolean resultado = abierto;
        return resultado;
    }
    public synchronized void añadirHamburguesas(){
        while(hamburguesas >= maxHamburguesas-3){
            try{
                wait();
            } catch (InterruptedException exc) { }
        }
        hamburguesas += 4;
        notifyAll();
    }
    public synchronized void añadirPapas(){
        while(racionesPapas >= maxRacionesPapas-3){
            try{
                wait();
            } catch (InterruptedException exc) { }
        }
        racionesPapas += 4;
        notifyAll();
    }
    public synchronized boolean obtenerComida(int cliente, int papas, int hamburguesas){
        if(estáAbierto()){
            Simulador.log("Cliente " + cliente + " [" + hamburguesas + "," + papas + "] espera por comida.");
            while(estáAbierto() && (papas > getPapas() || hamburguesas > getHamburguesas())){
                try{
                    wait();
                } catch (InterruptedException exc) { }
            }
            if(estáAbierto() == false){
                return false;
            }
            racionesPapas -= papas;
            this.hamburguesas -= hamburguesas;
            notifyAll();
            return true;
        } else {
            return false;
        }
    }
	//If data is changed then notifyAll()
    public synchronized int getHamburguesas(){
        int resultado = hamburguesas;
        return resultado;
    }
    public synchronized int getPapas(){
        int resultado = racionesPapas;
        return resultado;
    }
}

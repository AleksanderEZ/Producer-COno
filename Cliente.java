package fastfood;

import java.lang.Thread;

//Modifique y añada lo que crea necesarios
public class Cliente extends Thread{
    private int id;
    private int racionesPapas;
    private int hamburguesas;
    private Puesto puesto;
    public Cliente(int id, Puesto puesto, int racionesPapas, int hamburguesas){
        this.id = id;
        this.racionesPapas = racionesPapas;
        this.hamburguesas = hamburguesas;
        this.puesto = puesto;
    }
    @Override
    public void run(){
        Simulador.log("Cliente " + id + " [" + hamburguesas + "," + racionesPapas + "] llega al puesto.");
        boolean conseguido = puesto.obtenerComida(id, racionesPapas, hamburguesas);
        if(conseguido){
            Simulador.log("Cliente " + id + " [" + hamburguesas + "," + racionesPapas + "] consigue la comida.");
            try{
                this.sleep(Simulador.tiempoComerHamburguesa() + Simulador.tiempoComerPapas());
                Simulador.log("Cliente " + id + " [" + hamburguesas + "," + racionesPapas + "] ha comido.");
            } catch(Exception e) { }
        }
    }
}

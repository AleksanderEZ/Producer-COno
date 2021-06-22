package fastfood;

import java.lang.Thread;
//Modifique y añada lo que crea necesarios
public class Cocinero extends Thread{
    private Puesto puesto;
    private int tareas;
    public Cocinero(Puesto puesto, int tareas) {
        this.puesto = puesto;
        this.tareas = tareas;
        puesto.abre();
    }
    @Override
    public void run(){
        for(int i = 0; i < tareas; i++){
            try {
                this.sleep(Simulador.tiempoCocinar());
            } catch (Exception e) { }
            if(puesto.getHamburguesas() > puesto.getPapas()){
                puesto.añadirPapas();
            } else {
                puesto.añadirHamburguesas();
            }
        }
        puesto.cierra();
    }
}

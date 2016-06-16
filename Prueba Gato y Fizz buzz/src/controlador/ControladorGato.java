package controlador;

import vista.VentanaGato;
import modelo.Gato;

/**
 *
 * @author Humberto
 */
public class ControladorGato {
    private final Gato gato;
    private final VentanaGato vistaGato;
    private boolean respuesta;
    
    public ControladorGato(VentanaGato pVistaGato){
        this.gato = new Gato();
        this.vistaGato = pVistaGato;
        //this.vistaGato.addBoton1Listener(new GatoListener());
    }

    public boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
    
    public void recibirPosicion(int pColumna, int pFila){
        setRespuesta(gato.llenarCampo(pColumna, pFila));
    }
    
    public void cambiarTurno(){
        gato.establecerTurno();
    }
    
    public int establecerGanador(){
        int resultado;
        resultado = gato.establecerGanador();
        return resultado;
    }
    
    public void resetearJuego(){
        gato.resetearJuego();
    }
    
}

package controlador;
/**
 * Esta clase es la controla la lógica del gato y la interfaz del juego.
 * Llama a los métodos de la clase Gato, para que puedan ser utilizados en 
 * la interfaz, sin que esta "se de cuenta"
 * 
 * @version 15 de junio 2016 
 * @author Humberto
 */

import vista.VentanaGato;
import modelo.Gato;

public class ControladorGato {
    private final Gato gato;
    
    public ControladorGato(VentanaGato pVistaGato){
        this.gato = new Gato();
    }
    
    /**
    * Este método llama al método de llenar campo en la lógica del gato
    * Se llama cada vez que se haga una jugada.
    * 
    * @param  pColumna la columna que se quiere acceder
    * @param pFila la fila que se quiere acceder
    */
    public void recibirPosicion(int pColumna, int pFila){
        gato.llenarCampo(pColumna, pFila);
    }
    
    /**
    * Este método llama al método de establecer turno en la lógica del gato.
    * Depende del turno que se esté jugando. Se llama cada vez que se haga 
    * una jugada válida
    * 
    */
    public void cambiarTurno(){
        gato.establecerTurno();
    }
    
    /**
    * Este método llama al método de validar el gane de la lógica del gato.
    * 
    * @return int si el resultado es 0 hubo un gane, si es 1 un empate y si es
    * 2 el juego continua
    */
    public int establecerGanador(){
        int resultado;
        resultado = gato.validarGane();
        return resultado;
    }
    
    /**
    * Este método llama al método de resetear el juego en la lógica del gato. 
    * 
    */
    public void resetearJuego(){
        gato.resetearJuego();
    }
    
}

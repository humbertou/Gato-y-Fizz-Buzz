package modelo;

/**
 * Esta clase es la encargada de establecer la lógica del juego del gato.
 * Tiene como atributos la matriz, el turno y el contador de jugadas. 
 * 
 * @version 15 de junio 2016 
 * @author Humberto
 */


public final class Gato {
    private final String[][] matrizGato;
    private boolean turno;
    private int numeroJugada;
    
    public Gato (){
        this.matrizGato = new String[3][3];
        this.turno = true;
        this.numeroJugada = 0;
        iniciaMatrizGato();
    }

    /*
    Métodos set y get
    */
    public String[][] getTablero() {
        return matrizGato;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getNumJugada() {
        return numeroJugada;
    }

    public void setNumJugada(int numJugada) {
        this.numeroJugada = numJugada;
    }
    
    /**
    * Este método establece los valores iniciales de la matriz del tablero. Los 
    * valores son del 0 al 8
    *
    */
    public void iniciaMatrizGato(){
        int largoTablero = getTablero().length;
        int contador = 0;
        for (int contadorCol = 0; contadorCol < largoTablero; contadorCol++){
            for (int contadorFila = 0; contadorFila < largoTablero; contadorFila++){
                getTablero()[contadorCol][contadorFila] = Integer.toString(contador);
                contador++;
            }
        }
    }
    
    /**
    * Este método pone en un campo donde no haya una x o una o la letra 
    * correspondiente a la jugada. Llama al método validarPosicion para saber
    * si está ocupada o no.
    * 
    * @param pColumna columna que se quiere llenar con una x o una o
    * @param pFila fila que se quiere llenar con una x o una o
    * 
    * @return boolean falso si la posición está ocupada y true si no lo está.
    */
    public boolean llenarCampo(int pColumna, int pFila){
        boolean resultado;
        if (validarPosicion(pColumna, pFila) == true){
            resultado = false;
        }
        else{
            setNumJugada(getNumJugada() + 1);
            if (isTurno()){
                getTablero()[pColumna][pFila] = "x";
            }
            else{
                getTablero()[pColumna][pFila] = "o";
            }
            
            resultado = true;
        }
        return resultado;
    }
    
    /**
    * Este método valida si un campo en la matriz está ocupado por una x o una
    * o. Si no está ocupada por alguna de estas opciones devuelve true.
    * 
    * @param pColumna columna que se quiere acceder 
    * @param pFila fila que se quiere llenar acceder
    * 
    * @return boolean falso si la posición está ocupada y true si no lo está.
    */
    public boolean validarPosicion(int pColumna, int pFila){
        boolean resultado;
        String valorPosicion = getTablero()[pColumna][pFila];
        resultado = !(!valorPosicion.equals("x") || !valorPosicion.equals("o"));
        return resultado;
    }
    
    /**
    * Este método examina cada jugada posible para ganar y la posibilidad de empate. 
    * 
    * @return int si el resultado es 0 es un gane, si es un 1 es un empate y 
    * si es un 2 no ha pasado ninguno de los dos
    */
    public int validarGane(){
        int resultado;
        
        /*
        Primera columna
        */
        if (getTablero()[0][0].equals(getTablero()[1][0]) && 
                getTablero()[0][0].equals(getTablero()[2][0])){
            resultado = 0;
        }
        /*
        Segunda columna
        */
        else if (getTablero()[0][1].equals(getTablero()[1][1]) && 
                getTablero()[0][1].equals(getTablero()[2][1])){
            resultado = 0;
        }
        /*
        Tercera columna
        */
        else if (getTablero()[0][2].equals(getTablero()[1][2]) && 
                getTablero()[0][2].equals(getTablero()[2][2])){
            resultado = 0;
        }
        /*
        Diagonal principal
        */
        else if (getTablero()[0][0].equals(getTablero()[2][2]) && 
                getTablero()[0][0].equals(getTablero()[1][1])){
            resultado = 0;
        }
        /*
        Diagonal secundaria
        */
        else if (getTablero()[0][2].equals(getTablero()[1][1]) && 
                getTablero()[0][2].equals(getTablero()[2][0])){
            resultado = 0;
        }
        /*
        Primera fila
        */
        else if (getTablero()[0][0].equals(getTablero()[0][1]) && 
                getTablero()[0][0].equals(getTablero()[0][2])){
            resultado = 0;
        }
        /*
        Segunda fila
        */
        else if (getTablero()[1][0].equals(getTablero()[1][1]) && 
                getTablero()[1][0].equals(getTablero()[1][2])){
            resultado = 0;
        }
        /*
        Tercera fila
        */
        else if (getTablero()[2][0].equals(getTablero()[2][1]) && 
                getTablero()[2][0].equals(getTablero()[2][2])){
            resultado = 0;
        }
        else{
            /*
            Empate
            */
            if (getNumJugada() == 9){
                resultado = 1;
            }
            /*
            Continua el juego
            */
            else{
                resultado = 2;
            }
        }   
        
        return resultado;
    }
    
    /**
    * Este método cambia el turno. Depende del turno que se esté jugando.
    * Se llama cada vez que se haga una jugada válida
    * 
    */
    public void establecerTurno(){
        if(isTurno()){
            setTurno(false);
        }
        else{
            setTurno(true);
        }
    }
    
    /**
    * Este método resetea el juego. Una vez terminado el juego se llama
    * a este método. Establece el primer turno, el número de jugadas e iniciar
    * el tablero del gato.
    * 
    */
    public void resetearJuego(){
        this.turno = true;
        this.numeroJugada = 0;
        iniciaMatrizGato();
    }
}

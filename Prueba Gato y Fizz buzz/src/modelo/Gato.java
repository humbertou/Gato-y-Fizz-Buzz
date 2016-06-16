package modelo;

/**
 *
 * @author Humberto
 */
public final class Gato {
    //private final String jugador1;
    //private final String jugador2;
    private final String[][] tablero;
    private boolean turno;
    private int numJugada;
    
    public Gato (){
       // this.jugador1 = pJugador1;
       // this.jugador2 = pJugador2;
        this.tablero = new String[3][3];
        this.turno = true;
        this.numJugada = 0;
        iniciarTablero();
    }

    public String[][] getTablero() {
        return tablero;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getNumJugada() {
        return numJugada;
    }

    public void setNumJugada(int numJugada) {
        this.numJugada = numJugada;
    }
    
    public void iniciarTablero(){
        int largoTablero = getTablero().length;
        int contador = 0;
        for (int contadorCol = 0; contadorCol < largoTablero; contadorCol++){
            for (int contadorFila = 0; contadorFila < largoTablero; contadorFila++){
                getTablero()[contadorCol][contadorFila] = Integer.toString(contador);
                contador++;
            }
        }
    }
    
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
        //System.out.println(Arrays.deepToString(this.tablero));
        return resultado;
    }
    
    public boolean validarPosicion(int pColumna, int pFila){
        boolean resultado;
        String valorPosicion = getTablero()[pColumna][pFila];
        //resultado = !valorPosicion.equals("");
        resultado = !(!valorPosicion.equals("x") || !valorPosicion.equals("o"));
        return resultado;
    }
    
    public int validarGane(){
        int resultado;
        
        if (getTablero()[0][0].equals(getTablero()[1][0]) && 
                getTablero()[0][0].equals(getTablero()[2][0])){
            resultado = 0;
        }
        else if (getTablero()[0][1].equals(getTablero()[1][1]) && 
                getTablero()[0][1].equals(getTablero()[2][1])){
            resultado = 0;
        }
        else if (getTablero()[0][2].equals(getTablero()[1][2]) && 
                getTablero()[0][2].equals(getTablero()[2][2])){
            resultado = 0;
        }
        else if (getTablero()[0][0].equals(getTablero()[2][2]) && 
                getTablero()[0][0].equals(getTablero()[1][1])){
            resultado = 0;
        }
        else if (getTablero()[0][2].equals(getTablero()[1][1]) && 
                getTablero()[0][2].equals(getTablero()[2][0])){
            resultado = 0;
        }
        else if (getTablero()[0][0].equals(getTablero()[0][1]) && 
                getTablero()[0][2].equals(getTablero()[0][2])){
            resultado = 0;
        }
        else if (getTablero()[1][0].equals(getTablero()[1][1]) && 
                getTablero()[1][0].equals(getTablero()[1][2])){
            resultado = 0;
        }
        else if (getTablero()[2][0].equals(getTablero()[2][1]) && 
                getTablero()[2][0].equals(getTablero()[2][2])){
            resultado = 0;
        }
        else{
            if (getNumJugada() == 9){
                resultado = 1;
            }
            else{
                resultado = 2;
            }
        }   
        System.out.println(resultado);
        return resultado;
    }
    
    public int establecerGanador(){
        int resultado;
        if (validarGane() == 0){
            resultado = 0;
        }
        else if (validarGane() == 1){
            resultado = 1;
        }
        else {
            resultado = 2;
        }
        return resultado;
        
    }
    
    public void establecerTurno(){
        if(isTurno()){
            setTurno(false);
        }
        else{
            setTurno(true);
        }
    }
}

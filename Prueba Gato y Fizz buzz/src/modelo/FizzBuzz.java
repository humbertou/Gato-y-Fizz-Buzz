package modelo;

/**
 * Esta clase es la encargada de establecer la lógica del fizz buzz
 * Tiene como atributos la matriz, el turno y el contador de jugadas. 
 * 
 * @version 15 de junio 2016 
 * @author Humberto
 */
public class FizzBuzz {
    /*
    Constructor
    */
    public FizzBuzz(){
    
    }
    
     /**
    * Este método devuelve fizz si es múltiplo de 3, buzz si es múltiplo de 5,
    * Fizzbuzz si es múltiplo de ambos (de 15) y el número si no coin. 
    *
    * @param pNumero un número para saber si es múltiplo de 3, 5 o ambos
    * 
    * @return String es el resultado luego de haber pasado por las condiciones
    */
    public String crearNumeroFizzBuzz(int pNumero){
        String resultado;
        if ((pNumero % 3) == 0 && (pNumero % 5) == 0){
            resultado = "FizzBuzz";
        }
        else if ((pNumero % 3) == 0){
            resultado = "Fizz";
        }
        else if ((pNumero % 5) == 0){
            resultado = "Buzz";
        }
        else{
            resultado = Integer.toString(pNumero);
        }
        
        return resultado;
    }
    
     /**
    * Este método crea una lista de strings con los números del 1 al 100 
    * del FizzBuzz
    *
    * @return String[] devuelve un arreglo de strings con una lista de números
    * del 1 al 100 tomando en cuenta la regla de fizzBuzz
    */
    public String[] enlistarNumero (){
        String[] arregloNumeros = new String[100];
        int limiteCiclo = 100;
        for (int contador = 1; contador < limiteCiclo; contador++){
            arregloNumeros[contador] = crearNumeroFizzBuzz(contador);
        }
        return arregloNumeros;
    }
    
}


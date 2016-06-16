package controlador;

/**
 * Esta clase es la controla la lógica del Fizz Buzz y la interfaz de este.
 * Llama a los métodos de la clase FizzBuzz, para que puedan ser utilizados en 
 * la interfaz, sin que esta "se de cuenta" que existe una lógica.
 * 
 * @version 15 de junio 2016 
 * @author Humberto
 */

import modelo.FizzBuzz;

public class ControladorFizzBuzz {
    private final FizzBuzz fizzbuzz;
    
    public ControladorFizzBuzz(){
       this.fizzbuzz = new FizzBuzz();
    }
    
    public String[] listarNumeros(){
        return fizzbuzz.enlistarNumero();
    }
    
}

package modelo;

/**
 *
 * @author Humberto
 */
public class FizzBuzz {
    /*
    Constructor
    */
    public FizzBuzz(){
    
    }
    
    public void crearNumeroFizzBuzz(int pNumero){
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
        
        System.out.println(resultado);
        //return resultado;
    }
    
    public void enlistarNumero (){
        int limiteCiclo = 100;
        for (int contador = 1; contador < limiteCiclo; contador++){
            crearNumeroFizzBuzz(contador);
        }
    }
    
}



public class Poupança extends ContaBancario
{
   public Poupança(String numero){

        setNumeroConta(numero);
    }
    
    public void rendimento(){
        
        double juros = getSaldo() * 0.01;
        depositar(juros);
    }

}

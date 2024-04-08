
public class ContaEspecial extends ContaBancario
{
    private double limite;
    
    public ContaEspecial(String numero, double limite){
        this.limite = limite;
        setNumeroConta(numero);
    }
        
    @Override    
    public boolean temSaldo(double valor){
        return valor > 0 && valor <= (getSaldo()+limite);
    }
    /*
    @Override
    public void sacar(double valor){
         if (temSaldo(valor)){
             //super.sacar(valor);
             saldo -= valor; 
         }
    }*/
    
    public double getLimite(){
        return limite;
    }

}

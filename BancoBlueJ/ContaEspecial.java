
public class ContaEspecial extends ContaBancario
{
    private double limite;
    
    public ContaEspecial(String numero , double limite){
        this.limite = limite;
        setNumeroConta(numero);
    }
    
    @Override
    public void sacar(double valor){
        
        if(valor > 0 && valor <= (getSaldo() + valor)){
            saldo -= valor;
        }
    }
    
    public double getLimite(){
        return limite;
    }
}

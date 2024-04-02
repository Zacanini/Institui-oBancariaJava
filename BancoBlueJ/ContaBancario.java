
public class ContaBancario
{
    private Cliente correntista;
    protected double saldo;
    private String numeroConta;
    private Banco banco;
    
    
    public ContaBancario(){
        
    }
    public ContaBancario(String numeroConta){
        this.numeroConta = numeroConta;
    }
    
      
    public void sacar(double valor){
        if (valor >= 0 && valor <= saldo){
         this.saldo -= valor;
        }
    }
    
    public void depositar(double valor){
        if (valor >= 0){
         this.saldo += valor;
        }
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    
    public void setNumeroConta(String numeroConta){
        this.numeroConta = numeroConta;
    }
    
    public String getNumeroConta(){
        return numeroConta;
    }
    
    public void setCorrentista(Cliente correntista){
        this.correntista = correntista;
    }
    
    public Cliente getCorrentista(){
        return correntista;
    }
    
    public void setBanco(Banco banco){
        this.banco = banco;
    }
    
    public Banco getBanco(){
        return banco;
    }
}

    
   
    
    
    

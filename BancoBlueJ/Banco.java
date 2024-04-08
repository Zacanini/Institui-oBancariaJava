
import java.util.ArrayList;


public class Banco
{
    private String nome, sigla;
    private Gerente gerente;
    private ArrayList<Bancario> bancarios;
    //private Endereco endereco;
    private ArrayList<ContaBancario> contas;
    
    public Banco(){
        bancarios = new ArrayList<>();
        contas = new ArrayList<>();
    }    
    
    public ContaBancario buscaConta(String num){
        for(ContaBancario cb : getContas()){
            if (cb.getNumeroConta().equals(num)){
                return cb;
            }
        }
        return null;
    }
    
    public void addConta(ContaBancario conta){
        contas.add(conta);
    }
    public ArrayList<ContaBancario> getContas(){
        return contas;
    }
    
    public void addBancario(Bancario bancario){
        bancarios.add(bancario);
    }
    public ArrayList<Bancario> getBancarios(){
        return bancarios;
    }
    
    public void setGerente(Gerente gerente){
        this.gerente = gerente;
    }
    public Gerente getGerente(){
        return this.gerente;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    public void setSigla(String sigla){
        this.sigla = sigla;
    }
    public String getSigla(){
        return this.sigla;
    }    
}


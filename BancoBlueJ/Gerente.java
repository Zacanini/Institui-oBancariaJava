import java.util.Date;


public class Gerente extends FuncionarioBanco
{
    //private String nome;
    private Date dataNascimento;
    
    public Gerente(){
        
    }
    public Gerente(String nome){
        //this.nome = nome;
        dataNascimento = new Date();
    }
    
    
    public void setDataNascimento(Date dataNascimento){
      this.dataNascimento = dataNascimento;
    } 
    public Date getDataNascimento(){
      return this.dataNascimento;
    }
}

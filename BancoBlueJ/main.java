
public class main
{
  public static void main(String args[]){
      ContaBancario cb;
      cb = new Poupança("123");
      System.out.println("deseja criar conta (b)ancaria , (e)special ou (p)oupança?");
      String esc = "p";
      
      if(esc.equals("b" )){
          cb = new ContaBancario("123");
      }else if (esc.equals("e")){
          cb = new ContaEspecial("123" , 1000);
      }else{
          cb = new Poupança("123");
      }
      
      cb.depositar(500);
      
      
    
 }
}

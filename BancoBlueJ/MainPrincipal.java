
import java.util.Scanner;

public class MainPrincipal
{
    public static Scanner leGlobal = new Scanner(System.in);
    
    
    
    public static void main(String args[]){

        Scanner le = new Scanner(System.in);
                
        Banco bco = cadastrarBanco();          
        //System.out.println("Login do "+bco.getSigla()+"?");
        Bancario func = cadastrarBancario( le );
        
        if(!verificaLogin()){
            System.out.println("Loguin incorreto");
            System.exit(-1);
        }
         
        System.out.println("########## BB Systems Corporations #########");
        bco.addBancario( func );
        
        while(true){
        
            int menu = Menu() ;
            
            if (menu == 6){
                System.out.println("Ate Mais!!!");
                break;
            }else if(menu == 1){
                bco.addConta(cadastrarConta(bco));
            }
        
        }
    }
    
    public static ContaBancario cadastrarConta(Banco bco){
        Scanner le = new Scanner(System.in);
        System.out.println("### Tipo de conta? (C)onta , Conta (E)special ou (P)oupança:");
        String tipo = le.next();
        ContaBancario conta = new ContaBancario();
        if(tipo.equals("E")){
            conta = new ContaEspecial("",2000);
        }else if(tipo.equals("P")){
            conta = new Poupança("");
        }
        System.out.println("Numero da conta.");
        conta.setNumeroConta(le.nextLine() );
        conta.setBanco(bco);
        conta.setCorrentista( cadastrarCliente() );
        
        return conta;
        
    }
    
    public static Cliente cadastrarCliente(){
        Scanner le = new Scanner(System.in);
        System.out.println("#nome do Cliente:");
        Cliente cli = new Cliente(le.nextLine());
        
        
        return cli;
    }
    
    public static int Menu(){
        System.out.println("### MENU PRINCIPAL");
            System.out.println("## 1) Abrir Conta");
            System.out.println("## 2) Consultar Conta");
            System.out.println("## 3) Consultar Cliente");
            System.out.println("## 4) Realizar Operaçoes");        
            System.out.println("## 5) Relatorio Financeiro");                
            System.out.println("###########################");
            System.out.println("## 6) Sair");
            return leGlobal.nextInt();
    }
    
    public static boolean verificaLogin(){
        System.out.print("Login?");
        String login = leGlobal.next();
        System.out.print("Senha?");
        String senha = leGlobal.next();
        if (!(login.equals("func") && senha.equals("123"))){
            return false;
        }else{
            return true;
        }
    }
    
    public static Bancario cadastrarBancario( Scanner le ){
        System.out.println("Nome do Funcionario?");
        Bancario func = new Bancario( le.nextLine() );
        return func;
    }
    
    public static Banco cadastrarBanco(){
        Scanner le = new Scanner(System.in);
        Banco bco = new Banco();
        bco.setNome("Banco do Brasil");
        bco.setSigla("BB");
        System.out.println("Nome do Gerente do "+bco.getSigla()+"?");        
        bco.setGerente( new Gerente( le.nextLine() ) );
        
        return bco;
        
        // Gerente ger = new Gerente( le.nextLine() );        
        // bco.setGerente( ger ); 
    }
    
}


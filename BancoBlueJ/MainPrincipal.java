
import java.util.Scanner;

public class MainPrincipal
{
    public static Scanner leGlobal = new Scanner(System.in);
       
    
    public static void main(String args[]){

        Scanner le = new Scanner(System.in);
                        
        Banco bco = cadastrarBanco();   
        
        inicializarBanco(bco);
        
        //System.out.println("Login do "+bco.getSigla()+"?");
        Bancario func = cadastrarBancario( le );
        
        if (!verificaLogin()){
           System.out.println("Login Incorreto!!!");
            System.exit(-1); 
        }
        System.out.println("########## BB Systems Corporations #########");
        bco.addBancario( func );
                
        while(true){
            
            int menu = Menu();
            
            if (menu == 6){
                System.out.println("Ate Mais!!!");
                break;
            }else if ( menu ==1){
               bco.addConta( cadastrarConta(bco) );
            }else if (menu == 2){                
                consultarConta( bco );
            }else if (menu == 4){                
                realizarOperacao( bco );
            }
        }        
        
    }
    
    public static void inicializarBanco(Banco bco){
        
        ContaBancario c1 = new ContaBancario("123");
        c1.depositar(1500);
        c1.setCorrentista( new Cliente("Zezin") );  
        c1.setBanco(bco);
        bco.addConta( c1 );
        
        ContaBancario c2 = new Poupança("456");
        c2.depositar(100);
        c2.setCorrentista( new Cliente("Gustin") );        
        c2.setBanco(bco);
        bco.addConta( c2 );
        
        ContaBancario c3 = new ContaEspecial("789",1000);
        c3.depositar(5000);
        c3.setCorrentista( new Cliente("Mariazinha") );        
        c3.setBanco(bco);
        bco.addConta( c3 );
        
    }
    
    public static void realizarOperacao(Banco bco){
        System.out.println("############################");
        System.out.println("### OPERACAO");
        System.out.println("############################");
        System.out.println("##Contas Disponveis");
        for(ContaBancario cb : bco.getContas()){
           System.out.println( "### "+cb.getNumeroConta() ); 
        }
        System.out.println("# Informe a conta?");
        String numConta = leGlobal.next();
        
        ContaBancario cb = bco.buscaConta(numConta);
        if (cb == null){
            System.out.println("## Conta "+numConta+" no encontrada!!!"); 
            return;
        }
        System.out.println("# (D)eposito ou (S)aque?");
        String op = leGlobal.next();
        if (op.equals("D")){
           System.out.println("# Valor do Deposito");
           cb.depositar( leGlobal.nextDouble() );
           System.out.println("# Deposito realizado com sucesso!!!");
        }else if (op.equals("S")){
           System.out.println("# Valor do Saque");
           double valor = leGlobal.nextDouble();
           if ( cb.temSaldo(valor) ){
             cb.sacar( valor );
             System.out.println("# Saque realizado com sucesso!!!");  
           }
        }
    }
    
    public static void consultarConta(Banco bco){
        System.out.println("############################");
        System.out.println("### CONSULTA CONTA");
        System.out.println("############################");
        System.out.println("# Informe a conta a ser pesquisada?");
        String numConta = leGlobal.next();
        
        ContaBancario cb = bco.buscaConta(numConta);
        if (cb != null){        
            System.out.println("############################");
            System.out.println("## Numero :: "+cb.getNumeroConta() );
            System.out.println("## correntista :: "+cb.getCorrentista().getNome() );
            System.out.println("## Saldo :: "+cb.getSaldo() );   
            System.out.println("## Banco :: "+cb.getBanco().getNome() ); 
        }else{
           System.out.println("## Conta "+numConta+" no encontrada!!!"); 
        }
                
    }
    
    public static ContaBancario cadastrarConta(Banco bco){
        Scanner le = new Scanner(System.in);
        System.out.println("### Tipo de Conta? (C)onta, Conta (E)special ou (P)oupanca.");
        String tipo = le.next();
        ContaBancario conta = new ContaBancario();
        if (tipo.equals("E")){
            conta  = new ContaEspecial("", 2000);
        }else if (tipo.equals("P")){
            conta = new Poupança("");
        }
        System.out.println("#numero da conta.");
        le.nextLine(); 
        conta.setNumeroConta( le.nextLine() );
        conta.setBanco( bco );
        conta.setCorrentista( cadastrarCliente() );
        
        return conta;        
    }
    
    public static Cliente cadastrarCliente(){
        Scanner le = new Scanner(System.in);
        System.out.println("#nome do Cliente:");
        Cliente cli = new Cliente( le.nextLine() );
        
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
    
    public static void ConsultaCliente(){
        
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




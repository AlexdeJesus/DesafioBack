package br.com.desafioback.main;
import br.com.desafioback.bens.Customer;
import br.com.desafioback.jdbc.Conexao;
import br.com.desafioback.jdbc.CustomerDao;
import java.util.List;
/**
 * @author Alex Souza
 */
public class Main {
    public static void main(String[] args) {
        //conexao();
        //cadastrar();
        listar();
        
      
    }
    public static void conexao(){
        Conexao.getConnection();
    }
    
    public static void cadastrar(){
    Customer customer = new Customer();
    customer.setId(1507);
    customer.setCpf("333.444.555.10");
    customer.setNome("Joao Pedro");
    customer.setAtivo(true);
    customer.setValorTotal(709);
    
    CustomerDao customerdao= new CustomerDao();
    customerdao.cadastrar(customer);
    }
    
    public static void listar(){
        int i=0;
        float media=0;
        Customer customer = new Customer();
        CustomerDao customerdao = new CustomerDao();
        List<Customer>lista= customerdao.listar(customer);

        for (Customer c:lista){
            System.out.println("Id: "+c.getId());
            System.out.println("CPF: "+c.getCpf());
            System.out.println("Nome: "+c.getNome());
            System.out.println("Ativo: "+c.getAtivo());
            System.out.println("Valor: "+c.getValorTotal());
            System.out.println("==============================");
            i++;
            media=(float) (media+c.getValorTotal());
        }
        media=media/i;
        System.out.println("Média do saldo dos registros: "+media);
    }
}
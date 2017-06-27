package br.com.desafioback.jdbc;
import br.com.desafioback.bens.Customer;
import java.util.List;

/**
 * @author Alex Souza
 */
public interface ICustomerDao {    
    public  void cadastrar(Customer customer);
    public List <Customer>listar(Customer customer);
    
    
}

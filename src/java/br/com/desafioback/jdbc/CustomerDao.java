package br.com.desafioback.jdbc;

import br.com.desafioback.bens.Customer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Alex Souza
 */
public class CustomerDao implements ICustomerDao {

    private Connection conn = Conexao.getConnection();
    
    @Override
    public void cadastrar(Customer customer){
        try {
        String sql = "Insert into tb_customer_account (id, cpf, nome, ativo, valorTotal)"
                + "values(?,?,?,?,?)";
        
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
        ps.setInt(1, customer.getId());
        ps.setString(2, customer.getCpf());
        ps.setString(3, customer.getNome());
        ps.setBoolean(4, customer.getAtivo());
        ps.setDouble(5, customer.getValorTotal());
        
        ps.executeUpdate();
        ps.close();
        JOptionPane.showMessageDialog(null, "Cliente Cadastrado Com Sucesso! ");
        
        
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao inserir os dados");
        }
    }
    
   // @Override
    public List<Customer> listar(Customer customer) {
              
            String sql = "SELECT * FROM tb_customer_account where id >= 1500 and id <= 2700 and  valorTotal > 560 order by valorTotal desc";
            List <Customer>lista = new ArrayList<Customer>();
            
        try {            
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                Customer c = new Customer();
                c.setId(result.getInt("id"));
                c.setCpf(result.getString("cpf"));
                c.setNome(result.getString("nome"));
                c.setAtivo(result.getBoolean("ativo"));
                c.setValorTotal(result.getDouble("valorTotal"));
            
                lista.add(c);
            }
            ps.close();
            result.close();            
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar os dados! ");
        }
    }       
}

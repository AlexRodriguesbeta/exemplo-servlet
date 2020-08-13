package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import util.ConexaoBanco;

public class ClienteDao {
    private Connection con;
    public static void cadastrar(Cliente cliente) throws SQLException {
        
        Connection conexao = ConexaoBanco.getConexao();

        String query = "INSERT INTO tbcliente (nome, endereco, cpf, data_nascimento) VALUES (?,?,?,?)";
    
        PreparedStatement ps = conexao.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEndereco());
        ps.setString(3, cliente.getCpf());
        ps.setString(4, cliente.getDataNascimento());
       
        ps.execute();
        ps.close();
        conexao.close();
    }
     
    public List<Cliente> pesquisar() throws SQLException, Exception {
        
        List<Cliente> lista = new ArrayList();
        String query = "SELECT * FROM tbcliente";
        
        PreparedStatement st = con.prepareStatement(query);
    
        ResultSet rs = st.executeQuery();
         
        while(rs.next()) {            
            Cliente cli = new Cliente();
            
            cli.setIdCliente      ( rs.getInt   ("idCliente")     );
            cli.setNome           ( rs.getString("nome")          );
            cli.setEndereco       ( rs.getString("endereco")      );
            cli.setCpf            ( rs.getString("cpf")           );
            cli.setDataNascimento (rs.getString ("data_nascimento"));

            lista.add(cli);            
        }   
        return lista;
    }


    public Cliente pesquisarPorId(int id) throws SQLException {

        Connection con = new ConexaoBanco().getConnection();
        
        Cliente cli = new Cliente();
        String query = "SELECT * FROM tbcliente WHERE idCliente=?";
        
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        
        ResultSet rs = st.executeQuery();
        
        if (rs.next()) {            
            cli.setIdCliente   ( rs.getInt   ("idCLiente")  );
            cli.setNome ( rs.getString("nome")  );
            cli.setEndereco   ( rs.getString("endereco")  );
            cli.setCpf ( rs.getString   ("cpf") );
            cli.setDataNascimento ( rs.getString   ("data_nascimento") );          
        }   
        return cli;
    }

}
    

    

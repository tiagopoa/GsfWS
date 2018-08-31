package entidade.dao;

import entidade.Officer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lhries
 */
public class OfficerDaoBd implements OfficerDao {

    @Override
    public void inserir(Officer m) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "INSERT INTO officer(name,cellphone,email,address) VALUES (?,?,?,?)";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, m.getName());
            comando.setString(2, m.getCellphone());
            comando.setString(3, m.getEmail());
            comando.setString(4, m.getAddress());
            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(OfficerDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deletar(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "DELETE FROM officer WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(OfficerDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(int codigo,Officer m) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
            System.out.println(codigo + " " + m.getName()+ " " + m.getCellphone() + " " + m.getEmail() + " " + m.getAddress());

            String sql = "UPDATE officer SET name=?, "
                    + "cellphone=?, email=?, address=? "
                    + "WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, m.getName());
            comando.setString(2, m.getCellphone());
            comando.setString(3, m.getEmail());
            comando.setString(4, m.getAddress());
            comando.setInt(5, m.getCodigo());
                       
            
            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(OfficerDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Officer> listar() {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM officer";

            List<Officer> listaOfficers = new ArrayList<>();

            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                String name = resultado.getString("name");                
                String cellphone = resultado.getString("cellphone");
                String email = resultado.getString("email");
                String address = resultado.getString("address");                
                Officer m = new Officer(codigo, name, cellphone, email, address);
                listaOfficers.add(m);

            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return listaOfficers;

        } catch (SQLException ex) {
            Logger.getLogger(OfficerDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Officer buscarPorId(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM officer WHERE codigo=?";

            Officer officer = null;

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("codigo");
                String name = resultado.getString("name");                
                String cellphone = resultado.getString("cellphone");
                String email = resultado.getString("email");
                String address = resultado.getString("address");                
                officer = new Officer(codigo, name, cellphone, email, address);
            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return officer;

        } catch (SQLException ex) {
            Logger.getLogger(OfficerDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }




 
//    @Override
//    public Cliente buscarPorId(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

  


}

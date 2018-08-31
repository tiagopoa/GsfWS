package entidade.dao;

import entidade.Shot;
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
public class ShotDaoBd implements ShotDao {

    @Override
    public void inserir(Shot m) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "INSERT INTO shot(latitude,longitude,address,neighbourhood,city,officerid) VALUES (?,?,?,?,?,?)";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, m.getLatitude());
            comando.setString(2, m.getLongitude());
            comando.setString(3, m.getAddress());
            comando.setString(4, m.getNeighbourhood());
            comando.setString(5, m.getCity());
            comando.setString(6, m.getOfficerid());

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ShotDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deletar(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "DELETE FROM shot WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ShotDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(int codigo,Shot m) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
            System.out.println(codigo + " " + m.getLatitude() + " " + m.getLongitude() + " " + m.getAddress() + " " + m.getCity() + " " + m.getNeighbourhood() + " " + m.getOfficerid());

            String sql = "UPDATE shot SET latitude=?, "
                    + "longitude=?, address=?, neighbourhood=?, city=?, officerid=? "
                    + "WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, m.getLatitude());
            comando.setString(2, m.getLongitude());
            comando.setString(3, m.getAddress());
            comando.setString(4, m.getNeighbourhood());
            comando.setString(5, m.getCity());
            comando.setString(6, m.getOfficerid());
            comando.setInt(7, m.getCodigo());
                       
            
            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ShotDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Shot> listar() {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM shot";

            List<Shot> listaShots = new ArrayList<>();

            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                String latitude = resultado.getString("latitude");                
                String longitude = resultado.getString("longitude");
                String address = resultado.getString("address");
                String neighbourhood = resultado.getString("neighbourhood");
                String city = resultado.getString("city");
                String officerid = resultado.getString("officerid");
                Shot m = new Shot(codigo, latitude, longitude, address, neighbourhood, city, officerid);
                listaShots.add(m);

            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return listaShots;

        } catch (SQLException ex) {
            Logger.getLogger(ShotDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Shot buscarPorId(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM shot WHERE codigo=?";

            Shot shot = null;

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("codigo");
                String latitude = resultado.getString("latitude");                
                String longitude = resultado.getString("longitude");
                String address = resultado.getString("address");
                String neighbourhood = resultado.getString("neighbourhood");
                String city = resultado.getString("city");
                String officerid = resultado.getString("officerid");
                shot = new Shot(codigo, latitude, longitude, address, neighbourhood, city, officerid);
            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return shot;

        } catch (SQLException ex) {
            Logger.getLogger(ShotDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }




 
//    @Override
//    public Cliente buscarPorId(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

  


}

package entidade.dao;

import entidade.Officer;
import java.util.List;

public interface OfficerDao {
    public void inserir(Officer m);
    public void deletar(int codigo);
    public void atualizar(int codigo,Officer m);
    public List<Officer> listar();
    public Officer buscarPorId(int codigo);
    
    //public List<Motor> listarPorNome(String nome);
    //public List<Motor> listarPorUso(String uso);
    
}

package entidade.dao;

import entidade.Shot;
import java.util.List;

public interface ShotDao {
    public void inserir(Shot m);
    public void deletar(int codigo);
    public void atualizar(int codigo,Shot m);
    public List<Shot> listar();
    public Shot buscarPorId(int codigo);
    
    //public List<Motor> listarPorNome(String nome);
    //public List<Motor> listarPorUso(String uso);
    
}

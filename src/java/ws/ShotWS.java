package ws;

import entidade.Shot;
import entidade.dao.ShotDaoBd;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/shots")
public class ShotWS {

    @Context
    private UriInfo context;
    static List<Shot> listaShots = new ArrayList<>();
    
    private ShotDaoBd shotDao;
    private int codigo;
    /**
     * Creates a new instance of ShotWS
     */
    public ShotWS() {
        shotDao = new ShotDaoBd();
    }

    /**
     * Retrieves representation of an instance of ws.ShotWS
     * @return an instance of entidade.Shot
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shot> getShot() {
        return shotDao.listar();        
    }

    /**
     * PUT method for updating or creating an instance of ShotWS
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserirShot(Shot shot) {
        shotDao.inserir(shot);
    }
    
    @PUT
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarShot(@PathParam("codigo") int codigo, Shot shot) {
        shot.setCodigo(codigo);
        shotDao.atualizar(codigo,shot);
    }
    
    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removerShot(@PathParam("codigo") int codigo) { 
        shotDao.deletar(codigo);
    }
    
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Shot buscarPorCodigo(@PathParam("codigo") int codigo) {
        return shotDao.buscarPorId(codigo);
    }
    
}

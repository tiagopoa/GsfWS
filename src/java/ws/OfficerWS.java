package ws;

import entidade.Officer;
import entidade.dao.OfficerDaoBd;
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

@Path("/officers")
public class OfficerWS {

    @Context
    private UriInfo context;
    static List<Officer> listaOfficers = new ArrayList<>();
    
    private OfficerDaoBd officerDao;
    private int codigo;
    /**
     * Creates a new instance of OfficerWS
     */
    public OfficerWS() {
        officerDao = new OfficerDaoBd();
    }

    /**
     * Retrieves representation of an instance of ws.OfficerWS
     * @return an instance of entidade.Officer
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Officer> getOfficer() {
        return officerDao.listar();        
    }

    /**
     * PUT method for updating or creating an instance of OfficerWS
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserirOfficer(Officer officer) {
        officerDao.inserir(officer);
    }
    
    @PUT
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarOfficer(@PathParam("codigo") int codigo, Officer officer) {
        officer.setCodigo(codigo);
        officerDao.atualizar(codigo,officer);
    }
    
    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removerOfficer(@PathParam("codigo") int codigo) { 
        officerDao.deletar(codigo);
    }
    
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Officer buscarPorCodigo(@PathParam("codigo") int codigo) {
        return officerDao.buscarPorId(codigo);
    }
    
}

package br.com.inatel.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/entrega")
public class EntregaJersey {
	
	/*@GET
	@Path("/test2")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public String getTeste2( ) {
		String test = "hello world!";
		
		return test;
	}
	
	@GET
	@Path("/test")
	@Produces({MediaType.TEXT_HTML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getTeste( ) {
		String test = "hello world!";
		GenericEntity<String> entity = new GenericEntity<String>(test) {};
		
		return Response.status(Status.OK).entity(entity).build();
	}
	@GET
	@Path("/teste/{test}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getTeste(@PathParam("test") String test) {
		
		GenericEntity<String> entity = new GenericEntity<String>(test) {};
		
		return Response.status(Status.OK).entity(entity).build();
	}*/
	@GET
	@Path("{nPedido}")
	@Produces({MediaType.TEXT_HTML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getnPedido(@PathParam("nPedido") Long nPedido) {
		EntregaEntity item = new EntregaEntity();
		try {
			
		
			EntregaDAO dao = new EntregaDAO();
			item = dao.getEntregaByNPedido(nPedido);
			if(item.getnPedido() == null) {
				AlertaEntity pacote = new AlertaEntity("O recurso de número de pedido "+nPedido.toString()+" solicitado não existe!");
				GenericEntity<AlertaEntity> str  = new GenericEntity<AlertaEntity>(pacote) {}; 
				return Response.status(Status.NOT_FOUND).entity(str).build();
			}
			GenericEntity<EntregaEntity> entity = new GenericEntity<EntregaEntity>(item) {};
		
			return Response.status(Status.OK).entity(entity).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	
	@POST
	@Produces({MediaType.TEXT_HTML,MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response create( EntregaEntity entrega){
		try {
			if(entrega.getnPedido() == null || entrega.getIdCliente() == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			EntregaDAO dao = new EntregaDAO();
			dao.createEntrega(entrega);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	 }
	
}

package org.acme.resource;

import org.acme.model.BeneficioSocial;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import jakarta.ws.rs.PathParam; // Para @PathParam
import jakarta.ws.rs.core.Response; // Para Response

@Path("/beneficios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BeneficioSocialResource {

    @GET
    public List<BeneficioSocial> listarTodos() {
        return BeneficioSocial.listAll();
    }

    @GET
    @Path("/municipio/{municipio}")
    public List<BeneficioSocial> buscarPorMunicipio(@PathParam("municipio") String municipio) {
        return BeneficioSocial.findByMunicipio(municipio);
    }

    @GET
    @Path("/nome/{nome}")
    public List<BeneficioSocial> buscarPorNome(@PathParam("nome") String nome) {
        return BeneficioSocial.list("nome LIKE ?1", "%" + nome + "%");
    }

    @POST
    @Transactional
    public Response criar(BeneficioSocial beneficio) {
        beneficio.persist();
        return Response.status(Response.Status.CREATED).entity(beneficio).build();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

/**
 *
 * @author hp
 */

@Path("test") // this path is used to identify class
public class test {
    
    @GET
    @Path("/getdata") // this path is used to identify method
    @Produces(MediaType.APPLICATION_JSON)
    public String getDatainJSON(){
        return "Test";
    }
    
}

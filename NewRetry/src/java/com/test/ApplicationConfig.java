/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author hp
 */
@javax.ws.rs.ApplicationPath("test-api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        
        resources.add(Controllers.LoginController.class);
        resources.add(Controllers.StudentController.class);
        resources.add(com.test.MypathResource.class);
        resources.add(com.test.test.class);
       
         
    }
    
}

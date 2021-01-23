/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class Student implements Serializable{
    private int matriks;
    private String name, ic;
    private int age;

    public Student() {
    }
    
    
    
    public int getMatriks() {
        return matriks;
    }

    public void setMatriks(int matriks) {
        this.matriks = matriks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    
}

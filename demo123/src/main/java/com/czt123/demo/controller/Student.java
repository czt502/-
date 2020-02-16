package com.czt123.demo.controller;


public class Student {

    public String username;

    public Student(String username){

        this.username=username;

    }

    @Override
    public String toString() {

        return username;

    }


}

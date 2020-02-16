package com.czt123.demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;


import java.sql.*;

@Controller

public class LotteryDraw {

    @RequestMapping(value = "/lottery")

    public String lottery(Model model) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("驱动加载成功");

        Connection
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/求求了！?serverTimezone=UTC", "root", "chenshuai");

        System.out.println("连接成功");

        Statement statement = conn.createStatement();

        ResultSet result1 = statement.executeQuery("SELECT * FROM 学生信息 ORDER BY RAND() LIMIT 1");

        while (result1.next()) {

            System.out.print(result1.getInt("id") + " ");

            System.out.println(result1.getString("名字"));

            Student user=new Student(result1.getInt("id") + " " + result1.getString("名字"));

            model.addAttribute("user",user);

        }

        return null;

    }

}



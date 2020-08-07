package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
	// write your code here
        Main obj1=new Main();
        //obj1.add();
        //obj1.edit();
        obj1.Display();
    }


    static void add() throws ClassNotFoundException, SQLException{
        PreparedStatement query;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con1= DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
        Scanner key=new Scanner(System.in);
        String catDesc,catCode;
        System.out.println("Please enter the code:");
        catCode=key.nextLine();
        System.out.println("Please enter the Desc:");
        catDesc=key.nextLine();
        query=con1.prepareStatement("INSERT INTO category values(?,?)");
        query.setString(1,catCode);
        query.setString(2,catDesc);
        query.executeUpdate();
        System.out.println("One record added");
    }

    static  void Display() throws ClassNotFoundException,SQLException{
        PreparedStatement query;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con1=DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
        query=con1.prepareStatement("SELECT FROM category");
        ResultSet rs=query.executeQuery();

        if(!rs.isBeforeFirst()){
            System.out.println("No records");
        }
        while (rs.next()){
            System.out.println(rs.getString("catCode"));
            System.out.println(rs.getString("catDesc"));
        }

    }
    static void edit() throws ClassNotFoundException, SQLException{
        PreparedStatement query;
       Class.forName("com.mysql.jdbc.Driver");
        Connection con1= DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
        Scanner key=new Scanner(System.in);
        String catDesc,catCode;
        System.out.println("Please enter the code:");
        catCode=key.nextLine();
        System.out.println("Please enter the Desc:");
        catDesc=key.nextLine();
        query=con1.prepareStatement("UPDATE category SET catDesc=? WHERE catCode=?");
        query.setString(1,catDesc);
        query.setString(2,catCode);
        query.executeUpdate();
        System.out.println("One record has been updated");
    }
    static void delete() throws ClassNotFoundException, SQLException{
        PreparedStatement query;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con1= DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
        Scanner key=new Scanner(System.in);
        String catDesc,catCode;
        System.out.println("Please enter the code:");
        catCode=key.nextLine();
        query=con1.prepareStatement("Delete FROM category WHERE catCode=?");
        query.setString(1,catCode);
        query.executeUpdate();
        System.out.println("Record has been deleted");
    }
}

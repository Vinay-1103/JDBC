package com.company;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class dbfunctions {
    public Connection connect_to_db(String dbname,String user,String pass){
        Connection conn=null;
        try {
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if (conn!=null){
                System.out.println("Connection Established");
            }else {
                System.out.println("Connection failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    public void createTable(Connection conn,String table_name){
        Statement stmt;
        try {
            String query="create table "+table_name+"(empid SERIAL,name varchar(200),address varchar(200),primary key(empid));";
            stmt=conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table created Sucessfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insert_row(Connection conn,String table_name,String name,String address){
        Statement stmt;
        try {
            String query=String.format("insert into %s(name,address) values('%s','%s');",table_name,name,address);
            stmt= conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void read_data(Connection conn,String table_name){
        Statement stmt;
        ResultSet rs=null;
        try {
            String query=String.format("select * from %s",table_name);
            stmt= conn.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("Address")+" ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void update_name(Connection conn,String table_name,String old_name,String new_name){
        Statement stmt;
        try {
            String query=String.format("update %s set name='%s' where name='%s'",table_name,new_name,old_name);
            stmt= conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void search_by_name(Connection conn,String table_name,String name){
        Statement stmt;
        ResultSet rs=null;
        try {
            String query=String.format("select * from %s where name= '%s'",table_name,name);
            stmt= conn.createStatement();
            rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("Address")+" ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_row_by_name(Connection conn,String table_name,String name){
        Statement stmt;
        try {
            String query=String.format("delete from %s where name='%s'",table_name,name);
            stmt= conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_table(Connection conn,String table_name){
        Statement stmt;
        try {
            String query=String.format("delete table %s",table_name);
            stmt= conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table Deleted sucessfully");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

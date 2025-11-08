package com.company;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
       dbfunctions db=new dbfunctions();
       Connection conn=db.connect_to_db("Dbtrial","postgres","Vinay@786");
//       db.createTable(conn,"employee");
//       db.insert_row(conn,"employee","vinay","ghatkesar");
        db.insert_row(conn,"employee","Vamshi","Hyderabad");
//        db.insert_row(conn,"employee","Kumar","Valigonda");
//        db.update_name(conn,"employee","Vamsh","Krishna");
//        db.search_by_name(conn,"employee","Vamshi");
        db.delete_row_by_name(conn,"employee","Vamshi");
        db.read_data(conn,"employee");
    }
}
package com.klapertart.app;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException{
        DataConnection dataConnection = new DataConnection();        
        
        Connection tConnection = dataConnection.getConnection();
        if(tConnection != null){
            ProductCrud productCrud = new ProductCrud(tConnection);
            productCrud.getAllProduct();                    
        }else{
            System.out.println("Connection failed!");
        }
        
        tConnection.close();
    }    
}

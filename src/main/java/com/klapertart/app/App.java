package com.klapertart.app;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException{
        //System.out.println( getHelloWorld() );
        
        DataConnection dataConnection = new DataConnection("jdbc:mysql://localhost:3306/inventory", "root", "");        
        
        if(dataConnection.getConnection() != null){
            ProductCrud productCrud = new ProductCrud(dataConnection);
            productCrud.getAllProduct();        
        }else{
            System.out.println("Connection failed!");
        }
        
    }    
}

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
            
            // get all product
            productCrud.getAllProduct();    
            
            // add product
            productCrud.addProduct(new Product(0, "Penghapus", 8000, 7));
            
            // update product
            productCrud.updateProduct(5, 15000);
            
            // delete product
            productCrud.deleteProduct(5);
            
            tConnection.close();
        }else{
            System.out.println("Connection failed!");
        }        
    }    
}

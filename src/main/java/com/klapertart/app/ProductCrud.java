/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klapertart.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kurakuraninja
 */
public class ProductCrud {
    DataConnection dataConnection;

    public ProductCrud(DataConnection dataConnection) {
        this.dataConnection = dataConnection;
    }
    
    public void getAllProduct(){
        Statement state;
        ResultSet result;
        
        try{
            state = dataConnection.getConnection().createStatement();
            String query = "SELECT * FROM product";
            
            result = state.executeQuery(query);
            if(result.next()){
                result.beforeFirst();
                while(result.next()){
                    Product product = new Product(result.getInt("id"),
                                            result.getString("name"),
                                            result.getDouble("price"),
                                            result.getInt("stock"));

                    System.out.println(product.toString());
                }            
            }else{
                System.out.println("Data is empty!");
            }
        }catch(SQLException e){
            e.toString();
        }
    }
}

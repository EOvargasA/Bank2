/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank2;
import java.util.*;
/**
 *
 * @author osiri
 */
public class Customer {
    //atributos
    public String name;
    //se establece transacciones como un list que se transforma a un arraylist
    List<Double> transactions = new ArrayList<>();
    
    //constructor
    public Customer (String name){
        this.name = name;
    }
    
    //metodos
    public String getName() {
        return name;
    }
    
    public void addTransaction (double transaction){
        this.transactions.add(transaction);
    }
    
    public void clearTransactions (){
        this.transactions.clear();
    }
    
    @Override
    public String toString (){
        String b = "";
        int a, c;
        c = this.transactions.size();
        for (a = 0; a < c; a++){
            if (a == 0){
                b = ""+this.transactions.get(a);
            }else{
                b = b+", "+this.transactions.get(a);
            }
        }
        return "Customer name = "+this.name+", Transactions ("+b+")";
    }
}

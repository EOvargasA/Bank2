/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank2;
import java.util.ArrayList;
/**
 *
 * @author osiri
 */
public class Branch {
    //atributos
    String name;
    ArrayList<Customer> customers = new ArrayList<Customer>();

    //constructor
    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public boolean addCustomer(String name){
        if (existance(name)){
            return false;
        }else{
            Customer a = new Customer(name);
            this.customers.add(a);
            return true;
        }
    }
    
    public boolean removeCustomer (String name){
        if (existance(name)){
            this.customers.remove(obtainPosition(name));
            return true;
        }else{
            return false;
        }
    }
    
    public boolean addTransaction (String name, double transaction){
        if (existance(name)){
            this.customers.get(obtainPosition(name)).addTransaction(transaction);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean clearTransaction (String name){
        if (existance(name)){
            this.customers.get(obtainPosition(name)).clearTransactions();
            return true;
        }else{
            return false;
        }
    }
    
    private int obtainPosition (String name){
        for(int a = 0; a < this.customers.size(); a++){
            if (this.customers.get(a).getName() == name){
                return a;
            }
        }
        return -1;
    }
    
    private boolean existance (String name){
        for(int a = 0; a < this.customers.size(); a++){
            if (this.customers.get(a).getName() == name){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString (){
        String b = "";
        for (int a = 0; a < this.customers.size(); a++){
            if (a == 0){
                b = this.customers.get(a).toString();
            }else{
                b = b+", "+this.customers.get(a).toString();
            }
        }
        return "Branch name = "+this.name+", Customers ("+b+")";
    }
}

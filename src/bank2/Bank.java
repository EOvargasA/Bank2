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
public class Bank {
    //Atributos
    private String name;
    ArrayList<Branch> branchs = new ArrayList ();

    //Constructor
    public Bank(String name) {
        this.name = name;
    }

    //Metodos
    public String getName() {
        return name;
    }
    
    public boolean addBranch (String name){
        if (existance(name)){
            return false;
        }else{
            Branch a = new Branch (name);
            this.branchs.add(a);
            return true;
        }
    }
    
    public boolean removeBranch (String name){
        if (existance(name)){
            this.branchs.remove(obtainPosition(name));
            return true;
        }else{
            return false;
        }
    }
    
     public boolean addCustomer (String BName, String CName){
        if (existance (BName)){
            return this.branchs.get(obtainPosition(BName)).addCustomer(CName);
        }else{
            return false;
        }
    }
    
    public boolean removeCustomer (String BName, String CName){
        if (existance (BName)){
            return this.branchs.get(obtainPosition(BName)).removeCustomer(CName);
        }else{
            return false;
        }
    }
    
    public boolean addTransaction (String BName, String CName, double transaction){
        if (existance (BName)){
            return this.branchs.get(obtainPosition(BName)).addTransaction(CName,transaction);
        }else{
            return false;
        }
    }
    
    public boolean clearCustomer (String BName, String CName){
        if (existance (BName)){
            return this.branchs.get(obtainPosition(BName)).clearTransaction(CName);
        }else{
            return false;
        }
    }
    
    private int obtainPosition (String name){
        for(int a = 0; a < this.branchs.size(); a++){
            if (this.branchs.get(a).getName() == name){
                return a;
            }
        }
        return -1;
    }
    
    private boolean existance (String name){
        for(int a = 0; a < this.branchs.size(); a++){
            if (this.branchs.get(a).getName() == name){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString (){
        String b = "";
        for (int a = 0; a < this.branchs.size(); a++){
            if (a == 0){
                b = this.branchs.get(a).toString();
            }else{
                b = b+", "+this.branchs.get(a).toString();
            }
        }
        return "Bank name = "+this.name+", branchs ("+b+")";
    }
}

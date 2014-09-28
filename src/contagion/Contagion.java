/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contagion;

/**
 *
 * @author Alex
 */
public class Contagion {

    
    
    public static void main(String[] args) {
        double sum = 0;
        Person initContagion = new Person();
        int patientZero = (int)(Math.random()*99999);
        initContagion.position = patientZero;
        for (int i = 0; i < 100000;i++){
            initContagion.people[i] = new Person();   
        }
        
        System.out.println("Built");
       // initContagion.people[patientZero].infect();
        initContagion.people[patientZero].infect2();
        initContagion.printResult();
        for (int i = 0; i < 100000;i++){
            if(initContagion.people[i].infected == false){
                sum = sum + 1;
            }
        
        }
        System.out.println("Total: " + sum/100000*100);
    }
    
    
    
}

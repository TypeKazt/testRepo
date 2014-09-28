/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contagion;

import java.util.*;
/**
 *
 * @author Alex
 */
public class Person {
    public static Person[] people = new Person[100000];
    public boolean infected = false;
    public static double p = .3;
    private static double TotalInfected = 0;
    public int[] friends = new int[5];
    public int friend = 0; //position in array of friend
    public static int position;//position in array
    public double rando;
    private int nonIfriends = 5; // amount of noninfected friends
    private static int[] hold = new int[100000];
    private static int holdPos = 0;
    private static int friendsInfected = 0;
    
    
    public Person(){
       
        for (int i = 0; i < 5; i++){ //chooses 5 random friends
            do{
            friend = (int)(Math.random() * 99999);
            }
            while(friend == position);
            friends[i] = friend; 
        }
        
        position++;
        
      
    }
    
    public void infect(){
        System.out.println("Patient infected");
        infected = true;
        TotalInfected++;
        //printResult();
        for (int j = 0; j < 5;j++){
            rando = (double)(Math.random()*100);
           // System.out.println(rando);
            if(people[friends[j]].infected == false){
                //add randoms into array and compare amount to amount infected
              if(rando <= p * 100 && check(friends[j]) ){
                  hold[holdPos] = friends[j];
                  holdPos++;
                   System.out.println(friends[j]);
                  people[friends[j]].infect();
                 
              }
            }
        }   
    }
    public boolean check(int n){
        for (int i:hold){
            if(i == n){
                return false;
            }
         
        }
        return true;
    }
    
    public void infect2(){
        //System.out.println("Patient infected");
        infected = true;
        //printResult();
        for (int j = 0; j < 5;j++){
           printResult();
           // System.out.println(rando);
            if(people[friends[j]].infected == true){
                //add randoms into array and compare amount to amount infected
                    nonIfriends--;
                   
                 
              }
            
            else{
                rando = (Math.random()*100);
                if(rando <= p*100 && check(friends[j])){
                    hold[holdPos] = friends[j];
                    holdPos++;
                    friendsInfected++;
                    System.out.println(friends[j]);
                    people[friends[j]].infect2();
                }
            }
                    
            }
        System.out.println("I infected " + friendsInfected + "people");
        TotalInfected += p*nonIfriends;
        }   
    
    
    
    public void printResult(){
        System.out.println("Total % infected: "+TotalInfected/100000*100 + "%");
        System.out.println(nonIfriends);
    }
    
    
}

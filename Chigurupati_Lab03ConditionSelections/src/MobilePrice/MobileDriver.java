/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MobilePrice;

import java.util.Scanner;

/**
 *
 * @author Prudhvi Chigurupati
 */
public class MobileDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Create scanner class and get input from the keyboard
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Select the provider’s name:AT&T,T-Mobile,Verizon:");
        String providerName = sc.next();
        
        System.out.print("How many number of users:");
        int numOfUsers = sc.nextInt();
        
        System.out.print("Are you a member of the Mobile Alliance:");
        boolean isMemberOfMobileAlliance = sc.nextBoolean();
  
        System.out.print("Are you a first time user:");
        char isFirstTimeUser = sc.next().charAt(0);
        
        
        System.out.print("Do you have coupon:");
        String hasCoupon = sc.next();
        
        //Calling constructor with instance variables
        int input = 0;
        ProviderCalculator object1 = new ProviderCalculator(providerName, numOfUsers, isMemberOfMobileAlliance, isFirstTimeUser, hasCoupon);
        if(!(object1.checkProviderName())){
            System.out.println("Not a valid provider’s name");
            input = 1;
        }
        if(numOfUsers == 0){
            System.out.println("The  number  of users can't be zero.");
            input = 1;
        }
        if(numOfUsers > 5){
            System.out.println("The  number  of users  should be between 3 and 5.");
            input = 1;
        }
        if(isMemberOfMobileAlliance == true && (isFirstTimeUser=='Y') && hasCoupon.equalsIgnoreCase("Yes")){
            System.out.println("User can only choose one option: a) Membership discount, b) Coupon discount, or c) First time shopper discount.");
            input = 1;
        }
        else if(isMemberOfMobileAlliance == false && isFirstTimeUser == 'Y' && hasCoupon.equalsIgnoreCase("Yes")){
            System.out.println("User can only choose one option: a) Membership discount, b) Coupon discount, or c) First time shopper discount.");
            input = 1;
        }
        else if(isMemberOfMobileAlliance == true && isFirstTimeUser == 'N' && hasCoupon.equalsIgnoreCase("Yes")){
            System.out.println("User can only choose one option: a) Membership discount, b) Coupon discount, or c) First time shopper discount.");
            input = 1;
        }
        else if(isMemberOfMobileAlliance == true && isFirstTimeUser == 'Y' && hasCoupon.equalsIgnoreCase("No")){
            System.out.println("User can only choose one option: a) Membership discount, b) Coupon discount, or c) First time shopper discount.");
            System.out.println("You are required to choose only one option: (1), (2) or (3)");
            input = 1;
        }
        
        if(input == 0){
            
            System.out.println("*******************************");
            System.out.println("\n");
            System.out.println("\t\t\t\tUser Provider Details:");
            ProviderCalculator object2 = new ProviderCalculator(providerName, numOfUsers, isMemberOfMobileAlliance, isFirstTimeUser, hasCoupon);
            System.out.println(object2.toString());
            System.out.println(" ");
            System.out.println("*******************************");
            System.out.println(" ");
            
            System.out.println("\t\t\t\t"+object2.printReceipt());
        }
        else{
            System.out.println("Please try again");
        }
    }
}
        
    
    

        
        
             
        
        
        
    
        
        
       


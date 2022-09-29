/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MobilePrice;

/**
 *
 * @author Prudhvi Chigurupati
 */
public class ProviderCalculator {
    private String providerName;    //Provider Name 
    private int numOfUsers;         //Number of users
    private Boolean isMemberOfMobileAlliance;   //Does the user have a membership with the mobile alliance?
    private char isFirstTimeUser;   //Is the first time?  “Y” or “N” (upper-case)
    private String hasCoupon;       //Does the user have a coupon? “YES”, or “No” (upper-case, lower-case or any combination of upper-case and lower-case)
    private static final double COUPON = 5.00;  //Must be declared as a constant and initialized with 5.00 ($5 coupon)
    private static final double SALETAXES = 7.50;   //Must be declared as a constant and initialized with 7.50 (7.5% sales tax)

    /**
     * 
     * @param providerName provider name is given
     * @param numOfUsers   Number of users is given
     * @param isMemberOfMobileAlliance  Member of mobile alliance is given
     * @param isFirstTimeUser   First time user is given
     * @param hasCoupon     Coupon value is given
     */
    public ProviderCalculator(String providerName, int numOfUsers, Boolean isMemberOfMobileAlliance, char isFirstTimeUser, String hasCoupon) {
        this.providerName = providerName;
        this.numOfUsers = numOfUsers;
        this.isMemberOfMobileAlliance = isMemberOfMobileAlliance;
        this.isFirstTimeUser = isFirstTimeUser;
        this.hasCoupon = hasCoupon;
    }

    public String getProviderName() {
        return providerName;    //Get provider name
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;   //Set method is given to provider name
    }

    public int getNumOfUsers() {
        return numOfUsers;      //Get number of users
    }

    public void setNumOfUsers(int numOfUsers) {
        this.numOfUsers = numOfUsers;   //Set methodis given to number of users
    }

    public Boolean getIsMemberOfMobileAlliance() {
        return isMemberOfMobileAlliance;    //Get member of mobile alliance
    }

    public void setIsMemberOfMobileAlliance(Boolean isMemberOfMobileAlliance) {
        this.isMemberOfMobileAlliance = isMemberOfMobileAlliance;   //Set methods given to member of mobile alliance 
    }

    public char getIsFirstTimeUser() {
        return isFirstTimeUser;     //Get first time user value
    }

    public void setIsFirstTimeUser(char isFirstTimeUser) {
        this.isFirstTimeUser = isFirstTimeUser;     //Set method given to first time user
    }

    public String getHasCoupon() {
        return hasCoupon;       //Get Has coupon value
    }

    public void setHasCoupon(String hasCoupon) {
        this.hasCoupon = hasCoupon;     //Set method given to Has Coupon 
    }

    @Override
    /**
     * The tostring  method is used to print the details of the instance variables
     */
    public String toString() {
        return "Provider:"+ providerName +"\n"+"Number of user:"+ numOfUsers +"\n"+ "Member of the Mobile Alliance:" + isMemberOfMobileAlliance +"\n"+ "first time user:" + isFirstTimeUser + "\n"+"have coupon:" + hasCoupon;
    }
    /**
     * 
     * @return Finding the provider name 
     */
    public Boolean checkProviderName(){
        
         switch(providerName){
             
             
             case "AT&T":
                 
                 
                 return true;
                 
                    
             case "T-mobile":
                    
                    return true;
                    
             case "Verizon":
                   
                    return true;
                    
             default:
                    return false;    
        }
         
    }
    /**
     * 
     * @return Calculate the provider price 
     */    
     private double calcProviderPrice( ){
               if(providerName.equals("AT&T"))
               {
                   if(numOfUsers==1){
                       return 30.99;
                   }
                   else if(numOfUsers==2){
                        return 52.99;
                   }
                   else {
                       return 20.99;
                   }     
               }
               else if(providerName.equals("T-Mobile"))
               {
                   if(numOfUsers==1){
                       return 39.99;
                   }
                   else if(numOfUsers==2){
                        return 70.99;
                   }
                   else if(numOfUsers>=3&&numOfUsers<=5){
                       return 29.99;
                   }  
                  
                }
                    
               if((providerName.equals("Verizon"))&&(numOfUsers == 1))
               {
                    return 43.99;
               }
               else if(numOfUsers == 2)
               {
                    return 75.99;
               }
               else
               {
                    return 33.99;
               }
       }
        /**
         * 
         * @return Calculating the membership discount  
         */
        private double calcMembershipDiscount()
        {
        if(isMemberOfMobileAlliance == true)
        {
           if(numOfUsers == 1)
           {
               return Math.round(calcProviderPrice( )*(7.5/100)*100)/100.0;
           }
           else if(numOfUsers == 2)
           {
               return Math.round(calcProviderPrice( )*(6.5/100)*100)/100.0;
           }
           else if(numOfUsers>=3&&numOfUsers<=5)
           {
               return Math.round(calcProviderPrice( )*(8.5/100)*100)/100.0;
           }
        
        }
        return 0.0;

           }
        
        /**
         * 
         * @return Calculating the first time user discount or not 
         */
        private double calcFirstTimeUserDiscount(){
        if(isFirstTimeUser=='Y'){
             if(numOfUsers == 1)
           {
               return Math.round(calcProviderPrice( )*(10.0/100)*100)/100.0;
           }
           else if(numOfUsers == 2)
           {
               return Math.round(calcProviderPrice( )*(5.0/100)*100)/100.0;
           }
           else
           {
               return Math.round(calcProviderPrice( )*(4.0/100)*100)/100.0;
           }
        }
        else
            return 0.0;
    }
      /**
       * 
       * @param isMemberOfMobileAlliance
       * @param isFirstTimeUser
       * @param hasCoupon
       * @return the discount given by you
       */ 
      double chooseYourDiscount(Boolean isMemberOfMobileAlliance,char isFirstTimeUser,String hasCoupon){
          if(isMemberOfMobileAlliance == true){
              return calcMembershipDiscount();
          }
          else if(isFirstTimeUser=='Y'){
              return calcFirstTimeUserDiscount();
              
          }
          else {
              return calcCouponDiscount();
          }    
      }
       /**
        * 
        * @return Calculate the coupon discount 
        */
        private double calcCouponDiscount()
    {
        if(hasCoupon.equalsIgnoreCase("Yes"))
       
            return COUPON;
       
        else
            return 0.0;
       
    }
        /**
         * 
         * @return Calculate the total prize
         */
         private double totalPrice()
         {
        return Math.round((calcProviderPrice( ) - chooseYourDiscount(isMemberOfMobileAlliance, isFirstTimeUser, hasCoupon))*100.0)/100.0;
         }
         
         /**
          * 
          * @return Calculate the price with sales tax
          */
         private double totalPriceWithSalesTax()
    {
        if((numOfUsers==1)||(numOfUsers==2)||(numOfUsers==3))
           {
               
               return Math.round((totalPrice()+(totalPrice()*(SALETAXES/100)))*100)/100.0;
           }
           else
           {
               return 0.0;
           }
    }
         /**
          * 
          * @return Display's the print receipt method
          */
         public String printReceipt(){
        return "•  ++++ Receipt++++ \n"+
                "•  Mobile Charges for "+numOfUsers+" user using "+providerName+" as provider is:$" + calcProviderPrice( )
                + "\n•  Member of the Mobile Alliance: $" + calcMembershipDiscount()  
                + "\n• First Time user discount: $"
                + calcFirstTimeUserDiscount()
                + "\n• Coupon Discount: $" + calcCouponDiscount()
                + "\n• Charges After applying Discount: $" + totalPrice()
                +"\n•  Total Price with Tax: $"+ totalPriceWithSalesTax();
}
}



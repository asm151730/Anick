/**

*Description: This program will accept a given number of item names and prices from the user; then output them in reverse order 
* along with a welcome message, if any of the items are name "peas" (not case sensitive) 
* then the average price of the items will be displayed

*Class: Fall - COSC 2436.83448

*Assignment1: GroceryStore

*Date: 04/1/2020

*@author  Anick Muleki

*@version 4.4.2

*/ 
 
/**
* This code assigns the name PersonGeneric to a class with generic, assigns two data members, age and weight, 
* to class Person and create two constructors, a and w to display a string of Person's age and weight
* @This code asks the user to input their age and weight
* @The code returns the user's age and weight
* @Nothing implemented yet
*/

package grocerystore;
import java.util.Scanner;

/**
 *
 * @author anickmuleki
 */
public class GroceryStore 
{

    private static class Item 
    {// object
        private String name;
        private Double price;

        // constructor
        public Item(String name, Double price) 
        {//function to declare new items 
            this.name = name;
            this.price = price;           
        }
        
        public String ItemName()
        {// return name
            return name;
        }
        
        public Double ItemPrice()
        {// return price
            return price;
        }
    }
    
    public static void Welcome()
    {//  welcome meesage
        System.out.print("\nWelcome To St. Joseph's College!");          
    }
    public static void main(String[] args) 
    {// get number of items from user            
        Scanner input = new Scanner(System.in);
	int itemnum;
	System.out.print("How many items do you have? ");
	itemnum = input.nextInt();       
        
        // object array declaration
        Item[] ShoppingCart;
        ShoppingCart = new Item[itemnum];
        
        
        int a = 0; // counter for items
        int i = 0; // counter for while loop and array position
        while (i < itemnum) 
        {// while loop for item(s) name and price  
            a++;
            Scanner inputname = new Scanner(System.in);
            String itemname;
            System.out.print("What is the name for item " + a + "?: ");
            itemname = inputname.nextLine();
                        
            Scanner inputprice = new Scanner(System.in);
            Double itemprice;
            System.out.print("What is the price for item " + a + "?: $");
            itemprice = inputprice.nextDouble();  
            
            // initialize object
            ShoppingCart[i] = new Item(itemname, itemprice);
            
            // print item name and price
            System.out.print(ShoppingCart[i].ItemName() + ": $");
            System.out.print(ShoppingCart[i].ItemPrice() + "\n");
            // conuter
            i++;
        }
        
        //welcome message
        Welcome();
        
        System.out.print("\n\nThis is in your shopping cart: \n");
        // get lingth of shooping cart
        int r = ShoppingCart.length-1; 
        int flag = 0; // to flag peas
        
        //initialize average price
        Double avg_price = 0.0;
        while (r >= 0)
        {
            
            //System.out.print(ShoppingCart[r].ItemName().toLowerCase());
            // case senseitive if statement for peas average   
            String lowerCaseStr = ShoppingCart[r].ItemName().toLowerCase();
            if (lowerCaseStr.equals("peas"))
            {    
                flag = 1;
            }
            
            //print items in reverse
            System.out.print(ShoppingCart[r].ItemName() + ": $");
            System.out.print(ShoppingCart[r].ItemPrice() + "\n");
            
            // get average
            avg_price = avg_price + ShoppingCart[r].ItemPrice();
            r--; //reverse counter
            
        }
        
        if(flag == 1)
        { // print average if peas
            avg_price = avg_price / ShoppingCart.length;
            System.out.print("This is the average price of your cart " + avg_price);
        }
    }
    
}

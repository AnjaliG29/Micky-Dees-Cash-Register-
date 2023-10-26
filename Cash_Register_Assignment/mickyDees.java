// MickyDee's cash register program
// Written by Anjali Godara 2023-10-25

import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // import the ArrayList class
import java.lang.Math; // Import math library
import java.util.HashMap; // Import the HashMap class
import java.util.Map; // Import Map Class


public class mickyDees {
    public static void main(String[] args) {

        // Menu
        String menu = "MENU:\nBigMac (5$)\nMcChicken (5$)\nCheeseburger (5$)\nFries (3$)\nMuffin (3$)\nPoutine (3$)\nSprite (2$)\nCoke (2$)\nDrPepper (2$)\nIceCream (2$)\nMcFlurry (2$)";

        // Array of all the types of foods
        ArrayList<String> mains = new ArrayList<String>();
        ArrayList<String> side = new ArrayList<String>();
        ArrayList<String> drink = new ArrayList<String>();
        ArrayList<String> desert = new ArrayList<String>();

        // Order
        Map<String, Integer> order = new HashMap<String, Integer>();


        // Print welcome message and menu
        System.out.println("Welcome to McDonalds!");
        System.out.println(menu);

        while (true) { // While loop
            // Food Scanner
            Scanner obj1 = new Scanner(System.in);
            System.out.println("What would you like to order: "); // input string
            String food = obj1.nextLine();
            food = food.toLowerCase(); // Makes program not case sensative

            // Quantity Scanner
            Scanner obj2 = new Scanner(System.in);
            System.out.println("How much would you like:"); // input number
            int quant = obj2.nextInt();
            
            // Adds food and quantity to order
            order.put(food, quant);

            // The food string gets converted and sorted into catagories which gets added to the array at a value defined by the quantity
            for (int i = 0; i < quant; i++) { // This defines how many times the same food gets added to it's array (as determined by the quant value)
                switch (food) { // The switch sorts the food into catagories
                    case "bigmac":
                        mains.add("BigMac"); // Adds Big Mac
                        continue;
                    case "mcchicken":
                        mains.add("McChicken"); // Adds McChicken
                        continue;
                    case "cheeseburger":
                        mains.add("Cheeseburger"); // Adds Cheeseburger
                        continue;
                    case "fries":
                        side.add("Fries"); // Adds Fries
                        continue;
                    case "poutine":
                        side.add("Poutine"); // Adds Poutine
                        continue;
                    case "muffin":
                        side.add("Muffin"); // Adds Muffin
                        continue;
                    case "sprite":
                        drink.add("Sprite"); // Adds Sprite
                        continue;
                    case "coke":
                        drink.add("Coke"); // Adds Code
                        continue;
                    case "drPepper":
                        drink.add("DrPepper"); // Adds Dr Pepper
                        continue;
                    case "icecream":
                        desert.add("IceCream"); // Adds Ice Cream
                        continue;
                    case "mcflurry":
                        desert.add("McFlurry"); // Adds McFlurry 
                        continue;

            }
            }

            // Continue Scanner
            Scanner obj3 = new Scanner(System.in);
            System.out.println("Anything else (yes or no):"); // input string
            String decision = obj3.nextLine();
            decision = decision.toLowerCase();
            // Switch to decide if to continue or not
            if (decision.equals("yes")) {
                continue;
            } else {
                break;
            }
        }
        
        // Assign the size of the arrays into variables
        int a = mains.size();
        int b = side.size();
        int c = drink.size();
        int combos = 0;

        // This figures out how may combos there are
        if (a > 0 && b > 0 && c > 0) {
        combos = Math.min(a, b);
            combos = Math.min(combos, c);

            for (int i = 0; i < combos; i++) {
                // This removes the food that we already sorted into combos
                mains.remove(0);
                side.remove(0);
                drink.remove(0);
            }
        }
        
        // Now we can redefine the values of the food after figuring out the combos
        a = mains.size();
        b = side.size();
        c = drink.size();
        int d = desert.size();

        // Adds up the subprice
        float subprice = 0.0f;
        subprice += a * 5;
        subprice += b * 3;
        subprice += c * 2;
        subprice += d * 2;
        subprice += combos * 9;

        // Calculates tax
        float tax = 0.0f;
        float total = 0.0f;
        tax += subprice * 0.13;

        // The total
        total += subprice + tax;
        
        // Prints recipt
        System.out.println("\nRECIPT");

        // Iterates order
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Prints combo or regular recipt
        if (combos > 0) {
            System.out.println("\nSubtotal: " + subprice + "$\nTax: " + tax + "$\nTotal: " + total + "$\nYou Saved " + combos + "$ From Combo Discount\nHave a happy day!");
        } else {
            System.out.println("\nSubtotal: " + subprice + "$\nTax: " + tax + "$\nTotal: " + total + "$\nHave a happy day!");
        }
        
    }
}
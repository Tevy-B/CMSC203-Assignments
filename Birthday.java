import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * CMSC 203 Assignment 2 implementation
 * @author Sethatevy
 *
 * DESCRIPTION: a specialized toy company to purchase birthday gifts for the young children of your friends and relatives.  
 * The toys you can choose are divided into three categories:  plushies, blocks, and books. 
 * You can add a card and/or a balloon with each gift.  
 * Your program must display the information of the toy and the cost (including the card and the balloon), and the total amount of the order.  
 * Your program must generate a random number between 1-100000 to serve as the order number, followed by your name as programmer. 
 *
 */
public class Birthday extends Toy{
    public static void main(String[] args){

        //print welcome message and set variables
        JOptionPane.showMessageDialog(null, "Welcome to the Toy Company to choose gifts for young children.");
        String continueProgram = "";
        Random rand = new Random();
        double totalItemCost = 0.00;
        DecimalFormat moneyFormatter = new DecimalFormat("#,##0.00");

        do{
            /**
             * create variables to send info to Toy.java
             */
            String childName, childAgestr, toyChoice, cardChoice, balloonChoice;
            int childAge;
            Toy toy = new Toy();

            /**
             * Ask for child's name and age
             * Send age to toy object to set age.
             */
            childName = JOptionPane.showInputDialog("What is the child's name?");
            childAgestr = JOptionPane.showInputDialog("What is the child's age?");
            childAge = Integer.parseInt(childAgestr);
            toy.setAge(childAge);

            /**
             * Ask for toy choice
             */
            toyChoice = JOptionPane.showInputDialog("Which toy would you like to purchase? (plushie, blocks, book)");
            toy.setToy(toyChoice);

            /**
             * Call ageOK to test if gift is age appropriate. 
             * If toy is not age appropriate, ask user if they'd like to change it. 
             * If yes, prompt and ask for toy choice.
             * If no, continue
             */
            if (!toy.ageOK())
            {
                String continueOrNot = JOptionPane.showInputDialog("Toy is not age appropriate. Would you like to change the toy choice? (yes/no)");
                if (continueOrNot.equalsIgnoreCase("yes")) 
                {
                    toyChoice = JOptionPane.showInputDialog("Which toy would you like to purchase? (plushie, blocks, book)");
                    toy.setToy(toyChoice);
                }
            }

            /**
             * Set cost of toy
             */
            toy.setCost(toyChoice);

            /**
             * Ask if card is wanted. 
             * Send decision to addCard
             */
            cardChoice = JOptionPane.showInputDialog("Would you like to add a card? (yes/no)");
            toy.addCard(cardChoice);

            /**
             * Ask if balloon is wanted. 
             * Send answer to addBalloon
             */
            balloonChoice = JOptionPane.showInputDialog("Would you like to add a balloon? (yes/no)");
            toy.addBalloon(balloonChoice);

            /**
             * Add cost of toy and/or cards and/or balloons to total
             */
            totalItemCost += toy.getCost();

            /**
             * Display toy information to user
             */
            JOptionPane.showMessageDialog(null, "The gift for " + childName + toy.toString());

            /**
             * Ask user if another toy will be purchased
             * If yes, repeat while loop
             * If no, continue.
             */
            continueProgram = JOptionPane.showInputDialog("Would you like to purchase another toy? (yes/no)");
        }
        while(continueProgram.equalsIgnoreCase("yes"));


        /**
         * Display order total, order number, and programmer name to user
         */

        JOptionPane.showMessageDialog(null, "The total cost of your order is $" +
                moneyFormatter.format(totalItemCost));
        JOptionPane.showMessageDialog(null, "Order number: " + (rand.nextInt(10000) + 1)
                + "\nProgrammer: Sethatevy Bong");




    }
}



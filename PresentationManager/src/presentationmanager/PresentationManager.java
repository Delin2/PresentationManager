//Dennis Lin
//109426873
//dennis.lin@stonybrook.edu
//HOMEWORK 2
//CSE 214
//Vladimir Yevseenko 

package presentationmanager;

import java.util.Scanner;

public class PresentationManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SlideList SL = new SlideList();
        
        System.out.println("Welcome to PresentationManager!\n\n"
                          + "Please select an option:\n"
                          + "F) Move cursor forward\n"
                          + "B) Move cursor backward\n"
                          + "D) Display cursor slide\n"
                          + "E) Edit cursor slide\n"
                          + "P) Print presentation summary\n"
                          + "A) Append new slide to tail\n"
                          + "I) Insert new slide before cursor\n"
                          + "R) Remove slide at cursor\n"
                          + "H) Reset cursor to head\n"
                          + "Q) Quit\n");
        
        String selection;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Please select and option: ");
            selection = sc.nextLine();
            if(selection.toUpperCase().equals("F")){
                try {
                    SL.cursorForward();
                } catch (EndOfListException e) {
                    System.out.println("Unable to mvoe forward");
                }            
            }
            if (selection.toUpperCase().equals("B")) {
                try{
                SL.cursorBackward();
                }catch (EndOfListException e){
                    System.out.println("Unable to move backwards");
                }
            }
            if (selection.toUpperCase().equals("A")) {
                System.out.println("Enter the slide title:");
                    String title = sc.nextLine();
                System.out.println("Enter the slide duration:");
                    double duration = sc.nextDouble();
                    sc.nextLine();
                        String[] bullets = new String[5];
                        int i = 1;
                        Slide S1 = new Slide(title, bullets, duration);
                        System.out.println("Bullet " +i+ ":");
                        String bullet = sc.nextLine();
                        bullets[i] = bullet;
                        
                        i++; 
                    System.out.println("Add another bullet point?(Y/N)");
                do{
                    selection = sc.nextLine();
                    if(selection.toUpperCase().equals("Y")){
                        System.out.println("Bullet " +i+ ":");
                        bullet = sc.nextLine();
                        bullets[i] = bullet;
                        i++;
                        System.out.println("Add another bullet point?(Y/N)");
                        selection = sc.nextLine();
                    }
                }while(!selection.toUpperCase().equals("N"));
               SL.appendToTail(S1);
                System.out.println(S1);
            }
            if(selection.toUpperCase().equals("I")){
                System.out.println("Enter the slide title:");
                    String title = sc.nextLine();
                System.out.println("Enter the slide duration:");
                    double duration = sc.nextDouble();
                    sc.nextLine();
                        String[] bullets = new String[5];
                        int i = 1;
                        Slide S1 = new Slide(title, bullets, duration);
                        System.out.println("Bullet " +i+ ":");
                        String bullet = sc.nextLine();
                        bullets[i-1] = bullet;
                        i++; 
                    System.out.println("Add another bullet point?(Y/N)");
                do{
                    selection = sc.nextLine();
                    if(selection.toUpperCase().equals("Y")){
                        System.out.println("Bullet " +i+ ":");
                        bullet = sc.nextLine();
                        bullets[i-1] = bullet;
                        i++;
                        System.out.println("Add another bullet point?(Y/N)");
                        selection = sc.nextLine();
                    }
                }while(!selection.toUpperCase().equals("N"));
                    SL.insertBeforeCursor(S1);
                }
            if(selection.toUpperCase().equals("D")){
                SL.getCursorSlide().printslide();
            }
            if(selection.toUpperCase().equals("P")){
                SL.printSummary();
            }
        }while (!selection.toUpperCase().equals("Q"));
            System.out.println("Program terminating normally...");
    }
    
}

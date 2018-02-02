import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProcessAutoInventory
{
    // Start of main method
    public static void main( String [] args )
    {
        // Takes data from .txt file
        AutoInventory inventory = new AutoInventory( args[0] );
        Scanner input = new Scanner( System.in );
        // Creates command line object
        AutoInventoryCmdLineInterface userCommand = new AutoInventoryCmdLineInterface( inventory, input);
        
        //calls mainMenu method
        userCommand.mainMenu();
    }
}
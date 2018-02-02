import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AutoInventory
{
    // Declared variables
    public static final int makeIndex = 0;
    public static final int modelIndex = 1;
    public static final int yearIndex = 2;
    public static final int conditionIndex = 3;
    public static final int mileageIndex = 4;
    public static final int priceIndex = 5;
    public static final int vinIndex = 6;
    private int rows;
    private int columns;
    private String[][] autoArray;
    
    public AutoInventory( String path )
    {
        try
        {
            Scanner inventoryFile = new Scanner(new File ( path ) );
            
            // Values for rows and columns are read in from the .txt file
            // Values are read in one by one from .txt into an array
            rows = inventoryFile.nextInt();
            columns = inventoryFile.nextInt();
            autoArray = new String[rows][columns];
            
            // .useDelimiter method used to remove ; for the .txt file
            inventoryFile  = inventoryFile.useDelimiter(";");
            
            // for loop used to read in values from .txt file in a 2D array
            for ( int i = 0 ; i < rows ; i++ )
            {
                for ( int j = 0 ; j < columns ; j++ )
                {
                    autoArray[i][j] = inventoryFile.next() + "  ";
                }
            }
  
        }
        
        // Catch statement used to throw an exception if the file is not read in instead of terminating the program
        catch (FileNotFoundException except)
        {
            System.out.println( "Error: Inventory read failure. Error: " +
                               except.getMessage() );
            System.exit(-1);
        }
    }
    
    public String[][] getInventory()
    {
        return autoArray;
    }
    
    public int getNumColumns()
    {
        return columns;
    }
    
    public int getNumRecords()
    {
        return rows;
    }
    
    public String[][] searchIntegerField( int fieldNum, String compareType, int value )
    {
        String searchArray[][] = new String[rows][columns];
        if ( compareType.equals( "equal to" ) )
        {
            for ( int i = 0 ; i < rows ; i++ )
            {
                if (Integer.parseInt( autoArray[i][fieldNum].trim() ) == value )
                {
                    for ( int j = 0 ; j < columns ; j++ )
                    {
                        searchArray[i][j] = autoArray[i][j];
                    }
                }
            }
        }
        if ( compareType.equals( "less than" ) )
        {
            for ( int i = 0 ; i < rows ; i++ )
            {
                if (Integer.parseInt( autoArray[i][fieldNum].trim() ) < value )
                {
                    for ( int j = 0 ; j < columns ; j++ )
                    {
                        searchArray[i][j] = autoArray[i][j];
                    }
                }
            }
        }
        if ( compareType.equals( "greater than" ) )
        {
            for ( int i = 0 ; i < rows ; i++ )
            {
                if (Integer.parseInt( autoArray[i][fieldNum].trim() ) > value )
                {
                    for ( int j = 0 ; j < columns ; j++ )
                    {
                        searchArray[i][j] = autoArray[i][j];
                    }
                }
            }
        }
        return searchArray;
    }
    
    public String[][] searchTextField( int fieldNum, String value )
    {
       /* // for loop to calculate rows
        int returnRows = 0;
        for ( int i = 0 ; i < rows ; i++ )
        {
            if ( autoArray[i][fieldNum].trim().toLowerCase().contains(value) )
            {
                returnRows++;
            }
        }
        // declare new array
        String searchArray[returnRows][columns];*/
        String searchArray[][] = new String[rows][columns];
        // construct new array
        for ( int i = 0 ; i < rows ; i++ )
        {
            if ( autoArray[i][fieldNum].trim().toLowerCase().contains(value) )
            {
                for ( int j = 0 ; j < columns ; j++ )
                {
                    searchArray[i][j] = autoArray[i][j];
                }
            }
        }
        return searchArray;
    }
}
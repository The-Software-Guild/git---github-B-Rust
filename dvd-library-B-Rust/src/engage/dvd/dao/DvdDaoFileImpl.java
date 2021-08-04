// Ben Rust
// Engage - DVD project - I think this is complete

package engage.dvd.dao;

import engage.dvd.dto.Dvd;
import engage.dvd.ui.UserIO;
import engage.dvd.ui.UserIOConsoleImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DvdDaoFileImpl implements DvdDao {


    private List<Dvd> dvdList = new LinkedList<>();
    public static final String DVD_COLLECTION = "collection.txt";
    public static final String DELIMITER = "::";

    @Override
    // Adds the Dvd passed as a parameter to the collection
    public void addDvd(Dvd currDvd) throws DvdDaoException{
        loadCollection();
        dvdList.add(currDvd);
        writeCollection();
    }

    @Override
    // Returns a list of all the dvds in the dvd collection
    public List<Dvd> getAllDvds() throws DvdDaoException{
        UserIO io = new UserIOConsoleImpl();
        loadCollection();
        if(dvdList.isEmpty()){
            io.print("There are currently no DVDs in your collection");
        }

        return dvdList;
    }

    @Override
    // Return the dvd after prompting the user for info
    public Dvd getDvd() throws DvdDaoException{
        // First, get the title from the user (ignore capitalization)
        // If there are multiple DVDs that match that title, then
        // list them all and ask the user to select the specific one
        loadCollection();
        UserIO io = new UserIOConsoleImpl();
        String userTitle = io.readString("Please enter the title or piece of a title that you would like to search: ");
        Dvd currDvd = null;
        List<Dvd> validDvds = new ArrayList<Dvd>();
        int userSelection;

        for(int i = 0; i < dvdList.size(); i++){
            currDvd = dvdList.get(i);
            if(currDvd.getTitle().toLowerCase().contains(userTitle.toLowerCase())){
                validDvds.add(currDvd);
            }
        }

        // If there are no Dvds matching the user's input, state that and return null
        if(validDvds.isEmpty()){
            io.print("There was no DVD in this collection matching that input");
            return null;
        }

        // If there is only 1  dvd matching, print it and output it
        if(validDvds.size() == 1){
            io.print("There was only 1 DVD matching that input:");
            io.print(validDvds.get(0).getTitle());
            currDvd = validDvds.get(0);
        }

        // If there is more than 1 dvd matching, print them and let the user select it
        if(validDvds.size() > 1) {
            io.print("There was multiple DVDs matching that input:");

            for(int i = 0; i < validDvds.size(); i++){
                currDvd = validDvds.get(i);
                io.print((i+1) + ". " + currDvd.getTitle() + "(" + currDvd.getReleaseDate() + ")");
                io.print("Directed by: " + currDvd.getDirectorName() + "\t\tRated: " + currDvd.getMpaaRating() + "\n");
            }

            // The following is subtracted by 1 because the printed statements add +1 to the index
            // of each title, so that it would start at 1
            userSelection = io.readInt("Please enter the number of the DVD you want:", 1, validDvds.size())-1;
            currDvd = validDvds.get(userSelection);
        }

        return currDvd;
    }

    @Override
    // Edit the dvd passed as a parameter
    public void editDvd() throws DvdDaoException{
        loadCollection();
        boolean keepEditing = true;
        int userSelection = 0;
        UserIO io = new UserIOConsoleImpl();
        Dvd currDvd = getDvd();

        if(currDvd == null){
            return;
        }

        while(keepEditing){
            userSelection = getEditMenuSelection();
            switch(userSelection){
                case 1:
                    io.print("The current title is: " + currDvd.getTitle());
                    currDvd.setTitle(io.readString("Please enter the new title: "));
                    break;
                case 2:
                    io.print("The current release date is: " + currDvd.getReleaseDate());
                    currDvd.setReleaseDate(io.readString("Please enter the new release date: "));
                    break;
                case 3:
                    io.print("The current MPAA rating is: " + currDvd.getMpaaRating());
                    currDvd.setMpaaRating(io.readString("Please enter the new MPAA rating: "));
                    break;
                case 4:
                    io.print("The current director's name is: " + currDvd.getDirectorName());
                    currDvd.setDirectorName(io.readString("Please enter the new director's name: "));
                    break;
                case 5:
                    io.print("The current studio is: " + currDvd.getStudio());
                    currDvd.setStudio(io.readString("Please enter the new studio: "));
                    break;
                case 6:
                    // A much better program would allow the user to select if they want to
                    // edit the notes by starting fresh, adding to the front of the existing
                    // notes, or adding to the back of the existing notes
                    io.print("The current notes are: " + currDvd.getUserNote());
                    currDvd.setUserNote(io.readString("Please enter the new notes: "));
                    break;
                case 7:
                    keepEditing = false;
                    break;
                default:
                    io.print("Something went wrong, exiting the edit menu");
                    keepEditing = false;
            }
        }

        writeCollection();
    }

    @Override
    // Delete the dvd passed as a parameter
    public void deleteDvd() throws  DvdDaoException{
        loadCollection();
        Dvd currDvd = getDvd();
        if(currDvd == null){
            return;
        }
        dvdList.remove(currDvd);
        writeCollection();
    }

    // *********************************************************

    // Print the user's editing menu and get selection
    public int getEditMenuSelection(){
        UserIO io = new UserIOConsoleImpl();
        io.print("\n\nEditing Menu:");
        io.print("1. Edit Title");
        io.print("2. Edit Release Date");
        io.print("3. Edit MPAA Rating");
        io.print("4. Edit Director's Name");
        io.print("5. Edit Studio");
        io.print("6. Edit User Notes");
        io.print("7. Return to Menu");
        return  io.readInt("Please select from the above choices.", 1, 7);
    }

    /*
    dvdAsText is supposed to contain all of the data for the DVD
    It will have the data in the format of
        title::releaseDate::mpaaRating::directorName::studio::userNote
    Where the :: are delimiters separating the data fields

     This method will split that string based on the delilmiter
     It will then create a Dvd using that information
     */
    private Dvd unmarshallDvd(String dvdAsText){
        String [] dvdSections = dvdAsText.split(DELIMITER);
        Dvd currDvd = new Dvd();
        // Order of the dvdSections array: title, releaseDate,
        // mpaaRating, directorName, studio, userNote
        currDvd.setTitle(dvdSections[0]);
        currDvd.setReleaseDate(dvdSections[1]);
        currDvd.setMpaaRating(dvdSections[2]);
        currDvd.setDirectorName(dvdSections[3]);
        currDvd.setStudio(dvdSections[4]);
        currDvd.setUserNote(dvdSections[5]);
        return currDvd;
    }

    //
    private void loadCollection() throws DvdDaoException{
        Scanner fileScanner;

        // Create the scanner for reading from the "database" (text file)
        try{
            fileScanner = new Scanner  ( new BufferedReader( new FileReader(DVD_COLLECTION)));
        } catch (FileNotFoundException e){
            throw new DvdDaoException ("Error: Could not load collection data into memory", e);
        }

        // currentLine holds the most recent line read from the file
        String currentLine;
        // currDvd holds the most recent student unmarshalled
        Dvd currDvd;
        dvdList.clear();

        // Go through the DVD_COLLECTION file line by line and turn
        // each line back into  a student. Then, add these students to a list
        while(fileScanner.hasNextLine()){
            // get the next line
            currentLine = fileScanner.nextLine();
            // unmarshall that line into a dvd object
            currDvd = unmarshallDvd(currentLine);

            // Append each new Dvd to the dvdList
            dvdList.add(currDvd);
        }
        fileScanner.close();
    }

    // This method takes a Dvd object and turns it into
    // a single string, with each data field being separated
    // by :: delimiters.
    //      title::releaseDate::mpaaRating::directorName::studio::userNote
    private String marshallDvd(Dvd currDvd){
        String dvdAsStr = "";
        dvdAsStr += currDvd.getTitle() + DELIMITER;
        dvdAsStr += currDvd.getReleaseDate() + DELIMITER;
        dvdAsStr += currDvd.getMpaaRating() + DELIMITER;
        dvdAsStr += currDvd.getDirectorName() + DELIMITER;
        dvdAsStr += currDvd.getStudio() + DELIMITER;
        dvdAsStr += currDvd.getUserNote() + DELIMITER;
        return dvdAsStr;
    }

    // Write all DVDs in the dvdList as single lines of
    // text in the DVD_COLLECTION file
    private void writeCollection() throws DvdDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_COLLECTION));
        } catch (IOException e){
            throw new DvdDaoException("Could not write to the database (text file)", e);
        }

        // Turns each DVD in the DVD collection into a line of text
        // and insert them into the file, one by one
        String dvdAsText;
        for(Dvd dvd : dvdList){
            // Turn each dvd into a string
            dvdAsText = marshallDvd(dvd);
            // Write that string into the file
            out.println(dvdAsText);
            // Force printwriter to write the line to the file
            out.flush();
        }
    }
}

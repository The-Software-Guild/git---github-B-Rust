// Ben Rust
// DvdView class - incomplete

package engage.dvd.ui;

import engage.dvd.dto.Dvd;

import java.util.List;

public class DvdView {
    private UserIO io;

    // Constructor that initializes the UserIO field
    public DvdView(UserIO io){
        this.io = io;
    }

    // Print and get menu selection
    public int printMenuAndGetSelection() {
        io.print("\n\n========= Main Menu =========");
        io.print("1. Add a new DVD to the collection");
        io.print("2. List all DVDs");
        io.print("3. View the information of a single DVD");
        io.print("4. Search for a DVD by title");
        io.print("5. Edit a DVD");
        io.print("6. Delete a DVD from the collection");
        io.print("7. Quit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    // Get new DVD info
    public Dvd getNewDvdInfo(){
        Dvd currDvd = new Dvd();
        // Get dvd info
        currDvd.setTitle(io.readString("Enter Title"));
        currDvd.setReleaseDate(io.readString("Enter Release Date"));
        currDvd.setMpaaRating(io.readString("MPAA Rating"));
        currDvd.setDirectorName(io.readString("Director's Name"));
        currDvd.setStudio(io.readString("Enter Studio"));
        currDvd.setUserNote(io.readString("Enter User Notes"));
        return currDvd;
    }

    // Print Dvd info
    public void printDvdInfo(Dvd currDvd){
        UserIO io = new UserIOConsoleImpl();
        io.print("\nTitle: " + currDvd.getTitle() + "\tRelease Date: " + currDvd.getReleaseDate() + "\tDirector: " + currDvd.getDirectorName());
        io.print("MPAA Rating: " + currDvd.getMpaaRating() + "\tStudio: " + currDvd.getStudio() + "\tNotes: " + currDvd.getUserNote());
    }

    // Display all of the DVDs
    public void displayDvdCollection(List<Dvd> dvdList){
        for(Dvd currDvd : dvdList){
            printDvdInfo(currDvd);
        }
    }

    public void displayErrorMessage(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayGoodbyeMessage(){
        io.print("GOODBYE!");
    }

    // ***************** TEXT BANNERS *******************
    public void displayCreateDvdBanner(){
        io.print("==== Adding A New DVD ====");
    }

    public void displayCreateDvdSuccessBanner(){
        io.print("==== That DVD has been added to your collection! ====");
    }

    public void displayFindDvdBanner(){
        io.print("==== Searching For A DVD ====");
    }

    public void displayEditDvdBanner(){
        io.print("==== Editing A DVD ====");
    }

    public void displayEditDvdSuccessBanner(){
        io.print("==== That DVD has been edited! ====");
    }

    public void displayDeleteDvdBanner(){
        io.print("==== Deleting A DVD ====");
    }

    public void displayDeleteDvdSuccessBanner(){
        io.print("==== That DVD has been removed from your collection! ====");
    }





}

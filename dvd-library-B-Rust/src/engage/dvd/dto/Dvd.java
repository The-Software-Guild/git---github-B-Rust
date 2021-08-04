// Ben Rust
// Engage - Dvd class - should be done

package engage.dvd.dto;

import engage.dvd.ui.UserIO;
import engage.dvd.ui.UserIOConsoleImpl;

public class Dvd {
    private String title;
    private String releaseDate;
    private String mpaaRating; // could be enum
    private String directorName;
    private String studio;
    private String userNote = " ";

    public Dvd(){
    }

    // *******   Getters   *******************
    public String getTitle(){
        return this.title;
    }

    public String getReleaseDate(){
        return this.releaseDate;
    }

    public String getMpaaRating(){
        return this.mpaaRating;
    }

    public String getDirectorName(){
        return this.directorName;
    }

    public String getStudio(){
        return this.studio;
    }

    public String getUserNote(){
        return this.userNote;
    }

    // *******   Setters   *******************
    public void setTitle(String title){
        this.title = title;
    }

    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public void setMpaaRating(String mpaaRating){
        this.mpaaRating = mpaaRating;
    }

    public void setDirectorName(String directorName){
        this.directorName = directorName;
    }

    public void setStudio(String studio){
        this.studio = studio;
    }

    public void setUserNote(String userNote){
        this.userNote = userNote;
    }

}

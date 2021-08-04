package engage.dvd.dao;

import engage.dvd.dto.Dvd;

import java.util.List;

public interface DvdDao {

    // Adds the Dvd passed as a parameter to the collection
    void addDvd(Dvd currDvd) throws DvdDaoException;

    // Returns a list of all the dvds in the dvd collection
    List<Dvd> getAllDvds() throws DvdDaoException;

    // Return the dvd after prompting the user for info
    Dvd getDvd() throws DvdDaoException;

    // Edit the dvd passed as a parameter
    void editDvd() throws DvdDaoException;

    // Delete the dvd passed as a parameter
    void deleteDvd() throws  DvdDaoException;

}

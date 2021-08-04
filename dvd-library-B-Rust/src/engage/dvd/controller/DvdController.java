// Ben Rust
// Engage -  DvdController class - incomplete

package engage.dvd.controller;

import engage.dvd.dao.DvdDao;
import engage.dvd.dao.DvdDaoException;
import engage.dvd.dto.Dvd;
import engage.dvd.ui.DvdView;
import engage.dvd.ui.UserIOConsoleImpl;

import java.util.List;

public class DvdController {
    private DvdView view;
    private DvdDao dao;

    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing){
                menuSelection  = getMenuSelection();

                // Menu selection & switch case
                switch(menuSelection){
                    // 1. Create DVD
                    case 1:
                        createDvd();
                        break;

                    // 2. List all DVDs in collection
                    case 2:
                        listAllDvds();
                        break;

                    // 3. View Singular DVD
                    case 3:
                        findSingleDvd();
                        break;

                    // 4. Search DVDs by title
                    case 4:
                        findDvdByTitle();
                        break;

                    // 5. Edit DVD
                    case 5:
                        editDvd();
                        break;

                    // 6. Remove DVD
                    case 6:
                        removeDvd();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage(); // Exit message
        } catch (DvdDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    public DvdController(DvdDao dao, DvdView view){
        this.dao = dao;
        this.view = view;
    }

    public int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd);
        view.displayCreateDvdSuccessBanner();
    }

    private void  listAllDvds(){
        try {
            // view.displayDisplayAllBanner();
            List<Dvd> dvdList = dao.getAllDvds();
            view.displayDvdCollection(dvdList);
        } catch (DvdDaoException e){
            e.printStackTrace();
        }
    }

    private Dvd findSingleDvd() throws DvdDaoException {
        Dvd result = dao.getDvd();
        view.printDvdInfo(result);
        return result;
    }

    private void findDvdByTitle() throws DvdDaoException {
        view.displayFindDvdBanner();
        findSingleDvd();
    }

    private void editDvd()  throws DvdDaoException {
        view.displayEditDvdBanner();
        dao.editDvd();
        view.displayEditDvdSuccessBanner();
    }

    private void removeDvd() throws DvdDaoException {
        view.displayDeleteDvdBanner();
        dao.deleteDvd();
        view.displayDeleteDvdSuccessBanner();
    }

    private void unknownCommand(){
        view.displayErrorMessage("Unknown selection");
    }

    private void exitMessage(){
        view.displayGoodbyeMessage();
    }

}


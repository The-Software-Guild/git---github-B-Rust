package engage.dvd;

import engage.dvd.controller.DvdController;
import engage.dvd.dao.DvdDao;
import engage.dvd.dao.DvdDaoFileImpl;
import engage.dvd.ui.DvdView;
import engage.dvd.ui.UserIO;
import engage.dvd.ui.UserIOConsoleImpl;

public class DvdCollection {
    public static void main(String [] args){
        UserIO myIo = new UserIOConsoleImpl();
        DvdView myView = new DvdView(myIo);
        DvdDao myDao = new DvdDaoFileImpl();
        DvdController controller = new DvdController(myDao, myView);

        controller.run();
    }
}

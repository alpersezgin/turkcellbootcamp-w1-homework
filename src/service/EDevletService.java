package service;

import database.EDevletDb;
import entity.Player;
import service.Interface.EDevletInterface;

public class EDevletService implements EDevletInterface {

    @Override
    public boolean verify(Player player) {
        for (Player eDevletUser : EDevletDb.E_DEVLET_USERS) {
            if(player.getNationalIdentity().equals(eDevletUser.getNationalIdentity()) &&
                player.getFirstName().toLowerCase().equals(eDevletUser.getFirstName().toLowerCase()) &&
                player.getLastName().toLowerCase().equals(eDevletUser.getLastName().toLowerCase()) &&
                player.getYearOfBirth().equals(eDevletUser.getYearOfBirth())) {

                System.out.println(player.getFirstName() + " " + player.getLastName() + " Contact Verified.");
                return true;
            }
        }
        return false;
    }
}

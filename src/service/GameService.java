package service;

import java.util.List;

import database.GameDatabase;
import entity.Campaign;
import entity.Game;
import service.Interface.BaseInterface;

public class GameService implements BaseInterface<Game> {

    @Override
    public void add(Game game) {
        GameDatabase.gameList.add(game);
    }

    @Override
    public void update(Game game) {
        for (Game availableGame : GameDatabase.gameList) {
            if(availableGame.getId() == game.getId()){
                availableGame.setName(game.getName());
                availableGame.setPrice(game.getPrice());
                availableGame.setCampaign(game.getCampaign());
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int index = 0; index<GameDatabase.gameList.size(); index++){
            if(GameDatabase.gameList.get(index).getId() == id){
                GameDatabase.gameList.remove(index);
            }
        }
    }

    @Override
    public List<Game> getAll() {
       return GameDatabase.gameList;
    }

    @Override
    public Game getById(int id) throws Exception {
        for (int index = 0; index<GameDatabase.gameList.size(); index++){
            if(GameDatabase.gameList.get(index).getId() == id){
                return GameDatabase.gameList.get(index);
            }
        }
        return new Game();
    }

    @Override
    public Game getByName(String name) {
        for (int index = 0; index<GameDatabase.gameList.size(); index++){
            if(GameDatabase.gameList.get(index).getName().toLowerCase().equals(name.toLowerCase())){
                return GameDatabase.gameList.get(index);
            }
        }
        return new Game();
    }

    public void changedCampaign(Game game, Campaign campaign){
        game.setCampaign(campaign);
        update(calculatePriceForCampaign(game));
    }  
    
    public Game calculatePriceForCampaign(Game game){
        if(game.getCampaign() != null) {
            game.setPrice(game.getPrice() -  (game.getPrice() * game.getCampaign().getDiscountPercentage()) / 100);
        }
        return game;
    }
}

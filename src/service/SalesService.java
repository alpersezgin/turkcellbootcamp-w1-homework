package service;


import entity.Game;
import entity.Player;

public class SalesService {
    
    private PlayerService playerService = new PlayerService();
    
    public void buyGame(Game game,Player player){
        if(game.getPrice() <= player.getMoney()){
            player.setMoney(player.getMoney() - game.getPrice());
            player.setGame(game);
            playerService.update(player);
        }
    }

}

package org.catan.gui;

import java.util.ArrayList;
import java.util.Random;

import org.catan.players.Player;
import org.catan.map.*;

public class Controller {
    private Map gameMap;
    private ArrayList<Player> playerList;
    private Player currentPlayer;
    private int diceNum;
    
    public Controller() {
    	gameMap = new Map();
    	playerList = new ArrayList<Player>();
    	currentPlayer = new Player();
    	diceNum = 0;
    }
    
    public Map getMap() {
    	return(gameMap);
    }
    
    public ArrayList<Player> getPlayerList(){
    	return(playerList);
    }   
    
    public void addPlayer(Player p) {
    	playerList.add(p);
    }
    
    public Player getCurrentPlayer() {
    	return(currentPlayer);
    }
    
    public void goToNextPlayer() {
    	if (playerList.indexOf(currentPlayer) >= 3) {			// For four players, last index of playerList if 3
    		currentPlayer = playerList.get(0);
    	}
    	else {
    		currentPlayer = playerList.get(playerList.indexOf(currentPlayer) + 1);
    	}
    }
    
    public int rollDice() {
    	Random randNum1 = new Random();
    	Random randNum2 = new Random();
    	return((randNum1.nextInt(6) + 1) + (randNum2.nextInt(6) + 1));
    }
}

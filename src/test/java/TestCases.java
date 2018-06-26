/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.JsonArray;
import com.qainfotech.tap.training.snl.api.Board;
import com.qainfotech.tap.training.snl.api.BoardModel;
import com.qainfotech.tap.training.snl.api.GameInProgressException;
import com.qainfotech.tap.training.snl.api.InvalidTurnException;
import com.qainfotech.tap.training.snl.api.MaxPlayersReachedExeption;
import com.qainfotech.tap.training.snl.api.NoUserWithSuchUUIDException;
import com.qainfotech.tap.training.snl.api.OnlyOnePlayerPlayingException;
import com.qainfotech.tap.training.snl.api.PlayerExistsException;
import java.nio.file.FileAlreadyExistsException;
import org.json.JSONArray;
import org.json.JSONObject;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Arpitagarwal
 */
public class TestCases {
    
    
    
GameInterface gmInt;
@BeforeClass
public void InitGame()throws Exception{
    gmInt = new GameInterface();
}
@Test(expectedExceptions = OnlyOnePlayerPlayingException.class, priority = 0)
public void OnlyOnePLayerPlaying() throws Exception{
    InitGame();
    gmInt.registerPlayer(1, "B");
    gmInt.rollDice(0);
    
}
@Test(expectedExceptions = MaxPlayersReachedExeption.class, priority = 1)
public void MaximumLimitReached() throws Exception{
    gmInt.registerPlayer(5, "Arp");
}
@Test(expectedExceptions = GameInProgressException.class, priority = 2)
public void GameInPlay() throws Exception{
    InitGame();
    gmInt.registerPlayer(3, "Arpit");
    gmInt.rollDice(0);
    gmInt.registerPlayer(1, "Unk");
//    gmInt.registerPlayer();
}
@Test(expectedExceptions = PlayerExistsException.class, priority = 3)
public void PlayerAlreadyExist() throws Exception{
    InitGame();
    gmInt.registerPlayer(1, "A");
    gmInt.registerPlayer(1, "A");
}
@Test(expectedExceptions = InvalidTurnException.class, priority = 4)
public void InvalidTurn() throws Exception{
    InitGame();
    gmInt.registerPlayer(2, "Name");
    gmInt.rollDice(1);
}
@Test(expectedExceptions = InvalidTurnException.class, priority = 5)
public void TurnExceedingTotalPlayers() throws Exception{
    InitGame();
    gmInt.registerPlayer(2, "Name");
    gmInt.rollDice(2);
}
@Test(expectedExceptions = NoUserWithSuchUUIDException.class, priority = 6)
public void NoSuchPlayerExist() throws Exception{
    InitGame();
    gmInt.registerPlayer(3, "Delete");
    gmInt.deleteInvalidPlayer();
}
// TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    

}


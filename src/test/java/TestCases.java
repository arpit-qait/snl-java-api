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
import com.qainfotech.tap.training.snl.api.PlayerExistsException;
import java.nio.file.FileAlreadyExistsException;
import org.json.JSONArray;
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
    
    
    
Board board;
    JSONArray players;
    BoardModel data;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public void SetUpBoard() throws Exception {
        board = new Board();
        
    }
@Test(expectedExceptions = {MaxPlayersReachedExeption.class})
public void MoreThan4Players() throws Exception{
    players = board.registerPlayer("Arpit1");
    board.registerPlayer("Arpit2");
    board.registerPlayer("Arpit3");
    board.registerPlayer("Arpit4");
    board.registerPlayer("Arpit5");
}
@Test(expectedExceptions = {GameInProgressException.class})
public void GameAlreadyBegun() throws Exception{
   continue; 
}
}

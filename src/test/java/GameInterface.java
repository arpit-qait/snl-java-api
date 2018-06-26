
import com.qainfotech.tap.training.snl.api.Board;
import com.qainfotech.tap.training.snl.api.InvalidTurnException;
import com.qainfotech.tap.training.snl.api.OnlyOnePlayerPlayingException;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arpitagarwal
 */
public class GameInterface {
    JSONObject data;
    UUID buuid;
    Board board;
    JSONArray players;
    public GameInterface() throws Exception{
        board = new Board();
        data = board.getData();
        buuid = board.getUUID();
    }
    public void registerPlayer(int count, String name) throws Exception{
       for(int i=0;i<count;i++){
           board.registerPlayer(name+i);
       }
       System.out.println(data);
    }
    public void rollDice(int turn) throws Exception{
//        System.out.println(data.getJSONArray("players").length());
        if(data.getJSONArray("players").length() == 1)
            throw new OnlyOnePlayerPlayingException();
        if(turn >= data.getJSONArray("players").length()){
            throw new InvalidTurnException(buuid);
        }
//            throw new InvalidTurnException( );
        UUID puuid = (UUID)data.getJSONArray("players").getJSONObject(turn).get("uuid");
        board.rollDice(puuid);
    }
    public void deleteInvalidPlayer() throws Exception{
        System.out.println(buuid);
        board.deletePlayer((UUID)buuid);
    }
}

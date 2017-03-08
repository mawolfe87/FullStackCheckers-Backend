package stg.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stg.model.board.Board;

import java.util.List;
import java.util.Map;

/**
 * Created by prestonbattin on 3/7/17.
 */
@RestController
public class GameController {
    
    @RequestMapping(value = "/newGame",
                    method = RequestMethod.GET,
                    produces = {"application/json"})
    public Board newGame() {
        
        return new Board();
    }
    
    @RequestMapping(value = "/movePiece",
                    method = RequestMethod.POST,
                    consumes = {"application/json"},
                    produces = {"application/json"})
    public Board movePiece(@RequestBody Board board) {
        
        Map temp = board.getBoard();
        
        return board;
    }

    @RequestMapping(value="/move", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Integer> getMoves(@RequestBody Board board) {
        Board copyOfBoard = board;
        int position = copyOfBoard.getPositionFrom();
        return copyOfBoard.getBoard().get(position).getPossibleMoves(copyOfBoard, position);
    }

    @RequestMapping(value = "/checkMoves",
                    method = RequestMethod.POST,
                    consumes = {"application/json"},
                    produces = {"application/json"})
    public List<Integer> test(@RequestBody Board board) {
        
        //        Board tempbpard = board;
        //       int temp = board.getPositionFrom();
        //      return  board.getBoard().get(temp).getPossibleMoves(tempbpard,temp);
        
        return Board.getMoves(board, board.getPositionFrom());
    }
}
package stg.model.AI;

import stg.model.board.Board;
import stg.model.piece.*;

/**
 * Created by kevinmccann on 3/8/17.
 */
public class AI {
    public final int WIN = 500;
    public final int KING = 80;
    public final int PIECE = 30;

    public int evaluateBoardPositionWhite(Board board) {
        int positionScore = 0;
        for (Piece p : board.getBoard().values()) {
            if(p instanceof WhiteMan)
                positionScore += PIECE;
            if(p instanceof WhiteKing)
                positionScore += KING;
            if(board.checkGameFinished() && board.isWhiteWinner())
                positionScore += WIN;
            if(p instanceof BlackMan)
                positionScore -= PIECE;
            if(p instanceof BlackKing)
                positionScore -= KING;
            if(board.checkGameFinished() && board.isBlackWinner())
                positionScore -= WIN;
        }
        return positionScore;
    }

    public int evaluateBoardPositionBlack(Board board) {
        int positionScore = 0;
        for (Piece p : board.getBoard().values()) {
            if(p instanceof WhiteMan)
                positionScore -= PIECE;
            if(p instanceof WhiteKing)
                positionScore -= KING;
            if(board.checkGameFinished() && board.isWhiteWinner())
                positionScore -= WIN;
            if(p instanceof BlackMan)
                positionScore += PIECE;
            if(p instanceof BlackKing)
                positionScore += KING;
            if(board.checkGameFinished() && board.isBlackWinner())
                positionScore += WIN;
        }
        return positionScore;
    }

//    public int[] chooseMove(Board board) {
//
//    }

}
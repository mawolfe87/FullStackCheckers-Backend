package stg.model.piece;

import stg.model.move.WhiteMove;

/**
 * Created by rickjackson on 3/6/17.
 */
public class WhiteMan implements Man, WhiteMove {
    private int position;
    
    public WhiteMan(int position) {
        this.position = position;
    }
}

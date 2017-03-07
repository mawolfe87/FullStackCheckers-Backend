package stg.model.move;

/**
 * Created by rickjackson on 3/6/17.
 */
public interface WhiteMove {
    
    default int northWestSimpleMove(int start) {
        checkNorthSimpleMove(start);
        
        if (start < 5
            || ((start - 1) % 4 == 0 && ((start - 1) / 4) % 2 != 0)) {
            return -1;
        } else if (((start - 1) / 4) % 2 == 0) {
            return start - 4;
        } else {
            return start - 5;
        }
    }
    
    default int northEastSimpleMove(int start) {
        checkNorthSimpleMove(start);
        
        if (start < 5
            || ((start % 4 == 0 && (start / 4) % 2 != 0))) {
            return -1;
        } else if (((start - 1) / 4) % 2 == 0) {
            return start - 3;
        } else {
            return start - 4;
        }
    }
    
    default int northWestJumpMove(int start) {
        checkNorthSimpleMove(start);
        
        return (start < 9 || (start - 1) % 4 == 0) ? -1 : start - 9;
    }
    
    default int northEastJumpMove(int start) {
        checkNorthSimpleMove(start);
        
        return (start < 9 || start % 4 == 0) ? -1 : start - 7;
    }
    
    default void checkNorthSimpleMove(int index) {
        if (index < 1 || index > 32) {
            throw new IndexOutOfBoundsException();
        }
    }
}

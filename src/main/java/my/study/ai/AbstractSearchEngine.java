package my.study.ai;

import java.awt.Dimension;
import java.util.List;

/**
 * Created by thanh on 11/19/16.
 */
public abstract class AbstractSearchEngine {
    public Maze maze;

    public boolean equals(Dimension d1, Dimension d2){
        return d1.getHeight() == d2.getHeight() && d1.getWidth() == d2.getWidth();
    }

    public List<Dimension> getPossibleMoves(Dimension location){
        return null;
    }
}

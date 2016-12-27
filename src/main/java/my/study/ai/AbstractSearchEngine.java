package my.study.ai;

import java.awt.Dimension;
import java.util.*;

/**
 * Created by thanh on 11/19/16.
 */
public abstract class AbstractSearchEngine {
    public Maze getMaze() { return maze; }
    protected Maze maze;

    public AbstractSearchEngine(int width, int height) {
        maze = new Maze(width, height);
        initSearch();
    }

    /**
     * We will use the Java type Location (fields width and height will
     * encode the coordinates in x and y directions) for the search path:
     */
    protected Location[] searchPath;
    protected int pathCount;
    protected int maxDepth;
    protected Location startLoc, goalLoc, currentLoc;
    protected boolean isSearching = true;

    protected void initSearch() {
        if (searchPath == null) {
            searchPath = new Location[1000];
            for (int i=0; i<1000; i++) {
                searchPath[i] = new Location();
            }
        }
        pathCount = 0;
        startLoc = maze.startLoc;
        currentLoc = startLoc;
        goalLoc = maze.goalLoc;

        searchPath[pathCount++] = currentLoc;
    }

    protected boolean equals(Location d1, Location d2) {
        return d1.x == d2.x && d1.y == d2.y;
    }

    public Location [] getPath() {
        Location [] ret = new Location[maxDepth];
        for (int i=0; i < maxDepth; i++) {
            ret[i] = searchPath[i];
        }
        return ret;
    }

    protected Location [] getPossibleMoves(Location loc) {
        Location tempMoves[] = new Location[4];
        tempMoves[0] = tempMoves[1] = tempMoves[2] = tempMoves[3] = null;
        int x = loc.x;
        int y = loc.y;
        int num = 0;
        if (maze.getValue(x - 1, y) == 0 || maze.getValue(x - 1, y) == Maze.GOAL_LOC_VALUE) {
            tempMoves[num++] = new Location(x - 1, y);
        }
        if (maze.getValue(x + 1, y) == 0 || maze.getValue(x + 1, y) == Maze.GOAL_LOC_VALUE) {
            tempMoves[num++] = new Location(x + 1, y);
        }
        if (maze.getValue(x, y - 1) == 0 || maze.getValue(x, y - 1) == Maze.GOAL_LOC_VALUE) {
            tempMoves[num++] = new Location(x, y - 1);
        }
        if (maze.getValue(x, y + 1) == 0 || maze.getValue(x, y + 1) == Maze.GOAL_LOC_VALUE) {
            tempMoves[num++] = new Location(x, y + 1);
        }
        return tempMoves;
    }
}

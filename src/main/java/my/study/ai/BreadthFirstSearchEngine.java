package my.study.ai;

import java.util.*;

/**
 * Created by thanh on 11/19/16.
 */
public class BreadthFirstSearchEngine extends AbstractSearchEngine {

    public BreadthFirstSearchEngine(int width, int height) {
        super(width, height);
        doSearchOn2DGrid();
    }

    private void doSearchOn2DGrid() {
        int width = maze.getWidth();
        int height = maze.getHeight();
        boolean alReadyVisitedFlag[][] = new boolean[width][height];
        Location predecessor[][] = new Location[width][height];
        Queue<Location> queue = new LinkedList<Location>();

        for (int i=0; i<width; i++) {
            for (int j=0; j<height; j++) {
                alReadyVisitedFlag[i][j] = false;
                predecessor[i][j] = null;
            }
        }

        alReadyVisitedFlag[startLoc.x][startLoc.y] = true;
        queue.add(startLoc);
        boolean success = false;
        while (queue.isEmpty() == false && !success) {
            Location head = queue.poll();
            if (head == null) break; // ??
            Location [] connected = getPossibleMoves(head);
            for (int i=0; i<4; i++) {
                if (connected[i] == null) break;
                int w = connected[i].x;
                int h = connected[i].y;
                if (alReadyVisitedFlag[w][h] == false) {
                    alReadyVisitedFlag[w][h] = true;
                    predecessor[w][h] = head;
                    queue.add(connected[i]);
                    if (equals(connected[i], goalLoc)) {
                        success = true;
                        break; // we are done
                    }
                }
            }
        }
        // now calculate the shortest path from the predecessor array:
        maxDepth = 0;
        if (success) {
            searchPath[maxDepth++] = goalLoc;
            for (int i=0; i<100; i++) {
                searchPath[maxDepth] = predecessor[searchPath[maxDepth - 1].x][searchPath[maxDepth - 1].y];
                maxDepth++;
                if (equals(searchPath[maxDepth - 1], startLoc))  break;  // back to starting node
            }
        }

        System.out.println("Done");
    }
}

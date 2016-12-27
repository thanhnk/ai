package my.study.ai.gamesearch;

/**
 * Created by thanh on 12/23/16.
 */
public abstract class Game {
    public abstract boolean drawnPosition(Position p);
    public abstract boolean wonPosition(Position p, boolean player);
    public abstract int positionEvaluation(Position p, boolean player);
    public abstract Position[] possibleMoves(Position p, boolean player);
    public abstract Position makeMove(Position p, boolean player, Move move);
    public abstract boolean reachedMaxDepth(Position p, int depth);
    public abstract Move getMove();
}

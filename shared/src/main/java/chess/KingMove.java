package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KingMove implements MoveCalc{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves=new ArrayList<ChessMove>();
        int[][] directions={
            {1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}, {0, -1}, {1,-1}
        };
        int row=myPosition.getRow();
        int col=myPosition.getColumn();
        ChessPiece myPiece=board.getPiece(myPosition);
        for(int dir[]: directions) {
            int r = row + dir[0];
            int c = col + dir[1];
            ChessPosition newPosition = new ChessPosition(r, c);
            if (board.inBound(newPosition)) {
                if (board.emptyPosition(newPosition)) {
                    ChessMove move = new ChessMove(myPosition, newPosition, null);
                    moves.add(move);
                } else if (board.enemyPiece(newPosition, myPiece)) {
                    ChessMove move = new ChessMove(myPosition, newPosition, null);
                    moves.add(move);
                }
            }

        }
        return moves;
    }
}

package chess;

import java.util.Collection;

public interface MoveCalc {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);
}

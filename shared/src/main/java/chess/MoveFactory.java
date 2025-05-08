package chess;

public class MoveFactory {
    public MoveCalc movesCalculator(ChessPiece.PieceType type){
        switch(type){
            case KING:
                return new KingMove();
            case QUEEN:
            case PAWN:
            case ROOK:
            case BISHOP:
            case KNIGHT:
            case null, default:
                return new NullMove();
        }
    }
}

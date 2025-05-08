package chess;

public class MoveFactory {
    public MoveCalc movesCalculator(ChessPiece.PieceType type){
        switch(type){
            case KING:
                return new KingMove();
            case QUEEN:
            case PAWN:
                return new PawnMove();
            case ROOK:
            case BISHOP:
                return new BishopMove();
            case KNIGHT:
                return new KnightMove();
            case null, default:
                return new NullMove();
        }
    }
}

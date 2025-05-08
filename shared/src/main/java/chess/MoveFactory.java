package chess;

public class MoveFactory {
    public MoveCalc movesCalculator(ChessPiece.PieceType type){
        switch(type){
            case KING:
                return new KingMove();
            case QUEEN:
                return new QueenMove();
            case PAWN:
                return new PawnMove();
            case ROOK:
                return new RookMove();
            case BISHOP:
                return new BishopMove();
            case KNIGHT:
                return new KnightMove();
            case null, default:
                return new NullMove();
        }
    }
}

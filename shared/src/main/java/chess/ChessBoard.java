package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    private ChessPiece[][] board=new ChessPiece[8][8];
    public ChessBoard() {

    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece){
        board[8-position.getRow()][position.getColumn()-1]=piece;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return  board[8-position.getRow()][position.getColumn()-1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        board=new ChessPiece[8][8];
        for(ChessPiece.PieceType type: ChessPiece.PieceType.values()){
            addByColor(ChessGame.TeamColor.WHITE,type);
            addByColor(ChessGame.TeamColor.BLACK, type);
        }
    }
    private void addByColor(ChessGame.TeamColor color, ChessPiece.PieceType type){
        ChessPiece piece=new ChessPiece(color, type);
        ChessPosition position;
        int row;
        int col;
        int incr;
        if(color== ChessGame.TeamColor.WHITE){
            row=1;
            incr=1;
        }
        else{
            row=8;
            incr=-1;
        }
        switch(type){
            case KING:
                col=5;
                position= new ChessPosition(row, col);
                addPiece(position, piece);
                break;
            case QUEEN:
                col=4;
                position= new ChessPosition(row, col);
                addPiece(position, piece);
                break;
            case PAWN:
                int prow=row+incr;
                for(col=1; col<=8; col++){
                    position= new ChessPosition(prow, col);
                    addPiece(position, piece);
                }
                break;
            case ROOK:
                col=1;
                position= new ChessPosition(row, col);
                addPiece(position, piece);
                col=8;
                position= new ChessPosition(row, col);
                addPiece(position, piece);
                break;
            case BISHOP:
                col=3;
                position= new ChessPosition(row, col);
                addPiece(position, piece);
                col=6;
                position= new ChessPosition(row, col);
                addPiece(position, piece);
                break;
            case KNIGHT:
                col=2;
                position= new ChessPosition(row, col);
                addPiece(position, piece);
                col=7;
                position= new ChessPosition(row, col);
                addPiece(position, piece);
                break;
        }
    }
    public boolean inBound(ChessPosition position){
        int row=position.getRow();
        int col= position.getColumn();;
        if(row>8| row<1 | col>8 | col<1){
            return false;
        }
        return true;
    }
    public boolean emptyPosition(ChessPosition position){
        if(getPiece(position)==null){
            return true;
        }
        return false;
    }
    public boolean enemyPiece(ChessPosition newPosition, ChessPiece myPiece){
        if(emptyPosition(newPosition)){
            return false;
        }
        ChessGame.TeamColor myColor= myPiece.getTeamColor();
        if(getPiece(newPosition).getTeamColor()!=myColor){
            return true;
        }
        return false;
    }
}

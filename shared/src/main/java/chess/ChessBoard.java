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

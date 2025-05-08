package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMove implements MoveCalc{
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves= new ArrayList<>();
        ChessPiece myPiece=board.getPiece(myPosition);
        if(myPiece.getTeamColor()== ChessGame.TeamColor.WHITE){
            moves.addAll(moveByColor(board, myPosition, 2,8, 1));
        }
        else{
            moves.addAll(moveByColor(board, myPosition, 7,1, -1));
        }
        //things to do:
        //write how it moves regardless of color
        //moves up one inititally and then two if its at the start row
        //if the new position is the last row then promote to all the pieces possibly
        //then checks each diagonally if there is opponents
    }
    private Collection<ChessMove> moveByColor(ChessBoard board, ChessPosition myPosition, int startRow, int endRow, int rowIncr){
        Collection<ChessMove> moves= new ArrayList<>();
        ChessPiece myPiece=board.getPiece(myPosition);
        int myRow=myPosition.getRow();
        int myCol=myPosition.getColumn();
        int row=myRow+rowIncr;
        int col=myCol;
        ChessPosition newPosition= new ChessPosition(row, col);
        //moves forward one and possibly 2 if at starting row.
        if(board.inBound(newPosition)&& board.emptyPosition(newPosition)){
            if(row==endRow){
                moves.addAll(promoteAddPawn(myPosition, newPosition));
            }
            else{
                ChessMove move=new ChessMove(myPosition, newPosition, null);
                moves.add(move);
            }
            if(myRow==startRow){
                row=row+rowIncr;
                newPosition= new ChessPosition(row, col);
                ChessMove move=new ChessMove(myPosition, newPosition, null);
                moves.add(move);
            }
        }
        //diagonally left
        row=myRow+rowIncr;
        col=myCol-1;
        newPosition=new ChessPosition(row, col);
        if(board.inBound(newPosition)&& board.enemyPiece(newPosition, myPiece)){
            if(row==endRow){
                moves.addAll(promoteAddPawn(myPosition, newPosition));
            }
            else{
                ChessMove move=new ChessMove(myPosition, newPosition, null);
                moves.add(move);
            }
        }
        //diagonally right
        row=myRow+rowIncr;
        col=myCol+1;
        newPosition=new ChessPosition(row, col);
        if(board.inBound(newPosition)&& board.enemyPiece(newPosition, myPiece)){
            if(row==endRow){
                moves.addAll(promoteAddPawn(myPosition, newPosition));
            }
            else{
                ChessMove move=new ChessMove(myPosition, newPosition, null);
                moves.add(move);
            }
        }
        return moves;
    }

    private Collection<ChessMove>promoteAddPawn(ChessPosition startPos, ChessPosition endPos) {
        Collection<ChessMove> moves= new ArrayList<>();
        for(ChessPiece.PieceType type: ChessPiece.PieceType.values()){
            ChessMove move= new ChessMove(startPos, endPos, type);
            moves.add(move);
        }
        return moves;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(boolean isWhite){
        super(isWhite);
    }
    @Override
    public List<int[]> getValidMove(Piece[][] board, int[] position) {
        List<int[]> validMove = new ArrayList<>();
        System.out.println(position[0]+" "+position[1]);
        if(!this.isWhite()){
            if(position[0]==1){
                validMove.add(new int[]{2,position[1]});
                validMove.add(new int[]{3,position[1]});
            }
            else if(position[0]<7){
                validMove.add(new int[]{position[0]+1,position[1]});
            }
            if(position[1]>0 && position[0]<7){
                if(board[position[0]+1][position[1]-1]!=null && board[position[0]+1][position[1]-1].isWhite()==false){
                    validMove.add(new int[]{position[0]+1,position[1]-1});
                }
            }
            if(position[1]<7 && position[0]<7){
                if(board[position[0]+1][position[1]+1]!=null && board[position[0]+1][position[1]+1].isWhite()==false){
                    validMove.add(new int[]{position[0]+1,position[1]+1});
                }
            }
        }
        else{
            if(position[0]==6){
                validMove.add(new int[]{5,position[1]});
                validMove.add(new int[]{4,position[1]});
            }
            else if(position[0]>0){
                validMove.add(new int[]{position[0]-1,position[1]});
            }
            if(position[1]>0 && position[0]>0){
                if(board[position[0]-1][position[1]-1]!=null && board[position[0]-1][position[1]-1].isWhite()==false){
                    validMove.add(new int[]{position[0]-1,position[1]-1});
                }
            }
            if(position[1]<7 && position[0]>0){
                if(board[position[0]-1][position[1]+1]!=null && board[position[0]-1][position[1]+1].isWhite()==false){
                    validMove.add(new int[]{position[0]-1,position[1]+1});
                }
            }
        }
        return validMove;
    }

    @Override
    public String getSympol() {
        return " P"+(isWhite()?"w":"b");
    }
}

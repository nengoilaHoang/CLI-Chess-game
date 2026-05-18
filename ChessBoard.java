import java.util.List;

public class ChessBoard {
    private Piece[][] chessMatrix;
    public Piece[][] getChessMatrix(){
        return chessMatrix;
    }
    public ChessBoard(){
        // pawn = 1, bishop = 2, knight = 3, rook = 4, queen =5, king = 6.
        this.chessMatrix = new Piece[][]{   {null,null,null,null,null,null,null,null},
                                            {new Pawn(false),new Pawn(false),new Pawn(false),new Pawn(false),new Pawn(false),new Pawn(false),new Pawn(false),new Pawn(false)},
                                            {null,null,null,null,null,null,null,null},
                                            {null,null,null,null,null,null,null,null},
                                            {null,null,null,null,null,null,null,null},
                                            {null,null,null,null,null,null,null,null},
                                            {new Pawn(true),new Pawn(true),new Pawn(true),new Pawn(true),new Pawn(true),new Pawn(true),new Pawn(true),new Pawn(true)},
                                            {null,null,null,null,null,null,null,null},
                                            };
    }
    public ChessBoard(Piece[][] editedChessBoard){
        this.chessMatrix = editedChessBoard;
    }
    public List<int[]> getValidMove(int row, int column){
        if(chessMatrix[row][column]!=null){
            System.out.println(chessMatrix[row][column].getSympol());
            return chessMatrix[row][column].getValidMove(chessMatrix, new int[]{row, column});
        }
        else{
            System.out.println("this is a empty square");
            return null;
        }
    }
    public void PrintChess(){
        for(int i=0; i<=7; i++){
            for(int j=0; j<=7; j++){
                if(chessMatrix[i][j]==null){
                    if((i+j)%2==0) System.out.print(" . ");
                    else System.out.print(" # ");
                }
                else System.out.print(chessMatrix[i][j].getSympol());
            }
            System.out.println("   "+(8-i));
        }
        System.out.println();
        System.out.println(" a  b  c  d  e  f  g  h ");
    }
}

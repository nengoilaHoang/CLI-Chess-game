import java.util.List;
public abstract class Piece {
    private boolean isWhite;
    public Piece(boolean isWhite){
        this.isWhite = isWhite;
    }
    public boolean isWhite() {
        return this.isWhite;
    }
    public abstract List<int[]> getValidMove(Piece[][] board, int[]position);
    public abstract String getSympol();
}
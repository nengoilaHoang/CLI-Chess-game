import java.util.Scanner;
import java.util.List;

public class ChessGame {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Lệnh xóa sạch màn hình cho Windows (CMD/PowerShell)
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Lệnh xóa sạch màn hình cho Mac/Linux
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Bỏ qua lỗi nếu có
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ChessBoard chessBoard =  new ChessBoard();
        int[] chosingPosition = null;
        while(true){
            if(chosingPosition == null){
                clearScreen();
                chessBoard.PrintChess();
                int row;
                char column;
                int[] position = new int[2];
                System.out.print("choose row (enter one character (1->8)): ");
                row = scanner.nextInt();
                switch (row) {
                    case 1 -> position[0]=7;
                    case 2 -> position[0]=6;
                    case 3 -> position[0]=5;
                    case 4 -> position[0]=4;
                    case 5 -> position[0]=3;
                    case 6 -> position[0]=2;
                    case 7 -> position[0]=1;
                    case 8 -> position[0]=0;
                    default -> position[0]=-1;
                }
                if(position[0]==-1) continue; 
                System.out.print("choose column (enter one character (a->h)): ");
                column = scanner.next().charAt(0);
                switch (column) {
                    case 'a' -> position[1]=0;
                    case 'b' -> position[1]=1;
                    case 'c' -> position[1]=2;
                    case 'd' -> position[1]=3;
                    case 'e' -> position[1]=4;
                    case 'f' -> position[1]=5;
                    case 'g' -> position[1]=6;
                    case 'h' -> position[1]=7;
                    default -> position[1]=-1;
                }
                if(position[0]==-1) continue; 
                chosingPosition = position;
                System.out.println(position[0]+" "+position[1]);
                List<int[]> validMove = chessBoard.getValidMove(position[0], position[1]);
                System.out.print("valid moves is: ");
                if (validMove!=null){
                    for (int[] move : validMove) {
                        System.err.print(" ["+move[0]+", "+move[1]+"] ");
                    }
                    System.out.println();
                }
                else System.out.println("no exist");
            }
        }
    }
}


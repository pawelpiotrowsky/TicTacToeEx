import java.util.Random;
import java.util.Scanner;

public class TicTacToe {


    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        displayGameBoard(gameBoard);
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Pick a number (1-9)");
            int playerPosition = scan.nextInt();
            placePiece(gameBoard, playerPosition, "player");
            Random random = new Random();
            int cpuPosition = random.nextInt(9) + 1;
            placePiece(gameBoard, cpuPosition, "cpu");
            displayGameBoard(gameBoard);
        }
        if()

    }



    private static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
        }else if(user.equals("cpu")){
            symbol = 'O';
        }
        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    private static void displayGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

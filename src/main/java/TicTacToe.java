import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();

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
            int playerPos = scan.nextInt();
            while(playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)){
                System.out.println("Position taken, pick another number");
            }
            placePiece(gameBoard, playerPosition, "player");
            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            while(playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)){
                cpuPos = random.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPosition, "cpu");
            displayGameBoard(gameBoard);
            checkWinner();
        }


    }

    private static void checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List leftToRightX= Arrays.asList(1, 5, 9);
        List rightToLeftX = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(leftToRightX);
        winning.add(rightToLeftX);
        for (List l: winning){
            if(playerPosition.containsAll(l)){
                System.out.println("Congratulations, you won!");
            }else if(cpuPosition.containsAll(l)){
                System.out.println("Sorry, you lost :(");
            }else if(playerPosition.size() + cpuPosition.size() == 9){
                System.out.println("Board full ,tie");
            }
        }
    }


    private static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            playerPosition.add(pos);
        }else if(user.equals("cpu")){
            cpuPosition.add(pos);
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

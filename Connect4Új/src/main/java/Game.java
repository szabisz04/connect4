import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        player1 = new Player("1.játékos", 'S');
        player2 = new Player("2.játékos", 'P');
        currentPlayer = player1;
    }

    public void start() {
        boolean gameWon = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameWon && !board.isFull()) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + " köre (" + currentPlayer.getDisc() + ")");
            System.out.print("Válassz oszlopot (0-6): ");
            int col = scanner.nextInt();

            if (col < 0 || col >= 7) {
                System.out.println("Rossz oszlop, próbálja újra.");
                continue;
            }

            if (!board.dropDisc(col, currentPlayer.getDisc())) {
                System.out.println("Az oszlop tele van próblja újra");
                continue;
            }

            gameWon = board.checkForWin(currentPlayer.getDisc());
            if (gameWon) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " nyert!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        if (board.isFull() && !gameWon) {
            board.printBoard();
            System.out.println("Döntetlen");
        }

        scanner.close();
    }
}
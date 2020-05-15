import java.util.Scanner;

public class Game {
    char[][] board = new char[3][3];

    int blank = 9;

    boolean xWins = false;
    boolean oWins = false;
    boolean xMove = false;
    boolean yMove = false;
    boolean gameOver = false;
    boolean move = false;


    public void displayBoard() {
        String border = "---------------------";
        System.out.printf("%n%n%s%n", border);
        for (int i = 0; i < 3; i++) {

            System.out.print("|    ");
            for (int ii = 0; ii < 3; ii++) {
                System.out.print(this.board[i][ii] + "    ");
            }
            System.out.println("|");
            if (i == 0 || i == 1) {
                System.out.println("|                   |");
            }
        }
        System.out.printf("%s%n%n",border);
    }

    public boolean checkWin() {

        //check horizontals for win
        for (int i = 0; i < board.length; i++) {

            if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
                xWins = true;
            }

            if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
                oWins = true;
            }

        }

        //check verticals for win

        for (int i = 0; i < 3; i++) {

            if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') {
                xWins = true;
            }

            if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O') {
                oWins = true;
            }

        }

        //check diagonals or win

        if ((board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') || (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')) {
            xWins = true;
        }

        if ((board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') || (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')) {
            oWins = true;
        }

        if (!xWins && !oWins) {
            if (blank == 0) {
                System.out.println("Draw");
                gameOver = true;
            }
        } else if (xWins && !oWins) {
            System.out.println("X wins");
            gameOver = true;
        } else if (oWins && !xWins) {
            System.out.println("O wins");
            gameOver = true;
        } else {
            System.out.println("Impossible");
            gameOver = true;
        }

        return gameOver;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char count = '1';
        Game game = new Game();

        // create blank board
        for (int i = 0; i < game.board.length; i ++) {
            for (int ii = 0; ii < game.board[i].length; ii++) {
                game.board[i][ii] = count;
                count++;
            }
        }

        game.displayBoard(); //Display the board


        while(!game.gameOver) {
            int in;
            // Ask for next move
            while (!game.move) {
                if (!game.xMove) {
                    System.out.print("Enter your move X: ");
                } else {
                    System.out.print("Enter your move O: ");
                }
                try {
                    in = Integer.parseInt(sc.nextLine());
                    int b = 0;
                    int a = 0;

                    // Takes the input and assigns to appropriate space on the board.
                    if (in >= 1 && in <= 9) {
                        switch (in) {
                            case 1:
                                b = 0;
                                a = 0;
                                break;
                            case 2:
                                b = 0;
                                a = 1;
                                break;
                            case 3:
                                b = 0;
                                a = 2;
                                break;
                            case 4:
                                b = 1;
                                a = 0;
                                break;
                            case 5:
                                b = 1;
                                a = 1;
                                break;
                            case 6:
                                b = 1;
                                a = 2;
                                break;
                            case 7:
                                b = 2;
                                a = 0;
                                break;
                            case 8:
                                b = 2;
                                a = 1;
                                break;
                            case 9:
                                b = 2;
                                a = 2;
                                break;
                        }

                        // checks to make sure the space is not already occupied and makes the move.
                        if (game.board[b][a] >= '1' && game.board[b][a] <= '9') {
                            game.move = true;
                            if (!game.xMove) {
                                game.board[b][a] = 'X';
                                game.xMove = true;
                                game.yMove = false;
                            } else {
                                game.board[b][a] = 'O';
                                game.xMove = false;
                                game.yMove = true;
                            }
                            game.blank -= 1;
                        } else {
                            System.out.println("Position is already taken.");
                        }
                    } else {
                        System.out.println("Invalid input.");
                    }
                } catch (Exception e) {
                    System.out.println("Must input a number between 1 and 9.");
                }
            }
            game.move = false;
            game.displayBoard();
            game.gameOver = game.checkWin();

        }
    }

}

/**
 * this class is the board and the methods for lacing disks in the board
 * and sets a board for a new game and changes it and prints it
 * and has a method for the end of the game
 *
 * @author Moujan Mirjalili
 * @version 2020
 */
public class Board
{
    //this field is the board of the game which has othello disks in it
    private Disk[][] boardGame;

    /**
     * this is the constructor
     * it makes a new board considering the othello rules for anew game
     */
    public Board()
    {
        boardGame = new Disk[8][8];
        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                boardGame[i][j] = new Disk();
                boardGame[i][j].setColor("noColor");
            }
        }
        boardGame[3][3].setColor("white");
        boardGame[3][4].setColor("black");
        boardGame[4][3].setColor("black");
        boardGame[4][4].setColor("white");
        printBoard();
    }

    /**
     * this method gets the coordinates of a move and checks if the move is valid
     *
     * @param x is the row of the coordinate
     * @param y is the column of the coordinate
     * @param player is the player which wants to move
     */
    public void checkDisk(int x, int y, String player)
    {
        int theX = x, theY = y;
        boolean canMove = false;
        if(player.equals("black"))
        {
            if (x!=0 && y!=0 && boardGame[x - 1][y - 1].getColor().equals("white"))
            {
                while (x - 1 >= 0 && y - 1 >= 0) {
                    if (boardGame[x - 1][y - 1].getColor().equals("black"))
                    {
                        canMove = true;
                        changeBoard1(theX,theY,-1,-1);
                        break;
                    }
                    x--;
                    y--;
                }
            }
            x = theX;
            y = theY;
            if (x!=0 && boardGame[x - 1][y].getColor().equals("white"))
            {
                x--;
                while (x - 1 >= 0) {
                    if (boardGame[x - 1][y].getColor().equals("black"))
                    {
                        canMove = true;
                        changeBoard1(theX,theY,-1,0);
                        break;
                    }
                    x--;
                }
            }
            x = theX;
            y = theY;
            if (x!=0 && y!=7 && boardGame[x - 1][y + 1].getColor().equals("white"))
            {
                x--;
                y++;
                while (x - 1 >= 0 && y + 1 <= 7) {
                    if (boardGame[x - 1][y + 1].getColor().equals("black"))
                    {
                        canMove = true;
                        changeBoard1(theX,theY,-1,+1);
                        break;
                    }
                    x--;
                    y++;
                }
            }
            x = theX;
            y = theY;
            if (y!=0 && boardGame[x][y - 1].getColor().equals("white"))
            {
                y--;
                while (y - 1 >= 0) {
                    if (boardGame[x][y - 1].getColor().equals("black"))
                    {
                        canMove = true;
                        changeBoard1(theX,theY,0,-1);
                        break;
                    }
                    y--;
                }
            }
            x = theX;
            y = theY;
            if (y!=7 && boardGame[x][y + 1].getColor().equals("white"))
            {
                y++;
                while (y + 1 <= 7) {
                    if (boardGame[x][y + 1].getColor().equals("black"))
                    {
                        canMove = true;
                        changeBoard1(theX,theY,0,+1);
                        break;
                    }
                    y++;
                }
            }
            x = theX;
            y = theY;
            if (x!=7 && y!=0 && boardGame[x + 1][y - 1].getColor().equals("white"))
            {
                x++;
                y--;
                while (x + 1 <= 7 && y - 1 >= 0) {
                    if (boardGame[x + 1][y - 1].getColor().equals("black"))
                    {
                        canMove = true;
                        changeBoard1(theX,theY,+1,-1);
                        break;
                    }
                    x++;
                    y--;
                }
            }
            x = theX;
            y = theY;
            if (x!=7 && boardGame[x + 1][y].getColor().equals("white"))
            {
                x++;
                while (x + 1 <= 7) {
                    if (boardGame[x + 1][y].getColor().equals("black"))
                    {
                        canMove = true;
                        changeBoard1(theX,theY,+1,0);
                        break;
                    }
                    x++;
                }
            }
            x = theX;
            y = theY;
            if (x!=7 && y!=7 && boardGame[x + 1][y + 1].getColor().equals("white"))
            {
                x++;
                y++;
                while (x + 1 <= 7 && y + 1 <= 7) {
                    if (boardGame[x + 1][y + 1].getColor().equals("black"))
                    {
                        canMove = true;
                        changeBoard1(theX,theY,+1,+1);
                        break;
                    }
                    x++;
                    y++;
                }
            }
        }
        x = theX;
        y = theY;
        if(player.equals("white"))
        {
            if (x!=0 && y!=0 && boardGame[x-1][y-1].getColor().equals("black"))
            {
                while (x-1>=0 && y-1>=0)
                {
                    if (boardGame[x-1][y-1].getColor().equals("white"))
                    {
                        canMove = true;
                        changeBoard2(theX,theY,-1,-1);
                        break;
                    }
                    x--;
                    y--;
                }
            }
            x = theX;
            y = theY;
            if (x!=0 && boardGame[x-1][y].getColor().equals("black"))
            {
                x--;
                while (x-1>=0)
                {
                    if (boardGame[x-1][y].getColor().equals("white"))
                    {
                        canMove = true;
                        changeBoard2(theX,theY,-1,0);
                        break;
                    }
                    x--;
                }
            }
            x = theX;
            y = theY;
            if (x!=0 && y!=7 && boardGame[x-1][y+1].getColor().equals("black"))
            {
                x--;
                y++;
                while (x-1>=0 && y+1<=7)
                {
                    if (boardGame[x-1][y+1].getColor().equals("white"))
                    {
                        canMove = true;
                        changeBoard2(theX,theY,-1,+1);
                        break;
                    }
                    x--;
                    y++;
                }
            }
            x = theX;
            y = theY;
            if (y!=0 && boardGame[x][y-1].getColor().equals("black"))
            {
                y--;
                while (y-1>=0)
                {
                    if (boardGame[x][y-1].getColor().equals("white"))
                    {
                        canMove = true;
                        changeBoard2(theX,theY,0,-1);
                        break;
                    }
                    y--;
                }
            }
            x = theX;
            y = theY;
            if (y!=7 && boardGame[x][y+1].getColor().equals("black"))
            {
                y++;
                while (y+1<=7)
                {
                    if (boardGame[x][y+1].getColor().equals("white"))
                    {
                        canMove = true;
                        changeBoard2(theX,theY,0,+1);
                        break;
                    }
                    y++;
                }
            }
            x = theX;
            y = theY;
            if (x!=7 && y!=0 && boardGame[x+1][y-1].getColor().equals("black"))
            {
                x++;
                y--;
                while (x+1<=7 && y-1>=0)
                {
                    if (boardGame[x+1][y-1].getColor().equals("white"))
                    {
                        canMove = true;
                        changeBoard2(theX,theY,+1,-1);
                        break;
                    }
                    x++;
                    y--;
                }
            }
            x = theX;
            y = theY;
            if (x!=7 && boardGame[x+1][y].getColor().equals("black"))
            {
                x++;
                while (x+1<=7)
                {
                    if (boardGame[x+1][y].getColor().equals("white"))
                    {
                        canMove = true;
                        changeBoard2(theX,theY,+1,0);
                        break;
                    }
                    x++;
                }
            }
            x = theX;
            y = theY;
            if (x!=7 && y!= 7 && boardGame[x+1][y+1].getColor().equals("black"))
            {
                x++;
                y++;
                while (x + 1 <= 7 && y + 1 <= 7)
                {
                    if (boardGame[x + 1][y + 1].getColor().equals("white"))
                    {
                        canMove = true;
                        changeBoard2(theX,theY,+1,+1);
                        break;
                    }
                    x++;
                    y++;
                }
            }
        }
        //updating the board after a move
        if (canMove && player.equals("black"))
        {
            boardGame[theX][theY].setColor("black");
        }
        if (canMove && player.equals("white"))
        {
            boardGame[theX][theY].setColor("white");
        }
        if (!canMove)
        {
            System.out.println("Wrong Move!");
        }
        printBoard();
        endGame();
    }

    /**
     * this method prints the board
     */
    public void printBoard()
    {
        System.out.println("------------------------------------------");
        System.out.println("*| A  | B  | C  | D  | E  | F  | G  | H  |");
        for (int i=0; i<8; i++)
        {
            System.out.println("------------------------------------------");
            System.out.print(i+1);
            for (int j=0; j<8; j++)
            {
                switch (boardGame[i][j].getColor())
                {
                    case "noColor":
                        System.out.print("|    ");
                        break;
                    case "black":
                        System.out.print("| \u25EF ");
                        break;
                    case "white":
                        System.out.print("| \u2B24 ");
                        break;
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    /**
     * this method checks if the game has ended or not
     * and then it prints the result
     *
     * @return a boolean which shows if the game has ended or not
     */
    public boolean endGame()
    {
        boolean theEnd = true;
        boolean end = false;
        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                if (boardGame[i][j].getColor().equals("noColor"))
                {
                    end = true;
                    break;
                }
            }
        }
        if (!end)
        {
            int blackNum = 0, whiteNum = 0;
            System.out.println("Game Finished!");
            for (int i=0; i<8; i++)
            {
                for (int j=0; j<8; j++)
                {
                    if (boardGame[i][j].getColor().equals("white"))
                    {
                        whiteNum++;
                    }
                    else
                    {
                        blackNum++;
                    }
                }
            }
            theEnd = false;
            if (blackNum > whiteNum)
            {
                System.out.println("Number Of Black Disks: "+blackNum);
                System.out.println("Number Of White Disks: "+whiteNum);
                System.out.println("The Winner Is Black=))");
            }
            else if (whiteNum > blackNum)
            {
                System.out.println("Number Of Black Disks: "+blackNum);
                System.out.println("Number Of White Disks: "+whiteNum);
                System.out.println("The Winner Is White=))");
            }
            else {
                System.out.println("Number Of Black Disks: "+blackNum);
                System.out.println("Number Of White Disks: "+whiteNum);
                System.out.println("It Is a Tie=))");
            }
        }
        return theEnd;
    }

    /**
     * this method changes the board for the valid move (black player)
     * @param x is the valid row coordinate the player wants to put disk in there
     * @param y is the valid column coordinate the player wants to put disk in there
     * @param i is row the extension (the disks in between) that have to change
     * @param j is column the extension (the disks in between) that have to change
     */
    public void changeBoard1(int x, int y, int i, int j)
    {
        x = x + i;
        y = y + j;
        while (boardGame[x][y].getColor().equals("white"))
        {
            boardGame[x][y].setColor("black");
            x = x + i;
            y = y + j;
        }
    }

    /**
     * this method changes the board for the valid move (white player)
     * @param x is the valid row coordinate the player wants to put disk in there
     * @param y is the valid column coordinate the player wants to put disk in there
     * @param i is row the extension (the disks in between) that have to change
     * @param j is column the extension (the disks in between) that have to change
     */
    public void changeBoard2(int x, int y, int i, int j)
    {
        x = x + i;
        y = y + j;
        while (boardGame[x][y].getColor().equals("black"))
        {
            boardGame[x][y].setColor("white");
            x = x + i;
            y = y + j;
        }
    }
}

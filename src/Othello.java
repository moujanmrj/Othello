import java.util.*;

/**
 * this class is the main and it implements the whole game
 *
 * @author Moujan Mirjalili
 * @version 2020
 */
public class Othello
{
    //the main
    public static void main(String[] args)
    {
        //this is the board we want to play in
        Board game = new Board();
       //this is the black player
        Player blackPlayer = new Player("black", game);
        //this is the white player
        Player whitePlayer = new Player("white", game);

        //the game starts from here and ends when the board is full and then prints the result
        while (game.endGame())
        {
            Scanner scanMove = new Scanner(System.in);

            //scanning the move we want to play(black player)
            System.out.println("Black Turn");
            String moveBlack = scanMove.nextLine();
            while (moveBlack.length() < 2)
            {
                moveBlack = scanMove.nextLine();
            }
            blackPlayer.checkCoordinate(moveBlack,"black",game);


            //scanning the move we want to play(white player)
            System.out.println("White Turn");
            String moveWhite = scanMove.nextLine();

            while (moveWhite.length() < 2)
            {
                moveWhite = scanMove.nextLine();
            }
            blackPlayer.checkCoordinate(moveWhite,"white",game);

        }
    }
}

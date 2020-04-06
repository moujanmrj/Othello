/**
 * this class is the player class and has 2 players (black and white)
 * and holds the board we are playing in
 *
 * @author Moujan Mirjalili
 * @version 2020
 */
public class Player
{
    //this field holds the player color
    private String playerColor;
    //this field holds the board that the players are playing in
    private Board board;

    /**
     * this method returns the player color (black or white)
     * @return player color
     */
    public String getPlayerColor() { return playerColor; }
    /**
     * this method returns the board we are playing in
     * @return the board we're playing in
     */
    public Board getBoard() { return board; }

    /**
     * this method sets the player color (black or white)
     * @param playerColor is the player color
     */
    public void setPlayerColor(String playerColor) { this.playerColor = playerColor; }
    /**
     * this method sets the board we are playing in
     * @param board the board we're playing in
     */
    public void setBoard(Board board) { this.board = board; }

    /**
     * this method is the constructor
     * it gets a player and the board it wants to play in
     * @param playerColor the player color (black or white)
     * @param board the board it wants to play in
     */
    public Player(String playerColor, Board board)
    {
        this.playerColor = playerColor;
        this.board = board;
    }

    /**
     * this method is for converting the move to actual coordinates
     * @param move is the string that shows the move
     * @param player is the payer that wants to move
     * @param board is the board we're playing in
     */
    public void checkCoordinate(String move,String player, Board board)
    {
        int x = Integer.parseInt(move.substring(0,1))-1;
        if (!(x>=0 && x<8))
        {
            System.out.println("Wrong Coordinate!Try again=))");
        }
        String theY = move.substring(2);
        int y = 0;
        switch (theY)
        {
            case "A":
                y=0;
                break;
            case "B":
                y=1;
                break;
            case "C":
                y=2;
                break;
            case "D":
                y=3;
                break;
            case "E":
                y=4;
                break;
            case "F":
                y=5;
                break;
            case "G":
                y=6;
                break;
            case "H":
                y=7;
                break;
            default:
                System.out.println("Wrong Coordinate!Try again=))");
        }
        board.checkDisk(x,y,player);
    }
}

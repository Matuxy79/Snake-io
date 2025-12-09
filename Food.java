public class Food {
    private int x;
    private int y;
    private final char symbol;
    private final int points;

    public Food(int x,int y,char symbol,int points){
        this.x=x;
        this.y=y;
        this.symbol=symbol;
        this.points=points;
    }
    public int getX(){
        return x;//get food's x value
    }
    public int getY(){
        return y;// get food's y value
    }
    public char getSymbol(){
        return symbol;
    }
    public int getPoints(){
        return points;
    }
    public void spawnFood(int maxRow, int maxCol){
        // Map uses 0-9, so generate random coordinates in that range
        x=(int) (Math.random() * maxRow);
        y=(int) (Math.random() * maxCol);
    }
}

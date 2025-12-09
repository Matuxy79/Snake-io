public class GameState {

    private final int rows;
    private final int cols;
    private final Snake snake;
    private final Food apple;
    private final Banana banana;
    private int score;
    private boolean gameOver;

    public GameState(int rows, int cols, Snake snake, Food apple, Banana banana) {
        this.rows = rows;
        this.cols = cols;
        this.snake = snake;
        this.apple = apple;
        this.banana = banana;
        this.score = 0;
        this.gameOver = false;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getApple() {
        return apple;
    }

    public Banana getBanana() {
        return banana;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}



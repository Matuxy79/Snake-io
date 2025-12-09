public final class GameConfig {

    private GameConfig() {
    }

    public static final int ROWS = 10;
    public static final int COLS = 10;
    public static final int MAX_SNAKE_LENGTH = 100;
    public static final int TICK_DELAY_MS = 500;

    public static final char SNAKE_HEAD = '$';
    public static final char SNAKE_BODY = 'o';

    public static final char APPLE_SYMBOL = '@';
    public static final char BANANA_SYMBOL = '^';

    public static final String HIGH_SCORE_FILE = "highScore.txt";
}



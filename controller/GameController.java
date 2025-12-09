public class GameController {

    private final GameState state;
    private final InputService inputService;
    private final CollisionService collisionService;
    private final FoodSpawnService foodSpawnService;
    private final ScoreService scoreService;

    public GameController(InputService inputService) {
        this.inputService = inputService;
        this.collisionService = new CollisionService();
        this.foodSpawnService = new FoodSpawnService();
        this.scoreService = new ScoreService();

        Snake snake = new Snake(5, 6);
        Food apple = new Apple(4, 7);
        Banana banana = new Banana(2, 3);
        this.state = new GameState(GameConfig.ROWS, GameConfig.COLS, snake, apple, banana);
    }

    public void start() {
        Direction lastMove = Direction.UP;
        while (!state.isGameOver()) {
            GameRenderer.clearScreen();
            GameRenderer.renderBoard(state.getSnake(), state.getApple(), state.getBanana());

            Direction maybeDir = inputService.readDirectionOrNull();
            if (maybeDir != null && maybeDir != lastMove.getOpposite()) {
                lastMove = maybeDir;
            }
            state.getSnake().move(lastMove);

            boolean wall = collisionService.checkWallCollision(state.getSnake(), state.getRows(), state.getCols());
            boolean self = collisionService.checkSelfCollision(state.getSnake());
            if (wall || self) {
                state.setGameOver(true);
                break;
            }

            if (collisionService.checkFoodCollision(state.getSnake(), state.getBanana())) {
                state.addScore(state.getBanana().getPoints());
                state.getSnake().growSnake();
                foodSpawnService.respawnFoodNotOnSnake(state.getBanana(), state.getSnake(), state.getRows(), state.getCols());
            }
            if (collisionService.checkFoodCollision(state.getSnake(), state.getApple())) {
                state.addScore(state.getApple().getPoints());
                state.getSnake().growSnake();
                foodSpawnService.respawnFoodNotOnSnake(state.getApple(), state.getSnake(), state.getRows(), state.getCols());
            }

            System.out.println();
            System.out.println("Score: " + state.getScore());

            try {
                Thread.sleep(GameConfig.TICK_DELAY_MS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Game Over!");
        scoreService.saveScore(state.getScore());
        int high = scoreService.getHighScore();
        System.out.println("High Score:" + high);
    }
}



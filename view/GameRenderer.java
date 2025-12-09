public final class GameRenderer {

    private GameRenderer() {
    }

    public static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static void renderBoard(Snake s, Food apple, Food banana) {
        int row = GameConfig.ROWS;
        int column = GameConfig.COLS;
        char snakeHead = GameConfig.SNAKE_HEAD;
        char snakeBody = GameConfig.SNAKE_BODY;

        for (int i = 0; i <= row; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i <= row - 1; i++) {
            System.out.print("|");
            for (int j = 0; j <= column - 1; j++) {
                boolean printed = false;
                if (i == s.getX(0) && j == s.getY(0)) {
                    System.out.print(snakeHead);
                    printed = true;
                } else {
                    for (int k = 1; k < s.getLength(); k++) {
                        if (i == s.getX(k) && j == s.getY(k)) {
                            System.out.print(snakeBody);
                            printed = true;
                            break;
                        }
                    }
                }
                if (!printed) {
                    if (i == apple.getX() && j == apple.getY()) {
                        System.out.print(apple.getSymbol());
                    } else if (i == banana.getX() && j == banana.getY()) {
                        System.out.print(banana.getSymbol());
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.print("|");
            System.out.println();
        }
        for (int j = 0; j <= row; j++) {
            System.out.print("-");
        }
        System.out.println();
    }
}



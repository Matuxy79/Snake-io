public final class CollisionService {

    public boolean checkWallCollision(Snake snake, int rows, int cols) {
        int headRow = snake.getX(0);
        int headCol = snake.getY(0);
        return headRow < 0 || headRow > rows - 1 || headCol < 0 || headCol > cols - 1;
    }

    public boolean checkSelfCollision(Snake snake) {
        for (int i = 1; i < snake.getLength(); i++) {
            if (snake.getX(0) == snake.getX(i) && snake.getY(0) == snake.getY(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFoodCollision(Snake snake, Food food) {
        return snake.getX(0) == food.getX() && snake.getY(0) == food.getY();
    }
}



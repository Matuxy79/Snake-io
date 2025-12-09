public final class FoodSpawnService {

    public void respawnFoodNotOnSnake(Food food, Snake snake, int rows, int cols) {
        do {
            food.spawnFood(rows, cols);
        } while (isOnSnake(food, snake));
    }

    private boolean isOnSnake(Food food, Snake snake) {
        for (int i = 0; i < snake.getLength(); i++) {
            if (food.getX() == snake.getX(i) && food.getY() == snake.getY(i)) {
                return true;
            }
        }
        return false;
    }
}



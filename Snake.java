public class Snake {

    private final Position[] body;
    private int length;

    public Snake(int headX, int headY) {
        body = new Position[100];
        body[0] = new Position(headX, headY);
        length = 1;
    }

    private void shiftBody() {
        for (int i = length - 1; i > 0; i--) {
            body[i] = body[i - 1];
        }
    }

    public void move(Direction direction) {
        shiftBody();
        Position head = body[0];
        switch (direction) {
            case UP:
                body[0] = new Position(head.getRow() - 1, head.getCol());
                break;
            case DOWN:
                body[0] = new Position(head.getRow() + 1, head.getCol());
                break;
            case LEFT:
                body[0] = new Position(head.getRow(), head.getCol() - 1);
                break;
            case RIGHT:
                body[0] = new Position(head.getRow(), head.getCol() + 1);
                break;
            default:
                throw new IllegalStateException("Unexpected direction: " + direction);
        }
    }

    // Transitional wrapper methods to preserve current callers
    public void moveUP() {
        move(Direction.UP);
    }

    public void moveDown() {
        move(Direction.DOWN);
    }

    public void moveLeft() {
        move(Direction.LEFT);
    }

    public void moveRight() {
        move(Direction.RIGHT);
    }

    public int getX(int index) {
        return body[index].getRow();
    }

    public int getY(int index) {
        return body[index].getCol();
    }

    public void growSnake() {
        if (length > 0) {
            body[length] = body[length - 1];
        }
        length++;
    }

    public int getLength() {
        return length;
    }
}


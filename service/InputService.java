import java.util.Scanner;

public final class InputService {

    private final Scanner scanner;

    public InputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean hasInput() {
        return scanner.hasNext();
    }

    public Direction readDirectionOrNull() {
        if (!scanner.hasNext()) {
            return null;
        }
        String token = scanner.next();
        return parseDirection(token);
    }

    public Direction waitForDirection() {
        while (true) {
            if (scanner.hasNext()) {
                String token = scanner.next();
                Direction direction = parseDirection(token);
                if (direction != null) {
                    return direction;
                }
            }
        }
    }

    public String readTokenOrNull() {
        if (!scanner.hasNext()) {
            return null;
        }
        return scanner.next();
    }

    public static Direction parseDirection(String token) {
        if (token == null || token.isEmpty()) {
            return null;
        }
        char c = Character.toUpperCase(token.charAt(0));
        if (c == 'W') {
            return Direction.UP;
        } else if (c == 'A') {
            return Direction.LEFT;
        } else if (c == 'S') {
            return Direction.DOWN;
        } else if (c == 'D') {
            return Direction.RIGHT;
        }
        return null;
    }
}



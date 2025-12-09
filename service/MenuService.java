public final class MenuService {

    public void showIntro(InputService input) {
        System.out.println("Hello and welcome to Snake 2D by Colby");
        System.out.println("Press ; to proceed:");
        waitForSemicolon(input);
    }

    public void showRules(InputService input) {
        System.out.println("The rules of the game are as follows:");
        System.out.println("The goal is to eat as many apples as possible to set a new high score!");
        System.out.println("The snake is not allowed to collide with the walls or itself.");
        System.out.println("There are various fruits the snake can eat all with different power ups.");
        System.out.println("The speed and size of the snake will change based on the different fruits consumed.");
        System.out.println("Press ; to proceed");
        waitForSemicolon(input);
    }

    public void showControls() {
        System.out.println("To move the snake up press W.");
        System.out.println("To move the snake left press A");
        System.out.println("To move the snake right press D");
        System.out.println("To move the snake down press S");
    }

    private void waitForSemicolon(InputService input) {
        while (true) {
            String token = input.readTokenOrNull();
            if (token != null) {
                if (";".equals(token)) {
                    return;
                }
                System.out.println("Invalid character! Press ; to proceed:");
            }
        }
    }
}



import java.util.Scanner;

public class Snake2D {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        InputService inputService = new InputService(console);
        MenuService menu = new MenuService();
        menu.showIntro(inputService);
        menu.showRules(inputService);
        menu.showControls();

        GameController controller = new GameController(inputService);
        controller.start();
    }
}











import java.io.*;
import java.util.Scanner;

public final class ScoreService {

    public void saveScore(int score) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("highScore.txt", true))) {
            pw.println(score);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getHighScore() {
        int highScore = 0;
        try (Scanner s = new Scanner(new File("highScore.txt"))) {
            while (s.hasNextInt()) {
                int temporaryScore = s.nextInt();
                if (temporaryScore > highScore) {
                    highScore = temporaryScore;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No high scores yet!");
        }
        return highScore;
    }
}



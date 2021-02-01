import java.util.*;

public class Main {
    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        Initializer initializer = new Initializer(s);
        PositionSetter positionSetter = new PositionSetter(s);
        GameManager gameManager = new GameManager(initializer,positionSetter);
        List<Tokens> tokenList = initializer.initialise(initializer.initialise());
        while(!gameManager.play(tokenList)) {
            System.out.println();
        }
    }
}
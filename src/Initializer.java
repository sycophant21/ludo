import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Initializer {
    private final Scanner scanner;
    private boolean isPlayer = false;

    public Initializer(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Tokens> initialise() {
        System.out.println("Wanna play? \"Enter Y for yes and N for no\"");
        List<Tokens> tokensList = new ArrayList<>();
        if (scanner.next().equalsIgnoreCase("Y")) {
            isPlayer = true;
            System.out.println("Choose your token ( Red(R/r), Yellow(Y/y), Green(G/g), Blue(B/b) )");
            char color = scanner.next().charAt(0);
            if (color == 'R' || color == 'r') {
                tokensList.add(new Tokens("Red"));
            } else if (color == 'Y' || color == 'y') {
                tokensList.add(new Tokens("Yellow"));
            } else if (color == 'G' || color == 'g') {
                tokensList.add(new Tokens("Green"));
            } else if (color == 'B' || color == 'b') {
                tokensList.add(new Tokens("Blue"));
            }
        }
        return tokensList;
    }

    public List<Tokens> initialise(List<Tokens> tokenList) {
        if(!tokenList.isEmpty()) {
            char color = tokenList.get(0).getColor().charAt(0);
            if (color == 'R') {
                tokenList.add(new Tokens("Yellow"));
                tokenList.add(new Tokens("Green"));
                tokenList.add(new Tokens("Blue"));

            } else if (color == 'Y') {
                tokenList.add(new Tokens("Green"));
                tokenList.add(new Tokens("Blue"));
                tokenList.add(new Tokens("Red"));
            } else if (color == 'G') {
                tokenList.add(new Tokens("Blue"));
                tokenList.add(new Tokens("Red"));
                tokenList.add(new Tokens("Yellow"));
            } else if (color == 'B') {
                tokenList.add(new Tokens("Red"));
                tokenList.add(new Tokens("Yellow"));
                tokenList.add(new Tokens("Green"));
            }
        }
        else {
            tokenList.add(new Tokens("Red"));
            tokenList.add(new Tokens("Yellow"));
            tokenList.add(new Tokens("Green"));
            tokenList.add(new Tokens("Blue"));
        }
        return tokenList;
    }

    public boolean isPlayer() {
        return isPlayer;
    }
}

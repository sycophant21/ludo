import java.util.List;

public class PrintAll {

    public static void printAll(List<Tokens> tokenList, String color) {
        System.out.println();
        for (Tokens tokens : tokenList) {
            for (Token token : tokens.getTokenSet()) {
                if (!color.equalsIgnoreCase(token.getColor())) {
                    System.out.println(token.getColor() + " " + token.getColor().toUpperCase().charAt(0) + token.getPosition());
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

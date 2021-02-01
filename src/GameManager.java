import java.util.List;

public class GameManager {
    private final Initializer initializer;
    private final PositionSetter positionSetter;

    public GameManager(Initializer initializer, PositionSetter positionSetter) {
        this.initializer = initializer;
        this.positionSetter = positionSetter;
    }


    public boolean play(List<Tokens> tokenList) {
        boolean winner = false;
        boolean first;
        first = initializer.isPlayer();
        for (Tokens tokens : tokenList) {
            if (first) {
                winner = checkWinner(tokenList ,checkCapture(tokens, positionSetter.setPositionByPlayer(tokens), tokenList));
                first = false;
            }
            else {
                winner = checkWinner(tokenList ,checkCapture(tokens, positionSetter.setPosition(tokens), tokenList));
            }
            if(winner) {
                break;
            }

        }
        return winner;
    }

    private Tokens checkCapture(Tokens tokens, int position, List<Tokens> tokenList) {
        for (Tokens t : tokenList) {
            if (!t.equals(tokens)) {
                if (t.checkTokenCapture(tokens.getColor().charAt(0), position)) {
                    checkCapture(tokens, positionSetter.setPosition(tokens), tokenList);
                    break;
                }
            }
        }
        return tokens;
    }

    private boolean checkWinner(List<Tokens> tokensList, Tokens tokens) {
        if (tokens.checkWinner()) {
            PrintAll.printAll(tokensList, tokens.getColor());
            System.out.println(tokens.getColor() + " Wins");
            return true;
        }
        else {
            return false;
        }
    }
}

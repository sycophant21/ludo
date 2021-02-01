import java.util.List;
import java.util.Scanner;

public class PositionSetter {

    private final Scanner s;

    public PositionSetter(Scanner s) {
        this.s = s;
    }

    public int setPositionByPlayer(Tokens tokens) {
        int diceRoll = Dice.rollDice();
        System.out.println("dice roll = " + diceRoll);
        if (tokens.getTokensOut().size() == 1 && diceRoll < 6) {
            return tokens.setPositionOfToken(getIndex(tokens.getTokensOut().get(0).getColor()), diceRoll);
        }
        else {
            if (tokens.getTokensOut().size() > 1 && diceRoll < 6) {
                List<Token> tokenList = tokens.getTokensOut();
                System.out.println(tokenList);
                System.out.println("Choose token to Move, Only enter the index not the whole name");
                return tokens.setPositionOfToken(getIndex(tokenList.get(s.nextInt()-1).getColor()), diceRoll);
            }
            else if (tokens.getTokensOut().size() > 1 && diceRoll > 6 || (tokens.getTokensOut().size() == 1 && diceRoll > 6)) {
                System.out.println(tokens.getTokenSet());
                System.out.println("Choose token to Move, Only enter the index not the whole name");
                return tokens.setPositionOfToken(s.nextInt(), diceRoll);
            }
            else {
                if (tokens.getTokensOut().size() == 0 && diceRoll < 6) {
                    System.out.println("Dice roll less than 6, can't move any token");
                }
                else if (tokens.getTokensOut().size() == 0 && diceRoll > 6) {
                    return tokens.setPositionOfToken(ChooseToken.chooseTokenNumber(4), diceRoll);
                }
            }
        }
        return -1;
    }

    public int getIndex(String name) {
        return Integer.parseInt(name.substring(name.length()-1));
    }


    public int setPosition(Tokens tokens) {
        int diceRoll = Dice.rollDice();
        int size = tokens.getTokensOut().size();
        if (size > 0 && size < 4 && diceRoll < 6) {
            return tokenToMove(tokens, diceRoll);
        }
        else {
            return tokens.setPositionOfToken(ChooseToken.chooseTokenNumber(4), diceRoll);
        }
    }

    public int tokenToMove(Tokens tokens, int diceRoll) {
        List<Token> tokenList = tokens.getTokensOut();
        int index = ChooseToken.chooseTokenNumber(tokenList.size());
        Token token = tokenList.get(index - 1);
        return tokens.setPositionOfToken(Integer.parseInt(token.getColor().substring(token.getColor().length() - 1)), diceRoll);
    }
}

import java.util.*;

public class Tokens {
    private final List<Token> tokenSet;
    private final List<Token> tokensOut;
    private int counter = 0;
    private final String color;

    public Tokens(String color) {
        this.tokenSet = new ArrayList<>();
        this.tokensOut = new ArrayList<>();
        this.color = color;
        this.addToGame(color);
    }

    private void addToGame(String color) {
        for (int i = 1; i <= 4; i++) {
            tokenSet.add(new Token(color + i));
        }
    }

    public String getColor() {
        return color;
    }

    public boolean checkWinner() {
        return counter == 4;
    }

    public int setPositionOfToken(int index, int diceRoll) {
        index = indexChecker(index);
        int existingPosition = tokenSet.get(index - 1).getPosition();
        if (existingPosition + diceRoll <= 52) {
            int newPosition = PositionCalculatorHelper.positionCalculator(existingPosition, diceRoll);
            if (existingPosition != newPosition) {
                if (existingPosition == -1) {
                    tokensOut.add(tokenSet.get(index-1));
                }
                tokenSet.get(index - 1).setPosition(newPosition, diceRoll);
                if (newPosition == 52) {
                    counter++;
                    tokenSet.remove(index - 1);
                    return 0;
                }
            }
            else {
                System.out.println("Token " + tokenSet.get(index - 1).getColor() + " is still inside safe house, dice roll = " + diceRoll);
            }
            return newPosition;
        } else {
            if (diceRoll > 6) {
                while (diceRoll > 6) {
                    System.out.print(6 + " + ");
                    diceRoll -= 6;
                }
            }
            System.out.println(diceRoll + " Skipping turns" + " " + color + index + " at " + existingPosition);
        }
        return 0;
    }

    public boolean checkTokenCapture(char color , int position) {
        for (Token token : this.tokenSet) {
            if (position > 0) {
                if (ifCapture(token, color, position)) {
                    if (token.getPosition() > 0) {
                        token.setPosition(-1, -1);
                        tokensOut.remove(token);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean ifCapture(Token token, char tokenColor, int position) {
        Relationship relationship = RelationshipManager.getRelationship(getColor().toUpperCase().charAt(0), tokenColor);
        if (relationship == Relationship.LEFT) {
            if (position >= 39) {
                return token.getPosition() == position - 39;
            }
            else {
                return token.getPosition() == position + 13;
            }
        }
        else if (relationship == Relationship.RIGHT) {
            if (position >= 13) {
                return token.getPosition() == position - 13;
            }
            else {
                return token.getPosition() == position + 39;
            }
        }
        else if (relationship == Relationship.OPPOSITE) {
            if (position >= 26) {
                return token.getPosition() == position + 26;
            }
            else {
                return token.getPosition() == position - 26;
            }
        }
        else {
            return false;
        }
    }

    private int indexChecker(int index) {
        while (index > tokenSet.size()) {
            index--;
        }
        return index;
    }

    public List<Token> getTokenSet() {
        return tokenSet;
    }

    public List<Token> getTokensOut() {
        return tokensOut;
    }
}

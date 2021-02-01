public class Token {
    private final String color;
    private int currentPosition = -1;
    Token(String color) {
        this.color = color;
    }

    public int getPosition() {
        return currentPosition;
    }

    public void setPosition(int newPosition, int diceRoll) {
        if (diceRoll > 6) {
            while (diceRoll > 6) {
                System.out.print(6 + " + ");
                diceRoll -= 6;
            }
            System.out.println(diceRoll + " " + this.getColor() + " " + this.getColor().toUpperCase().charAt(0) + this.getPosition() + " to " + this.getColor().toUpperCase().charAt(0) + newPosition);
        }
        else if (diceRoll > 0 && diceRoll < 6){
            System.out.println(diceRoll + " " + this.getColor() + " " + this.getColor().toUpperCase().charAt(0) + this.getPosition() + " to " + this.getColor().toUpperCase().charAt(0) + newPosition);
        }
        else {
            System.out.println(diceRoll + " " + this.getColor() + " " + this.getColor().toUpperCase().charAt(0) + this.getPosition() + " to " + this.getColor().toUpperCase().charAt(0) + newPosition);
        }
        this.currentPosition = newPosition;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Token{" +
                "color='" + color + '\'' +
                ", currentPosition=" + currentPosition +
                '}';
    }
}

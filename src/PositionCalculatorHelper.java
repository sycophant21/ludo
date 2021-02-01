public class PositionCalculatorHelper {
    public static int positionCalculator(int existingPosition, int diceRoll) {
        if (existingPosition > 46 ) {
            if (diceRoll<=52-existingPosition) {
                return existingPosition+diceRoll;
            }
            else {
                System.out.println("Skipping Turn");
                return existingPosition;
            }
        }
        else {
            if (existingPosition == -1) {
                if (diceRoll > 6) {
                    return diceRoll - 6;
                }
                else {
                    return -1;
                }
            }
            else {
                return existingPosition + diceRoll;
            }
        }
    }
}

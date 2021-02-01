import java.util.Random;

public class Dice {
    public static int rollDice() {
         int i = (new Random().nextInt(6))+1;
         for (; ; ) {
             if (i%6 == 0 && i < 18) {
                 i = i + (new Random().nextInt(6))+1;
             }
             else {
                 if (i != 18) {
                     return i;
                 }
                 else {
                     return 0;
                 }
             }
         }
    }
}

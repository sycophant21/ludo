import java.util.Random;

public class ChooseToken {

    public static int chooseTokenNumber(int bound) {
        return (new Random().nextInt(bound))+1;
    }

}

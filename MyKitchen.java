import java.util.Scanner;
public class MyKitchen {
    public static void main(String[] args) {
        Scanner interrogator = new Scanner(System.in);
        Kettle myKettle = new Kettle();

        System.out.print("Enter the volume of water you are boiling (ml): ");
        int waterLevel = interrogator.nextInt();

        myKettle.addWater(waterLevel);
        myKettle.on();
    }
}
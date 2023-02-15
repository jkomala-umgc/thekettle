import java.util.Scanner;
public class MyKitchen {
    public static void main(String[] args) {
        Scanner interrogator = new Scanner(System.in);
        Kettle myKettle = new Kettle();
        System.out.println("The Kettle by James Komala \n CMIS 242/6981 \n 15 February 2023");

        System.out.print("Enter the volume of water you are boiling (ml): ");
        int waterLevel = interrogator.nextInt();

        myKettle.addWater(waterLevel);
        myKettle.on();
    }
}
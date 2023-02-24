import java.util.Scanner;
public class MyKitchen {
    public static void main(String[] args) {
        System.out.println("The Kettle by James Komala\nCMIS 242/6981\n25 February 2023");

        //instantiate an empty kettle at standard room temperature.
        int roomTemp = 25;
        Kettle myKettle = new Kettle(0, roomTemp);
        Scanner input = new Scanner(System.in);

        System.out.print("How much water do you want to boil?: ");
        myKettle.setWaterVolume(input.nextInt());
        myKettle.start();
        printKettleStats(myKettle);

        //Change room temp.
        roomTemp = 10;
        myKettle.setRoomTemperature(roomTemp);
        System.out.println("\nRoom temperature set to: " + roomTemp);
        myKettle.start();
        printKettleStats(myKettle);

        //Change max temperature.
        myKettle.setMaxTemperature(95);
        System.out.println("\nMax temperature set to 95.");
        myKettle.start();
        printKettleStats(myKettle);

    }

    static void printKettleStats(Kettle kettle) {
        System.out.println("\nWe just boiled " + kettle.getWaterVolume() + " ml.");
        System.out.println("Room temperature: " + kettle.getRoomTemperature() + "C");
        System.out.printf("Water temp: %.2f C\nEnergy in water: %.2f kJ\nTime taken: %ds\n",
                kettle.getWaterTemperature(),
                (kettle.getTotalSystemEnergy()/1000),
                kettle.getEstimatedTime()
        );
    }
}
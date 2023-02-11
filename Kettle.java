public class Kettle {

    // Being a kettle is harder than you thought.
    public static final int KETTLE_WATTAGE = 1800; // unit: watts
    public static final int MAX_WATER_VOLUME = 1750; // unit: milliliter
    public static final double STANDARD_HEAT_CAPACITY = 4.20;  //unit: Joules per gran by celsius
    int waterVolume = 0; // unit: milliliter

    /*
     * all temperatures are in degree celsius
     * water freezes at 0 and boils at 100.
     */
    double roomTemperature = 25.0;
    double waterTemperature = roomTemperature;

    //the water already has some kinetic energy in it!
    double totalSystemEnergy = STANDARD_HEAT_CAPACITY * waterVolume * waterTemperature; //unit: joules

    boolean kettleOn = false;


    void handleKettlePhysics() {
        System.out.println("Boiling ... please be patient");
        while (true) {
            if (kettleOn) {
                //keep adding energy until the water reaches 100 degree celsius
                if (waterTemperature < 100.0) {
                    //not all the energy from the outlet made it into the water.
                    totalSystemEnergy += (KETTLE_WATTAGE * 0.92);
                }
                else {
                    kettleOn = false;
                    System.out.println("Done! Water temperature: " + waterTemperature);
                    System.out.println("Energy in water: " + totalSystemEnergy/1000 + " kJ.");
                    return;
                }
                //water temperature is inferred from the total system energy inside the kettle
                waterTemperature = (totalSystemEnergy / waterVolume) / STANDARD_HEAT_CAPACITY;
            }

            //pause 1 second to emulate real life situation.
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("oops... something broke. it's likely your fault.");
            }
        }
    }

    void on() {
        kettleOn = true;
        handleKettlePhysics();
    }

    void addWater(int volume) {
        waterVolume += volume;
        System.out.println(volume + " ml added.");
    }
}




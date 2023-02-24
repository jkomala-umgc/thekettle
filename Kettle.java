public class Kettle {
    // Being a kettle is harder than you thought.
    public static final int KETTLE_WATTAGE = 1800; // unit: watts
    public static final int MAX_WATER_VOLUME = 1750; // unit: milliliter
    private static final double STANDARD_HEAT_CAPACITY = 4.20;  //unit: Joules per gran by celsius
    private int waterVolume; // unit: milliliter

    public Kettle(int waterVolume, double roomTemperature) {
        //check arguments before instantiation.
        if (waterVolume >= 0 && waterVolume <= MAX_WATER_VOLUME) {
            this.waterVolume = waterVolume;
        }
        else {
            throw new IllegalArgumentException("waterVolume must be positive and less than 1750 ml.");
        }

        if (roomTemperature > 0) {
            this.roomTemperature = roomTemperature;
        }
        else {
            throw new IllegalArgumentException("We haven't figured out how to make this kettle work under a subzero condition.");
        }


    }


    /*
     * all temperatures are in degree celsius
     * water freezes at 0 and boils at 100.
     */
    private double roomTemperature;
    private double waterTemperature;
    private double maxTemperature = 100.0;

    //the water already has some kinetic energy in it!
    private double totalSystemEnergy; //unit: joules

    private int estimatedTime;

    private void handleKettlePhysics() {
        System.out.println("Boiling ... ");
        while (waterTemperature < maxTemperature) {
            totalSystemEnergy += (KETTLE_WATTAGE * 0.92);
            waterTemperature = (totalSystemEnergy / waterVolume) / STANDARD_HEAT_CAPACITY;
            estimatedTime += 1;
        }


    }

    public void start() {
        //Initialize instant variables before running handleKettlePhysics.
        waterTemperature = roomTemperature;
        totalSystemEnergy = STANDARD_HEAT_CAPACITY * waterVolume * waterTemperature;
        estimatedTime = 0;
        handleKettlePhysics();
    }

    //getters
    public int getEstimatedTime() {
        return estimatedTime;
    }

    public int getWaterVolume() {
        return waterVolume;
    }

    public double getRoomTemperature() {
        return roomTemperature;
    }

    public double getWaterTemperature() {
        return waterTemperature;
    }

    public double getTotalSystemEnergy() {
        return totalSystemEnergy;
    }

    //setters
    public void setMaxTemperature(double maxTemperature) {
        if (maxTemperature > 100) {
            throw new IllegalArgumentException("I can only go as high as 100.");
        }
        if (maxTemperature < 50) {
            throw new IllegalArgumentException("Minimum temperature is 50");
        }

        this.maxTemperature = maxTemperature;
    }

    public void setWaterVolume(int waterVolume) {
        if (waterVolume < 100) {
            throw new IllegalArgumentException("You must add at least 100 ml.");
        }
        if (waterVolume > MAX_WATER_VOLUME) {
            throw new IllegalArgumentException("This kettle can only hold up to " + MAX_WATER_VOLUME);
        }
        this.waterVolume = waterVolume;
    }

    public void setRoomTemperature(double roomTemperature) {
        this.roomTemperature = roomTemperature;
    }
}




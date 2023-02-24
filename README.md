# thekettle 
A simulation of the electric kettle. <br/>
<img width="508" alt="Screenshot_20230215_070431" src="https://user-images.githubusercontent.com/76917080/219023904-a7689640-f9b3-4c10-a535-533613f38046.png"> 
## Inputs:
- Integer: Water volume (in ml).
- Integer: Room temperature (in degree Celsius).
- Double: Max temperature (in degree Celsius).

## Output: 
- Water temperature (in degree Celsius)
- Room temperature (in degree Celsius)
- Energy in water (in kilojoule)
- Time taken (s).
- Water volume (ml).
- 


## How to run:
`$ javac MyKettle.java` <br />
`$ java MyKettle`

## How to use:
Just add water and turn it on. `myKettle.start()`

## How does it work:
A kettle is a kitchen appliance that dumps as much energy into a volume of water as quickly as possible. This particular kettle is rated for 1800 watts, but because some heat can escape through the wall of the container, it can only push 92% of that energy into the water (See Kettle.java, line 29). In this program, we infer the water temperature by calculating the amount of energy added to the water. The kettle shuts off when the water reaches 100°C. 

How Electric Kettles Work: <https://www.explainthatstuff.com/how-electric-kettles-work.html>

Why don’t Americans use electric kettles: <https://www.youtube.com/watch?v=_yMMTVVJI4c>



# mars-rover-java
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to sen. back to Earth.

## Quick start

1. Download and install [gradle](http://gradle.org/gradle-download/).
2. Go to the root of the project and type `gradle build`. This will build the project.
3. In order to run the project, go to the root of the project and type `java -jar build/libs/mars-rover-java.jar`.

The program expects input as follows:

```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0. The following input is information pertaining to the rovers that have been deployed, wich gives the rover's position, wich is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation. The second line is a series of instructions telling the rover how to explore the plateau and it expects an array of characters, where each character is a command for the robot. 'L' means "turn left", 'R' means "turn right" and 'M' means "move one step towards your direction".

PS: In this solution, if you type 'q' in the deploy of the rovers will stop the execution.

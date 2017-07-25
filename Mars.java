import java.util.InputMismatchException;
import java.util.Scanner;

public class Mars {

    private static int marsMaxX;
    private static int marsMaxY;

    private static void checkNegativeValues(int coordinateX, int coordinateY){
        if(coordinateX < 0 || coordinateY < 0){
            throw new InputMismatchException("Coordinates must be positive!");
        }
    }

    private static void checkMaxValues(int roverposX, int roverposY){
        if(roverposX > marsMaxX || roverposY > marsMaxY){
            throw new InputMismatchException("Rover coordinates must be in range of Nasa's research field in Mars!");
        }
    }

    public static void main(String args[]){

        Scanner readData = new Scanner(System.in);

        String numbers[] = readData.nextLine().split(" ");
        marsMaxX = Integer.parseInt(numbers[0]);
        marsMaxY = Integer.parseInt(numbers[1]);
        checkNegativeValues(marsMaxX, marsMaxY);

        System.out.println("Type q to quit");
        while(!readData.hasNext("q")){
            String roverInitializer[] = readData.nextLine().toUpperCase().split(" ");
            Rover nasaRover = new Rover(Integer.parseInt(roverInitializer[0]), Integer.parseInt(roverInitializer[1]), roverInitializer[2].charAt(0));
            checkNegativeValues(Integer.parseInt(roverInitializer[0]), Integer.parseInt(roverInitializer[1]));
            checkMaxValues(Integer.parseInt(roverInitializer[0]), Integer.parseInt(roverInitializer[1]));
            String commands = readData.nextLine().toUpperCase();
            for(char command : commands.toCharArray()){
                switch (command){
                    case 'L':
                        nasaRover.changeDirection('L');
                        break;
                    case 'R':
                        nasaRover.changeDirection('R');
                        break;
                    case 'M':
                        if(nasaRover.canMove(marsMaxX, marsMaxY)) nasaRover.moveAhead();
                        break;
                    default:
                        System.out.println("Quiting...");
                        System.exit(1);
                }
            }
            System.out.println(nasaRover.getActualX() + " " + nasaRover.getActualY() + " " + nasaRover.getFacingDirection());
        }
        System.out.println("Quiting...");
        System.exit(1);
    }

}

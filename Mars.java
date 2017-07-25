import java.util.Scanner;

public class Mars {

    static int marsMaxX;
    static int marsMaxY;

    public static void main(String args[]){

        Scanner readData = new Scanner(System.in);

        String numbers[] = readData.nextLine().split(" ");
        marsMaxX = Integer.parseInt(numbers[0]);
        marsMaxY = Integer.parseInt(numbers[1]);

        System.out.println("Type q to quit");
        while(!readData.hasNext("q")){
            String roverInitializer[] = readData.nextLine().split(" ");
            Rover nasaRover = new Rover(Integer.parseInt(roverInitializer[0]), Integer.parseInt(roverInitializer[1]), roverInitializer[2].charAt(0));
            String commands = readData.nextLine();
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

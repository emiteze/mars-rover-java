package src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Rover {

    private int actualX;
    private int actualY;
    private char facingDirection;
    private Set<Character> validDirections;

    public int getActualX() {
        return actualX;
    }

    public void setActualX(int actualX) {
        this.actualX = actualX;
    }

    public int getActualY() {
        return actualY;
    }

    public void setActualY(int actualY) {
        this.actualY = actualY;
    }

    public Rover(int actualX, int actualY, char facingDirection){
        this.actualX = actualX;
        this.actualY = actualY;
        this.facingDirection = facingDirection;
        validDirections = new HashSet<Character>(Arrays.<Character>asList('N', 'S', 'W', 'E'));
    }

    public void setActualLocation(int actualX, int actualY){
        this.actualX = actualX;
        this.actualY = actualY;
    }

    public char getFacingDirection(){
        return this.facingDirection;
    }

    public void setFacingDirection(char direction){
        if(validDirections.contains(direction)){
            this.facingDirection = direction;
        }
    }

    public void changeDirection(char rotateDegrees){
        if(rotateDegrees == 'L' || rotateDegrees == 'R'){
            switch(facingDirection){
                case 'N':
                    if(rotateDegrees == 'L'){
                        setFacingDirection('W');
                    } else {
                        setFacingDirection('E');
                    }
                    break;
                case 'W':
                    if(rotateDegrees == 'L'){
                        setFacingDirection('S');
                    } else {
                        setFacingDirection('N');
                    }
                    break;
                case 'E':
                    if(rotateDegrees == 'L'){
                        setFacingDirection('N');
                    } else {
                        setFacingDirection('S');
                    }
                    break;
                case 'S':
                    if(rotateDegrees == 'L'){
                        setFacingDirection('E');
                    } else {
                        setFacingDirection('W');
                    }
                    break;
            }
        }
    }

    public boolean canMove(int marsMaxX, int marsMaxY){
        switch(facingDirection){
            case 'N':
                return this.actualY < marsMaxY;
            case 'W':
                return this.actualX > 0;
            case 'E':
                return this.actualX < marsMaxX;
            case 'S':
                return this.actualY > 0;
        }
        return false;
    }

    public void moveAhead(){
        switch(facingDirection){
            case 'N':
                this.actualY += 1;
                break;
            case 'W':
                this.actualX += -1;
                break;
            case 'E':
                this.actualX += 1;
                break;
            case 'S':
                this.actualY += -1;
                break;
        }
    }

}

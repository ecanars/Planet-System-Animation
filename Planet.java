import javax.swing.*;
import java.awt.*;

/**
 * Planet
 */
public class Planet {

    //attributes of a planet
    
    private String name;
    private int pos_x;
    private int pos_y;
    private double pos_angle;
    private double angularSpeed;
    private double orbitMaxRadius;
    private double orbitMinRadius;
    private double planetDiameter;
    private Color planetColor;
    private static int center_x = 440;
    private static int center_y = 370;

    //getter setter
    public String getName() {
        return name;
    }
    public int getCenter_x() {
        return center_x;
    }
    public int getCenter_y() {
        return center_y;
    }
    public double getAngularSpeed() {
        return angularSpeed;
    }
    public double getOrbitMaxRadius() {
        return orbitMaxRadius;
    }
    public double getOrbitMinRadius() {
        return orbitMinRadius;
    }
    public double getPlanetDiameter() {
        return planetDiameter;
    }
    public double getPos_angle() {
        return pos_angle;
    }
    public int getPos_x() {
        return pos_x;
    }
    public int getPos_y() {
        return pos_y;
    }
    public Color getPlanetColor() {
        return planetColor;
    }
    
    public void setAngularSpeed(double angularSpeed) {
        this.angularSpeed = angularSpeed;
    }
    public void setOrbitMaxRadius(double orbitMaxRadius) {
        this.orbitMaxRadius = orbitMaxRadius;
    }
    public void setOrbitMinRadius(double orbitMinRadius) {
        this.orbitMinRadius = orbitMinRadius;
    }
    public void setPlanetDiameter(double planetDiameter) {
        this.planetDiameter = planetDiameter;
    }
    public void setPos_angle(double pos_angle) {
        this.pos_angle = pos_angle;
    }
    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }
    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }
    public void setPlanetColor(Color planetColor) {
        this.planetColor = planetColor;
    }

    //constructor

    public Planet( double angularSpeed,double orbitMaxRadius,double orbitMinRadius, double planetDiameter, double positionAngle){
        
        
        this.angularSpeed = angularSpeed; // saniyede bu kadar açı dönecek
        this.orbitMaxRadius = orbitMaxRadius;
        this.orbitMinRadius = orbitMinRadius;
        this.planetDiameter = planetDiameter;
        this.setPosition(positionAngle);
        
    }

    public Planet( double angularSpeed,double orbitMaxRadius,double orbitMinRadius, double planetDiameter, double positionAngle , String color){
        
       
        this.angularSpeed = angularSpeed; // saniyede bu kadar açı dönecek
        this.orbitMaxRadius = orbitMaxRadius;
        this.orbitMinRadius = orbitMinRadius;
        this.planetDiameter = planetDiameter;
        this.setPosition(positionAngle);

        if(color.equalsIgnoreCase("Blue")){
            this.planetColor = Color.BLUE ;
        } 
        if(color.equalsIgnoreCase("Red")){
            this.planetColor = Color.RED ;
        } 
        if(color.equalsIgnoreCase("Yellow")){
            this.planetColor = Color.YELLOW ;
        } 
        if(color.equalsIgnoreCase("Green")){
            this.planetColor = Color.GREEN ;
        } 
        if(color.equalsIgnoreCase("Grey")){
            this.planetColor = Color.GRAY ;
        } 
        if(color.equalsIgnoreCase("Pink")){
            this.planetColor = Color.PINK ;
        } 
    }

    public Planet( String name){
        this. name = name;
       
        

        
    }
    
    //methods

    public void setPosition(double Angle){

        this.pos_angle = Angle;
        double radian = Math.toRadians(Angle);
        
        double cosOfAngle = Math.cos(radian);
        double sinOfAngle = Math.sin(radian);
       
        this.pos_x = Math.round((float)(orbitMaxRadius*cosOfAngle));
        this.pos_y = Math.round((float)(orbitMinRadius*sinOfAngle));

    }



   

    
  
    

    
   


}
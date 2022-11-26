import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlanetComponent extends JComponent {

    public static ArrayList<Planet> planetList = new ArrayList<>();

    

   
    public void paintComponent(Graphics g){
        
        g.setColor(Color.YELLOW);
        g.fillOval(340, 270, 100, 100);
        
        for(Planet p : planetList){

            g.setColor(Color.GRAY);
            g.drawOval(390 - (int )p.getOrbitMaxRadius(), 320 - (int) p.getOrbitMinRadius(), (int)(p.getOrbitMaxRadius()*2), (int) (p.getOrbitMinRadius()*2));
                
            g.setColor(p.getPlanetColor());
            g.fillOval(p.getPos_x() + 390 - (int) p.getPlanetDiameter()/2, p.getPos_y() + 320 - (int) p.getPlanetDiameter()/2, (int)p.getPlanetDiameter(), (int)p.getPlanetDiameter()); 

            
        }
    }

    public void append(Planet planet){
        planetList.add(planet);
        repaint();
    }

    public void clear(){
        planetList.clear();
        repaint();
    }

    public void updateAngles(){
    
        for(Planet p : planetList  ){
            double nextAngle = p.getPos_angle() + p.getAngularSpeed()/25;
            p.setPosition(nextAngle);
        }
        repaint(); 
    }

    public void updateAnglesReverse(){
    
        for(Planet p : planetList  ){
            double nextAngle = p.getPos_angle() - p.getAngularSpeed()/25;
            p.setPosition(nextAngle);
        }
        repaint(); 
    }
}

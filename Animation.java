import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class test {
    
    public static JComponent planetsComponent;

    
    
    public static void main(String[] args) {
       
        
        //create frame
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
       
        
        //create panels
        
        JPanel addPlanetPanel = new JPanel();
        
        //create buttons panel at north

        JPanel buttons = new JPanel();
        JButton startButton = new JButton("START");
        JButton stopButton = new JButton("STOP");
        JButton reverseButton = new JButton ("REWIND");
        JButton clearButton = new JButton("CLEAR PLANETS");

        





        //organise add planet panel
        addPlanetPanel.setLayout(new BorderLayout());

        // new panel that will be inside of add planet panel 

            

            JPanel planetFeaturesPanel = new JPanel();
            planetFeaturesPanel.setLayout(new GridLayout(6,2));

            JTextField angularSpeedTField = new JTextField(5);
            JLabel angularSpeedLabel = new JLabel("Angular Speed");
            angularSpeedTField.setText("0");
            planetFeaturesPanel.add(angularSpeedTField);
            planetFeaturesPanel.add(angularSpeedLabel);

            JTextField maxRadiusTField = new JTextField(5);
            JLabel maxRadiusLabel = new JLabel("Orbit Max Radius");
            maxRadiusTField.setText("0");
            planetFeaturesPanel.add(maxRadiusTField);
            planetFeaturesPanel.add(maxRadiusLabel);

            JTextField minRadiusTField = new JTextField(5);
            JLabel minRadiusLabel = new JLabel("Orbit Min Radius");
            minRadiusTField.setText("0");
            planetFeaturesPanel.add(minRadiusTField);
            planetFeaturesPanel.add(minRadiusLabel);

            JTextField planetRadiusTField = new JTextField(5);
            JLabel planetRadiusLabel = new JLabel("Planet Diameter");
            planetRadiusTField.setText("0");
            planetFeaturesPanel.add(planetRadiusTField);
            planetFeaturesPanel.add(planetRadiusLabel);

            JTextField angleTField = new JTextField(5);
            JLabel angleLabel = new JLabel("Angle");
            angleTField.setText("0");
            planetFeaturesPanel.add(angleTField);
            planetFeaturesPanel.add(angleLabel);

            JComboBox planetColorComboBox = new JComboBox();
            JLabel colorLabel = new JLabel("Color");

            planetColorComboBox.addItem("Blue");
            planetColorComboBox.addItem("Red");
            planetColorComboBox.addItem("Yellow");
            planetColorComboBox.addItem("Green");
            planetColorComboBox.addItem("Grey");
            planetColorComboBox.addItem("Pink");

            planetFeaturesPanel.add(planetColorComboBox);
            planetFeaturesPanel.add(colorLabel);

            class AddPlanetListener implements ActionListener{

                
                
                
                @Override
                public void actionPerformed(ActionEvent e) {

                    double AS = Double.parseDouble(angularSpeedTField.getText());
                double MaxR = Double.parseDouble(maxRadiusTField.getText());
                double MinR = Double.parseDouble(minRadiusTField.getText()) ;
                double PR = Double.parseDouble(planetRadiusTField.getText()) ;
                double ANGLE = Double.parseDouble(angleTField.getText());
                String color = (String) planetColorComboBox.getSelectedItem();
                
                    ((PlanetComponent)planetsComponent).append(new Planet(AS,MaxR,MinR,PR,ANGLE,color));
                }


                
            }
            

        //add another panel to the add planet panel for add planet button

            JPanel addPlanetButtonPanel = new JPanel();
            JButton addPlanetButton = new JButton("Add Planet");

            AddPlanetListener addPlanetListener = new AddPlanetListener();
            addPlanetButton.addActionListener(addPlanetListener);
            
            addPlanetButtonPanel.add(addPlanetButton);
            addPlanetPanel.add(addPlanetButtonPanel);

            

          
 
        //add these two to the add planet panel

            addPlanetPanel.add(planetFeaturesPanel , BorderLayout.CENTER);
            addPlanetPanel.add(addPlanetButtonPanel , BorderLayout.SOUTH);
        
       
            
          
            
            
            

        //create planets


            Planet mars = new Planet(1, 200, 150, 20, 60,"red");
            Planet world = new Planet(12, 300, 100, 10, 90, "blue");
            Planet jupiter = new Planet(0.3,255,190,35,125,"green");
            Planet osman = new Planet(0.9, 100, 250, 40, 93,"gray");
            
            
            
            planetsComponent = new PlanetComponent();
            
            
            PlanetComponent.planetList.add(mars);
            PlanetComponent.planetList.add(world);
            PlanetComponent.planetList.add(jupiter);
            PlanetComponent.planetList.add(osman);

            

            


            buttons.add(startButton);
            buttons.add(stopButton);
            buttons.add(reverseButton);
            buttons.add(clearButton);

            class SystemMove implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    ((PlanetComponent)planetsComponent).updateAngles();
                }
            
            }

            class SystemMoveReverse implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    ((PlanetComponent)planetsComponent).updateAnglesReverse();
                }
            
            }


            SystemMoveReverse moveReverse = new SystemMoveReverse();
            SystemMove move = new SystemMove();

            Timer movetimer = new Timer(1, move );
            Timer reverseMoveTimer = new Timer(1,moveReverse);

            class TimerStarter implements ActionListener{
	            public void actionPerformed(ActionEvent e)
	            {   
                    reverseMoveTimer.stop();
			        movetimer.start();
	            }
            }
            class TimerStopper implements ActionListener{
	            public void actionPerformed(ActionEvent e)
	            {
			        movetimer.stop();
                    reverseMoveTimer.stop();
	            }
            }
            class ReverseTimerStarter implements ActionListener{
	            public void actionPerformed(ActionEvent e)
	            {   
                    movetimer.stop();
			        reverseMoveTimer.start();
	            }
            }

            class PlanetRemover implements ActionListener{

                @Override
                public void actionPerformed(ActionEvent e) {
                    ((PlanetComponent)planetsComponent).clear();                    
                }

            }

            startButton.addActionListener(new TimerStarter());
            stopButton.addActionListener(new TimerStopper());
            reverseButton.addActionListener(new ReverseTimerStarter());
            clearButton.addActionListener(new PlanetRemover());

            
            
            
            
            

         
        //add panels AND planets to frame
            
            
            frame.add(planetsComponent ,BorderLayout.CENTER );
            
            frame.add(addPlanetPanel , BorderLayout.EAST);

            frame.add(buttons , BorderLayout.NORTH);

            
            

        //set frame visible
            frame.getContentPane().setBackground(Color.BLACK);
            frame.setSize(1000,700);
            frame.setTitle("Solar System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

          
            




    }
  

    
}

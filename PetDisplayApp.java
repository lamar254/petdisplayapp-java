import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class PetDisplayApp extends JFrame {
    private JLabel petLabel;
    private JLabel petImageLabel;
    private Map<String, ImageIcon> petImages;

    public PetDisplayApp() {
        setTitle("Pet Display App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Create radio buttons
        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");
        JRadioButton pigButton = new JRadioButton("Pig");

        // Create a button group to ensure only one radio button is selected at a time
        ButtonGroup petGroup = new ButtonGroup();
        petGroup.add(birdButton);
        petGroup.add(catButton);
        petGroup.add(dogButton);
        petGroup.add(rabbitButton);
        petGroup.add(pigButton);

        // Create a label to display the selected pet
        petLabel = new JLabel("Select a pet");
        petImageLabel = new JLabel();

        // Create a panel for radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Load pet images
        loadPetImages();

        // Add action listeners to radio buttons
        birdButton.addActionListener(new PetSelectionListener("Bird"));
        catButton.addActionListener(new PetSelectionListener("Cat"));
        dogButton.addActionListener(new PetSelectionListener("Dog"));
        rabbitButton.addActionListener(new PetSelectionListener("Rabbit"));
        pigButton.addActionListener(new PetSelectionListener("Pig"));

        // Add components to the main frame
        add(radioPanel, BorderLayout.WEST);
        add(petLabel, BorderLayout.CENTER);
        add(petImageLabel, BorderLayout.EAST);

        setVisible(true);
    }

    private void loadPetImages() {
        petImages = new HashMap<>();
        petImages.put("Bird", new ImageIcon("D:\\java\\bird.jpg")); 
        petImages.put("Cat", new ImageIcon("D:\\java\\cat.jpg"));   
        petImages.put("Dog", new ImageIcon("D:\\java\\dog.jpg"));   
        petImages.put("Rabbit", new ImageIcon("D:\\java\\rabbit.jpg")); 
        petImages.put("Pig", new ImageIcon("D:\\java\\pig.jpg"));    
    }


    private class PetSelectionListener implements ActionListener {
        private String petType;

        public PetSelectionListener(String petType) {
            this.petType = petType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            petLabel.setText("Selected pet: " + petType);
            petImageLabel.setIcon(petImages.get(petType));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetDisplayApp());
    }
}

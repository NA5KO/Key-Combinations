import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.TreeUI;
public class Fenetre extends JFrame {
    private JMenuBar jmb = new JMenuBar();
    private JMenu choix = new JMenu("Choix");
    private JMenu aide = new JMenu("Aide");
    private JMenuItem Formule1 = new JMenuItem("Formule1");
    private JMenuItem Formule2 = new JMenuItem("Formule2");
    private JMenuItem Quitter = new JMenuItem("Quitter");
    
    private JPanel page1 = new JPanel();
    private JPanel page2 = new JPanel();
    public Fenetre(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calcul de Formule ");
        this.setLocationRelativeTo(null);
        this.setSize(300,300);
        choix.add(Formule1);
        choix.add(Formule2);
        choix.addSeparator();
        choix.add(Quitter);
        jmb.add(choix);
        jmb.add(aide);
        Dimension menuBarSize = new Dimension(600, 50); 
        jmb.setPreferredSize(menuBarSize);
        this.setJMenuBar(jmb);
        this.setVisible(true);
        
        //page1 de la formule 1 
        page1.setLayout(new GridLayout(3,1,0,10));
        JLabel taiLabel = new JLabel("taille (en cm)");
        JLabel ageLabel = new JLabel("age");
        JLabel morpJLabel = new JLabel("morphologie");
        JTextField taille1  = new JTextField( 20);
        JTextField age = new JTextField(20);
        String[] morphologyStrings = {"large" , "normal" , "mince" };
        JComboBox<String> morphologie = new JComboBox<>(morphologyStrings);
        JButton calculer = new JButton("Calculer");
        JButton Effacer = new JButton("Effacer");
        JPanel ada = new JPanel(new GridLayout(3, 2, 1, 5)); // 2 rows, 2 columns, 10px horizontal and vertical gap
        ada.add(taiLabel);
        ada.add(taille1);
        ada.add(ageLabel);
        ada.add(age);
        ada.add(morpJLabel);
        ada.add(morphologie);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 0, 10)); // 1 row, 2 columns, 10px horizontal and vertical gap
        buttonPanel.add(calculer);
        buttonPanel.add(Effacer);
        JPanel labPanel = new JPanel();
        JLabel Label = new JLabel("votre poids ideal en kg est :");
        labPanel.add(Label);
        // Add components to the frame
        page1.add(ada);
        page1.add(buttonPanel);
        page1.add(labPanel);


        
        //page 2 de la formule 2 
        page2.setLayout(new BoxLayout(page2, BoxLayout.Y_AXIS));
        JPanel aha = new JPanel(new GridLayout(1,2,1,5));
        JLabel taiLabel2 = new JLabel("taille (en cm)");
        JTextField taille2  = new JTextField( 20);
        aha.add(taiLabel2);
        aha.add(taille2);
        JPanel aba = new JPanel(new GridLayout(1,3,5,5));
        JLabel sexe = new JLabel("sexe");
        JRadioButton sexe1Box = new JRadioButton("Homme");
        JRadioButton sexe2Box = new JRadioButton("Femme");
        JPanel buttonPane2 = new JPanel(new GridLayout(1, 2, 0, 10));
        JButton calculer2 = new JButton("Calculer");
        JButton Effacer2 = new JButton("Effacer");
        buttonPane2.add(calculer2);
        buttonPane2.add(Effacer2);
        aba.add(sexe);
        aba.add(sexe1Box);
        aba.add(sexe2Box);
        page2.add(aha);
        page2.add(aba);
        page2.add(buttonPane2);
        JPanel labPanel2 = new JPanel();
        JLabel Label2 = new JLabel("votre poids ideal en kg est :");
        labPanel2.add(Label2);
        page2.add(labPanel2);



        //actions

        class item1listener implements ActionListener{
            public void actionPerformed (ActionEvent e){
                System.exit(0);
            }
        }
        class item2listener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                Fenetre.this.setContentPane(page1);
                Fenetre.this.setTitle("Calcul de poids : Formule 1");
                Fenetre.this.validate();
            }
    }
        class item3listener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                Fenetre.this.setContentPane(page2);
                Fenetre.this.setTitle("Calcul de poids : Formule 2");
                Fenetre.this.validate();
            }
    }
    Effacer.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // clear the text fields and label
            taille1.setText("");
            age.setText("");
            Label.setText("votre poids ideal en kg est :");
        }
    });
    Effacer2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // clear the text fields and label
            taille1.setText("");
            age.setText("");
            Label2.setText("votre poids ideal en kg est :");
        }
    });
    
    
    calculer.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ((e.getSource() == calculer ) && Fenetre.this.getContentPane() == page1) {
                // Calculate ideal poids based on input values for formula 1
                int poids=0;
                int taille = Integer.parseInt(taille1.getText());
                int ageValue = Integer.parseInt(age.getText());
                String morphologieValue = (String) morphologie.getSelectedItem();
                if( morphologieValue == "mince"){
                    poids = (int) ((taille - 100 +ageValue/10)*0.9*0.9) ;
                }
                else if ( morphologieValue == "large"){
                    poids = (int) ((taille - 100 +ageValue/10)*0.9*1.1) ;
                }
                else if ( morphologieValue == "normal"){
                    poids = (int) ((taille - 100 +ageValue/10)*0.9) ;
                }
                Label.setText("Votre poids idéal en kg est: " + poids);
                
            }
        }
    });
    calculer2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int taille = Integer.parseInt(taille2.getText());
            int poids;
            if (sexe1Box.isSelected()) {
                poids = (int) (taille - 100 - (taille - 150) / 2.5);
            } else {
                poids = (int) ((taille - 150) -(taille - 150)/ 4.0);
            }
            Label2.setText("Votre poids idéal en kg est : " + poids);
        }
    });
    Quitter.addActionListener(new item1listener());
    Formule1.addActionListener(new item2listener());
    Formule2.addActionListener(new item3listener());
    this.setVisible(true);
    }
}

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TextField {
    public static void main(String[] args) {
        
        new MyText();
    }
}
class MyText extends JFrame implements ActionListener{

    private JTextField text;
    private JButton button;
    private JLabel label, label2;
    private ImageIcon image;
    MyText(){

        image = new ImageIcon("f1774f9d539798d9f4dd87c3c7dbea17.jpg");
        label2 = new JLabel();
        label2.setBounds(100,200,500,500);
        label2.setIcon(image);
        label2.setVisible(false);

        label = new JLabel("Enter part Name: ");
        label.setBounds(100,70,150,30);
        label.setVisible(true);

        text = new JTextField();
        text.setBounds(100,100,200,40);
        text.setVisible(true);

        button = new JButton("Submit");
        button.setBounds(150,150,70,40);
        button.addActionListener(this);
        button.setVisible(true);

        this.add(label);
        this.add(label2);
        this.add(text);
        this.add(button);

        this.setSize(1000,1000);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String part = text.getText();

        if(e.getSource() == button){
            if(part.equals("Tires")){
                label.setVisible(false);
                text.setVisible(false);
                button.setVisible(false);
                label2.setVisible(true);
            }
        }
    }
}

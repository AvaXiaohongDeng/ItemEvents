import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEvents extends JFrame implements ItemListener {
    JPanel pnl = new JPanel();
    String[] styles = {"Deep Dish","Gourmet Style","Thin&Crisp"};
    JComboBox<String> comboBox = new JComboBox<String>(styles);

    JRadioButton rad1 = new JRadioButton("White");
    JRadioButton rad2 = new JRadioButton("Red");
    ButtonGroup wines = new ButtonGroup();
    JCheckBox chk = new JCheckBox("Pepperoni");
    JTextArea txtArea = new JTextArea(5, 48);


    public ItemEvents(){
        super("Swing Window");
        setSize( 500,200 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        add(pnl);

        wines.add(rad1);
        wines.add(rad2);

        pnl.add(rad1);
        pnl.add(rad2);
        pnl.add(chk);
        pnl.add(comboBox);
        pnl.add(txtArea);

        rad1.addItemListener(this);
        rad2.addItemListener(this);
        chk.addItemListener(this);
        comboBox.addItemListener(this);

        setVisible( true );
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getItemSelectable()==rad1){
            txtArea.setText("White wine selected");
        }
        if(e.getItemSelectable()==rad2){
            txtArea.setText("Red wine selected");
        }
        if(e.getItemSelectable()==chk&&e.getStateChange()==ItemEvent.SELECTED){
            txtArea.append("\nPepperoni selected\n");
        }
        if(e.getItemSelectable()==comboBox&&e.getStateChange()==ItemEvent.SELECTED){
            txtArea.append(e.getItem().toString() + " selected");
        }
    }

    public static void main(String[] args) {
        ItemEvents gui = new ItemEvents();
    }
}

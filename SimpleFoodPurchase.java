import javax.swing.*;
import java.awt.event.*;

class Free 
{
    int iceCream;
    int milkShake;
}

class Food extends Free 
{
    int[] type;
}

class Buyer 
{
    int id;
    String name;
    String address;
    double amount;
    Food objOfFood;

    Buyer(int id, String name, String address, double amount, Food objOfFood) 
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.amount = amount;
        this.objOfFood = objOfFood;
    }
}

class MyFrame extends JFrame implements ItemListener 
{
    double amt_pay = 0;
    JLabel lblChappati;
    JLabel lblCholaPuri;
    JLabel lblPaneerButterMasala;
    JLabel lblParota;
    
    JLabel lblCusID;
    JLabel lblCusName;
    JLabel lblCusAddress;
    
    JCheckBox jcbChappati;
    JCheckBox jcbCholaPuri;
    JCheckBox jcbPaneerButterMasala;
    JCheckBox jcbParota;
    
    JTextField txtChappati;
    JTextField txtCholaPuri;
    JTextField txtPaneerButterMasala;
    JTextField txtParota;

    JTextField txtCusID;
    JTextField txtCusName;
    JTextField txtCusAddress;

    JButton btnPurchase;
    JButton btnReport;

    MyFrame() 
    {
        setVisible(true);
        setSize(600, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jcbChappati = new JCheckBox();
        jcbChappati.setBounds(50, 50, 20, 25);
        add(jcbChappati);

        lblChappati = new JLabel("Chappati (₹50)");
        lblChappati.setBounds(90, 50, 150, 25);
        add(lblChappati);

        txtChappati = new JTextField();
        txtChappati.setBounds(280, 50, 50, 20);
        add(txtChappati);
        
        jcbCholaPuri = new JCheckBox();
        jcbCholaPuri.setBounds(50, 75, 20, 25);
        add(jcbCholaPuri);
        
        lblCholaPuri = new JLabel("Chola Puri (₹60)");
        lblCholaPuri.setBounds(90, 75, 150, 25);
        add(lblCholaPuri);

        txtCholaPuri = new JTextField();
        txtCholaPuri.setBounds(280, 75, 50, 20);
        add(txtCholaPuri);
        
        jcbPaneerButterMasala = new JCheckBox();
        jcbPaneerButterMasala.setBounds(50, 100, 20, 25);
        add(jcbPaneerButterMasala);

        lblPaneerButterMasala = new JLabel("Paneer Butter Masala (₹200)");
        lblPaneerButterMasala.setBounds(90, 100, 180, 25);
        add(lblPaneerButterMasala);

        txtPaneerButterMasala = new JTextField();
        txtPaneerButterMasala.setBounds(280, 100, 50, 20);
        add(txtPaneerButterMasala);
        
        jcbParota = new JCheckBox();
        jcbParota.setBounds(50, 125, 20, 25);
        add(jcbParota);

        lblParota = new JLabel("Parota (₹100)");
        lblParota.setBounds(90, 125, 150, 25);
        add(lblParota);

        txtParota = new JTextField();
        txtParota.setBounds(280, 125, 50, 20);
        add(txtParota);

        lblCusID = new JLabel("Customer ID: ");
        lblCusID.setBounds(50, 175, 150, 25);
        add(lblCusID);

        lblCusName = new JLabel("Customer Name: ");
        lblCusName.setBounds(50, 200, 150, 25);
        add(lblCusName);

        lblCusAddress = new JLabel("Customer Address: ");
        lblCusAddress.setBounds(50, 225, 150, 25);
        add(lblCusAddress);

        txtCusID = new JTextField();
        txtCusID.setBounds(200, 175, 150, 25);
        add(txtCusID);

        txtCusName = new JTextField();
        txtCusName.setBounds(200, 200, 150, 25);
        add(txtCusName);

        txtCusAddress = new JTextField();
        txtCusAddress.setBounds(200, 225, 150, 25);
        add(txtCusAddress);

        btnPurchase = new JButton("Purchase");
        btnPurchase.setBounds(400, 75, 100, 25);

        // Corrected action listener with proper implementation
        btnPurchase.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    Food food = new Food();
                    int total = 0;
                    
                    if(jcbChappati.isSelected()) 
                    {
                        int qty = Integer.parseInt(txtChappati.getText());
                        food.iceCream = qty;
                        total += qty * 50;
                    }
                    if(jcbCholaPuri.isSelected()) 
                    {
                        int qty = Integer.parseInt(txtCholaPuri.getText());
                        food.milkShake = qty;
                        total += qty * 60;
                    }
                    if(jcbPaneerButterMasala.isSelected()) 
                    {
                        int qty = Integer.parseInt(txtPaneerButterMasala.getText());
                        food.type = new int[]{qty};
                        total += qty * 200;
                    }
                    if(jcbParota.isSelected()) 
                    {
                        int qty = Integer.parseInt(txtParota.getText());
                        food.iceCream += qty;
                        total += qty * 100;
                    }

                    JOptionPane.showMessageDialog(MyFrame.this, 
                        "Purchase Successful!\nTotal Amount: ₹" + total);

                    // Reset form
                    txtCusID.setText("");
                    txtCusName.setText("");
                    txtCusAddress.setText("");
                    txtChappati.setText("");
                    txtCholaPuri.setText("");
                    txtPaneerButterMasala.setText("");
                    txtParota.setText("");
                    jcbChappati.setSelected(false);
                    jcbCholaPuri.setSelected(false);
                    jcbPaneerButterMasala.setSelected(false);
                    jcbParota.setSelected(false);
                    
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(MyFrame.this,
                        "Invalid input! Please enter valid numbers.");
                }
            }
        });

        add(btnPurchase);

        btnReport = new JButton("Report");
        btnReport.setBounds(400, 100, 100, 25);
        add(btnReport);
    }

    public void itemStateChanged(ItemEvent ie) 
    {
        try 
        {
            if(ie.getSource() == jcbChappati)
                amt_pay += 50 * Integer.parseInt(txtChappati.getText());
            if(ie.getSource() == jcbCholaPuri)
                amt_pay += 60 * Integer.parseInt(txtCholaPuri.getText());
            if(ie.getSource() == jcbPaneerButterMasala)
                amt_pay += 200 * Integer.parseInt(txtPaneerButterMasala.getText());
            if(ie.getSource() == jcbParota)
                amt_pay += 100 * Integer.parseInt(txtParota.getText());
        } 
        catch (NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(this, "Invalid quantity value!");
        }
    }
}

class SimpleFoodPurchase 
{
    public static void main(String args[]) 
    {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}

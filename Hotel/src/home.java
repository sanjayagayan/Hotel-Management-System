
import codes.Dbconnect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;




public class home extends javax.swing.JFrame implements ActionListener{

    
    
   
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    
    public home() {
        initComponents();
        conn = Dbconnect.connect();
        tableload();
        
         
    }
    
    public void tableload()
    {
        try {
            String sql = "SELECT Customer_Ref,First_Name,Sur_Name,Address,Mobile_No,Nationality,Gender,ID_No,Check_In,Check_out,Room_No,Room_Type,Bed_Type,Rate  FROM home";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }

    
    public void update()
    {
       String ref = Reflbl.getText();
       String fname = fname_box.getText();
       String sname = sname_box.getText();
       String address = address_box.getText();
       int phone = Integer.parseInt(phone_box.getText());
       String national = national_box.getText();
       String gender = (String) sex_box.getSelectedItem();
       String id = id_box.getText();
       int roomno = Integer.parseInt(roomno_box.getText());
       String roomtype = (String) roomtype_box.getSelectedItem();
       String bedtype = (String) bedtype_box.getSelectedItem();
       int rate = Integer.parseInt(rate_box.getText());
       
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String checkin = sdf.format(checkin_box.getDate());
       String checkout = sdf.format(checkout_box.getDate());
     
        
        
        try {
            String sql = "UPDATE home SET First_Name='"+fname+"',Sur_Name='"+sname+"',Address='"+address+"',Mobile_No='"+phone+"',Nationality='"+national+"',Gender='"+gender+"',ID_No='"+id+"',Check_in='"+checkin+"',Check_out='"+checkout+"',Room_No='"+roomno+"',Room_Type='"+roomtype+"',Bed_Type='"+bedtype+"',Rate='"+rate+"' WHERE Customer_Ref='"+ref+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Updated!..");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Errors!..");
        }
        
    }
    
    
    public void tableone()
    {
        int r = table1.getSelectedRow();
       
         try {
            
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(r,8).toString());
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(r,9).toString());
            checkin_box.setDate(date1);
            checkout_box.setDate(date2);
            } catch (ParseException ex) {
             Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        
             
            
            String ref = table1.getValueAt(r,0).toString();
            String fname = table1.getValueAt(r,1).toString();
            String sname = table1.getValueAt(r,2).toString();
            String address = table1.getValueAt(r,3).toString();
            String phone = table1.getValueAt(r,4).toString();
            String national = table1.getValueAt(r,5).toString();
            String gender = table1.getValueAt(r,6).toString();
            String id = table1.getValueAt(r,7).toString();
          
            String roomno = table1.getValueAt(r,10).toString();
            String roomtype = table1.getValueAt(r,11).toString();
            String bedtype = table1.getValueAt(r,12).toString();
            String rate = table1.getValueAt(r,13).toString();
            
            Reflbl.setText(ref);
            fname_box.setText(fname);
            sname_box.setText(sname);
            sex_box.setSelectedItem(gender);
            address_box.setText(address);
            phone_box.setText(phone);
            national_box.setText(national);
            id_box.setText(id);
            
            roomno_box.setText(roomno);
            roomtype_box.setSelectedItem(roomtype);
            bedtype_box.setSelectedItem(bedtype);
            rate_box.setText(rate); 
          
    }
 
    
    
    public void reset()
    {
        
        Reflbl.setText("Reference_No");
        fname_box.setText(" ");
        sname_box.setText(" ");
        sex_box.setSelectedItem(" ");
        address_box.setText(" ");
        phone_box.setText(" ");
        national_box.setText(" ");
        roomno_box.setText(" ");
        roomtype_box.setSelectedItem(" ");
        bedtype_box.setSelectedItem(" ");
        rate_box.setText(" ");
        id_box.setText(" ");   
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        fname_box = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sname_box = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        address_box = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        phone_box = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        national_box = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        sex_box = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        id_box = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        roomno_box = new javax.swing.JTextField();
        roomtype_box = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        bedtype_box = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rate_box = new javax.swing.JTextField();
        Reflbl = new javax.swing.JLabel();
        checkout_box = new com.toedter.calendar.JDateChooser();
        checkin_box = new com.toedter.calendar.JDateChooser();
        input_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        reset_btn = new javax.swing.JButton();
        back_btn1 = new javax.swing.JButton();
        exit_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setBackground(jLabel3.getBackground());
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer Ref.", "First Name", "Sur Name", "Address", "Mobile No.", "Nationality", "Gender", "Identity No.", "Check in Date", "Check out Date", "Room No.", "Room Type", "Bed Type", "Rate"
            }
        ));
        table1.setOpaque(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 188, 690, 400));

        jPanel2.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Customer Ref :");

        fname_box.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fname_box.setOpaque(false);
        fname_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fname_boxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sur Name :");

        sname_box.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sname_box.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address :");

        address_box.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        address_box.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mobile No :");

        phone_box.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phone_box.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nationality :");

        national_box.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        national_box.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender :");

        sex_box.setBackground(new java.awt.Color(153, 153, 153));
        sex_box.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sex_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        sex_box.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Check in Date :");

        id_box.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        id_box.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Identity No. :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Check out Date :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Room No. :");

        roomno_box.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roomno_box.setOpaque(false);

        roomtype_box.setBackground(new java.awt.Color(153, 153, 153));
        roomtype_box.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roomtype_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "AC", "NON AC" }));
        roomtype_box.setOpaque(false);
        roomtype_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomtype_boxActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Room Type :");

        bedtype_box.setBackground(new java.awt.Color(153, 153, 153));
        bedtype_box.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bedtype_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Single", "Double", "Family" }));
        bedtype_box.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Bed Type :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Rate :");

        rate_box.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rate_box.setOpaque(false);

        Reflbl.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Reflbl.setForeground(new java.awt.Color(255, 255, 255));
        Reflbl.setText("Ref.");

        checkout_box.setDateFormatString("yyyy-MM-dd");
        checkout_box.setOpaque(false);

        checkin_box.setDateFormatString("yyyy-MM-dd");
        checkin_box.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15))
                                .addGap(28, 28, 28))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel11)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(76, 76, 76)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkin_box, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(checkout_box, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fname_box)
                    .addComponent(Reflbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sname_box)
                    .addComponent(address_box)
                    .addComponent(phone_box)
                    .addComponent(national_box)
                    .addComponent(sex_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id_box)
                    .addComponent(roomno_box)
                    .addComponent(roomtype_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bedtype_box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rate_box))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Reflbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fname_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(sname_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(address_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(phone_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(national_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sex_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkin_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkout_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomno_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomtype_box, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bedtype_box, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rate_box, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 56, -1, -1));

        input_btn.setBackground(new java.awt.Color(53, 53, 53));
        input_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        input_btn.setForeground(new java.awt.Color(255, 255, 255));
        input_btn.setText("Input");
        input_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        input_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_btnActionPerformed(evt);
            }
        });
        jPanel1.add(input_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 709, 93, 48));

        update_btn.setBackground(new java.awt.Color(53, 53, 53));
        update_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update");
        update_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        jPanel1.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 709, 93, 48));

        delete_btn.setBackground(new java.awt.Color(53, 53, 53));
        delete_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete_btn.setForeground(new java.awt.Color(255, 255, 255));
        delete_btn.setText("Delete");
        delete_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        jPanel1.add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 709, 93, 48));

        reset_btn.setBackground(new java.awt.Color(53, 53, 53));
        reset_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reset_btn.setForeground(new java.awt.Color(255, 255, 255));
        reset_btn.setText("Reset");
        reset_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });
        jPanel1.add(reset_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 709, 93, 48));

        back_btn1.setBackground(new java.awt.Color(53, 53, 53));
        back_btn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back_btn1.setForeground(new java.awt.Color(255, 255, 255));
        back_btn1.setText("Back");
        back_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(back_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(952, 709, 93, 48));

        exit_btn.setBackground(new java.awt.Color(53, 53, 53));
        exit_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exit_btn.setForeground(new java.awt.Color(255, 255, 255));
        exit_btn.setText("Exit");
        exit_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        jPanel1.add(exit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, 93, 48));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Booking Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 45, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2teen.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(1250, 500));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1250, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1262, 802));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        System.exit(0);// TODO add your handling code here:
    }//GEN-LAST:event_exit_btnActionPerformed

    private void input_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_btnActionPerformed
       
       
       String fname;
       String sname;
       String address;
       int phone;
       String national;
       String gender;
       String id;
      
       
       int roomno;
       String roomtype;
       String bedtype;
       int rate;
       
       fname = fname_box.getText();
       sname = sname_box.getText();
       address = address_box.getText();
       phone = Integer.parseInt(phone_box.getText());
       national = national_box.getText();
       gender = (String) sex_box.getSelectedItem();
       id = id_box.getText();
       roomno = Integer.parseInt(roomno_box.getText());
       roomtype = (String) roomtype_box.getSelectedItem();
       bedtype = (String) bedtype_box.getSelectedItem();
       rate = Integer.parseInt(rate_box.getText());
       
       
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String checkin = sdf.format(checkin_box.getDate());
       String checkout = sdf.format(checkout_box.getDate());
       
       
        try 
        {
          String sql = "INSERT INTO home (First_Name,Sur_Name,Address,Mobile_No,Nationality,Gender,ID_No,Check_in,Check_out,Room_No,Room_Type,Bed_Type,Rate) VALUES ('"+fname+"','"+sname+"','"+address+"','"+phone+"','"+national+"','"+gender+"','"+id+"','"+checkin+"','"+checkout+"','"+roomno+"','"+roomtype+"','"+bedtype+"','"+rate+"')";  
          pst = conn.prepareStatement(sql);
          pst.execute();
          JOptionPane.showMessageDialog(null,"Inserted!..");
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
       reset();
       tableload();
       reset();
       
    }//GEN-LAST:event_input_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed


        int check = JOptionPane.showConfirmDialog(null,"Do you want to delete?");
        
        if(check==0)
        {
            
             
            String ref = Reflbl.getText();
            try {
                String sql = "DELETE FROM home WHERE Customer_Ref = '"+ref+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Deleted!..");
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,"Errors!..");
            }
        }
        
       
        
       reset();
       tableload();
    }//GEN-LAST:event_delete_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
            
      update();
      reset();
      tableload();

    }//GEN-LAST:event_update_btnActionPerformed

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
       
        
        Reflbl.setText("Reference No.");
        fname_box.setText(null);
        sname_box.setText(null);
        address_box.setText(null);
        phone_box.setText(null);
        national_box.setText(null);
        sex_box.setSelectedIndex(0);
        id_box.setText(null);
        roomno_box.setText(null);
        roomtype_box.setSelectedIndex(0);
        checkin_box.setDate(null);
        checkout_box.setDate(null);
        bedtype_box.setSelectedIndex(0);
        rate_box.setText(null);
        
        
    }//GEN-LAST:event_reset_btnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
       tableone();
        
        
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
       tableone();
       
        // TODO add your handling code here:
    }//GEN-LAST:event_table1KeyReleased

    private void roomtype_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomtype_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomtype_boxActionPerformed

    private void back_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btn1ActionPerformed
       Menu m = new Menu();
       m.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_back_btn1ActionPerformed

    private void fname_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fname_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fname_boxActionPerformed

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Reflbl;
    private javax.swing.JTextField address_box;
    private javax.swing.JButton back_btn1;
    private javax.swing.JComboBox<String> bedtype_box;
    private com.toedter.calendar.JDateChooser checkin_box;
    private com.toedter.calendar.JDateChooser checkout_box;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton exit_btn;
    private javax.swing.JTextField fname_box;
    private javax.swing.JTextField id_box;
    private javax.swing.JButton input_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField national_box;
    private javax.swing.JTextField phone_box;
    private javax.swing.JTextField rate_box;
    private javax.swing.JButton reset_btn;
    private javax.swing.JTextField roomno_box;
    private javax.swing.JComboBox<String> roomtype_box;
    private javax.swing.JComboBox<String> sex_box;
    private javax.swing.JTextField sname_box;
    private javax.swing.JTable table1;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables

  
}

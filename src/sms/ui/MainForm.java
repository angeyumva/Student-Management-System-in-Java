 
package sms.ui;
import sms.dao.StudentDAO;
import sms.model.Student;
import javax.swing.JOptionPane;

 
public class MainForm extends javax.swing.JFrame {

    StudentDAO dao = new StudentDAO();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainForm.class.getName());

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        cmbGender.setSelectedIndex(0);
        cmbCourse.setSelectedIndex(0);
        txtMarks.setText("");
    }

    private void loadStudents() {
        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblStudents.getModel();
        model.setRowCount(0);

        for (Student s : dao.getAllStudents()) {
            model.addRow(new Object[]{
                s.getId(),
                s.getName(),
                s.getEmail(),
                s.getGender(),
                s.getCourse(),
                s.getMarks()
            });
        }
    }
   private void searchStudents() {
    String keyword = txtSearch.getText().trim();
    String searchBy = cmbSearchBy.getSelectedItem().toString();

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblStudents.getModel();
    model.setRowCount(0);

    for (Student s : dao.searchStudents(keyword, searchBy)) {
        model.addRow(new Object[]{
            s.getId(),
            s.getName(),
            s.getEmail(),
            s.getGender(),
            s.getCourse(),
            s.getMarks()
        });
    }
}

    private void sortStudents() {
        String sortBy = "";

        if (rdoSortName.isSelected()) {
            sortBy = "name";
        } else if (rdoSortMarks.isSelected()) {
            sortBy = "marks";
        }

        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblStudents.getModel();
        model.setRowCount(0);

        for (Student s : dao.getAllStudentsSorted(sortBy)) {
            model.addRow(new Object[]{
                s.getId(),
                s.getName(),
                s.getEmail(),
                s.getGender(),
                s.getCourse(),
                s.getMarks()
            });
        }
    }

   public MainForm() {
        initComponents();
        dao.createTable();
        lblStatus.setText("Ready");
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbCourse = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtMarks = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnShowAll = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        rdoSortName = new javax.swing.JRadioButton();
        rdoSortMarks = new javax.swing.JRadioButton();
        cmbSearchBy = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        itemExit = new javax.swing.JMenuItem();
        itemLogout = new javax.swing.JMenuItem();
        mnuStudents = new javax.swing.JMenu();
        itemAdd = new javax.swing.JMenuItem();
        itemUpdate = new javax.swing.JMenuItem();
        itemDelete = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        itemAbout = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Details"));

        txtId.setBackground(new java.awt.Color(204, 204, 255));
        txtId.setText(" ");

        jLabel2.setText(" Student ID");

        txtName.setBackground(new java.awt.Color(204, 204, 255));
        txtName.setText(" ");

        jLabel3.setText("Name");

        txtEmail.setBackground(new java.awt.Color(204, 204, 255));
        txtEmail.setText(" ");

        jLabel7.setText("Email");

        cmbGender.setBackground(new java.awt.Color(204, 204, 255));
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel4.setText("Gender");

        cmbCourse.setBackground(new java.awt.Color(204, 204, 255));
        cmbCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java", "DBMS", "Networking", "Mathematics" }));

        jLabel5.setText(" Course");

        txtMarks.setBackground(new java.awt.Color(204, 204, 255));
        txtMarks.setText(" ");
        txtMarks.addActionListener(this::txtMarksActionPerformed);

        jLabel6.setText("Marks");

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setText("Add");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(0, 204, 204));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnClear.setBackground(new java.awt.Color(255, 102, 102));
        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);

        btnSearch.setText("Search");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        lblSearch.setText("Search");

        txtSearch.setBackground(new java.awt.Color(204, 204, 255));
        txtSearch.setText(" ");

        btnShowAll.setBackground(new java.awt.Color(255, 204, 0));
        btnShowAll.setText("Show All");
        btnShowAll.addActionListener(this::btnShowAllActionPerformed);

        lblStatus.setText("Ready");

        buttonGroup1.add(rdoSortName);
        rdoSortName.setText("Sort by Name");
        rdoSortName.addActionListener(this::rdoSortNameActionPerformed);

        buttonGroup1.add(rdoSortMarks);
        rdoSortMarks.setText("Sort by Marks");
        rdoSortMarks.addActionListener(this::rdoSortMarksActionPerformed);

        cmbSearchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Email", "Gender", "Course" }));
        cmbSearchBy.addActionListener(this::cmbSearchByActionPerformed);

        jLabel8.setText("Search by");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(lblStatus)
                .addContainerGap(476, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(114, 114, 114)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblSearch)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSearch))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(rdoSortMarks)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnSearch)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(94, 94, 94)
                                                    .addComponent(rdoSortName))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 677, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowAll)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSearch)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoSortName))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoSortMarks))
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear)
                    .addComponent(btnShowAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addGap(21, 21, 21))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Records"));

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "Gender", "Course", "Marks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudents);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );

        mnuFile.setText("File");

        itemExit.setText("Exit");
        itemExit.addActionListener(this::itemExitActionPerformed);
        mnuFile.add(itemExit);

        itemLogout.setText("Log out");
        itemLogout.addActionListener(this::itemLogoutActionPerformed);
        mnuFile.add(itemLogout);

        jMenuBar1.add(mnuFile);

        mnuStudents.setText("Students");

        itemAdd.setText("Add");
        itemAdd.addActionListener(this::itemAddActionPerformed);
        mnuStudents.add(itemAdd);

        itemUpdate.setText("Update");
        itemUpdate.addActionListener(this::itemUpdateActionPerformed);
        mnuStudents.add(itemUpdate);

        itemDelete.setText("Delete");
        itemDelete.addActionListener(this::itemDeleteActionPerformed);
        mnuStudents.add(itemDelete);

        jMenuBar1.add(mnuStudents);

        mnuHelp.setText("Help");

        itemAbout.setText("About");
        itemAbout.addActionListener(this::itemAboutActionPerformed);
        mnuHelp.add(itemAbout);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
String idText = txtId.getText().trim();
String name = txtName.getText().trim();
String email = txtEmail.getText().trim();
String course = cmbCourse.getSelectedItem().toString();
String marksText = txtMarks.getText().trim();

if (idText.isEmpty() || name.isEmpty() || email.isEmpty() || marksText.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please fill in all fields");
    return;
}

double marks;
    try {
        marks = Double.parseDouble(marksText);
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Marks must be a valid number");
        txtMarks.requestFocus();
        return;
    }

    if (marks < 0 || marks > 100) {
        javax.swing.JOptionPane.showMessageDialog(this, "Marks must be between 0 and 100");
        txtMarks.requestFocus();
        return;
    }

int id = Integer.parseInt(idText);
String gender = cmbGender.getSelectedItem().toString();
Student student = new Student(id, name, email, gender, course, marks);
boolean added = dao.addStudent(student);

if (added) {
    lblStatus.setText("Student added successfully");
    loadStudents();
    javax.swing.JOptionPane.showMessageDialog(this, "Student added successfully");
    clearFields();
}
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    clearFields(); 
    lblStatus.setText("Ready");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
if (tblStudents.getSelectedRow() == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Select a student from the table first");
    return;
}
        String idText = txtId.getText().trim();

if (idText.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Enter Student ID first");
    return;
}

int id = Integer.parseInt(idText);
int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete this student?",
        "Confirm Delete",
        javax.swing.JOptionPane.YES_NO_OPTION
);

if (confirm != javax.swing.JOptionPane.YES_OPTION) {
    return;
}
dao.deleteStudent(id);
loadStudents();
clearFields();

lblStatus.setText("Student deleted successfully");
javax.swing.JOptionPane.showMessageDialog(this, "Student deleted successfully");       
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
if (tblStudents.getSelectedRow() == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Select a student from the table first");
    return;
}
        String idText = txtId.getText().trim();
        String marksText = txtMarks.getText().trim();

if (idText.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Enter Student ID first");
    return;
}

if (marksText.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Enter Marks first");
    return;
}

double marks;
    try {
        marks = Double.parseDouble(marksText);
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Marks must be a valid number");
        txtMarks.requestFocus();
        return;
    }

    if (marks < 0 || marks > 100) {
        javax.swing.JOptionPane.showMessageDialog(this, "Marks must be between 0 and 100");
        txtMarks.requestFocus();
        return;
    }

int id = Integer.parseInt(idText);
String name = txtName.getText();
String email = txtEmail.getText().trim();
String gender = cmbGender.getSelectedItem().toString();
String course = cmbCourse.getSelectedItem().toString();

Student student = new Student(id, name, email, gender, course, marks);
dao.updateStudent(student);
loadStudents();
clearFields();

lblStatus.setText("Student updated successfully");
javax.swing.JOptionPane.showMessageDialog(this, "Student updated successfully");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
 int row = tblStudents.getSelectedRow();

txtId.setText(tblStudents.getValueAt(row, 0).toString());
txtName.setText(tblStudents.getValueAt(row, 1).toString());
txtEmail.setText(tblStudents.getValueAt(row, 2).toString());
cmbGender.setSelectedItem(tblStudents.getValueAt(row, 3).toString());
cmbCourse.setSelectedItem(tblStudents.getValueAt(row, 4).toString());
txtMarks.setText(tblStudents.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tblStudentsMouseClicked

    private void itemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExitActionPerformed
      System.exit(0);
    }//GEN-LAST:event_itemExitActionPerformed

    private void itemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAboutActionPerformed
       new About().setVisible(true);
    }//GEN-LAST:event_itemAboutActionPerformed

    private void itemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddActionPerformed
       btnAdd.doClick();
    }//GEN-LAST:event_itemAddActionPerformed

    private void itemUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUpdateActionPerformed
       btnUpdate.doClick();
    }//GEN-LAST:event_itemUpdateActionPerformed

    private void itemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeleteActionPerformed
     btnDelete.doClick();
    }//GEN-LAST:event_itemDeleteActionPerformed

    private void txtMarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarksActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
     searchStudents();
     lblStatus.setText("Search completed");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
    loadStudents();
    lblStatus.setText("All students displayed");
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void rdoSortNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSortNameActionPerformed
       sortStudents();
       lblStatus.setText("Sorted by name");
    }//GEN-LAST:event_rdoSortNameActionPerformed

    private void rdoSortMarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSortMarksActionPerformed
       sortStudents();
       lblStatus.setText("Sorted by marks");
    }//GEN-LAST:event_rdoSortMarksActionPerformed

    private void itemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLogoutActionPerformed
       javax.swing.JOptionPane.showMessageDialog(this, "Logged out successfully");
       new LoginForm().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_itemLogoutActionPerformed

    private void cmbSearchByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSearchByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSearchByActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        javax.swing.JOptionPane.showMessageDialog(null, "Please run the project and login first.");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbCourse;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JComboBox<String> cmbSearchBy;
    private javax.swing.JMenuItem itemAbout;
    private javax.swing.JMenuItem itemAdd;
    private javax.swing.JMenuItem itemDelete;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JMenuItem itemUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuStudents;
    private javax.swing.JRadioButton rdoSortMarks;
    private javax.swing.JRadioButton rdoSortName;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarks;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

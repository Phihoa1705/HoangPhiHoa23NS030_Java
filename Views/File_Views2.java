package Java_I_O_Stream.T2.Views;

import Java_I_O_Stream.T2.Controller.File_Controller2;
import Java_I_O_Stream.T2.Model.File_Models;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class File_Views2 extends JFrame {
    private File_Models fileModels;

    private JTextArea textArea;

    public File_Views2(String tenRoot,String duongDan)  {
        this.fileModels = new File_Models(tenRoot,duongDan);
        this.setTitle("PHI HÒA HANDSOME");
        this.setVisible(true);
        this.init();
    }


    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setSize(500,500);
        this.setLayout(new BorderLayout());
        textArea = new JTextArea("Phi Hòa đẹp trai");
        textArea.setEditable(false); //Không được chỉnh sửa
        JTree tree = new JTree(fileModels.getRoot());
        JScrollPane scrollPane1 = new JScrollPane(tree);
        JScrollPane scrollPane2 = new JScrollPane(textArea);
        TreeSelectionListener treeSelectionListener = new File_Controller2(this);
        this.add(scrollPane2,BorderLayout.CENTER);
        this.add(scrollPane1, BorderLayout.WEST);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}

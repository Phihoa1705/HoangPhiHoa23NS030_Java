package Java_I_O_Stream.T2.Views;

import Java_I_O_Stream.T2.Controller.File_Controller1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class File_Views1 extends JFrame {
        private JTextField textFieldTenThuMuc;

        private JTextField textFielddDiaChiThuMuc;
        private JButton Submit;
        private JButton Exit;

        public File_Views1() {
            this.setVisible(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setSize(450, 170);
            this.setTitle("Welcome");
            this.setLayout(new BorderLayout());
            ActionListener ac = new File_Controller1(this);
            JPanel panel1 = new JPanel(new FlowLayout());
            JPanel panel2 = new JPanel(new GridLayout(2, 2,15,15));
            JPanel panel3 = new JPanel(new FlowLayout());
            JLabel Form = new JLabel("FORM");
            panel1.add(Form);
            JLabel nhapTenThuMuc = new JLabel("Nhập tên thư mục muốn tạo cây TM");
            JLabel nhapDiaChiThuMuc = new JLabel("Nhập địa chỉ thư mục");
            textFieldTenThuMuc = new JTextField(50);
            textFielddDiaChiThuMuc = new JTextField(50);
            panel2.add(nhapTenThuMuc);
            panel2.add(textFieldTenThuMuc);
            panel2.add(nhapDiaChiThuMuc);
            panel2.add(textFielddDiaChiThuMuc);
            Submit = new JButton("Submit");
            Submit.addActionListener(ac);
            Exit = new JButton("Exit");
            Exit.addActionListener(ac);
            panel3.add(Submit);
            panel3.add(Exit);
            this.add(panel1,BorderLayout.NORTH);
            this.add(panel2,BorderLayout.CENTER);
            this.add(panel3,BorderLayout.SOUTH);
        }

    public JTextField getTextFieldTenThuMuc() {
        return textFieldTenThuMuc;
    }

    public void setTextFieldTenThuMuc(JTextField textFieldTenThuMuc) {
        this.textFieldTenThuMuc = textFieldTenThuMuc;
    }

    public JTextField getTextFielddDiaChiThuMuc() {
        return textFielddDiaChiThuMuc;
    }

    public void setTextFielddDiaChiThuMuc(JTextField textFielddDiaChiThuMuc) {
        this.textFielddDiaChiThuMuc = textFielddDiaChiThuMuc;
    }
}

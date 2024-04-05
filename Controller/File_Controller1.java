package Java_I_O_Stream.T2.Controller;

import Java_I_O_Stream.T2.Views.File_Views1;
import Java_I_O_Stream.T2.Views.File_Views2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class File_Controller1 implements ActionListener {
    private File_Views1 fileViews1;

    public File_Controller1(File_Views1 fileView1) {
        this.fileViews1 = fileView1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nsk = e.getActionCommand();
        if (nsk == "Submit") {
            File_Views2 fileViews2 = new File_Views2(fileViews1.getTextFieldTenThuMuc().getText(),
                    fileViews1.getTextFielddDiaChiThuMuc().getText());
            this.fileViews1.dispose();
        } else if (nsk == "Exit") {
            System.exit(0);
        }
    }
}

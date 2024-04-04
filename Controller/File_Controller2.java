package Java_I_O_Stream.T2.Controller;

import Java_I_O_Stream.T2.Views.File_Views2;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class File_Controller2 implements TreeSelectionListener {
    private File_Views2 fileViews2;

    public File_Controller2(File_Views2 fileViews2) {
        this.fileViews2 = fileViews2;
    }

    @Override
    public void valueChanged(TreeSelectionEvent event) {
        try {
                File fileCanMo = new File(String.valueOf(event.getPath())); //chuyển đổi đường dẫn của File đã chọn thành String
                BufferedReader br = Files.newBufferedReader(fileCanMo.toPath(), StandardCharsets.UTF_8);
                String line = null;
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    } else {

                    }
                }
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}

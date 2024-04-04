package Java_I_O_Stream.T2.Model;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class File_Models {
    private DefaultMutableTreeNode root;

    public File_Models(String tenRoot, String path) {
        this.root = new DefaultMutableTreeNode(tenRoot);
        loadTreeData(path);
    }

    public File_Models(DefaultMutableTreeNode root) {
        this.root = root;
    }

    public void loadTreeData(String path) {
        File rootDir = new File(path);
        buildTree(root, rootDir);
    }
    public void buildTree(DefaultMutableTreeNode node, File file) {
        if (file.isDirectory()) { //Nếu là thư mục
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
            node.add(childNode);
            File[] fileListArray = file.listFiles(); // Lấy danh sách tệp con
            if (fileListArray != null) { // Kiểm tra xem danh sách tệp con có null hay không
                List<File> fileList = Arrays.asList(fileListArray);
                Stream<File> fileStream = fileList.stream();
                fileStream.forEach(f ->{
                    buildTree(childNode,f);
                });
            }
        } else { // Nếu là tập tin
            DefaultMutableTreeNode tapTin = new DefaultMutableTreeNode(file.getName());
            node.add(tapTin);
        }
    }

    public DefaultMutableTreeNode getRoot() {
        return root;
    }

    public void setRoot(DefaultMutableTreeNode root) {
        this.root = root;
    }
}


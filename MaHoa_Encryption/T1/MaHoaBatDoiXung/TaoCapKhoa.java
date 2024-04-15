package MaHoa_Encryption.T1.MaHoaBatDoiXung;

import javax.crypto.KeyGenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class TaoCapKhoa {
    public static void main(String[] args) {
        try{
            SecureRandom sr = new SecureRandom();
            // - Thuật toán phát sinh khóa RSA
            // - Độ dài khóa 1024(bits), độ dài khóa này quyết định đến độ an toàn của
            // khóa, càng lớn thì càng an toàn.
            // Demo chỉ sử dụng 1024 bit. Nhưng theo khuyến cáo thì độ dài khóa nên tối thiểu là 2048.
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024,sr);

            //Khởi tạo cặp khóa
            KeyPair kp = kpg.genKeyPair();
            //Public Key
            PublicKey publicKey = kp.getPublic();
            //Private Key
            PrivateKey privateKey = kp.getPrivate();

            File publicKeyFile = createKeyFile(new File("D:\\Intel\\Java_Nang_Cao_T1\\src\\MaHoa_Encryption\\T1\\MaHoaBatDoiXung\\publicKey.rsa"));
            File privateKeyFile = createKeyFile(new File("D:\\Intel\\Java_Nang_Cao_T1\\src\\MaHoa_Encryption\\T1\\MaHoaBatDoiXung\\privateKey.rsa"));

            //Lưu Public Key
            FileOutputStream fos = new FileOutputStream(publicKeyFile);
            fos.write(publicKey.getEncoded());
            fos.close();

            // Lưu Private Key
            fos = new FileOutputStream(privateKeyFile);
            fos.write(privateKey.getEncoded());
            fos.close();

            System.out.println("Generate key successfully");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static File createKeyFile(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        return file;
    }
}

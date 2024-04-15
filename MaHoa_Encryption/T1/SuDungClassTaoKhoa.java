package MaHoa_Encryption.T1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class SuDungClassTaoKhoa {
    /*
        Sử dụng class KeyPairGenerator của Java Security để generate một cặp public key và private key
     */
    public static void main(String[] args) {
        //Đầu tiên, các bạn cần khởi tạo đối tượng KeyPairGenerator sử dụng phương thức static getInstance()
        // với thuật toán RSA và kích thước 1024 hoặc 2048 như sau:
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
//            Sử dụng phương thức generateKeyPair() của đối tượng KeyPairGenerator, các bạn sẽ generate
//            được một cặp public key và private key, thông tin được chứa trong đối tượng KeyPair:

            KeyPair keyPair = kpg.generateKeyPair();
//            Từ đối tượng KeyPair này, các bạn có thể lấy đối tượng chứa public key và private key như sau:
            Key pub = keyPair.getPublic();
            Key pvt = keyPair.getPrivate();

//            Các bạn có thể lấy thông tin định dạng của public key và private key như sau:
            System.out.println("Public key format: " + pub.getFormat());
            System.out.println("Private key format: " + pvt.getFormat());
//            Như các bạn thấy, định dạng mặc định của public key là X.509 và private key là PKCS#8.
//            Các bạn tìm hiểu thêm về các định dạng này trên mạng nhé!
            generatePublicKeyAndPrivateKey(keyPair,"D:\\Intel\\Java_Nang_Cao_T1\\src\\MaHoa_Encryption\\T1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Để lưu lại public key và private key này ra file, các bạn có thể sử dụng phương thức sau:
    private static void generatePublicKeyAndPrivateKey(KeyPair keypair, String outputFileWithoutExtension)
            throws IOException {
        OutputStream out = new FileOutputStream(outputFileWithoutExtension + ".key");
        out.write(keypair.getPrivate().getEncoded());
        out.close();

        out = new FileOutputStream(outputFileWithoutExtension + ".pub");
        out.write(keypair.getPublic().getEncoded());
        out.close();
    }
}

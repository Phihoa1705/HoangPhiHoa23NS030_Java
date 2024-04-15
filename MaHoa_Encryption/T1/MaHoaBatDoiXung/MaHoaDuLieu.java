package MaHoa_Encryption.T1.MaHoaBatDoiXung;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class MaHoaDuLieu {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        try {
            // Đọc file chứa public key
            FileInputStream fis = new FileInputStream("D:\\Intel\\Java_Nang_Cao_T1\\src\\MaHoa_Encryption\\T1\\MaHoaBatDoiXung\\publicKey.rsa");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();
            //Tạo public Key
//          "X509EncodedKeySpec" là một lớp trong Java được sử dụng để biểu diễn một khóa công cộng trong
//          mã hóa và giải mã RSA. Trong đoạn mã, nó được sử dụng để tạo public key từ dữ liệu đã được mã
//          hóa theo chuẩn X.509, để sau đó sử dụng trong quá trình mã hóa dữ liệu với thuật toán RSA.
            X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
//            "KeyFactory" đề cập đến lớp `KeyFactory` trong Java, được sử dụng để chuyển đổi các khóa (key) được lưu dưới dạng chuỗi thành các đối tượng khóa dùng cho mã hóa và giải mã. Trong trường hợp này, `KeyFactory` được sử dụng để tạo Public Key từ dữ liệu
//            khóa dạng X.509 và sau đó được sử dụng để mã hóa dữ liệu bằng thuật toán RSA.
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = factory.generatePublic(spec);

            //Mã Hóa dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.ENCRYPT_MODE, publicKey);
            String msg = "helloworld";
            byte encryptOut[] = c.doFinal(msg.getBytes());
            String strEncrypt = Base64.getEncoder().encodeToString(encryptOut);
            System.out.println("Chuỗi sau khi mã hoá: " + strEncrypt);
            /*
                Kết quả là
                    dE8KBbQt5FB6+IWR/DDbVG7/VuwhWKLLMlt+yFXQkECFUBhSO/TH2MejxSDUVdwvqkWNK7y0+O+JG6mrkKvK/7Nt653/kPVnIl6Onm5lAYLYZGzPXBuKPspE16hdFkfnCceDPNdrT1emsZdrKDn3y94w9AU1N5+jedbXMdUqv3g=
             */
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }
}

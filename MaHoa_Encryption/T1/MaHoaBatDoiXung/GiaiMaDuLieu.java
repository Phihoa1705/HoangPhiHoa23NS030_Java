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
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class GiaiMaDuLieu {
    public static void main(String[] args) {
        try {
            // Đọc file chứa private key
            FileInputStream fis = new FileInputStream("D:\\Intel\\Java_Nang_Cao_T1\\src\\MaHoa_Encryption\\T1\\MaHoaBatDoiXung\\privateKey.rsa");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();
            /*
                   "PKCS8EncodedKeySpec" đề cập đến lớp trong Java được sử dụng để xác định một khóa
                   dưới dạng chuỗi byte dưới dạng chuỗi mã hóa chuẩn PKCS#8. Trong đoạn mã được cung
                   cấp, nó được sử dụng để tạo private key từ dữ liệu mã hóa PKCS#8 của khóa private
                   để sau đó giải mã dữ liệu sử dụng thuật toán RSA.
             */
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = factory.generatePrivate(spec);

            // Giải mã dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, privateKey);
            /*
                Lấy chuỗi đó từ kqua của MaHoaDuLieu.java
            */
            byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(
                    "dE8KBbQt5FB6+IWR/DDbVG7/VuwhWKLLMlt+yFXQkECFUBhSO/TH2MejxSDUVdwvqkWNK7y0+O+JG6mrkKvK/7Nt653/kPVnIl6Onm5lAYLYZGzPXBuKPspE16hdFkfnCceDPNdrT1emsZdrKDn3y94w9AU1N5+jedbXMdUqv3g="));
            System.out.println("Dữ liệu sau khi giải mã: " + new String(decryptOut));
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

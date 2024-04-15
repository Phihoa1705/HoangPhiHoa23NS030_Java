package MaHoa_Encryption.T1;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MaHoa_SHA256 {
    public static void main(String[] args) {
        try {
            //Đọc dữ liệu từ người dùng
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập thông tin muốn mã hóa: ");
            String chuoi = sc.nextLine();


            //Tạo đối tượng của lớp MessageDigest
            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            getInstance("SHA-256") sẽ trả về một đối tượng MessageDigest được cấu hình để sử dụng thuật toán băm SHA-256.

            //Truyền dữ liệu cho đối tượng md
            md.update(chuoi.getBytes());
            byte[] digest = md.digest();
            System.out.println("Sau khi đã băm dữ liệu: "+digest);
//            digest() là một phương thức của đối tượng MessageDigest, được sử dụng để tính toán giá trị băm của dữ liệu đầu vào

//            lớp StringBuffer được sử dụng để tạo chuỗi có thể thay đổi (mutable).
//            Lớp StringBuffer trong java tương tự như lớp String ngoại trừ nó có thể thay đổi.

//            CÁC CONSTRUCTOR của StringBuffer
//            StringBuffer(): Tạo ra một bộ đệm chuỗi với dung lượng ban đầu là 16.
//            StringBuffer(String str): Tạo ra một bộ đệm chuỗi với chuỗi cụ thể.
//            StringBuffer(int capacity): Tạo ra một bộ đệm chuỗi với dung lượng được chỉ định như độ dài chuỗi.
            StringBuffer hexString = new StringBuffer();
            /*
            public synchronized StringBuffer append(String s): được sử dụng để nối thêm các chuỗi được chỉ định với chuỗi này.
            Các phương thức append() được nạp chồng như append(char), append(boolean), append(int), append(float), append(double), ...
             */
            for (int i = 0; i < digest.length; i++) {
//                Trả về String tương ứng với giá trị int ở hệ hexadecimal.
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }
            System.out.println("Sau khi chuyển dữ liệu thành thập lục phân: " + hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
    /*
    0xFF là một số nguyên dạng thập lục phân có giá trị là 255 trong hệ thập phân và tương ứng với 11111111 trong hệ nhị phân.

    Khi bạn thực hiện phép toán AND bit (&) giữa 0xFF và digest[i], chỉ có 8 bit thấp nhất của digest[i] sẽ được giữ lại,
    trong khi các bit cao hơn sẽ bị xóa. Điều này là do phép toán AND chỉ giữ lại các bit tại các vị trí mà cả hai số đều có giá trị 1.
    Vì 0xFF có tất cả các bit đều là 1, nó sẽ giữ lại tất cả các bit thấp nhất của digest[i] và xóa các bit cao hơn.
    Điều này giúp đảm bảo rằng kết quả của phép toán AND luôn nằm trong khoảng từ 0 đến 255, phù hợp với giá trị của một byte.
     */
}

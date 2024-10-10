package views;

import management.OfficialPhoneManagement;
import service.FileService;

import java.util.Scanner;

public class MainView {
    public static void displayMenu() {
        OfficialPhoneManagement.setOfficialPhoneList(FileService.loadFromFile());
        boolean isExit = false;
        while (!isExit) {
            System.out.println("================= CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI =================");
            System.out.println("Chọn chức năng theo số để tiếp tục");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn:");
            String yourChoice = (new Scanner(System.in)).nextLine();

            switch (yourChoice) {
                case "1":
                    AddPhoneMenu.displayMenu();
                    break;
                case "2":
                    OfficialPhoneManagement.delete();
                    break;
                case "3":
                    OfficialPhoneManagement.show();
                    break;
                case "4":
                    OfficialPhoneManagement.find();
                    break;
                case "5":
                    isExit = true;
                    break;
                default:
                    System.err.println("<!>Lựa chọn của bạn không hợp lệ!");
            }
        }
        System.out.println("Hẹn gặp lại <3");
    }
}

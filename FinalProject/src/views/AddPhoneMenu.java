package views;

import management.OfficialPhoneManagement;

import java.util.Scanner;

public class AddPhoneMenu {
    public static void displayMenu() {
        System.out.println("================= CHỌN LOẠI ĐIỆN THOẠI =================");
        System.out.println("1. Chính hãng");
        System.out.println("2. Xách tay");
        System.out.print("Nhập lựa chọn của bạn:");
        String yourChoice = (new Scanner(System.in)).nextLine();
        switch (yourChoice) {
            case "1":
                OfficialPhoneManagement.add();
                break;
            case "2":
                break;
            default:
        }
    }
}

package management;

import entity.OfficialPhone;
import entity.Phone;
import service.FileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OfficialPhoneManagement {
    private static List<OfficialPhone> officialPhoneList = new ArrayList<>();

    public static List<OfficialPhone> getOfficialPhoneList() {
        return officialPhoneList;
    }

    public static void setOfficialPhoneList(List<OfficialPhone> officialPhoneList) {
        OfficialPhoneManagement.officialPhoneList = officialPhoneList;
    }

    public static void add() {
        int id;
        String name;
        while (true) {
            boolean isIdTrue = false;
            boolean isFound = false;
            System.out.println("Nhập id:");
            id = new Scanner(System.in).nextInt();
            if (id > 0) {
                for (OfficialPhone officialPhone : officialPhoneList) {
                    if (officialPhone.getId() == id) {
                        isFound = true;
                        System.err.println("<!> ID tồn tại");
                        break;
                    }
                }
                if (!isFound) {
                    isIdTrue = true;
                }
            } else {
                System.err.println("<!> ID không được < 0");
            }
            if (isIdTrue) {
                break;
            }
        }
        while (true) {
            System.out.println("Nhập tên điện thoại:");
            name = new Scanner(System.in).nextLine();
            if (name.isEmpty()) {
                System.out.println("<!> Tên không được bỏ trống");
            } else {
                break;
            }
        }

        System.out.println("Nhập giá bán:");
        double price = new Scanner(System.in).nextDouble();
        System.out.println("Nhập số lượng:");
        int quantity = new Scanner(System.in).nextInt();
        System.out.println("Nhập nsx:");
        String manufacturer = new Scanner(System.in).nextLine();
        System.out.println("Nhập thời gian bảo hành:");
        int warrantyPeriod = new Scanner(System.in).nextInt();
        System.out.println("Nhập phạm vi bảo hành:");
        String warrantyCoverage = new Scanner(System.in).nextLine();

        officialPhoneList.add(new OfficialPhone(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyCoverage));
        FileService.saveToFile(officialPhoneList);
    }

    public static void delete() {
        boolean isFound = false;
        System.out.println("Nhập id điện thoại cần tiìm kiếm:");
        int id = new Scanner(System.in).nextInt();
        for (int i = 0; i < officialPhoneList.size(); i++) {
            if (id == officialPhoneList.get(i).getId()) {
                isFound = true;
                officialPhoneList.remove(i);
                break;
            }
        }
        FileService.saveToFile(officialPhoneList);
    }

    public static void find() {
        System.out.println("Nhập id điện thoại cần tiìm kiếm:");
        int id = new Scanner(System.in).nextInt();
        for (OfficialPhone officialPhone : officialPhoneList) {
            if (id == officialPhone.getId()) {
                System.out.println(officialPhone.toString());
            }
        }
    }

    public static void show() {
        for (OfficialPhone officialPhone : officialPhoneList) {
            System.out.println(officialPhone);
        }
    }
}

package service;

import entity.OfficialPhone;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static void saveToFile(List<OfficialPhone> officialPhoneList) {
        if (!officialPhoneList.isEmpty()){
            try {
                String fileName = "src/data/official_phone.csv";
                FileWriter fileWriter = new FileWriter(fileName);
                for (OfficialPhone officialPhone : officialPhoneList) {
                    fileWriter.write(officialPhone.getId() + ",");
                    fileWriter.write(officialPhone.getName() + ",");
                    fileWriter.write(officialPhone.getPrice() + ",");
                    fileWriter.write(officialPhone.getQuantity() + ",");
                    fileWriter.write(officialPhone.getManufacturer() + ",");
                    fileWriter.write(officialPhone.getWarrantyPeriod() + ",");
                    fileWriter.write(officialPhone.getWarrantyCoverage() + "|\n");
                }
                fileWriter.flush();
                fileWriter.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static List<OfficialPhone> loadFromFile() {
        int count = 0;
        StringBuilder id = new StringBuilder();
        StringBuilder name = new StringBuilder();
        StringBuilder price = new StringBuilder();
        StringBuilder quantity = new StringBuilder();
        StringBuilder manufacturer = new StringBuilder();
        StringBuilder warrantyPeriod = new StringBuilder();
        StringBuilder warrantyCoverage = new StringBuilder();
        List<OfficialPhone> officialPhoneList = new ArrayList<>();

        try {
            String fileName = "src/data/official_phone.csv";
            FileReader fileReader = new FileReader(fileName);
            while (true){
                int character = fileReader.read();
//                System.out.print((char) character);
                if (character == -1){
                    break;
                }
                if ((char)character == ','){
                    count++;

                }
                if (count == 0 && (char)character != ',' && (char)character != '\n'){
                    id.append((char) character);
                }
                else if (count == 1 && (char)character != ','){
                    name.append((char) character);
                }
                else if (count == 2 && (char)character != ','){
                    price.append((char) character);
                }
                else if (count == 3 && (char)character != ','){
                    quantity.append((char) character);
                }
                else if (count == 4 && (char)character != ','){
                    manufacturer.append((char) character);
                }
                else if (count == 5 && (char)character != ','){
                    warrantyPeriod.append((char) character);
                }
                else if (count == 6 && (char)character != ',' && (char)character != '|'){
                    warrantyCoverage.append((char) character);
                }
                if ((char)character == '|'){
//                    System.out.println();
//                    System.out.println("Full Name: " + fullName);
//                    System.out.println("Phone: " + phoneNumber);
//                    System.out.println("User Name: " + userName);
//                    System.out.println("Password: " + password);
//                    System.out.println("Pin: " + pin);
//                    System.out.println("Balance: " + balance);

                    officialPhoneList.add(new OfficialPhone(Integer.parseInt(id.toString()),
                            name.toString(),
                            Double.parseDouble(price.toString()),
                            Integer.parseInt(quantity.toString()),
                            manufacturer.toString(),
                            Integer.parseInt(warrantyPeriod.toString()),
                            warrantyCoverage.toString()));

                    count = 0;
                    id = new StringBuilder();
                    name = new StringBuilder();
                    price = new StringBuilder();
                    quantity = new StringBuilder();
                    manufacturer = new StringBuilder();
                    warrantyPeriod = new StringBuilder();
                    warrantyCoverage = new StringBuilder();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return officialPhoneList;
    }
}

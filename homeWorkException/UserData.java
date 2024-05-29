package homeWorkException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserData {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные (Фамилия Имя Отчество дата рождения номер телефона пол): ");
            String userData = scanner.nextLine();
            String[] data = userData.split(" ");

            if (data.length != 6) {
                System.out.println("Ошибка: введено неверное количество данных.");
                return;
            }

            String lastName = data[0];
            String firstName = data[1];
            String patronymic = data[2];
            String dateOfBirth = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (!dateOfBirth.matches("\\d{2}.\\d{2}.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты рождения.");
            }

            if (gender != 'm' && gender != 'f') {
                throw new IllegalArgumentException("Неверный формат пола.");
            }

            String fileName = lastName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(lastName + " " + firstName + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender);
            writer.newLine();
            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

}
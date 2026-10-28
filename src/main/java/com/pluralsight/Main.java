package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
            try {
                FileReader file = new FileReader("src/main/resources/employees.csv");
                BufferedReader reader = new BufferedReader(file);

                String line;
                reader.readLine();
                while ((line = reader.readLine()) != null) {

                    String[] tokens = line.split("[|]");
                    int id = Integer.parseInt(tokens[0]);
                    String name = tokens[1];
                    double hoursWorked = Double.parseDouble(tokens[2]);
                    double payRate = Double.parseDouble(tokens[3]);

                    Employee employee = new Employee(id, name, hoursWorked, payRate);

                    System.out.printf("%d | %s | $%.2f%n",
                            employee.getEmployeeId(),
                            employee.getName(),
                            employee.getGrossPay());


                }
                reader.close();
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

    }

}
package Controllers;

import java.util.Scanner;

public class UserActionController {
    public static Integer getUserInputNumber(String message){
        System.out.println(message);

        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }
}

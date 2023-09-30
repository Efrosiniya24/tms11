package org.example;

public class Regestration {
    private String login;
    private String password;
    private String confirmPassword;

    static void regestration(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if(login.length()>20 || login.contains(" "))
            throw new WrongLoginException("Неверно введен логин");


        if(password.length()>20 || password.contains(" ") || !passwordIsDigit(password) || !password.equals(confirmPassword))
            throw new WrongPasswordException("Неверно введен пароль");

        System.out.println("Логин и пароль были введены верно)");
    }

    static public boolean passwordIsDigit(String password){
        for(char c: password.toCharArray())
            if(Character.isDigit(c))
                return true;
        return false;
    }
}

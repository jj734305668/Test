package lambda.example1;

import lambda.User;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<User> users = new ArrayList<>();
        users.add(new User("a",42));
        users.add(new User("ba",82));
        users.add(new User("ca",12));
        users.add(new User("da",25));
        users.sort(new UserCompare());
        System.out.print(users);
    }
}

package lambda.example2;

import lambda.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            userList.add(new User("ddd" + i,10));
        }
        userList.forEach(user -> {
            user.setAge(user.getAge()+20);
            user.setName(user.getName() + "_");
        });
//        userList.forEach(System.out::println);
        List<User> users = userList.stream().filter(user -> user.getName().contains("1")).collect(Collectors.toList());
        users.forEach(System.out::println);
//        System.out.print(userList);
    }
}

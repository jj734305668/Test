package lambda.example1;

import lambda.User;

import java.util.Comparator;

public class UserCompare implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getAge()-o2.getAge();
    }

}


import java.util.Collections;
import java.util.List;

public class MyUser implements IUser {
    @Override
    public int f1(List<User> t) {
        int maxStatus = Integer.MIN_VALUE;
        for (User user : t) {
            String userName = user.getName();
            if (userName.length() > 1 && Character.isDigit(userName.charAt(1))) {
                maxStatus = Math.max(maxStatus, user.getStatus());
            }
        }
        return maxStatus;
    }
@Override
    public void f2(List<User> t) {
        int size = t.size();
        if (size >= 6) {
            List<User> sublist = t.subList(size - 5, size - 2);
            Collections.reverse(sublist);
        }
    }



    @Override
    public void f3(List<User> t) {
        int maxStatus = Integer.MIN_VALUE;
        User maxStatusUser = null;
        for (User user : t) {
            if (user.getStatus() > maxStatus) {
                maxStatus = user.getStatus();
                maxStatusUser = user;
            }
        }
        if (maxStatusUser != null) {
            t.get(0).setName(maxStatusUser.getName());
        }
    }
}
package junmeng.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author james
 * @date 2020/3/23
 */
public class UserService implements IUserService {

    private static final Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("aa", new User("aa", "aa@163.com"));
        userMap.put("bb", new User("bb", "bb@163.com"));
    }

    @Override
    public User findByName(String userName) {
        return userMap.get(userName);
    }
}

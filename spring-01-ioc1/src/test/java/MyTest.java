import com.xin.dao.UserDaoOracleImpl;
import com.xin.service.UserService;
import com.xin.service.UserServiceImpl;

public class MyTest {

    public static void main(String[] args) {

        //用户实际调用的是业务层，dao层他们不需要接触
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl)userService).setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }

}

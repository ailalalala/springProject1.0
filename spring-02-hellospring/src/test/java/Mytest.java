import com.xin.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        //获取spring上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //现在对象都在spring中管理了。直接从中获取就可以了
        Hello hello = context.getBean("hello",Hello.class);
        hello.show();
    }
}

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;

/**
 * Created by wangxc on 2015/8/16.
 */
public class SayHelloAction extends AnAction {
    public void actionPerformed(AnActionEvent e) {
        Application application = ApplicationManager.getApplication();

        MyComponent myComponent = application.getComponent(MyComponent.class);

        myComponent.sayHello();
    }
}

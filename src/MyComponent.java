import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

/**
 * Created by wangxc on 2015/8/16.
 */
public class MyComponent implements ApplicationComponent {
    public MyComponent() {
    }

    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "MyComponent";
    }


    public void sayHello() {

        // Show dialog with message

        Messages.showMessageDialog(

                "Hello World!",

                "Sample",

                Messages.getInformationIcon()

        );

    }
}

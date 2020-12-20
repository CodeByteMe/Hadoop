package wordCount;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Zhou.Y.M
 * @create 2020/12/20 12:25
 */
public class Property {
    private static Properties prop = new Properties();
    static
    {
        try {
            prop.load(Property.class.getResourceAsStream("/setting.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Properties getProperties()
    {
        return prop;
    }
}

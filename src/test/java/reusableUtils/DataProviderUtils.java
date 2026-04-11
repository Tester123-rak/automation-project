package reusableUtils;

import com.caltech.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name="LoginData")
    public Object[][] loginData() throws Exception{
     ExcelUtils exl=new ExcelUtils();

    return  exl.excelReader();

     }

}

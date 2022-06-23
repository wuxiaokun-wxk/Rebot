import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.DocFlavor;
import java.net.URL;

public class ReviewCalculate {
    //private static String std_design_url;
    final static String STD_DESIGN_URL="https://std-design.skong.com/";
    final static String ID="wuxksjs";
    final static String PASSWORD="123456";


    public static void main  (String[] args) throws Exception{
        WebDriver webDriver=new ChromeDriver();
        //登录desin；
        webDriver.get(STD_DESIGN_URL);
        //窗口最大化；
        webDriver.manage().window().maximize();
        //刚打开时较慢，无法定位元素，设置等待10s；
        Thread.sleep(10000);
        //webDriver.findElement(By.linkText("用户登录"));
        webDriver.findElement(By.id("passport")).sendKeys(ID);
        webDriver.findElement(By.id("password")).sendKeys(PASSWORD);
        webDriver.findElement(By.className("ant-btn-primary")).click();
        //登录之后等待两秒，再定位元素；
        Thread.sleep(2000);
        //点击方案管理
        webDriver.findElement(By.id("schemeManage")).click();
        //搜索方案
        webDriver.findElement(By.className("ant-input")).sendKeys("ReviewCalculate");
        Thread.sleep(1000);
        webDriver.findElement(By.className("ant-input-group-addon")).click();
        //点击编辑按钮
        Thread.sleep(1000);
        webDriver.findElement(By.id("a23938dc2fd44973ac1e0f539a1323d1")).click();
        Thread.sleep(2000);
        System.out.println(webDriver.switchTo().alert().getText());

    }
}

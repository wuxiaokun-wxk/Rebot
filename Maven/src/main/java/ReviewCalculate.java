import org.cyberneko.html.HTMLElements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.Date;
import java.util.Set;

public class ReviewCalculate {
    //private static String std_design_url;
    final static String STD_DESIGN_URL="https://std-design.skong.com/";
    final static String ID="wuxksjs";
    final static String PASSWORD="123456";
    static Log log;


    public static void main  (String[] args) throws Exception{

        WebDriver webDriver=new ChromeDriver();
        //获得当前页面句柄
        String materialHandle = webDriver.getWindowHandle();
        //登录desin；
        webDriver.get(STD_DESIGN_URL);
        //窗口最大化；
        webDriver.manage().window().maximize();
        try {
            //刚打开时较慢，无法定位元素，设置等待时间，最长20s，每1秒检查一次；
            WebDriverWait webDriverWait=new WebDriverWait(webDriver,20,1000);
            //检查元素是否存在
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("passport"))).sendKeys(ID);
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
            //弹窗点击确认跳转到编辑器
            webDriver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div/div/div[2]/button[2]")).click();

            Thread.sleep(10000);
            //获得所有页面的句柄，遍历
            Set<String> allHandles=webDriver.getWindowHandles();
            for(String handle:allHandles){
                //跟material句柄不一样代表是新页面
                if(handle.equals(materialHandle)==false){
                    //切换至方案编辑页面
                    webDriver.switchTo().window(handle);
                    Thread.sleep(5000);
                    //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/header/div/div[2]/div/ul/button[2]"))).click();
                    webDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/header/div/div[2]/div/ul/button[2]")).click();
                    webDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/header/div/div[2]/div/ul/button[2]")).click();
                    webDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/header/div/div[2]/div/ul/button[2]")).click();
                    //点击计算按钮，进入计算页面
                    webDriver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/main/div[1]/div/div[1]/div[5]/div[1]/div/div[3]")).click();
                    Thread.sleep(5000);

                    //新建计算
                    webDriver.findElement(By.className("ant-btn-default")).click();


                }

            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("没有找到元素");
        }

    }
}

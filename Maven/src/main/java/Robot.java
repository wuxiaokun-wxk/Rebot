import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Robot {


        public static void main(String args[]) throws Exception{

            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("https://oapi.dingtalk.com/robot/send?access_token=e882a5ac1a512f57fadc37d6a711e5f4f541c628cf64c7d804d3b465ab213543");
            httppost.addHeader("Content-Type", "application/json; charset=utf-8");

            String textMsg = "{ \"msgtype\": \"text\", \"text\": {\"content\": \"我是老板孔乙己,各位老板想吃啥\"}}";
            StringEntity se = new StringEntity(textMsg, "utf-8");
            httppost.setEntity(se);
            HttpResponse response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                String result= EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(result);
            }
        }



}

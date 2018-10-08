package mailtest;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

public class SendEmail {

    public static void main(String[] args) {
        //收件人电子邮箱
        String to = "*********@qq.com";

        //发件人电子邮箱
        String from = "*********@qq.com";

        String host = "smtp.qq.com";

        //获取系统属性
        Properties properties = System.getProperties();

        //设置邮件服务器
        //properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.host",host);

        properties.put("mail.smtp.auth","true");
        //获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("*********@qq.com","********");
            }
        });

        try {
            //创建默认的MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            //Set From 头部字段
            message.setFrom(new InternetAddress(from));

            //Set To 头部字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //Set Subject 头部字段
            message.setSubject("This is the Subject Line!");

            //设置消息体
            message.setText("java 代码测试~~~~");

            //发送消息
            Transport.send(message);
            System.out.println("send message successfully...from runoob.com");

        }catch(MessagingException mex) {
            mex.printStackTrace();
        }
    }

}

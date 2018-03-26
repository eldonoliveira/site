package site;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class ZccMail {
	
	public void enviarEmailZcc( ZccMailDTO formDTO) {
		try {
			Properties p = new Properties();
			Session session = Session.getInstance(p, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("site@zelocallcenter.com.br", "ZCCenter@1201");
				}
			});

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("site@zelocallcenter.com.br")); // Remetente
			
			/* DEBUG - do envio de e-mail */
			session.setDebug(false);

//			System.out.println(">> Host");
			p.put("mail.smtps.host", "server28.integrator.com.br");

//			System.out.println(">> Auth");
			p.put("mail.smtps.auth", "true");

//			System.out.println(">> Port");
			p.put("mail.smtps.port", "465");

//			System.out.println(">> SMTP");
			Transport t = session.getTransport("smtp");

//			System.out.println(">> Connect");
			t.connect("mail.zelocallcenter.com.br", 587, "site@zelocallcenter.com.br", "ZCCenter@1201");

//			System.out.println(">> SendMessage");
			msg.setSubject("Contato via Site");// Assunto
			msg.setText(formDTO.getMensagem(), "utf-8", "html");
			t.sendMessage(msg, new Address[] { new InternetAddress("eldoneso@gmail.com"),
											   new InternetAddress("suyani.pereira@zelocallcenter.com.br")});
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
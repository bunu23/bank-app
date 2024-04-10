package bank.service;

import bank.domain.AccountChangeEvent;
import bank.integration.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventEmailer {
	@Autowired
	EmailSender emailSender;

	@EventListener
	public void onEvent(AccountChangeEvent event) {
		emailSender.sendEmail("******** email account change event :" + event);
	}

}

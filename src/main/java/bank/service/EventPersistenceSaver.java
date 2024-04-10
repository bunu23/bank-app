package bank.service;

import bank.domain.AccountChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import bank.dao.IAccountChangeEventDAO;

@Component
public class EventPersistenceSaver {
	@Autowired
	private IAccountChangeEventDAO dao;
	
	  @EventListener
	  public void onEvent(AccountChangeEvent event) {
	    System.out.println("******** saving account change event :" + event);
	    dao.save(event);
	  }
}

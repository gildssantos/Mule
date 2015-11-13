package br.com.caelum.aggr;

import java.util.List;

import org.mule.DefaultMuleEvent;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.routing.AggregationContext;
import org.mule.routing.AggregationStrategy;

public class SimpleResponseStrategy implements AggregationStrategy{

	@Override
	public MuleEvent aggregate(AggregationContext context) throws MuleException {

		 List<MuleEvent> a = context.collectEventsWithExceptions();
		for (MuleEvent event : a) {
			throw new RuntimeException(event.toString());
			
		}
		DefaultMuleEvent muleEvent = new DefaultMuleEvent(context.getOriginalEvent(), 
							context.getOriginalEvent().getFlowConstruct());
		
		muleEvent.getMessage().setPayload("<resposta>ok</resposta>");
		
		return muleEvent;
	}

	
	
}

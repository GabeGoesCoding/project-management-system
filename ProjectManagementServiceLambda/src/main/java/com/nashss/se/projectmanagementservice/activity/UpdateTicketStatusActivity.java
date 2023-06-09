package com.nashss.se.projectmanagementservice.activity;

import com.nashss.se.projectmanagementservice.activity.requests.UpdateTicketStatusRequest;
import com.nashss.se.projectmanagementservice.activity.results.UpdateTicketStatusResult;
import com.nashss.se.projectmanagementservice.converters.ProjectModelConverter;
import com.nashss.se.projectmanagementservice.dynamodb.TicketDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Ticket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


public class UpdateTicketStatusActivity {

    private final Logger log = LogManager.getLogger();

    private final TicketDao ticketDao;

    @Inject
    public UpdateTicketStatusActivity(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public UpdateTicketStatusResult handleRequest(final UpdateTicketStatusRequest updateTicketStatusRequest){
        log.info("Received UpdateTicketStatusRequest{}", updateTicketStatusRequest);

        Ticket ticket = ticketDao.getTicket(updateTicketStatusRequest.getProjectId(), updateTicketStatusRequest.getTicketId());

        ticket.setStatus(updateTicketStatusRequest.getStatus());
        ticket = ticketDao.saveTicket(ticket);

        return UpdateTicketStatusResult.builder().withTicket(new ProjectModelConverter().toTicketModel(ticket))
                .build();
    }
}

package com.nashss.se.projectmanagementservice.activity;

import com.nashss.se.projectmanagementservice.activity.requests.UpdateTicketDetailsRequest;
import com.nashss.se.projectmanagementservice.activity.results.UpdateTicketDetailsResult;
import com.nashss.se.projectmanagementservice.converters.ProjectModelConverter;
import com.nashss.se.projectmanagementservice.dynamodb.TicketDao;
import com.nashss.se.projectmanagementservice.dynamodb.models.Ticket;
import com.nashss.se.projectmanagementservice.exceptions.InvalidAttributeValueException;
import com.nashss.se.projectmanagementservice.utils.ProjectManagementServiceUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateTicketDetailsActivity {

    private final Logger log = LogManager.getLogger();
    private final TicketDao ticketDao;

    @Inject
    public UpdateTicketDetailsActivity(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public UpdateTicketDetailsResult handleRequest(UpdateTicketDetailsRequest updateTicketDetailsRequest) {
        log.info("Received UpdatePlaylistRequest {}", updateTicketDetailsRequest);

        if (!ProjectManagementServiceUtils.isValidString(updateTicketDetailsRequest.getTitle())) {
            throw new InvalidAttributeValueException("Ticket name [" + updateTicketDetailsRequest.getTitle() +
                    "] contains illegal characters");
        }

        if (!ProjectManagementServiceUtils.isValidString(updateTicketDetailsRequest.getDescription())) {
            throw new InvalidAttributeValueException("Ticket name [" + updateTicketDetailsRequest.getDescription() +
                    "] contains illegal characters");
        }

        Ticket ticket = ticketDao.getTicket(updateTicketDetailsRequest.getProjectId(), updateTicketDetailsRequest.getTicketId());


        ticket.setTitle(updateTicketDetailsRequest.getTitle());
        ticket.setDescription(updateTicketDetailsRequest.getDescription());
        ticket.setStatus(updateTicketDetailsRequest.getStatus());
        ticket = ticketDao.saveTicket(ticket);

        return UpdateTicketDetailsResult.builder()
                .withTicketModel(new ProjectModelConverter().toTicketModel(ticket))
                .build();
    }
}
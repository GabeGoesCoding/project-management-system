package com.nashss.se.projectmanagementservice.activity.results;

import com.nashss.se.projectmanagementservice.models.TicketModel;

public class CreateTicketResult {

    private final TicketModel ticketModel;

    private CreateTicketResult(TicketModel ticketModel) {
        this.ticketModel = ticketModel;
    }

    public TicketModel getTicketModel() {
        return ticketModel;
    }

    @Override
    public String toString() {
        return "UpdateTicketResult{" +
                "ticketModel=" + ticketModel +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private TicketModel ticketModel;

        public Builder withTicketModel(TicketModel ticketModel) {
            this.ticketModel = ticketModel;
            return this;
        }

        public CreateTicketResult build() {
            return new CreateTicketResult(ticketModel);
        }
    }
}

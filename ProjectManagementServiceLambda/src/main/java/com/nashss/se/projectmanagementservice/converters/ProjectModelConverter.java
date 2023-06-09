package com.nashss.se.projectmanagementservice.converters;

import java.util.ArrayList;
import java.util.List;

import com.nashss.se.projectmanagementservice.dynamodb.models.Project;
import com.nashss.se.projectmanagementservice.dynamodb.models.Ticket;
import com.nashss.se.projectmanagementservice.models.ProjectModel;
import com.nashss.se.projectmanagementservice.models.TicketModel;

public class ProjectModelConverter{
    /**
     * Converts between Data and API models.
     */
        /**
         * Converts a provided {@link Project} into a {@link ProjectModel} representation.
         *
         * @param project the project to convert
         * @return the converted project
         */
        public ProjectModel toProjectModel(Project project) {

            return ProjectModel.builder()
                .withProjectId(project.getProjectId())
                .withTitle(project.getTitle())
                .withDescription(project.getDescription())
                .withStatus(project.getStatus())
                .build();
        }

        /**
         * Converts a provided Ticket into a TicketModel representation.
         *
         * @param ticket the ticket to convert to TicketModel
         * @return the converted SongModel with fields mapped from albumTrack
         */
        public TicketModel toTicketModel(Ticket ticket) {
            return TicketModel.builder()
                .withProjectId(ticket.getProjectId())
                .withTicketId(ticket.getTicketId())
                .withTitle(ticket.getTitle())
                .withDescription(ticket.getDescription())
                .withStatus(ticket.getStatus())
                .build();
        }

    public List<TicketModel> toTicketModelList(List<Ticket> tickets) {
        List<TicketModel> ticketModels = new ArrayList<>();

        for (Ticket ticket : tickets) {
            ticketModels.add(toTicketModel(ticket));
        }

        return ticketModels;
    }

    public List<ProjectModel> toProjectModelList(List<Project> projects) {
        List<ProjectModel> projectModels = new ArrayList<>();

        for (Project project : projects) {
            projectModels.add(toProjectModel(project));
        }

        return projectModels;
    }


    }



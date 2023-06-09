package com.nashss.se.projectmanagementservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = DeleteProjectRequest.Builder.class)
public class DeleteProjectRequest {
    private final String projectId;
    private final String title;
    private final String description;
    private final String status;

    private DeleteProjectRequest(String projectId, String title, String description,String status) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getProjectId() {
        return projectId;
    }

    @Override
    public String toString() {
        return "DeleteProjectRequest{" +
                "title='" + title + '\'' +
                ", projectId='" + projectId + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String title;
        private String projectId;
        private String description;
        private String status;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public DeleteProjectRequest build() {
            return new DeleteProjectRequest(projectId, title, description, status);
        }
    }
}


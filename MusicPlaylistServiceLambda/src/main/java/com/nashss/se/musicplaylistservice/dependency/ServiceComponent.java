package com.nashss.se.musicplaylistservice.dependency;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.*;

import com.nashss.se.musicplaylistservice.activity.requests.DeleteProjectRequest;
import com.nashss.se.musicplaylistservice.activity.*;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.musicplaylistservice.activity.*;
import com.nashss.se.musicplaylistservice.activity.AddSongToPlaylistActivity;
import com.nashss.se.musicplaylistservice.activity.CreatePlaylistActivity;
import com.nashss.se.musicplaylistservice.activity.GetAllTicketsActivity;
import com.nashss.se.musicplaylistservice.activity.GetPlaylistActivity;
import com.nashss.se.musicplaylistservice.activity.GetPlaylistSongsActivity;
import com.nashss.se.musicplaylistservice.activity.GetTicketActivity;
import com.nashss.se.musicplaylistservice.activity.SearchPlaylistsActivity;
import com.nashss.se.musicplaylistservice.activity.UpdatePlaylistActivity;


import com.nashss.se.musicplaylistservice.activity.requests.CreateTicketRequest;
import com.nashss.se.musicplaylistservice.activity.requests.CreateProjectRequest;

import com.nashss.se.musicplaylistservice.activity.requests.UpdateProjectStatusRequest;
import dagger.Component;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the Music Playlist Service.
 */
@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {

    /**
     * Provides the relevant activity.
     * @return AddSongToPlaylistActivity
     */
    AddSongToPlaylistActivity provideAddSongToPlaylistActivity();

    /**
     * Provides the relevant activity.
     * @return CreatePlaylistActivity
     */
    CreatePlaylistActivity provideCreatePlaylistActivity();

    /**
     * Provides the relevant activity.
     * @return GetPlaylistActivity
     */
    GetPlaylistActivity provideGetPlaylistActivity();

    /**
     * Provides the relevant activity.
     * @return GetPlaylistActivity
     */
    SearchPlaylistsActivity provideSearchPlaylistsActivity();

    /**
     * Provides the relevant activity.
     * @return GetPlaylistSongsActivity
     */
    GetPlaylistSongsActivity provideGetPlaylistSongsActivity();

    /**
     * Provides the relevant activity.
     * @return UpdatePlaylistActivity
     */
    UpdatePlaylistActivity provideUpdatePlaylistActivity();

    DeleteTicketActivity provideDeleteTicketActivity();

    DeleteProjectActivity provideDeleteProjectActivity();
    
    GetProjectActivity provideGetProjectActivity();

    CreateTicketActivity provideCreateTicketActivity();
    
    GetTicketActivity provideGetTicketActivity();

    GetAllTicketsActivity provideGetAllTicketsActivity();

    CreateProjectActivity provideCreateProjectActivity();

    UpdateProjectStatusActivity provideUpdateProjectStatusActivity();
}

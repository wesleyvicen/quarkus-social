package io.github.wesleyvicen.quarkussocial.rest;

import io.github.wesleyvicen.quarkussocial.domain.model.Follower;
import io.github.wesleyvicen.quarkussocial.domain.repository.FollowerRepository;
import io.github.wesleyvicen.quarkussocial.domain.repository.UserRepository;
import io.github.wesleyvicen.quarkussocial.rest.dto.FollowerRequest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users/{userId}/followers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowerResource {
    private FollowerRepository repository;
    private UserRepository userRepository;

    @Inject
    public FollowerResource (FollowerRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @PUT
    @Transactional
    public Response followersUser(@PathParam("userId") Long userId, FollowerRequest request){
       var user = userRepository.findById(userId);
       if(user == null){
           return Response.status(Response.Status.NOT_FOUND).build();
       }
       var follower = userRepository.findById(request.getFollowerId());
        var followers = repository.follower(follower, user);

        if(!followers){
            var entity = new Follower();
            entity.setUser(user);
            entity.setFollower(follower);

            repository.persist(entity);
        }

       return Response.status(Response.Status.NO_CONTENT).build();
    }
}

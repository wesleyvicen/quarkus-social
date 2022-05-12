package io.github.wesleyvicen.quarkussocial.rest.dto;

import io.github.wesleyvicen.quarkussocial.domain.model.Follower;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowerResponse {
    private Long id;
    private String name;

    public FollowerResponse(Follower follower){
        this(follower.getId(), follower.getFollower().getName());
    }
}

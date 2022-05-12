package io.github.wesleyvicen.quarkussocial.rest.dto;

import io.github.wesleyvicen.quarkussocial.domain.model.Follower;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowersPerUserResponse {
    private Integer followersCount;
    private List<FollowerResponse> content;

}

package io.github.wesleyvicen.quarkussocial.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowerRequest {
    private Long followerId;
}

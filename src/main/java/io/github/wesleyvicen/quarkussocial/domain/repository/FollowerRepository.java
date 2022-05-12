package io.github.wesleyvicen.quarkussocial.domain.repository;

import io.github.wesleyvicen.quarkussocial.domain.model.Follower;
import io.github.wesleyvicen.quarkussocial.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class FollowerRepository implements PanacheRepository<Follower> {

    public Boolean follower(User follower, User user){
//        Map<String, Object> params = new HashMap<>();
//        params.put("follower", follower);
//        params.put("user", user);

        var params = Parameters.with("follower", follower)
                .and("user", user).map();

        var query = find("follower =:follower and user =:user", params);
        var result = query.firstResultOptional();

        return result.isPresent();
    }
}

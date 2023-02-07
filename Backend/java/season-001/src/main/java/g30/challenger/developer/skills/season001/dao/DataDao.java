package g30.challenger.developer.skills.season001.dao;

import g30.challenger.developer.skills.season001.dto.Data;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "info", path = "infoData")
public interface DataDao extends MongoRepository<Data, String> {

    Long countAllByActiveIsTrue();

}

package g30.challenger.developer.skills.season001.srv;

import g30.challenger.developer.skills.season001.dao.DataDao;
import lombok.RequiredArgsConstructor;

import lombok.extern.apachecommons.CommonsLog;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@CommonsLog
@RequiredArgsConstructor
public class DataSrv {

    private final DataDao dataDao;
    private final MongoTemplate mongoTemplate;

    public List<?> getCountriesGroup() {
        GroupOperation group = Aggregation.group("countryPhone").count().as("counts");

        Aggregation agg = Aggregation.newAggregation(
                group
        );
        return mongoTemplate.aggregate(agg, "info", Map.class).getMappedResults();
    }

    public List<?> getTagsGroup() {
        GroupOperation group = Aggregation.group("tag").count().as("counts");

        Aggregation agg = Aggregation.newAggregation(
                group
        );
        return mongoTemplate.aggregate(agg, "info", Map.class).getMappedResults();
    }

    public Map getTotalActives() {
        var actives = dataDao.countAllByActiveIsTrue();
        var total = dataDao.count();
        return Map.of(
                "actives:", actives,
                "total", total
        );
    }
}

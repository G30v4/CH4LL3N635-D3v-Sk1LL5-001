package g30.challenger.developer.skills.season001.ctrl;

import g30.challenger.developer.skills.season001.srv.DataSrv;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/dashboard")
public class DataCtrl {

    private final DataSrv dataSrv;

    @GetMapping("/countries")
    public List<?> getCountrie() {
        return dataSrv.getCountriesGroup();
    }

    @GetMapping("/tags")
    public List<?> getTags() {
        return dataSrv.getTagsGroup();
    }

    @GetMapping("/actives")
    public Map getActives() {
        return dataSrv.getTotalActives();
    }
}

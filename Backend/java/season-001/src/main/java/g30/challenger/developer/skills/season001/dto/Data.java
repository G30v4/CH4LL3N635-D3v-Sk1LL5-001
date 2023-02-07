package g30.challenger.developer.skills.season001.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "info")
public class Data {
    @Id
    private String id;
    private String email;
    private String mailPass;
    private String phone;
    private String countryPhone;
    private String tag;
    private LocalDateTime createdAt;
    private boolean active;

}

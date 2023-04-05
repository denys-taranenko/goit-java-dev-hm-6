package entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@ToString
@Data
public class Project {
    private int clientId;
    private LocalDate startDate;
    private LocalDate finishDate;
}

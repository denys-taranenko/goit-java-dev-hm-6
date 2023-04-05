package entity;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class MaxProjectClient {
    private int id;
    private String name;
    private int projectCount;
}

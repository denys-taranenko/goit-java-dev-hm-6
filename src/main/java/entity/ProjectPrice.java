package entity;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class ProjectPrice {
    private int id;
    private int price;
}

package org.trial.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    private String id;

    private Long itemCount;
    private String itemName;
    private String itemPrice;
}

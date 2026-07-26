package org.trial.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    private String id;

    @Field("product_name") // Optional: Maps the Java field to a specific key name in the MongoDB document.
    private String name;

    private String description;

    private BigDecimal price;

    private String category;
}

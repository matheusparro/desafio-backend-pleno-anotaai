package com.matheusparro.desafio_java_pleno.domain.Product;

import com.matheusparro.desafio_java_pleno.domain.Category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "product")
public class Product {
    @Id
    @Generated
    private String id;

    private String title;

    private String description;

    private Integer price;

    private String ownerId;

    private String category;

    public Product(ProductDTO productDTO) {
        this.title = productDTO.title();
        this.description = productDTO.description();
        this.price = productDTO.price();
        this.ownerId = productDTO.ownerId();
        this.category = productDTO.categoryId();
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("title", this.title);
        json.put("description", this.description);
        json.put("price", this.price);
        json.put("ownerId", this.ownerId);
        json.put("categoryId", this.category);
        json.put("type", "product");
        return json.toString();

    }

}

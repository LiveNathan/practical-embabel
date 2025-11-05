package dev.nathanlively.data;

import org.springframework.ai.tool.annotation.Tool;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(Long id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Tool
    public boolean isAffordableWithin(BigDecimal budget) {
        return this.price.compareTo(budget) <= 0;
    }

    @Tool
    public boolean matches(String searchTerm) {
        if (searchTerm == null || searchTerm.isBlank()) {
            return false;
        }
        String lower = searchTerm.toLowerCase();
        return name.toLowerCase().contains(lower) ||
               description.toLowerCase().contains(lower);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
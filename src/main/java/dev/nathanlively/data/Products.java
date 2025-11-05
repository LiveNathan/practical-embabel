package dev.nathanlively.data;

import org.springframework.ai.tool.annotation.Tool;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Products {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Products() {
        super();
    }

    @Tool
    public List<Product> findAll() {
        return List.copyOf(products.values());
    }

    @Tool
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Tool
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idGenerator.getAndIncrement());
        }
        products.put(product.getId(), product);
        return product;
    }

    public List<Product> saveAll(Iterable<Product> productsToSave) {
        productsToSave.forEach(this::save);
        return findAll();
    }

    @Tool
    public long count() {
        return products.size();
    }

    public void deleteAll() {
        products.clear();
    }
}

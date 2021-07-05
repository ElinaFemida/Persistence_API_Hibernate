package Hibernate.crud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "title")
        private String title;

        @Column(name = "price")
        private int price;

    @Override
    public String toString() {
        return String.format("Product [id = %d, title = %s, price = %d]", id, title, price);
    }
}


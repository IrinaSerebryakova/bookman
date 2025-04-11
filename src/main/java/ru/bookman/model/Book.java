package ru.bookman.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorCode;
    private String title;
    private int year;
    private String brand;
    private int stock;
    private double price;

    public Book(String vendorCode, String title, int year, String brand, int stock, double price) {
        this.vendorCode = vendorCode;
        this.title = title;
        this.year = year;
        this.brand = brand;
        this.stock = stock;
        this.price = price;
    }

    public Book() {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && stock == book.stock && Double.compare(price, book.price) == 0 && Objects.equals(id, book.id) && Objects.equals(vendorCode, book.vendorCode) && Objects.equals(title, book.title) && Objects.equals(brand, book.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendorCode, title, year, brand, stock, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", vendorCode='" + vendorCode + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}

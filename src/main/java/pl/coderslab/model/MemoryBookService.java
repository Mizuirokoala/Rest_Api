package pl.coderslab.model;


import org.springframework.stereotype.Service;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoryBookService implements BookInterface {

    private List<Book> list;

    public MemoryBookService() {
        this.list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public Book getBook(Long id) {
        return list.stream().filter(book -> book.getId() == id).collect(Collectors.toList()).get(0);
    }

    public void setBook(Book book) {
        this.list.add(book);
    }

    public void bookEdit(Long id, String isbn, String title, String author, String publisher, String type) {
        Book book = list.stream()
                .filter(b -> b.getId() == id)
                .collect(Collectors.toList())
                .get(0);
        book.setIsbn(isbn)
                .setTitle(title)
                .setAuthor(author)
                .setPublisher(publisher)
                .setType(type);

    }
    public void bookDelete(Long id){
        list.remove(list.stream().filter(book -> book.getId()==id).collect(Collectors.toList()).get(0));
    }

}

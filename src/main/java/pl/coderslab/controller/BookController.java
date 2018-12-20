package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.beans.Book;
import pl.coderslab.beans.BookInterface;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookInterface bookInterface;

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book("9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/")
    public List<Book> bookList() {
        return bookInterface.getList();
    }

    @PostMapping("/")
    public String addBook(@RequestBody Book book) {
        bookInterface.setBook(book);
        return " Book create";
    }

    @GetMapping("/{id}")
    public Book book(@PathVariable Long id) {

        return bookInterface.getBook(id);
    }


    @PutMapping("/{id}")
    public String bookEdit(@PathVariable Long id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
        bookInterface.bookEdit(id, isbn, title, author, publisher, type);
        return " Book edit";
    }

    @DeleteMapping("/{id}")
    public String bookDelete(@PathVariable Long id) {
        bookInterface.bookDelete(id);
        return "Book delete";
    }

}
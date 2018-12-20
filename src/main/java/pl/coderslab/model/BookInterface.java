package pl.coderslab.model;

import java.util.List;

public interface BookInterface {

    List<Book> getList();

    void setList(List<Book> list);

    Book getBook(Long id);

    void setBook(Book book);

    void bookEdit(Long id, String isbn, String title, String author, String publisher, String type);

    void bookDelete(Long id);


}


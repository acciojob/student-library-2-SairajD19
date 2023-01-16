package com.driver.services;

import com.driver.models.Book;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

    public void createBook(Book book){

        bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){

        /*i) If genre=”X”, availability = true, and author=null;
        we require the list of all books which are available and have genre “X”.
        Note that these books can be written by any author.*/
//        List<Book> allBooks = bookRepository2.findAll();
//        List<Book> result = new ArrayList<>();
//        if(author==null){
//            for(Book book: allBooks){
//                if(book.getGenre().name()==genre && book.isAvailable()){
//                    result.add(book);
//                }
//            }
//        }
//        else{
//            for(Book book: allBooks){
//                if(book.getGenre().name()==genre && !book.isAvailable() && book.getAuthor().getName()==author){
//                    result.add(book);
//                }
//            }
//        }
        if(genre != null && author != null)
        {
            return bookRepository2.findBooksByGenreAuthor(genre, author, available);
        }
        else if (genre != null)
        {
            return bookRepository2.findBooksByGenre(genre, available);
        }
        else if (author != null)
        {
            return bookRepository2.findBooksByAuthor(author, available);
        }
        else
        {
            return bookRepository2.findByAvailability(available);
        }

        /*ii) If genre=”Y”, availability = false, and author=”A”;
        we require the list of all books which are written by author “A”, have genre “Y”, and are currently unavailable.
        */

        //List<Book> books = null; //find the elements of the list by yourself
        //return result;
    }
}

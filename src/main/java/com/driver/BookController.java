package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable String id){
      Book book = bookService.findBookById(id);
      if(book==null){
          return new ResponseEntity<>(book,HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(book,HttpStatus.FOUND);

    }
    @GetMapping("get-all-books")
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = bookService.findAllBooks();
        return new ResponseEntity<>(list,HttpStatus.FOUND);

    }
    @DeleteMapping("delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id){
       return new ResponseEntity<>("SUCCESS",HttpStatus.ACCEPTED);
    }
   @DeleteMapping("delete-all-books")
    public ResponseEntity<String> deleteAll(){
        return new ResponseEntity<>("SUCCESS",HttpStatus.ACCEPTED);
    }


   @GetMapping("get-books-by-author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam("author") String author){

       List<Book> list = bookService.findAllBooks();
       return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

    public ResponseEntity<List<Book>> findBooksByGenre(String genre){
        List<Book> list = bookService.findAllBooks();
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }
}

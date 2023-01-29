package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
   HashMap<Integer,Book> db;
   int bookid;
    public BookRepository(){

        this.db = new HashMap<>();
        this.bookid=0;

    }

    public Book save(Book book){

       this.bookid++;
       book.setId(bookid);
       db.put(bookid,book);

        return book;
    }

    public Book findBookById(int id){

        return db.get(id);
    }

    public List<Book> findAll(){
        List<Book> list = new ArrayList<>();
        for(int id : db.keySet()){
            list.add(db.get(id));
        }
        return list;
    }

    public void deleteBookById(int id){

        db.remove(id);
        this.bookid--;

    }

    public void deleteAll(){
       db.clear();

    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> list = new ArrayList<>();
        for(int id : db.keySet()) {
            if (db.get(id).getAuthor().equals(author)) {
                list.add(db.get(id));
            }
        }
        return list;

    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list = new ArrayList<>();
        for(int id : db.keySet()) {
            if (db.get(id).getAuthor().equals(genre)) {
                list.add(db.get(id));
            }
        }
        return list;
    }
}


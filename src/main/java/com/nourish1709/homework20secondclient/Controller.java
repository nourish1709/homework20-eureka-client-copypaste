package com.nourish1709.homework20secondclient;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Data
public class Controller {

    private final RestTemplate restTemplate;

    @RequestMapping("/copypaste/{id}")
    public Object copyPaste(@PathVariable("id") int id) {
        String idValue = "random_id_value_" + id;
        Book book = restTemplate.getForObject("http://library/books/" + idValue, Book.class);
        restTemplate.postForEntity("http://library/books", book, Book.class);
        ResponseEntity<Object> booksEntity = restTemplate.getForEntity("http://library/books", Object.class);
        return (List<Book>) booksEntity.getBody();
    }
}

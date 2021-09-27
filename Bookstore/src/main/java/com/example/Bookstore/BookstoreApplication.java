package com.example.Bookstore;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("save a couple of categories");
			categoryRepository.save(new Category("Romance"));
			categoryRepository.save(new Category("Fantasy"));


			log.info("save a couple of books");
			bookRepository.save(new Book("9781781101032", "Harry Potter à l'école des sorciers", "J. K. Rowling", 1997, 9.90, categoryRepository.findByName("Fantasy").get(0)));
			bookRepository.save(new Book("9782709641944", "Fifty Shades of Grey", "E. L. James", 2011, 6.49, categoryRepository.findByName("Romance").get(0)));

			log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			log.info("fetch all students");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}

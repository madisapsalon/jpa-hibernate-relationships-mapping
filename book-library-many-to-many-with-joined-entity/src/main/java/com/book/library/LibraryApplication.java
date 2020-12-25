package com.book.library;

import com.book.library.entity.Book;
import com.book.library.entity.BookPublisher;
import com.book.library.entity.Publisher;
import com.book.library.repository.BookRepository;
import com.book.library.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@RequiredArgsConstructor
@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private PublisherRepository publisherRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Publisher publisherA = new Publisher("Publisher A");
		Publisher publisherB = new Publisher("Publisher B");
		publisherRepository.saveAll(Arrays.asList(publisherA, publisherB));

		bookRepository.save(new Book("Book 1", new BookPublisher(publisherA, new Date()), new BookPublisher(publisherB, new Date())));
		bookRepository.save(new Book("Book 2", new BookPublisher(publisherA, new Date())));
	}
}

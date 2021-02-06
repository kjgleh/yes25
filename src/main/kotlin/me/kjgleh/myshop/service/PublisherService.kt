package me.kjgleh.myshop.service

import me.kjgleh.myshop.repository.PublisherRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PublisherService(
    private var publisherRepository: PublisherRepository
) {

    fun findAllBookTitle(): List<String> {
        val publishers = publisherRepository.findAllBookTitle()
        return publishers.flatMap { publisher ->
            publisher.books.map { book -> book.title }
        }
    }

    @Transactional(readOnly = true)
    fun findAll(): Int {
        val allPublisher = publisherRepository.findAll()
        val sizeOfTotalBooks = allPublisher.sumBy {
            it.books.size
        }
        return sizeOfTotalBooks
    }
}
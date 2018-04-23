package com.gouermazi.sse.service;

import com.gouermazi.sse.bussiness.StockTransaction;
import com.gouermazi.sse.domain.Stock;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * created by tab chan on 2018/04/22
 */
@Service
public class StockTransactionService {
    private List<Stock> stockList = new LinkedList<>();
    public Flux<StockTransaction> getStockTransactions() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        interval.subscribe(
                (i) -> stockList.forEach(
                        stock -> stock.setPrice(i.floatValue())));
        Flux<StockTransaction> stockTransactionFlux = Flux.fromStream(Stream.generate(() -> new StockTransaction(getRandomUser(), getRandomStock(), new Date())));
        return Flux.zip(interval, stockTransactionFlux).map(Tuple2::getT2);
    }

    private Stock getRandomStock() {
        return new Stock(UUID.randomUUID().toString(),new Random().nextFloat());
    }

    private String getRandomUser() {
        return UUID.randomUUID().toString();
    }
}

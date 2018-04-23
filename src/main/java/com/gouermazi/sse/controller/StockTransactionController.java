package com.gouermazi.sse.controller;

import com.gouermazi.sse.bussiness.StockTransaction;
import com.gouermazi.sse.service.StockTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * created by tab chan on 2018/04/22
 */
@RestController
@RequestMapping("/stock/transaction")
class StockTransactionController {
    @Autowired
    StockTransactionService stockTransactionService;
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<StockTransaction> stockTransactionEvents(){
        return stockTransactionService.getStockTransactions();
    }
}
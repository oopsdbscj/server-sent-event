package com.gouermazi.sse.bussiness;

import com.gouermazi.sse.domain.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/**
 * created by tab chan on 2018/04/22
 */
@Data
@AllArgsConstructor
public class StockTransaction {
    String user;
    Stock stock;
    Date when;
}

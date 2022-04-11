package com.sip.ams.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Article;
import com.sip.ams.entities.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {


}




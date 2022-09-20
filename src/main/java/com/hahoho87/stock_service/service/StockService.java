package com.hahoho87.stock_service.service;

import org.springframework.stereotype.Service;

import com.hahoho87.stock_service.repository.StockRepository;

@Service
public class StockService {

	private final StockRepository stockRepository;

	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	public void decrease(Long id, Long quantity) {
		stockRepository.findById(id).ifPresent(stock -> {
			stock.decrease(quantity);
			stockRepository.save(stock);
		});
	}
}

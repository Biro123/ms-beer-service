package com.oldman.msbeerservice.bootstrap;

import com.oldman.msbeerservice.domain.Beer;
import com.oldman.msbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 *  Class to create some initial data in the repository
 */
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Black Sheep")
                    .beerStyle("Ale")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(33701000001L)
                    .price(new BigDecimal("3.15"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Shipyard")
                    .beerStyle("IPA")
                    .quantityToBrew(100)
                    .minOnHand(12)
                    .upc(33701000002L)
                    .price(new BigDecimal("2.95"))
                    .build());
        }

        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}

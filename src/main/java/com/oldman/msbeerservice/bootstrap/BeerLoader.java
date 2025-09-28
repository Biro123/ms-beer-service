package com.oldman.msbeerservice.bootstrap;

import com.oldman.msbeerservice.domain.Beer;
import com.oldman.msbeerservice.repositories.BeerRepository;
import com.oldman.msbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 *  Class to create some initial data in the repository
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Black Sheep")
                    .beerStyle(BeerStyleEnum.ALE.name())
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("3.15"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Shipyard")
                    .beerStyle(BeerStyleEnum.IPA.name())
                    .quantityToBrew(100)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("2.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("XB")
                    .beerStyle(BeerStyleEnum.ALE.name())
                    .quantityToBrew(80)
                    .minOnHand(19)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("3.05"))
                    .build());

            log.info("Pre-Loaded Beers: {}", beerRepository.count());
        }

    }
}

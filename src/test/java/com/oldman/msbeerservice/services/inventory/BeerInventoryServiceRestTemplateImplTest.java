package com.oldman.msbeerservice.services.inventory;

import com.oldman.msbeerservice.bootstrap.BeerLoader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled // utility for manual testing
@SpringBootTest
class BeerInventoryServiceRestTemplateImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @Test
    void getOnhandInventory() {
        Integer qoh = beerInventoryService.getOnhandInventory(BeerLoader.BEER_1_UUID);

        System.out.println(qoh);
    }

}
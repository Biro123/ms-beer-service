package com.oldman.msbeerservice.web.mappers;

import com.oldman.msbeerservice.domain.Beer;
import com.oldman.msbeerservice.services.inventory.BeerInventoryService;
import com.oldman.msbeerservice.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper{
    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        BeerDto dto = mapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto dto) {
        return mapper.beerDtoToBeer(dto);
    }
}

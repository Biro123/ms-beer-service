package com.oldman.msbeerservice.web.mappers;

import com.oldman.msbeerservice.domain.Beer;
import com.oldman.msbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper( uses = DateMapper.class )
public interface BeerMapper {
    BeerDto BeerToBeerDto(Beer beer);
    Beer BeerDtoToBeer(BeerDto dto);
}

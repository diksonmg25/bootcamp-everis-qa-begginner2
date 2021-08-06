package com.github.diksonferreira.citiesapi.countries.repository;

import com.github.diksonferreira.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}

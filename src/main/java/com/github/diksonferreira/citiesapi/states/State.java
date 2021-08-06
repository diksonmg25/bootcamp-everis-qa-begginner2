package com.github.diksonferreira.citiesapi.states;

import com.github.diksonferreira.citiesapi.countries.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;
import java.util.List;

    @Entity(name = "State")
    @Table(name = "estado")
    @TypeDefs({
            @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
    })
    public class State {

        @Id
        private Long id;

        @Column(name = "nome")
        private String name;

        private String uf;

        private Integer ibge;

        // 1st --- esse country faz referencia somente ao id do "pais"
        /*@Column(name = "pais")
        private Integer countryId;*/

        // 2nd - @ManyToOne
        @ManyToOne
        @JoinColumn(name = "pais", referencedColumnName = "id")
        private Country country; // esse country referencia não somente ao id mas a entidade "pais"

        @Type(type = "jsonb")
        @Basic(fetch = FetchType.LAZY)
        @Column(name = "ddd", columnDefinition = "jsonb")
        private List<Integer> ddd;

        public State() {
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUf() {
            return uf;
        }

        public Integer getIbge() {
            return ibge;
        }

        public List<Integer> getDdd() {
            return ddd;
        }


        //traz a entidade do pais
        public Country getCountry() {
            return country;
        }

        // Traz como resultado o id do pais como um inteiro
        /*public Integer getCountryId() {
          return countryId;
       }*/

    }


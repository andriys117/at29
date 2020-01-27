package com.lits.sohanskyy.assignment.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchBookModel {

    @JsonProperty("hits")
    private ArrayList<BookModel> hits;

    public ArrayList<BookModel> getHits() {
        return hits;
    }

    public void setHits(ArrayList<BookModel> hits) {
        this.hits = hits;
    }
}

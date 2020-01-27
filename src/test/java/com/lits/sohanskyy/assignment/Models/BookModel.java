package com.lits.sohanskyy.assignment.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookModel {

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public HighlightResult getHighlightResult() {
        return highlightResult;
    }

    public void setHighlightResult(HighlightResult highlightResult) {
        this.highlightResult = highlightResult;
    }

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("author")
    private String author;

    @JsonProperty("publishDate")
    private String publishDate;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("objectID")
    private String objectID;

    @JsonProperty("_highlightResult")
    private HighlightResult highlightResult;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class HighlightResult{
        public Information getAuthor() {
            return author;
        }

        public void setAuthor(Information author) {
            this.author = author;
        }

        public Information getIsbn() {
            return isbn;
        }

        public void setIsbn(Information isbn) {
            this.isbn = isbn;
        }

        @JsonProperty("author")
        private Information author;

        @JsonProperty("isbn")
        private Information isbn;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Information{
            @JsonProperty("value")
            private String value;

            @JsonProperty("matchLevel")
            private String matchLevel;

            @JsonProperty("matchedWords")
            private ArrayList matchedWords;

            public ArrayList getMatchedWords() {
                return matchedWords;
            }

            public void setMatchedWords(ArrayList matchedWords) {
                this.matchedWords = matchedWords;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getMatchLevel() {
                return matchLevel;
            }

            public void setMatchLevel(String matchLevel) {
                this.matchLevel = matchLevel;
            }
        }
    }
}


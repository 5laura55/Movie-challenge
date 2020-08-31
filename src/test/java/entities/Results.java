package entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"page", "results", "total_pages", "total_results"})
public class Results {
    private String page;
    private List<FavoriteMovie> results;
    private String total_pages;
    private String total_results;

    public Results() {

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<FavoriteMovie> getResults() {
        return results;
    }

    public void setResults(List<FavoriteMovie> results) {
        this.results = results;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }
}

package tests;

import api.API;
import entities.Results;
import helpers.TestEnvironment;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class RatingMediaTest {
    private static API api;

    @BeforeClass
    public static void before() {
        api = new API(TestEnvironment.API_KEY);

    }

    @Test()
    public void testRateMovie() {
        Response rta = api.rateMovie("577922", "4.5");
        Assert.assertEquals(201, rta.getStatusCode());

    }

    @Test()
    public void testRateTvShow() {

        Response rta = api.rateTvShow("63174", "3.5");
        Assert.assertEquals(201, rta.getStatusCode());

    }

    @Test()
    public void testRateTvEpisode() {

        Response rta = api.rateEpisode("63174", "2", "2", "4.5");
        Assert.assertEquals(201, rta.getStatusCode());

    }

    //extra feature
    @Test()
    public void testFavoriteMoviesToObjects() {
        Response rta = api.getFavoritesMovies();
        Results result = rta.as(Results.class);
        Assert.assertEquals("Joker",result.getResults().get(0).getTitle());
    }


}

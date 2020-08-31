package tests;

import api.API;
import helpers.TestEnvironment;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.response.Response;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ListTest {
    private static API api;

    @BeforeClass
    public static void before() {
        api = new API(TestEnvironment.API_KEY);

    }

    @Test()
    public void testCreateList() {
        Response rta = api.createList("ejemplo", "Just an awesomeeeeeee", "en");
        Assert.assertEquals(201, rta.getStatusCode());

    }

    @Test()
    public void testGetDetailsOfAList() {
        Response rta = api.getDetails("1");
        Assert.assertEquals(200, rta.getStatusCode());

    }

    @Test()
    public void checkMovieInAList() {

        Response rta = api.checkItemStatus("1", "284053");
        Assert.assertEquals(200, rta.getStatusCode());

    }

    @Test()
    public void testAddMovie() {

        Response rta = api.addMovie("7056430");
        Assert.assertEquals(201, rta.getStatusCode());

    }

    @Test()
    public void testRemoveMovie() {
        Response rta = api.removeMovie("7056430");
        Assert.assertEquals(200, rta.getStatusCode());

    }

    @Test()
    public void testClearList() {
        int listNumer = api.createList("This a great list", "Just an awesomeeeeeee", "en").then().extract().path("list_id");
        Response rta = api.clearList(listNumer + "");
        Assert.assertEquals(201, rta.getStatusCode());

    }

    //no sirve
    @Test()
    public void testDeleteList() {
        int listNumer = api.createList("tryyy", "Just an awesomeeeeeee", "en").then().extract().path("list_id");

        Response rta = api.deleteList(listNumer + "");

        Assert.assertEquals(200, rta.getStatusCode());

    }


}

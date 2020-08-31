package tests;


import api.API;

import helpers.TestEnvironment;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AuthenticationTest {


    private static API api;

    @BeforeClass
    public static void before() {
        api = new API(TestEnvironment.API_KEY);

    }

    @Test
    public void testCreateGuestSession() {
        Response rta = api.createGuestSession();
        Assert.assertEquals(200, rta.getStatusCode());
    }

    @Test
    public void testGetRequestToken() {
        String rta = api.getRequestToken();
        System.out.println(rta);
        Assert.assertNotNull(rta);

    }

    @Test()
    public void testCreateSessionWithLogin() {

        Response rta = api.createSessionWithLogin();
        Assert.assertEquals(200, rta.getStatusCode());
    }

    @Test()
    public void testCreateSession() {

        Response rta = api.createSession();
        Assert.assertEquals(200, rta.getStatusCode());
    }

    @Test()
    public void testDeleteSession() {

        Response rta = api.deleteSession();
        Assert.assertEquals(200, rta.getStatusCode());
    }

}

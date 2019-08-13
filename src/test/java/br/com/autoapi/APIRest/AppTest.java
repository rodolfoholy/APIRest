package br.com.autoapi.APIRest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import io.restassured.http.ContentType;


public class AppTest {

	@Test
	public void TestesAPI(){
		baseURI = "https://viacep.com.br/ws/06454000/json/";
	
	
		given()
			.relaxedHTTPSValidation()
			.contentType("application/json")
			.body(baseURI);
		when()
			.get(baseURI)
		.then()
			.statusCode(200) // O status http retornado foi 200
			.contentType(ContentType.JSON) // O response foi retornado no formato JSON
			.body("cep", is("06454-000"))
			.body("logradouro", is("Alameda Rio Negro"))
			.body("localidade", is("Barueri"))
			.body("uf", is("SP"));
	
	}
}

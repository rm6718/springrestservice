import com.ironyard.desserts.dto.Photos;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by reevamerchant on 10/27/16.
 */
public class TestApi {
    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplate();
        //Photos[] albums = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", Photos[].class);
        // to get around the API security
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<Photos[]> respEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/photos",
                HttpMethod.GET, entity, Photos[].class);
        Photos[] albums = respEntity.getBody();
        System.out.println(albums);
    }

}

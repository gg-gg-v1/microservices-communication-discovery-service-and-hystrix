package io.sample.moviecatalogservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.sample.moviecatalogservice.models.CatalogItem;
import io.sample.moviecatalogservice.models.Movie;
import io.sample.moviecatalogservice.models.Rating;
import io.sample.moviecatalogservice.models.UserRating;
import io.sample.moviecatalogservice.services.MovieInfo;
import io.sample.moviecatalogservice.services.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieInfo movieInfo;

    @Autowired
    private UserRatingInfo userRatingInfo;



    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating ratings = userRatingInfo.getUserRating(userId);
//        List<Rating> ratings = Arrays.asList(
//                new Rating("12345", 4),
//                new Rating("5678", 5));

        return ratings.getUserRating().stream().map(rating -> {
            return movieInfo.getCatalogItem(rating);
        }).collect(Collectors.toList());

    }







}

package com.example.boringapp.client;


import com.example.boringapp.contract.ActivityDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;

@Component
public class ActivityClient {
    RestTemplate restClient=new RestTemplate();
@Value("${external.server.url}")
    String baseUrl;

    public RestTemplate getRestClient() {
        return restClient;
    }

    public void setRestClient(RestTemplate restClient) {
        this.restClient = restClient;
    }

    public String getBaseUrl() {
        return baseUrl;
    }


    public ActivityDto getActivity()
    {
        var url=baseUrl;
        return restClient.getForObject(url, ActivityDto.class);
    }
    public ActivityDto CallApiByType(String type)
    {
     //   final var url=buildUri("http://www.boredapi.com/api/activity?type="+type);
        final var url="http://www.boredapi.com/api/activity?type="+type;
        System.out.println("?type="+type);
        return restClient.getForObject(url, ActivityDto.class);
    }
    private String buildUri(String type)
    {
        return URLEncoder.encode(baseUrl+type);
    }
    public Activity convertDto(ActivityDto activityDto)
    {   Activity activity1=new Activity();
        activity1.setActivity(activityDto.activity);
        activity1.setAccessibility(activityDto.accessibility);
        activity1.setPrice(activityDto.price);
        activity1.setType(activityDto.type);
        activity1.setLink(activityDto.link);
        activity1.setParticipants(activityDto.participants);
        activity1.setKey(activityDto.key);
        return activity1;
    }
}

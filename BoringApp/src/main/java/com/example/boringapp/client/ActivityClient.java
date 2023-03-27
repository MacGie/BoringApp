package com.example.boringapp.client;


import com.example.boringapp.contract.ActivityDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActivityClient {
    RestTemplate restClient=new RestTemplate();

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

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public ActivityDto getActivity()
    {
        var url=baseUrl+"/";
        return restClient.getForObject(url, ActivityDto.class);
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

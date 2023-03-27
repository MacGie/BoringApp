package com.example.boringapp.service;


import com.example.boringapp.Repository.ActivityRepository;
import com.example.boringapp.client.Activity;
import com.example.boringapp.client.ActivityClient;
import com.example.boringapp.contract.ActivityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    ActivityClient activityClient= new ActivityClient();
    ActivityRepository activityRepository;
    @Autowired
    public ActivityService(ActivityRepository activityRepository) {

      this.activityRepository=activityRepository;
    }
    public Activity getActivity()
    {

        return activityClient.convertDto(activityClient.getActivity());
    }

    public Iterable<Activity> fall()
    {
        return activityRepository.findAll();
    }
    public void saveActivity(Activity activity1){
    activityRepository.save(activity1);

    }
    public Activity getActivityByType(String type)
    {

       return activityClient.convertDto(activityClient.CallApiByType(type));
    }

}

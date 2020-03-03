package tests.internetoff;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;

import com.example.testdeeplink.MainActivity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import tests.helper.Deeplink;
import tests.helper.SharedPrefs;

import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

/*
@RunWith(AndroidJUnit4.class)
public class Test20DeeplinkTest
{
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class, true, false);

    SharedPrefs store;

    Deeplink deeplink;

    @Before
    public void setUp() throws Exception
    {
        this.deeplink = new Deeplink();
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(deeplink.getDeeplink()))
                .setPackage(getTargetContext().getPackageName());
        activityTestRule.launchActivity(intent);
        store = new SharedPrefs(getInstrumentation().getTargetContext());
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void withdeeplink_test() throws InterruptedException
    {
        getActivityInstance();
        Assert.assertNotEquals(activityTestRule.getActivity().getClass().getName(), currentActivity.getClass().getName());
        Assert.assertTrue(store.containsDeeplink());
        Assert.assertEquals(this.deeplink.getDeeplink(), store.getDeeplink());
        Assert.assertFalse(store.containsFinallink());
    }

    Activity currentActivity = null;

    public Activity getActivityInstance(){
        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection<Activity> resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                for (Activity activity: resumedActivities){
                    currentActivity = activity;
                    break;
                }
            }
        });

        return currentActivity;
    }
}*/
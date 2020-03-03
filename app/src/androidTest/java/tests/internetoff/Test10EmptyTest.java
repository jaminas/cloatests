package tests.internetoff;

import android.app.Activity;
import android.content.Intent;
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
import tests.helper.SharedPrefs;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

/*
@RunWith(AndroidJUnit4.class)
public class Test10EmptyTest
{
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class, true, false);

    SharedPrefs store;

    @Before
    public void setUp() throws Exception
    {
        activityTestRule.launchActivity(new Intent());
        store = new SharedPrefs(getInstrumentation().getTargetContext());
        store.clear();
    }

    @After
    public void tearDown() throws Exception
    {
        store.clear();
    }

    @Test
    public void nointernet_test() throws InterruptedException
    {
        getActivityInstance();
        Assert.assertNotEquals(activityTestRule.getActivity().getClass().getName(), currentActivity.getClass().getName());
        Assert.assertFalse(store.containsDeeplink());
        Assert.assertFalse(store.containsFinallink());
    }

    Activity currentActivity = null;

    public Activity getActivityInstance(){
        getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection<Activity> resumedActivities =
                        ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                for (Activity activity: resumedActivities){
                    Log.d("-----", "Your current activity: " + activity.getClass().getName());
                    currentActivity = activity;
                    break;
                }
            }
        });

        return currentActivity;
    }

}
*/
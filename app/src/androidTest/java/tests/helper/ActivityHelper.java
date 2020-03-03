package tests.helper;

import android.app.Activity;
import android.util.Log;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;

import org.junit.Assert;

import java.util.Collection;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

public class ActivityHelper
{
    public static void checkMainActivity(final ActivityTestRule atr)
    {
        getInstrumentation().runOnMainSync(new Runnable()
        {
            public void run() {
                Collection<Activity> resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Log.i("----------", "Main size: " + resumedActivities.size());
                Assert.assertTrue((resumedActivities.size() > 0));
                for (Activity activity: resumedActivities)
                {
                    Log.d("-----", "Main activity: " + activity.getClass().getName());
                    Assert.assertEquals(atr.getActivity().getClass().getName(), activity.getClass().getName());
                    break;
                }
            }
        });
    }

    public static void checkCloakaActivity(final ActivityTestRule atr)
    {
        getInstrumentation().runOnMainSync(new Runnable()
        {
            public void run() {
                Collection<Activity> resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Log.i("----------", "Cloaka size: " + resumedActivities.size());
                Assert.assertTrue(resumedActivities.size() > 0);
                for (Activity activity: resumedActivities)
                {
                    Log.d("-----", "Cloaka activity: " + activity.getClass().getName());
                    Assert.assertNotEquals(atr.getActivity().getClass().getName(), activity.getClass().getName());
                    break;
                }
            }
        });
    }

    public static void checkNoActivity(final ActivityTestRule atr)
    {
        getInstrumentation().runOnMainSync(new Runnable()
        {
            public void run() {
                Collection<Activity> resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Log.i("----------", "No activity size: " + resumedActivities.size());
                Assert.assertTrue(resumedActivities.size() == 0);
            }
        });
    }
}

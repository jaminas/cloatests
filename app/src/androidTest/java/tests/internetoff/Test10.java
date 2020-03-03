package tests.internetoff;

import com.example.testdeeplink.MainActivity;

import android.content.Intent;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import tests.helper.ActivityHelper;
import tests.helper.SharedPrefs;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class Test10
{
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    SharedPrefs store;

    @Before
    public void setUp() throws Exception
    {
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
        ActivityHelper.checkCloakaActivity(activityTestRule);
        Assert.assertFalse(store.containsDeeplink());
        Assert.assertFalse(store.containsFinallink());
    }
}
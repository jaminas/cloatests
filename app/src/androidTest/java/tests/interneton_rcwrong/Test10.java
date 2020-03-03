package tests.interneton_rcwrong;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.example.testdeeplink.MainActivity;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import tests.helper.ActivityHelper;
import tests.helper.SharedPrefs;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

/*
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
    public void empty_test() throws InterruptedException
    {
        ActivityHelper.checkMainActivity(this.activityTestRule);
        Thread.sleep(2000);
        ActivityHelper.checkCloakaActivity(this.activityTestRule);

        Assert.assertFalse(store.containsDeeplink());
        Assert.assertFalse(store.containsFinallink());
    }
}*/

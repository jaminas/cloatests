package tests.internetoff;

import {PACKAGE}.MainActivity;

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
public class Test30
{
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    SharedPrefs store;

    @Before
    public void setUp() throws Exception
    {
        store = new SharedPrefs(getInstrumentation().getTargetContext());
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void withoutdeeplink_test() throws InterruptedException
    {
        ActivityHelper.checkCloakaActivity(activityTestRule);
        Assert.assertTrue(store.containsDeeplink());
        Assert.assertFalse(store.containsFinallink());
    }
}
package tests.internetoff;

import {PACKAGE}.MainActivity;

import android.content.Intent;
import android.net.Uri;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import tests.helper.ActivityHelper;
import tests.helper.Deeplink;
import tests.helper.SharedPrefs;
import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class Test40
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
        store.clear();
    }

    @Test
    public void rewritedeeplink_test() throws InterruptedException
    {
        ActivityHelper.checkCloakaActivity(activityTestRule);
        Assert.assertTrue(store.containsDeeplink());
        Assert.assertEquals(this.deeplink.getDeeplink(), store.getDeeplink());
        Assert.assertFalse(store.containsFinallink());
    }
}
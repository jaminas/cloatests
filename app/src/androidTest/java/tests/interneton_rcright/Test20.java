package tests.interneton_rcright;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import android.webkit.URLUtil;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import com.example.testdeeplink.BuildConfig;
import com.example.testdeeplink.MainActivity;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import tests.helper.ActivityHelper;
import tests.helper.Deeplink;
import tests.helper.SharedPrefs;
import static androidx.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Диплинк пришел. RemoteConfig пришел
 *
@RunWith(AndroidJUnit4.class)
public class Test20
{
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class, true, false);

    SharedPrefs store;

    Deeplink deeplink;

    private UiDevice mDevice;

    @Before
    public void setUp() throws Exception
    {
        mDevice = UiDevice.getInstance(getInstrumentation());
        assertThat(mDevice, notNullValue());

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
    public void withdeeplink_test() throws InterruptedException, UiObjectNotFoundException, GooglePlayServicesNotAvailableException, IOException, GooglePlayServicesRepairableException
    {
        ActivityHelper.checkMainActivity(this.activityTestRule);
        Thread.sleep(2000);
        ActivityHelper.checkNoActivity(this.activityTestRule);

        Assert.assertTrue(store.containsDeeplink());
        Assert.assertTrue(store.containsFinallink());
        Assert.assertEquals(this.deeplink.getDeeplink(), store.getDeeplink());

        String finallink = store.getFinallink();
        Log.i("-----------", "Finallink in test: " + finallink);

        Assert.assertTrue(URLUtil.isValidUrl(finallink)&& (URLUtil.isHttpsUrl(finallink) || URLUtil.isHttpUrl(finallink)));

        UiObject urlbar = new UiObject(new UiSelector().resourceId("com.android.chrome:id/url_bar"));
        assertThat(urlbar, notNullValue());
        String url_from_bar = urlbar.getText();
        Log.i("------------", "url_bar: " + url_from_bar);
        Assert.assertTrue(finallink.contains(url_from_bar));

        String device_id = Settings.Secure.getString(activityTestRule.getActivity().getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.i("-----------", "device_id in test: " + device_id);

        AdvertisingIdClient.Info idInfo = AdvertisingIdClient.getAdvertisingIdInfo(activityTestRule.getActivity());
        String advert_id = idInfo.getId();
        Log.i("-----------", "advert_ID is test: " + advert_id);

        Assert.assertTrue(finallink.contains("/" +  deeplink.getDl() + "/"));
        Assert.assertTrue(finallink.contains("/" + BuildConfig.APPLICATION_ID + "/"));
        Assert.assertTrue(finallink.contains("device_id=" + device_id + "&"));
        Assert.assertTrue(finallink.contains("internal_sub_id_1=" + advert_id + "&"));
        Assert.assertTrue(finallink.contains("&sub_id_1=" + deeplink.getSub1() + "&"));
        Assert.assertTrue(finallink.contains("&sub_id_2=" + deeplink.getSub2() + "&"));
        Assert.assertTrue(finallink.contains("&sub_id_3=" + deeplink.getSub3() + "&"));
        Assert.assertTrue(finallink.contains("&sub_id_4=" + deeplink.getSub4() + "&"));
        Assert.assertTrue(finallink.contains("&sub_id_5=" + deeplink.getSub5() + "&"));
    }
}*/
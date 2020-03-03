package tests.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs
{
    public static final String STORE_NAME          = "settings";
    public static final String DEEPLINK_STORE_NAME = "deeplink";
    public static final String FINALLINK_STORE_NAME = "link";

    SharedPreferences sharedPreferences;

    public SharedPrefs(Context context)
    {
        sharedPreferences = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);
    }

    public void clear()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public boolean containsDeeplink(){
        return sharedPreferences.contains(DEEPLINK_STORE_NAME);
    }

    public boolean containsFinallink(){
        return sharedPreferences.contains( FINALLINK_STORE_NAME);
    }

    public String getDeeplink() {
        return sharedPreferences.getString(DEEPLINK_STORE_NAME, "");
    }

    public String getFinallink() {
        return sharedPreferences.getString(FINALLINK_STORE_NAME, "");
    }
}

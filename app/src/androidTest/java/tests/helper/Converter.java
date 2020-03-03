package tests.helper;

import android.app.Activity;
import android.provider.Settings;

import java.util.regex.PatternSyntaxException;

public class Converter
{
    String appId    = "";
    String deviceId = "";
    String advertId = "";
    String dl       = "";
    String sub_id_1 = "";
    String sub_id_2 = "";
    String sub_id_3 = "";
    String sub_id_4 = "";
    String sub_id_5 = "";

    static String regex1 = "\\{";
    static String regex2 = "\\}";
    static String app_id_key = regex1+ "app_id" + regex2;
    static String deeplink_key = regex1+ "deeplink" + regex2;
    static String device_id_key = regex1+ "device_id" + regex2;
    static String is_vm_key = regex1+ "is_vm" + regex2;
    static String sub_id_1_key = regex1+ "sub_id_1" + regex2;
    static String sub_id_2_key = regex1+ "sub_id_2" + regex2;
    static String sub_id_3_key = regex1+ "sub_id_3" + regex2;
    static String sub_id_4_key = regex1+ "sub_id_4" + regex2;
    static String sub_id_5_key = regex1+ "sub_id_5" + regex2;

    static String internal_sub_id_1_key = regex1+ "advertising_id" + regex2;
    static String internal_sub_id_2_key = regex1+ "appsflyer_id" + regex2;

    public String fillTemplate(Activity activity, String template, String deeplink)
    {
        this.parseDeeplinkSting(deeplink);



        String outputLink = template;
        try
        {
            outputLink = outputLink.replaceAll(app_id_key, this.appId);
            outputLink = outputLink.replaceAll(deeplink_key, this.dl);
            outputLink = outputLink.replaceAll(device_id_key, this.deviceId);
            outputLink = outputLink.replaceAll(is_vm_key, "1");

            outputLink = outputLink.replaceAll(sub_id_1_key, this.sub_id_1);
            outputLink = outputLink.replaceAll(sub_id_2_key, this.sub_id_2);
            outputLink = outputLink.replaceAll(sub_id_3_key, this.sub_id_3);
            outputLink = outputLink.replaceAll(sub_id_4_key, this.sub_id_4);
            outputLink = outputLink.replaceAll(sub_id_5_key, this.sub_id_5);

            outputLink = outputLink.replaceAll(internal_sub_id_1_key, this.advertId);

            outputLink = outputLink.replaceAll(internal_sub_id_2_key, ""); // MainActivity.appsflyerId
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
        return outputLink;
    }

    private void parseDeeplinkSting(String s)
    {
        String[] stringParts = s.split("://");
        s  = stringParts[stringParts.length - 1];
        stringParts = s.split("\\?");
        s  = stringParts[stringParts.length - 1];

        String[] pairs = s.split("&");

        for (String pair: pairs)
        {
            String[] kv = pair.split("=");
            if (kv.length == 2)
            {
                if ("dl".equals(kv[0])) {
                    this.dl = kv[1];
                } else if ("sub_id_1".equals(kv[0])) {
                    this.sub_id_1 = kv[1];
                } else if ("sub_id_2".equals(kv[0])) {
                    this.sub_id_2 = kv[1];
                } else if ("sub_id_3".equals(kv[0])) {
                    this.sub_id_3 = kv[1];
                } else if ("sub_id_4".equals(kv[0])) {
                    this.sub_id_4 = kv[1];
                } else if ("sub_id_5".equals(kv[0])) {
                    this.sub_id_5 = kv[1];
                }
            }
        }
    }

}

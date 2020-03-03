package tests.helper;

import android.content.Intent;
import android.net.Uri;

import java.util.Random;

import static androidx.test.InstrumentationRegistry.getTargetContext;

public class Deeplink
{
    final static String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";

    String scheme = "app";
    String host = "";
    String path = "/";
    String param_dl;
    String param_sub1;
    String param_sub2;
    String param_sub3;
    String param_sub4;
    String param_sub5;
    String deeplink;

    private String getRandomString(int length)
    {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++)
        {
            builder.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return builder.toString();
    }

    public String getDeeplink()
    {
        if (this.deeplink == null)
        {
            this.param_dl   = this.getRandomString(8);
            this.param_sub1 = this.getRandomString(8);
            this.param_sub2 = this.getRandomString(8);
            this.param_sub3 = this.getRandomString(8);
            this.param_sub4 = this.getRandomString(8);
            this.param_sub5 = this.getRandomString(8);

            this.deeplink = this.scheme + "://" + this.host + "" + this.path + "?dl=" + this.param_dl + "&sub_id_1=" + this.param_sub1 + "&sub_id_2=" + this.param_sub2 + "&sub_id_3=" + this.param_sub3 + "&sub_id_4=" + this.param_sub4 + "&sub_id_5=" + this.param_sub5;
        }

        return this.deeplink;
    }

    public String getScheme()
    {
        return this.scheme;
    }

    public String getHost()
    {
        return this.host;
    }

    public String getPath()
    {
        return this.path;
    }

    public String getDl()
    {
        return this.param_dl;
    }

    public String getSub1()
    {
        return this.param_sub1;
    }

    public String getSub2()
    {
        return this.param_sub2;
    }

    public String getSub3()
    {
        return this.param_sub3;
    }

    public String getSub4()
    {
        return this.param_sub4;
    }

    public String getSub5()
    {
        return this.param_sub5;
    }
}

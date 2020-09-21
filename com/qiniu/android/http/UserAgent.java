package com.qiniu.android.http;

import android.os.Build;
import android.text.TextUtils;
import com.qiniu.android.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes6.dex */
public final class UserAgent {
    private static UserAgent opZ = new UserAgent();
    public final String id = egt();
    public final String ua = VX(this.id);

    private UserAgent() {
    }

    public static UserAgent egs() {
        return opZ;
    }

    private static String egt() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    static String VX(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", "7.3.13", Vv(), egu(), str);
    }

    private static String Vv() {
        try {
            String str = Build.VERSION.RELEASE;
            if (str == null) {
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.Wd(str.trim());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String egu() {
        try {
            String trim = Build.MODEL.trim();
            String gE = gE(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(gE)) {
                gE = gE(Build.BRAND.trim(), trim);
            }
            StringBuilder sb = new StringBuilder();
            if (gE == null) {
                gE = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.Wd(sb.append(gE).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(trim).toString());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String gE(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public String VY(String str) {
        String trim = ("" + str).trim();
        return new String((this.ua + "; " + trim.substring(0, Math.min(16, trim.length())) + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}

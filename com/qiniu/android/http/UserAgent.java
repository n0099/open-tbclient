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
    private static UserAgent ogq = new UserAgent();
    public final String id = ecw();
    public final String ua = Vv(this.id);

    private UserAgent() {
    }

    public static UserAgent ecv() {
        return ogq;
    }

    private static String ecw() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    static String Vv(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", "7.3.13", UM(), ecx(), str);
    }

    private static String UM() {
        try {
            String str = Build.VERSION.RELEASE;
            if (str == null) {
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.VB(str.trim());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String ecx() {
        try {
            String trim = Build.MODEL.trim();
            String gs = gs(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(gs)) {
                gs = gs(Build.BRAND.trim(), trim);
            }
            StringBuilder sb = new StringBuilder();
            if (gs == null) {
                gs = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.VB(sb.append(gs).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(trim).toString());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String gs(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public String Vw(String str) {
        String trim = ("" + str).trim();
        return new String((this.ua + "; " + trim.substring(0, Math.min(16, trim.length())) + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}

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
    private static UserAgent oFq = new UserAgent();
    public final String id = eke();
    public final String ua = WL(this.id);

    private UserAgent() {
    }

    public static UserAgent ekd() {
        return oFq;
    }

    private static String eke() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    static String WL(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", "7.3.13", Xs(), ekf(), str);
    }

    private static String Xs() {
        try {
            String str = Build.VERSION.RELEASE;
            if (str == null) {
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.WR(str.trim());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String ekf() {
        try {
            String trim = Build.MODEL.trim();
            String gL = gL(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(gL)) {
                gL = gL(Build.BRAND.trim(), trim);
            }
            StringBuilder sb = new StringBuilder();
            if (gL == null) {
                gL = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.WR(sb.append(gL).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(trim).toString());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String gL(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public String WM(String str) {
        String trim = ("" + str).trim();
        return new String((this.ua + "; " + trim.substring(0, Math.min(16, trim.length())) + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}

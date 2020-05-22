package com.qiniu.android.http;

import android.os.Build;
import android.text.TextUtils;
import com.qiniu.android.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes5.dex */
public final class UserAgent {
    private static UserAgent ngr = new UserAgent();
    public final String id = dHQ();
    public final String ua = QS(this.id);

    private UserAgent() {
    }

    public static UserAgent dHP() {
        return ngr;
    }

    private static String dHQ() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    static String QS(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", "7.3.13", Nv(), dHR(), str);
    }

    private static String Nv() {
        try {
            String str = Build.VERSION.RELEASE;
            if (str == null) {
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.QY(str.trim());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String dHR() {
        try {
            String trim = Build.MODEL.trim();
            String fO = fO(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(fO)) {
                fO = fO(Build.BRAND.trim(), trim);
            }
            StringBuilder sb = new StringBuilder();
            if (fO == null) {
                fO = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.QY(sb.append(fO).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(trim).toString());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String fO(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public String QT(String str) {
        String trim = ("" + str).trim();
        return new String((this.ua + "; " + trim.substring(0, Math.min(16, trim.length())) + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}

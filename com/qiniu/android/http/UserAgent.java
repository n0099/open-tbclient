package com.qiniu.android.http;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.qiniu.android.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes5.dex */
public final class UserAgent {
    private static UserAgent npB = new UserAgent();
    public final String id = dGx();
    public final String ua = Ro(this.id);

    private UserAgent() {
    }

    public static UserAgent dGw() {
        return npB;
    }

    private static String dGx() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    static String Ro(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", "7.3.13", dGy(), dGz(), str);
    }

    private static String dGy() {
        try {
            String str = Build.VERSION.RELEASE;
            if (str == null) {
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.Ru(str.trim());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String dGz() {
        try {
            String trim = Build.MODEL.trim();
            String fv = fv(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(fv)) {
                fv = fv(Build.BRAND.trim(), trim);
            }
            StringBuilder sb = new StringBuilder();
            if (fv == null) {
                fv = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.Ru(sb.append(fv).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(trim).toString());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String fv(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith(PraiseDataPassUtil.KEY_FROM_OS) || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public String Rp(String str) {
        String trim = ("" + str).trim();
        return new String((this.ua + "; " + trim.substring(0, Math.min(16, trim.length())) + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}

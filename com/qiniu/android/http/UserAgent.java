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
    private static UserAgent nnM = new UserAgent();
    public final String id = dFX();
    public final String ua = Rp(this.id);

    private UserAgent() {
    }

    public static UserAgent dFW() {
        return nnM;
    }

    private static String dFX() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    static String Rp(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", "7.3.13", dFY(), dFZ(), str);
    }

    private static String dFY() {
        try {
            String str = Build.VERSION.RELEASE;
            if (str == null) {
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.Rv(str.trim());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String dFZ() {
        try {
            String trim = Build.MODEL.trim();
            String fx = fx(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(fx)) {
                fx = fx(Build.BRAND.trim(), trim);
            }
            StringBuilder sb = new StringBuilder();
            if (fx == null) {
                fx = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.Rv(sb.append(fx).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(trim).toString());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String fx(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith(PraiseDataPassUtil.KEY_FROM_OS) || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public String Rq(String str) {
        String trim = ("" + str).trim();
        return new String((this.ua + "; " + trim.substring(0, Math.min(16, trim.length())) + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}

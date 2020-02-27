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
    private static UserAgent nnz = new UserAgent();
    public final String id = dFU();
    public final String ua = Ro(this.id);

    private UserAgent() {
    }

    public static UserAgent dFT() {
        return nnz;
    }

    private static String dFU() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    static String Ro(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", "7.3.13", dFV(), dFW(), str);
    }

    private static String dFV() {
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

    private static String dFW() {
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
            return StringUtils.Ru(sb.append(fx).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(trim).toString());
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

    public String Rp(String str) {
        String trim = ("" + str).trim();
        return new String((this.ua + "; " + trim.substring(0, Math.min(16, trim.length())) + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}

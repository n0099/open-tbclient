package com.qiniu.android.http;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.qiniu.android.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes4.dex */
public final class UserAgent {
    private static UserAgent nmT = new UserAgent();
    public final String id = dEL();
    public final String ua = Rd(this.id);

    private UserAgent() {
    }

    public static UserAgent dEK() {
        return nmT;
    }

    private static String dEL() {
        return System.currentTimeMillis() + "" + new Random().nextInt(999);
    }

    static String Rd(String str) {
        return String.format("QiniuAndroid/%s (%s; %s; %s", "7.3.13", dEM(), dEN(), str);
    }

    private static String dEM() {
        try {
            String str = Build.VERSION.RELEASE;
            if (str == null) {
                return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.Rj(str.trim());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String dEN() {
        try {
            String trim = Build.MODEL.trim();
            String fp = fp(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(fp)) {
                fp = fp(Build.BRAND.trim(), trim);
            }
            StringBuilder sb = new StringBuilder();
            if (fp == null) {
                fp = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return StringUtils.Rj(sb.append(fp).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(trim).toString());
        } catch (Throwable th) {
            return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private static String fp(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith(PraiseDataPassUtil.KEY_FROM_OS) || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public String Re(String str) {
        String trim = ("" + str).trim();
        return new String((this.ua + "; " + trim.substring(0, Math.min(16, trim.length())) + ")").getBytes(Charset.forName("ISO-8859-1")));
    }
}

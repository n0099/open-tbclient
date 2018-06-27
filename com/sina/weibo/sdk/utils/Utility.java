package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.sina.weibo.BuildConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public class Utility {
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static boolean isChineseLocale(Context context) {
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            if (Locale.CHINA.equals(locale) || Locale.CHINESE.equals(locale) || Locale.SIMPLIFIED_CHINESE.equals(locale)) {
                return true;
            }
            return Locale.TAIWAN.equals(locale);
        } catch (Exception e) {
            return true;
        }
    }

    public static String generateGUID() {
        return UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (int i = 0; i < packageInfo.signatures.length; i++) {
                byte[] byteArray = packageInfo.signatures[i].toByteArray();
                if (byteArray != null) {
                    return MD5.hexdigest(byteArray);
                }
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static String safeString(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getAid(Context context, String str) {
        if (context == null) {
            return "";
        }
        AidTask aidTask = AidTask.getInstance(context);
        String loadAidFromCache = aidTask.loadAidFromCache();
        if (TextUtils.isEmpty(loadAidFromCache)) {
            aidTask.aidTaskInit(str);
            return "";
        }
        return loadAidFromCache;
    }

    public static String generateUAAid(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String str = "weibosdk";
        if (!TextUtils.isEmpty(packageName) && packageName.contains(BuildConfig.APPLICATION_ID)) {
            str = "weibo";
        }
        sb.append(Build.MANUFACTURER).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(Build.MODEL);
        sb.append("__");
        sb.append(str);
        sb.append("__");
        try {
            sb.append(WbSdkVersion.WEIBO_SDK_VERSION_CODE.replaceAll("\\s+", "_"));
        } catch (Exception e) {
            sb.append("unknown");
        }
        sb.append("__").append(HttpConstants.OS_TYPE_VALUE).append("__android").append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    public static String getWeiBoVersion(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        if (packageInfo == null) {
            return null;
        }
        return packageInfo.versionName;
    }
}

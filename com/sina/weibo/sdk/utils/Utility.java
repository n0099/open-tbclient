package com.sina.weibo.sdk.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes3.dex */
public class Utility {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";

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

    public static Bundle parseUri(String str) {
        try {
            return decodeUrl(new URI(str).getQuery());
        } catch (Exception e) {
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
        }
    }

    public static String safeString(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getAid(Context context, String str) {
        AidTask.AidInfo aidSync = AidTask.getInstance(context).getAidSync(str);
        return aidSync != null ? aidSync.getAid() : "";
    }

    public static String generateUA(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(Build.MODEL);
        sb.append("_");
        sb.append(Build.VERSION.RELEASE);
        sb.append("_");
        sb.append("weibosdk");
        sb.append("_");
        sb.append(WBConstants.WEIBO_SDK_VERSION_CODE);
        sb.append("_android");
        return sb.toString();
    }

    public static String generateUAAid(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(Build.MODEL);
        sb.append("__");
        sb.append("weibosdk");
        sb.append("__");
        try {
            sb.append(WBConstants.WEIBO_SDK_VERSION_CODE.replaceAll("\\s+", "_"));
        } catch (Exception e) {
            sb.append("unknown");
        }
        sb.append("__").append(HttpConstants.OS_TYPE_VALUE).append("__android").append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    public static void shareMessagetoWeibo(Context context, String str, Bundle bundle) {
        try {
            Intent intent = new Intent();
            String valueOf = String.valueOf(System.currentTimeMillis());
            intent.putExtra(WBConstants.TRAN, valueOf);
            HashMap hashMap = new HashMap();
            hashMap.put(WBConstants.ACTION_START_TIME, valueOf);
            try {
                WBAgent.onEvent(context, "message", hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            intent.setAction("android.intent.action.VIEW");
            intent.putExtra(WBConstants.Base.APP_PKG, context.getPackageName());
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            intent.putExtras(bundle);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
        }
    }

    public static void openWeiboActivity(Context context, String str, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.putExtra(WBConstants.Base.APP_PKG, context.getPackageName());
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            intent.putExtras(bundle);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }

    public static Boolean isWeiBoVersionSupportNewPay(Context context) {
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return false;
        }
        int i = 0;
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.applicationInfo != null && !TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName)) {
                try {
                    i = context.getPackageManager().getPackageInfo(resolveInfo.serviceInfo.applicationInfo.packageName, 0).versionCode;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return Boolean.valueOf(i >= 1920);
    }

    public static String getImei(Context context) {
        String str = "";
        if (checkMyPermission(context, "android.permission.READ_PHONE_STATE").booleanValue()) {
            str = ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String getWifiMac(Context context) {
        String str = "";
        if (checkMyPermission(context, "android.permission.ACCESS_WIFI_STATE").booleanValue()) {
            str = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static Boolean checkMyPermission(Context context, String str) {
        return Boolean.valueOf(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }
}

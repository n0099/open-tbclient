package com.fun.openid.sdk;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class FunOpenIDSdk {
    public static final String SDK_VERSION = "1.3.2";
    public static final String TAG = "FunOpenIDSdk";
    public static boolean logEnabled;
    public static String vivoAppId;

    public static String getAndroidId(Context context) {
        if (context != null) {
            try {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String getImei(Context context) {
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && b.a(context, "android.permission.READ_PHONE_STATE")) {
                    return telephonyManager.getDeviceId();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String getImeiNew(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null || !b.a(context, "android.permission.READ_PHONE_STATE")) {
                    return null;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                        method.setAccessible(true);
                        str = (String) method.invoke(telephonyManager, new Object[0]);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                }
                return telephonyManager.getDeviceId();
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static synchronized void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        synchronized (FunOpenIDSdk.class) {
            if (context == null) {
                if (isLogEnabled()) {
                    Log.e(TAG, "getOaid context is null !!!");
                }
            } else if (onGetOaidListener != null) {
                j.f30848a.execute(new e(context, onGetOaidListener));
            } else {
                if (isLogEnabled()) {
                    Log.e(TAG, "getOaid onGetOaidListener is null !!!");
                }
            }
        }
    }

    public static String getSdkVersion() {
        return SDK_VERSION;
    }

    public static String getVivoAppId() {
        return vivoAppId;
    }

    public static boolean isLogEnabled() {
        return logEnabled;
    }

    public static void setLogEnabled(boolean z) {
        logEnabled = z;
    }

    public static void setVivoAppId(String str) {
        vivoAppId = str;
    }
}

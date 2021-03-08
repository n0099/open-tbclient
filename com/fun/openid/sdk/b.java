package com.fun.openid.sdk;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class b {
    private static boolean logEnabled;

    public static synchronized void a(Context context, c cVar) {
        synchronized (b.class) {
            if (context == null) {
                if (isLogEnabled()) {
                    Log.e("FunOpenIDSdk", "getOaid context is null !!!");
                }
            } else if (cVar != null) {
                l.f5247a.execute(new g(context, cVar));
            } else if (isLogEnabled()) {
                Log.e("FunOpenIDSdk", "getOaid onGetOaidListener is null !!!");
            }
        }
    }

    public static String getAndroidId(Context context) {
        if (context != null) {
            try {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getImei(Context context) {
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && d.a(context, "android.permission.READ_PHONE_STATE")) {
                    return telephonyManager.getDeviceId();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | InputDeviceCompat.SOURCE_ANY).substring(6));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String in(Context context) {
        Exception exc;
        String str;
        String str2;
        String str3 = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && d.a(context, "android.permission.READ_PHONE_STATE")) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        try {
                            Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                            method.setAccessible(true);
                            str2 = (String) method.invoke(telephonyManager, new Object[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                            str2 = null;
                        }
                        try {
                            if (!TextUtils.isEmpty(str2)) {
                                return str2;
                            }
                            str3 = str2;
                        } catch (Exception e2) {
                            exc = e2;
                            str = str2;
                            exc.printStackTrace();
                            return str;
                        }
                    }
                    try {
                        return telephonyManager.getDeviceId();
                    } catch (Exception e3) {
                        exc = e3;
                        str = str3;
                        exc.printStackTrace();
                        return str;
                    }
                }
            } catch (Exception e4) {
                exc = e4;
                str = null;
            }
        }
        return null;
    }

    public static boolean isLogEnabled() {
        return logEnabled;
    }
}

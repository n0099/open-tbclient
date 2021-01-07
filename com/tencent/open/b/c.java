package com.tencent.open.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.webkit.internal.ETAG;
import java.util.Locale;
/* loaded from: classes4.dex */
public class c {
    private static String d;

    /* renamed from: a  reason: collision with root package name */
    static String f13690a = null;

    /* renamed from: b  reason: collision with root package name */
    static String f13691b = null;
    static String c = null;
    private static String e = null;

    public static String a() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            Context a2 = com.tencent.open.utils.e.a();
            if (a2 != null && (wifiManager = (WifiManager) a2.getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                return connectionInfo.getMacAddress();
            }
            return "";
        } catch (SecurityException e2) {
            com.tencent.open.a.f.b("openSDK_LOG.MobileInfoUtil", "getLocalMacAddress>>>", e2);
            return "";
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        if (context == null) {
            return "";
        }
        d = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            d = width + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return d;
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static String b(Context context) {
        if (f13690a != null && f13690a.length() > 0) {
            return f13690a;
        }
        if (context == null) {
            return "";
        }
        try {
            f13690a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return f13690a;
        } catch (Exception e2) {
            return "";
        }
    }

    public static String c(Context context) {
        if (f13691b != null && f13691b.length() > 0) {
            return f13691b;
        }
        if (context == null) {
            return "";
        }
        try {
            f13691b = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            return f13691b;
        } catch (Exception e2) {
            return "";
        }
    }

    public static String d(Context context) {
        if (c != null && c.length() > 0) {
            return c;
        }
        if (context == null) {
            return "";
        }
        try {
            c = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return c;
        } catch (Exception e2) {
            return "";
        }
    }

    public static String e(Context context) {
        try {
            if (e == null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb = new StringBuilder();
                sb.append("imei=").append(b(context)).append('&');
                sb.append("model=").append(Build.MODEL).append('&');
                sb.append("os=").append(Build.VERSION.RELEASE).append('&');
                sb.append("apilevel=").append(Build.VERSION.SDK_INT).append('&');
                String b2 = a.b(context);
                if (b2 == null) {
                    b2 = "";
                }
                sb.append("network=").append(b2).append('&');
                sb.append("sdcard=").append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0).append('&');
                sb.append("display=").append(displayMetrics.widthPixels).append('*').append(displayMetrics.heightPixels).append('&');
                sb.append("manu=").append(Build.MANUFACTURER).append(ETAG.ITEM_SEPARATOR);
                sb.append("wifi=").append(a.e(context));
                e = sb.toString();
            }
            return e;
        } catch (Exception e2) {
            return null;
        }
    }
}

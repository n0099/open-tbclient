package com.tencent.ams.a.a.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.mobstat.Config;
import com.qq.e.comm.plugin.util.aa;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f13278a;

    /* renamed from: b  reason: collision with root package name */
    private static String f13279b;
    private static String c;
    private static HashMap<String, String> d = new HashMap<>();

    public static String a() {
        return Build.VERSION.RELEASE;
    }

    private static String a(int i, String str, String str2) {
        return i == 1 ? a.b(str + str2) : i == 2 ? a.b(a.b(str) + str2) : a.b(str);
    }

    public static String a(Context context) {
        if (c != null) {
            return c;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            c = "";
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            c = displayMetrics.widthPixels + Config.EVENT_HEAT_X + displayMetrics.heightPixels;
        }
        return c;
    }

    public static HashMap<String, String> a(Context context, String str, int i) {
        HashMap<String, String> hashMap = new HashMap<>(3);
        hashMap.put("MAC", c(context, str, i));
        hashMap.put("IMEI", b(context, str, i));
        hashMap.put("ANDROIDID", d(context, str, i));
        return hashMap;
    }

    public static String b() {
        return Build.MODEL;
    }

    private static String b(Context context, String str, int i) {
        String str2 = str + i + "imei";
        String str3 = d.get(str2);
        if (str3 != null) {
            return str3;
        }
        if (aa.b() && context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str3 = telephonyManager.getDeviceId();
                    if (!TextUtils.isEmpty(str3)) {
                        str3 = a(i, str3, str);
                    }
                }
            } catch (Throwable th) {
            }
            if (str3 == null) {
                str3 = "";
            }
            d.put(str2, str3);
            return str3;
        }
        return "";
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        return networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static String c(Context context) {
        if (f13278a != null) {
            return f13278a;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            f13278a = packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e) {
        }
        return f13278a;
    }

    private static String c(Context context, String str, int i) {
        WifiInfo connectionInfo;
        String str2 = str + i + "mac";
        String str3 = d.get(str2);
        if (str3 != null) {
            return str3;
        }
        if (aa.a()) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    str3 = connectionInfo.getMacAddress();
                    if (!TextUtils.isEmpty(str3)) {
                        str3 = a(i, str3.replace(":", "").toUpperCase(), str);
                    }
                }
            } catch (Throwable th) {
            }
            if (str3 == null) {
                str3 = "";
            }
            d.put(str2, str3);
            return str3;
        }
        return "";
    }

    public static String d(Context context) {
        if (f13279b == null && context != null) {
            f13279b = context.getPackageName();
        }
        return f13279b;
    }

    private static String d(Context context, String str, int i) {
        String str2 = str + i + "androidId";
        String str3 = d.get(str2);
        if (str3 != null) {
            return str3;
        }
        if (aa.c()) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                str3 = (TextUtils.isEmpty(string) || "9774d56d682e549c".equals(string) || string.length() < 15) ? "" : a(i, string, str);
            } catch (Throwable th) {
            }
            d.put(str2, str3);
            return str3;
        }
        return "";
    }

    public static Map<String, String> e(Context context) {
        HashMap hashMap = new HashMap();
        if (context != null) {
            hashMap.put("OSVS", a());
            hashMap.put("TERM", b());
            hashMap.put("WIFI", b(context) ? "1" : "0");
            hashMap.put("ANAME", c(context));
            hashMap.put("AKEY", d(context));
            hashMap.put("OSVS", a());
            hashMap.put("OS", "0");
            hashMap.put("SCWH", a(context));
            hashMap.put("SDKVS", LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION);
        }
        return hashMap;
    }
}

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
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.Locale;
import kotlin.text.Typography;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f40065a;

    /* renamed from: b  reason: collision with root package name */
    public static String f40066b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40067c;

    /* renamed from: d  reason: collision with root package name */
    public static String f40068d;

    /* renamed from: e  reason: collision with root package name */
    public static String f40069e;

    public static String a() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            Context a2 = com.tencent.open.utils.e.a();
            return (a2 == null || (wifiManager = (WifiManager) a2.getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
        } catch (SecurityException e2) {
            com.tencent.open.a.f.b("openSDK_LOG.MobileInfoUtil", "getLocalMacAddress>>>", e2);
            return "";
        }
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static String c(Context context) {
        String str = f40066b;
        if (str == null || str.length() <= 0) {
            if (context == null) {
                return "";
            }
            try {
                String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
                f40066b = simSerialNumber;
                return simSerialNumber;
            } catch (Exception unused) {
                return "";
            }
        }
        return f40066b;
    }

    public static String d(Context context) {
        String str = f40067c;
        if (str == null || str.length() <= 0) {
            if (context == null) {
                return "";
            }
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
                f40067c = string;
                return string;
            } catch (Exception unused) {
                return "";
            }
        }
        return f40067c;
    }

    public static String e(Context context) {
        try {
            if (f40069e == null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb = new StringBuilder();
                sb.append("imei=");
                sb.append(b(context));
                sb.append(Typography.amp);
                sb.append("model=");
                sb.append(Build.MODEL);
                sb.append(Typography.amp);
                sb.append("os=");
                sb.append(Build.VERSION.RELEASE);
                sb.append(Typography.amp);
                sb.append("apilevel=");
                sb.append(Build.VERSION.SDK_INT);
                sb.append(Typography.amp);
                String b2 = a.b(context);
                if (b2 == null) {
                    b2 = "";
                }
                sb.append("network=");
                sb.append(b2);
                sb.append(Typography.amp);
                sb.append("sdcard=");
                sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append(Typography.amp);
                sb.append("display=");
                sb.append(displayMetrics.widthPixels);
                sb.append('*');
                sb.append(displayMetrics.heightPixels);
                sb.append(Typography.amp);
                sb.append("manu=");
                sb.append(Build.MANUFACTURER);
                sb.append("&");
                sb.append("wifi=");
                sb.append(a.e(context));
                f40069e = sb.toString();
            }
            return f40069e;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context) {
        String str = f40065a;
        if (str == null || str.length() <= 0) {
            if (context == null) {
                return "";
            }
            try {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                f40065a = deviceId;
                return deviceId;
            } catch (Exception unused) {
                return "";
            }
        }
        return f40065a;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f40068d)) {
            if (context == null) {
                return "";
            }
            f40068d = "";
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                int width = windowManager.getDefaultDisplay().getWidth();
                int height = windowManager.getDefaultDisplay().getHeight();
                f40068d = width + "x" + height;
            }
            return f40068d;
        }
        return f40068d;
    }
}

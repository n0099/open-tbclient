package com.bytedance.sdk.openadsdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.kwai.video.player.KsMediaMeta;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    @NonNull
    public static String a() {
        String str = "DU:MM:YA:DD:RE:SS";
        TTCustomController d = com.bytedance.sdk.openadsdk.core.i.c().d();
        if (d != null && d.isCanUseWifiState() && d.isCanUseLocation()) {
            str = a("wlan0");
            if (TextUtils.isEmpty(str)) {
                str = a("eth0");
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "DU:MM:YA:DD:RE:SS";
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0013 A[Catch: Throwable -> 0x0065, TryCatch #0 {Throwable -> 0x0065, blocks: (B:3:0x0001, B:4:0x000d, B:6:0x0013, B:8:0x001b, B:10:0x0025, B:14:0x002f, B:16:0x0038, B:17:0x0051, B:19:0x0057, B:20:0x0060), top: B:25:0x0001 }] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
                while (r2.hasNext()) {
                }
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static String a(boolean z) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        boolean z2 = inetAddress instanceof Inet4Address;
                        String upperCase = inetAddress.getHostAddress().toUpperCase();
                        if (z) {
                            if (z2) {
                                return upperCase;
                            }
                        } else if (!z2) {
                            int indexOf = upperCase.indexOf(37);
                            return indexOf >= 0 ? upperCase.substring(0, indexOf) : upperCase;
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
        return "";
    }

    public static boolean a(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            if ((context.getResources().getConfiguration().uiMode & 15) != 4) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static int c(Context context) {
        if (b(context)) {
            return 3;
        }
        if (a(context)) {
            return 2;
        }
        return 1;
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", com.bytedance.sdk.openadsdk.core.k.d(context));
            jSONObject.put("android_id", com.bytedance.sdk.openadsdk.core.k.c(context));
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.k.e(context));
            jSONObject.put("ssid", com.bytedance.sdk.openadsdk.core.k.g(context));
            jSONObject.put("wifi_mac", com.bytedance.sdk.openadsdk.core.k.h(context));
            jSONObject.put("imsi", com.bytedance.sdk.openadsdk.core.k.f(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put("rom_version", ad.a());
            jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.k.b(context));
            jSONObject.put("type", c(context));
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", x.b(context));
            jSONObject.put("mac", a());
            jSONObject.put("screen_width", ak.c(context));
            jSONObject.put("screen_height", ak.d(context));
            jSONObject.put("oaid", y.a());
            jSONObject.put("free_space", m.f7593a);
            jSONObject.put("applog_did", com.bytedance.embedapplog.b.getDid());
        } catch (Throwable th) {
        }
        return jSONObject;
    }
}

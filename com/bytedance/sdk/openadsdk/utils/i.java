package com.bytedance.sdk.openadsdk.utils;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f30286a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f30287b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f30288c = true;

    /* loaded from: classes6.dex */
    public static class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = i.f30288c = true;
                u.c("DeviceUtils", "screen_on");
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = i.f30288c = false;
                u.c("DeviceUtils", "screen_off");
            }
        }
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT == 29 && ae.r()) {
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.p.a().getSystemService("power");
                if (powerManager != null) {
                    f30288c = powerManager.isScreenOn();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return f30288c;
    }

    public static boolean c(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int d(Context context) {
        if (c(context)) {
            return 3;
        }
        return b(context) ? 2 : 1;
    }

    public static JSONObject e(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", com.bytedance.sdk.openadsdk.core.k.d(context));
            jSONObject.put(IAdRequestParam.ANDROID_ID, com.bytedance.sdk.openadsdk.core.k.c(context));
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.k.e(context));
            jSONObject.put("ssid", com.bytedance.sdk.openadsdk.core.k.g(context));
            jSONObject.put("wifi_mac", com.bytedance.sdk.openadsdk.core.k.h(context));
            jSONObject.put("imsi", com.bytedance.sdk.openadsdk.core.k.f(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put("rom_version", ae.a());
            jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.k.b(context));
            jSONObject.put("type", d(context));
            jSONObject.put(IAdRequestParam.OS, 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", x.b(context));
            jSONObject.put(IAdRequestParam.MAC, b());
            jSONObject.put("screen_width", al.c(context));
            jSONObject.put("screen_height", al.d(context));
            jSONObject.put("oaid", y.a());
            jSONObject.put(PmsConstant.EnvParam.Key.FREE_SPACE, m.f30290a);
            jSONObject.put("applog_did", AppLogHelper.getInstance().getAppLogDid());
            jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.core.s.a().b());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    @NonNull
    public static String b() {
        String str;
        if (!TextUtils.isEmpty(f30286a)) {
            return f30286a;
        }
        String a2 = com.bytedance.sdk.openadsdk.core.i.a("sdk_local_mac_address", 172800000L);
        f30286a = a2;
        if (TextUtils.isEmpty(a2)) {
            TTCustomController e2 = com.bytedance.sdk.openadsdk.core.i.d().e();
            if (e2 != null && e2.isCanUseWifiState() && e2.isCanUseLocation()) {
                str = a(NetworkInfoUtils.NETWORK_NAME);
                if (TextUtils.isEmpty(str)) {
                    str = a("eth0");
                }
            } else {
                str = "DU:MM:YA:DD:RE:SS";
            }
            String str2 = TextUtils.isEmpty(str) ? "DU:MM:YA:DD:RE:SS" : str;
            f30286a = str2;
            com.bytedance.sdk.openadsdk.core.i.a("sdk_local_mac_address", str2);
        }
        return f30286a;
    }

    public static void a(Context context) {
        if (f30287b) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                f30288c = powerManager.isScreenOn();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        a aVar = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(aVar, intentFilter);
        f30287b = true;
    }

    @SuppressLint({"NewApi"})
    public static String a(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static boolean b(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
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
                            return indexOf < 0 ? upperCase : upperCase.substring(0, indexOf);
                        }
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }
}

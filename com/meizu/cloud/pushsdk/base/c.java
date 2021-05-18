package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f34832a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f34833b = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f34833b)) {
            f34833b = !a() ? c(context) : d(context);
            return f34833b;
        }
        return f34833b;
    }

    public static String a(String str) {
        String str2;
        try {
            FileInputStream fileInputStream = new FileInputStream("/sys/class/net/" + str + "/address");
            Scanner scanner = new Scanner(fileInputStream);
            r1 = scanner.hasNextLine() ? scanner.nextLine().trim() : null;
            fileInputStream.close();
        } catch (FileNotFoundException unused) {
            str2 = "getMacAddressWithIfName File not found Exception";
            d.j.a.a.a.b("DeviceUtils", str2);
            return r1;
        } catch (IOException unused2) {
            str2 = "getMacAddressWithIfName IOException";
            d.j.a.a.a.b("DeviceUtils", str2);
            return r1;
        } catch (Exception unused3) {
            str2 = "getMacAddressWithIfName Exception ";
            d.j.a.a.a.b("DeviceUtils", str2);
            return r1;
        }
        return r1;
    }

    public static boolean a() {
        String a2 = j.a("ro.target.product");
        if (TextUtils.isEmpty(a2)) {
            d.j.a.a.a.d("DeviceUtils", "current product is phone");
            return true;
        }
        d.j.a.a.a.d("DeviceUtils", "current product is " + a2);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r5.getType() == 9) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        String str;
        WifiInfo connectionInfo;
        String macAddress;
        if (TextUtils.isEmpty(f34832a)) {
            try {
                str = null;
            } catch (Exception unused) {
                d.j.a.a.a.b("DeviceUtils", "get address exception ");
            }
            if (Build.VERSION.SDK_INT < 23) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    macAddress = connectionInfo.getMacAddress();
                    str = macAddress;
                }
                f34832a = str;
                return f34832a;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    macAddress = a(NetworkInfoUtils.NETWORK_NAME);
                    if (TextUtils.isEmpty(macAddress)) {
                        macAddress = a("eth0");
                    }
                    str = macAddress;
                } else if (activeNetworkInfo.getType() == 1) {
                    macAddress = a(NetworkInfoUtils.NETWORK_NAME);
                    str = macAddress;
                }
            }
            f34832a = str;
            return f34832a;
            d.j.a.a.a.b("DeviceUtils", "get address exception ");
            return f34832a;
        }
        return f34832a;
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = Build.SERIAL;
        d.j.a.a.a.d("DeviceUtils", "device serial " + str);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            String b2 = b(context);
            d.j.a.a.a.b("DeviceUtils", "mac address " + b2);
            if (!TextUtils.isEmpty(b2)) {
                sb.append(b2.replace(":", "").toUpperCase());
                return sb.toString();
            }
        }
        return null;
    }

    public static String d(Context context) {
        com.meizu.cloud.pushsdk.base.a.d a2 = com.meizu.cloud.pushsdk.base.a.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
        return a2.f34815a ? (String) a2.f34816b : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }
}

package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.repackage.ym9;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/* loaded from: classes5.dex */
public class c {
    public static String a = "";
    public static String b = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            b = !a() ? c(context) : d(context);
            return b;
        }
        return b;
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
            ym9.b("DeviceUtils", str2);
            return r1;
        } catch (IOException unused2) {
            str2 = "getMacAddressWithIfName IOException";
            ym9.b("DeviceUtils", str2);
            return r1;
        } catch (Exception unused3) {
            str2 = "getMacAddressWithIfName Exception ";
            ym9.b("DeviceUtils", str2);
            return r1;
        }
        return r1;
    }

    public static boolean a() {
        String a2 = j.a("ro.target.product");
        if (TextUtils.isEmpty(a2)) {
            ym9.d("DeviceUtils", "current product is phone");
            return true;
        }
        ym9.d("DeviceUtils", "current product is " + a2);
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
        if (TextUtils.isEmpty(a)) {
            try {
                str = null;
            } catch (Exception unused) {
                ym9.b("DeviceUtils", "get address exception ");
            }
            if (Build.VERSION.SDK_INT < 23) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    macAddress = connectionInfo.getMacAddress();
                    str = macAddress;
                }
                a = str;
                return a;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    macAddress = a("wlan0");
                    if (TextUtils.isEmpty(macAddress)) {
                        macAddress = a("eth0");
                    }
                    str = macAddress;
                } else if (activeNetworkInfo.getType() == 1) {
                    macAddress = a("wlan0");
                    str = macAddress;
                }
            }
            a = str;
            return a;
            ym9.b("DeviceUtils", "get address exception ");
            return a;
        }
        return a;
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = Build.SERIAL;
        ym9.d("DeviceUtils", "device serial " + str);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            String b2 = b(context);
            ym9.b("DeviceUtils", "mac address " + b2);
            if (!TextUtils.isEmpty(b2)) {
                sb.append(b2.replace(":", "").toUpperCase());
                return sb.toString();
            }
        }
        return null;
    }

    public static String d(Context context) {
        com.meizu.cloud.pushsdk.base.a.d a2 = com.meizu.cloud.pushsdk.base.a.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
        return a2.a ? (String) a2.b : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }
}

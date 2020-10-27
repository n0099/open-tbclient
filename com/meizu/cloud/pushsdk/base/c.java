package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f4370a = "";
    private static String b = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            if (a()) {
                b = d(context);
            } else {
                b = c(context);
            }
            return b;
        }
        return b;
    }

    private static String a(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream("/sys/class/net/" + str + "/address");
            Scanner scanner = new Scanner(fileInputStream);
            r0 = scanner.hasNextLine() ? scanner.nextLine().trim() : null;
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            com.meizu.cloud.a.a.e("DeviceUtils", "getMacAddressWithIfName File not found Exception");
        } catch (IOException e2) {
            com.meizu.cloud.a.a.e("DeviceUtils", "getMacAddressWithIfName IOException");
        } catch (Exception e3) {
            com.meizu.cloud.a.a.e("DeviceUtils", "getMacAddressWithIfName Exception ");
        }
        return r0;
    }

    public static boolean a() {
        String a2 = j.a("ro.target.product");
        if (TextUtils.isEmpty(a2)) {
            com.meizu.cloud.a.a.i("DeviceUtils", "current product is phone");
            return true;
        }
        com.meizu.cloud.a.a.i("DeviceUtils", "current product is " + a2);
        return false;
    }

    public static String b(Context context) {
        WifiInfo connectionInfo;
        String str;
        String str2 = null;
        if (TextUtils.isEmpty(f4370a)) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null) {
                            str = a("wlan0");
                            if (TextUtils.isEmpty(str)) {
                                str = a("eth0");
                            }
                        } else if (activeNetworkInfo.getType() == 1) {
                            str = a("wlan0");
                        } else if (activeNetworkInfo.getType() == 9) {
                            str = a("eth0");
                        }
                        str2 = str;
                    }
                    str = null;
                    str2 = str;
                } else {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                        str2 = connectionInfo.getMacAddress();
                    }
                }
                f4370a = str2;
            } catch (Exception e) {
                com.meizu.cloud.a.a.e("DeviceUtils", "get address exception ");
            }
            return f4370a;
        }
        return f4370a;
    }

    private static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = Build.SERIAL;
        com.meizu.cloud.a.a.i("DeviceUtils", "device serial " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        sb.append(str);
        String b2 = b(context);
        com.meizu.cloud.a.a.e("DeviceUtils", "mac address " + b2);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        sb.append(b2.replace(":", "").toUpperCase());
        return sb.toString();
    }

    private static String d(Context context) {
        com.meizu.cloud.pushsdk.base.a.d a2 = com.meizu.cloud.pushsdk.base.a.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
        return a2.f4365a ? (String) a2.b : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }
}

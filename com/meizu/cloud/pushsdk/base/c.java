package com.meizu.cloud.pushsdk.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/* loaded from: classes5.dex */
public class c {
    private static String a = "";
    private static String b = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            if (a()) {
                b = i.a(context);
            } else if (TextUtils.isEmpty(b)) {
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
                b = sb.toString();
            }
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
        }
        return r0;
    }

    public static boolean a() {
        String a2 = k.a("ro.target.product");
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
        if (TextUtils.isEmpty(a)) {
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
                a = str2;
            } catch (Exception e) {
                com.meizu.cloud.a.a.e("DeviceUtils", "get address exception ");
            }
            return a;
        }
        return a;
    }
}

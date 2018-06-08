package com.meizu.cloud.pushsdk.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.meizu.cloud.pushsdk.common.util.d;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/* loaded from: classes3.dex */
public class b {
    private static String a = "";
    private static String b = "";

    public static boolean a() {
        d.c a2 = e.a("ro.target.product");
        if (a2.a && !TextUtils.isEmpty((CharSequence) a2.b)) {
            Logger.b("DeviceUtils", "current product is " + ((String) a2.b));
            return false;
        }
        Logger.b("DeviceUtils", "current product is phone");
        return true;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            if (!a()) {
                if (TextUtils.isEmpty(b)) {
                    StringBuilder sb = new StringBuilder();
                    String str = Build.SERIAL;
                    Logger.b("DeviceUtils", "device serial " + str);
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    sb.append(str);
                    String b2 = b(context);
                    Logger.d("DeviceUtils", "mac address " + b2);
                    if (TextUtils.isEmpty(b2)) {
                        return null;
                    }
                    sb.append(b2.replace(SystemInfoUtil.COLON, "").toUpperCase());
                    b = sb.toString();
                }
            } else {
                b = g.a(context);
            }
        }
        return b;
    }

    public static String b(Context context) {
        WifiInfo connectionInfo;
        String str;
        String str2 = null;
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.getType() == 1) {
                        str = a("wlan0");
                    } else if (activeNetworkInfo.getType() == 9) {
                        str = a("eth0");
                    }
                } else {
                    str = a("wlan0");
                    if (TextUtils.isEmpty(str)) {
                        str = a("eth0");
                    }
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
        return a;
    }

    private static String a(String str) {
        String str2 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("/sys/class/net/" + str + "/address");
            Scanner scanner = new Scanner(fileInputStream);
            if (scanner.hasNextLine()) {
                str2 = scanner.nextLine().trim();
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            Logger.d("DeviceUtils", "getMacAddressWithIfName File not found Exception");
        } catch (IOException e2) {
            Logger.d("DeviceUtils", "getMacAddressWithIfName IOException");
        }
        return str2;
    }
}

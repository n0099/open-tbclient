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
import com.baidu.pass.face.platform.utils.DeviceUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f68356a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f68357b = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f68357b)) {
            f68357b = !a() ? c(context) : d(context);
            return f68357b;
        }
        return f68357b;
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
            b.j.a.a.a.b(DeviceUtils.TAG, str2);
            return r1;
        } catch (IOException unused2) {
            str2 = "getMacAddressWithIfName IOException";
            b.j.a.a.a.b(DeviceUtils.TAG, str2);
            return r1;
        } catch (Exception unused3) {
            str2 = "getMacAddressWithIfName Exception ";
            b.j.a.a.a.b(DeviceUtils.TAG, str2);
            return r1;
        }
        return r1;
    }

    public static boolean a() {
        String a2 = j.a("ro.target.product");
        if (TextUtils.isEmpty(a2)) {
            b.j.a.a.a.d(DeviceUtils.TAG, "current product is phone");
            return true;
        }
        b.j.a.a.a.d(DeviceUtils.TAG, "current product is " + a2);
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
        if (TextUtils.isEmpty(f68356a)) {
            try {
                str = null;
            } catch (Exception unused) {
                b.j.a.a.a.b(DeviceUtils.TAG, "get address exception ");
            }
            if (Build.VERSION.SDK_INT < 23) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    macAddress = connectionInfo.getMacAddress();
                    str = macAddress;
                }
                f68356a = str;
                return f68356a;
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
            f68356a = str;
            return f68356a;
            b.j.a.a.a.b(DeviceUtils.TAG, "get address exception ");
            return f68356a;
        }
        return f68356a;
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = Build.SERIAL;
        b.j.a.a.a.d(DeviceUtils.TAG, "device serial " + str);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            String b2 = b(context);
            b.j.a.a.a.b(DeviceUtils.TAG, "mac address " + b2);
            if (!TextUtils.isEmpty(b2)) {
                sb.append(b2.replace(":", "").toUpperCase());
                return sb.toString();
            }
        }
        return null;
    }

    public static String d(Context context) {
        com.meizu.cloud.pushsdk.base.a.d a2 = com.meizu.cloud.pushsdk.base.a.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
        return a2.f68339a ? (String) a2.f68340b : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }
}

package com.sdk.base.framework.f.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Stack;
/* loaded from: classes7.dex */
public class a extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39458a = "com.sdk.base.framework.f.a.a";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39459b = f.f39439b;

    static {
        new Stack();
    }

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return StringUtil.NULL_STRING;
        } catch (SocketException unused) {
            return StringUtil.NULL_STRING;
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            c.b(f39458a, e2.getMessage(), Boolean.valueOf(f39459b));
            return null;
        }
    }

    public static String a(Context context, String str) {
        String str2 = (String) b(context, str);
        return c.a(str2).booleanValue() ? com.sdk.base.framework.f.b.a.a(context, Constants.API_KEY) : str2;
    }

    @SuppressLint({"NewApi"})
    public static int b() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e2) {
            c.b(f39458a, e2.getMessage(), Boolean.valueOf(f39459b));
            return -1;
        }
    }

    public static int b(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(c(context), 1);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception e2) {
            c.b(f39458a, e2.getMessage(), Boolean.valueOf(f39459b));
            return -1;
        }
    }

    public static <T> T b(Context context, String str) {
        Bundle bundle;
        if (context == null || c.a(str).booleanValue()) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(c(context), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return (T) bundle.get(str);
        } catch (Exception e2) {
            c.a(f39458a, e2.getMessage(), Boolean.valueOf(f39459b));
            return null;
        }
    }

    public static String c(Context context) {
        if (context == null) {
            c.c(f39458a, "mContext 为空", Boolean.valueOf(f39459b));
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Exception e2) {
            c.b(f39458a, e2.getMessage(), Boolean.valueOf(f39459b));
            return null;
        }
    }

    public static boolean c() {
        return false;
    }

    public static String d(Context context) {
        if (context == null) {
            com.sdk.base.framework.f.a.a(f39458a, "getAppLable", "mContext 为空", f39459b);
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
        } catch (Exception e2) {
            c.b(f39458a, e2.getMessage(), Boolean.valueOf(f39459b));
            return null;
        }
    }

    public static String e(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e2) {
            c.b(f39458a, e2.getMessage(), Boolean.valueOf(f39459b));
            packageInfo = null;
        }
        if (packageInfo != null) {
            int i2 = packageInfo.applicationInfo.flags;
            try {
                byte[] byteArray = packageInfo.signatures[0].toByteArray();
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                byte[] digest = messageDigest.digest();
                String str = "";
                for (int i3 = 0; i3 < digest.length; i3++) {
                    if (i3 != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(":");
                        str = sb.toString();
                    }
                    String hexString = Integer.toHexString(digest[i3] & 255);
                    if (hexString.length() == 1) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append("0");
                        str = sb2.toString();
                    }
                    str = str + hexString;
                }
                return str;
            } catch (Exception e3) {
                c.b(f39458a, e3.getMessage(), Boolean.valueOf(f39459b));
                return null;
            }
        }
        return null;
    }
}

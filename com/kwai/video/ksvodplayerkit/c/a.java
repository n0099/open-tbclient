package com.kwai.video.ksvodplayerkit.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;
/* loaded from: classes4.dex */
public class a {
    public static boolean a(Context context) {
        boolean z;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (java.lang.Integer.parseInt(r2[3]) < 255) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        if (trim.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
            String[] split = trim.split("\\.");
            if (Integer.parseInt(split[0]) < 255) {
                if (Integer.parseInt(split[1]) < 255) {
                    if (Integer.parseInt(split[2]) < 255) {
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public static String b(String str) {
        try {
            return Uri.parse(str).getHost().toLowerCase(Locale.US);
        } catch (Exception e) {
            throw new RuntimeException("Illegal url:" + str, e);
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static String c(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                return "Notfound";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r4.equals("3g") != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(Context context) {
        boolean z = true;
        if (b(context)) {
            return 1;
        }
        String c = c(context);
        switch (c.hashCode()) {
            case 1653:
                if (c.equals("2g")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1684:
                break;
            case 1715:
                if (c.equals("4g")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                return 4;
            case true:
                return 3;
            case true:
                return 2;
            default:
                return 0;
        }
    }
}

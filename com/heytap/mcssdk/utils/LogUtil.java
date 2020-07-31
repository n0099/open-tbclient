package com.heytap.mcssdk.utils;

import android.util.Log;
/* loaded from: classes20.dex */
public class LogUtil {
    public static final String TAG = "mcssdk---";
    private static String special = "MCS";
    private static boolean sV = false;
    private static boolean sI = false;
    private static boolean sD = true;
    private static boolean sW = true;
    private static boolean sE = true;
    private static String sSeparator = "-->";
    private static boolean sIsDebug = true;

    public static void d(String str) {
        if (sD && sIsDebug) {
            Log.d(TAG, special + sSeparator + str);
        }
    }

    public static void d(String str, String str2) {
        if (sD && sIsDebug) {
            Log.d(str, special + sSeparator + str2);
        }
    }

    public static void e(Exception exc) {
        if (sE) {
            exc.printStackTrace();
        }
    }

    public static void e(String str) {
        if (sE && sIsDebug) {
            Log.e(TAG, special + sSeparator + str);
        }
    }

    public static void e(String str, String str2) {
        if (sE && sIsDebug) {
            Log.e(str, special + sSeparator + str2);
        }
    }

    public static void e(String str, Throwable th) {
        if (sE) {
            Log.e(str, th.toString());
        }
    }

    public static String getSeprateor() {
        return sSeparator;
    }

    public static String getSpecial() {
        return special;
    }

    public static void i(String str) {
        if (sI && sIsDebug) {
            Log.i(TAG, special + sSeparator + str);
        }
    }

    public static void i(String str, String str2) {
        if (sI && sIsDebug) {
            Log.i(str, special + sSeparator + str2);
        }
    }

    public static boolean isD() {
        return sD;
    }

    public static boolean isDebugs() {
        return sIsDebug;
    }

    public static boolean isE() {
        return sE;
    }

    public static boolean isI() {
        return sI;
    }

    public static boolean isV() {
        return sV;
    }

    public static boolean isW() {
        return sW;
    }

    public static void setD(boolean z) {
        sD = z;
    }

    public static void setDebugs(boolean z) {
        sIsDebug = z;
        if (z) {
            sV = true;
            sD = true;
            sI = true;
            sW = true;
            sE = true;
            return;
        }
        sV = false;
        sD = false;
        sI = false;
        sW = false;
        sE = false;
    }

    public static void setE(boolean z) {
        sE = z;
    }

    public static void setI(boolean z) {
        sI = z;
    }

    public static void setSeprateor(String str) {
        sSeparator = str;
    }

    public static void setSpecial(String str) {
        special = str;
    }

    public static void setV(boolean z) {
        sV = z;
    }

    public static void setW(boolean z) {
        sW = z;
    }

    public static void v(String str) {
        if (sV && sIsDebug) {
            Log.v(TAG, special + sSeparator + str);
        }
    }

    public static void v(String str, String str2) {
        if (sV && sIsDebug) {
            Log.v(str, special + sSeparator + str2);
        }
    }

    public static void w(String str) {
        if (sW && sIsDebug) {
            Log.w(TAG, special + sSeparator + str);
        }
    }

    public static void w(String str, String str2) {
        if (sW && sIsDebug) {
            Log.w(str, special + sSeparator + str2);
        }
    }
}

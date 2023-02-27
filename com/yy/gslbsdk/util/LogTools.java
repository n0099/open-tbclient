package com.yy.gslbsdk.util;

import android.text.TextUtils;
import android.util.Log;
import com.yy.gslbsdk.GslbEvent;
import java.util.Locale;
/* loaded from: classes8.dex */
public class LogTools {
    public static final String TAG = GlobalTools.LOG_TAG + "-2.2.28-live";

    public static void printDebug(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            Log.d(TAG, String.format(Locale.US, "[%s] %s", str, str2));
        }
        printMsgEvent("debug", str, str2);
    }

    public static void printError(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            Log.e(TAG, String.format(Locale.US, "[%s] %s", str, str2));
        }
        printMsgEvent("error", str, str2);
    }

    public static void printInfo(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            Log.i(TAG, String.format(Locale.US, "[%s] %s", str, str2));
        }
        printMsgEvent("info", str, str2);
    }

    public static void printWarning(String str, Exception exc) {
        if (exc == null) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            Log.w(TAG, String.format(Locale.US, "[%s] %s", str, exc));
        }
        printMsgEvent("warn", str, exc.getLocalizedMessage());
    }

    public static void printMsgEvent(String str, String str2, String str3) {
        GslbEvent.INSTANCE.onMessage(String.format(Locale.US, " [%s][%s][%s] %s", str, TAG, str2, str3));
    }

    public static void printWarning(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (GlobalTools.LOG_IS_OPEN) {
            Log.w(TAG, String.format(Locale.US, "[%s] %s", str, str2));
        }
        printMsgEvent("warn", str, str2);
    }
}

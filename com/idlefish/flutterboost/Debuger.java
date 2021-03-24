package com.idlefish.flutterboost;

import com.idlefish.flutterboost.log.AndroidLog;
import com.idlefish.flutterboost.log.ILog;
/* loaded from: classes6.dex */
public class Debuger {
    public static final Debuger DEBUG = new Debuger();
    public static ILog sLog = new AndroidLog();
    public static boolean sSafeMode = false;

    public static boolean canThrowError() {
        return isDebug() && !sSafeMode;
    }

    public static void exception(String str) {
        if (!canThrowError()) {
            sLog.e("FlutterBoost#", "exception", new RuntimeException(str));
            return;
        }
        throw new RuntimeException(str);
    }

    public static boolean isDebug() {
        try {
            return FlutterBoost.instance().platform().isDebug();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void log(String str) {
        DEBUG.print(str);
    }

    public final void print(String str) {
        if (isDebug()) {
            sLog.e("FlutterBoost#", str);
        }
    }

    public static void exception(Throwable th) {
        if (!canThrowError()) {
            sLog.e("FlutterBoost#", "exception", th);
            return;
        }
        throw new RuntimeException(th);
    }
}

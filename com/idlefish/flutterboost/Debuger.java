package com.idlefish.flutterboost;

import com.idlefish.flutterboost.log.AndroidLog;
import com.idlefish.flutterboost.log.ILog;
/* loaded from: classes12.dex */
public class Debuger {
    private static final Debuger DEBUG = new Debuger();
    private static boolean sSafeMode = false;
    private static ILog sLog = new AndroidLog();

    private Debuger() {
    }

    private void print(String str) {
        if (isDebug()) {
            sLog.e("FlutterBoost#", str);
        }
    }

    public static void log(String str) {
        DEBUG.print(str);
    }

    public static void exception(String str) {
        if (canThrowError()) {
            throw new RuntimeException(str);
        }
        sLog.e("FlutterBoost#", "exception", new RuntimeException(str));
    }

    public static void exception(Throwable th) {
        if (canThrowError()) {
            throw new RuntimeException(th);
        }
        sLog.e("FlutterBoost#", "exception", th);
    }

    public static boolean isDebug() {
        try {
            return FlutterBoost.instance().platform().isDebug();
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean canThrowError() {
        return isDebug() && !sSafeMode;
    }
}

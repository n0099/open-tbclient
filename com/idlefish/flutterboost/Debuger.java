package com.idlefish.flutterboost;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes6.dex */
public class Debuger {
    private static final Debuger DEBUG = new Debuger();

    private Debuger() {
    }

    private void print(String str) {
        if (isDebug()) {
            BdLog.e(str);
        }
    }

    public static void log(String str) {
        DEBUG.print(str);
    }

    public static void exception(String str) {
        if (isDebug()) {
            throw new RuntimeException(str);
        }
        BdLog.e(new RuntimeException(str));
    }

    public static boolean isDebug() {
        try {
            return FlutterBoost.instance().platform().isDebug();
        } catch (Throwable th) {
            return false;
        }
    }
}

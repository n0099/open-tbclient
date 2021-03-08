package com.thunder.livesdk.log;

import android.util.Log;
import com.thunder.livesdk.helper.ThunderNative;
/* loaded from: classes6.dex */
public class ThunderLog {
    private static volatile ThunderLog instance = null;
    public static final String kLogTagCall = "ycall-Java";
    public static final String kLogTagCallback = "ycallback-Java";
    public static final String kLogTagRtcEngine = "yrtc";
    public static final String kLogTagSdk = "ysdk-Java";
    public static final String kLogTagVideo = "yvideo-Java";
    private static Object syncLock = new Object();
    private static int logLevel = 10;

    /* loaded from: classes6.dex */
    public static final class YYLogModule {
        public static final int YYLOG_MODULE_AUDIO = 101;
        public static final int YYLOG_MODULE_PLATFORM = 100;
        public static final int YYLOG_MODULE_TRANS = 103;
        public static final int YYLOG_MODULE_UNKNOWN = 0;
        public static final int YYLOG_MODULE_VIDEO = 102;
    }

    public static ThunderLog instance() {
        if (instance == null) {
            synchronized (syncLock) {
                if (instance == null) {
                    instance = new ThunderLog();
                }
            }
        }
        return instance;
    }

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void trace(String str, String str2, Object... objArr) {
        logM(0, 100, str, str2, objArr);
    }

    public static void trace(String str, String str2) {
        logM(0, 100, str, str2);
    }

    public static void debug(String str, String str2, Object... objArr) {
        logM(1, 100, str, str2, objArr);
    }

    public static void debug(String str, String str2) {
        logM(1, 100, str, str2);
    }

    public static void info(String str, String str2, Object... objArr) {
        logM(2, 100, str, str2, objArr);
    }

    public static void info(String str, String str2) {
        logM(2, 100, str, str2);
    }

    public static void warn(String str, String str2, Object... objArr) {
        logM(3, 100, str, str2, objArr);
    }

    public static void warn(String str, String str2) {
        logM(3, 100, str, str2);
    }

    public static void error(String str, String str2, Object... objArr) {
        logM(4, 100, str, str2, objArr);
    }

    public static void error(String str, String str2) {
        logM(4, 100, str, str2);
    }

    public static void release(String str, String str2, Object... objArr) {
        logM(10, 100, str, str2, objArr);
    }

    public static void release(String str, String str2) {
        logM(10, 100, str, str2);
    }

    public static void logM(int i, int i2, String str, String str2) {
        ThunderNative.logText(i, i2, str, str2);
    }

    public static void logM(int i, int i2, String str, String str2, Object... objArr) {
        if (i >= logLevel) {
            ThunderNative.logText(i, i2, str, String.format(str2, objArr));
        }
    }

    public static boolean isInfoValid() {
        return logLevel <= 2;
    }

    public static boolean isWarnValid() {
        return logLevel <= 3;
    }

    public static boolean isErrorValid() {
        return logLevel <= 4;
    }

    public void enableConsoleLogger(boolean z) {
        Log.v("TLog", "enableConsoleLogger, bEnable " + z);
    }
}

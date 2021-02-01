package com.yy.audioengine;
/* loaded from: classes4.dex */
public class YALog {
    private static native void nativeDebug(String str);

    private static native void nativeError(String str);

    private static native void nativeInfo(String str);

    public static void debug(String str) {
        nativeDebug(str);
    }

    public static void info(String str) {
        nativeInfo(str);
    }

    public static void error(String str) {
        nativeError(str);
    }
}

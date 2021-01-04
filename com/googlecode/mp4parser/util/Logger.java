package com.googlecode.mp4parser.util;
/* loaded from: classes6.dex */
public abstract class Logger {
    public abstract void logDebug(String str);

    public abstract void logError(String str);

    public abstract void logWarn(String str);

    public static Logger getLogger(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new AndroidLogger(cls.getSimpleName()) : new JuliLogger(cls.getSimpleName());
    }
}

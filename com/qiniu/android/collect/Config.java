package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String nmG;
    public static boolean nmF = true;
    public static boolean isUpload = true;
    public static int nmH = 2097152;
    public static int nmI = 4096;
    public static int acx = 10;

    static {
        nmG = null;
        try {
            nmG = ContextGetter.dGi().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

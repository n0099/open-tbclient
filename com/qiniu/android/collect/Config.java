package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes6.dex */
public final class Config {
    public static String oEk;
    public static boolean oEj = true;
    public static boolean isUpload = true;
    public static int oEl = 2097152;
    public static int oEm = 4096;
    public static int aIW = 10;

    static {
        oEk = null;
        try {
            oEk = ContextGetter.eko().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

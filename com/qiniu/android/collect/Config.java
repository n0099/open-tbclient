package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes6.dex */
public final class Config {
    public static String nKY;
    public static boolean nKX = true;
    public static boolean isUpload = true;
    public static int nKZ = 2097152;
    public static int nLa = 4096;
    public static int azu = 10;

    static {
        nKY = null;
        try {
            nKY = ContextGetter.dQv().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes6.dex */
public final class Config {
    public static String nKW;
    public static boolean nKV = true;
    public static boolean isUpload = true;
    public static int nKX = 2097152;
    public static int nKY = 4096;
    public static int azu = 10;

    static {
        nKW = null;
        try {
            nKW = ContextGetter.dQu().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

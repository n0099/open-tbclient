package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String nCl;
    public static boolean nCk = true;
    public static boolean isUpload = true;
    public static int nCm = 2097152;
    public static int nCn = 4096;
    public static int ayh = 10;

    static {
        nCl = null;
        try {
            nCl = ContextGetter.dMU().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

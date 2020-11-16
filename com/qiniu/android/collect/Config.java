package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes6.dex */
public final class Config {
    public static String pGD;
    public static boolean pGC = true;
    public static boolean isUpload = true;
    public static int pGE = 2097152;
    public static int pGF = 4096;
    public static int aIN = 10;

    static {
        pGD = null;
        try {
            pGD = ContextGetter.eye().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

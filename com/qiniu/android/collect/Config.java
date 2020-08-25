package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes6.dex */
public final class Config {
    public static String oeR;
    public static boolean oeQ = true;
    public static boolean isUpload = true;
    public static int oeS = 2097152;
    public static int oeT = 4096;
    public static int aEF = 10;

    static {
        oeR = null;
        try {
            oeR = ContextGetter.ecx().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

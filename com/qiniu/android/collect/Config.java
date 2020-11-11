package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes6.dex */
public final class Config {
    public static String pFa;
    public static boolean pEZ = true;
    public static boolean isUpload = true;
    public static int pFb = 2097152;
    public static int pFc = 4096;
    public static int aKy = 10;

    static {
        pFa = null;
        try {
            pFa = ContextGetter.eyd().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes6.dex */
public final class Config {
    public static String ooS;
    public static boolean ooR = true;
    public static boolean isUpload = true;
    public static int ooT = 2097152;
    public static int ooU = 4096;
    public static int aFS = 10;

    static {
        ooS = null;
        try {
            ooS = ContextGetter.egD().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

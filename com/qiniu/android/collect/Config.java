package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String nou;
    public static boolean nos = true;
    public static boolean isUpload = true;
    public static int nov = 2097152;
    public static int nox = 4096;
    public static int acH = 10;

    static {
        nou = null;
        try {
            nou = ContextGetter.dGI().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

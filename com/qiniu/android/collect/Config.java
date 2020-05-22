package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String nfl;
    public static boolean nfk = true;
    public static boolean isUpload = true;
    public static int nfm = 2097152;
    public static int nfn = 4096;
    public static int avZ = 10;

    static {
        nfl = null;
        try {
            nfl = ContextGetter.dIa().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

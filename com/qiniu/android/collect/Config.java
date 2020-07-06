package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String nCo;
    public static boolean nCn = true;
    public static boolean isUpload = true;
    public static int nCp = 2097152;
    public static int nCq = 4096;
    public static int ayh = 10;

    static {
        nCo = null;
        try {
            nCo = ContextGetter.dMY().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

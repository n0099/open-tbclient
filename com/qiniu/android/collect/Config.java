package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String nmt;
    public static boolean nms = true;
    public static boolean isUpload = true;
    public static int nmu = 2097152;
    public static int nmv = 4096;
    public static int acx = 10;

    static {
        nmt = null;
        try {
            nmt = ContextGetter.dGf().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

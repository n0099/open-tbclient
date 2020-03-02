package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String nmv;
    public static boolean nmu = true;
    public static boolean isUpload = true;
    public static int nmw = 2097152;
    public static int nmx = 4096;
    public static int acx = 10;

    static {
        nmv = null;
        try {
            nmv = ContextGetter.dGh().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

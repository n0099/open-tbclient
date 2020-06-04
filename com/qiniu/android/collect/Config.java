package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String ngv;
    public static boolean ngu = true;
    public static boolean isUpload = true;
    public static int ngw = 2097152;
    public static int ngx = 4096;
    public static int avZ = 10;

    static {
        ngv = null;
        try {
            ngv = ContextGetter.dIo().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

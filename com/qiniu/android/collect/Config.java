package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes6.dex */
public final class Config {
    public static String ofk;
    public static boolean ofj = true;
    public static boolean isUpload = true;
    public static int ofl = 2097152;
    public static int ofm = 4096;
    public static int aEH = 10;

    static {
        ofk = null;
        try {
            ofk = ContextGetter.ecG().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes6.dex */
public final class Config {
    public static String pvG;
    public static boolean pvF = true;
    public static boolean isUpload = true;
    public static int pvH = 2097152;
    public static int pvI = 4096;
    public static int aJy = 10;

    static {
        pvG = null;
        try {
            pvG = ContextGetter.euo().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

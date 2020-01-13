package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes4.dex */
public final class Config {
    public static String nlN;
    public static boolean nlM = true;
    public static boolean isUpload = true;
    public static int nlO = 2097152;
    public static int nlP = 4096;
    public static int aaz = 10;

    static {
        nlN = null;
        try {
            nlN = ContextGetter.dEW().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

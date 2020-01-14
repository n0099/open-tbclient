package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes4.dex */
public final class Config {
    public static String nlS;
    public static boolean nlR = true;
    public static boolean isUpload = true;
    public static int nlT = 2097152;
    public static int nlU = 4096;
    public static int aaz = 10;

    static {
        nlS = null;
        try {
            nlS = ContextGetter.dEY().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

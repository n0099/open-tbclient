package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String mLe;
    public static boolean mLd = true;
    public static boolean isUpload = true;
    public static int mLf = 2097152;
    public static int mLg = 4096;
    public static int aqT = 10;

    static {
        mLe = null;
        try {
            mLe = ContextGetter.dAK().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

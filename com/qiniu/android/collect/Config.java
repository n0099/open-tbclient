package com.qiniu.android.collect;

import com.qiniu.android.utils.ContextGetter;
/* loaded from: classes5.dex */
public final class Config {
    public static String mLh;
    public static boolean mLg = true;
    public static boolean isUpload = true;
    public static int mLi = 2097152;
    public static int mLj = 4096;
    public static int aqZ = 10;

    static {
        mLh = null;
        try {
            mLh = ContextGetter.dAH().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}

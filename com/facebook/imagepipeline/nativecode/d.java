package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    public static boolean mzA;
    private static c mzz;

    static {
        mzA = false;
        try {
            mzz = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            mzA = true;
        } catch (Throwable th) {
            mzA = false;
        }
    }

    public static c dBt() {
        return mzz;
    }
}

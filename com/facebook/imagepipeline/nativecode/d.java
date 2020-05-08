package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    private static c mey;
    public static boolean mez;

    static {
        mez = false;
        try {
            mey = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            mez = true;
        } catch (Throwable th) {
            mez = false;
        }
    }

    public static c dtN() {
        return mey;
    }
}

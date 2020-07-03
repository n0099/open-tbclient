package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    private static c mVG;
    public static boolean mVH;

    static {
        mVH = false;
        try {
            mVG = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            mVH = true;
        } catch (Throwable th) {
            mVH = false;
        }
    }

    public static c dFV() {
        return mVG;
    }
}

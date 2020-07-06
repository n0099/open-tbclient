package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    private static c mVJ;
    public static boolean mVK;

    static {
        mVK = false;
        try {
            mVJ = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            mVK = true;
        } catch (Throwable th) {
            mVK = false;
        }
    }

    public static c dFZ() {
        return mVJ;
    }
}

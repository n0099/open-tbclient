package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    private static c meu;
    public static boolean mev;

    static {
        mev = false;
        try {
            meu = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            mev = true;
        } catch (Throwable th) {
            mev = false;
        }
    }

    public static c dtQ() {
        return meu;
    }
}

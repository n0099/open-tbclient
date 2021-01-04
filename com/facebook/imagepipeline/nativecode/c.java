package com.facebook.imagepipeline.nativecode;
/* loaded from: classes6.dex */
public class c {
    private static b pDQ;
    public static boolean pDR;

    static {
        pDR = false;
        try {
            pDQ = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            pDR = true;
        } catch (Throwable th) {
            pDR = false;
        }
    }

    public static b eAa() {
        return pDQ;
    }
}

package com.facebook.imagepipeline.nativecode;
/* loaded from: classes5.dex */
public class d {
    private static c pFx;
    public static boolean pFy;

    static {
        pFy = false;
        try {
            pFx = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            pFy = true;
        } catch (Throwable th) {
            pFy = false;
        }
    }

    public static c eAE() {
        return pFx;
    }
}

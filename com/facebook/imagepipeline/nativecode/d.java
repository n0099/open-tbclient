package com.facebook.imagepipeline.nativecode;
/* loaded from: classes5.dex */
public class d {
    private static c pNK;
    public static boolean pNL;

    static {
        pNL = false;
        try {
            pNK = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            pNL = true;
        } catch (Throwable th) {
            pNL = false;
        }
    }

    public static c ezv() {
        return pNK;
    }
}

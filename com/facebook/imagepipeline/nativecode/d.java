package com.facebook.imagepipeline.nativecode;
/* loaded from: classes7.dex */
public class d {
    private static c poo;
    public static boolean poq;

    static {
        poq = false;
        try {
            poo = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            poq = true;
        } catch (Throwable th) {
            poq = false;
        }
    }

    public static c ewt() {
        return poo;
    }
}

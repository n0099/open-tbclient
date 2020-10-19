package com.facebook.imagepipeline.nativecode;
/* loaded from: classes12.dex */
public class d {
    private static c nXi;
    public static boolean nXj;

    static {
        nXj = false;
        try {
            nXi = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            nXj = true;
        } catch (Throwable th) {
            nXj = false;
        }
    }

    public static c edd() {
        return nXi;
    }
}

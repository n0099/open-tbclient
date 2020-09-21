package com.facebook.imagepipeline.nativecode;
/* loaded from: classes12.dex */
public class d {
    private static c nHR;
    public static boolean nHS;

    static {
        nHS = false;
        try {
            nHR = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            nHS = true;
        } catch (Throwable th) {
            nHS = false;
        }
    }

    public static c dZs() {
        return nHR;
    }
}

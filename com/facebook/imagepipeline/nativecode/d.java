package com.facebook.imagepipeline.nativecode;
/* loaded from: classes8.dex */
public class d {
    private static c nxU;
    public static boolean nxV;

    static {
        nxV = false;
        try {
            nxU = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            nxV = true;
        } catch (Throwable th) {
            nxV = false;
        }
    }

    public static c dVu() {
        return nxU;
    }
}

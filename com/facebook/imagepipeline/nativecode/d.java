package com.facebook.imagepipeline.nativecode;
/* loaded from: classes8.dex */
public class d {
    private static c nxC;
    public static boolean nxD;

    static {
        nxD = false;
        try {
            nxC = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            nxD = true;
        } catch (Throwable th) {
            nxD = false;
        }
    }

    public static c dVl() {
        return nxC;
    }
}

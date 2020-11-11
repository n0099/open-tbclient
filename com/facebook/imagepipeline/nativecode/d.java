package com.facebook.imagepipeline.nativecode;
/* loaded from: classes12.dex */
public class d {
    private static c oXT;
    public static boolean oXU;

    static {
        oXU = false;
        try {
            oXT = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            oXU = true;
        } catch (Throwable th) {
            oXU = false;
        }
    }

    public static c eqS() {
        return oXT;
    }
}

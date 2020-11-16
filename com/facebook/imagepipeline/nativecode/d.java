package com.facebook.imagepipeline.nativecode;
/* loaded from: classes17.dex */
public class d {
    private static c oZw;
    public static boolean oZx;

    static {
        oZx = false;
        try {
            oZw = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            oZx = true;
        } catch (Throwable th) {
            oZx = false;
        }
    }

    public static c eqQ() {
        return oZw;
    }
}

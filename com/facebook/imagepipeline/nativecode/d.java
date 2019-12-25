package com.facebook.imagepipeline.nativecode;
/* loaded from: classes11.dex */
public class d {
    private static c lQs;
    public static boolean lQt;

    static {
        lQt = false;
        try {
            lQs = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            lQt = true;
        } catch (Throwable th) {
            lQt = false;
        }
    }

    public static c doV() {
        return lQs;
    }
}

package com.facebook.imagepipeline.nativecode;
/* loaded from: classes5.dex */
public class d {
    private static c pAX;
    public static boolean pAY;

    static {
        pAY = false;
        try {
            pAX = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            pAY = true;
        } catch (Throwable th) {
            pAY = false;
        }
    }

    public static c ewM() {
        return pAX;
    }
}

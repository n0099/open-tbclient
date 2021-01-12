package com.facebook.imagepipeline.nativecode;
/* loaded from: classes5.dex */
public class d {
    private static c pAW;
    public static boolean pAX;

    static {
        pAX = false;
        try {
            pAW = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            pAX = true;
        } catch (Throwable th) {
            pAX = false;
        }
    }

    public static c ewM() {
        return pAW;
    }
}

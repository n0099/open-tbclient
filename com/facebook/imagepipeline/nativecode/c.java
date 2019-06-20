package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b kbV;
    public static boolean kbW;

    static {
        kbW = false;
        try {
            kbV = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            kbW = true;
        } catch (Throwable th) {
            kbW = false;
        }
    }

    public static b cHv() {
        return kbV;
    }
}

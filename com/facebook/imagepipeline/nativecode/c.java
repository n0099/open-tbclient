package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b kbS;
    public static boolean kbT;

    static {
        kbT = false;
        try {
            kbS = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            kbT = true;
        } catch (Throwable th) {
            kbT = false;
        }
    }

    public static b cHw() {
        return kbS;
    }
}

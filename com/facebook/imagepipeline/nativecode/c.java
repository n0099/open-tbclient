package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b kbR;
    public static boolean kbS;

    static {
        kbS = false;
        try {
            kbR = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            kbS = true;
        } catch (Throwable th) {
            kbS = false;
        }
    }

    public static b cHu() {
        return kbR;
    }
}

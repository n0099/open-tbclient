package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b kkR;
    public static boolean kkS;

    static {
        kkS = false;
        try {
            kkR = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            kkS = true;
        } catch (Throwable th) {
            kkS = false;
        }
    }

    public static b cIF() {
        return kkR;
    }
}

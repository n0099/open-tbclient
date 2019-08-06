package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b kki;
    public static boolean kkj;

    static {
        kkj = false;
        try {
            kki = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            kkj = true;
        } catch (Throwable th) {
            kkj = false;
        }
    }

    public static b cKU() {
        return kki;
    }
}

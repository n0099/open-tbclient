package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b kka;
    public static boolean kkb;

    static {
        kkb = false;
        try {
            kka = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            kkb = true;
        } catch (Throwable th) {
            kkb = false;
        }
    }

    public static b cID() {
        return kka;
    }
}

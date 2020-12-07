package com.facebook.imagepipeline.nativecode;
/* loaded from: classes7.dex */
public class d {
    private static c pom;
    public static boolean pon;

    static {
        pon = false;
        try {
            pom = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            pon = true;
        } catch (Throwable th) {
            pon = false;
        }
    }

    public static c ews() {
        return pom;
    }
}

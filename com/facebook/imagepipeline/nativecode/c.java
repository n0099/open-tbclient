package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b jJd;
    public static boolean jJe;

    static {
        jJe = false;
        try {
            jJd = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            jJe = true;
        } catch (Throwable th) {
            jJe = false;
        }
    }

    public static b czy() {
        return jJd;
    }
}

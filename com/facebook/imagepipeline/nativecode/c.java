package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b jJe;
    public static boolean jJf;

    static {
        jJf = false;
        try {
            jJe = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            jJf = true;
        } catch (Throwable th) {
            jJf = false;
        }
    }

    public static b czy() {
        return jJe;
    }
}

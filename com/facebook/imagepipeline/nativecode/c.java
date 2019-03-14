package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b jJJ;
    public static boolean jJK;

    static {
        jJK = false;
        try {
            jJJ = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            jJK = true;
        } catch (Throwable th) {
            jJK = false;
        }
    }

    public static b czF() {
        return jJJ;
    }
}

package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b jJR;
    public static boolean jJS;

    static {
        jJS = false;
        try {
            jJR = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            jJS = true;
        } catch (Throwable th) {
            jJS = false;
        }
    }

    public static b czC() {
        return jJR;
    }
}

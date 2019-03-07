package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b jJy;
    public static boolean jJz;

    static {
        jJz = false;
        try {
            jJy = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            jJz = true;
        } catch (Throwable th) {
            jJz = false;
        }
    }

    public static b czs() {
        return jJy;
    }
}

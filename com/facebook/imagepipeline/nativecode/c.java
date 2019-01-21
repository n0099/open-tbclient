package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b itQ;
    public static boolean itR;

    static {
        itR = false;
        try {
            itQ = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            itR = true;
        } catch (Throwable th) {
            itR = false;
        }
    }

    public static b can() {
        return itQ;
    }
}

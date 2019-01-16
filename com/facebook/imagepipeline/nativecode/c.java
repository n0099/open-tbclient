package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b itP;
    public static boolean itQ;

    static {
        itQ = false;
        try {
            itP = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            itQ = true;
        } catch (Throwable th) {
            itQ = false;
        }
    }

    public static b can() {
        return itP;
    }
}

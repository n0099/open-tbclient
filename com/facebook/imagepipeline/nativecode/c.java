package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b isI;
    public static boolean isJ;

    static {
        isJ = false;
        try {
            isI = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            isJ = true;
        } catch (Throwable th) {
            isJ = false;
        }
    }

    public static b bZF() {
        return isI;
    }
}

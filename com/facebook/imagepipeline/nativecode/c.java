package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b iim;
    public static boolean iin;

    static {
        iin = false;
        try {
            iim = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            iin = true;
        } catch (Throwable th) {
            iin = false;
        }
    }

    public static b bWJ() {
        return iim;
    }
}

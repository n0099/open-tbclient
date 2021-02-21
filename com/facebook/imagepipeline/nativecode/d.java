package com.facebook.imagepipeline.nativecode;
/* loaded from: classes5.dex */
public class d {
    private static c pLF;
    public static boolean pLG;

    static {
        pLG = false;
        try {
            pLF = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            pLG = true;
        } catch (Throwable th) {
            pLG = false;
        }
    }

    public static c ezm() {
        return pLF;
    }
}

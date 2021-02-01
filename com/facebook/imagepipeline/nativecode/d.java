package com.facebook.imagepipeline.nativecode;
/* loaded from: classes5.dex */
public class d {
    private static c pLf;
    public static boolean pLg;

    static {
        pLg = false;
        try {
            pLf = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            pLg = true;
        } catch (Throwable th) {
            pLg = false;
        }
    }

    public static c eze() {
        return pLf;
    }
}

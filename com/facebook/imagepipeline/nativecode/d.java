package com.facebook.imagepipeline.nativecode;
/* loaded from: classes3.dex */
public class d {
    private static c ndK;
    public static boolean ndL;

    static {
        ndL = false;
        try {
            ndK = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            ndL = true;
        } catch (Throwable th) {
            ndL = false;
        }
    }

    public static c dJl() {
        return ndK;
    }
}

package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b igB;
    public static boolean igC;

    static {
        igC = false;
        try {
            igB = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            igC = true;
        } catch (Throwable th) {
            igC = false;
        }
    }

    public static b bXo() {
        return igB;
    }
}

package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b igC;
    public static boolean igD;

    static {
        igD = false;
        try {
            igC = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            igD = true;
        } catch (Throwable th) {
            igD = false;
        }
    }

    public static b bXo() {
        return igC;
    }
}

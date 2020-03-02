package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    private static c lUS;
    public static boolean lUT;

    static {
        lUT = false;
        try {
            lUS = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            lUT = true;
        } catch (Throwable th) {
            lUT = false;
        }
    }

    public static c dru() {
        return lUS;
    }
}

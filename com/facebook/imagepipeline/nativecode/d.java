package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    private static c lVd;
    public static boolean lVe;

    static {
        lVe = false;
        try {
            lVd = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            lVe = true;
        } catch (Throwable th) {
            lVe = false;
        }
    }

    public static c drv() {
        return lVd;
    }
}

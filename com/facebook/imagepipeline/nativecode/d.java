package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    private static c lWJ;
    public static boolean lWK;

    static {
        lWK = false;
        try {
            lWJ = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            lWK = true;
        } catch (Throwable th) {
            lWK = false;
        }
    }

    public static c drS() {
        return lWJ;
    }
}

package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    private static c lUQ;
    public static boolean lUR;

    static {
        lUR = false;
        try {
            lUQ = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            lUR = true;
        } catch (Throwable th) {
            lUR = false;
        }
    }

    public static c drs() {
        return lUQ;
    }
}

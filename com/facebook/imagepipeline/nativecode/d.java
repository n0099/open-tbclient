package com.facebook.imagepipeline.nativecode;
/* loaded from: classes12.dex */
public class d {
    private static c lUe;
    public static boolean lUf;

    static {
        lUf = false;
        try {
            lUe = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            lUf = true;
        } catch (Throwable th) {
            lUf = false;
        }
    }

    public static c dqe() {
        return lUe;
    }
}

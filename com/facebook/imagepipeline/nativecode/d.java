package com.facebook.imagepipeline.nativecode;
/* loaded from: classes12.dex */
public class d {
    private static c lUj;
    public static boolean lUk;

    static {
        lUk = false;
        try {
            lUj = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            lUk = true;
        } catch (Throwable th) {
            lUk = false;
        }
    }

    public static c dqg() {
        return lUj;
    }
}

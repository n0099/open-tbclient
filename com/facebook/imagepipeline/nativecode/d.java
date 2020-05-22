package com.facebook.imagepipeline.nativecode;
/* loaded from: classes13.dex */
public class d {
    private static c myp;
    public static boolean myq;

    static {
        myq = false;
        try {
            myp = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            myq = true;
        } catch (Throwable th) {
            myq = false;
        }
    }

    public static c dBf() {
        return myp;
    }
}

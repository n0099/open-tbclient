package com.facebook.imagepipeline.nativecode;
/* loaded from: classes12.dex */
public class d {
    private static c oOA;
    public static boolean oOB;

    static {
        oOB = false;
        try {
            oOA = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            oOB = true;
        } catch (Throwable th) {
            oOB = false;
        }
    }

    public static c enb() {
        return oOA;
    }
}

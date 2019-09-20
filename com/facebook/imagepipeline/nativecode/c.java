package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b kmF;
    public static boolean kmG;

    static {
        kmG = false;
        try {
            kmF = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            kmG = true;
        } catch (Throwable th) {
            kmG = false;
        }
    }

    public static b cLI() {
        return kmF;
    }
}

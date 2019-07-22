package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b kjc;
    public static boolean kjd;

    static {
        kjd = false;
        try {
            kjc = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            kjd = true;
        } catch (Throwable th) {
            kjd = false;
        }
    }

    public static b cKz() {
        return kjc;
    }
}

package com.facebook.imagepipeline.nativecode;
/* loaded from: classes3.dex */
public class d {
    private static c ndM;
    public static boolean ndN;

    static {
        ndN = false;
        try {
            ndM = (c) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            ndN = true;
        } catch (Throwable th) {
            ndN = false;
        }
    }

    public static c dJm() {
        return ndM;
    }
}

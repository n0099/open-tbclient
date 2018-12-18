package com.facebook.imagepipeline.nativecode;
/* loaded from: classes2.dex */
public class c {
    private static b ipy;
    public static boolean ipz;

    static {
        ipz = false;
        try {
            ipy = (b) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            ipz = true;
        } catch (Throwable th) {
            ipz = false;
        }
    }

    public static b bYO() {
        return ipy;
    }
}

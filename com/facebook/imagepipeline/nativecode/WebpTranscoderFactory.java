package com.facebook.imagepipeline.nativecode;
/* loaded from: classes5.dex */
public class WebpTranscoderFactory {
    public static WebpTranscoder sWebpTranscoder = null;
    public static boolean sWebpTranscoderPresent = false;

    static {
        try {
            sWebpTranscoder = (WebpTranscoder) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
            sWebpTranscoderPresent = true;
        } catch (Throwable unused) {
            sWebpTranscoderPresent = false;
        }
    }

    public static WebpTranscoder getWebpTranscoder() {
        return sWebpTranscoder;
    }
}

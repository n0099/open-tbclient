package com.facebook.imagepipeline.decoder;
/* loaded from: classes15.dex */
public class DecodeException extends RuntimeException {
    private final com.facebook.imagepipeline.g.e mEncodedImage;

    public DecodeException(String str, com.facebook.imagepipeline.g.e eVar) {
        super(str);
        this.mEncodedImage = eVar;
    }

    public DecodeException(String str, Throwable th, com.facebook.imagepipeline.g.e eVar) {
        super(str, th);
        this.mEncodedImage = eVar;
    }

    public com.facebook.imagepipeline.g.e getEncodedImage() {
        return this.mEncodedImage;
    }
}

package com.facebook.imagepipeline.transcoder;
/* loaded from: classes6.dex */
public class ImageTranscodeResult {
    public final int mTranscodeStatus;

    public ImageTranscodeResult(int i2) {
        this.mTranscodeStatus = i2;
    }

    public int getTranscodeStatus() {
        return this.mTranscodeStatus;
    }

    public String toString() {
        return String.format(null, "Status: %d", Integer.valueOf(this.mTranscodeStatus));
    }
}

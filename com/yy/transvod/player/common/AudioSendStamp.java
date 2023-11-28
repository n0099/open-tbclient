package com.yy.transvod.player.common;
/* loaded from: classes2.dex */
public class AudioSendStamp {
    public long a;
    public long b;

    public static native void nativeClassInit();

    public AudioSendStamp(long j, long j2) {
        this.a = j2;
        this.b = j;
    }

    public String toString() {
        return " sendStampMs=" + this.a + " mCaptureStampMs=" + this.b;
    }
}

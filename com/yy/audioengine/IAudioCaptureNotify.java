package com.yy.audioengine;
/* loaded from: classes6.dex */
public interface IAudioCaptureNotify {
    void onCaptureAudioVolume(int i);

    void onEncodedAudioData(byte[] bArr, long j, int i, int i2);
}

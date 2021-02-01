package com.thunder.livesdk;
/* loaded from: classes4.dex */
public interface ThunderVideoFrameConsumer {
    void consumeByteArrayFrame(byte[] bArr, int i, int i2, int i3, int i4, long j);

    void consumeTextureFrame(int i, int i2, int i3, int i4, int i5, long j, float[] fArr);

    void consumeVideoFrame(ThunderExternalVideoFrame thunderExternalVideoFrame);
}

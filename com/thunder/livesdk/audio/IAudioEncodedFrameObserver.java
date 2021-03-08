package com.thunder.livesdk.audio;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public interface IAudioEncodedFrameObserver {
    void onAudioEncodedFrame(ByteBuffer byteBuffer, int i, int i2, int i3, long j, int i4);
}

package com.thunder.livesdk.audio;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public interface IAudioFrameObserver {
    boolean onPlaybackAudioFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    boolean onPlaybackAudioFrameBeforeMixing(String str, ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    boolean onRecordAudioFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);
}

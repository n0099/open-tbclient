package com.thunder.livesdk.audio;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class AudioFrameObserver implements IAudioFrameObserver {
    @Override // com.thunder.livesdk.audio.IAudioFrameObserver
    public boolean onRecordAudioFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        return false;
    }

    @Override // com.thunder.livesdk.audio.IAudioFrameObserver
    public boolean onPlaybackAudioFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        return false;
    }

    @Override // com.thunder.livesdk.audio.IAudioFrameObserver
    public boolean onPlaybackAudioFrameBeforeMixing(String str, ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        return false;
    }

    public boolean onMixedAudioFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        return false;
    }
}

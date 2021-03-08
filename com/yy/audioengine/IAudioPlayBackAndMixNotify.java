package com.yy.audioengine;
/* loaded from: classes6.dex */
public interface IAudioPlayBackAndMixNotify {
    void fileMixerProgress(long j, long j2);

    void finishMixer();

    void playBackEnd();

    void playBackProgress(int i, long j, long j2);
}

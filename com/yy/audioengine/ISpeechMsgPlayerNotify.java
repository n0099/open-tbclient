package com.yy.audioengine;
/* loaded from: classes6.dex */
public interface ISpeechMsgPlayerNotify {
    void onAudioPlayError();

    void onAudioPlayStatus(long j, long j2, long j3);

    void onFirstStartPlayData();

    void onReachMaxPlayTime(long j, long j2);

    void onStopPlayData(long j, long j2);
}

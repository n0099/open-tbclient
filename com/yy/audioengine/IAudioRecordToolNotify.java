package com.yy.audioengine;

import com.yy.audioengine.Constant;
/* loaded from: classes4.dex */
public interface IAudioRecordToolNotify {
    void accompanyPlayEnd();

    void accompanyPlayVolume(long j, long j2, long j3);

    void onAudioRecordError(Constant.AudioDeviceErrorType audioDeviceErrorType);

    void onGetFirstRecordData();

    void onReachMaxDuration();

    void onStopRecordData(long j, long j2);

    void voiceRecordVolume(long j, long j2);
}

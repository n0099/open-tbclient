package com.yy.audioengine;

import com.yy.audioengine.Constant;
/* loaded from: classes6.dex */
public interface ISpeechMsgRecorderNotify {
    void onAudioRecordError(Constant.AudioDeviceErrorType audioDeviceErrorType);

    void onAudioVolumeVisual(long j, long j2);

    void onGetFirstRecordData();

    void onReachMaxDuration(long j, long j2);

    void onStopRecordData(long j, long j2);
}

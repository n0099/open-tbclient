package com.yy.audioengine;

import com.yy.audioengine.Constant;
/* loaded from: classes4.dex */
public interface IAudioEngineNotify {
    void onAudioCaptureError(Constant.AudioDeviceErrorType audioDeviceErrorType);

    void onAudioModeChange();

    void onAudioRenderError(Constant.AudioDeviceErrorType audioDeviceErrorType);

    void onHeadsetPlug(boolean z);

    void onReceivePhoneCall(boolean z);
}

package com.yy.audioengine;

import com.yy.audioengine.Constant;
/* loaded from: classes6.dex */
public class SpeechMsgRecorder {
    private ISpeechMsgRecorderNotify mNotify = null;
    private long mRecorderCtx;

    /* loaded from: classes6.dex */
    public enum RECORDER_INIT_STATUS {
        ERROR_NONE,
        ERROR_UNKNOWN_CODEC,
        ERROR_ENCODER_INIT,
        ERROR_FILE_OPEN_FAIL
    }

    /* loaded from: classes6.dex */
    public enum SpeechMsgCodecType {
        SpeechMsgCodecSilk,
        SpeechMsgCodecSpeex,
        SpeechMsgCodecEaacPlus,
        SpeechMsgCodecLcAAC,
        SpeechMsgCodecWav
    }

    private native long nativeCreate(Object obj, String str, int i, int i2, long j);

    private native long nativeDestroy(long j);

    private native void nativeEnableCompressor(long j, boolean z);

    private native void nativeEnableEqualizerEx(long j, boolean z);

    private native void nativeEnableLimiter(long j, boolean z);

    private native void nativeEnableReverbEx(long j, boolean z);

    private native void nativeEnableReverbFv3(long j, boolean z);

    private native long nativeInit(long j);

    private native void nativePause(long j);

    private native void nativeResume(long j);

    private native void nativeSeek(long j, long j2);

    private native void nativeSetCompressorParam(long j, int[] iArr);

    private native void nativeSetEqGains(long j, float[] fArr);

    private native void nativeSetLimiterParam(long j, float[] fArr);

    private native void nativeSetReverbFv3Param(long j, float[] fArr);

    private native void nativeSetReverbParamEx(long j, float[] fArr);

    private native void nativeSetVolume(long j, long j2);

    private native void nativeStart(long j);

    private native void nativeStartAudioPreview(long j);

    private native void nativeStop(long j);

    private native void nativeStopAudioPreview(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpeechMsgRecorder(String str, int i, SpeechMsgCodecType speechMsgCodecType, long j) {
        this.mRecorderCtx = nativeCreate(this, str, i, speechMsgCodecType.ordinal(), j);
    }

    public RECORDER_INIT_STATUS init() {
        nativeInit(this.mRecorderCtx);
        return RECORDER_INIT_STATUS.ERROR_NONE;
    }

    public void start(ISpeechMsgRecorderNotify iSpeechMsgRecorderNotify) {
        this.mNotify = iSpeechMsgRecorderNotify;
        nativeStart(this.mRecorderCtx);
    }

    public void stop() {
        nativeStop(this.mRecorderCtx);
    }

    public void pause() {
        nativePause(this.mRecorderCtx);
    }

    public void resume() {
        nativeResume(this.mRecorderCtx);
    }

    public void seek(long j) {
        nativeSeek(this.mRecorderCtx, j);
    }

    public void destroy() {
        this.mRecorderCtx = nativeDestroy(this.mRecorderCtx);
    }

    public void enableReverbEx(boolean z) {
        nativeEnableReverbEx(this.mRecorderCtx, z);
    }

    public void setReverbParamEx(float[] fArr) {
        nativeSetReverbParamEx(this.mRecorderCtx, fArr);
    }

    public void enableReverbFv3(boolean z) {
        nativeEnableReverbFv3(this.mRecorderCtx, z);
    }

    public void setReverbFv3Param(float[] fArr) {
        nativeSetReverbFv3Param(this.mRecorderCtx, fArr);
    }

    public void enableEqualizer(boolean z) {
        nativeEnableEqualizerEx(this.mRecorderCtx, z);
    }

    public void setEqGains(float[] fArr) {
        nativeSetEqGains(this.mRecorderCtx, fArr);
    }

    public void enableCompressor(boolean z) {
        nativeEnableCompressor(this.mRecorderCtx, z);
    }

    public void setCompressorParam(int[] iArr) {
        nativeSetCompressorParam(this.mRecorderCtx, iArr);
    }

    public void enableLimiter(boolean z) {
        nativeEnableLimiter(this.mRecorderCtx, z);
    }

    public void setLimiterParam(float[] fArr) {
        nativeSetLimiterParam(this.mRecorderCtx, fArr);
    }

    public void setVolume(long j) {
        nativeSetVolume(this.mRecorderCtx, j);
    }

    public void startAudioPreview() {
        nativeStartAudioPreview(this.mRecorderCtx);
    }

    public void stopAudioPreview() {
        nativeStopAudioPreview(this.mRecorderCtx);
    }

    private void onAudioVolumeVisualEvent(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.onAudioVolumeVisual(j, j2);
        }
    }

    private void onAudioRecordErrorEvent(int i) {
        if (this.mNotify != null) {
            this.mNotify.onAudioRecordError(Constant.AudioDeviceErrorType.values()[i]);
        }
    }

    private void onGetFirstRecordDataEvent() {
        if (this.mNotify != null) {
            this.mNotify.onGetFirstRecordData();
        }
    }

    private void onStopRecordDataEvent(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.onStopRecordData(j, j2);
        }
    }

    private void onReachMaxDurationEvent(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.onReachMaxDuration(j, j2);
        }
    }
}

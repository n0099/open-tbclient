package com.yy.audioengine;

import com.yy.audioengine.Constant;
import com.yy.audioengine.SpeechMsgRecorder;
/* loaded from: classes4.dex */
public class AudioEngine implements IAudioEngine {
    private static final String TAG = "AudioEngine";
    private IKaraokeScoreNotify mKaraokeScoreNotify;
    private SpeechMsgPlayer mSpeechMsgPlayer;
    private SpeechMsgRecorder mSpeechMsgRecorder;
    private IAudioCaptureNotify mCaptureNotify = null;
    private IAudioPullFrameNotify mPullFrameNotify = null;
    private IAudioRenderNotify mRenderNotify = null;
    private IAudioEngineNotify mAudioEngineNotify = null;
    private long engineCtx = nativeCreateAudioEngine(this);

    private native long nativeCreateAudioEngine(Object obj);

    private native void nativeDestroyAudioEngine(long j);

    private native void nativeEnableCaptureVolumeNotify(long j, boolean z);

    private native void nativeEnableCompressor(long j, boolean z);

    private native void nativeEnableDebugLoopDelay(long j, boolean z);

    private native void nativeEnableEqualizer(long j, boolean z);

    private native void nativeEnableKaraokeScore(long j, boolean z);

    private native void nativeEnableKaraokeScoreEx(long j, boolean z);

    private native void nativeEnableLimiter(long j, boolean z);

    private native void nativeEnablePackerVad(long j, boolean z);

    private native void nativeEnableRenderVolumeNotify(long j, boolean z);

    private native void nativeEnableReverbEx(long j, boolean z);

    private native void nativeEnableSingingAutoTune(long j, boolean z);

    private native void nativeEnableSoundPositionIndication(long j, boolean z);

    private native void nativeEnableVoiceBeautify(long j, boolean z);

    private native boolean nativeOneKeySingingAutoTuneProcess(long j, int i, String str, String str2);

    private native boolean nativeOpenScoreRefFile(long j, String str);

    private native void nativePauseKaraokeScore(long j, boolean z);

    private native void nativeResetKaraokeScore(long j, long j2);

    private native void nativeSetAudioSourceType(long j, int i);

    private native void nativeSetCompressorParameter(long j, int[] iArr);

    private native void nativeSetCurrentPlayingPosition(long j, long j2);

    private native void nativeSetEqualizerParameter(long j, float[] fArr);

    private native void nativeSetLimiterParameter(long j, float[] fArr);

    private native void nativeSetLocalVoicePitch(long j, float f);

    private native void nativeSetLoudspeakerStatus(long j, boolean z);

    private native boolean nativeSetPlaybackModeOn(long j, boolean z);

    private native boolean nativeSetRemoteStreamVolume(long j, long j2, int i);

    private native boolean nativeSetRemoteVoicePosition(long j, long j2, int i, int i2);

    private native void nativeSetReverbParamEx(long j, float[] fArr);

    private native void nativeSetReverbmode(long j, int i);

    private native byte[] nativeSetScoreTimeRange(long j, TimeRange[] timeRangeArr, long j2);

    private native boolean nativeSetSingRefLyricFile(long j, String str);

    private native boolean nativeSetSingRefLyricTimeRange(long j, TimeRange[] timeRangeArr, long j2);

    private native boolean nativeSetSingRefMfccFile(long j, String str);

    private native boolean nativeSetSingRefPitchFile(long j, String str);

    private native void nativeSetVirtualMicVolume(long j, int i);

    private native void nativeSetVirtualSpeakerVolume(long j, int i);

    private native void nativeSetVoiceBeautifyMode(long j, int i, float f, float f2);

    private native void nativeSetVoiceChangerMode(long j, int i);

    private native void nativeStartAudioEngine(long j, int i);

    private native void nativeStartAudioPreview(long j);

    private native boolean nativeStartAudioSaver(long j, String str, int i, int i2);

    private native void nativeStartCapture(long j, int i);

    private native boolean nativeStartInputDeviceTest(long j);

    private native void nativeStartKaraokeScore(long j);

    private native boolean nativeStartOutputDeviceTest(long j, String str);

    private native void nativeStartPlay(long j, long j2);

    private native void nativeStartWavDebugLogger(long j, String str);

    private native void nativeStopAudioEngine(long j);

    private native void nativeStopAudioPreview(long j);

    private native boolean nativeStopAudioSaver(long j);

    private native void nativeStopCapture(long j);

    private native boolean nativeStopInputDeviceTest(long j);

    private native void nativeStopKaraokeScore(long j);

    private native boolean nativeStopOutputDeviceTest(long j);

    private native void nativeStopPlay(long j, long j2);

    private native void nativeStopWavDebugLogger(long j);

    public void destroy() {
        nativeDestroyAudioEngine(this.engineCtx);
        this.engineCtx = 0L;
    }

    @Override // com.yy.audioengine.IAudioEngine
    public void startAudioEngine(Constant.AudioEngineMode audioEngineMode) {
        nativeStartAudioEngine(this.engineCtx, audioEngineMode.ordinal());
    }

    @Override // com.yy.audioengine.IAudioEngine
    public void stopAudioEngine() {
        nativeStopAudioEngine(this.engineCtx);
    }

    public void setAudioEngineNotify(IAudioEngineNotify iAudioEngineNotify) {
        this.mAudioEngineNotify = iAudioEngineNotify;
    }

    public void startCapture(IAudioCaptureNotify iAudioCaptureNotify, Constant.EncoderType encoderType) {
        this.mCaptureNotify = iAudioCaptureNotify;
        nativeStartCapture(this.engineCtx, encoderType.ordinal());
    }

    public void enablePackerVad(boolean z) {
        nativeEnablePackerVad(this.engineCtx, z);
    }

    public void stopCapture() {
        nativeStopCapture(this.engineCtx);
    }

    public void startPlayout(long j, IAudioPullFrameNotify iAudioPullFrameNotify) {
        this.mPullFrameNotify = iAudioPullFrameNotify;
        nativeStartPlay(this.engineCtx, j);
    }

    public void startPlayout2(long j, IAudioRenderNotify iAudioRenderNotify) {
        this.mRenderNotify = iAudioRenderNotify;
        nativeStartPlay(this.engineCtx, j);
    }

    public void stopPlayout(long j) {
        nativeStopPlay(this.engineCtx, j);
    }

    public void setVirtualSpeakerVolume(int i) {
        nativeSetVirtualSpeakerVolume(this.engineCtx, i);
    }

    public void setVirtualMicVolume(int i) {
        nativeSetVirtualMicVolume(this.engineCtx, i);
    }

    public boolean startAudioSaver(String str, Constant.AudioSaverMode audioSaverMode, Constant.AudioSaverWriteFileMode audioSaverWriteFileMode) {
        return nativeStartAudioSaver(this.engineCtx, str, audioSaverMode.ordinal(), audioSaverWriteFileMode.ordinal());
    }

    public boolean stopAudioSaver() {
        return nativeStopAudioSaver(this.engineCtx);
    }

    public void startSpeechMsgRecorder(String str, SpeechMsgRecorder.SpeechMsgCodecType speechMsgCodecType, int i, ISpeechMsgRecorderNotify iSpeechMsgRecorderNotify) {
        this.mSpeechMsgRecorder = new SpeechMsgRecorder(str, 1, speechMsgCodecType, i);
        this.mSpeechMsgRecorder.init();
        this.mSpeechMsgRecorder.start(iSpeechMsgRecorderNotify);
    }

    public void stopSpeechMsgRecorder() {
        this.mSpeechMsgRecorder.stop();
        this.mSpeechMsgRecorder.destroy();
        this.mSpeechMsgRecorder = null;
    }

    public void startSpeechMsgPlayer(String str, ISpeechMsgPlayerNotify iSpeechMsgPlayerNotify) {
        this.mSpeechMsgPlayer = new SpeechMsgPlayer(str);
        this.mSpeechMsgPlayer.init();
        this.mSpeechMsgPlayer.start(iSpeechMsgPlayerNotify);
    }

    public void stopSpeechMsgPlayer() {
        this.mSpeechMsgPlayer.stop();
        this.mSpeechMsgPlayer.destroy();
    }

    public void setReverbMode(Constant.ReverbMode reverbMode) {
        nativeSetReverbmode(this.engineCtx, reverbMode.ordinal());
    }

    public void enableRenderVolumeNotify(boolean z) {
        nativeEnableRenderVolumeNotify(this.engineCtx, z);
    }

    public void enableCaptureVolumeNotify(boolean z) {
        nativeEnableCaptureVolumeNotify(this.engineCtx, z);
    }

    public void enableVoiceBeautify(boolean z) {
        nativeEnableVoiceBeautify(this.engineCtx, z);
    }

    public void setVoiceBeautifyMode(Constant.VoiceBeautifyMode voiceBeautifyMode) {
        nativeSetVoiceBeautifyMode(this.engineCtx, voiceBeautifyMode.ordinal(), 0.0f, 0.0f);
    }

    public void setVoiceChangerMode(Constant.VoiceChangerMode voiceChangerMode) {
        nativeSetVoiceChangerMode(this.engineCtx, voiceChangerMode.ordinal());
    }

    public void startWavDebugLogger(String str) {
        nativeStartWavDebugLogger(this.engineCtx, str);
    }

    public void stopWavDebugLogger() {
        nativeStopWavDebugLogger(this.engineCtx);
    }

    public boolean isHeadsetMode() {
        return true;
    }

    public void enableEqualizer(boolean z) {
        nativeEnableEqualizer(this.engineCtx, z);
    }

    public void setEqualizerParameter(float[] fArr) {
        nativeSetEqualizerParameter(this.engineCtx, fArr);
    }

    public void enableReverbEx(boolean z) {
        nativeEnableReverbEx(this.engineCtx, z);
    }

    public void setReverbParameter(float[] fArr) {
        nativeSetReverbParamEx(this.engineCtx, fArr);
    }

    public void enableLimiter(boolean z) {
        nativeEnableLimiter(this.engineCtx, z);
    }

    public void setLimiterParameter(float[] fArr) {
        nativeSetLimiterParameter(this.engineCtx, fArr);
    }

    public void enableCompressor(boolean z) {
        nativeEnableCompressor(this.engineCtx, z);
    }

    public void setCompressor(int[] iArr) {
        nativeSetCompressorParameter(this.engineCtx, iArr);
    }

    public void startAudioPreview() {
        nativeStartAudioPreview(this.engineCtx);
    }

    public void stopAudioPreview() {
        nativeStopAudioPreview(this.engineCtx);
    }

    public void setLoudspeakerStatus(boolean z) {
        nativeSetLoudspeakerStatus(this.engineCtx, z);
    }

    public void enableKaraokeScoreEx(boolean z) {
        nativeEnableKaraokeScoreEx(this.engineCtx, z);
    }

    public void enableKaraokeScore(boolean z) {
        nativeEnableKaraokeScore(this.engineCtx, z);
    }

    public void startKaraokeScore(IKaraokeScoreNotify iKaraokeScoreNotify) {
        this.mKaraokeScoreNotify = iKaraokeScoreNotify;
        nativeStartKaraokeScore(this.engineCtx);
    }

    public void pauseKaraokeScore(boolean z) {
        nativePauseKaraokeScore(this.engineCtx, z);
    }

    public void stopKaraokeScore() {
        nativeStopKaraokeScore(this.engineCtx);
    }

    public void resetKaraokeScore(long j) {
        nativeResetKaraokeScore(this.engineCtx, j);
    }

    public boolean openScoreRefFile(String str) {
        return nativeOpenScoreRefFile(this.engineCtx, str);
    }

    public byte[] setScoreTimeRange(TimeRange[] timeRangeArr, int i) {
        return nativeSetScoreTimeRange(this.engineCtx, timeRangeArr, i);
    }

    public void enableSingingAutoTune(boolean z) {
        nativeEnableSingingAutoTune(this.engineCtx, z);
    }

    public void setCurrentPlayingPosition(long j) {
        nativeSetCurrentPlayingPosition(this.engineCtx, j);
    }

    public boolean setSingRefPitchFile(String str) {
        return nativeSetSingRefPitchFile(this.engineCtx, str);
    }

    public boolean setSingRefLyricTimeRange(TimeRange[] timeRangeArr, int i) {
        return nativeSetSingRefLyricTimeRange(this.engineCtx, timeRangeArr, i);
    }

    public boolean setSingRefLyricFile(String str) {
        return nativeSetSingRefLyricFile(this.engineCtx, str);
    }

    public boolean setSingRefMfccFile(String str) {
        return nativeSetSingRefMfccFile(this.engineCtx, str);
    }

    public boolean oneKeySingingAutoTuneProcess(int i, String str, String str2) {
        return nativeOneKeySingingAutoTuneProcess(this.engineCtx, i, str, str2);
    }

    public boolean setPlaybackModeOn(boolean z) {
        return nativeSetPlaybackModeOn(this.engineCtx, z);
    }

    public boolean setRemoteStreamVolume(long j, int i) {
        return nativeSetRemoteStreamVolume(this.engineCtx, j, i);
    }

    public boolean setRemoteVoicePosition(long j, int i, int i2) {
        return nativeSetRemoteVoicePosition(this.engineCtx, j, i, i2);
    }

    public void enableSoundPositionIndication(boolean z) {
        nativeEnableSoundPositionIndication(this.engineCtx, z);
    }

    public boolean startInputDeviceTest() {
        return nativeStartInputDeviceTest(this.engineCtx);
    }

    public boolean stopInputDeviceTest() {
        return nativeStopInputDeviceTest(this.engineCtx);
    }

    public boolean startOutputDeviceTest(String str) {
        return nativeStartOutputDeviceTest(this.engineCtx, str);
    }

    public boolean stopOutputDeviceTest() {
        return nativeStopOutputDeviceTest(this.engineCtx);
    }

    public void setAudioSourceType(Constant.AudioSourceType audioSourceType) {
        nativeSetAudioSourceType(this.engineCtx, audioSourceType.ordinal());
    }

    public void enableDebugLoopDelay(boolean z) {
        nativeEnableDebugLoopDelay(this.engineCtx, z);
    }

    public void setLocalVoicePitch(float f) {
        nativeSetLocalVoicePitch(this.engineCtx, f);
    }

    private void onEncodedAudioDataEvent(byte[] bArr, long j, int i, int i2) {
        if (this.mCaptureNotify != null) {
            this.mCaptureNotify.onEncodedAudioData(bArr, j, i, i2);
        }
    }

    private void onCaptureAudioVolumeEvent(int i) {
        if (this.mCaptureNotify != null) {
            this.mCaptureNotify.onCaptureAudioVolume(i);
        }
    }

    private IAudioRenderInfo onRenderAudioDataEvent(int i, int i2, int i3) {
        if (this.mRenderNotify != null) {
            return this.mRenderNotify.onRenderAudioData(i, i2, i3);
        }
        return null;
    }

    private IAudioPullFrameInfo onPullAudioFrameEvent(long j, boolean z, boolean z2, boolean z3, boolean z4, double d, double d2, double d3) {
        if (this.mPullFrameNotify != null) {
            return this.mPullFrameNotify.onPullAudioFrame(j, z, z2, z3, z4, d, d2, d3);
        }
        return null;
    }

    private void onAudioCaptureErrorEvent(int i) {
        if (this.mAudioEngineNotify != null) {
            this.mAudioEngineNotify.onAudioCaptureError(Constant.AudioDeviceErrorType.values()[i]);
        }
    }

    private void onAudioRenderErrorEvent(int i) {
        if (this.mAudioEngineNotify != null) {
            this.mAudioEngineNotify.onAudioRenderError(Constant.AudioDeviceErrorType.values()[i]);
        }
    }

    private void onReceivePhoneCallEvent(boolean z) {
        if (this.mAudioEngineNotify != null) {
            this.mAudioEngineNotify.onReceivePhoneCall(z);
        }
    }

    private void onAudioModeChangeEvent() {
        if (this.mAudioEngineNotify != null) {
            this.mAudioEngineNotify.onAudioModeChange();
        }
    }

    private void onHeadsetPlugEvent(boolean z) {
        if (this.mAudioEngineNotify != null) {
            this.mAudioEngineNotify.onHeadsetPlug(z);
        }
    }

    private void onCalcKaraokeScore(byte b2, long j) {
        if (this.mKaraokeScoreNotify != null) {
            this.mKaraokeScoreNotify.onCalcKaraokeScore(b2, j);
        }
    }

    private void onSingerPitchVisual(byte b2, long j, long j2, long j3) {
        if (this.mKaraokeScoreNotify != null) {
            this.mKaraokeScoreNotify.onSingerPitchVisual(b2, j, j2, j3);
        }
    }
}

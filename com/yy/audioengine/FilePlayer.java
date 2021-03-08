package com.yy.audioengine;

import com.yy.audioengine.Constant;
/* loaded from: classes6.dex */
public class FilePlayer {
    private IFilePlayerNotify mNotify = null;
    private long mPlayerCtx;

    /* loaded from: classes6.dex */
    public enum FilePlayerMixerType {
        LocalPlay,
        OverrideMic,
        MixWithMic
    }

    private native long nativeCreateFilePlayer(Object obj);

    private native long nativeDestroy(long j);

    private native void nativeEnableCompressor(long j, boolean z);

    private native void nativeEnableDenoiser(long j, boolean z);

    private native void nativeEnableDrc(long j, boolean z);

    private native void nativeEnableEffect(long j, boolean z);

    private native void nativeEnableEqualizerEx(long j, boolean z);

    private native void nativeEnableEtb(long j, boolean z);

    private native void nativeEnableLimiter(long j, boolean z);

    private native void nativeEnableLoopPlay(long j, boolean z);

    private native void nativeEnableMute(long j, boolean z);

    private native void nativeEnableReverbEx(long j, boolean z);

    private native void nativeEnableReverbFv3(long j, boolean z);

    private native void nativeEnableVolumeNotify(long j, boolean z);

    private native void nativeFakePause(long j);

    private native int nativeGetAudioTrackCount(long j);

    private native long nativeGetCurrentPlayTimeMS(long j);

    private native long nativeGetTotalPlayLengthMS(long j);

    private native boolean nativeOpen(long j, String str);

    private native void nativePause(long j);

    private native void nativePlay(long j);

    private native void nativeResume(long j);

    private native void nativeSeek(long j, long j2);

    private native void nativeSeekSaver(long j, long j2);

    private native boolean nativeSelectAudioTrack(long j, int i);

    private native void nativeSetCompressorParam(long j, int[] iArr);

    private native void nativeSetDenoiseType(long j, int i);

    private native void nativeSetEqualizerParameter(long j, float[] fArr);

    private native void nativeSetFeedBackToMicMode(long j, long j2);

    private native void nativeSetLimiterParam(long j, float[] fArr);

    private native void nativeSetPlayerVolume(long j, long j2);

    private native void nativeSetReverbParameter(long j, float[] fArr);

    private native void nativeSetToneSelValue(long j, int i);

    private native void nativeSetTrebleBassVal(long j, int i);

    private native boolean nativeStartSaver(long j, String str);

    private native void nativeStop(long j);

    private native boolean nativeStopSaver(long j);

    public FilePlayer() {
        this.mPlayerCtx = 0L;
        this.mPlayerCtx = nativeCreateFilePlayer(this);
    }

    public void registerNotify(IFilePlayerNotify iFilePlayerNotify) {
        this.mNotify = iFilePlayerNotify;
    }

    public boolean open(String str) {
        return nativeOpen(this.mPlayerCtx, str);
    }

    public void destroy() {
        this.mPlayerCtx = nativeDestroy(this.mPlayerCtx);
    }

    public void play() {
        nativePlay(this.mPlayerCtx);
    }

    public void stop() {
        nativeStop(this.mPlayerCtx);
    }

    public void pause() {
        nativePause(this.mPlayerCtx);
    }

    public void fakePause() {
        nativeFakePause(this.mPlayerCtx);
    }

    public void resume() {
        nativeResume(this.mPlayerCtx);
    }

    public void enableLoopPlay(boolean z) {
        nativeEnableLoopPlay(this.mPlayerCtx, z);
    }

    public void seek(long j) {
        nativeSeek(this.mPlayerCtx, j);
    }

    public void seekSaver(long j) {
        nativeSeekSaver(this.mPlayerCtx, j);
    }

    public void setPlayerVolume(long j) {
        nativeSetPlayerVolume(this.mPlayerCtx, j);
    }

    public void enableVolumeNotify(boolean z) {
        nativeEnableVolumeNotify(this.mPlayerCtx, z);
    }

    public void setFeedBackToMicMode(FilePlayerMixerType filePlayerMixerType) {
        nativeSetFeedBackToMicMode(this.mPlayerCtx, filePlayerMixerType.ordinal());
    }

    public void enableEffect(boolean z) {
        nativeEnableEffect(this.mPlayerCtx, z);
    }

    public void enableReverbEx(boolean z) {
        nativeEnableReverbEx(this.mPlayerCtx, z);
    }

    public void enableReverbFv3(boolean z) {
        nativeEnableReverbFv3(this.mPlayerCtx, z);
    }

    public void enableEqualizerEx(boolean z) {
        nativeEnableEqualizerEx(this.mPlayerCtx, z);
    }

    public void enableCompressor(boolean z) {
        nativeEnableCompressor(this.mPlayerCtx, z);
    }

    public void enableLimiter(boolean z) {
        nativeEnableLimiter(this.mPlayerCtx, z);
    }

    public void setReverbParameter(float[] fArr) {
        nativeSetReverbParameter(this.mPlayerCtx, fArr);
    }

    public void setEqualizerParameter(float[] fArr) {
        nativeSetEqualizerParameter(this.mPlayerCtx, fArr);
    }

    public void setCompressorParameter(int[] iArr) {
        nativeSetCompressorParam(this.mPlayerCtx, iArr);
    }

    public void setLimiterParam(float[] fArr) {
        nativeSetLimiterParam(this.mPlayerCtx, fArr);
    }

    public void setToneSelValue(int i) {
        nativeSetToneSelValue(this.mPlayerCtx, i);
    }

    public void setTrebleBassVal(int i) {
        nativeSetTrebleBassVal(this.mPlayerCtx, i);
    }

    public long getFileTimeMs() {
        return nativeGetTotalPlayLengthMS(this.mPlayerCtx);
    }

    public long getCurrentPlayTimeMS() {
        return nativeGetCurrentPlayTimeMS(this.mPlayerCtx);
    }

    public long getTotalPlayLengthMS() {
        return nativeGetTotalPlayLengthMS(this.mPlayerCtx);
    }

    public boolean startSaver(String str) {
        return nativeStartSaver(this.mPlayerCtx, str);
    }

    public boolean stopSaver() {
        return nativeStopSaver(this.mPlayerCtx);
    }

    public void enableMute(boolean z) {
        nativeEnableMute(this.mPlayerCtx, z);
    }

    public void enableEtb(boolean z) {
        nativeEnableEtb(this.mPlayerCtx, z);
    }

    public void enableDrc(boolean z) {
        nativeEnableDrc(this.mPlayerCtx, z);
    }

    public void enableDenoiser(boolean z) {
        nativeEnableDenoiser(this.mPlayerCtx, z);
    }

    public void setDenoiseType(Constant.DenoiseModuleType denoiseModuleType) {
        nativeSetDenoiseType(this.mPlayerCtx, denoiseModuleType.ordinal());
    }

    public boolean selectAudioTrack(int i) {
        return nativeSelectAudioTrack(this.mPlayerCtx, i);
    }

    public int getAudioTrackCount() {
        return nativeGetAudioTrackCount(this.mPlayerCtx);
    }

    private void onPlayerEndEvent() {
        if (this.mNotify != null) {
            this.mNotify.onPlayerEnd();
        }
    }

    private void onPlayerVolumeEvent(int i, long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.onPlayerVolume(i, j, j2);
        }
    }
}

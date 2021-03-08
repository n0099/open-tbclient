package com.yy.audioengine;

import com.yy.audioengine.Constant;
/* loaded from: classes6.dex */
public class AudioFileMixerPoint {
    public long mAudioFileMixerPointCtx;

    private native void nativeClose(long j);

    private native void nativeEnableCompressor(long j, boolean z);

    private native void nativeEnableDenoiser(long j, boolean z);

    private native void nativeEnableDrc(long j, boolean z);

    private native void nativeEnableEqualizerEx(long j, boolean z);

    private native void nativeEnableEtb(long j, boolean z);

    private native void nativeEnableLimiter(long j, boolean z);

    private native void nativeEnableReverbFv3(long j, boolean z);

    private native boolean nativeOpen(long j, String str);

    private native void nativeSetCompressorParam(long j, int[] iArr);

    private native void nativeSetDenoiseType(long j, int i);

    private native void nativeSetEqualizerParameter(long j, float[] fArr);

    private native void nativeSetLimiterParam(long j, float[] fArr);

    private native void nativeSetOffsetTime(long j, int i);

    private native void nativeSetReverbFv3Param(long j, float[] fArr);

    private native void nativeSetSemitone(long j, int i);

    private native void nativeSetTrebleBassVal(long j, int i);

    private native void nativeSetVolume(long j, int i);

    public AudioFileMixerPoint(long j) {
        this.mAudioFileMixerPointCtx = j;
    }

    public boolean open(String str) {
        return nativeOpen(this.mAudioFileMixerPointCtx, str);
    }

    public void close() {
        nativeClose(this.mAudioFileMixerPointCtx);
        this.mAudioFileMixerPointCtx = 0L;
    }

    public void enableReverbFv3(boolean z) {
        nativeEnableReverbFv3(this.mAudioFileMixerPointCtx, z);
    }

    public void enableEqualizerEx(boolean z) {
        nativeEnableEqualizerEx(this.mAudioFileMixerPointCtx, z);
    }

    public void enableCompressor(boolean z) {
        nativeEnableCompressor(this.mAudioFileMixerPointCtx, z);
    }

    public void enableLimiter(boolean z) {
        nativeEnableLimiter(this.mAudioFileMixerPointCtx, z);
    }

    public void setReverbFv3Param(float[] fArr) {
        nativeSetReverbFv3Param(this.mAudioFileMixerPointCtx, fArr);
    }

    public void setEqualizerParameter(float[] fArr) {
        nativeSetEqualizerParameter(this.mAudioFileMixerPointCtx, fArr);
    }

    public void setCompressorParameter(int[] iArr) {
        nativeSetCompressorParam(this.mAudioFileMixerPointCtx, iArr);
    }

    public void setLimiterParam(float[] fArr) {
        nativeSetLimiterParam(this.mAudioFileMixerPointCtx, fArr);
    }

    public void setVolume(int i) {
        nativeSetVolume(this.mAudioFileMixerPointCtx, i);
    }

    public void setOffsetTime(int i) {
        nativeSetOffsetTime(this.mAudioFileMixerPointCtx, i);
    }

    public void setTrebleBassVal(int i) {
        nativeSetTrebleBassVal(this.mAudioFileMixerPointCtx, i);
    }

    public void setSemitone(int i) {
        nativeSetSemitone(this.mAudioFileMixerPointCtx, i);
    }

    public void setDenoiseType(Constant.DenoiseModuleType denoiseModuleType) {
        nativeSetDenoiseType(this.mAudioFileMixerPointCtx, denoiseModuleType.ordinal());
    }

    public void enableEtb(boolean z) {
        nativeEnableEtb(this.mAudioFileMixerPointCtx, z);
    }

    public void enableDrc(boolean z) {
        nativeEnableDrc(this.mAudioFileMixerPointCtx, z);
    }

    public void enableDenoiser(boolean z) {
        nativeEnableDenoiser(this.mAudioFileMixerPointCtx, z);
    }
}

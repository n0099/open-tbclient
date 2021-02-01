package com.yy.audioengine;

import java.util.Arrays;
/* loaded from: classes4.dex */
public class KaraokeFileMixer {
    private static String TAG = "[KaraokeFileMixer]";
    private long mCtx;
    private IKaraokeFileMixerNotity mNotify;

    private native long nativeCreateKaraokeFileMixer(Object obj);

    private native void nativeDestroyKaraokeFileMixer(long j);

    private native void nativeEnableCompressor(long j, boolean z);

    private native void nativeEnableDenoise(long j, boolean z);

    private native void nativeEnableEqualizer(long j, boolean z);

    private native void nativeEnableLimiter(long j, boolean z);

    private native void nativeEnableReverbNew(long j, boolean z);

    private native boolean nativeOpen(long j, String str, String str2);

    private native void nativeSetAccompanyVolume(long j, int i);

    private native void nativeSetCompressorParam(long j, int[] iArr);

    private native void nativeSetEqGains(long j, float[] fArr);

    private native void nativeSetEtbValue(long j, int i);

    private native void nativeSetLimiterParam(long j, float[] fArr);

    private native void nativeSetReverbNewParam(long j, float[] fArr);

    private native void nativeSetTone(long j, int i);

    private native void nativeSetVoiceOffset(long j, int i);

    private native void nativeSetVoiceVolume(long j, int i);

    private native boolean nativeStart(long j, String str);

    private native void nativeStop(long j);

    public void init() {
        YALog.info(TAG + "Init....");
        this.mCtx = nativeCreateKaraokeFileMixer(this);
    }

    public void destroy() {
        YALog.info(TAG + "Destroy....");
        nativeDestroyKaraokeFileMixer(this.mCtx);
        this.mNotify = null;
    }

    public void setKaraokeFileMixerNotify(IKaraokeFileMixerNotity iKaraokeFileMixerNotity) {
        YALog.info(TAG + "SetKaraokeFileMixerNotify, notify: " + iKaraokeFileMixerNotity);
        this.mNotify = iKaraokeFileMixerNotity;
    }

    public boolean open(String str, String str2) {
        YALog.info(TAG + "Open, voiceFile: " + str + " ,accompanyFile: " + str2);
        return nativeOpen(this.mCtx, str, str2);
    }

    public boolean start(String str) {
        YALog.info(TAG + "Start, fileName: " + str);
        return nativeStart(this.mCtx, str);
    }

    public void stop() {
        YALog.info(TAG + "Stop....");
        nativeStop(this.mCtx);
    }

    public void setVoiceOffset(int i) {
        YALog.info(TAG + "SetVoiceOffset, offsetTime: " + i);
        nativeSetVoiceOffset(this.mCtx, i);
    }

    public void setEtbValue(int i) {
        YALog.info(TAG + "SetEtbValue, value: " + i);
        nativeSetEtbValue(this.mCtx, i);
    }

    public void enableDenoise(boolean z) {
        YALog.info(TAG + "EnableDenoise, enable: " + z);
        nativeEnableDenoise(this.mCtx, z);
    }

    public void setVoiceVolume(int i) {
        YALog.info(TAG + "SetVoiceVolume, volume: " + i);
        nativeSetVoiceVolume(this.mCtx, i);
    }

    public void setAccompanyVolume(int i) {
        YALog.info(TAG + "SetAccompanyVolume, volume: " + i);
        nativeSetAccompanyVolume(this.mCtx, i);
    }

    public void setTone(int i) {
        YALog.info(TAG + "SetTone, value: " + i);
        nativeSetTone(this.mCtx, i);
    }

    public void enableReverbNew(boolean z) {
        YALog.info(TAG + "EnableReverbNew, enable: " + z);
        nativeEnableReverbNew(this.mCtx, z);
    }

    public void setReverbNewParam(float[] fArr) {
        YALog.info(TAG + "SetReverbNewParam,array: " + Arrays.toString(fArr));
        nativeSetReverbNewParam(this.mCtx, fArr);
    }

    public void enableEqualizer(boolean z) {
        YALog.info(TAG + "EnableEqualizer, enable: " + z);
        nativeEnableEqualizer(this.mCtx, z);
    }

    public void setEqGains(float[] fArr) {
        YALog.info(TAG + "SetEqGains,array: " + Arrays.toString(fArr));
        nativeSetEqGains(this.mCtx, fArr);
    }

    public void enableCompressor(boolean z) {
        YALog.info(TAG + "EnableCompressor, enable: " + z);
        nativeEnableCompressor(this.mCtx, z);
    }

    public void setCompressorParam(int[] iArr) {
        YALog.info(TAG + "SetCompressorParam,array: " + Arrays.toString(iArr));
        nativeSetCompressorParam(this.mCtx, iArr);
    }

    public void enableLimiter(boolean z) {
        YALog.info(TAG + "EnableLimiter. enable: " + z);
        nativeEnableLimiter(this.mCtx, z);
    }

    public void setLimiterParam(float[] fArr) {
        YALog.info(TAG + "SetLimiterParam,array: " + Arrays.toString(fArr));
        nativeSetLimiterParam(this.mCtx, fArr);
    }

    private void onFileMixerState(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.onFileMixerState(j, j2);
        }
    }

    private void onFinishMixer() {
        YALog.info(TAG + "OnFinishMixer...");
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.KaraokeFileMixer.1
            @Override // java.lang.Runnable
            public void run() {
                if (KaraokeFileMixer.this.mNotify != null) {
                    KaraokeFileMixer.this.mNotify.onFinishMixer();
                }
            }
        });
    }
}

package com.yy.audioengine;
/* loaded from: classes4.dex */
public class Karaoke {
    private static String TAG = "[Karaoke]";
    private long mCtx;
    private IKaraokeNotify mNotify;

    private native long nativeCreateKaraoke(Object obj);

    private native void nativeDestroyKaraoke(long j);

    private native void nativeEnableCompressor(long j, boolean z);

    private native void nativeEnableEqualizer(long j, boolean z);

    private native void nativeEnableLimiter(long j, boolean z);

    private native boolean nativeEnablePlayBack(long j, boolean z);

    private native void nativeEnableReverbNew(long j, boolean z);

    private native long nativeGetCurrentPlayerTime(long j);

    private native long nativeGetPlayerTime(long j);

    private native boolean nativeIsRecordPlayBackEnable(long j);

    private native boolean nativeOpenAccompanyFile(long j, String str);

    private native boolean nativeOpenInputFile(long j, String str, String str2);

    private native boolean nativeOpenMixFile(long j, String str);

    private native boolean nativeOpenOutputFile(long j, String str, String str2);

    private native void nativePause(long j);

    private native void nativeResume(long j);

    private native boolean nativeSeek(long j, long j2);

    private native boolean nativeSeekToEnd(long j, long j2);

    private native void nativeSetAccompanyVolume(long j, int i);

    private native boolean nativeSetChooseMixFilePlay(long j, boolean z);

    private native void nativeSetCompressorParam(long j, int[] iArr);

    private native void nativeSetDisplayTolerate(long j, float f, float f2);

    private native void nativeSetEqGains(long j, float[] fArr);

    private native void nativeSetLimiterParam(long j, float[] fArr);

    private native void nativeSetLineInfo(long j, LineInfo[] lineInfoArr, long j2);

    private native boolean nativeSetLyricPauseTime(long j, long j2);

    private native void nativeSetReverbNewParam(long j, float[] fArr);

    private native byte[] nativeSetScoreTimeRange(long j, TimeRange[] timeRangeArr, long j2);

    private native void nativeSetTone(long j, int i);

    private native void nativeSetVoiceVolume(long j, int i);

    private native void nativeStart(long j);

    private native void nativeStop(long j);

    public void init() {
        YALog.info(TAG + "Init...isEnableLowLatencyPlayBack: " + AudioConfig.isEnableLowLatencyPlayBack());
        if (AudioConfig.isEnableLowLatencyPlayBack()) {
            IAudioLibJniInit.enableAndroidOpenSlEs(true);
        }
        this.mCtx = nativeCreateKaraoke(this);
    }

    public void destroy() {
        YALog.info(TAG + "Destroy....");
        nativeDestroyKaraoke(this.mCtx);
        this.mCtx = 0L;
        if (AudioConfig.isEnableLowLatencyPlayBack()) {
            IAudioLibJniInit.enableAndroidOpenSlEs(false);
        }
        this.mNotify = null;
    }

    public void setKaraokeListener(IKaraokeNotify iKaraokeNotify) {
        YALog.info(TAG + "SetKaraokeListener, notify: " + iKaraokeNotify);
        this.mNotify = iKaraokeNotify;
    }

    public boolean openInputFile(String str, String str2) {
        YALog.info(TAG + "OpenInputFile, mixerFile: " + str + " ,accompanyFile: " + str2);
        return nativeOpenInputFile(this.mCtx, str, str2);
    }

    public boolean openOutputFile(String str, String str2) {
        YALog.info(TAG + "OpenOutputFile, voiceRecordFile: " + str + " ,accompanyRecordFile: " + str2);
        return nativeOpenOutputFile(this.mCtx, str, str2);
    }

    public boolean openMixFile(String str) {
        YALog.info(TAG + "OpenMixFile, mixFile: " + str);
        return nativeOpenMixFile(this.mCtx, str);
    }

    public boolean openAccompanyFile(String str) {
        YALog.info(TAG + "OpenAccompanyFile, accompanyFile: " + str);
        return nativeOpenAccompanyFile(this.mCtx, str);
    }

    public void start() {
        YALog.info(TAG + "Start....");
        nativeStart(this.mCtx);
    }

    public void pause() {
        YALog.info(TAG + "Pause....");
        nativePause(this.mCtx);
    }

    public void resume() {
        YALog.info(TAG + "Resume....");
        nativeResume(this.mCtx);
    }

    public void stop() {
        YALog.info(TAG + "Stop....");
        nativeStop(this.mCtx);
    }

    public boolean seek(long j) {
        YALog.info(TAG + "Seek, seekTime: " + j);
        return nativeSeek(this.mCtx, j);
    }

    public boolean seekToEnd(long j) {
        YALog.info(TAG + "SeekToEnd, seekTime: " + j);
        return nativeSeekToEnd(this.mCtx, j);
    }

    public boolean setLyricPauseTime(long j) {
        YALog.info(TAG + "SetPause, pauseTime: " + j);
        return nativeSetLyricPauseTime(this.mCtx, j);
    }

    public byte[] setScoreTimeRange(TimeRange[] timeRangeArr, int i) {
        return nativeSetScoreTimeRange(this.mCtx, timeRangeArr, i);
    }

    public void setLineInfo(LineInfo[] lineInfoArr, int i) {
        nativeSetLineInfo(this.mCtx, lineInfoArr, i);
    }

    public long getPlayerTime() {
        return nativeGetPlayerTime(this.mCtx);
    }

    public long getCurrentPlayerTime() {
        return nativeGetCurrentPlayerTime(this.mCtx);
    }

    public void setVoiceVolume(int i) {
        YALog.info(TAG + "SetVoiceVolume: " + i);
        nativeSetVoiceVolume(this.mCtx, i);
    }

    public void setAccompanyVolume(int i) {
        YALog.info(TAG + "SetAccompanyVolume: " + i);
        nativeSetAccompanyVolume(this.mCtx, i);
    }

    public void setTone(int i) {
        YALog.info(TAG + "SetTone: " + i);
        nativeSetTone(this.mCtx, i);
    }

    public void setDisplayTolerate(float f, float f2) {
        YALog.info(TAG + "SetDisplayTolerate, lowValue" + f + " ,highValue: " + f2);
        nativeSetDisplayTolerate(this.mCtx, f, f2);
    }

    public boolean setChooseMixFilePlay(boolean z) {
        YALog.info(TAG + "SetChooseMixFilePlay: " + z);
        return nativeSetChooseMixFilePlay(this.mCtx, z);
    }

    public boolean enablePlayBack(boolean z) {
        YALog.info(TAG + "EnablePlayBack: " + z);
        return nativeEnablePlayBack(this.mCtx, z);
    }

    public boolean isRecordPlayBackEnable() {
        return nativeIsRecordPlayBackEnable(this.mCtx);
    }

    public void enableReverbNew(boolean z) {
        nativeEnableReverbNew(this.mCtx, z);
    }

    public void setReverbNewParam(float[] fArr) {
        nativeSetReverbNewParam(this.mCtx, fArr);
    }

    public void enableEqualizer(boolean z) {
        nativeEnableEqualizer(this.mCtx, z);
    }

    public void setEqGains(float[] fArr) {
        nativeSetEqGains(this.mCtx, fArr);
    }

    public void enableCompressor(boolean z) {
        nativeEnableCompressor(this.mCtx, z);
    }

    public void setCompressorParam(int[] iArr) {
        nativeSetCompressorParam(this.mCtx, iArr);
    }

    public void enableLimiter(boolean z) {
        nativeEnableLimiter(this.mCtx, z);
    }

    public void setLimiterParam(float[] fArr) {
        nativeSetLimiterParam(this.mCtx, fArr);
    }

    private void onPlayerEnd() {
        if (this.mNotify != null) {
            this.mNotify.onKaraokePlayEnd();
        }
    }

    private void onPlayerVolume(final long j, final long j2, final long j3) {
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.Karaoke.1
            @Override // java.lang.Runnable
            public void run() {
                if (Karaoke.this.mNotify != null) {
                    Karaoke.this.mNotify.onKaraokeCurrentPlayVolume(j, j2, j3);
                }
            }
        });
    }

    private void onAudioVolumeVisual(final long j, final long j2) {
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.Karaoke.2
            @Override // java.lang.Runnable
            public void run() {
                if (Karaoke.this.mNotify != null) {
                    Karaoke.this.mNotify.onKaraokeCurrentRecordVolume(j, j2);
                }
            }
        });
    }

    private void onAudioRecordError() {
        YALog.error(TAG + "onAudioRecordError...");
        if (this.mNotify != null) {
            this.mNotify.onKaraokeInitError();
        }
    }

    private void onCalcKaraokeScore(byte b2, long j) {
        if (this.mNotify != null) {
            this.mNotify.onKaraokeScore(b2, j);
        }
    }

    private void onSingerPitchVisual(byte b2, long j, long j2, long j3) {
        if (this.mNotify != null) {
            this.mNotify.onKaraokePitch(b2, j, j2, j3);
        }
    }

    private void onFirstPlayData() {
        YALog.info(TAG + "onFirstPlayData...");
        if (this.mNotify != null) {
            this.mNotify.onKaraokeFirstPlayData();
        }
    }
}

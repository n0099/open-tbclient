package com.yy.audioengine;

import android.os.Build;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class KaraokePlayBack {
    private static String TAG = "[KaraokePlayBack]";
    private long mCtx;
    private IKaraokePlaybackNotify mNotify;

    private native boolean nativeChooseAutoToneFilePlayer(long j, boolean z);

    private native long nativeCreateKaraokePlayBack(Object obj);

    private native void nativeDestroyKaraokePlayBack(long j);

    private native void nativeEnableCompressor(long j, boolean z);

    private native void nativeEnableDenoise(long j, boolean z);

    private native void nativeEnableDrc(long j, boolean z);

    private native void nativeEnableEqualizer(long j, boolean z);

    private native void nativeEnableLimiter(long j, boolean z);

    private native void nativeEnableReverbNew(long j, boolean z);

    private native long nativeGetCurrentPlayerTime(long j);

    private native long nativeGetTotalPlayBackTime(long j);

    private native boolean nativeIsAutoToneFilePlaying(long j);

    private native boolean nativeOpen(long j, String str, String str2);

    private native boolean nativeOpenAutoToneFilePlayer(long j, String str);

    private native void nativePause(long j);

    private native void nativePlay(long j);

    private native void nativeResume(long j);

    private native boolean nativeSeek(long j, long j2);

    private native void nativeSetAccompanyVolume(long j, int i);

    private native void nativeSetCompressorParam(long j, int[] iArr);

    private native void nativeSetEqGains(long j, float[] fArr);

    private native void nativeSetEtbValue(long j, int i);

    private native void nativeSetLimiterParam(long j, float[] fArr);

    private native void nativeSetReverbNewParam(long j, float[] fArr);

    private native void nativeSetTone(long j, int i);

    private native void nativeSetVoiceOffset(long j, int i);

    private native void nativeSetVoiceVolume(long j, int i);

    private native void nativeStop(long j);

    private native boolean nativeStopAutoToneFilePlayer(long j);

    public void init() {
        YALog.info(TAG + "Init...IsEnableLowLatencyPlayBack: " + AudioConfig.isEnableLowLatencyPlayBack());
        if (AudioConfig.isEnableLowLatencyPlayBack()) {
            IAudioLibJniInit.enableAndroidOpenSlEs(true);
        }
        if (Build.MODEL.equalsIgnoreCase("A1601")) {
            YALog.info(TAG + "Init, oppo A1601 enable openslesout....");
            IAudioLibJniInit.enableAndroidOpenSlEs(true);
        }
        this.mCtx = nativeCreateKaraokePlayBack(this);
    }

    public void destroy() {
        YALog.info(TAG + "Destroy.....");
        nativeDestroyKaraokePlayBack(this.mCtx);
        this.mCtx = 0L;
        this.mNotify = null;
        if (AudioConfig.isEnableLowLatencyPlayBack()) {
            IAudioLibJniInit.enableAndroidOpenSlEs(false);
        }
        if (Build.MODEL.equalsIgnoreCase("A1601")) {
            YALog.info(TAG + "Destroy, oppo A1601 disable openslesout....");
            IAudioLibJniInit.enableAndroidOpenSlEs(false);
        }
    }

    public boolean open(String str, String str2) {
        YALog.info(TAG + "Open, voiceFile: " + str + " ,accompanyFile: " + str2);
        return nativeOpen(this.mCtx, str, str2);
    }

    public void play() {
        YALog.info(TAG + "Play.....");
        nativePlay(this.mCtx);
    }

    public void stop() {
        YALog.info(TAG + "Stop.....");
        nativeStop(this.mCtx);
    }

    public void pause() {
        YALog.info(TAG + "Pause.....");
        nativePause(this.mCtx);
    }

    public void resume() {
        YALog.info(TAG + "Resume.....");
        nativeResume(this.mCtx);
    }

    public void seek(long j) {
        YALog.info(TAG + "Seek, seekTime: " + j);
        nativeSeek(this.mCtx, j);
    }

    public void setKaraokePlaybackNotify(IKaraokePlaybackNotify iKaraokePlaybackNotify) {
        YALog.info(TAG + "setKaraokePlaybackNotify: " + iKaraokePlaybackNotify);
        this.mNotify = iKaraokePlaybackNotify;
    }

    public void enableReverbNew(boolean z) {
        YALog.info(TAG + "EnableReverbNew. enable: " + z);
        nativeEnableReverbNew(this.mCtx, z);
    }

    public void setReverbNewParam(float[] fArr) {
        YALog.info(TAG + "SetReverbNewParam,array: " + Arrays.toString(fArr));
        nativeSetReverbNewParam(this.mCtx, fArr);
    }

    public void enableEqualizer(boolean z) {
        YALog.info(TAG + "EnableEqualizer. enable: " + z);
        nativeEnableEqualizer(this.mCtx, z);
    }

    public void setEqGains(float[] fArr) {
        YALog.info(TAG + "SetEqGains,array: " + Arrays.toString(fArr));
        nativeSetEqGains(this.mCtx, fArr);
    }

    public void enableCompressor(boolean z) {
        YALog.info(TAG + "EnableCompressor. enable: " + z);
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

    public void setVoiceOffset(int i) {
        YALog.info(TAG + "SetVoiceOffset: " + i);
        nativeSetVoiceOffset(this.mCtx, i);
    }

    public void setTone(int i) {
        YALog.info(TAG + "SetTone: " + i);
        nativeSetTone(this.mCtx, i);
    }

    public void setEtbValue(int i) {
        YALog.info(TAG + "SetEtbValue: " + i);
        nativeSetEtbValue(this.mCtx, i);
    }

    public void enableDenoise(boolean z) {
        YALog.info(TAG + "EnableDenoise: " + z);
        nativeEnableDenoise(this.mCtx, z);
    }

    public void enableDrc(boolean z) {
        YALog.info(TAG + "EnableDrc: " + z);
        nativeEnableDrc(this.mCtx, z);
    }

    public void setVoiceVolume(int i) {
        YALog.info(TAG + "SetVoiceVolume: " + i);
        nativeSetVoiceVolume(this.mCtx, i);
    }

    public void setAccompanyVolume(int i) {
        YALog.info(TAG + "SetAccompanyVolume: " + i);
        nativeSetAccompanyVolume(this.mCtx, i);
    }

    public long getTotalPlayBackTimeMs() {
        return nativeGetTotalPlayBackTime(this.mCtx);
    }

    public long getCurrentPlayBackTimeMs() {
        return nativeGetCurrentPlayerTime(this.mCtx);
    }

    public void enableLoopPlay(boolean z) {
    }

    public boolean openAutoToneFilePlayer(String str) {
        boolean nativeOpenAutoToneFilePlayer = nativeOpenAutoToneFilePlayer(this.mCtx, str);
        YALog.info(TAG + "OpenAutoToneFilePlayer: " + str + " ,res: " + nativeOpenAutoToneFilePlayer);
        return nativeOpenAutoToneFilePlayer;
    }

    public boolean stopAutoToneFilePlayer() {
        YALog.info(TAG + "StopAutoToneFilePlayer...");
        return nativeStopAutoToneFilePlayer(this.mCtx);
    }

    public void chooseAutoToneFilePlayer(boolean z) {
        YALog.info(TAG + "ChooseAutoToneFilePlayer, isAutoTonePlay: " + z);
        nativeChooseAutoToneFilePlayer(this.mCtx, z);
    }

    public boolean isAutoToneFilePlaying() {
        return nativeIsAutoToneFilePlaying(this.mCtx);
    }

    private void onPlayerEnd() {
        YALog.info(TAG + "OnPlayerEnd...");
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.KaraokePlayBack.1
            @Override // java.lang.Runnable
            public void run() {
                if (KaraokePlayBack.this.mNotify != null) {
                    KaraokePlayBack.this.mNotify.onKaraokePlayBackEnd();
                }
            }
        });
    }

    private void onPlayerVolume(long j, final long j2, final long j3) {
        MainHandler.getInstance().post(new Runnable() { // from class: com.yy.audioengine.KaraokePlayBack.2
            @Override // java.lang.Runnable
            public void run() {
                if (KaraokePlayBack.this.mNotify != null) {
                    KaraokePlayBack.this.mNotify.onKaraokePlayBackTimeInfo(j2, j3);
                }
            }
        });
    }
}

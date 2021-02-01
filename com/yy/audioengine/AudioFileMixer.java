package com.yy.audioengine;
/* loaded from: classes4.dex */
public class AudioFileMixer {
    private long mAudioFileMixerCtx;
    private IFileMixerNotify mNotify = null;

    private native long nativeCreateAudioFileMixer(Object obj);

    private native long nativeCreateMixerPoint(long j);

    private native long nativeDestroy(long j);

    private native void nativeSetMusicPoint(long j, long j2);

    private native void nativeSetVoicePoint(long j, long j2);

    private native boolean nativeStart(long j, String str);

    private native void nativeStop(long j);

    public AudioFileMixer() {
        this.mAudioFileMixerCtx = 0L;
        this.mAudioFileMixerCtx = nativeCreateAudioFileMixer(this);
    }

    public void destroy() {
        this.mAudioFileMixerCtx = nativeDestroy(this.mAudioFileMixerCtx);
    }

    public boolean start(String str) {
        return nativeStart(this.mAudioFileMixerCtx, str);
    }

    public void stop() {
        nativeStop(this.mAudioFileMixerCtx);
    }

    public void setVoicePoint(long j) {
        nativeSetVoicePoint(this.mAudioFileMixerCtx, j);
    }

    public void setMusicPoint(long j) {
        nativeSetMusicPoint(this.mAudioFileMixerCtx, j);
    }

    public AudioFileMixerPoint createMixerPoint() {
        return new AudioFileMixerPoint(nativeCreateMixerPoint(this.mAudioFileMixerCtx));
    }

    public void registerNotify(IFileMixerNotify iFileMixerNotify) {
        this.mNotify = iFileMixerNotify;
    }

    public void onFinishMixerEvent() {
        if (this.mNotify != null) {
            this.mNotify.onFinishMixer();
        }
    }

    public void onFileMixerStateEvent(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.onFileMixerState(j, j2);
        }
    }
}

package com.yy.audioengine;
/* loaded from: classes4.dex */
public class SpeechMsgPlayer {
    private ISpeechMsgPlayerNotify mNotify = null;
    private long mPlayerCtx;

    /* loaded from: classes4.dex */
    public enum PLAYER_INIT_STATUS {
        ERROR_NONE,
        ERROR_FILE_OPEN,
        ERROR_HEADER_LENGTH,
        ERROR_UNKNOWN_CODEC,
        ERROR_DECODER_INIT
    }

    private native long nativeCreate(Object obj, String str);

    private native long nativeDestroy(long j);

    private native long nativeFileTime(long j);

    private native int nativeInit(long j);

    private native void nativeStart(long j);

    private native void nativeStop(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SpeechMsgPlayer(String str) {
        this.mPlayerCtx = nativeCreate(this, str);
    }

    public PLAYER_INIT_STATUS init() {
        nativeInit(this.mPlayerCtx);
        return PLAYER_INIT_STATUS.ERROR_NONE;
    }

    public void start(ISpeechMsgPlayerNotify iSpeechMsgPlayerNotify) {
        this.mNotify = iSpeechMsgPlayerNotify;
        nativeStart(this.mPlayerCtx);
    }

    public void stop() {
        nativeStop(this.mPlayerCtx);
    }

    public void destroy() {
        this.mPlayerCtx = nativeDestroy(this.mPlayerCtx);
    }

    public long fileTime() {
        return nativeFileTime(this.mPlayerCtx);
    }

    private void onAudioPlayStatusEvent(long j, long j2, long j3) {
        if (this.mNotify != null) {
            this.mNotify.onAudioPlayStatus(j, j2, j3);
        }
    }

    private void onAudioPlayErrorEvent() {
        if (this.mNotify != null) {
            this.mNotify.onAudioPlayError();
        }
    }

    private void onFirstStartPlayDataEvent() {
        if (this.mNotify != null) {
            this.mNotify.onFirstStartPlayData();
        }
    }

    private void onStopPlayDataEvent(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.onStopPlayData(j, j2);
        }
    }

    private void onReachMaxPlayTimeEvent(long j, long j2) {
        if (this.mNotify != null) {
            this.mNotify.onReachMaxPlayTime(j, j2);
        }
    }
}

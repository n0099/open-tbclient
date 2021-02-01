package com.thunder.livesdk;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
import com.yy.audioengine.MainHandler;
/* loaded from: classes4.dex */
public class ThunderAudioFilePlayer implements Comparable<ThunderAudioFilePlayer> {
    public static final int AUDIO_PLAYER_CREATE_FILE_DECODER_FAILED = -1;
    public static final int AUDIO_PLAYER_OPEN_FILE_DECODER_FAILED = -2;
    public static final int AUDIO_PLAYER_OPEN_FILE_FORMAT_NOT_SUPPORT = -3;
    public static final int AUDIO_PLAYER_OPEN_FILE_PATH_ERROR = -4;
    public static final int AUDIO_PLAYER_STATUS_SUCCESS = 0;
    public static final int AUDIO_PLAY_EVENT_END = 6;
    public static final int AUDIO_PLAY_EVENT_OPEN = 1;
    public static final int AUDIO_PLAY_EVENT_PAUSE = 4;
    public static final int AUDIO_PLAY_EVENT_PLAY = 2;
    public static final int AUDIO_PLAY_EVENT_RESUME = 5;
    public static final int AUDIO_PLAY_EVENT_SEEK_COMPLETE = 7;
    public static final int AUDIO_PLAY_EVENT_STOP = 3;
    private Handler mPlayerQueueHandler;
    private long nativeCtx;
    private Object mCallbackLock = new Object();
    private IThunderAudioFilePlayerCallback mCallback = null;
    private IThunderAudioFilePlayerEventCallback mEventCallback = null;
    private boolean mIsDestroy = false;
    private String mFilePath = null;
    private boolean mIsMixStandard = false;
    @Deprecated
    private final int PLAY_EVENT_PLAYING = 2;
    @Deprecated
    private final int AUDIO_PLAY_EVENT_VOLUME = 8;
    @Deprecated
    private final int AUDIO_PLAY_EVENT_ERROR = 9;
    private HandlerThread mPlayerQueueThread = new HandlerThread("PlayerQueueThread");

    @Deprecated
    /* loaded from: classes4.dex */
    public interface IThunderAudioFilePlayerCallback {
        void onAudioFilePause();

        void onAudioFilePlayEnd();

        void onAudioFilePlayError(int i);

        void onAudioFilePlaying();

        void onAudioFileResume();

        void onAudioFileSeekComplete(int i);

        void onAudioFileStop();

        void onAudioFileVolume(long j, long j2, long j3);
    }

    public ThunderAudioFilePlayer() {
        this.nativeCtx = 0L;
        this.nativeCtx = ThunderNative.createAudioFilePlayer(this);
        this.mPlayerQueueThread.start();
        this.mPlayerQueueHandler = new Handler(this.mPlayerQueueThread.getLooper());
    }

    public synchronized void setPlayerEventCallback(IThunderAudioFilePlayerEventCallback iThunderAudioFilePlayerEventCallback) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer setPlayerEventCallback");
        if (!this.mIsDestroy) {
            synchronized (this.mCallbackLock) {
                this.mEventCallback = iThunderAudioFilePlayerEventCallback;
            }
        }
    }

    @Deprecated
    public synchronized void setPlayerNotify(IThunderAudioFilePlayerCallback iThunderAudioFilePlayerCallback) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer setPlayerNotify");
        if (!this.mIsDestroy) {
            synchronized (this.mCallbackLock) {
                this.mCallback = iThunderAudioFilePlayerCallback;
            }
        }
    }

    public synchronized void enableVolumeIndication(boolean z, int i) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer enableVolumeNotify enable = %b, interval=%d ", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.mIsDestroy) {
            ThunderLog.release(ThunderLog.kLogTagCall, "chorus: enableVolumeIndication mIsDestroy is null");
        } else {
            if (i <= 0) {
                i = 200;
            }
            ThunderNative.enableAudioFileVolumeCallback(this.nativeCtx, z, i);
        }
    }

    public synchronized void setMixStandard(boolean z) {
        ThunderNative.makeBehaviorEvent("af_player", "setMixStandard", String.valueOf(z), 2);
        this.mIsMixStandard = z;
        if (this.mIsMixStandard) {
            ThunderNative.enableAudioFileVolumeCallback(this.nativeCtx, true, 1000);
        }
    }

    public synchronized boolean isMixStandard() {
        return this.mIsMixStandard;
    }

    public void open(String str) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer open path = %s", str);
        this.mFilePath = str;
        if (!this.mIsDestroy && str != null && this.mPlayerQueueHandler != null) {
            this.mPlayerQueueHandler.post(new Runnable() { // from class: com.thunder.livesdk.ThunderAudioFilePlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    ThunderNative.audioFileOpen(ThunderAudioFilePlayer.this.nativeCtx, ThunderAudioFilePlayer.this.mFilePath);
                }
            });
        }
    }

    public void close() {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer close");
        if (!this.mIsDestroy && this.mFilePath != null && this.mPlayerQueueHandler != null) {
            this.mPlayerQueueHandler.post(new Runnable() { // from class: com.thunder.livesdk.ThunderAudioFilePlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    ThunderNative.audioFileClose(ThunderAudioFilePlayer.this.nativeCtx);
                }
            });
        }
    }

    public void play() {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer play");
        if (!this.mIsDestroy && this.mFilePath != null && this.mPlayerQueueHandler != null) {
            this.mPlayerQueueHandler.post(new Runnable() { // from class: com.thunder.livesdk.ThunderAudioFilePlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    ThunderNative.audioFilePlay(ThunderAudioFilePlayer.this.nativeCtx);
                }
            });
        }
    }

    public void stop() {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer stop");
        if (!this.mIsDestroy && this.mFilePath != null && this.mPlayerQueueHandler != null) {
            this.mPlayerQueueHandler.post(new Runnable() { // from class: com.thunder.livesdk.ThunderAudioFilePlayer.4
                @Override // java.lang.Runnable
                public void run() {
                    ThunderNative.audioFileStop(ThunderAudioFilePlayer.this.nativeCtx);
                }
            });
        }
    }

    public void pause() {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer pause");
        if (!this.mIsDestroy && this.mPlayerQueueHandler != null) {
            this.mPlayerQueueHandler.post(new Runnable() { // from class: com.thunder.livesdk.ThunderAudioFilePlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    ThunderNative.audioFilePause(ThunderAudioFilePlayer.this.nativeCtx);
                }
            });
        }
    }

    public void resume() {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer resume");
        if (!this.mIsDestroy && this.mPlayerQueueHandler != null) {
            this.mPlayerQueueHandler.post(new Runnable() { // from class: com.thunder.livesdk.ThunderAudioFilePlayer.6
                @Override // java.lang.Runnable
                public void run() {
                    ThunderNative.audioFileResume(ThunderAudioFilePlayer.this.nativeCtx);
                }
            });
        }
    }

    public void seek(final long j) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer seek timems = %d ", Long.valueOf(j));
        if (!this.mIsDestroy && this.mFilePath != null && this.mPlayerQueueHandler != null) {
            this.mPlayerQueueHandler.post(new Runnable() { // from class: com.thunder.livesdk.ThunderAudioFilePlayer.7
                @Override // java.lang.Runnable
                public void run() {
                    ThunderNative.audioFileSeek(ThunderAudioFilePlayer.this.nativeCtx, j);
                }
            });
        }
    }

    public long getTotalPlayTimeMS() {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer getTotalPlayTimeMS ");
        if (this.mIsDestroy) {
            return 0L;
        }
        return ThunderNative.audioFileGetTotalTime(this.nativeCtx);
    }

    public long getCurrentPlayTimeMS() {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer getCurrentPlayTimeMS ");
        if (this.mIsDestroy) {
            return 0L;
        }
        return ThunderNative.audioFileGetCurrentPlayTime(this.nativeCtx);
    }

    public void setPlayVolume(int i) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer setPlayVolume volume = %d", Integer.valueOf(i));
        if (!this.mIsDestroy) {
            if (i < 0) {
                i = 0;
            } else if (i > 100) {
                i = 100;
            }
            ThunderNative.audioFileSetPlayVolume(this.nativeCtx, i);
        }
    }

    public int setPlayerLocalVolume(int i) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer setPlayerLocalVolume volume = %d", Integer.valueOf(i));
        if (this.mIsDestroy) {
            return -1;
        }
        return ThunderNative.audioFileSetPlayerLocalVolume(this.nativeCtx, i);
    }

    public int setPlayerPublishVolume(int i) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer setPlayerPublishVolume volume = %d", Integer.valueOf(i));
        if (this.mIsDestroy) {
            return -1;
        }
        return ThunderNative.audioFileSetPlayerPublishVolume(this.nativeCtx, i);
    }

    public int getPlayerLocalVolume() {
        return (int) ThunderNative.audioFileGetPlayerLocalVolume(this.nativeCtx);
    }

    public int getPlayerPublishVolume() {
        return (int) ThunderNative.audioFileGetPlayerPublishVolume(this.nativeCtx);
    }

    public int getAudioTrackCount() {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer getAudioTrackCount ");
        if (this.mIsDestroy) {
            return 0;
        }
        return (int) ThunderNative.audioFileGetAudioTrackCount(this.nativeCtx);
    }

    public int selectAudioTrack(int i) {
        int audioTrackCount;
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer selectAudioTrack audioTrack = %d", Integer.valueOf(i));
        if (this.mIsDestroy || (audioTrackCount = getAudioTrackCount()) == 0 || i < 0) {
            return -1;
        }
        if (i >= audioTrackCount) {
            i = audioTrackCount - 1;
        }
        return ThunderNative.audioFileSelectAudioTrack(this.nativeCtx, i) != 1 ? -1 : 0;
    }

    public void setSemitone(int i) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer setSemitone val = %d", Integer.valueOf(i));
        if (!this.mIsDestroy) {
            if (i < -5) {
                i = -5;
            } else if (i > 5) {
                i = 5;
            }
            ThunderNative.audioFileSetSemitone(this.nativeCtx, i);
        }
    }

    public void setTempo(float f) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer setTempo tempo=%f", Float.valueOf(f));
        if (f < 0.5d) {
            f = 0.5f;
        } else if (f > 2.0f) {
            f = 2.0f;
        }
        ThunderNative.audioFileSetTempo(this.nativeCtx, f);
    }

    public void setPosition(int i) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer setTempo:(azimuth=%d)", Integer.valueOf(i));
        if (i < -90) {
            i = -90;
        } else if (i > 90) {
            i = 90;
        }
        ThunderNative.audioFileSetPosition(this.nativeCtx, i, 0);
    }

    public int setLooping(int i) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer setLooping cycle = %d", Integer.valueOf(i));
        if (this.mIsDestroy) {
            return -1;
        }
        return (int) ThunderNative.audioFileSetLooping(this.nativeCtx, i);
    }

    public void enablePublish(boolean z) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer enablePublish: enable=%b", Boolean.valueOf(z));
        if (!this.mIsDestroy) {
            ThunderNative.audioFileEnablePublish(this.nativeCtx, z);
        }
    }

    public void onPlayEvent(final int i, final int i2) {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer onPlayEvent event = %d, errorCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        MainHandler.getInstance().post(new Runnable() { // from class: com.thunder.livesdk.ThunderAudioFilePlayer.8
            @Override // java.lang.Runnable
            public void run() {
                if (!ThunderAudioFilePlayer.this.mIsDestroy) {
                    synchronized (ThunderAudioFilePlayer.this.mCallbackLock) {
                        if (ThunderAudioFilePlayer.this.mCallback != null) {
                            switch (i) {
                                case 1:
                                case 9:
                                    ThunderAudioFilePlayer.this.mCallback.onAudioFilePlayError(i2);
                                    break;
                                case 2:
                                    if (i2 != 0) {
                                        ThunderAudioFilePlayer.this.mCallback.onAudioFilePlayError(i2);
                                        break;
                                    } else {
                                        ThunderAudioFilePlayer.this.mCallback.onAudioFilePlaying();
                                        break;
                                    }
                                case 3:
                                    ThunderAudioFilePlayer.this.mCallback.onAudioFileStop();
                                    break;
                                case 4:
                                    ThunderAudioFilePlayer.this.mCallback.onAudioFilePause();
                                    break;
                                case 5:
                                    ThunderAudioFilePlayer.this.mCallback.onAudioFileResume();
                                    break;
                                case 6:
                                    ThunderAudioFilePlayer.this.mCallback.onAudioFilePlayEnd();
                                    break;
                                case 7:
                                    ThunderAudioFilePlayer.this.mCallback.onAudioFileSeekComplete(i2);
                                    break;
                            }
                        } else if (ThunderAudioFilePlayer.this.mEventCallback != null) {
                            ThunderAudioFilePlayer.this.mEventCallback.onAudioFileStateChange(i, i2);
                        }
                    }
                }
            }
        });
    }

    public synchronized void onAudioFileVolume(final long j, final long j2, final long j3) {
        MainHandler.getInstance().post(new Runnable() { // from class: com.thunder.livesdk.ThunderAudioFilePlayer.9
            @Override // java.lang.Runnable
            public void run() {
                if (!ThunderAudioFilePlayer.this.mIsDestroy) {
                    synchronized (ThunderAudioFilePlayer.this.mCallbackLock) {
                        if (ThunderAudioFilePlayer.this.mCallback == null) {
                            if (ThunderAudioFilePlayer.this.mEventCallback != null) {
                                ThunderLog.release(ThunderLog.kLogTagCall, " evt chorus: volume[%d], currentMs[%d], totalMs[%d].", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
                                ThunderAudioFilePlayer.this.mEventCallback.onAudioFileVolume(j, j2, j3);
                                if (ThunderAudioFilePlayer.this.isMixStandard()) {
                                    ThunderNative.sendAudioFilePlayerInfo((int) j, (int) j2, (int) j3);
                                }
                            } else {
                                ThunderLog.release(ThunderLog.kLogTagCall, " chorus: onAudioFileVolume mIsDestroy is null");
                            }
                        } else {
                            ThunderLog.release(ThunderLog.kLogTagCall, " chorus: volume[%d], currentMs[%d], totalMs[%d].", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
                            ThunderAudioFilePlayer.this.mCallback.onAudioFileVolume(j, j2, j3);
                            if (ThunderAudioFilePlayer.this.isMixStandard()) {
                                ThunderNative.sendAudioFilePlayerInfo((int) j, (int) j2, (int) j3);
                            }
                        }
                    }
                    return;
                }
                ThunderLog.release(ThunderLog.kLogTagCall, " chorus: onAudioFileVolume mIsDestroy is false");
            }
        });
    }

    public void destroyAudioFilePlayer() {
        ThunderLog.release(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer destroyAudioFilePlayer");
        try {
            if (this.mPlayerQueueHandler != null) {
                this.mPlayerQueueHandler.removeCallbacksAndMessages(null);
                if (Build.VERSION.SDK_INT >= 18) {
                    this.mPlayerQueueThread.quitSafely();
                } else {
                    this.mPlayerQueueThread.quit();
                }
                this.mPlayerQueueThread.join();
                this.mPlayerQueueHandler = null;
                this.mPlayerQueueThread = null;
            }
        } catch (Exception e) {
            ThunderLog.error(ThunderLog.kLogTagCall, "ThunderAudioFilePlayer destroyAudioFilePlayer, exception: " + e.getMessage());
        }
        setPlayerNotify(null);
        setPlayerEventCallback(null);
        ThunderNative.destroyAudioFilePlayer(this.nativeCtx);
        this.mIsDestroy = true;
        this.nativeCtx = 0L;
    }

    protected void finalize() {
        destroyAudioFilePlayer();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(ThunderAudioFilePlayer thunderAudioFilePlayer) {
        if (thunderAudioFilePlayer == null) {
            throw new NullPointerException();
        }
        return this == thunderAudioFilePlayer ? 0 : 1;
    }
}

package com.yy.videoplayer.decoder;

import android.support.v4.media.session.PlaybackStateCompat;
import com.yy.videoplayer.utils.TimeUtil;
import com.yy.videoplayer.utils.YMFLog;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class PlayNotify {
    long mStreamId;
    long mUserGroupId;
    NotifyTask nTaskRua;
    Thread notifyThread;
    Timer playTimer;
    private boolean mIsRunNotifyThread = true;
    WeakReference<PlayListner> mWpl = null;
    int lastStatus = 1;
    long lastDraw = System.currentTimeMillis();
    BlockingQueue<ViewNotifyEvent> eveq = new LinkedBlockingQueue(10);

    /* loaded from: classes6.dex */
    public interface PlayListner {
        void OnNoFrameCnt(int i);

        void OnPlayEnd();

        void OnPlayPause(long j);

        void OnPlayResume(long j);

        void OnPlayStart(long j);
    }

    public void Init() {
        try {
            this.playTimer = new Timer();
            this.playTimer.schedule(new PlayCheckingTask(), 10L, 1000L);
            this.nTaskRua = new NotifyTask();
            this.notifyThread = new Thread(null, this.nTaskRua, "PlayNotify", PlaybackStateCompat.ACTION_SET_REPEAT_MODE);
            this.notifyThread.start();
        } catch (Exception e) {
            YMFLog.error(this, "[Decoder ]", "failed to init notifier");
        }
    }

    public void Release() {
        try {
            this.eveq.clear();
            this.playTimer.cancel();
            this.eveq.put(new ViewNotifyEvent(-1, System.currentTimeMillis() - this.lastDraw, TimeUtil.getTickCountLong()));
            this.mIsRunNotifyThread = false;
            this.notifyThread.interrupt();
        } catch (Exception e) {
            YMFLog.error(this, "[Decoder ]", "release exception:" + e.toString());
        }
    }

    public void DrawNotify() {
        if ((this.lastStatus == 2 || this.lastStatus == 1) && this.eveq.remainingCapacity() > 0) {
            this.lastStatus ^= 1;
            try {
                if (this.eveq.remainingCapacity() > 0) {
                    this.eveq.put(new ViewNotifyEvent(this.lastStatus, System.currentTimeMillis() - this.lastDraw, TimeUtil.getTickCountLong()));
                }
            } catch (Exception e) {
                YMFLog.error(this, "[Decoder ]", "Failed to put START ViewNotifyEvent, exception:%s", e);
            }
        }
        this.lastDraw = System.currentTimeMillis();
    }

    public void NoFrameNotify(int i) {
        try {
            this.eveq.put(new ViewNotifyEvent(-2, i));
        } catch (Exception e) {
            YMFLog.error(this, "[Decoder ]", "Failed to put NOFRAME ViewNotifyEvent, exception:%s", e);
        }
    }

    public void EndPlay(boolean z) {
        this.lastStatus = 1;
        if (z) {
            try {
                if (this.eveq.remainingCapacity() > 0) {
                    this.eveq.put(new ViewNotifyEvent(this.lastStatus, System.currentTimeMillis() - this.lastDraw, TimeUtil.getTickCountLong()));
                }
            } catch (Exception e) {
                YMFLog.error(this, "[Decoder ]", "Failed to put END ViewNotifyEvent, exception:%s", e);
            }
        }
    }

    public void setVideoIds(long j, long j2) {
        this.mUserGroupId = j;
        this.mStreamId = j2;
    }

    public long getUserGroupId() {
        return this.mUserGroupId;
    }

    public long getStreamId() {
        return this.mStreamId;
    }

    /* loaded from: classes6.dex */
    private class PlayCheckingTask extends TimerTask {
        private PlayCheckingTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - PlayNotify.this.lastDraw > 2000) {
                if (PlayNotify.this.lastStatus == 3 || PlayNotify.this.lastStatus == 0) {
                    PlayNotify.this.lastStatus = 2;
                    try {
                        if (PlayNotify.this.eveq.remainingCapacity() > 0) {
                            PlayNotify.this.eveq.put(new ViewNotifyEvent(PlayNotify.this.lastStatus, System.currentTimeMillis() - PlayNotify.this.lastDraw, TimeUtil.getTickCountLong()));
                        }
                    } catch (Exception e) {
                        YMFLog.error(this, "[Decoder ]", "Failed to put START ViewNotifyEvent, exception:%s", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private class NotifyTask implements Runnable {
        private NotifyTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewNotifyEvent take;
            while (PlayNotify.this.mIsRunNotifyThread) {
                try {
                    take = PlayNotify.this.eveq.take();
                    YMFLog.info(this, "[Decoder ]", "videoview notify eventType:%d", Integer.valueOf(take.type));
                    YYVideoLibMgr.instance().onViewPlayEventNotify(PlayNotify.this.mUserGroupId, PlayNotify.this.mStreamId, take.type, take.happenTime);
                } catch (Exception e) {
                    YMFLog.info(this, "[Decoder ]", "Failed to take ViewNotifyEvent, exception:" + e.toString());
                }
                if (take.type == -1) {
                    YMFLog.info(this, "[Decoder ]", "view notify exit");
                    return;
                } else if (PlayNotify.this.mWpl == null) {
                    YMFLog.info(this, "[Decoder ]", "view notify no event listner");
                } else {
                    PlayListner playListner = PlayNotify.this.mWpl.get();
                    if (playListner != null) {
                        switch (take.type) {
                            case -2:
                                YMFLog.info(this, "[Decoder ]", "view notify NOFRAME");
                                playListner.OnNoFrameCnt(take.noFrameCnt);
                                continue;
                            case -1:
                            default:
                                continue;
                            case 0:
                                YMFLog.info(this, "[Decoder ]", "view notify START");
                                playListner.OnPlayStart(take.happenTime);
                                continue;
                            case 1:
                                YMFLog.info(this, "[Decoder ]", "view notify END");
                                playListner.OnPlayEnd();
                                continue;
                            case 2:
                                YMFLog.info(this, "[Decoder ]", "view notify PAUSE %d", Long.valueOf(take.interval));
                                playListner.OnPlayPause(take.interval);
                                continue;
                            case 3:
                                YMFLog.info(this, "[Decoder ]", "view notify RESUME %d", Long.valueOf(take.interval));
                                playListner.OnPlayResume(take.interval);
                                continue;
                        }
                    }
                }
            }
        }
    }

    public void setPlayListner(PlayListner playListner) {
        this.mWpl = new WeakReference<>(playListner);
    }

    /* loaded from: classes6.dex */
    static class ViewNotifyEvent {
        public static final int END = 1;
        private static final int EXIT = -1;
        public static final int NOFRAME = -2;
        public static final int PAUSE = 2;
        public static final int RESUME = 3;
        public static final int START = 0;
        long happenTime;
        long interval;
        int noFrameCnt;
        int type;

        ViewNotifyEvent(int i, long j, long j2) {
            this.type = i;
            this.interval = j;
            this.happenTime = j2;
        }

        ViewNotifyEvent(int i, int i2) {
            this.type = i;
            this.noFrameCnt = i2;
        }
    }
}

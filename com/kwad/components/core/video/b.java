package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class b {
    public static boolean JD;
    public static final AtomicInteger JE = new AtomicInteger(0);
    public com.kwad.sdk.core.video.kwai.c JG;
    public int JH;
    public long JI;
    public Runnable JJ;
    public com.kwad.sdk.contentalliance.kwai.kwai.b JK;
    public int Jn;
    public int Jo;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public String TAG = "MediaPlayerImpl";
    public volatile int JF = 0;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public long mStartTime = 0;
    public int JL = 0;
    public List<c.d> JM = new CopyOnWriteArrayList();
    public final AtomicBoolean JN = new AtomicBoolean(false);
    public boolean JO = false;
    public volatile List<g> JP = new CopyOnWriteArrayList();
    public volatile List<c.e> JQ = new CopyOnWriteArrayList();
    public c.e JR = new c.e() { // from class: com.kwad.components.core.video.b.1
        @Override // com.kwad.sdk.core.video.kwai.c.e
        public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
            String str = b.this.TAG;
            com.kwad.sdk.core.e.b.i(str, "onPrepared:" + b.getStateString(b.this.JF) + "->STATE_PREPARED");
            b.this.JF = 2;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.JF);
            for (c.e eVar : b.this.JQ) {
                eVar.a(b.this.JG);
            }
        }
    };
    public c.h JS = new c.h() { // from class: com.kwad.components.core.video.b.3
        @Override // com.kwad.sdk.core.video.kwai.c.h
        public final void i(int i, int i2) {
            if (b.this.mDetailVideoView != null) {
                b.this.mDetailVideoView.adaptVideoSize(i, i2);
            }
            String str = b.this.TAG;
            com.kwad.sdk.core.e.b.i(str, "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
        }
    };
    public c.b JT = new c.b() { // from class: com.kwad.components.core.video.b.4
        @Override // com.kwad.sdk.core.video.kwai.c.b
        public final void ns() {
            b.this.JF = 9;
            b bVar = b.this;
            bVar.onPlayStateChanged(bVar.JF);
            com.kwad.sdk.core.e.b.i(b.this.TAG, "onCompletion ——> STATE_COMPLETED");
        }
    };
    public c.InterfaceC0687c JU = new c.InterfaceC0687c() { // from class: com.kwad.components.core.video.b.5
        @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0687c
        public final boolean j(int i, int i2) {
            if (i != -38) {
                b.this.JF = -1;
                b.this.Jn = i;
                b.this.Jo = i2;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.JF);
                String str = b.this.TAG;
                com.kwad.sdk.core.e.b.i(str, "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                return true;
            }
            return true;
        }
    };
    public c.d JV = new c.d() { // from class: com.kwad.components.core.video.b.6
        @Override // com.kwad.sdk.core.video.kwai.c.d
        public final boolean k(int i, int i2) {
            String str;
            StringBuilder sb;
            String str2;
            String str3;
            String str4;
            if (i != 3) {
                if (i == 701) {
                    if (b.this.JF == 5 || b.this.JF == 7) {
                        b.this.JF = 7;
                        str3 = b.this.TAG;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        b.this.JF = 6;
                        str3 = b.this.TAG;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.e.b.i(str3, str4);
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.JF);
                } else if (i == 702) {
                    if (b.this.JF == 6) {
                        b.this.JF = 4;
                        b bVar2 = b.this;
                        bVar2.onPlayStateChanged(bVar2.JF);
                        com.kwad.sdk.core.e.b.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.JF == 7) {
                        b.this.JF = 5;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.JF);
                        str = b.this.TAG;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                        com.kwad.sdk.core.e.b.i(str, str2);
                    }
                } else if (i != 10001) {
                    if (i == 801) {
                        str = b.this.TAG;
                        str2 = "视频不能seekTo，为直播视频";
                        com.kwad.sdk.core.e.b.i(str, str2);
                    } else {
                        str = b.this.TAG;
                        sb = new StringBuilder("onInfo ——> what：");
                        sb.append(i);
                    }
                }
                b bVar4 = b.this;
                bVar4.a(bVar4.JG, i, i2);
                return true;
            }
            b.this.JF = 4;
            b bVar5 = b.this;
            bVar5.onPlayStateChanged(bVar5.JF);
            str = b.this.TAG;
            sb = new StringBuilder("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
            sb.append(System.currentTimeMillis() - b.this.mStartTime);
            str2 = sb.toString();
            com.kwad.sdk.core.e.b.i(str, str2);
            b bVar42 = b.this;
            bVar42.a(bVar42.JG, i, i2);
            return true;
        }
    };
    public c.a JW = new c.a() { // from class: com.kwad.components.core.video.b.7
        @Override // com.kwad.sdk.core.video.kwai.c.a
        public final void ai(int i) {
            b.this.JH = i;
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        @WorkerThread
        void onReleaseSuccess();
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.kwai.c cVar) {
        com.kwad.sdk.core.e.b.i(this.TAG, "initMediaPlayer");
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.JO = z;
        this.JK = bVar;
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.e.b.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.JG != cVar) {
            com.kwad.sdk.core.e.b.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.kwai.c cVar2 = this.JG;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                oV();
                this.JG.release();
            }
            this.JG = cVar;
            reset();
            oU();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.e.b.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            oV();
            oU();
        }
        this.JG.setSurface(detailVideoView.Ke);
    }

    public static void a(com.kwad.sdk.core.video.kwai.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        try {
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public static String getStateString(int i) {
        switch (i) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.JP != null) {
            for (g gVar : this.JP) {
                gVar.onVideoPlayProgress(duration, currentPosition);
            }
        }
    }

    private void oU() {
        this.JG.b(this.JR);
        this.JG.a(this.JS);
        this.JG.a(this.JT);
        this.JG.a(this.JU);
        this.JG.c(this.JV);
        this.JG.a(this.JW);
    }

    private void oV() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0687c) null);
        this.JG.a((c.b) null);
        this.JG.b(null);
        this.JG.a((c.h) null);
        this.JG.c(null);
        this.JG.a((c.f) null);
        this.JG.a((c.a) null);
    }

    private void oX() {
        oY();
        if (this.JJ == null) {
            this.JJ = new Runnable() { // from class: com.kwad.components.core.video.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.oR();
                    if (b.this.JJ != null) {
                        b.this.mHandler.postDelayed(b.this.JJ, 500L);
                    }
                }
            };
        }
        this.mHandler.post(this.JJ);
    }

    private void oY() {
        Runnable runnable = this.JJ;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.JJ = null;
        }
    }

    private void reset() {
        String str = this.TAG;
        com.kwad.sdk.core.e.b.i(str, "reset:" + getStateString(this.JF) + "->STATE_IDLE");
        this.JG.reset();
        this.JF = 0;
    }

    private void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.JK;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    public final void a(final a aVar, boolean z) {
        if (this.JG == null) {
            return;
        }
        setKeepScreenOn(false);
        this.mHandler.removeCallbacksAndMessages(null);
        oY();
        oV();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.video.b.10
                    @Override // java.lang.Runnable
                    public final void run() {
                        b bVar = b.this;
                        b.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.JG = null;
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.b.i(str, "release:" + getStateString(this.JF) + "->STATE_IDLE");
        this.JF = 0;
        this.JL = 0;
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar instanceof com.kwad.sdk.core.video.kwai.d) {
            ((com.kwad.sdk.core.video.kwai.d) cVar).a(aVar);
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        try {
            if (TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.e.b.e(this.TAG, "videoUrl is null");
                return;
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.b.e(str, "videoUrl=" + bVar.videoUrl);
            this.JG.a(bVar);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, @NonNull DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        String str = this.TAG;
        com.kwad.sdk.core.e.b.i(str, "initMediaPlayer enablePreLoad:" + z);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.video.kwai.c a2 = com.kwad.sdk.core.video.kwai.e.a(this.mContext, z, com.kwad.sdk.core.config.d.lt(), com.kwad.sdk.core.config.d.lu());
        a2.setLooping(false);
        a(bVar, z2, detailVideoView, a2);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.JM.add(dVar);
    }

    public final void a(c.e eVar) {
        this.JQ.add(eVar);
    }

    public final void a(com.kwad.sdk.core.video.kwai.c cVar, int i, int i2) {
        Iterator<c.d> it = this.JM.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.k(i, i2);
            }
        }
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.JM.remove(dVar);
    }

    public final void c(g gVar) {
        this.JP.add(gVar);
    }

    public final void clear() {
        this.JP.clear();
    }

    public final void d(g gVar) {
        this.JP.remove(gVar);
    }

    public final int getBufferPercentage() {
        return this.JH;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    public final boolean isPrepared() {
        return this.JF == 2 || this.JF == 3 || this.JF == 5 || this.JF == 8 || this.JF == 9;
    }

    public final boolean isPreparing() {
        return this.JF == 1;
    }

    public final com.kwad.sdk.core.video.kwai.c oT() {
        return this.JG;
    }

    public final void oW() {
        if (this.JG == null) {
            com.kwad.sdk.core.e.b.w("resetAndPlay", "mMediaPlayer is null");
        } else if (this.JF == 2 || this.JF == 3 || this.JF == 4 || this.JF == 5) {
            com.kwad.sdk.core.e.b.w("resetAndPlay", "can not resetAndPlay in sate:" + this.JF);
        } else {
            reset();
            oV();
            oU();
            prepareAsync();
        }
    }

    public final void onPlayStateChanged(int i) {
        if (this.JP == null) {
            return;
        }
        for (g gVar : this.JP) {
            if (gVar != null) {
                switch (i) {
                    case -1:
                        setKeepScreenOn(false);
                        oY();
                        gVar.onVideoPlayError(this.Jn, this.Jo);
                        continue;
                    case 1:
                        gVar.onVideoPreparing();
                        continue;
                    case 2:
                        gVar.onVideoPrepared();
                        continue;
                    case 3:
                        setKeepScreenOn(true);
                        gVar.onVideoPlayStart();
                        continue;
                    case 4:
                        setKeepScreenOn(true);
                        gVar.onVideoPlaying();
                        continue;
                    case 5:
                        setKeepScreenOn(false);
                        gVar.onVideoPlayPaused();
                        continue;
                    case 6:
                        gVar.onVideoPlayBufferingPlaying();
                        continue;
                    case 7:
                        gVar.onVideoPlayBufferingPaused();
                        continue;
                    case 9:
                        try {
                            if (this.JG != null && !this.JG.isLooping()) {
                                setKeepScreenOn(false);
                                oY();
                            }
                            gVar.onVideoPlayCompleted();
                            continue;
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public final boolean pause() {
        boolean z;
        String str = this.TAG;
        com.kwad.sdk.core.e.b.i(str, "pause mCurrentState: " + getStateString(this.JF));
        if (this.JF == 4) {
            this.JG.pause();
            com.kwad.sdk.core.e.b.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.JF = 5;
            onPlayStateChanged(this.JF);
            z = true;
        } else {
            z = false;
        }
        if (this.JF == 6) {
            this.JG.pause();
            com.kwad.sdk.core.e.b.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.JF = 7;
            onPlayStateChanged(this.JF);
            z = true;
        }
        if (this.JF == 3) {
            this.JG.pause();
            com.kwad.sdk.core.e.b.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.JF = 5;
            onPlayStateChanged(this.JF);
            z = true;
        }
        if (this.JF == 9 && this.JG.isLooping()) {
            this.JG.pause();
            String str2 = this.TAG;
            com.kwad.sdk.core.e.b.i(str2, "pause " + getStateString(this.JF) + "->STATE_PAUSED");
            this.JF = 5;
            onPlayStateChanged(this.JF);
            return true;
        }
        return z;
    }

    public final void prepareAsync() {
        if (this.JG == null) {
            return;
        }
        if (this.JO) {
            if (this.JN.compareAndSet(false, true)) {
                com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.video.b.8
                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, CONST_STR, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x00c9 A[Catch: all -> 0x00d4, TRY_ENTER, TryCatch #3 {Exception -> 0x00d7, blocks: (B:20:0x00c2, B:21:0x00c8, B:22:0x00c9, B:23:0x00d2), top: B:37:0x00c2 }] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void run() {
                        boolean prepareAsync;
                        String str = b.this.TAG;
                        com.kwad.sdk.core.e.b.i(str, "prepareAsync now:" + b.getStateString(b.this.JF));
                        if (b.this.JG == null) {
                            return;
                        }
                        try {
                            synchronized (b.this.JG) {
                                b.this.a(b.this.JK);
                                prepareAsync = b.this.JG.prepareAsync();
                                String str2 = b.this.TAG;
                                com.kwad.sdk.core.e.b.i(str2, "prepareAsync:" + b.getStateString(b.this.JF) + "->STATE_PREPARING, success: " + prepareAsync);
                                b.this.JF = 1;
                            }
                            if (prepareAsync) {
                                b.this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.video.b.8.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        b bVar = b.this;
                                        bVar.onPlayStateChanged(bVar.JF);
                                    }
                                });
                            } else {
                                com.kwad.sdk.core.e.b.e(b.this.TAG, "prepareAsync failed");
                            }
                        } finally {
                            try {
                                synchronized (b.this.JN) {
                                }
                            } finally {
                            }
                        }
                        try {
                            synchronized (b.this.JN) {
                                b.this.JN.notifyAll();
                            }
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.b.printStackTrace(e);
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            a(this.JK);
            if (!this.JG.prepareAsync()) {
                com.kwad.sdk.core.e.b.e(this.TAG, "prepareAsync failed");
                return;
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.b.i(str, "prepareAsync:" + getStateString(this.JF) + "->STATE_PREPARING");
            this.JF = 1;
            onPlayStateChanged(this.JF);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i = this.JL;
                this.JL = i + 1;
                if (i <= 4) {
                    oW();
                }
            }
            String str2 = this.TAG;
            com.kwad.sdk.core.e.b.i(str2, "prepareAsync Exception:" + getStateString(this.JF));
            com.kwad.sdk.core.e.b.printStackTrace(th);
        }
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseSync() {
        a((a) null, false);
    }

    public final void restart() {
        if (this.JG != null && this.JF == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        if (this.JG == null) {
            com.kwad.sdk.core.e.b.e(this.TAG, "resume but mMediaPlayer is null");
            return;
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.b.i(str, "resume mCurrentState: " + getStateString(this.JF));
        if (this.JF == 2 || this.JF == 0) {
            String str2 = this.TAG;
            com.kwad.sdk.core.e.b.i(str2, "resume:" + getStateString(this.JF) + "->start()");
            start();
        } else if (this.JF == 5) {
            this.JG.start();
            String str3 = this.TAG;
            com.kwad.sdk.core.e.b.i(str3, "resume:" + getStateString(this.JF) + "->STATE_PLAYING");
            this.JF = 4;
            onPlayStateChanged(this.JF);
            setPlayType(2);
        } else if (this.JF != 7) {
            String str4 = this.TAG;
            com.kwad.sdk.core.e.b.e(str4, "resume: " + getStateString(this.JF) + " 此时不能调用resume()方法.");
        } else {
            this.JG.start();
            String str5 = this.TAG;
            com.kwad.sdk.core.e.b.i(str5, "resume:" + getStateString(this.JF) + "->STATE_BUFFERING_PLAYING");
            this.JF = 6;
            onPlayStateChanged(this.JF);
        }
    }

    public final void seekTo(long j) {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            cVar.seekTo(j);
        }
    }

    public final void setAudioEnabled(boolean z) {
        float f = z ? 1.0f : 0.0f;
        setVolume(f, f);
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mDetailVideoView.setRadius(f, f2, f3, f4);
    }

    public final void setSpeed(float f) {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar == null) {
            return;
        }
        cVar.setSpeed(f);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void setVolume(float f, float f2) {
        com.kwad.sdk.core.video.kwai.c cVar = this.JG;
        if (cVar == null) {
            return;
        }
        cVar.setVolume(f, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
        if (r7.JF == 9) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void start() {
        String str = this.TAG;
        com.kwad.sdk.core.e.b.i(str, "start mCurrentState: " + getStateString(this.JF));
        if (this.JF == 0) {
            com.kwad.sdk.core.e.b.i(this.TAG, "start, still not prepared well, prepare again");
            prepareAsync();
            if (getMediaPlayerType() == 2) {
                if (this.JO && this.JN.get()) {
                    com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.video.b.9
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (b.this.JN.get()) {
                                try {
                                    synchronized (b.this.JN) {
                                        b.this.JN.wait(5000L);
                                    }
                                } catch (InterruptedException e) {
                                    com.kwad.sdk.core.e.b.printStackTrace(e);
                                }
                            }
                            if (b.this.getMediaPlayerType() == 2) {
                                b.this.JG.start();
                            }
                        }
                    });
                } else {
                    this.JG.start();
                }
            }
        } else if (this.JF == 2 || this.JF == 9) {
            this.mStartTime = System.currentTimeMillis();
            this.JG.start();
            long j = this.JI;
            if (j != 0) {
                this.JG.seekTo((int) j);
            }
            String str2 = this.TAG;
            com.kwad.sdk.core.e.b.i(str2, "start:" + getStateString(this.JF) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.JK;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.JF == 2) {
                    if (this.JK.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    }
                    setPlayType(3);
                }
            }
            this.JF = 3;
            onPlayStateChanged(this.JF);
            oX();
        }
    }

    public final void start(long j) {
        this.JI = j;
        start();
    }

    public final void stopAndPrepareAsync() {
        String str = this.TAG;
        com.kwad.sdk.core.e.b.i(str, "stopAndPrepareAsync mCurrentState:" + this.JF);
        if (this.JF == 1 || this.JF == 2) {
            return;
        }
        if (this.JF != 3 && this.JF != 4 && this.JF != 5 && this.JF != 6 && this.JF != 7 && this.JF != 8 && this.JF != 9) {
            release();
            return;
        }
        try {
            this.JG.stop();
            this.JF = 8;
            onPlayStateChanged(this.JF);
            prepareAsync();
        } catch (Exception unused) {
            release();
            String str2 = this.TAG;
            com.kwad.sdk.core.e.b.e(str2, "stopAndPrepareAsync mCurrentState:" + this.JF);
        }
    }
}

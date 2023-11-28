package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class b {
    public static boolean TB;
    public static final AtomicInteger TC = new AtomicInteger(0);
    public final String TAG;
    public volatile int TD;
    public com.kwad.sdk.core.video.a.c TE;
    public int TF;
    public long TG;
    public Runnable TH;
    public com.kwad.sdk.contentalliance.a.a.b TI;
    public int TJ;
    public List<c.d> TK;
    public final AtomicBoolean TL;
    public boolean TM;
    public final int TN;
    public volatile List<k> TO;
    public volatile List<c.e> TP;
    public final c.f TQ;
    public c.e TR;
    public c.i TS;
    public c.b TT;
    public c.InterfaceC0713c TU;
    public c.d TV;
    public c.a TW;
    public int Tl;
    public int Tm;
    public com.kwad.components.core.video.a.a Ty;
    public Handler fS;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public long mStartTime;

    /* loaded from: classes10.dex */
    public interface a {
        @WorkerThread
        void onReleaseSuccess();
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
    public void rd() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.TO != null) {
            for (k kVar : this.TO) {
                kVar.onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    private void reset() {
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "reset:" + getStateString(this.TD) + "->STATE_IDLE");
        this.TE.reset();
        this.TD = 0;
    }

    private void rg() {
        this.TE.a(this.TQ);
        this.TE.b(this.TR);
        this.TE.a(this.TS);
        this.TE.a(this.TT);
        this.TE.a(this.TU);
        this.TE.c(this.TV);
        this.TE.a(this.TW);
    }

    private void rh() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0713c) null);
        this.TE.a((c.b) null);
        this.TE.b(null);
        this.TE.a((c.i) null);
        this.TE.c(null);
        this.TE.a((c.g) null);
        this.TE.a((c.a) null);
    }

    private void rj() {
        rk();
        if (this.TH == null) {
            this.TH = new Runnable() { // from class: com.kwad.components.core.video.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.rd();
                    if (b.this.TH != null) {
                        b.this.fS.postDelayed(b.this.TH, 500L);
                    }
                }
            };
        }
        this.fS.post(this.TH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk() {
        Runnable runnable = this.TH;
        if (runnable != null) {
            this.fS.removeCallbacks(runnable);
            this.TH = null;
        }
    }

    public final void clear() {
        this.TO.clear();
    }

    public final int getBufferPercentage() {
        return this.TF;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar == null) {
            return "";
        }
        return cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    @Deprecated
    public final boolean isPrepared() {
        if (this.TD != 2 && this.TD != 3 && this.TD != 5 && this.TD != 8 && this.TD != 9) {
            return false;
        }
        return true;
    }

    @Deprecated
    public final boolean isPreparing() {
        if (this.TD == 1) {
            return true;
        }
        return false;
    }

    public final void prepareAsync() {
        aO(false);
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseSync() {
        a((a) null, false);
    }

    public final void restart() {
        if (this.TE != null && this.TD == 9) {
            start();
        }
        setPlayType(3);
    }

    public final com.kwad.sdk.core.video.a.c rf() {
        return this.TE;
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(boolean z) {
        boolean prepareAsync;
        a(this.TI);
        if (z) {
            prepareAsync = this.TE.EQ();
        } else {
            prepareAsync = this.TE.prepareAsync();
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "prepareAsync forcePrepare: " + z + ", result: " + prepareAsync);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.TI;
        if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
            videoPlayerStatus.mVideoPlayerType = i;
        }
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    public final void onPlayStateChanged(final int i) {
        if (this.TO == null) {
            return;
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.video.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                for (k kVar : b.this.TO) {
                    switch (i) {
                        case -1:
                            b.this.setKeepScreenOn(false);
                            b.this.rk();
                            kVar.onMediaPlayError(b.this.Tl, b.this.Tm);
                            break;
                        case 1:
                            kVar.onMediaPreparing();
                            break;
                        case 2:
                            kVar.onMediaPrepared();
                            break;
                        case 3:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlayStart();
                            break;
                        case 4:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlaying();
                            break;
                        case 5:
                            b.this.setKeepScreenOn(false);
                            kVar.onMediaPlayPaused();
                            break;
                        case 6:
                            kVar.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            kVar.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (b.this.TE != null && !b.this.TE.isLooping()) {
                                b.this.setKeepScreenOn(false);
                                b.this.rk();
                            }
                            kVar.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    public final void seekTo(long j) {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            cVar.seekTo(j);
        }
    }

    public final void setAudioEnabled(boolean z) {
        if (z) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setSpeed(float f) {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar == null) {
            return;
        }
        cVar.setSpeed(f);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void start(long j) {
        this.TG = j;
        start();
    }

    public b(@Nullable DetailVideoView detailVideoView, int i) {
        this.TD = 0;
        this.fS = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.TJ = 0;
        this.TK = new CopyOnWriteArrayList();
        this.TL = new AtomicBoolean(false);
        this.TM = false;
        this.TO = new CopyOnWriteArrayList();
        this.TP = new CopyOnWriteArrayList();
        this.TQ = new c.f() { // from class: com.kwad.components.core.video.b.1
            @Override // com.kwad.sdk.core.video.a.c.f
            public final void rl() {
                b.this.TD = 1;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.TD);
            }
        };
        this.TR = new c.e() { // from class: com.kwad.components.core.video.b.4
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                String str = b.this.TAG;
                com.kwad.sdk.core.e.c.i(str, "onPrepared:" + b.getStateString(b.this.TD) + "->STATE_PREPARED");
                b.this.TD = 2;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.TD);
                for (c.e eVar : b.this.TP) {
                    eVar.a(b.this.TE);
                }
            }
        };
        this.TS = new c.i() { // from class: com.kwad.components.core.video.b.5
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void m(int i2, int i3) {
                if (b.this.mDetailVideoView != null) {
                    b.this.mDetailVideoView.adaptVideoSize(i2, i3);
                }
                String str = b.this.TAG;
                com.kwad.sdk.core.e.c.i(str, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
            }
        };
        this.TT = new c.b() { // from class: com.kwad.components.core.video.b.6
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void oO() {
                b.this.TD = 9;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.TD);
                com.kwad.sdk.core.video.a.a.a.ea("videoFinishPlay");
            }
        };
        this.TU = new c.InterfaceC0713c() { // from class: com.kwad.components.core.video.b.7
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0713c
            public final boolean n(int i2, int i3) {
                if (i2 == -38) {
                    return true;
                }
                b.this.TD = -1;
                b.this.Tl = i2;
                b.this.Tm = i3;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.TD);
                String str = b.this.TAG;
                com.kwad.sdk.core.e.c.i(str, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                return true;
            }
        };
        this.TV = new c.d() { // from class: com.kwad.components.core.video.b.8
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean o(int i2, int i3) {
                if (i2 != 3) {
                    if (i2 == 701) {
                        if (b.this.TD == 5 || b.this.TD == 7) {
                            b.this.TD = 7;
                            com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                        } else {
                            b.this.TD = 6;
                            com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                        }
                        b bVar = b.this;
                        bVar.onPlayStateChanged(bVar.TD);
                    } else if (i2 == 702) {
                        if (b.this.TD == 6) {
                            b.this.TD = 4;
                            b bVar2 = b.this;
                            bVar2.onPlayStateChanged(bVar2.TD);
                            com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                        }
                        if (b.this.TD == 7) {
                            b.this.TD = 5;
                            b bVar3 = b.this;
                            bVar3.onPlayStateChanged(bVar3.TD);
                            com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                        }
                    } else if (i2 != 10001) {
                        if (i2 != 801) {
                            String str = b.this.TAG;
                            com.kwad.sdk.core.e.c.i(str, "onInfo ——> what：" + i2);
                        } else {
                            com.kwad.sdk.core.e.c.i(b.this.TAG, "视频不能seekTo，为直播视频");
                        }
                    }
                } else {
                    b.this.TD = 4;
                    b bVar4 = b.this;
                    bVar4.onPlayStateChanged(bVar4.TD);
                    String str2 = b.this.TAG;
                    com.kwad.sdk.core.e.c.i(str2, "onInfo:" + b.getStateString(b.this.TD) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
                }
                b bVar5 = b.this;
                bVar5.a(bVar5.TE, i2, i3);
                return true;
            }
        };
        this.TW = new c.a() { // from class: com.kwad.components.core.video.b.9
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void au(int i2) {
                b.this.TF = i2;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.TN = 0;
        String str = "DetailMediaPlayerImpl[0" + PreferencesUtil.RIGHT_MOUNT;
        this.TAG = str;
        com.kwad.sdk.core.e.c.i(str, "create DetailMediaPlayerImpl");
    }

    public b(@Nullable DetailVideoView detailVideoView, @NonNull AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void setVolume(float f, float f2) {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f, f2);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.a.c cVar) {
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "initMediaPlayer " + this.TE);
        if (bVar != null && detailVideoView != null && cVar != null) {
            if (this.mContext == null) {
                this.mContext = detailVideoView.getContext().getApplicationContext();
            }
            this.TM = z;
            this.TI = bVar;
            AdTemplate adTemplate = bVar.adTemplate;
            if (adTemplate != null) {
                this.Ty = com.kwad.components.core.video.a.c.ay(adTemplate);
            } else {
                AdTemplate adTemplate2 = this.mAdTemplate;
                if (adTemplate2 != null) {
                    this.Ty = com.kwad.components.core.video.a.c.ay(adTemplate2);
                } else {
                    this.Ty = com.kwad.components.core.video.a.c.ax(bVar.videoUrl);
                }
            }
            this.TO.add(this.Ty);
            DetailVideoView detailVideoView2 = this.mDetailVideoView;
            if (detailVideoView2 != detailVideoView) {
                com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer videoView changed");
                if (detailVideoView2 != null) {
                    detailVideoView2.setMediaPlayer(null);
                    detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                    detailVideoView2.setKeepScreenOn(false);
                }
                this.mDetailVideoView = detailVideoView;
            }
            detailVideoView.setMediaPlayer(this);
            if (this.TE != cVar) {
                com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer mediaPlayer changed");
                com.kwad.sdk.core.video.a.c cVar2 = this.TE;
                if (cVar2 != null) {
                    cVar.setLooping(cVar2.isLooping());
                    rh();
                    this.TE.release();
                }
                this.TE = cVar;
                reset();
                rg();
                cVar.setAudioStreamType(3);
            } else {
                com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
                reset();
                rh();
                rg();
            }
            this.TE.setSurface(detailVideoView.Uf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.a.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "releaseMediaPlayer:" + getStateString(this.TD) + "->STATE_IDLE");
        try {
            if (this.Ty != null) {
                this.Ty.onRelease();
            }
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    private void aO(final boolean z) {
        if (this.TE == null) {
            return;
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "start prepareAsync");
        if (this.TM) {
            if (!this.TL.compareAndSet(false, true)) {
                return;
            }
            com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.video.b.10
                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, CONST_STR, CONSTRUCTOR, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0071 A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #5 {Exception -> 0x007f, blocks: (B:17:0x006a, B:18:0x0070, B:19:0x0071, B:20:0x007a), top: B:33:0x006a }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    String str = b.this.TAG;
                    com.kwad.sdk.core.e.c.i(str, "prepareAsync now:" + b.getStateString(b.this.TD));
                    if (b.this.TE == null) {
                        return;
                    }
                    try {
                        synchronized (b.this.TE) {
                            b.this.aP(z);
                        }
                    } finally {
                        try {
                            synchronized (b.this.TL) {
                            }
                        } finally {
                        }
                    }
                    try {
                        synchronized (b.this.TL) {
                            b.this.TL.notifyAll();
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
            });
            return;
        }
        try {
            aP(z);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i = this.TJ;
                this.TJ = i + 1;
                if (i <= 4) {
                    ri();
                }
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "prepareAsync Exception:" + getStateString(this.TD));
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    public final void a(final a aVar, boolean z) {
        if (this.TE == null) {
            return;
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "release:" + getStateString(this.TD) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.fS.removeCallbacksAndMessages(null);
        rk();
        rh();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.video.b.11
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.TE = null;
        }
        this.TD = 0;
        this.TJ = 0;
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        com.kwad.sdk.core.video.a.c cVar = this.TE;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(aVar);
        }
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.TK.remove(dVar);
    }

    public final void c(k kVar) {
        this.TO.add(kVar);
    }

    public final void d(k kVar) {
        this.TO.remove(kVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.videoUrl)) {
                String str = this.TAG;
                com.kwad.sdk.core.e.c.d(str, "videoUrl=" + bVar.videoUrl);
                this.TE.a(bVar);
                return;
            }
            com.kwad.sdk.core.e.c.e(this.TAG, "videoUrl is null");
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "initMediaPlayer enablePreLoad:" + z);
        if (bVar != null && detailVideoView != null) {
            com.kwad.sdk.core.video.a.c a2 = com.kwad.sdk.core.video.a.e.a(this.mContext, z, com.kwad.sdk.core.config.d.yf(), com.kwad.sdk.core.config.d.yg(), this.TN);
            a2.setLooping(false);
            a(bVar, z2, detailVideoView, a2);
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mDetailVideoView.setRadius(f, f2, f3, f4);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.TK.add(dVar);
    }

    public final void a(c.e eVar) {
        this.TP.add(eVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
        Iterator<c.d> it = this.TK.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.o(i, i2);
            }
        }
    }

    public final boolean pause() {
        boolean z;
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "pause mCurrentState: " + getStateString(this.TD));
        if (this.TD == 4) {
            this.TE.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.TD = 5;
            onPlayStateChanged(this.TD);
            com.kwad.sdk.core.video.a.a.a.ea("videoPausePlay");
            z = true;
        } else {
            z = false;
        }
        if (this.TD == 6) {
            this.TE.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.TD = 7;
            onPlayStateChanged(this.TD);
            z = true;
        }
        if (this.TD == 3) {
            this.TE.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.TD = 5;
            onPlayStateChanged(this.TD);
            com.kwad.sdk.core.video.a.a.a.ea("videoPausePlay");
            z = true;
        }
        if (this.TD == 9 && this.TE.isLooping()) {
            this.TE.pause();
            String str2 = this.TAG;
            com.kwad.sdk.core.e.c.i(str2, "pause " + getStateString(this.TD) + "->STATE_PAUSED");
            this.TD = 5;
            onPlayStateChanged(this.TD);
            return true;
        }
        return z;
    }

    public final void start() {
        if (this.TE == null) {
            return;
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "start state: " + getStateString(this.TD));
        com.kwad.components.core.video.a.a aVar = this.Ty;
        if (aVar != null) {
            try {
                aVar.onStart();
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        if (this.TD == 0) {
            com.kwad.sdk.core.e.c.i(this.TAG, "start still not prepared well forcePrepare");
            aO(true);
        } else if (this.TD != 2 && this.TD != 9) {
            if (this.TD == 3) {
                this.TE.start();
            }
        } else {
            this.mStartTime = System.currentTimeMillis();
            this.TE.start();
            com.kwad.sdk.core.video.a.a.a.ea("videoStartPlay");
            long j = this.TG;
            if (j != 0) {
                this.TE.seekTo((int) j);
            }
            String str2 = this.TAG;
            com.kwad.sdk.core.e.c.i(str2, "start:" + getStateString(this.TD) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.a.a.b bVar = this.TI;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.TD == 2) {
                    if (this.TI.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.TD == 9) {
                    setPlayType(3);
                }
            }
            this.TD = 3;
            onPlayStateChanged(this.TD);
            rj();
        }
    }

    public final void resume() {
        if (this.TE == null) {
            com.kwad.sdk.core.e.c.e(this.TAG, "resume but mMediaPlayer is null");
            return;
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "resume state: " + getStateString(this.TD));
        if (this.TD != 2 && this.TD != 3 && this.TD != 0) {
            if (this.TD == 5) {
                this.TE.start();
                String str2 = this.TAG;
                com.kwad.sdk.core.e.c.i(str2, "resume:" + getStateString(this.TD) + "->STATE_PLAYING");
                this.TD = 4;
                onPlayStateChanged(this.TD);
                setPlayType(2);
                com.kwad.sdk.core.video.a.a.a.ea("videoResumePlay");
                return;
            } else if (this.TD == 7) {
                this.TE.start();
                String str3 = this.TAG;
                com.kwad.sdk.core.e.c.i(str3, "resume:" + getStateString(this.TD) + "->STATE_BUFFERING_PLAYING");
                this.TD = 6;
                onPlayStateChanged(this.TD);
                return;
            } else if (this.TD != 1) {
                String str4 = this.TAG;
                com.kwad.sdk.core.e.c.w(str4, "resume: " + getStateString(this.TD) + " 此时不能调用resume()方法.");
                return;
            } else {
                return;
            }
        }
        String str5 = this.TAG;
        com.kwad.sdk.core.e.c.i(str5, "resume:" + getStateString(this.TD) + "->start()");
        start();
    }

    public final void ri() {
        if (this.TE == null) {
            com.kwad.sdk.core.e.c.w("resetAndPlay", "mMediaPlayer is null");
        } else if (this.TD != 2 && this.TD != 3 && this.TD != 4 && this.TD != 5) {
            reset();
            rh();
            rg();
            prepareAsync();
        } else {
            com.kwad.sdk.core.e.c.w("resetAndPlay", "can not resetAndPlay in state:");
        }
    }

    public final void stopAndPrepareAsync() {
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "stopAndPrepareAsync state: " + getStateString(this.TD));
        if (this.TD != 1 && this.TD != 2) {
            if (this.TD == 3 || this.TD == 4 || this.TD == 5 || this.TD == 6 || this.TD == 7 || this.TD == 8 || this.TD == 9) {
                try {
                    this.TE.stop();
                    this.TD = 8;
                    onPlayStateChanged(this.TD);
                    prepareAsync();
                    return;
                } catch (Exception unused) {
                }
            }
            release();
        }
    }
}

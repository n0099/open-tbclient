package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bj;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes8.dex */
public final class d extends com.kwad.sdk.core.video.kwai.a {
    public static volatile boolean adO;
    public static final Queue<d> adP = new ConcurrentLinkedQueue();
    public com.kwad.sdk.contentalliance.kwai.kwai.b JK;
    public String adG;
    public MediaDataSource adH;
    public final Object adI;
    public boolean adJ;
    public final KSVodPlayerWrapper adK;
    public final a adL;
    public boolean adM;
    public boolean adN;
    public boolean adQ;
    public int mSarDen;
    public int mSarNum;

    /* loaded from: classes8.dex */
    public static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        public final WeakReference<d> mWeakMediaPlayer;

        public a(d dVar) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
        }

        private d vA() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onBufferingUpdate(int i) {
            d vA = vA();
            if (vA != null) {
                vA.notifyOnBufferingUpdate(i);
            }
        }

        public final void onError(int i, int i2) {
            d vA = vA();
            if (vA != null) {
                d.a(vA, false);
                vA.notifyOnError(i, i2);
            }
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i, int i2) {
            com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "onEvent, what: " + i);
            d vA = vA();
            if (vA != null) {
                if (i == 10100) {
                    vA.notifyOnSeekComplete();
                } else if (i == 10101) {
                    vA.notifyOnCompletion();
                } else {
                    if (i == 10209) {
                        vA.vz();
                    }
                    vA.notifyOnInfo(i, i2);
                }
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "onPrepared");
            d vA = vA();
            if (vA != null) {
                vA.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d vA = vA();
            if (vA != null) {
                vA.n(i, i2);
                vA.mSarNum = i3;
                vA.mSarDen = i4;
            }
        }
    }

    public d(@NonNull Context context) {
        Object obj = new Object();
        this.adI = obj;
        this.adN = false;
        this.adQ = true;
        synchronized (obj) {
            this.adK = new KSVodPlayerWrapper(bj.getApplicationContext(context));
        }
        this.adL = new a(this);
        vw();
        setLooping(false);
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.adN = false;
        return false;
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.adG = str;
        this.adK.setDataSource(str, (Map) null);
    }

    private void vv() {
        MediaDataSource mediaDataSource = this.adH;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.adH = null;
        }
    }

    private void vw() {
        this.adK.setOnPreparedListener(this.adL);
        this.adK.setBufferingUpdateListener(this.adL);
        this.adK.setOnEventListener(this.adL);
        this.adK.setVideoSizeChangedListener(this.adL);
        this.adK.setOnErrorListener(this.adL);
    }

    private void vx() {
        this.adK.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.adK.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.adK.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.adK.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.adK.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    private void vy() {
        if (this.adN) {
            return;
        }
        try {
            int prepareAsync = this.adK.prepareAsync();
            com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "realPrepare: ret: " + prepareAsync);
        } catch (IllegalStateException e) {
            com.kwad.sdk.core.e.b.e("KwaiMediaPlayer", "realPrepare failed", e);
        }
        this.adN = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vz() {
        Queue<d> queue;
        Iterator<d> it = adP.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i2++;
            }
        }
        com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i2);
        int i3 = i2 + 1;
        if (i3 < adP.size()) {
            com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
            while (true) {
                queue = adP;
                if (i >= i3) {
                    break;
                }
                queue.poll();
                i++;
            }
            d poll = queue.poll();
            adP.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        if (this.adK == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.rB();
        this.adK.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        this.JK = bVar;
        a(bVar.Te);
        f fVar = (f) ServiceProvider.get(f.class);
        setDataSource((TextUtils.isEmpty(bVar.manifest) || fVar == null || !fVar.lv()) ? bVar.videoUrl : bVar.manifest, (Map<String, String>) null);
    }

    public final void aM(boolean z) {
        this.adQ = z;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getAudioSessionId() {
        return this.adK.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.adK;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getCurrentPosition() {
        try {
            return this.adK.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getDataSource() {
        return this.adG;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getDuration() {
        try {
            return this.adK.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoHeight() {
        return this.adK.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoWidth() {
        return this.adK.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isLooping() {
        return this.adM;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isPlaying() {
        try {
            return this.adK.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void pause() {
        this.adK.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean prepareAsync() {
        if (!this.adQ) {
            vy();
            return true;
        }
        if (!adP.contains(this)) {
            adP.offer(this);
        }
        if (adP.size() == 1) {
            vy();
            com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "prepareAsync first");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void release() {
        boolean remove = adP.remove(this);
        com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + adP.size());
        this.adJ = true;
        this.adK.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.kwai.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "onPlayerRelease");
            }
        });
        vv();
        resetListeners();
        vx();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void reset() {
        this.adN = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.adK.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        vv();
        resetListeners();
        vw();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void seekTo(long j) {
        this.adK.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.adI) {
            if (!this.adJ) {
                this.adK.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setLooping(boolean z) {
        this.adM = z;
        this.adK.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setSpeed(float f) {
        this.adK.setSpeed(f);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.adK.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setVolume(float f, float f2) {
        this.adK.setVolume(f, f2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void start() {
        com.kwad.sdk.core.e.b.i("KwaiMediaPlayer", "start");
        vy();
        this.adK.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void stop() {
        this.adK.stop();
    }
}

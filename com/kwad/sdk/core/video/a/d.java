package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.kwad.sdk.m.l;
import com.kwad.sdk.service.ServiceProvider;
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
/* loaded from: classes10.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    public static volatile boolean aAj;
    public static final Queue<d> aAk = new ConcurrentLinkedQueue();
    public final String TAG;
    public com.kwad.sdk.contentalliance.a.a.b TI;
    public String aAa;
    public MediaDataSource aAb;
    public final Object aAc;
    public boolean aAd;
    public final KSVodPlayerWrapper aAf;
    public final a aAg;
    public boolean aAh;
    public boolean aAi;
    public boolean aAl;
    public int mSarDen;
    public int mSarNum;

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    /* loaded from: classes10.dex */
    public static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        public final String TAG;
        public final WeakReference<d> mWeakMediaPlayer;

        public a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        public final void onError(int i, int i2) {
            d EV = EV();
            if (EV != null) {
                d.a(EV, false);
                EV.notifyOnError(i, i2);
            }
        }

        private d EV() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.e.c.i(this.TAG, "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.e.c.i(this.TAG, "onPrepared");
            d EV = EV();
            if (EV != null) {
                EV.notifyOnPrepared();
            }
        }

        public final void onBufferingUpdate(int i) {
            d EV = EV();
            if (EV != null) {
                EV.notifyOnBufferingUpdate(i);
            }
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i, int i2) {
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "onEvent, what: " + i);
            d EV = EV();
            if (EV != null) {
                if (i == 10100) {
                    EV.notifyOnSeekComplete();
                } else if (i == 10101) {
                    EV.notifyOnCompletion();
                } else {
                    if (i == 10209) {
                        EV.EU();
                    }
                    EV.notifyOnInfo(i, i2);
                }
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d EV = EV();
            if (EV != null) {
                EV.y(i, i2);
                EV.mSarNum = i3;
                EV.mSarDen = i4;
            }
        }
    }

    private void EP() {
        MediaDataSource mediaDataSource = this.aAb;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.aAb = null;
        }
    }

    private void ER() {
        this.aAf.setOnPreparedListener(this.aAg);
        this.aAf.setBufferingUpdateListener(this.aAg);
        this.aAf.setOnEventListener(this.aAg);
        this.aAf.setVideoSizeChangedListener(this.aAg);
        this.aAf.setOnErrorListener(this.aAg);
    }

    private void ES() {
        this.aAf.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aAf.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aAf.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aAf.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aAf.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean EQ() {
        com.kwad.sdk.core.e.c.i(this.TAG, "forcePrepareAsync");
        ET();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aAf.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aAf;
        if (kSVodPlayerWrapper == null) {
            return "";
        }
        return kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aAf.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aAa;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aAf.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aAf.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aAf.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aAh;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aAf.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aAf.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aAi = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aAf.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        EP();
        resetListeners();
        ER();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.e.c.i(this.TAG, "start");
        this.aAf.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aAf.stop();
    }

    public d(int i) {
        Object obj = new Object();
        this.aAc = obj;
        this.aAi = false;
        this.aAl = true;
        synchronized (obj) {
            this.aAf = new KSVodPlayerWrapper(l.My());
        }
        this.TAG = "KSMediaPlayer[" + i + PreferencesUtil.RIGHT_MOUNT;
        this.aAg = new a(this, this.TAG);
        ER();
        setLooping(false);
        com.kwad.sdk.core.e.c.i(this.TAG, "create KwaiMediaPlayer");
    }

    private void ET() {
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "realPrepare hasCallPrepare: " + this.aAi);
        if (this.aAi) {
            return;
        }
        try {
            this.aAi = true;
            int prepareAsync = this.aAf.prepareAsync();
            EO();
            String str2 = this.TAG;
            com.kwad.sdk.core.e.c.i(str2, "realPrepare result: " + prepareAsync);
        } catch (IllegalStateException e) {
            com.kwad.sdk.core.e.c.e(this.TAG, "realPrepare failed ", e);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        if (this.aAl) {
            if (!aAk.contains(this)) {
                aAk.offer(this);
            }
            int size = aAk.size();
            if (size == 1) {
                com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync first");
                ET();
                return true;
            }
            String str = this.TAG;
            com.kwad.sdk.core.e.c.i(str, "prepareAsync pending size: " + size);
            return false;
        }
        ET();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        boolean remove = aAk.remove(this);
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "release remote player ret: " + remove + ", player list size: " + aAk.size());
        this.aAd = true;
        this.aAf.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.e.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        EP();
        resetListeners();
        ES();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EU() {
        Iterator<d> it = aAk.iterator();
        int i = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next() == this) {
                    break;
                }
                i++;
            } else {
                i = 0;
                break;
            }
        }
        String str = this.TAG;
        com.kwad.sdk.core.e.c.i(str, "preloadNextPlayer next player index: " + i);
        int i2 = i + 1;
        if (i2 < aAk.size()) {
            com.kwad.sdk.core.e.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i3 = 0; i3 < i2; i3++) {
                aAk.poll();
            }
            d poll = aAk.poll();
            aAk.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                com.kwad.sdk.core.e.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.aAa = str;
        this.aAf.setDataSource(str, (Map) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.aAf.setVolume(f, f2);
        com.kwad.sdk.core.video.a.a.f(f);
    }

    public final void bn(boolean z) {
        this.aAl = z;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        this.aAf.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aAc) {
            if (!this.aAd) {
                this.aAf.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.aAh = z;
        this.aAf.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        this.aAf.setSpeed(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aAf.setSurface(surface);
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.aAi = false;
        return false;
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.aAf != null && aVar != null) {
            KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
            kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
            kSVodVideoContext.mClickTime = aVar.clickTime;
            kSVodVideoContext.mExtra = aVar.Ag();
            this.aAf.updateVideoContext(kSVodVideoContext);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.TI = bVar;
        a(bVar.aoi);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.tr()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }
}

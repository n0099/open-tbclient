package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.ksvodplayerkit.Logger.KSVodPlayerLogUploader;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public final class d extends com.kwad.sdk.core.video.kwai.a {
    public static volatile boolean k;
    public static final Queue<d> l = new ConcurrentLinkedQueue();
    public final KSVodPlayerWrapper a;
    public final a b;
    public String c;
    public MediaDataSource d;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public com.kwad.sdk.contentalliance.kwai.kwai.b n;
    public final Object e = new Object();
    public boolean j = false;
    public boolean m = true;

    /* loaded from: classes5.dex */
    public static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        public final WeakReference<d> a;

        public a(d dVar) {
            this.a = new WeakReference<>(dVar);
        }

        private d a() {
            return this.a.get();
        }

        public final void onBufferingUpdate(int i) {
            d a = a();
            if (a != null) {
                a.a(i);
            }
        }

        public final void onError(int i, int i2) {
            d a = a();
            if (a != null) {
                a.j = false;
                a.b(i, i2);
            }
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i, int i2) {
            com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "onEvent, what: " + i);
            d a = a();
            if (a == null || i == 10100) {
                return;
            }
            if (i == 10101) {
                a.c();
                return;
            }
            if (i == 10209) {
                a.q();
            }
            a.c(i, i2);
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "onPrepared");
            d a = a();
            if (a != null) {
                a.b();
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d a = a();
            if (a != null) {
                a.a(i, i2);
                a.h = i3;
                a.i = i4;
            }
        }
    }

    public d(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        synchronized (this.e) {
            this.a = new KSVodPlayerWrapper(applicationContext);
        }
        a(context);
        this.b = new a(this);
        o();
        a(false);
    }

    public static synchronized void a(@NonNull Context context) {
        synchronized (d.class) {
            com.kwad.sdk.core.d.b.a("KwaiMediaPlayer", "initConfigSync has init =" + k);
            if (!k) {
                KSVodPlayerCoreInitConfig.init(context);
                f fVar = (f) ServiceProvider.a(f.class);
                if (fVar != null && fVar.c()) {
                    KSVodPlayerLogUploader.setLogger(new KSVodPlayerLogUploader.ILogger() { // from class: com.kwad.sdk.core.video.kwai.d.1
                        public final void logTaskEvent(String str, String str2) {
                            com.kwad.sdk.core.video.kwai.kwai.a.a(str, str2);
                        }
                    });
                }
                k = true;
            }
        }
    }

    private void a(String str, Map<String, String> map) {
        this.c = str;
        this.a.setDataSource(str, (Map) null);
    }

    private void m() {
        MediaDataSource mediaDataSource = this.d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.d = null;
        }
    }

    private void n() {
        if (this.j) {
            return;
        }
        try {
            int prepareAsync = this.a.prepareAsync();
            com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "realPrepare: ret: " + prepareAsync);
        } catch (IllegalStateException e) {
            com.kwad.sdk.core.d.b.a("KwaiMediaPlayer", "realPrepare failed", e);
        }
        this.j = true;
    }

    private void o() {
        this.a.setOnPreparedListener(this.b);
        this.a.setBufferingUpdateListener(this.b);
        this.a.setOnEventListener(this.b);
        this.a.setVideoSizeChangedListener(this.b);
        this.a.setOnErrorListener(this.b);
    }

    private void p() {
        this.a.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.a.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.a.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.a.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.a.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Queue<d> queue;
        Iterator<d> it = l.iterator();
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
        com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i2);
        int i3 = i2 + 1;
        if (i3 < l.size()) {
            com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
            while (true) {
                queue = l;
                if (i >= i3) {
                    break;
                }
                queue.poll();
                i++;
            }
            d poll = queue.poll();
            l.clear();
            if (poll != null) {
                poll.d();
            } else {
                com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(float f, float f2) {
        this.a.setVolume(f, f2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(long j) {
        this.a.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void a(Surface surface) {
        this.a.setSurface(surface);
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        if (this.a == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.a);
        kSVodVideoContext.mClickTime = aVar.b;
        kSVodVideoContext.mExtra = aVar.a();
        this.a.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        this.n = bVar;
        a(bVar.e);
        f fVar = (f) ServiceProvider.a(f.class);
        a((TextUtils.isEmpty(bVar.c) || fVar == null || !fVar.d()) ? bVar.b : bVar.c, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(boolean z) {
        this.g = z;
        this.a.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void b(int i) {
    }

    public final void b(boolean z) {
        this.m = z;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean d() {
        if (!this.m) {
            n();
            return true;
        }
        if (!l.contains(this)) {
            l.offer(this);
        }
        if (l.size() == 1) {
            n();
            com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "prepareAsync first");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void e() {
        com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "start");
        n();
        this.a.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void f() {
        this.a.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long g() {
        try {
            return this.a.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long h() {
        try {
            return this.a.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void i() {
        boolean remove = l.remove(this);
        com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + l.size());
        this.f = true;
        this.a.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.kwai.d.2
            public final void onPlayerRelease() {
                com.kwad.sdk.core.d.b.c("KwaiMediaPlayer", "onPlayerRelease");
            }
        });
        m();
        a();
        p();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void j() {
        this.j = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.a.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        m();
        a();
        o();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean k() {
        return this.g;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int l() {
        return 2;
    }
}

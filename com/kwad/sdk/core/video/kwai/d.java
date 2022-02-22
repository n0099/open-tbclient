package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ay;
import com.kwai.video.ksvodplayerkit.CacheListener;
import com.kwai.video.ksvodplayerkit.CacheReceipt;
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
/* loaded from: classes4.dex */
public class d extends com.kwad.sdk.core.video.kwai.a {
    public static volatile boolean k;
    public static final Queue<d> l = new ConcurrentLinkedQueue();
    public final KSVodPlayerWrapper a;

    /* renamed from: b  reason: collision with root package name */
    public final a f56436b;

    /* renamed from: c  reason: collision with root package name */
    public String f56437c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f56438d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56440f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56441g;

    /* renamed from: h  reason: collision with root package name */
    public int f56442h;

    /* renamed from: i  reason: collision with root package name */
    public int f56443i;
    public com.kwad.sdk.contentalliance.detail.video.c n;

    /* renamed from: e  reason: collision with root package name */
    public final Object f56439e = new Object();

    /* renamed from: j  reason: collision with root package name */
    public boolean f56444j = false;
    public boolean m = true;

    /* loaded from: classes4.dex */
    public static class a implements CacheListener, IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        public final WeakReference<d> a;

        public a(d dVar) {
            this.a = new WeakReference<>(dVar);
        }

        private d a() {
            return this.a.get();
        }

        public void onBufferingUpdate(int i2) {
            d a = a();
            if (a != null) {
                a.a(i2);
            }
        }

        public void onCancelled(@Nullable CacheReceipt cacheReceipt) {
        }

        public void onCompleted(@Nullable CacheReceipt cacheReceipt) {
        }

        public void onError(int i2, int i3) {
            d a = a();
            if (a != null) {
                a.f56444j = false;
                a.b(i2, i3);
            }
        }

        public void onEvent(@KSVodConstants.KSVodPlayerEventType int i2, int i3) {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onEvent, what: " + i2);
            d a = a();
            if (a != null) {
                if (i2 == 10100) {
                    a.d();
                } else if (i2 == 10101) {
                    a.c();
                } else {
                    if (i2 == 10209) {
                        a.t();
                    }
                    a.c(i2, i3);
                }
            }
        }

        public void onFailed(@Nullable CacheReceipt cacheReceipt) {
        }

        public void onFragmentCompleted(@Nullable CacheReceipt cacheReceipt) {
            if (ay.a().b()) {
                d a = a();
                if (a != null) {
                    a.a.setCacheSessionListener((CacheListener) null);
                }
            } else if (cacheReceipt == null || cacheReceipt.mBytesReadFromSource <= 0 || cacheReceipt.mReadSourceTimeCostMills == 0) {
            } else {
                ay.a().a((cacheReceipt.mBytesReadFromSource - cacheReceipt.mInitAvailableBytesOfCache) / cacheReceipt.mReadSourceTimeCostMills);
            }
        }

        public void onPlayerRelease() {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPlayerRelease");
        }

        public void onPrepared() {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPrepared");
            d a = a();
            if (a != null) {
                a.b();
            }
        }

        public void onProgress(@Nullable CacheReceipt cacheReceipt) {
        }

        public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onVideoSizeChanged width: " + i2 + ", height: " + i3 + ", sarNum:" + i4 + ", sarDen:" + i5);
            d a = a();
            if (a != null) {
                a.a(i2, i3);
                a.f56442h = i4;
                a.f56443i = i5;
            }
        }
    }

    public d(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        synchronized (this.f56439e) {
            this.a = new KSVodPlayerWrapper(applicationContext);
        }
        a(context);
        this.f56436b = new a(this);
        r();
        a(false);
    }

    public static synchronized void a(@NonNull Context context) {
        synchronized (d.class) {
            com.kwad.sdk.core.d.a.a("KwaiMediaPlayer", "initConfigSync has init =" + k);
            if (!k) {
                KSVodPlayerCoreInitConfig.init(context);
                if (com.kwad.sdk.core.config.b.m()) {
                    KSVodPlayerLogUploader.setLogger(new KSVodPlayerLogUploader.ILogger() { // from class: com.kwad.sdk.core.video.kwai.d.1
                        public void logTaskEvent(String str, String str2) {
                            com.kwad.sdk.core.video.kwai.kwai.a.a(str, str2);
                        }
                    });
                }
                k = true;
            }
        }
    }

    private void p() {
        MediaDataSource mediaDataSource = this.f56438d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f56438d = null;
        }
    }

    private void q() {
        if (this.f56444j) {
            return;
        }
        try {
            int prepareAsync = this.a.prepareAsync();
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "realPrepare: ret: " + prepareAsync);
        } catch (IllegalStateException e2) {
            com.kwad.sdk.core.d.a.a("KwaiMediaPlayer", "realPrepare failed", e2);
        }
        this.f56444j = true;
    }

    private void r() {
        this.a.setOnPreparedListener(this.f56436b);
        this.a.setBufferingUpdateListener(this.f56436b);
        this.a.setOnEventListener(this.f56436b);
        this.a.setVideoSizeChangedListener(this.f56436b);
        this.a.setOnErrorListener(this.f56436b);
        if (com.kwad.sdk.core.config.b.u()) {
            this.a.setCacheSessionListener(this.f56436b);
        }
    }

    private void s() {
        this.a.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.a.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.a.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.a.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.a.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
        this.a.setCacheSessionListener((CacheListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Queue<d> queue;
        Iterator<d> it = l.iterator();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i3++;
            }
        }
        com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i3);
        int i4 = i3 + 1;
        if (i4 < l.size()) {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
            while (true) {
                queue = l;
                if (i2 >= i4) {
                    break;
                }
                queue.poll();
                i2++;
            }
            d poll = queue.poll();
            l.clear();
            if (poll != null) {
                poll.e();
            } else {
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(float f2, float f3) {
        this.a.setVolume(f2, f3);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(long j2) {
        this.a.seekTo((int) j2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.a.setSurface(surface);
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.b bVar) {
        if (this.a == null || bVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(bVar.a);
        kSVodVideoContext.mClickTime = bVar.f55789b;
        kSVodVideoContext.mExtra = bVar.a();
        this.a.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        this.n = cVar;
        a(cVar.f55795e);
        a((TextUtils.isEmpty(cVar.f55793c) || !com.kwad.sdk.core.config.b.A()) ? cVar.f55792b : cVar.f55793c, (Map<String, String>) null);
    }

    public void a(String str, Map<String, String> map) {
        this.f56437c = str;
        this.a.setDataSource(str, map);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void a(boolean z) {
        this.f56441g = z;
        this.a.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void b(int i2) {
    }

    public void b(boolean z) {
        this.m = z;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public boolean e() {
        if (!this.m) {
            q();
            return true;
        }
        if (!l.contains(this)) {
            l.offer(this);
        }
        if (l.size() == 1) {
            q();
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "prepareAsync first");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void f() {
        com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "start");
        q();
        this.a.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void g() {
        this.a.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int h() {
        return this.a.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int i() {
        return this.a.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public long j() {
        try {
            return this.a.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public long k() {
        try {
            return this.a.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void l() {
        boolean remove = l.remove(this);
        com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + l.size());
        this.f56440f = true;
        this.a.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.kwai.d.2
            public void onPlayerRelease() {
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPlayerRelease");
            }
        });
        p();
        a();
        s();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public void m() {
        this.f56444j = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.a.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        p();
        a();
        r();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public boolean n() {
        return this.f56441g;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public int o() {
        return 2;
    }
}

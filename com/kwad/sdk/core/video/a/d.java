package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.kwad.sdk.utils.al;
import com.kwai.video.ksvodplayerkit.CacheListener;
import com.kwai.video.ksvodplayerkit.CacheReceipt;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.ksvodplayerkit.Logger.KSVodPlayerLogUploader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.core.video.a.a {
    public static volatile boolean k = false;
    public static final Queue<d> l = new ConcurrentLinkedQueue();

    /* renamed from: a  reason: collision with root package name */
    public final KSVodPlayerWrapper f32729a;

    /* renamed from: b  reason: collision with root package name */
    public final a f32730b;

    /* renamed from: c  reason: collision with root package name */
    public String f32731c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f32732d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32734f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32735g;

    /* renamed from: h  reason: collision with root package name */
    public int f32736h;

    /* renamed from: i  reason: collision with root package name */
    public int f32737i;
    public com.kwad.sdk.contentalliance.detail.video.c n;

    /* renamed from: e  reason: collision with root package name */
    public final Object f32733e = new Object();
    public boolean j = false;
    public boolean m = true;

    /* loaded from: classes6.dex */
    public static class a implements CacheListener, IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f32739a;

        public a(d dVar) {
            this.f32739a = new WeakReference<>(dVar);
        }

        private d a() {
            return this.f32739a.get();
        }

        public void onBufferingUpdate(int i2) {
            d a2 = a();
            if (a2 != null) {
                a2.a(i2);
            }
        }

        public void onCancelled(@Nullable CacheReceipt cacheReceipt) {
        }

        public void onCompleted(@Nullable CacheReceipt cacheReceipt) {
        }

        public void onError(int i2, int i3) {
            d a2 = a();
            if (a2 != null) {
                a2.j = false;
                a2.b(i2, i3);
            }
        }

        public void onEvent(@KSVodConstants.KSVodPlayerEventType int i2, int i3) {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onEvent, what: " + i2);
            d a2 = a();
            if (a2 != null) {
                if (i2 == 10100) {
                    a2.d();
                } else if (i2 == 10101) {
                    a2.c();
                } else {
                    if (i2 == 10209) {
                        a2.s();
                    }
                    a2.c(i2, i3);
                }
            }
        }

        public void onFailed(@Nullable CacheReceipt cacheReceipt) {
        }

        public void onFragmentCompleted(@Nullable CacheReceipt cacheReceipt) {
            if (al.a().b()) {
                d a2 = a();
                if (a2 != null) {
                    a2.f32729a.setCacheSessionListener((CacheListener) null);
                }
            } else if (cacheReceipt == null || cacheReceipt.mBytesReadFromSource <= 0 || cacheReceipt.mReadSourceTimeCostMills == 0) {
            } else {
                al.a().a((cacheReceipt.mBytesReadFromSource - cacheReceipt.mInitAvailableBytesOfCache) / cacheReceipt.mReadSourceTimeCostMills);
            }
        }

        public void onPlayerRelease() {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPlayerRelease");
        }

        public void onPrepared() {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPrepared");
            d a2 = a();
            if (a2 != null) {
                a2.b();
            }
        }

        public void onProgress(@Nullable CacheReceipt cacheReceipt) {
        }

        public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onVideoSizeChanged width: " + i2 + ", height: " + i3 + ", sarNum:" + i4 + ", sarDen:" + i5);
            d a2 = a();
            if (a2 != null) {
                a2.a(i2, i3);
                a2.f32736h = i4;
                a2.f32737i = i5;
            }
        }
    }

    public d(@NonNull Context context) {
        Context applicationContext = context.getApplicationContext();
        synchronized (this.f32733e) {
            this.f32729a = new KSVodPlayerWrapper(applicationContext);
        }
        a(applicationContext);
        this.f32730b = new a(this);
        q();
    }

    public static synchronized void a(@NonNull Context context) {
        synchronized (d.class) {
            com.kwad.sdk.core.d.a.a("KwaiMediaPlayer", "initConfigSync has init =" + k);
            if (!k) {
                KSVodPlayerCoreInitConfig.init(context);
                if (com.kwad.sdk.core.config.c.m()) {
                    KSVodPlayerLogUploader.setLogger(new KSVodPlayerLogUploader.ILogger() { // from class: com.kwad.sdk.core.video.a.d.1
                        public void logTaskEvent(String str, String str2) {
                            com.kwad.sdk.core.video.a.a.a.a(str, str2);
                        }
                    });
                }
                k = true;
            }
        }
    }

    private void o() {
        MediaDataSource mediaDataSource = this.f32732d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f32732d = null;
        }
    }

    private void p() {
        if (this.j) {
            return;
        }
        int prepareAsync = this.f32729a.prepareAsync();
        com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "realPrepare: ret: " + prepareAsync);
        this.j = true;
    }

    private void q() {
        this.f32729a.setOnPreparedListener(this.f32730b);
        this.f32729a.setBufferingUpdateListener(this.f32730b);
        this.f32729a.setOnEventListener(this.f32730b);
        this.f32729a.setVideoSizeChangedListener(this.f32730b);
        this.f32729a.setOnErrorListener(this.f32730b);
        if (com.kwad.sdk.core.config.c.r()) {
            this.f32729a.setCacheSessionListener(this.f32730b);
        }
    }

    private void r() {
        this.f32729a.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.f32729a.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.f32729a.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.f32729a.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.f32729a.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
        this.f32729a.setCacheSessionListener((CacheListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
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

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2, float f3) {
        this.f32729a.setVolume(f2, f3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        this.f32729a.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.f32729a.setSurface(surface);
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.b bVar) {
        if (this.f32729a == null || bVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(bVar.f32026a);
        kSVodVideoContext.mClickTime = bVar.f32027b;
        this.f32729a.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        this.n = cVar;
        a(cVar.f32031d);
        a((TextUtils.isEmpty(cVar.f32029b) || !com.kwad.sdk.core.config.c.w()) ? cVar.f32028a : cVar.f32029b, (Map<String, String>) null);
    }

    public void a(String str, Map<String, String> map) {
        this.f32731c = str;
        this.f32729a.setDataSource(str, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        this.f32735g = z;
        this.f32729a.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void b(int i2) {
    }

    public void b(boolean z) {
        this.m = z;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean e() {
        if (!this.m) {
            p();
            return true;
        }
        if (!l.contains(this)) {
            l.offer(this);
        }
        if (l.size() == 1) {
            p();
            com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "prepareAsync first");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void f() {
        com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", IntentConfig.START);
        p();
        this.f32729a.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        this.f32729a.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        return this.f32729a.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        return this.f32729a.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long j() {
        try {
            return this.f32729a.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        try {
            return this.f32729a.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void l() {
        boolean remove = l.remove(this);
        com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + l.size());
        this.f32734f = true;
        this.f32729a.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.2
            public void onPlayerRelease() {
                com.kwad.sdk.core.d.a.c("KwaiMediaPlayer", "onPlayerRelease");
            }
        });
        o();
        a();
        r();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        this.j = false;
        try {
            this.f32729a.getKwaiMediaPlayer().reset();
        } catch (IllegalStateException unused) {
        }
        o();
        a();
        q();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int n() {
        return 2;
    }
}

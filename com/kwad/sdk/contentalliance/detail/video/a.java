package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.video.a.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {
    private com.kwad.sdk.core.video.a.c c;
    private Surface d;
    private int e;
    private long f;
    private Timer g;
    private TimerTask h;
    private DetailVideoView j;
    private WeakReference<DetailVideoView> k;
    private int l;
    private int m;
    private d o;

    /* renamed from: a  reason: collision with root package name */
    private String f8590a = "MediaPlayerImpl";

    /* renamed from: b  reason: collision with root package name */
    private int f8591b = 0;
    private Handler i = new Handler(Looper.getMainLooper());
    private long n = 0;
    private int p = 0;
    private List<c.d> q = new CopyOnWriteArrayList();
    private volatile List<c.e> r = new CopyOnWriteArrayList();
    private c.e s = new c.e() { // from class: com.kwad.sdk.contentalliance.detail.video.a.1
        @Override // com.kwad.sdk.core.video.a.c.e
        public void a(com.kwad.sdk.core.video.a.c cVar) {
            com.kwad.sdk.core.d.a.b(a.this.f8590a, "onPrepared:" + a.this.b(a.this.f8591b) + "->STATE_PREPARED");
            a.this.f8591b = 2;
            a.this.a(a.this.f8591b);
            for (c.e eVar : a.this.r) {
                eVar.a(a.this.c);
            }
        }
    };
    private c.h t = new c.h() { // from class: com.kwad.sdk.contentalliance.detail.video.a.2
        @Override // com.kwad.sdk.core.video.a.c.h
        public void a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
            DetailVideoView detailVideoView = (DetailVideoView) a.this.k.get();
            if (detailVideoView != null) {
                detailVideoView.a(i, i2);
            }
            com.kwad.sdk.core.d.a.b(a.this.f8590a, "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
        }
    };
    private c.b u = new c.b() { // from class: com.kwad.sdk.contentalliance.detail.video.a.3
        @Override // com.kwad.sdk.core.video.a.c.b
        public void a(com.kwad.sdk.core.video.a.c cVar) {
            a.this.f8591b = 9;
            a.this.a(a.this.f8591b);
            com.kwad.sdk.core.d.a.b(a.this.f8590a, "onCompletion ——> STATE_COMPLETED");
            DetailVideoView detailVideoView = (DetailVideoView) a.this.k.get();
            if (detailVideoView != null) {
                detailVideoView.setKeepScreenOn(true);
            }
        }
    };
    private c.InterfaceC1104c v = new c.InterfaceC1104c() { // from class: com.kwad.sdk.contentalliance.detail.video.a.4
        @Override // com.kwad.sdk.core.video.a.c.InterfaceC1104c
        public boolean a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
            if (i != -38) {
                a.this.f8591b = -1;
                a.this.l = i;
                a.this.m = i2;
                a.this.a(a.this.f8591b);
                com.kwad.sdk.core.d.a.b(a.this.f8590a, "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                return true;
            }
            return true;
        }
    };
    private c.d w = new c.d() { // from class: com.kwad.sdk.contentalliance.detail.video.a.5
        @Override // com.kwad.sdk.core.video.a.c.d
        public boolean a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
            if (i == 3) {
                a.this.f8591b = 4;
                a.this.a(a.this.f8591b);
                com.kwad.sdk.core.d.a.b(a.this.f8590a, "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: " + (System.currentTimeMillis() - a.this.n));
            } else if (i == 701) {
                if (a.this.f8591b == 5 || a.this.f8591b == 7) {
                    a.this.f8591b = 7;
                    com.kwad.sdk.core.d.a.b(a.this.f8590a, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                } else {
                    a.this.f8591b = 6;
                    com.kwad.sdk.core.d.a.b(a.this.f8590a, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                }
                a.this.a(a.this.f8591b);
            } else if (i == 702) {
                if (a.this.f8591b == 6) {
                    a.this.f8591b = 4;
                    a.this.a(a.this.f8591b);
                    com.kwad.sdk.core.d.a.b(a.this.f8590a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                }
                if (a.this.f8591b == 7) {
                    a.this.f8591b = 5;
                    a.this.a(a.this.f8591b);
                    com.kwad.sdk.core.d.a.b(a.this.f8590a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                }
            } else if (i != 10001) {
                if (i == 801) {
                    com.kwad.sdk.core.d.a.b(a.this.f8590a, "视频不能seekTo，为直播视频");
                } else {
                    com.kwad.sdk.core.d.a.b(a.this.f8590a, "onInfo ——> what：" + i);
                }
            }
            a.this.a(a.this.c, i, i2);
            return true;
        }
    };
    private c.a x = new c.a() { // from class: com.kwad.sdk.contentalliance.detail.video.a.6
        @Override // com.kwad.sdk.core.video.a.c.a
        public void a(com.kwad.sdk.core.video.a.c cVar, int i) {
            a.this.e = i;
        }
    };
    private volatile List<e> y = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kwad.sdk.contentalliance.detail.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1077a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f8600a;

        C1077a(a aVar) {
            this.f8600a = new WeakReference<>(aVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar = this.f8600a.get();
            if (aVar != null) {
                aVar.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f8601a;

        c(a aVar) {
            this.f8601a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f8601a.get();
            if (aVar != null) {
                long o = aVar.o();
                long n = aVar.n();
                for (e eVar : aVar.y) {
                    eVar.a(n, o);
                }
            }
        }
    }

    public a(DetailVideoView detailVideoView) {
        this.j = detailVideoView;
        this.k = new WeakReference<>(detailVideoView);
    }

    public static com.kwad.sdk.core.video.a.c a(@NonNull Context context, boolean z) {
        com.kwad.sdk.core.video.a.c bVar;
        try {
            if (com.kwad.sdk.core.video.a.e.b() && com.kwad.sdk.core.config.c.p() && com.kwad.sdk.core.video.a.e.a()) {
                com.kwad.sdk.core.d.a.b("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                bVar = new com.kwad.sdk.core.video.a.d(context);
                ((com.kwad.sdk.core.video.a.d) bVar).b(z);
            } else {
                com.kwad.sdk.core.d.a.b("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                bVar = new com.kwad.sdk.core.video.a.b();
            }
            return bVar;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            return new com.kwad.sdk.core.video.a.b();
        }
    }

    private void c(int i) {
        if (this.o == null || this.o.f8612b == null) {
            return;
        }
        this.o.f8612b.mVideoPlayerType = i;
    }

    private void q() {
        if (this.c == null) {
            return;
        }
        this.c.a((c.InterfaceC1104c) null);
        this.c.a((c.b) null);
        this.c.a((c.e) null);
        this.c.a((c.d) null);
        this.c.a((c.f) null);
        this.c.a((c.a) null);
    }

    private void r() {
        com.kwad.sdk.core.d.a.b(this.f8590a, "reset:" + b(this.f8591b) + "->STATE_IDLE");
        this.c.n();
        this.f8591b = 0;
    }

    private void s() {
        t();
        if (this.g == null) {
            this.g = new Timer();
        }
        if (this.h == null) {
            this.h = new C1077a(this);
            this.g.schedule(this.h, 0L, 1000L);
        }
    }

    private void t() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
        if (this.h != null) {
            this.h.cancel();
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.i.post(new c(this));
    }

    public com.kwad.sdk.core.video.a.c a() {
        return this.c;
    }

    public void a(float f) {
        if (this.c == null) {
            return;
        }
        this.c.a(f);
    }

    public void a(float f, float f2) {
        if (this.c == null) {
            return;
        }
        this.c.a(f, f2);
    }

    public void a(int i) {
        if (this.y == null) {
            return;
        }
        for (e eVar : this.y) {
            if (eVar != null) {
                switch (i) {
                    case -1:
                        t();
                        eVar.a(this.l, this.m);
                        continue;
                    case 1:
                        eVar.e();
                        continue;
                    case 2:
                        eVar.h();
                        continue;
                    case 3:
                        eVar.b();
                        continue;
                    case 4:
                        eVar.d();
                        continue;
                    case 5:
                        eVar.c();
                        continue;
                    case 6:
                        eVar.g();
                        continue;
                    case 7:
                        eVar.f();
                        continue;
                    case 9:
                        t();
                        eVar.a();
                        continue;
                }
            }
        }
    }

    public void a(long j) {
        if (this.c != null) {
            this.c.a(j);
        }
    }

    public void a(Surface surface) {
        this.d = surface;
        if (this.c != null) {
            this.c.a(surface);
        }
    }

    public void a(final b bVar) {
        if (this.c == null) {
            return;
        }
        this.j.setKeepScreenOn(false);
        this.i.removeCallbacksAndMessages(null);
        t();
        q();
        if (this.c != null) {
            final com.kwad.sdk.core.video.a.c cVar = this.c;
            com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.video.a.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        cVar.m();
                        if (bVar != null) {
                            bVar.a();
                        }
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.a.a(th);
                    }
                }
            });
            this.c = null;
        }
        com.kwad.sdk.core.d.a.b(this.f8590a, "release:" + b(this.f8591b) + "->STATE_IDLE");
        this.f8591b = 0;
        this.p = 0;
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        if (this.c instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) this.c).a(cVar);
        }
    }

    public void a(@NonNull d dVar) {
        com.kwad.sdk.core.d.a.b(this.f8590a, "initMediaPlayer");
        this.o = dVar;
        this.d = this.j.f8588b;
        this.j.setMediaPlayer(this);
        this.c = a(this.j.getContext(), true);
        b(dVar);
        this.c.a(false);
        this.c.a(this.d);
        this.c.b(3);
        if (this.c instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) this.c).a(this.j);
        }
        c();
    }

    public void a(e eVar) {
        this.y.add(eVar);
    }

    public void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.q.add(dVar);
    }

    public void a(c.e eVar) {
        this.r.add(eVar);
    }

    public void a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
        Iterator<c.d> it = this.q.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.a(cVar, i, i2);
            }
        }
    }

    public int b() {
        return this.c.o();
    }

    public String b(int i) {
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

    public void b(@NonNull d dVar) {
        try {
            if (TextUtils.isEmpty(dVar.f8611a)) {
                com.kwad.sdk.core.d.a.d(this.f8590a, "videoUrl is null");
            } else {
                this.c.a(dVar);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    public void b(e eVar) {
        this.y.remove(eVar);
    }

    public void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.q.remove(dVar);
    }

    protected void c() {
        this.c.a(this.s);
        this.c.a(this.t);
        this.c.a(this.u);
        this.c.a(this.v);
        this.c.a(this.w);
        this.c.a(this.x);
    }

    public void c(d dVar) {
        if (this.c == null) {
            com.kwad.sdk.core.d.a.c("resetAndPlay", "mMediaPlayer is null");
        } else if (this.f8591b == 2 || this.f8591b == 3 || this.f8591b == 4 || this.f8591b == 5) {
            com.kwad.sdk.core.d.a.c("resetAndPlay", "can not resetAndPlay in sate:" + this.f8591b);
        } else {
            r();
            b(dVar);
            q();
            c();
            e();
        }
    }

    public boolean d() {
        return this.f8591b == 1;
    }

    public void e() {
        this.j.setKeepScreenOn(true);
        try {
            if (this.c.e()) {
                com.kwad.sdk.core.d.a.b(this.f8590a, "prepareAsync:" + b(this.f8591b) + "->STATE_PREPARING");
                this.f8591b = 1;
                a(this.f8591b);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(this.f8590a, "prepareAsync Exception:" + b(this.f8591b));
            com.kwad.sdk.core.d.a.a(e);
            if (b() != 2) {
                int i = this.p;
                this.p = i + 1;
                if (i <= 4) {
                    c(this.o);
                }
            }
        }
    }

    public void f() {
        if (this.f8591b == 0) {
            com.kwad.sdk.core.d.a.b(this.f8590a, "start, still not prepared well, prepare again");
            e();
            if (b() == 2) {
                this.c.f();
            }
        } else if (this.f8591b == 2 || this.f8591b == 9) {
            this.n = System.currentTimeMillis();
            this.c.f();
            if (this.f != 0) {
                this.c.a((int) this.f);
            }
            com.kwad.sdk.core.d.a.b(this.f8590a, "start:" + b(this.f8591b) + "->STATE_STARTED");
            if (this.o != null && this.o.f8612b != null) {
                if (this.f8591b == 2) {
                    if (this.o.f8612b.mVideoPlayerType == 0) {
                        c(1);
                    } else {
                        c(3);
                    }
                } else if (this.f8591b == 9) {
                    c(3);
                }
            }
            this.f8591b = 3;
            a(this.f8591b);
            s();
        }
    }

    public void g() {
        if (this.c != null && this.f8591b == 9) {
            f();
        }
        c(3);
    }

    public void h() {
        if (this.c == null) {
            return;
        }
        if (this.f8591b == 2 || this.f8591b == 0) {
            com.kwad.sdk.core.d.a.b(this.f8590a, "resume:" + b(this.f8591b) + "->start()");
            f();
        } else if (this.f8591b == 5) {
            this.c.f();
            com.kwad.sdk.core.d.a.b(this.f8590a, "resume:" + b(this.f8591b) + "->STATE_PLAYING");
            this.f8591b = 4;
            a(this.f8591b);
            c(2);
        } else if (this.f8591b == 7) {
            this.c.f();
            com.kwad.sdk.core.d.a.b(this.f8590a, "resume:" + b(this.f8591b) + "->STATE_BUFFERING_PLAYING");
            this.f8591b = 6;
            a(this.f8591b);
        }
    }

    public boolean i() {
        if (this.c != null) {
            return this.c.j();
        }
        return false;
    }

    public void j() {
        if (this.f8591b == 4) {
            this.c.g();
            com.kwad.sdk.core.d.a.b(this.f8590a, "pause STATE_PLAYING->STATE_PAUSED");
            this.f8591b = 5;
            a(this.f8591b);
        }
        if (this.f8591b == 6) {
            this.c.g();
            com.kwad.sdk.core.d.a.b(this.f8590a, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.f8591b = 7;
            a(this.f8591b);
        }
        if (this.f8591b == 3) {
            this.c.g();
            com.kwad.sdk.core.d.a.b(this.f8590a, "pause STATE_STARTED->STATE_PAUSED");
            this.f8591b = 5;
            a(this.f8591b);
        }
    }

    public void k() {
        a((b) null);
    }

    public int l() {
        if (this.c != null) {
            return this.c.h();
        }
        return 0;
    }

    public int m() {
        if (this.c != null) {
            return this.c.i();
        }
        return 0;
    }

    public long n() {
        if (this.c != null) {
            return this.c.l();
        }
        return 0L;
    }

    public long o() {
        if (this.c != null) {
            return this.c.k();
        }
        return 0L;
    }

    public void p() {
        this.y.clear();
    }
}

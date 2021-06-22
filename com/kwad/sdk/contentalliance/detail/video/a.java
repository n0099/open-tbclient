package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.video.a.c f33186c;

    /* renamed from: d  reason: collision with root package name */
    public Surface f33187d;

    /* renamed from: e  reason: collision with root package name */
    public int f33188e;

    /* renamed from: f  reason: collision with root package name */
    public long f33189f;

    /* renamed from: g  reason: collision with root package name */
    public Timer f33190g;

    /* renamed from: h  reason: collision with root package name */
    public TimerTask f33191h;
    public DetailVideoView j;
    public WeakReference<DetailVideoView> k;
    public int l;
    public int m;
    public d o;

    /* renamed from: a  reason: collision with root package name */
    public String f33184a = "MediaPlayerImpl";

    /* renamed from: b  reason: collision with root package name */
    public int f33185b = 0;

    /* renamed from: i  reason: collision with root package name */
    public Handler f33192i = new Handler(Looper.getMainLooper());
    public long n = 0;
    public int p = 0;
    public List<c.d> q = new CopyOnWriteArrayList();
    public volatile List<c.e> r = new CopyOnWriteArrayList();
    public c.e s = new c.e() { // from class: com.kwad.sdk.contentalliance.detail.video.a.1
        @Override // com.kwad.sdk.core.video.a.c.e
        public void a(com.kwad.sdk.core.video.a.c cVar) {
            String str = a.this.f33184a;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrepared:");
            a aVar = a.this;
            sb.append(aVar.b(aVar.f33185b));
            sb.append("->STATE_PREPARED");
            com.kwad.sdk.core.d.a.b(str, sb.toString());
            a.this.f33185b = 2;
            a aVar2 = a.this;
            aVar2.a(aVar2.f33185b);
            for (c.e eVar : a.this.r) {
                eVar.a(a.this.f33186c);
            }
        }
    };
    public c.h t = new c.h() { // from class: com.kwad.sdk.contentalliance.detail.video.a.2
        @Override // com.kwad.sdk.core.video.a.c.h
        public void a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
            DetailVideoView detailVideoView = (DetailVideoView) a.this.k.get();
            if (detailVideoView != null) {
                detailVideoView.a(i2, i3);
            }
            String str = a.this.f33184a;
            com.kwad.sdk.core.d.a.b(str, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
        }
    };
    public c.b u = new c.b() { // from class: com.kwad.sdk.contentalliance.detail.video.a.3
        @Override // com.kwad.sdk.core.video.a.c.b
        public void a(com.kwad.sdk.core.video.a.c cVar) {
            a.this.f33185b = 9;
            a aVar = a.this;
            aVar.a(aVar.f33185b);
            com.kwad.sdk.core.d.a.b(a.this.f33184a, "onCompletion ——> STATE_COMPLETED");
            DetailVideoView detailVideoView = (DetailVideoView) a.this.k.get();
            if (detailVideoView != null) {
                detailVideoView.setKeepScreenOn(true);
            }
        }
    };
    public c.InterfaceC0394c v = new c.InterfaceC0394c() { // from class: com.kwad.sdk.contentalliance.detail.video.a.4
        @Override // com.kwad.sdk.core.video.a.c.InterfaceC0394c
        public boolean a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
            if (i2 != -38) {
                a.this.f33185b = -1;
                a.this.l = i2;
                a.this.m = i3;
                a aVar = a.this;
                aVar.a(aVar.f33185b);
                String str = a.this.f33184a;
                com.kwad.sdk.core.d.a.b(str, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                return true;
            }
            return true;
        }
    };
    public c.d w = new c.d() { // from class: com.kwad.sdk.contentalliance.detail.video.a.5
        @Override // com.kwad.sdk.core.video.a.c.d
        public boolean a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
            String str;
            StringBuilder sb;
            String str2;
            String str3;
            String str4;
            if (i2 != 3) {
                if (i2 == 701) {
                    if (a.this.f33185b == 5 || a.this.f33185b == 7) {
                        a.this.f33185b = 7;
                        str3 = a.this.f33184a;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        a.this.f33185b = 6;
                        str3 = a.this.f33184a;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.d.a.b(str3, str4);
                    a aVar = a.this;
                    aVar.a(aVar.f33185b);
                } else if (i2 == 702) {
                    if (a.this.f33185b == 6) {
                        a.this.f33185b = 4;
                        a aVar2 = a.this;
                        aVar2.a(aVar2.f33185b);
                        com.kwad.sdk.core.d.a.b(a.this.f33184a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.f33185b == 7) {
                        a.this.f33185b = 5;
                        a aVar3 = a.this;
                        aVar3.a(aVar3.f33185b);
                        str = a.this.f33184a;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                        com.kwad.sdk.core.d.a.b(str, str2);
                    }
                } else if (i2 != 10001) {
                    if (i2 == 801) {
                        str = a.this.f33184a;
                        str2 = "视频不能seekTo，为直播视频";
                        com.kwad.sdk.core.d.a.b(str, str2);
                    } else {
                        str = a.this.f33184a;
                        sb = new StringBuilder();
                        sb.append("onInfo ——> what：");
                        sb.append(i2);
                    }
                }
                a aVar4 = a.this;
                aVar4.a(aVar4.f33186c, i2, i3);
                return true;
            }
            a.this.f33185b = 4;
            a aVar5 = a.this;
            aVar5.a(aVar5.f33185b);
            str = a.this.f33184a;
            sb = new StringBuilder();
            sb.append("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
            sb.append(System.currentTimeMillis() - a.this.n);
            str2 = sb.toString();
            com.kwad.sdk.core.d.a.b(str, str2);
            a aVar42 = a.this;
            aVar42.a(aVar42.f33186c, i2, i3);
            return true;
        }
    };
    public c.a x = new c.a() { // from class: com.kwad.sdk.contentalliance.detail.video.a.6
        @Override // com.kwad.sdk.core.video.a.c.a
        public void a(com.kwad.sdk.core.video.a.c cVar, int i2) {
            a.this.f33188e = i2;
        }
    };
    public volatile List<e> y = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0367a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f33202a;

        public C0367a(a aVar) {
            this.f33202a = new WeakReference<>(aVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar = this.f33202a.get();
            if (aVar != null) {
                aVar.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f33203a;

        public c(a aVar) {
            this.f33203a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f33203a.get();
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.kwad.sdk.core.video.a.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static com.kwad.sdk.core.video.a.c a(@NonNull Context context, boolean z) {
        com.kwad.sdk.core.video.a.b bVar;
        try {
            if (com.kwad.sdk.core.video.a.e.b() && com.kwad.sdk.core.config.c.p() && com.kwad.sdk.core.video.a.e.a()) {
                com.kwad.sdk.core.d.a.b("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                com.kwad.sdk.core.video.a.d dVar = new com.kwad.sdk.core.video.a.d(context);
                dVar.b(z);
                bVar = dVar;
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

    private void c(int i2) {
        VideoPlayerStatus videoPlayerStatus;
        d dVar = this.o;
        if (dVar == null || (videoPlayerStatus = dVar.f33221b) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    private void q() {
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0394c) null);
        this.f33186c.a((c.b) null);
        this.f33186c.a((c.e) null);
        this.f33186c.a((c.d) null);
        this.f33186c.a((c.f) null);
        this.f33186c.a((c.a) null);
    }

    private void r() {
        String str = this.f33184a;
        com.kwad.sdk.core.d.a.b(str, "reset:" + b(this.f33185b) + "->STATE_IDLE");
        this.f33186c.n();
        this.f33185b = 0;
    }

    private void s() {
        t();
        if (this.f33190g == null) {
            this.f33190g = new Timer();
        }
        if (this.f33191h == null) {
            C0367a c0367a = new C0367a(this);
            this.f33191h = c0367a;
            this.f33190g.schedule(c0367a, 0L, 1000L);
        }
    }

    private void t() {
        Timer timer = this.f33190g;
        if (timer != null) {
            timer.cancel();
            this.f33190g = null;
        }
        TimerTask timerTask = this.f33191h;
        if (timerTask != null) {
            timerTask.cancel();
            this.f33191h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.f33192i.post(new c(this));
    }

    public com.kwad.sdk.core.video.a.c a() {
        return this.f33186c;
    }

    public void a(float f2) {
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar == null) {
            return;
        }
        cVar.a(f2);
    }

    public void a(float f2, float f3) {
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar == null) {
            return;
        }
        cVar.a(f2, f3);
    }

    public void a(int i2) {
        if (this.y == null) {
            return;
        }
        for (e eVar : this.y) {
            if (eVar != null) {
                switch (i2) {
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
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar != null) {
            cVar.a(j);
        }
    }

    public void a(Surface surface) {
        this.f33187d = surface;
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar != null) {
            cVar.a(surface);
        }
    }

    public void a(final b bVar) {
        if (this.f33186c == null) {
            return;
        }
        this.j.setKeepScreenOn(false);
        this.f33192i.removeCallbacksAndMessages(null);
        t();
        q();
        final com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar != null) {
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
            this.f33186c = null;
        }
        String str = this.f33184a;
        com.kwad.sdk.core.d.a.b(str, "release:" + b(this.f33185b) + "->STATE_IDLE");
        this.f33185b = 0;
        this.p = 0;
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        com.kwad.sdk.core.video.a.c cVar2 = this.f33186c;
        if (cVar2 instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar2).a(cVar);
        }
    }

    public void a(@NonNull d dVar) {
        com.kwad.sdk.core.d.a.b(this.f33184a, "initMediaPlayer");
        this.o = dVar;
        DetailVideoView detailVideoView = this.j;
        this.f33187d = detailVideoView.f33175b;
        detailVideoView.setMediaPlayer(this);
        this.f33186c = a(this.j.getContext(), true);
        b(dVar);
        this.f33186c.a(false);
        this.f33186c.a(this.f33187d);
        this.f33186c.b(3);
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(this.j);
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

    public void a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
        Iterator<c.d> it = this.q.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.a(cVar, i2, i3);
            }
        }
    }

    public int b() {
        return this.f33186c.o();
    }

    public String b(int i2) {
        switch (i2) {
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
            if (TextUtils.isEmpty(dVar.f33220a)) {
                com.kwad.sdk.core.d.a.d(this.f33184a, "videoUrl is null");
            } else {
                this.f33186c.a(dVar);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
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

    public void c() {
        this.f33186c.a(this.s);
        this.f33186c.a(this.t);
        this.f33186c.a(this.u);
        this.f33186c.a(this.v);
        this.f33186c.a(this.w);
        this.f33186c.a(this.x);
    }

    public void c(d dVar) {
        if (this.f33186c == null) {
            com.kwad.sdk.core.d.a.c("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        int i2 = this.f33185b;
        if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
            com.kwad.sdk.core.d.a.c("resetAndPlay", "can not resetAndPlay in sate:" + this.f33185b);
            return;
        }
        r();
        b(dVar);
        q();
        c();
        e();
    }

    public boolean d() {
        return this.f33185b == 1;
    }

    public void e() {
        this.j.setKeepScreenOn(true);
        try {
            if (this.f33186c.e()) {
                String str = this.f33184a;
                com.kwad.sdk.core.d.a.b(str, "prepareAsync:" + b(this.f33185b) + "->STATE_PREPARING");
                this.f33185b = 1;
                a(1);
            }
        } catch (Exception e2) {
            String str2 = this.f33184a;
            com.kwad.sdk.core.d.a.b(str2, "prepareAsync Exception:" + b(this.f33185b));
            com.kwad.sdk.core.d.a.a(e2);
            if (b() != 2) {
                int i2 = this.p;
                this.p = i2 + 1;
                if (i2 <= 4) {
                    c(this.o);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
        if (r4 == 9) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        VideoPlayerStatus videoPlayerStatus;
        int i2 = this.f33185b;
        if (i2 == 0) {
            com.kwad.sdk.core.d.a.b(this.f33184a, "start, still not prepared well, prepare again");
            e();
            if (b() == 2) {
                this.f33186c.f();
            }
        } else if (i2 == 2 || i2 == 9) {
            this.n = System.currentTimeMillis();
            this.f33186c.f();
            long j = this.f33189f;
            if (j != 0) {
                this.f33186c.a((int) j);
            }
            String str = this.f33184a;
            com.kwad.sdk.core.d.a.b(str, "start:" + b(this.f33185b) + "->STATE_STARTED");
            d dVar = this.o;
            if (dVar != null && (videoPlayerStatus = dVar.f33221b) != null) {
                int i3 = this.f33185b;
                if (i3 == 2) {
                    if (videoPlayerStatus.mVideoPlayerType == 0) {
                        c(1);
                    }
                    c(3);
                }
            }
            this.f33185b = 3;
            a(3);
            s();
        }
    }

    public void g() {
        if (this.f33186c != null && this.f33185b == 9) {
            f();
        }
        c(3);
    }

    public void h() {
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar == null) {
            return;
        }
        int i2 = this.f33185b;
        if (i2 == 2 || i2 == 0) {
            String str = this.f33184a;
            com.kwad.sdk.core.d.a.b(str, "resume:" + b(this.f33185b) + "->start()");
            f();
        } else if (i2 == 5) {
            cVar.f();
            String str2 = this.f33184a;
            com.kwad.sdk.core.d.a.b(str2, "resume:" + b(this.f33185b) + "->STATE_PLAYING");
            this.f33185b = 4;
            a(4);
            c(2);
        } else if (i2 == 7) {
            cVar.f();
            String str3 = this.f33184a;
            com.kwad.sdk.core.d.a.b(str3, "resume:" + b(this.f33185b) + "->STATE_BUFFERING_PLAYING");
            this.f33185b = 6;
            a(6);
        }
    }

    public boolean i() {
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar != null) {
            return cVar.j();
        }
        return false;
    }

    public void j() {
        if (this.f33185b == 4) {
            this.f33186c.g();
            com.kwad.sdk.core.d.a.b(this.f33184a, "pause STATE_PLAYING->STATE_PAUSED");
            this.f33185b = 5;
            a(5);
        }
        if (this.f33185b == 6) {
            this.f33186c.g();
            com.kwad.sdk.core.d.a.b(this.f33184a, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.f33185b = 7;
            a(7);
        }
        if (this.f33185b == 3) {
            this.f33186c.g();
            com.kwad.sdk.core.d.a.b(this.f33184a, "pause STATE_STARTED->STATE_PAUSED");
            this.f33185b = 5;
            a(5);
        }
    }

    public void k() {
        a((b) null);
    }

    public int l() {
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar != null) {
            return cVar.h();
        }
        return 0;
    }

    public int m() {
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar != null) {
            return cVar.i();
        }
        return 0;
    }

    public long n() {
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar != null) {
            return cVar.l();
        }
        return 0L;
    }

    public long o() {
        com.kwad.sdk.core.video.a.c cVar = this.f33186c;
        if (cVar != null) {
            return cVar.k();
        }
        return 0L;
    }

    public void p() {
        this.y.clear();
    }
}

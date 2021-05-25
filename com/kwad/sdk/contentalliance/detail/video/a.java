package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.f;
import com.kwad.sdk.utils.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static int f31935b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f31936c = false;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.video.a.c f31939e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f31940f;

    /* renamed from: g  reason: collision with root package name */
    public int f31941g;

    /* renamed from: h  reason: collision with root package name */
    public long f31942h;

    /* renamed from: i  reason: collision with root package name */
    public Timer f31943i;
    public TimerTask j;
    public DetailVideoView l;
    public WeakReference<DetailVideoView> m;
    public int n;
    public int o;
    public com.kwad.sdk.contentalliance.detail.video.c q;

    /* renamed from: a  reason: collision with root package name */
    public String f31937a = "MediaPlayerImpl";

    /* renamed from: d  reason: collision with root package name */
    public int f31938d = 0;
    public Handler k = new Handler(Looper.getMainLooper());
    public long p = 0;
    public int r = 0;
    public List<c.d> s = new CopyOnWriteArrayList();
    public volatile List<c.e> t = new CopyOnWriteArrayList();
    public c.e u = new c.e() { // from class: com.kwad.sdk.contentalliance.detail.video.a.1
        @Override // com.kwad.sdk.core.video.a.c.e
        public void a(com.kwad.sdk.core.video.a.c cVar) {
            String str = a.this.f31937a;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrepared:");
            a aVar = a.this;
            sb.append(aVar.b(aVar.f31938d));
            sb.append("->STATE_PREPARED");
            com.kwad.sdk.core.d.a.c(str, sb.toString());
            a.this.f31938d = 2;
            a aVar2 = a.this;
            aVar2.a(aVar2.f31938d);
            for (c.e eVar : a.this.t) {
                eVar.a(a.this.f31939e);
            }
        }
    };
    public c.h v = new c.h() { // from class: com.kwad.sdk.contentalliance.detail.video.a.2
        @Override // com.kwad.sdk.core.video.a.c.h
        public void a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
            DetailVideoView detailVideoView = (DetailVideoView) a.this.m.get();
            if (detailVideoView != null) {
                detailVideoView.a(i2, i3);
            }
            String str = a.this.f31937a;
            com.kwad.sdk.core.d.a.c(str, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
        }
    };
    public c.b w = new c.b() { // from class: com.kwad.sdk.contentalliance.detail.video.a.3
        @Override // com.kwad.sdk.core.video.a.c.b
        public void a(com.kwad.sdk.core.video.a.c cVar) {
            a.this.f31938d = 9;
            a aVar = a.this;
            aVar.a(aVar.f31938d);
            com.kwad.sdk.core.d.a.c(a.this.f31937a, "onCompletion ——> STATE_COMPLETED");
            DetailVideoView detailVideoView = (DetailVideoView) a.this.m.get();
            if (detailVideoView != null) {
                detailVideoView.setKeepScreenOn(true);
            }
        }
    };
    public c.InterfaceC0370c x = new c.InterfaceC0370c() { // from class: com.kwad.sdk.contentalliance.detail.video.a.4
        @Override // com.kwad.sdk.core.video.a.c.InterfaceC0370c
        public boolean a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
            if (i2 != -38) {
                a.this.f31938d = -1;
                a.this.n = i2;
                a.this.o = i3;
                a aVar = a.this;
                aVar.a(aVar.f31938d);
                String str = a.this.f31937a;
                com.kwad.sdk.core.d.a.c(str, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                return true;
            }
            return true;
        }
    };
    public c.d y = new c.d() { // from class: com.kwad.sdk.contentalliance.detail.video.a.5
        @Override // com.kwad.sdk.core.video.a.c.d
        public boolean a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
            String str;
            StringBuilder sb;
            String str2;
            String str3;
            String str4;
            if (i2 != 3) {
                if (i2 == 701) {
                    if (a.this.f31938d == 5 || a.this.f31938d == 7) {
                        a.this.f31938d = 7;
                        str3 = a.this.f31937a;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        a.this.f31938d = 6;
                        str3 = a.this.f31937a;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.d.a.c(str3, str4);
                    a aVar = a.this;
                    aVar.a(aVar.f31938d);
                } else if (i2 == 702) {
                    if (a.this.f31938d == 6) {
                        a.this.f31938d = 4;
                        a aVar2 = a.this;
                        aVar2.a(aVar2.f31938d);
                        com.kwad.sdk.core.d.a.c(a.this.f31937a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.f31938d == 7) {
                        a.this.f31938d = 5;
                        a aVar3 = a.this;
                        aVar3.a(aVar3.f31938d);
                        str = a.this.f31937a;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                        com.kwad.sdk.core.d.a.c(str, str2);
                    }
                } else if (i2 != 10001) {
                    if (i2 == 801) {
                        str = a.this.f31937a;
                        str2 = "视频不能seekTo，为直播视频";
                        com.kwad.sdk.core.d.a.c(str, str2);
                    } else {
                        str = a.this.f31937a;
                        sb = new StringBuilder();
                        sb.append("onInfo ——> what：");
                        sb.append(i2);
                    }
                }
                a aVar4 = a.this;
                aVar4.a(aVar4.f31939e, i2, i3);
                return true;
            }
            a.this.f31938d = 4;
            a aVar5 = a.this;
            aVar5.a(aVar5.f31938d);
            str = a.this.f31937a;
            sb = new StringBuilder();
            sb.append("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
            sb.append(System.currentTimeMillis() - a.this.p);
            str2 = sb.toString();
            com.kwad.sdk.core.d.a.c(str, str2);
            a aVar42 = a.this;
            aVar42.a(aVar42.f31939e, i2, i3);
            return true;
        }
    };
    public c.a z = new c.a() { // from class: com.kwad.sdk.contentalliance.detail.video.a.6
        @Override // com.kwad.sdk.core.video.a.c.a
        public void a(com.kwad.sdk.core.video.a.c cVar, int i2) {
            a.this.f31941g = i2;
        }
    };
    public volatile List<d> A = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0359a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f31953a;

        public C0359a(a aVar) {
            this.f31953a = new WeakReference<>(aVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar = this.f31953a.get();
            if (aVar != null) {
                aVar.r();
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
        public WeakReference<a> f31954a;

        public c(a aVar) {
            this.f31954a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f31954a.get();
            if (aVar != null) {
                long l = aVar.l();
                long k = aVar.k();
                for (d dVar : aVar.A) {
                    dVar.a(k, l);
                }
            }
        }
    }

    public a(DetailVideoView detailVideoView) {
        this.l = detailVideoView;
        this.m = new WeakReference<>(detailVideoView);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.kwad.sdk.core.video.a.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static com.kwad.sdk.core.video.a.c a(@NonNull Context context, boolean z) {
        boolean z2;
        com.kwad.sdk.core.video.a.b bVar;
        com.kwad.sdk.core.video.a.b bVar2;
        try {
            if (com.kwad.sdk.core.video.a.e.b() && com.kwad.sdk.core.config.c.g() && com.kwad.sdk.core.video.a.e.a()) {
                com.kwad.sdk.core.d.a.c("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                com.kwad.sdk.core.video.a.d dVar = new com.kwad.sdk.core.video.a.d(context);
                dVar.b(z);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.a.c("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                bVar2 = new com.kwad.sdk.core.video.a.b();
            }
            z2 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!f31936c) {
                f31936c = true;
                com.kwad.sdk.crash.a.a(th);
            }
            z2 = true;
            bVar = new com.kwad.sdk.core.video.a.b();
        }
        int a2 = y.a(com.kwad.sdk.core.video.a.e.b(), KsAdSDKImpl.get().getIsExternal(), com.kwad.sdk.core.config.c.g(), com.kwad.sdk.core.video.a.e.a(), z2, com.kwad.sdk.core.config.c.A(), bVar.n());
        com.kwad.sdk.core.d.a.a("player v=" + Integer.toBinaryString(a2));
        if (f31935b != a2) {
            f31935b = a2;
            com.kwad.sdk.core.report.e.c(a2);
        }
        return bVar;
    }

    private void c(int i2) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.detail.video.c cVar = this.q;
        if (cVar == null || (videoPlayerStatus = cVar.f31959c) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    private void n() {
        com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0370c) null);
        this.f31939e.a((c.b) null);
        this.f31939e.a((c.e) null);
        this.f31939e.a((c.d) null);
        this.f31939e.a((c.f) null);
        this.f31939e.a((c.a) null);
    }

    private void o() {
        String str = this.f31937a;
        com.kwad.sdk.core.d.a.c(str, "reset:" + b(this.f31938d) + "->STATE_IDLE");
        this.f31939e.m();
        this.f31938d = 0;
    }

    private void p() {
        q();
        if (this.f31943i == null) {
            this.f31943i = new Timer();
        }
        if (this.j == null) {
            C0359a c0359a = new C0359a(this);
            this.j = c0359a;
            this.f31943i.schedule(c0359a, 0L, 1000L);
        }
    }

    private void q() {
        Timer timer = this.f31943i;
        if (timer != null) {
            timer.cancel();
            this.f31943i = null;
        }
        TimerTask timerTask = this.j;
        if (timerTask != null) {
            timerTask.cancel();
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.k.post(new c(this));
    }

    public com.kwad.sdk.core.video.a.c a() {
        return this.f31939e;
    }

    public void a(float f2, float f3) {
        com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar == null) {
            return;
        }
        cVar.a(f2, f3);
    }

    public void a(int i2) {
        if (this.A == null) {
            return;
        }
        for (d dVar : this.A) {
            if (dVar != null) {
                switch (i2) {
                    case -1:
                        q();
                        dVar.a(this.n, this.o);
                        continue;
                    case 1:
                        dVar.a();
                        continue;
                    case 2:
                        dVar.b();
                        continue;
                    case 3:
                        dVar.c();
                        continue;
                    case 4:
                        dVar.d();
                        continue;
                    case 5:
                        dVar.e();
                        continue;
                    case 6:
                        dVar.g();
                        continue;
                    case 7:
                        dVar.h();
                        continue;
                    case 9:
                        q();
                        dVar.f();
                        continue;
                }
            }
        }
    }

    public void a(Surface surface) {
        this.f31940f = surface;
        com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar != null) {
            cVar.a(surface);
        }
    }

    public void a(final b bVar) {
        if (this.f31939e == null) {
            return;
        }
        this.l.setKeepScreenOn(false);
        this.k.removeCallbacksAndMessages(null);
        q();
        n();
        final com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar != null) {
            f.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.video.a.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        cVar.l();
                        if (bVar != null) {
                            bVar.a();
                        }
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.a.a(th);
                    }
                }
            });
            this.f31939e = null;
        }
        String str = this.f31937a;
        com.kwad.sdk.core.d.a.c(str, "release:" + b(this.f31938d) + "->STATE_IDLE");
        this.f31938d = 0;
        this.r = 0;
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.b bVar) {
        com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(bVar);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        com.kwad.sdk.core.d.a.c(this.f31937a, "initMediaPlayer");
        this.q = cVar;
        DetailVideoView detailVideoView = this.l;
        this.f31940f = detailVideoView.f31926b;
        detailVideoView.setMediaPlayer(this);
        this.f31939e = a(this.l.getContext(), true);
        b(cVar);
        this.f31939e.a(false);
        this.f31939e.a(this.f31940f);
        this.f31939e.b(3);
        com.kwad.sdk.core.video.a.c cVar2 = this.f31939e;
        if (cVar2 instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar2).a(this.l);
        }
        c();
    }

    public void a(d dVar) {
        this.A.add(dVar);
    }

    public void a(c.e eVar) {
        this.t.add(eVar);
    }

    public void a(com.kwad.sdk.core.video.a.c cVar, int i2, int i3) {
        Iterator<c.d> it = this.s.iterator();
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
        return this.f31939e.n();
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

    public void b(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        try {
            if (TextUtils.isEmpty(cVar.f31957a)) {
                com.kwad.sdk.core.d.a.e(this.f31937a, "videoUrl is null");
            } else {
                this.f31939e.a(cVar);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public void b(d dVar) {
        this.A.remove(dVar);
    }

    public void c() {
        this.f31939e.a(this.u);
        this.f31939e.a(this.v);
        this.f31939e.a(this.w);
        this.f31939e.a(this.x);
        this.f31939e.a(this.y);
        this.f31939e.a(this.z);
    }

    public void c(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        if (this.f31939e == null) {
            com.kwad.sdk.core.d.a.d("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        int i2 = this.f31938d;
        if (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
            com.kwad.sdk.core.d.a.d("resetAndPlay", "can not resetAndPlay in sate:" + this.f31938d);
            return;
        }
        o();
        b(cVar);
        n();
        c();
        d();
    }

    public void d() {
        this.l.setKeepScreenOn(true);
        try {
            if (this.f31939e.e()) {
                String str = this.f31937a;
                com.kwad.sdk.core.d.a.c(str, "prepareAsync:" + b(this.f31938d) + "->STATE_PREPARING");
                this.f31938d = 1;
                a(1);
            }
        } catch (Exception e2) {
            String str2 = this.f31937a;
            com.kwad.sdk.core.d.a.c(str2, "prepareAsync Exception:" + b(this.f31938d));
            com.kwad.sdk.core.d.a.a(e2);
            if (b() != 2) {
                int i2 = this.r;
                this.r = i2 + 1;
                if (i2 <= 4) {
                    c(this.q);
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
    public void e() {
        VideoPlayerStatus videoPlayerStatus;
        int i2 = this.f31938d;
        if (i2 == 0) {
            com.kwad.sdk.core.d.a.c(this.f31937a, "start, still not prepared well, prepare again");
            d();
            if (b() == 2) {
                this.f31939e.f();
            }
        } else if (i2 == 2 || i2 == 9) {
            this.p = System.currentTimeMillis();
            this.f31939e.f();
            long j = this.f31942h;
            if (j != 0) {
                this.f31939e.a((int) j);
            }
            String str = this.f31937a;
            com.kwad.sdk.core.d.a.c(str, "start:" + b(this.f31938d) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.detail.video.c cVar = this.q;
            if (cVar != null && (videoPlayerStatus = cVar.f31959c) != null) {
                int i3 = this.f31938d;
                if (i3 == 2) {
                    if (videoPlayerStatus.mVideoPlayerType == 0) {
                        c(1);
                    }
                    c(3);
                }
            }
            this.f31938d = 3;
            a(3);
            p();
        }
    }

    public void f() {
        com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar == null) {
            return;
        }
        int i2 = this.f31938d;
        if (i2 == 2 || i2 == 0) {
            String str = this.f31937a;
            com.kwad.sdk.core.d.a.c(str, "resume:" + b(this.f31938d) + "->start()");
            e();
        } else if (i2 == 5) {
            cVar.f();
            String str2 = this.f31937a;
            com.kwad.sdk.core.d.a.c(str2, "resume:" + b(this.f31938d) + "->STATE_PLAYING");
            this.f31938d = 4;
            a(4);
            c(2);
        } else if (i2 == 7) {
            cVar.f();
            String str3 = this.f31937a;
            com.kwad.sdk.core.d.a.c(str3, "resume:" + b(this.f31938d) + "->STATE_BUFFERING_PLAYING");
            this.f31938d = 6;
            a(6);
        }
    }

    public void g() {
        if (this.f31938d == 4) {
            this.f31939e.g();
            com.kwad.sdk.core.d.a.c(this.f31937a, "pause STATE_PLAYING->STATE_PAUSED");
            this.f31938d = 5;
            a(5);
        }
        if (this.f31938d == 6) {
            this.f31939e.g();
            com.kwad.sdk.core.d.a.c(this.f31937a, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.f31938d = 7;
            a(7);
        }
        if (this.f31938d == 3) {
            this.f31939e.g();
            com.kwad.sdk.core.d.a.c(this.f31937a, "pause STATE_STARTED->STATE_PAUSED");
            this.f31938d = 5;
            a(5);
        }
    }

    public void h() {
        a((b) null);
    }

    public int i() {
        com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar != null) {
            return cVar.h();
        }
        return 0;
    }

    public int j() {
        com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar != null) {
            return cVar.i();
        }
        return 0;
    }

    public long k() {
        com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar != null) {
            return cVar.k();
        }
        return 0L;
    }

    public long l() {
        com.kwad.sdk.core.video.a.c cVar = this.f31939e;
        if (cVar != null) {
            return cVar.j();
        }
        return 0L;
    }

    public void m() {
        this.A.clear();
    }
}

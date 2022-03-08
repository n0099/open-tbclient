package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static int f54128b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f54129c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicInteger f54130d = new AtomicInteger(0);

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.video.kwai.c f54132f;

    /* renamed from: g  reason: collision with root package name */
    public int f54133g;

    /* renamed from: h  reason: collision with root package name */
    public long f54134h;

    /* renamed from: i  reason: collision with root package name */
    public Timer f54135i;

    /* renamed from: j  reason: collision with root package name */
    public TimerTask f54136j;
    public Context l;
    public DetailVideoView m;
    public int n;
    public int o;
    public com.kwad.sdk.contentalliance.detail.video.c q;
    public String a = "MediaPlayerImpl";

    /* renamed from: e  reason: collision with root package name */
    public volatile int f54131e = 0;
    public Handler k = new Handler(Looper.getMainLooper());
    public long p = 0;
    public int r = 0;
    public List<c.d> s = new CopyOnWriteArrayList();
    public final AtomicBoolean t = new AtomicBoolean(false);
    public boolean u = false;
    public volatile List<c.e> v = new CopyOnWriteArrayList();
    public c.e w = new c.e() { // from class: com.kwad.sdk.contentalliance.detail.video.a.1
        @Override // com.kwad.sdk.core.video.kwai.c.e
        public void a(com.kwad.sdk.core.video.kwai.c cVar) {
            String str = a.this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrepared:");
            a aVar = a.this;
            sb.append(aVar.b(aVar.f54131e));
            sb.append("->STATE_PREPARED");
            com.kwad.sdk.core.d.a.c(str, sb.toString());
            a.this.f54131e = 2;
            a aVar2 = a.this;
            aVar2.a(aVar2.f54131e);
            for (c.e eVar : a.this.v) {
                eVar.a(a.this.f54132f);
            }
        }
    };
    public c.h x = new c.h() { // from class: com.kwad.sdk.contentalliance.detail.video.a.2
        @Override // com.kwad.sdk.core.video.kwai.c.h
        public void a(com.kwad.sdk.core.video.kwai.c cVar, int i2, int i3) {
            if (a.this.m != null) {
                a.this.m.a(i2, i3);
            }
            String str = a.this.a;
            com.kwad.sdk.core.d.a.c(str, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
        }
    };
    public c.b y = new c.b() { // from class: com.kwad.sdk.contentalliance.detail.video.a.3
        @Override // com.kwad.sdk.core.video.kwai.c.b
        public void a(com.kwad.sdk.core.video.kwai.c cVar) {
            a.this.f54131e = 9;
            a aVar = a.this;
            aVar.a(aVar.f54131e);
            com.kwad.sdk.core.d.a.c(a.this.a, "onCompletion ——> STATE_COMPLETED");
        }
    };
    public c.InterfaceC2106c z = new c.InterfaceC2106c() { // from class: com.kwad.sdk.contentalliance.detail.video.a.4
        @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC2106c
        public boolean a(com.kwad.sdk.core.video.kwai.c cVar, int i2, int i3) {
            if (i2 != -38) {
                a.this.f54131e = -1;
                a.this.n = i2;
                a.this.o = i3;
                a aVar = a.this;
                aVar.a(aVar.f54131e);
                String str = a.this.a;
                com.kwad.sdk.core.d.a.c(str, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                return true;
            }
            return true;
        }
    };
    public c.d A = new c.d() { // from class: com.kwad.sdk.contentalliance.detail.video.a.5
        @Override // com.kwad.sdk.core.video.kwai.c.d
        public boolean a(com.kwad.sdk.core.video.kwai.c cVar, int i2, int i3) {
            String str;
            StringBuilder sb;
            String str2;
            String str3;
            String str4;
            if (i2 != 3) {
                if (i2 == 701) {
                    if (a.this.f54131e == 5 || a.this.f54131e == 7) {
                        a.this.f54131e = 7;
                        str3 = a.this.a;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        a.this.f54131e = 6;
                        str3 = a.this.a;
                        str4 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.d.a.c(str3, str4);
                    a aVar = a.this;
                    aVar.a(aVar.f54131e);
                } else if (i2 == 702) {
                    if (a.this.f54131e == 6) {
                        a.this.f54131e = 4;
                        a aVar2 = a.this;
                        aVar2.a(aVar2.f54131e);
                        com.kwad.sdk.core.d.a.c(a.this.a, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.f54131e == 7) {
                        a.this.f54131e = 5;
                        a aVar3 = a.this;
                        aVar3.a(aVar3.f54131e);
                        str = a.this.a;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                        com.kwad.sdk.core.d.a.c(str, str2);
                    }
                } else if (i2 != 10001) {
                    if (i2 == 801) {
                        str = a.this.a;
                        str2 = "视频不能seekTo，为直播视频";
                        com.kwad.sdk.core.d.a.c(str, str2);
                    } else {
                        str = a.this.a;
                        sb = new StringBuilder();
                        sb.append("onInfo ——> what：");
                        sb.append(i2);
                    }
                }
                a aVar4 = a.this;
                aVar4.a(aVar4.f54132f, i2, i3);
                return true;
            }
            a.this.f54131e = 4;
            a aVar5 = a.this;
            aVar5.a(aVar5.f54131e);
            str = a.this.a;
            sb = new StringBuilder();
            sb.append("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING, TIME ELAPSED: ");
            sb.append(System.currentTimeMillis() - a.this.p);
            str2 = sb.toString();
            com.kwad.sdk.core.d.a.c(str, str2);
            a aVar42 = a.this;
            aVar42.a(aVar42.f54132f, i2, i3);
            return true;
        }
    };
    public c.a B = new c.a() { // from class: com.kwad.sdk.contentalliance.detail.video.a.6
        @Override // com.kwad.sdk.core.video.kwai.c.a
        public void a(com.kwad.sdk.core.video.kwai.c cVar, int i2) {
            a.this.f54133g = i2;
        }
    };
    public volatile List<d> C = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.sdk.contentalliance.detail.video.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C2091a extends TimerTask {
        public WeakReference<a> a;

        public C2091a(a aVar) {
            this.a = new WeakReference<>(aVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar = this.a.get();
            if (aVar != null) {
                aVar.s();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public WeakReference<a> a;

        public c(a aVar) {
            this.a = new WeakReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.a.get();
            if (aVar != null) {
                long m = aVar.m();
                long k = aVar.k();
                for (d dVar : aVar.C) {
                    dVar.a(k, m);
                }
            }
        }
    }

    public a(@Nullable DetailVideoView detailVideoView) {
        this.m = detailVideoView;
        if (detailVideoView != null) {
            this.l = detailVideoView.getContext().getApplicationContext();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.kwad.sdk.core.video.kwai.d */
    /* JADX WARN: Multi-variable type inference failed */
    public static com.kwad.sdk.core.video.kwai.c a(@NonNull Context context, boolean z) {
        boolean z2;
        com.kwad.sdk.core.video.kwai.b bVar;
        com.kwad.sdk.core.video.kwai.b bVar2;
        try {
            if (com.kwad.sdk.core.video.kwai.e.b() && com.kwad.sdk.core.config.b.h() && com.kwad.sdk.core.video.kwai.e.a()) {
                com.kwad.sdk.core.d.a.c("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                com.kwad.sdk.core.video.kwai.d dVar = new com.kwad.sdk.core.video.kwai.d(context);
                dVar.b(z);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.a.c("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                bVar2 = new com.kwad.sdk.core.video.kwai.b();
            }
            z2 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!f54129c) {
                f54129c = true;
                com.kwad.sdk.crash.a.a(th);
            }
            z2 = true;
            bVar = new com.kwad.sdk.core.video.kwai.b();
        }
        int a = ai.a(com.kwad.sdk.core.video.kwai.e.b(), KsAdSDKImpl.get().getIsExternal(), com.kwad.sdk.core.config.b.h(), com.kwad.sdk.core.video.kwai.e.a(), z2, com.kwad.sdk.core.config.b.G(), bVar.o());
        com.kwad.sdk.core.d.a.a("player v=" + Integer.toBinaryString(a));
        if (f54128b != a) {
            f54128b = a;
            com.kwad.sdk.core.report.d.c(a);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.kwai.c cVar, b bVar) {
        if (cVar == null) {
            return;
        }
        try {
            cVar.l();
            if (bVar != null) {
                bVar.a();
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    private void b(boolean z) {
        DetailVideoView detailVideoView = this.m;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void c(int i2) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.detail.video.c cVar = this.q;
        if (cVar == null || (videoPlayerStatus = cVar.f54144d) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    private void o() {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC2106c) null);
        this.f54132f.a((c.b) null);
        this.f54132f.a((c.e) null);
        this.f54132f.a((c.h) null);
        this.f54132f.a((c.d) null);
        this.f54132f.a((c.f) null);
        this.f54132f.a((c.a) null);
    }

    private void p() {
        String str = this.a;
        com.kwad.sdk.core.d.a.c(str, "reset:" + b(this.f54131e) + "->STATE_IDLE");
        this.f54132f.m();
        this.f54131e = 0;
    }

    private void q() {
        r();
        if (this.f54135i == null) {
            this.f54135i = new Timer("ksad-DetailPlayer-timer" + f54130d.getAndIncrement());
        }
        if (this.f54136j == null) {
            C2091a c2091a = new C2091a(this);
            this.f54136j = c2091a;
            this.f54135i.schedule(c2091a, 0L, 500L);
        }
    }

    private void r() {
        Timer timer = this.f54135i;
        if (timer != null) {
            timer.cancel();
            this.f54135i = null;
        }
        TimerTask timerTask = this.f54136j;
        if (timerTask != null) {
            timerTask.cancel();
            this.f54136j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.k.post(new c(this));
    }

    public com.kwad.sdk.core.video.kwai.c a() {
        return this.f54132f;
    }

    public void a(float f2, float f3) {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar == null) {
            return;
        }
        cVar.a(f2, f3);
    }

    public void a(int i2) {
        if (this.C == null) {
            return;
        }
        for (d dVar : this.C) {
            if (dVar != null) {
                switch (i2) {
                    case -1:
                        b(false);
                        r();
                        dVar.a(this.n, this.o);
                        continue;
                    case 1:
                        dVar.a();
                        continue;
                    case 2:
                        dVar.b();
                        continue;
                    case 3:
                        b(true);
                        dVar.c();
                        continue;
                    case 4:
                        b(true);
                        dVar.d();
                        continue;
                    case 5:
                        b(false);
                        dVar.e();
                        continue;
                    case 6:
                        dVar.g();
                        continue;
                    case 7:
                        dVar.h();
                        continue;
                    case 9:
                        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
                        if (cVar != null && !cVar.n()) {
                            b(false);
                            r();
                        }
                        dVar.f();
                        continue;
                }
            }
        }
    }

    public void a(long j2) {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar != null) {
            cVar.a(j2);
        }
    }

    public void a(Surface surface) {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar != null) {
            cVar.a(surface);
        }
    }

    public void a(b bVar) {
        a(bVar, true);
    }

    public void a(final b bVar, boolean z) {
        if (this.f54132f == null) {
            return;
        }
        b(false);
        this.k.removeCallbacksAndMessages(null);
        r();
        o();
        this.m = null;
        final com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar != null) {
            if (z) {
                i.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.video.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(cVar, bVar);
                    }
                });
            } else {
                a(cVar, bVar);
            }
            this.f54132f = null;
        }
        String str = this.a;
        com.kwad.sdk.core.d.a.c(str, "release:" + b(this.f54131e) + "->STATE_IDLE");
        this.f54131e = 0;
        this.r = 0;
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.b bVar) {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar instanceof com.kwad.sdk.core.video.kwai.d) {
            ((com.kwad.sdk.core.video.kwai.d) cVar).a(bVar);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        try {
            if (TextUtils.isEmpty(cVar.f54142b)) {
                com.kwad.sdk.core.d.a.e(this.a, "videoUrl is null");
            } else {
                String str = this.a;
                com.kwad.sdk.core.d.a.e(str, "videoUrl=" + cVar.f54142b);
                this.f54132f.a(cVar);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, @NonNull DetailVideoView detailVideoView) {
        a(cVar, true, false, detailVideoView);
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.kwai.c cVar2) {
        com.kwad.sdk.core.d.a.c(this.a, "initMediaPlayer");
        if (cVar == null || detailVideoView == null || cVar2 == null) {
            return;
        }
        if (this.l == null) {
            this.l = detailVideoView.getContext().getApplicationContext();
        }
        this.u = z;
        this.q = cVar;
        DetailVideoView detailVideoView2 = this.m;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.d.a.c(this.a, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.m = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.f54132f != cVar2) {
            com.kwad.sdk.core.d.a.c(this.a, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.kwai.c cVar3 = this.f54132f;
            if (cVar3 != null) {
                cVar2.a(cVar3.n());
                o();
                this.f54132f.l();
            }
            this.f54132f = cVar2;
            p();
            c();
            cVar2.b(3);
        } else {
            com.kwad.sdk.core.d.a.c(this.a, "initMediaPlayer mediaPlayer not changed");
            p();
            o();
            c();
        }
        this.f54132f.a(detailVideoView.f54119b);
        com.kwad.sdk.core.video.kwai.c cVar4 = this.f54132f;
        if (cVar4 instanceof com.kwad.sdk.core.video.kwai.d) {
            ((com.kwad.sdk.core.video.kwai.d) cVar4).a(detailVideoView);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        String str = this.a;
        com.kwad.sdk.core.d.a.c(str, "initMediaPlayer enablePreLoad:" + z);
        if (cVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.video.kwai.c a = a(this.l, z);
        a.a(false);
        a(cVar, z2, detailVideoView, a);
    }

    public void a(d dVar) {
        this.C.add(dVar);
    }

    public void a(c.e eVar) {
        this.v.add(eVar);
    }

    public void a(com.kwad.sdk.core.video.kwai.c cVar, int i2, int i3) {
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

    public void a(boolean z) {
        float f2 = z ? 1.0f : 0.0f;
        a(f2, f2);
    }

    public int b() {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar != null) {
            return cVar.o();
        }
        return 0;
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

    public void b(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        if (this.f54132f == null) {
            com.kwad.sdk.core.d.a.d("resetAndPlay", "mMediaPlayer is null");
        } else if (this.f54131e == 2 || this.f54131e == 3 || this.f54131e == 4 || this.f54131e == 5) {
            com.kwad.sdk.core.d.a.d("resetAndPlay", "can not resetAndPlay in sate:" + this.f54131e);
        } else {
            p();
            o();
            c();
            d();
        }
    }

    public void b(d dVar) {
        this.C.remove(dVar);
    }

    public void c() {
        this.f54132f.a(this.w);
        this.f54132f.a(this.x);
        this.f54132f.a(this.y);
        this.f54132f.a(this.z);
        this.f54132f.a(this.A);
        this.f54132f.a(this.B);
    }

    public void d() {
        if (this.u) {
            if (this.t.compareAndSet(false, true)) {
                i.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.video.a.7
                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, CONSTRUCTOR, CONST_STR, INVOKE, IGET, IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6 A[Catch: all -> 0x00e1, TRY_ENTER, TryCatch #2 {Exception -> 0x00e4, blocks: (B:20:0x00cf, B:21:0x00d5, B:22:0x00d6, B:23:0x00df), top: B:36:0x00cf }] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        boolean e2;
                        String str = a.this.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("prepareAsync now:");
                        a aVar = a.this;
                        sb.append(aVar.b(aVar.f54131e));
                        com.kwad.sdk.core.d.a.c(str, sb.toString());
                        if (a.this.f54132f == null) {
                            return;
                        }
                        try {
                            try {
                                synchronized (a.this.f54132f) {
                                    a.this.a(a.this.q);
                                    e2 = a.this.f54132f.e();
                                    String str2 = a.this.a;
                                    com.kwad.sdk.core.d.a.c(str2, "prepareAsync:" + a.this.b(a.this.f54131e) + "->STATE_PREPARING, success: " + e2);
                                    a.this.f54131e = 1;
                                }
                                if (e2) {
                                    a.this.k.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.video.a.7.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            a aVar2 = a.this;
                                            aVar2.a(aVar2.f54131e);
                                        }
                                    });
                                } else {
                                    com.kwad.sdk.core.d.a.e(a.this.a, "prepareAsync failed");
                                }
                            } finally {
                                try {
                                    synchronized (a.this.t) {
                                    }
                                } finally {
                                }
                            }
                            synchronized (a.this.t) {
                                a.this.t.notifyAll();
                            }
                        } catch (Exception e3) {
                            com.kwad.sdk.core.d.a.a(e3);
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            a(this.q);
            if (this.f54132f.e()) {
                String str = this.a;
                com.kwad.sdk.core.d.a.c(str, "prepareAsync:" + b(this.f54131e) + "->STATE_PREPARING");
                this.f54131e = 1;
                a(this.f54131e);
            } else {
                com.kwad.sdk.core.d.a.e(this.a, "prepareAsync failed");
            }
        } catch (Throwable th) {
            if (b() != 2) {
                int i2 = this.r;
                this.r = i2 + 1;
                if (i2 <= 4) {
                    b(this.q);
                }
            }
            String str2 = this.a;
            com.kwad.sdk.core.d.a.c(str2, "prepareAsync Exception:" + b(this.f54131e));
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
        if (r7.f54131e == 9) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        String str = this.a;
        com.kwad.sdk.core.d.a.c(str, "start mCurrentState: " + b(this.f54131e));
        if (this.f54131e == 0) {
            com.kwad.sdk.core.d.a.c(this.a, "start, still not prepared well, prepare again");
            d();
            if (b() == 2) {
                if (this.u && this.t.get()) {
                    i.a(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.video.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.t.get()) {
                                try {
                                    synchronized (a.this.t) {
                                        a.this.t.wait(5000L);
                                    }
                                } catch (InterruptedException e2) {
                                    com.kwad.sdk.core.d.a.a(e2);
                                }
                            }
                            if (a.this.b() == 2) {
                                a.this.f54132f.f();
                            }
                        }
                    });
                } else {
                    this.f54132f.f();
                }
            }
        } else if (this.f54131e == 2 || this.f54131e == 9) {
            this.p = System.currentTimeMillis();
            this.f54132f.f();
            long j2 = this.f54134h;
            if (j2 != 0) {
                this.f54132f.a((int) j2);
            }
            String str2 = this.a;
            com.kwad.sdk.core.d.a.c(str2, "start:" + b(this.f54131e) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.detail.video.c cVar = this.q;
            if (cVar != null && cVar.f54144d != null) {
                if (this.f54131e == 2) {
                    if (this.q.f54144d.mVideoPlayerType == 0) {
                        c(1);
                    }
                    c(3);
                }
            }
            this.f54131e = 3;
            a(this.f54131e);
            q();
        }
    }

    public void f() {
        if (this.f54132f == null) {
            com.kwad.sdk.core.d.a.e(this.a, "resume but mMediaPlayer is null");
            return;
        }
        String str = this.a;
        com.kwad.sdk.core.d.a.c(str, "resume mCurrentState: " + b(this.f54131e));
        if (this.f54131e == 2 || this.f54131e == 0) {
            String str2 = this.a;
            com.kwad.sdk.core.d.a.c(str2, "resume:" + b(this.f54131e) + "->start()");
            e();
        } else if (this.f54131e == 5) {
            this.f54132f.f();
            String str3 = this.a;
            com.kwad.sdk.core.d.a.c(str3, "resume:" + b(this.f54131e) + "->STATE_PLAYING");
            this.f54131e = 4;
            a(this.f54131e);
            c(2);
        } else if (this.f54131e != 7) {
            String str4 = this.a;
            com.kwad.sdk.core.d.a.e(str4, "resume: " + b(this.f54131e) + " 此时不能调用resume()方法.");
        } else {
            this.f54132f.f();
            String str5 = this.a;
            com.kwad.sdk.core.d.a.c(str5, "resume:" + b(this.f54131e) + "->STATE_BUFFERING_PLAYING");
            this.f54131e = 6;
            a(this.f54131e);
        }
    }

    public boolean g() {
        boolean z;
        String str = this.a;
        com.kwad.sdk.core.d.a.c(str, "pause mCurrentState: " + b(this.f54131e));
        if (this.f54131e == 4) {
            this.f54132f.g();
            com.kwad.sdk.core.d.a.c(this.a, "pause STATE_PLAYING->STATE_PAUSED");
            this.f54131e = 5;
            a(this.f54131e);
            z = true;
        } else {
            z = false;
        }
        if (this.f54131e == 6) {
            this.f54132f.g();
            com.kwad.sdk.core.d.a.c(this.a, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.f54131e = 7;
            a(this.f54131e);
            z = true;
        }
        if (this.f54131e == 3) {
            this.f54132f.g();
            com.kwad.sdk.core.d.a.c(this.a, "pause STATE_STARTED->STATE_PAUSED");
            this.f54131e = 5;
            a(this.f54131e);
            z = true;
        }
        if (this.f54131e == 9 && this.f54132f.n()) {
            this.f54132f.g();
            String str2 = this.a;
            com.kwad.sdk.core.d.a.c(str2, "pause " + b(this.f54131e) + "->STATE_PAUSED");
            this.f54131e = 5;
            a(this.f54131e);
            return true;
        }
        return z;
    }

    public void h() {
        a((b) null);
    }

    public int i() {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar != null) {
            return cVar.h();
        }
        return 0;
    }

    public int j() {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar != null) {
            return cVar.i();
        }
        return 0;
    }

    public long k() {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar != null) {
            return cVar.k();
        }
        return 0L;
    }

    public long l() {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar != null) {
            return cVar.j();
        }
        return 0L;
    }

    public long m() {
        com.kwad.sdk.core.video.kwai.c cVar = this.f54132f;
        if (cVar != null) {
            return cVar.j();
        }
        return 0L;
    }

    public void n() {
        this.C.clear();
    }
}

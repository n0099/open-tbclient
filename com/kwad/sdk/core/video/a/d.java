package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.al;
import com.kwai.video.ksvodplayerkit.a.c;
import com.kwai.video.ksvodplayerkit.d;
import com.kwai.video.ksvodplayerkit.j;
import com.kwai.video.ksvodplayerkit.k;
import com.kwai.video.ksvodplayerkit.l;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.core.video.a.a {
    private static volatile boolean k = false;
    private static final Queue<d> l = new ConcurrentLinkedQueue();

    /* renamed from: a  reason: collision with root package name */
    private final k f9451a;

    /* renamed from: b  reason: collision with root package name */
    private final a f9452b;
    private String c;
    private MediaDataSource d;
    private boolean f;
    private boolean g;
    private int h;
    private int i;
    private com.kwad.sdk.contentalliance.detail.video.d n;
    private final Object e = new Object();
    private boolean j = false;
    private boolean m = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements com.kwai.video.ksvodplayerkit.b, d.a, d.b, d.c, d.InterfaceC1167d, d.e, d.f {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<d> f9454a;

        a(d dVar) {
            this.f9454a = new WeakReference<>(dVar);
        }

        private d c() {
            return this.f9454a.get();
        }

        @Override // com.kwai.video.ksvodplayerkit.d.f
        public void a() {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPlayerRelease");
        }

        @Override // com.kwai.video.ksvodplayerkit.d.a
        public void a(int i) {
            d c = c();
            if (c != null) {
                c.a(i);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.c
        public void a(int i, int i2) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onEvent, what: " + i);
            d c = c();
            if (c != null) {
                if (i == 10100) {
                    c.d();
                } else if (i == 10101) {
                    c.c();
                } else {
                    if (i == 10209) {
                        c.u();
                    }
                    c.c(i, i2);
                }
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.e
        public void a(int i, int i2, int i3, int i4) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d c = c();
            if (c != null) {
                c.a(i, i2);
                c.h = i3;
                c.i = i4;
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void a(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
        }

        @Override // com.kwai.video.ksvodplayerkit.d.InterfaceC1167d
        public void b() {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPrepared");
            d c = c();
            if (c != null) {
                c.b();
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.b
        public void b(int i, int i2) {
            d c = c();
            if (c != null) {
                c.j = false;
                c.b(i, i2);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void b(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
            if (al.a().b()) {
                d c = c();
                if (c != null) {
                    c.f9451a.a((com.kwai.video.ksvodplayerkit.b) null);
                }
            } else if (cVar == null || cVar.f11060b <= 0 || cVar.l == 0) {
            } else {
                al.a().a((cVar.f11060b - cVar.f11059a) / cVar.l);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void c(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void d(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void e(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
        }
    }

    public d(@NonNull Context context) {
        synchronized (this.e) {
            this.f9451a = new k(context.getApplicationContext());
        }
        a(context);
        this.f9452b = new a(this);
        s();
    }

    public static synchronized void a(@NonNull Context context) {
        synchronized (d.class) {
            com.kwad.sdk.core.d.a.a("KwaiMediaPlayer", "initConfigSync has init =" + k);
            if (!k) {
                j.a(context);
                if (com.kwad.sdk.core.config.c.F()) {
                    com.kwai.video.ksvodplayerkit.a.c.a(new c.a() { // from class: com.kwad.sdk.core.video.a.d.1
                        @Override // com.kwai.video.ksvodplayerkit.a.c.a
                        public void a(String str, String str2) {
                            com.kwad.sdk.core.video.a.a.a.a(str, str2);
                        }
                    });
                }
                k = true;
            }
        }
    }

    public static synchronized boolean p() {
        boolean z;
        synchronized (d.class) {
            z = k;
        }
        return z;
    }

    private void q() {
        if (this.d != null) {
            try {
                this.d.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.d = null;
        }
    }

    private void r() {
        if (this.j) {
            return;
        }
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "realPrepare: ret: " + this.f9451a.a());
        this.j = true;
    }

    private void s() {
        this.f9451a.a((d.InterfaceC1167d) this.f9452b);
        this.f9451a.a((d.a) this.f9452b);
        this.f9451a.a((d.c) this.f9452b);
        this.f9451a.a((d.e) this.f9452b);
        this.f9451a.a((d.b) this.f9452b);
        if (com.kwad.sdk.core.config.c.U()) {
            this.f9451a.a((com.kwai.video.ksvodplayerkit.b) this.f9452b);
        }
    }

    private void t() {
        this.f9451a.a((d.InterfaceC1167d) null);
        this.f9451a.a((d.a) null);
        this.f9451a.a((d.c) null);
        this.f9451a.a((d.e) null);
        this.f9451a.a((d.b) null);
        this.f9451a.a((com.kwai.video.ksvodplayerkit.b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Iterator<d> it = l.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i++;
            }
        }
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i);
        if (i + 1 < l.size()) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
            for (int i2 = 0; i2 < i + 1; i2++) {
                l.poll();
            }
            d poll = l.poll();
            l.clear();
            if (poll != null) {
                poll.e();
            } else {
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f) {
        this.f9451a.a(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f, float f2) {
        this.f9451a.a(f, f2);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        this.f9451a.a((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.f9451a.a(surface);
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        if (this.f9451a == null || cVar == null) {
            return;
        }
        l lVar = new l();
        lVar.c = String.valueOf(cVar.f8609a);
        lVar.d = cVar.f8610b;
        this.f9451a.a(lVar);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar) {
        this.n = dVar;
        a(this.n.c);
        a(dVar.f8611a, (Map<String, String>) null);
    }

    public void a(String str, Map<String, String> map) {
        this.c = str;
        this.f9451a.a(str, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        this.g = z;
        this.f9451a.a(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void b(int i) {
    }

    public void b(boolean z) {
        this.m = z;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean e() {
        if (!this.m) {
            r();
            return true;
        }
        if (!l.contains(this)) {
            l.offer(this);
        }
        if (l.size() == 1) {
            r();
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "prepareAsync first");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void f() {
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "start");
        r();
        this.f9451a.e();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        this.f9451a.g();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        return this.f9451a.f().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        return this.f9451a.f().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean j() {
        try {
            return this.f9451a.b();
        } catch (IllegalStateException e) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        try {
            return this.f9451a.c();
        } catch (IllegalStateException e) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long l() {
        try {
            return this.f9451a.d();
        } catch (IllegalStateException e) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "release remote player ret: " + l.remove(this) + ", player list size: " + l.size());
        this.f = true;
        this.f9451a.a(new d.f() { // from class: com.kwad.sdk.core.video.a.d.2
            @Override // com.kwai.video.ksvodplayerkit.d.f
            public void a() {
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPlayerRelease");
            }
        });
        q();
        a();
        t();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void n() {
        this.j = false;
        try {
            this.f9451a.f().reset();
        } catch (IllegalStateException e) {
        }
        q();
        a();
        s();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int o() {
        return 2;
    }
}

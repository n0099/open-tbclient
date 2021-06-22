package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.core.video.a.a {
    public static volatile boolean k = false;
    public static final Queue<d> l = new ConcurrentLinkedQueue();

    /* renamed from: a  reason: collision with root package name */
    public final k f34848a;

    /* renamed from: b  reason: collision with root package name */
    public final a f34849b;

    /* renamed from: c  reason: collision with root package name */
    public String f34850c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f34851d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f34852e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34853f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34854g;

    /* renamed from: h  reason: collision with root package name */
    public int f34855h;

    /* renamed from: i  reason: collision with root package name */
    public int f34856i;
    public boolean j;
    public boolean m;
    public com.kwad.sdk.contentalliance.detail.video.d n;

    /* loaded from: classes7.dex */
    public static class a implements com.kwai.video.ksvodplayerkit.b, d.a, d.b, d.c, d.InterfaceC0455d, d.e, d.f {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f34858a;

        public a(d dVar) {
            this.f34858a = new WeakReference<>(dVar);
        }

        private d c() {
            return this.f34858a.get();
        }

        @Override // com.kwai.video.ksvodplayerkit.d.f
        public void a() {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPlayerRelease");
        }

        @Override // com.kwai.video.ksvodplayerkit.d.a
        public void a(int i2) {
            d c2 = c();
            if (c2 != null) {
                c2.a(i2);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.c
        public void a(int i2, int i3) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onEvent, what: " + i2);
            d c2 = c();
            if (c2 != null) {
                if (i2 == 10100) {
                    c2.d();
                } else if (i2 == 10101) {
                    c2.c();
                } else {
                    if (i2 == 10209) {
                        c2.u();
                    }
                    c2.c(i2, i3);
                }
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.e
        public void a(int i2, int i3, int i4, int i5) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onVideoSizeChanged width: " + i2 + ", height: " + i3 + ", sarNum:" + i4 + ", sarDen:" + i5);
            d c2 = c();
            if (c2 != null) {
                c2.a(i2, i3);
                c2.f34855h = i4;
                c2.f34856i = i5;
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void a(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
        }

        @Override // com.kwai.video.ksvodplayerkit.d.InterfaceC0455d
        public void b() {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPrepared");
            d c2 = c();
            if (c2 != null) {
                c2.b();
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.b
        public void b(int i2, int i3) {
            d c2 = c();
            if (c2 != null) {
                c2.j = false;
                c2.b(i2, i3);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void b(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
            if (al.a().b()) {
                d c2 = c();
                if (c2 != null) {
                    c2.f34848a.a((com.kwai.video.ksvodplayerkit.b) null);
                }
            } else if (cVar != null) {
                long j = cVar.f38143b;
                if (j > 0) {
                    long j2 = cVar.l;
                    if (j2 != 0) {
                        al.a().a((j - cVar.f38142a) / j2);
                    }
                }
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
        Object obj = new Object();
        this.f34852e = obj;
        this.j = false;
        this.m = true;
        synchronized (obj) {
            this.f34848a = new k(context.getApplicationContext());
        }
        a(context);
        this.f34849b = new a(this);
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
        MediaDataSource mediaDataSource = this.f34851d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f34851d = null;
        }
    }

    private void r() {
        if (this.j) {
            return;
        }
        int a2 = this.f34848a.a();
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "realPrepare: ret: " + a2);
        this.j = true;
    }

    private void s() {
        this.f34848a.a((d.InterfaceC0455d) this.f34849b);
        this.f34848a.a((d.a) this.f34849b);
        this.f34848a.a((d.c) this.f34849b);
        this.f34848a.a((d.e) this.f34849b);
        this.f34848a.a((d.b) this.f34849b);
        if (com.kwad.sdk.core.config.c.U()) {
            this.f34848a.a((com.kwai.video.ksvodplayerkit.b) this.f34849b);
        }
    }

    private void t() {
        this.f34848a.a((d.InterfaceC0455d) null);
        this.f34848a.a((d.a) null);
        this.f34848a.a((d.c) null);
        this.f34848a.a((d.e) null);
        this.f34848a.a((d.b) null);
        this.f34848a.a((com.kwai.video.ksvodplayerkit.b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
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
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i3);
        int i4 = i3 + 1;
        if (i4 < l.size()) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
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
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2) {
        this.f34848a.a(f2);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2, float f3) {
        this.f34848a.a(f2, f3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        this.f34848a.a((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.f34848a.a(surface);
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        if (this.f34848a == null || cVar == null) {
            return;
        }
        l lVar = new l();
        lVar.f38254c = String.valueOf(cVar.f33218a);
        lVar.f38255d = cVar.f33219b;
        this.f34848a.a(lVar);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar) {
        this.n = dVar;
        a(dVar.f33222c);
        a(dVar.f33220a, (Map<String, String>) null);
    }

    public void a(String str, Map<String, String> map) {
        this.f34850c = str;
        this.f34848a.a(str, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        this.f34854g = z;
        this.f34848a.a(z);
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
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", IntentConfig.START);
        r();
        this.f34848a.e();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        this.f34848a.g();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        return this.f34848a.f().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        return this.f34848a.f().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean j() {
        try {
            return this.f34848a.b();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        try {
            return this.f34848a.c();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long l() {
        try {
            return this.f34848a.d();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        boolean remove = l.remove(this);
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + l.size());
        this.f34853f = true;
        this.f34848a.a(new d.f() { // from class: com.kwad.sdk.core.video.a.d.2
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
            this.f34848a.f().reset();
        } catch (IllegalStateException unused) {
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

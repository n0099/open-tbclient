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
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.core.video.a.a {
    public static volatile boolean k = false;
    public static final Queue<d> l = new ConcurrentLinkedQueue();

    /* renamed from: a  reason: collision with root package name */
    public final k f34402a;

    /* renamed from: b  reason: collision with root package name */
    public final a f34403b;

    /* renamed from: c  reason: collision with root package name */
    public String f34404c;

    /* renamed from: d  reason: collision with root package name */
    public MediaDataSource f34405d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f34406e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34407f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34408g;

    /* renamed from: h  reason: collision with root package name */
    public int f34409h;
    public int i;
    public boolean j;
    public boolean m;
    public com.kwad.sdk.contentalliance.detail.video.d n;

    /* loaded from: classes6.dex */
    public static class a implements com.kwai.video.ksvodplayerkit.b, d.a, d.b, d.c, d.InterfaceC0466d, d.e, d.f {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<d> f34411a;

        public a(d dVar) {
            this.f34411a = new WeakReference<>(dVar);
        }

        private d c() {
            return this.f34411a.get();
        }

        @Override // com.kwai.video.ksvodplayerkit.d.f
        public void a() {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPlayerRelease");
        }

        @Override // com.kwai.video.ksvodplayerkit.d.a
        public void a(int i) {
            d c2 = c();
            if (c2 != null) {
                c2.a(i);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.c
        public void a(int i, int i2) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onEvent, what: " + i);
            d c2 = c();
            if (c2 != null) {
                if (i == 10100) {
                    c2.d();
                } else if (i == 10101) {
                    c2.c();
                } else {
                    if (i == 10209) {
                        c2.u();
                    }
                    c2.c(i, i2);
                }
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.e
        public void a(int i, int i2, int i3, int i4) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d c2 = c();
            if (c2 != null) {
                c2.a(i, i2);
                c2.f34409h = i3;
                c2.i = i4;
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void a(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
        }

        @Override // com.kwai.video.ksvodplayerkit.d.InterfaceC0466d
        public void b() {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "onPrepared");
            d c2 = c();
            if (c2 != null) {
                c2.b();
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.d.b
        public void b(int i, int i2) {
            d c2 = c();
            if (c2 != null) {
                c2.j = false;
                c2.b(i, i2);
            }
        }

        @Override // com.kwai.video.ksvodplayerkit.b
        public void b(@Nullable com.kwai.video.ksvodplayerkit.c cVar) {
            if (al.a().b()) {
                d c2 = c();
                if (c2 != null) {
                    c2.f34402a.a((com.kwai.video.ksvodplayerkit.b) null);
                }
            } else if (cVar != null) {
                long j = cVar.f37561b;
                if (j > 0) {
                    long j2 = cVar.l;
                    if (j2 != 0) {
                        al.a().a((j - cVar.f37560a) / j2);
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
        this.f34406e = obj;
        this.j = false;
        this.m = true;
        synchronized (obj) {
            this.f34402a = new k(context.getApplicationContext());
        }
        a(context);
        this.f34403b = new a(this);
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
        MediaDataSource mediaDataSource = this.f34405d;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f34405d = null;
        }
    }

    private void r() {
        if (this.j) {
            return;
        }
        int a2 = this.f34402a.a();
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "realPrepare: ret: " + a2);
        this.j = true;
    }

    private void s() {
        this.f34402a.a((d.InterfaceC0466d) this.f34403b);
        this.f34402a.a((d.a) this.f34403b);
        this.f34402a.a((d.c) this.f34403b);
        this.f34402a.a((d.e) this.f34403b);
        this.f34402a.a((d.b) this.f34403b);
        if (com.kwad.sdk.core.config.c.U()) {
            this.f34402a.a((com.kwai.video.ksvodplayerkit.b) this.f34403b);
        }
    }

    private void t() {
        this.f34402a.a((d.InterfaceC0466d) null);
        this.f34402a.a((d.a) null);
        this.f34402a.a((d.c) null);
        this.f34402a.a((d.e) null);
        this.f34402a.a((d.b) null);
        this.f34402a.a((com.kwai.video.ksvodplayerkit.b) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
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
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i2);
        int i3 = i2 + 1;
        if (i3 < l.size()) {
            com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
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
                poll.e();
            } else {
                com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2) {
        this.f34402a.a(f2);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(float f2, float f3) {
        this.f34402a.a(f2, f3);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(long j) {
        this.f34402a.a((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public void a(Surface surface) {
        this.f34402a.a(surface);
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(com.kwad.sdk.contentalliance.detail.video.c cVar) {
        if (this.f34402a == null || cVar == null) {
            return;
        }
        l lVar = new l();
        lVar.f37666c = String.valueOf(cVar.f32828a);
        lVar.f37667d = cVar.f32829b;
        this.f34402a.a(lVar);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar) {
        this.n = dVar;
        a(dVar.f32832c);
        a(dVar.f32830a, (Map<String, String>) null);
    }

    public void a(String str, Map<String, String> map) {
        this.f34404c = str;
        this.f34402a.a(str, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(boolean z) {
        this.f34408g = z;
        this.f34402a.a(z);
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
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", IntentConfig.START);
        r();
        this.f34402a.e();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void g() {
        this.f34402a.g();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int h() {
        return this.f34402a.f().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public int i() {
        return this.f34402a.f().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public boolean j() {
        try {
            return this.f34402a.b();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long k() {
        try {
            return this.f34402a.c();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public long l() {
        try {
            return this.f34402a.d();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void m() {
        boolean remove = l.remove(this);
        com.kwad.sdk.core.d.a.b("KwaiMediaPlayer", "release remote player ret: " + remove + ", player list size: " + l.size());
        this.f34407f = true;
        this.f34402a.a(new d.f() { // from class: com.kwad.sdk.core.video.a.d.2
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
            this.f34402a.f().reset();
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

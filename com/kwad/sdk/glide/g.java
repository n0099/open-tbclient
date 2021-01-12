package com.kwad.sdk.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.c.c;
import com.kwad.sdk.glide.c.i;
import com.kwad.sdk.glide.c.l;
import com.kwad.sdk.glide.c.m;
import com.kwad.sdk.glide.c.o;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.request.a.j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class g implements i {
    private static final com.kwad.sdk.glide.request.f d = com.kwad.sdk.glide.request.f.b(Bitmap.class).i();
    private static final com.kwad.sdk.glide.request.f e = com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.resource.d.c.class).i();
    private static final com.kwad.sdk.glide.request.f f = com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.c).a(Priority.LOW).b(true);

    /* renamed from: a  reason: collision with root package name */
    protected final c f10001a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f10002b;
    final com.kwad.sdk.glide.c.h c;
    @GuardedBy("this")
    private final m g;
    @GuardedBy("this")
    private final l h;
    @GuardedBy("this")
    private final o i;
    private final Runnable j;
    private final Handler k;
    private final com.kwad.sdk.glide.c.c l;
    private final CopyOnWriteArrayList<com.kwad.sdk.glide.request.e<Object>> m;
    @GuardedBy("this")
    private com.kwad.sdk.glide.request.f n;

    /* loaded from: classes4.dex */
    private class a implements c.a {
        @GuardedBy("RequestManager.this")

        /* renamed from: b  reason: collision with root package name */
        private final m f10005b;

        a(m mVar) {
            this.f10005b = mVar;
        }

        @Override // com.kwad.sdk.glide.c.c.a
        public void a(boolean z) {
            if (z) {
                synchronized (g.this) {
                    this.f10005b.d();
                }
            }
        }
    }

    public g(@NonNull c cVar, @NonNull com.kwad.sdk.glide.c.h hVar, @NonNull l lVar, @NonNull Context context) {
        this(cVar, hVar, lVar, new m(), cVar.d(), context);
    }

    g(c cVar, com.kwad.sdk.glide.c.h hVar, l lVar, m mVar, com.kwad.sdk.glide.c.d dVar, Context context) {
        this.i = new o();
        this.j = new Runnable() { // from class: com.kwad.sdk.glide.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.c.a(g.this);
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        this.f10001a = cVar;
        this.c = hVar;
        this.h = lVar;
        this.g = mVar;
        this.f10002b = context;
        this.l = dVar.a(context.getApplicationContext(), new a(mVar));
        if (k.c()) {
            this.k.post(this.j);
        } else {
            hVar.a(this);
        }
        hVar.a(this.l);
        this.m = new CopyOnWriteArrayList<>(cVar.e().a());
        a(cVar.e().b());
        cVar.a(this);
    }

    private void c(@NonNull j<?> jVar) {
        if (b(jVar) || this.f10001a.a(jVar) || jVar.b() == null) {
            return;
        }
        com.kwad.sdk.glide.request.c b2 = jVar.b();
        jVar.a((com.kwad.sdk.glide.request.c) null);
        b2.b();
    }

    @NonNull
    @CheckResult
    public <ResourceType> f<ResourceType> a(@NonNull Class<ResourceType> cls) {
        return new f<>(this.f10001a, this, cls, this.f10002b);
    }

    @NonNull
    @CheckResult
    public f<Drawable> a(@Nullable String str) {
        return g().a(str);
    }

    public synchronized void a() {
        this.g.a();
    }

    public synchronized void a(@Nullable j<?> jVar) {
        if (jVar != null) {
            c(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(@NonNull j<?> jVar, @NonNull com.kwad.sdk.glide.request.c cVar) {
        this.i.a(jVar);
        this.g.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(@NonNull com.kwad.sdk.glide.request.f fVar) {
        this.n = fVar.clone().j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public <T> h<?, T> b(Class<T> cls) {
        return this.f10001a.e().a(cls);
    }

    public synchronized void b() {
        this.g.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean b(@NonNull j<?> jVar) {
        boolean z = true;
        synchronized (this) {
            com.kwad.sdk.glide.request.c b2 = jVar.b();
            if (b2 != null) {
                if (this.g.b(b2)) {
                    this.i.b(jVar);
                    jVar.a((com.kwad.sdk.glide.request.c) null);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // com.kwad.sdk.glide.c.i
    public synchronized void c() {
        b();
        this.i.c();
    }

    @Override // com.kwad.sdk.glide.c.i
    public synchronized void d() {
        a();
        this.i.d();
    }

    @Override // com.kwad.sdk.glide.c.i
    public synchronized void e() {
        this.i.e();
        for (j<?> jVar : this.i.a()) {
            a(jVar);
        }
        this.i.b();
        this.g.c();
        this.c.b(this);
        this.c.b(this.l);
        this.k.removeCallbacks(this.j);
        this.f10001a.b(this);
    }

    @NonNull
    @CheckResult
    public f<Bitmap> f() {
        return a(Bitmap.class).a((com.kwad.sdk.glide.request.a<?>) d);
    }

    @NonNull
    @CheckResult
    public f<Drawable> g() {
        return a(Drawable.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.kwad.sdk.glide.request.e<Object>> h() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.kwad.sdk.glide.request.f i() {
        return this.n;
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.g + ", treeNode=" + this.h + "}";
    }
}

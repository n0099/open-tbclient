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
/* loaded from: classes7.dex */
public class g implements i {

    /* renamed from: d  reason: collision with root package name */
    public static final com.kwad.sdk.glide.request.f f35871d = com.kwad.sdk.glide.request.f.b(Bitmap.class).i();

    /* renamed from: e  reason: collision with root package name */
    public static final com.kwad.sdk.glide.request.f f35872e = com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.resource.d.c.class).i();

    /* renamed from: f  reason: collision with root package name */
    public static final com.kwad.sdk.glide.request.f f35873f = com.kwad.sdk.glide.request.f.b(com.kwad.sdk.glide.load.engine.h.f36226c).a(Priority.LOW).b(true);

    /* renamed from: a  reason: collision with root package name */
    public final c f35874a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f35875b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.c.h f35876c;
    @GuardedBy("this")

    /* renamed from: g  reason: collision with root package name */
    public final m f35877g;
    @GuardedBy("this")

    /* renamed from: h  reason: collision with root package name */
    public final l f35878h;
    @GuardedBy("this")

    /* renamed from: i  reason: collision with root package name */
    public final o f35879i;
    public final Runnable j;
    public final Handler k;
    public final com.kwad.sdk.glide.c.c l;
    public final CopyOnWriteArrayList<com.kwad.sdk.glide.request.e<Object>> m;
    @GuardedBy("this")
    public com.kwad.sdk.glide.request.f n;

    /* loaded from: classes7.dex */
    public class a implements c.a {
        @GuardedBy("RequestManager.this")

        /* renamed from: b  reason: collision with root package name */
        public final m f35882b;

        public a(m mVar) {
            this.f35882b = mVar;
        }

        @Override // com.kwad.sdk.glide.c.c.a
        public void a(boolean z) {
            if (z) {
                synchronized (g.this) {
                    this.f35882b.d();
                }
            }
        }
    }

    public g(@NonNull c cVar, @NonNull com.kwad.sdk.glide.c.h hVar, @NonNull l lVar, @NonNull Context context) {
        this(cVar, hVar, lVar, new m(), cVar.d(), context);
    }

    public g(c cVar, com.kwad.sdk.glide.c.h hVar, l lVar, m mVar, com.kwad.sdk.glide.c.d dVar, Context context) {
        this.f35879i = new o();
        this.j = new Runnable() { // from class: com.kwad.sdk.glide.g.1
            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                gVar.f35876c.a(gVar);
            }
        };
        this.k = new Handler(Looper.getMainLooper());
        this.f35874a = cVar;
        this.f35876c = hVar;
        this.f35878h = lVar;
        this.f35877g = mVar;
        this.f35875b = context;
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
        if (b(jVar) || this.f35874a.a(jVar) || jVar.b() == null) {
            return;
        }
        com.kwad.sdk.glide.request.c b2 = jVar.b();
        jVar.a((com.kwad.sdk.glide.request.c) null);
        b2.b();
    }

    @NonNull
    @CheckResult
    public <ResourceType> f<ResourceType> a(@NonNull Class<ResourceType> cls) {
        return new f<>(this.f35874a, this, cls, this.f35875b);
    }

    @NonNull
    @CheckResult
    public f<Drawable> a(@Nullable String str) {
        return g().a(str);
    }

    public synchronized void a() {
        this.f35877g.a();
    }

    public synchronized void a(@Nullable j<?> jVar) {
        if (jVar == null) {
            return;
        }
        c(jVar);
    }

    public synchronized void a(@NonNull j<?> jVar, @NonNull com.kwad.sdk.glide.request.c cVar) {
        this.f35879i.a(jVar);
        this.f35877g.a(cVar);
    }

    public synchronized void a(@NonNull com.kwad.sdk.glide.request.f fVar) {
        this.n = fVar.clone().j();
    }

    @NonNull
    public <T> h<?, T> b(Class<T> cls) {
        return this.f35874a.e().a(cls);
    }

    public synchronized void b() {
        this.f35877g.b();
    }

    public synchronized boolean b(@NonNull j<?> jVar) {
        com.kwad.sdk.glide.request.c b2 = jVar.b();
        if (b2 == null) {
            return true;
        }
        if (this.f35877g.b(b2)) {
            this.f35879i.b(jVar);
            jVar.a((com.kwad.sdk.glide.request.c) null);
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.c.i
    public synchronized void c() {
        b();
        this.f35879i.c();
    }

    @Override // com.kwad.sdk.glide.c.i
    public synchronized void d() {
        a();
        this.f35879i.d();
    }

    @Override // com.kwad.sdk.glide.c.i
    public synchronized void e() {
        this.f35879i.e();
        for (j<?> jVar : this.f35879i.a()) {
            a(jVar);
        }
        this.f35879i.b();
        this.f35877g.c();
        this.f35876c.b(this);
        this.f35876c.b(this.l);
        this.k.removeCallbacks(this.j);
        this.f35874a.b(this);
    }

    @NonNull
    @CheckResult
    public f<Bitmap> f() {
        return a(Bitmap.class).a((com.kwad.sdk.glide.request.a<?>) f35871d);
    }

    @NonNull
    @CheckResult
    public f<Drawable> g() {
        return a(Drawable.class);
    }

    public List<com.kwad.sdk.glide.request.e<Object>> h() {
        return this.m;
    }

    public synchronized com.kwad.sdk.glide.request.f i() {
        return this.n;
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f35877g + ", treeNode=" + this.f35878h + "}";
    }
}

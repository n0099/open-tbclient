package com.kwad.sdk.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.baidu.mobstat.Config;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.load.engine.i;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.request.a.i;
import com.kwad.sdk.glide.request.a.j;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public final class SingleRequest<R> implements a.c, i, c, g {

    /* renamed from: a  reason: collision with root package name */
    private static final Pools.Pool<SingleRequest<?>> f6821a = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC1142a<SingleRequest<?>>() { // from class: com.kwad.sdk.glide.request.SingleRequest.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC1142a
        /* renamed from: a */
        public SingleRequest<?> b() {
            return new SingleRequest<>();
        }
    });
    private static final boolean c = Log.isLoggable("Request", 2);
    private Drawable A;
    private int B;
    private int C;
    @Nullable
    private RuntimeException D;
    private boolean b;
    @Nullable
    private final String d;
    private final com.kwad.sdk.glide.g.a.c e;
    @Nullable
    private e<R> f;
    private d g;
    private Context h;
    private com.kwad.sdk.glide.e i;
    @Nullable
    private Object j;
    private Class<R> k;
    private a<?> l;
    private int m;
    private int n;
    private Priority o;
    private j<R> p;
    @Nullable
    private List<e<R>> q;
    private com.kwad.sdk.glide.load.engine.i r;
    private com.kwad.sdk.glide.request.b.c<? super R> s;
    private Executor t;
    private s<R> u;
    private i.d v;
    private long w;
    @GuardedBy("this")
    private Status x;
    private Drawable y;
    private Drawable z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    SingleRequest() {
        this.d = c ? String.valueOf(super.hashCode()) : null;
        this.e = com.kwad.sdk.glide.g.a.c.a();
    }

    private static int a(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(i * f);
    }

    private Drawable a(@DrawableRes int i) {
        return com.kwad.sdk.glide.load.resource.b.a.a(this.i, i, this.l.v() != null ? this.l.v() : this.h.getTheme());
    }

    public static <R> SingleRequest<R> a(Context context, com.kwad.sdk.glide.e eVar, Object obj, Class<R> cls, a<?> aVar, int i, int i2, Priority priority, j<R> jVar, e<R> eVar2, @Nullable List<e<R>> list, d dVar, com.kwad.sdk.glide.load.engine.i iVar, com.kwad.sdk.glide.request.b.c<? super R> cVar, Executor executor) {
        SingleRequest<R> singleRequest = (SingleRequest<R>) f6821a.acquire();
        if (singleRequest == null) {
            singleRequest = new SingleRequest<>();
        }
        singleRequest.b(context, eVar, obj, cls, aVar, i, i2, priority, jVar, eVar2, list, dVar, iVar, cVar, executor);
        return singleRequest;
    }

    private synchronized void a(GlideException glideException, int i) {
        boolean z;
        this.e.b();
        glideException.setOrigin(this.D);
        int e = this.i.e();
        if (e <= i) {
            Log.w("Glide", "Load failed for " + this.j + " with size [" + this.B + Config.EVENT_HEAT_X + this.C + "]", glideException);
            if (e <= 4) {
                glideException.logRootCauses("Glide");
            }
        }
        this.v = null;
        this.x = Status.FAILED;
        this.b = true;
        if (this.q != null) {
            z = false;
            for (e<R> eVar : this.q) {
                z |= eVar.a(glideException, this.j, this.p, r());
            }
        } else {
            z = false;
        }
        if (!((this.f != null && this.f.a(glideException, this.j, this.p, r())) | z)) {
            n();
        }
        this.b = false;
        t();
    }

    private void a(s<?> sVar) {
        this.r.a(sVar);
        this.u = null;
    }

    private synchronized void a(s<R> sVar, R r, DataSource dataSource) {
        boolean z;
        boolean r2 = r();
        this.x = Status.COMPLETE;
        this.u = sVar;
        if (this.i.e() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.j + " with size [" + this.B + Config.EVENT_HEAT_X + this.C + "] in " + com.kwad.sdk.glide.g.f.a(this.w) + " ms");
        }
        this.b = true;
        if (this.q != null) {
            z = false;
            for (e<R> eVar : this.q) {
                z |= eVar.a(r, this.j, this.p, dataSource, r2);
            }
        } else {
            z = false;
        }
        if (!((this.f != null && this.f.a(r, this.j, this.p, dataSource, r2)) | z)) {
            this.p.a(r, this.s.a(dataSource, r2));
        }
        this.b = false;
        s();
    }

    private void a(String str) {
        Log.v("Request", str + " this: " + this.d);
    }

    private synchronized boolean a(SingleRequest<?> singleRequest) {
        boolean z;
        synchronized (this) {
            synchronized (singleRequest) {
                z = (this.q == null ? 0 : this.q.size()) == (singleRequest.q == null ? 0 : singleRequest.q.size());
            }
        }
        return z;
    }

    private synchronized void b(Context context, com.kwad.sdk.glide.e eVar, Object obj, Class<R> cls, a<?> aVar, int i, int i2, Priority priority, j<R> jVar, e<R> eVar2, @Nullable List<e<R>> list, d dVar, com.kwad.sdk.glide.load.engine.i iVar, com.kwad.sdk.glide.request.b.c<? super R> cVar, Executor executor) {
        this.h = context;
        this.i = eVar;
        this.j = obj;
        this.k = cls;
        this.l = aVar;
        this.m = i;
        this.n = i2;
        this.o = priority;
        this.p = jVar;
        this.f = eVar2;
        this.q = list;
        this.g = dVar;
        this.r = iVar;
        this.s = cVar;
        this.t = executor;
        this.x = Status.PENDING;
        if (this.D == null && eVar.g()) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    private void i() {
        j();
        this.e.b();
        this.p.b(this);
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
    }

    private void j() {
        if (this.b) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private Drawable k() {
        if (this.y == null) {
            this.y = this.l.p();
            if (this.y == null && this.l.q() > 0) {
                this.y = a(this.l.q());
            }
        }
        return this.y;
    }

    private Drawable l() {
        if (this.z == null) {
            this.z = this.l.s();
            if (this.z == null && this.l.r() > 0) {
                this.z = a(this.l.r());
            }
        }
        return this.z;
    }

    private Drawable m() {
        if (this.A == null) {
            this.A = this.l.u();
            if (this.A == null && this.l.t() > 0) {
                this.A = a(this.l.t());
            }
        }
        return this.A;
    }

    private synchronized void n() {
        if (q()) {
            Drawable m = this.j == null ? m() : null;
            if (m == null) {
                m = k();
            }
            if (m == null) {
                m = l();
            }
            this.p.c(m);
        }
    }

    private boolean o() {
        return this.g == null || this.g.b(this);
    }

    private boolean p() {
        return this.g == null || this.g.d(this);
    }

    private boolean q() {
        return this.g == null || this.g.c(this);
    }

    private boolean r() {
        return this.g == null || !this.g.i();
    }

    private void s() {
        if (this.g != null) {
            this.g.e(this);
        }
    }

    private void t() {
        if (this.g != null) {
            this.g.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized void a() {
        j();
        this.e.b();
        this.w = com.kwad.sdk.glide.g.f.a();
        if (this.j == null) {
            if (k.a(this.m, this.n)) {
                this.B = this.m;
                this.C = this.n;
            }
            a(new GlideException("Received null model"), m() == null ? 5 : 3);
        } else if (this.x == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else {
            if (this.x == Status.COMPLETE) {
                a((s<?>) this.u, DataSource.MEMORY_CACHE);
            } else {
                this.x = Status.WAITING_FOR_SIZE;
                if (k.a(this.m, this.n)) {
                    a(this.m, this.n);
                } else {
                    this.p.a((com.kwad.sdk.glide.request.a.i) this);
                }
                if ((this.x == Status.RUNNING || this.x == Status.WAITING_FOR_SIZE) && q()) {
                    this.p.b(l());
                }
                if (c) {
                    a("finished run method in " + com.kwad.sdk.glide.g.f.a(this.w));
                }
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.a.i
    public synchronized void a(int i, int i2) {
        this.e.b();
        if (c) {
            a("Got onSizeReady in " + com.kwad.sdk.glide.g.f.a(this.w));
        }
        if (this.x == Status.WAITING_FOR_SIZE) {
            this.x = Status.RUNNING;
            float D = this.l.D();
            this.B = a(i, D);
            this.C = a(i2, D);
            if (c) {
                a("finished setup for calling load in " + com.kwad.sdk.glide.g.f.a(this.w));
            }
            this.v = this.r.a(this.i, this.j, this.l.x(), this.B, this.C, this.l.n(), this.k, this.o, this.l.o(), this.l.k(), this.l.l(), this.l.E(), this.l.m(), this.l.w(), this.l.F(), this.l.G(), this.l.H(), this, this.t);
            if (this.x != Status.RUNNING) {
                this.v = null;
            }
            if (c) {
                a("finished onSizeReady in " + com.kwad.sdk.glide.g.f.a(this.w));
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.g
    public synchronized void a(GlideException glideException) {
        a(glideException, 5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.kwad.sdk.glide.request.SingleRequest<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.glide.request.g
    public synchronized void a(s<?> sVar, DataSource dataSource) {
        this.e.b();
        this.v = null;
        if (sVar == null) {
            a(new GlideException("Expected to receive a Resource<R> with an object of " + this.k + " inside, but instead got null."));
        } else {
            Object e = sVar.e();
            if (e == null || !this.k.isAssignableFrom(e.getClass())) {
                a(sVar);
                a(new GlideException("Expected to receive an object of " + this.k + " but instead got " + (e != null ? e.getClass() : "") + "{" + e + "} inside Resource{" + sVar + "}." + (e != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
            } else if (o()) {
                a(sVar, e, dataSource);
            } else {
                a(sVar);
                this.x = Status.COMPLETE;
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean a(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar instanceof SingleRequest) {
                SingleRequest<?> singleRequest = (SingleRequest) cVar;
                synchronized (singleRequest) {
                    if (this.m == singleRequest.m && this.n == singleRequest.n && k.b(this.j, singleRequest.j) && this.k.equals(singleRequest.k) && this.l.equals(singleRequest.l) && this.o == singleRequest.o && a(singleRequest)) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized void b() {
        j();
        this.e.b();
        if (this.x != Status.CLEARED) {
            i();
            if (this.u != null) {
                a((s<?>) this.u);
            }
            if (p()) {
                this.p.a(l());
            }
            this.x = Status.CLEARED;
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean c() {
        boolean z;
        if (this.x != Status.RUNNING) {
            z = this.x == Status.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        return this.e;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean e() {
        return e_();
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean e_() {
        return this.x == Status.COMPLETE;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean f() {
        return this.x == Status.CLEARED;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean g() {
        return this.x == Status.FAILED;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized void h() {
        j();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = -1;
        this.p = null;
        this.q = null;
        this.f = null;
        this.g = null;
        this.s = null;
        this.v = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = -1;
        this.C = -1;
        this.D = null;
        f6821a.release(this);
    }
}

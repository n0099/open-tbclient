package com.kwad.sdk.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes6.dex */
public final class SingleRequest<R> implements a.c, i, c, g {

    /* renamed from: a  reason: collision with root package name */
    public static final Pools.Pool<SingleRequest<?>> f35756a = com.kwad.sdk.glide.g.a.a.a(150, new a.InterfaceC0410a<SingleRequest<?>>() { // from class: com.kwad.sdk.glide.request.SingleRequest.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.g.a.a.InterfaceC0410a
        /* renamed from: a */
        public SingleRequest<?> b() {
            return new SingleRequest<>();
        }
    });

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f35757c = Log.isLoggable(com.bumptech.glide.request.SingleRequest.TAG, 2);
    public Drawable A;
    public int B;
    public int C;
    @Nullable
    public RuntimeException D;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35758b;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f35759d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f35760e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public e<R> f35761f;

    /* renamed from: g  reason: collision with root package name */
    public d f35762g;

    /* renamed from: h  reason: collision with root package name */
    public Context f35763h;
    public com.kwad.sdk.glide.e i;
    @Nullable
    public Object j;
    public Class<R> k;
    public a<?> l;
    public int m;
    public int n;
    public Priority o;
    public j<R> p;
    @Nullable
    public List<e<R>> q;
    public com.kwad.sdk.glide.load.engine.i r;
    public com.kwad.sdk.glide.request.b.c<? super R> s;
    public Executor t;
    public s<R> u;
    public i.d v;
    public long w;
    @GuardedBy("this")
    public Status x;
    public Drawable y;
    public Drawable z;

    /* loaded from: classes6.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest() {
        this.f35759d = f35757c ? String.valueOf(super.hashCode()) : null;
        this.f35760e = com.kwad.sdk.glide.g.a.c.a();
    }

    public static int a(int i, float f2) {
        return i == Integer.MIN_VALUE ? i : Math.round(f2 * i);
    }

    private Drawable a(@DrawableRes int i) {
        return com.kwad.sdk.glide.load.resource.b.a.a(this.i, i, this.l.v() != null ? this.l.v() : this.f35763h.getTheme());
    }

    public static <R> SingleRequest<R> a(Context context, com.kwad.sdk.glide.e eVar, Object obj, Class<R> cls, a<?> aVar, int i, int i2, Priority priority, j<R> jVar, e<R> eVar2, @Nullable List<e<R>> list, d dVar, com.kwad.sdk.glide.load.engine.i iVar, com.kwad.sdk.glide.request.b.c<? super R> cVar, Executor executor) {
        SingleRequest<?> acquire = f35756a.acquire();
        if (acquire == null) {
            acquire = new SingleRequest();
        }
        acquire.b(context, eVar, obj, cls, aVar, i, i2, priority, jVar, eVar2, list, dVar, iVar, cVar, executor);
        return acquire;
    }

    private synchronized void a(GlideException glideException, int i) {
        boolean z;
        this.f35760e.b();
        glideException.setOrigin(this.D);
        int e2 = this.i.e();
        if (e2 <= i) {
            Log.w("Glide", "Load failed for " + this.j + " with size [" + this.B + "x" + this.C + "]", glideException);
            if (e2 <= 4) {
                glideException.logRootCauses("Glide");
            }
        }
        this.v = null;
        this.x = Status.FAILED;
        boolean z2 = true;
        this.f35758b = true;
        if (this.q != null) {
            z = false;
            for (e<R> eVar : this.q) {
                z |= eVar.a(glideException, this.j, this.p, r());
            }
        } else {
            z = false;
        }
        if (this.f35761f == null || !this.f35761f.a(glideException, this.j, this.p, r())) {
            z2 = false;
        }
        if (!(z | z2)) {
            n();
        }
        this.f35758b = false;
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
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.j + " with size [" + this.B + "x" + this.C + "] in " + com.kwad.sdk.glide.g.f.a(this.w) + " ms");
        }
        boolean z2 = true;
        this.f35758b = true;
        if (this.q != null) {
            z = false;
            for (e<R> eVar : this.q) {
                z |= eVar.a(r, this.j, this.p, dataSource, r2);
            }
        } else {
            z = false;
        }
        if (this.f35761f == null || !this.f35761f.a(r, this.j, this.p, dataSource, r2)) {
            z2 = false;
        }
        if (!(z2 | z)) {
            this.p.a(r, this.s.a(dataSource, r2));
        }
        this.f35758b = false;
        s();
    }

    private void a(String str) {
        Log.v(com.bumptech.glide.request.SingleRequest.TAG, str + " this: " + this.f35759d);
    }

    private synchronized boolean a(SingleRequest<?> singleRequest) {
        boolean z;
        synchronized (singleRequest) {
            z = (this.q == null ? 0 : this.q.size()) == (singleRequest.q == null ? 0 : singleRequest.q.size());
        }
        return z;
    }

    private synchronized void b(Context context, com.kwad.sdk.glide.e eVar, Object obj, Class<R> cls, a<?> aVar, int i, int i2, Priority priority, j<R> jVar, e<R> eVar2, @Nullable List<e<R>> list, d dVar, com.kwad.sdk.glide.load.engine.i iVar, com.kwad.sdk.glide.request.b.c<? super R> cVar, Executor executor) {
        this.f35763h = context;
        this.i = eVar;
        this.j = obj;
        this.k = cls;
        this.l = aVar;
        this.m = i;
        this.n = i2;
        this.o = priority;
        this.p = jVar;
        this.f35761f = eVar2;
        this.q = list;
        this.f35762g = dVar;
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
        this.f35760e.b();
        this.p.b(this);
        i.d dVar = this.v;
        if (dVar != null) {
            dVar.a();
            this.v = null;
        }
    }

    private void j() {
        if (this.f35758b) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private Drawable k() {
        if (this.y == null) {
            Drawable p = this.l.p();
            this.y = p;
            if (p == null && this.l.q() > 0) {
                this.y = a(this.l.q());
            }
        }
        return this.y;
    }

    private Drawable l() {
        if (this.z == null) {
            Drawable s = this.l.s();
            this.z = s;
            if (s == null && this.l.r() > 0) {
                this.z = a(this.l.r());
            }
        }
        return this.z;
    }

    private Drawable m() {
        if (this.A == null) {
            Drawable u = this.l.u();
            this.A = u;
            if (u == null && this.l.t() > 0) {
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
        d dVar = this.f35762g;
        return dVar == null || dVar.b(this);
    }

    private boolean p() {
        d dVar = this.f35762g;
        return dVar == null || dVar.d(this);
    }

    private boolean q() {
        d dVar = this.f35762g;
        return dVar == null || dVar.c(this);
    }

    private boolean r() {
        d dVar = this.f35762g;
        return dVar == null || !dVar.i();
    }

    private void s() {
        d dVar = this.f35762g;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    private void t() {
        d dVar = this.f35762g;
        if (dVar != null) {
            dVar.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized void a() {
        j();
        this.f35760e.b();
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
                return;
            }
            this.x = Status.WAITING_FOR_SIZE;
            if (k.a(this.m, this.n)) {
                a(this.m, this.n);
            } else {
                this.p.a((com.kwad.sdk.glide.request.a.i) this);
            }
            if ((this.x == Status.RUNNING || this.x == Status.WAITING_FOR_SIZE) && q()) {
                this.p.b(l());
            }
            if (f35757c) {
                a("finished run method in " + com.kwad.sdk.glide.g.f.a(this.w));
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.a.i
    public synchronized void a(int i, int i2) {
        try {
            this.f35760e.b();
            if (f35757c) {
                a("Got onSizeReady in " + com.kwad.sdk.glide.g.f.a(this.w));
            }
            if (this.x != Status.WAITING_FOR_SIZE) {
                return;
            }
            this.x = Status.RUNNING;
            float D = this.l.D();
            this.B = a(i, D);
            this.C = a(i2, D);
            if (f35757c) {
                a("finished setup for calling load in " + com.kwad.sdk.glide.g.f.a(this.w));
            }
            try {
                try {
                    this.v = this.r.a(this.i, this.j, this.l.x(), this.B, this.C, this.l.n(), this.k, this.o, this.l.o(), this.l.k(), this.l.l(), this.l.E(), this.l.m(), this.l.w(), this.l.F(), this.l.G(), this.l.H(), this, this.t);
                    if (this.x != Status.RUNNING) {
                        this.v = null;
                    }
                    if (f35757c) {
                        a("finished onSizeReady in " + com.kwad.sdk.glide.g.f.a(this.w));
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.kwad.sdk.glide.request.g
    public synchronized void a(GlideException glideException) {
        a(glideException, 5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.kwad.sdk.glide.request.SingleRequest<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.glide.request.g
    public synchronized void a(s<?> sVar, DataSource dataSource) {
        this.f35760e.b();
        this.v = null;
        if (sVar == null) {
            a(new GlideException("Expected to receive a Resource<R> with an object of " + this.k + " inside, but instead got null."));
            return;
        }
        Object e2 = sVar.e();
        if (e2 != null && this.k.isAssignableFrom(e2.getClass())) {
            if (o()) {
                a(sVar, e2, dataSource);
                return;
            }
            a(sVar);
            this.x = Status.COMPLETE;
            return;
        }
        a(sVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.k);
        sb.append(" but instead got ");
        sb.append(e2 != null ? e2.getClass() : "");
        sb.append(StringUtil.ARRAY_START);
        sb.append(e2);
        sb.append("} inside Resource{");
        sb.append(sVar);
        sb.append("}.");
        sb.append(e2 != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        a(new GlideException(sb.toString()));
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized boolean a(c cVar) {
        boolean z = false;
        if (cVar instanceof SingleRequest) {
            SingleRequest<?> singleRequest = (SingleRequest) cVar;
            synchronized (singleRequest) {
                if (this.m == singleRequest.m && this.n == singleRequest.n && k.b(this.j, singleRequest.j) && this.k.equals(singleRequest.k) && this.l.equals(singleRequest.l) && this.o == singleRequest.o && a(singleRequest)) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.c
    public synchronized void b() {
        j();
        this.f35760e.b();
        if (this.x == Status.CLEARED) {
            return;
        }
        i();
        if (this.u != null) {
            a((s<?>) this.u);
        }
        if (p()) {
            this.p.a(l());
        }
        this.x = Status.CLEARED;
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
        return this.f35760e;
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
        this.f35763h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = -1;
        this.p = null;
        this.q = null;
        this.f35761f = null;
        this.f35762g = null;
        this.s = null;
        this.v = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = -1;
        this.C = -1;
        this.D = null;
        f35756a.release(this);
    }
}

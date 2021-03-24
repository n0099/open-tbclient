package d.c.c.a.b;

import d.c.c.a.b.v;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final a0 f65459e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.w f65460f;

    /* renamed from: g  reason: collision with root package name */
    public final int f65461g;

    /* renamed from: h  reason: collision with root package name */
    public final String f65462h;
    public final u i;
    public final v j;
    public final d k;
    public final c l;
    public final c m;
    public final c n;
    public final long o;
    public final long p;
    public volatile h q;

    public c(a aVar) {
        this.f65459e = aVar.f65463a;
        this.f65460f = aVar.f65464b;
        this.f65461g = aVar.f65465c;
        this.f65462h = aVar.f65466d;
        this.i = aVar.f65467e;
        this.j = aVar.f65468f.c();
        this.k = aVar.f65469g;
        this.l = aVar.f65470h;
        this.m = aVar.i;
        this.n = aVar.j;
        this.o = aVar.k;
        this.p = aVar.l;
    }

    public h A() {
        h hVar = this.q;
        if (hVar != null) {
            return hVar;
        }
        h a2 = h.a(this.j);
        this.q = a2;
        return a2;
    }

    public long B() {
        return this.o;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d dVar = this.k;
        if (dVar != null) {
            dVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public long m() {
        return this.p;
    }

    public a0 n() {
        return this.f65459e;
    }

    public String o(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String c2 = this.j.c(str);
        return c2 != null ? c2 : str2;
    }

    public com.bytedance.sdk.a.b.w q() {
        return this.f65460f;
    }

    public int r() {
        return this.f65461g;
    }

    public boolean s() {
        int i = this.f65461g;
        return i >= 200 && i < 300;
    }

    public String t() {
        return this.f65462h;
    }

    public String toString() {
        return "Response{protocol=" + this.f65460f + ", code=" + this.f65461g + ", message=" + this.f65462h + ", url=" + this.f65459e.a() + '}';
    }

    public u v() {
        return this.i;
    }

    public v w() {
        return this.j;
    }

    public d x() {
        return this.k;
    }

    public a y() {
        return new a(this);
    }

    public c z() {
        return this.n;
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public a0 f65463a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.a.b.w f65464b;

        /* renamed from: c  reason: collision with root package name */
        public int f65465c;

        /* renamed from: d  reason: collision with root package name */
        public String f65466d;

        /* renamed from: e  reason: collision with root package name */
        public u f65467e;

        /* renamed from: f  reason: collision with root package name */
        public v.a f65468f;

        /* renamed from: g  reason: collision with root package name */
        public d f65469g;

        /* renamed from: h  reason: collision with root package name */
        public c f65470h;
        public c i;
        public c j;
        public long k;
        public long l;

        public a() {
            this.f65465c = -1;
            this.f65468f = new v.a();
        }

        public a a(int i) {
            this.f65465c = i;
            return this;
        }

        public a b(long j) {
            this.k = j;
            return this;
        }

        public a c(c cVar) {
            if (cVar != null) {
                l("networkResponse", cVar);
            }
            this.f65470h = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f65469g = dVar;
            return this;
        }

        public a e(u uVar) {
            this.f65467e = uVar;
            return this;
        }

        public a f(v vVar) {
            this.f65468f = vVar.h();
            return this;
        }

        public a g(com.bytedance.sdk.a.b.w wVar) {
            this.f65464b = wVar;
            return this;
        }

        public a h(a0 a0Var) {
            this.f65463a = a0Var;
            return this;
        }

        public a i(String str) {
            this.f65466d = str;
            return this;
        }

        public a j(String str, String str2) {
            this.f65468f.b(str, str2);
            return this;
        }

        public c k() {
            if (this.f65463a != null) {
                if (this.f65464b != null) {
                    if (this.f65465c >= 0) {
                        if (this.f65466d != null) {
                            return new c(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f65465c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }

        public final void l(String str, c cVar) {
            if (cVar.k == null) {
                if (cVar.l == null) {
                    if (cVar.m == null) {
                        if (cVar.n == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        public a m(long j) {
            this.l = j;
            return this;
        }

        public a n(c cVar) {
            if (cVar != null) {
                l("cacheResponse", cVar);
            }
            this.i = cVar;
            return this;
        }

        public a o(c cVar) {
            if (cVar != null) {
                p(cVar);
            }
            this.j = cVar;
            return this;
        }

        public final void p(c cVar) {
            if (cVar.k != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a(c cVar) {
            this.f65465c = -1;
            this.f65463a = cVar.f65459e;
            this.f65464b = cVar.f65460f;
            this.f65465c = cVar.f65461g;
            this.f65466d = cVar.f65462h;
            this.f65467e = cVar.i;
            this.f65468f = cVar.j.h();
            this.f65469g = cVar.k;
            this.f65470h = cVar.l;
            this.i = cVar.m;
            this.j = cVar.n;
            this.k = cVar.o;
            this.l = cVar.p;
        }
    }
}

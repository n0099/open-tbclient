package d.c.c.a.b;

import d.c.c.a.b.v;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final a0 f65460e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.w f65461f;

    /* renamed from: g  reason: collision with root package name */
    public final int f65462g;

    /* renamed from: h  reason: collision with root package name */
    public final String f65463h;
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
        this.f65460e = aVar.f65464a;
        this.f65461f = aVar.f65465b;
        this.f65462g = aVar.f65466c;
        this.f65463h = aVar.f65467d;
        this.i = aVar.f65468e;
        this.j = aVar.f65469f.c();
        this.k = aVar.f65470g;
        this.l = aVar.f65471h;
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
        return this.f65460e;
    }

    public String o(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String c2 = this.j.c(str);
        return c2 != null ? c2 : str2;
    }

    public com.bytedance.sdk.a.b.w q() {
        return this.f65461f;
    }

    public int r() {
        return this.f65462g;
    }

    public boolean s() {
        int i = this.f65462g;
        return i >= 200 && i < 300;
    }

    public String t() {
        return this.f65463h;
    }

    public String toString() {
        return "Response{protocol=" + this.f65461f + ", code=" + this.f65462g + ", message=" + this.f65463h + ", url=" + this.f65460e.a() + '}';
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
        public a0 f65464a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.a.b.w f65465b;

        /* renamed from: c  reason: collision with root package name */
        public int f65466c;

        /* renamed from: d  reason: collision with root package name */
        public String f65467d;

        /* renamed from: e  reason: collision with root package name */
        public u f65468e;

        /* renamed from: f  reason: collision with root package name */
        public v.a f65469f;

        /* renamed from: g  reason: collision with root package name */
        public d f65470g;

        /* renamed from: h  reason: collision with root package name */
        public c f65471h;
        public c i;
        public c j;
        public long k;
        public long l;

        public a() {
            this.f65466c = -1;
            this.f65469f = new v.a();
        }

        public a a(int i) {
            this.f65466c = i;
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
            this.f65471h = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f65470g = dVar;
            return this;
        }

        public a e(u uVar) {
            this.f65468e = uVar;
            return this;
        }

        public a f(v vVar) {
            this.f65469f = vVar.h();
            return this;
        }

        public a g(com.bytedance.sdk.a.b.w wVar) {
            this.f65465b = wVar;
            return this;
        }

        public a h(a0 a0Var) {
            this.f65464a = a0Var;
            return this;
        }

        public a i(String str) {
            this.f65467d = str;
            return this;
        }

        public a j(String str, String str2) {
            this.f65469f.b(str, str2);
            return this;
        }

        public c k() {
            if (this.f65464a != null) {
                if (this.f65465b != null) {
                    if (this.f65466c >= 0) {
                        if (this.f65467d != null) {
                            return new c(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f65466c);
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
            this.f65466c = -1;
            this.f65464a = cVar.f65460e;
            this.f65465b = cVar.f65461f;
            this.f65466c = cVar.f65462g;
            this.f65467d = cVar.f65463h;
            this.f65468e = cVar.i;
            this.f65469f = cVar.j.h();
            this.f65470g = cVar.k;
            this.f65471h = cVar.l;
            this.i = cVar.m;
            this.j = cVar.n;
            this.k = cVar.o;
            this.l = cVar.p;
        }
    }
}

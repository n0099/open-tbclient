package d.b.c.a.b;

import d.b.c.a.b.v;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final a0 f64786e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.w f64787f;

    /* renamed from: g  reason: collision with root package name */
    public final int f64788g;

    /* renamed from: h  reason: collision with root package name */
    public final String f64789h;

    /* renamed from: i  reason: collision with root package name */
    public final u f64790i;
    public final v j;
    public final d k;
    public final c l;
    public final c m;
    public final c n;
    public final long o;
    public final long p;
    public volatile h q;

    public c(a aVar) {
        this.f64786e = aVar.f64791a;
        this.f64787f = aVar.f64792b;
        this.f64788g = aVar.f64793c;
        this.f64789h = aVar.f64794d;
        this.f64790i = aVar.f64795e;
        this.j = aVar.f64796f.c();
        this.k = aVar.f64797g;
        this.l = aVar.f64798h;
        this.m = aVar.f64799i;
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
        return this.f64786e;
    }

    public String o(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String c2 = this.j.c(str);
        return c2 != null ? c2 : str2;
    }

    public com.bytedance.sdk.a.b.w q() {
        return this.f64787f;
    }

    public int r() {
        return this.f64788g;
    }

    public boolean s() {
        int i2 = this.f64788g;
        return i2 >= 200 && i2 < 300;
    }

    public String t() {
        return this.f64789h;
    }

    public String toString() {
        return "Response{protocol=" + this.f64787f + ", code=" + this.f64788g + ", message=" + this.f64789h + ", url=" + this.f64786e.a() + '}';
    }

    public u v() {
        return this.f64790i;
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
        public a0 f64791a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.a.b.w f64792b;

        /* renamed from: c  reason: collision with root package name */
        public int f64793c;

        /* renamed from: d  reason: collision with root package name */
        public String f64794d;

        /* renamed from: e  reason: collision with root package name */
        public u f64795e;

        /* renamed from: f  reason: collision with root package name */
        public v.a f64796f;

        /* renamed from: g  reason: collision with root package name */
        public d f64797g;

        /* renamed from: h  reason: collision with root package name */
        public c f64798h;

        /* renamed from: i  reason: collision with root package name */
        public c f64799i;
        public c j;
        public long k;
        public long l;

        public a() {
            this.f64793c = -1;
            this.f64796f = new v.a();
        }

        public a a(int i2) {
            this.f64793c = i2;
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
            this.f64798h = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f64797g = dVar;
            return this;
        }

        public a e(u uVar) {
            this.f64795e = uVar;
            return this;
        }

        public a f(v vVar) {
            this.f64796f = vVar.h();
            return this;
        }

        public a g(com.bytedance.sdk.a.b.w wVar) {
            this.f64792b = wVar;
            return this;
        }

        public a h(a0 a0Var) {
            this.f64791a = a0Var;
            return this;
        }

        public a i(String str) {
            this.f64794d = str;
            return this;
        }

        public a j(String str, String str2) {
            this.f64796f.b(str, str2);
            return this;
        }

        public c k() {
            if (this.f64791a != null) {
                if (this.f64792b != null) {
                    if (this.f64793c >= 0) {
                        if (this.f64794d != null) {
                            return new c(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f64793c);
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
            this.f64799i = cVar;
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
            this.f64793c = -1;
            this.f64791a = cVar.f64786e;
            this.f64792b = cVar.f64787f;
            this.f64793c = cVar.f64788g;
            this.f64794d = cVar.f64789h;
            this.f64795e = cVar.f64790i;
            this.f64796f = cVar.j.h();
            this.f64797g = cVar.k;
            this.f64798h = cVar.l;
            this.f64799i = cVar.m;
            this.j = cVar.n;
            this.k = cVar.o;
            this.l = cVar.p;
        }
    }
}

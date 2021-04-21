package d.c.c.a.b;

import d.c.c.a.b.v;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final a0 f66400e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.w f66401f;

    /* renamed from: g  reason: collision with root package name */
    public final int f66402g;

    /* renamed from: h  reason: collision with root package name */
    public final String f66403h;
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
        this.f66400e = aVar.f66404a;
        this.f66401f = aVar.f66405b;
        this.f66402g = aVar.f66406c;
        this.f66403h = aVar.f66407d;
        this.i = aVar.f66408e;
        this.j = aVar.f66409f.c();
        this.k = aVar.f66410g;
        this.l = aVar.f66411h;
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
        return this.f66400e;
    }

    public String o(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String c2 = this.j.c(str);
        return c2 != null ? c2 : str2;
    }

    public com.bytedance.sdk.a.b.w q() {
        return this.f66401f;
    }

    public int r() {
        return this.f66402g;
    }

    public boolean s() {
        int i = this.f66402g;
        return i >= 200 && i < 300;
    }

    public String t() {
        return this.f66403h;
    }

    public String toString() {
        return "Response{protocol=" + this.f66401f + ", code=" + this.f66402g + ", message=" + this.f66403h + ", url=" + this.f66400e.a() + '}';
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
        public a0 f66404a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.a.b.w f66405b;

        /* renamed from: c  reason: collision with root package name */
        public int f66406c;

        /* renamed from: d  reason: collision with root package name */
        public String f66407d;

        /* renamed from: e  reason: collision with root package name */
        public u f66408e;

        /* renamed from: f  reason: collision with root package name */
        public v.a f66409f;

        /* renamed from: g  reason: collision with root package name */
        public d f66410g;

        /* renamed from: h  reason: collision with root package name */
        public c f66411h;
        public c i;
        public c j;
        public long k;
        public long l;

        public a() {
            this.f66406c = -1;
            this.f66409f = new v.a();
        }

        public a a(int i) {
            this.f66406c = i;
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
            this.f66411h = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f66410g = dVar;
            return this;
        }

        public a e(u uVar) {
            this.f66408e = uVar;
            return this;
        }

        public a f(v vVar) {
            this.f66409f = vVar.h();
            return this;
        }

        public a g(com.bytedance.sdk.a.b.w wVar) {
            this.f66405b = wVar;
            return this;
        }

        public a h(a0 a0Var) {
            this.f66404a = a0Var;
            return this;
        }

        public a i(String str) {
            this.f66407d = str;
            return this;
        }

        public a j(String str, String str2) {
            this.f66409f.b(str, str2);
            return this;
        }

        public c k() {
            if (this.f66404a != null) {
                if (this.f66405b != null) {
                    if (this.f66406c >= 0) {
                        if (this.f66407d != null) {
                            return new c(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f66406c);
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
            this.f66406c = -1;
            this.f66404a = cVar.f66400e;
            this.f66405b = cVar.f66401f;
            this.f66406c = cVar.f66402g;
            this.f66407d = cVar.f66403h;
            this.f66408e = cVar.i;
            this.f66409f = cVar.j.h();
            this.f66410g = cVar.k;
            this.f66411h = cVar.l;
            this.i = cVar.m;
            this.j = cVar.n;
            this.k = cVar.o;
            this.l = cVar.p;
        }
    }
}

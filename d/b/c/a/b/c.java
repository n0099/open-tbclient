package d.b.c.a.b;

import d.b.c.a.b.v;
import java.io.Closeable;
/* loaded from: classes6.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final a0 f65472e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.w f65473f;

    /* renamed from: g  reason: collision with root package name */
    public final int f65474g;

    /* renamed from: h  reason: collision with root package name */
    public final String f65475h;

    /* renamed from: i  reason: collision with root package name */
    public final u f65476i;
    public final v j;
    public final d k;
    public final c l;
    public final c m;
    public final c n;
    public final long o;
    public final long p;
    public volatile h q;

    public c(a aVar) {
        this.f65472e = aVar.f65477a;
        this.f65473f = aVar.f65478b;
        this.f65474g = aVar.f65479c;
        this.f65475h = aVar.f65480d;
        this.f65476i = aVar.f65481e;
        this.j = aVar.f65482f.c();
        this.k = aVar.f65483g;
        this.l = aVar.f65484h;
        this.m = aVar.f65485i;
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
        return this.f65472e;
    }

    public String o(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String c2 = this.j.c(str);
        return c2 != null ? c2 : str2;
    }

    public com.bytedance.sdk.a.b.w q() {
        return this.f65473f;
    }

    public int r() {
        return this.f65474g;
    }

    public boolean s() {
        int i2 = this.f65474g;
        return i2 >= 200 && i2 < 300;
    }

    public String t() {
        return this.f65475h;
    }

    public String toString() {
        return "Response{protocol=" + this.f65473f + ", code=" + this.f65474g + ", message=" + this.f65475h + ", url=" + this.f65472e.a() + '}';
    }

    public u v() {
        return this.f65476i;
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

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public a0 f65477a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.a.b.w f65478b;

        /* renamed from: c  reason: collision with root package name */
        public int f65479c;

        /* renamed from: d  reason: collision with root package name */
        public String f65480d;

        /* renamed from: e  reason: collision with root package name */
        public u f65481e;

        /* renamed from: f  reason: collision with root package name */
        public v.a f65482f;

        /* renamed from: g  reason: collision with root package name */
        public d f65483g;

        /* renamed from: h  reason: collision with root package name */
        public c f65484h;

        /* renamed from: i  reason: collision with root package name */
        public c f65485i;
        public c j;
        public long k;
        public long l;

        public a() {
            this.f65479c = -1;
            this.f65482f = new v.a();
        }

        public a a(int i2) {
            this.f65479c = i2;
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
            this.f65484h = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f65483g = dVar;
            return this;
        }

        public a e(u uVar) {
            this.f65481e = uVar;
            return this;
        }

        public a f(v vVar) {
            this.f65482f = vVar.h();
            return this;
        }

        public a g(com.bytedance.sdk.a.b.w wVar) {
            this.f65478b = wVar;
            return this;
        }

        public a h(a0 a0Var) {
            this.f65477a = a0Var;
            return this;
        }

        public a i(String str) {
            this.f65480d = str;
            return this;
        }

        public a j(String str, String str2) {
            this.f65482f.b(str, str2);
            return this;
        }

        public c k() {
            if (this.f65477a != null) {
                if (this.f65478b != null) {
                    if (this.f65479c >= 0) {
                        if (this.f65480d != null) {
                            return new c(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f65479c);
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
            this.f65485i = cVar;
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
            this.f65479c = -1;
            this.f65477a = cVar.f65472e;
            this.f65478b = cVar.f65473f;
            this.f65479c = cVar.f65474g;
            this.f65480d = cVar.f65475h;
            this.f65481e = cVar.f65476i;
            this.f65482f = cVar.j.h();
            this.f65483g = cVar.k;
            this.f65484h = cVar.l;
            this.f65485i = cVar.m;
            this.j = cVar.n;
            this.k = cVar.o;
            this.l = cVar.p;
        }
    }
}

package d.b.c.a.b;

import d.b.c.a.b.v;
import java.io.Closeable;
/* loaded from: classes6.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final a0 f65515e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.w f65516f;

    /* renamed from: g  reason: collision with root package name */
    public final int f65517g;

    /* renamed from: h  reason: collision with root package name */
    public final String f65518h;

    /* renamed from: i  reason: collision with root package name */
    public final u f65519i;
    public final v j;
    public final d k;
    public final c l;
    public final c m;
    public final c n;
    public final long o;
    public final long p;
    public volatile h q;

    public c(a aVar) {
        this.f65515e = aVar.f65520a;
        this.f65516f = aVar.f65521b;
        this.f65517g = aVar.f65522c;
        this.f65518h = aVar.f65523d;
        this.f65519i = aVar.f65524e;
        this.j = aVar.f65525f.c();
        this.k = aVar.f65526g;
        this.l = aVar.f65527h;
        this.m = aVar.f65528i;
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
        return this.f65515e;
    }

    public String o(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String c2 = this.j.c(str);
        return c2 != null ? c2 : str2;
    }

    public com.bytedance.sdk.a.b.w q() {
        return this.f65516f;
    }

    public int r() {
        return this.f65517g;
    }

    public boolean s() {
        int i2 = this.f65517g;
        return i2 >= 200 && i2 < 300;
    }

    public String t() {
        return this.f65518h;
    }

    public String toString() {
        return "Response{protocol=" + this.f65516f + ", code=" + this.f65517g + ", message=" + this.f65518h + ", url=" + this.f65515e.a() + '}';
    }

    public u v() {
        return this.f65519i;
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
        public a0 f65520a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.a.b.w f65521b;

        /* renamed from: c  reason: collision with root package name */
        public int f65522c;

        /* renamed from: d  reason: collision with root package name */
        public String f65523d;

        /* renamed from: e  reason: collision with root package name */
        public u f65524e;

        /* renamed from: f  reason: collision with root package name */
        public v.a f65525f;

        /* renamed from: g  reason: collision with root package name */
        public d f65526g;

        /* renamed from: h  reason: collision with root package name */
        public c f65527h;

        /* renamed from: i  reason: collision with root package name */
        public c f65528i;
        public c j;
        public long k;
        public long l;

        public a() {
            this.f65522c = -1;
            this.f65525f = new v.a();
        }

        public a a(int i2) {
            this.f65522c = i2;
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
            this.f65527h = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f65526g = dVar;
            return this;
        }

        public a e(u uVar) {
            this.f65524e = uVar;
            return this;
        }

        public a f(v vVar) {
            this.f65525f = vVar.h();
            return this;
        }

        public a g(com.bytedance.sdk.a.b.w wVar) {
            this.f65521b = wVar;
            return this;
        }

        public a h(a0 a0Var) {
            this.f65520a = a0Var;
            return this;
        }

        public a i(String str) {
            this.f65523d = str;
            return this;
        }

        public a j(String str, String str2) {
            this.f65525f.b(str, str2);
            return this;
        }

        public c k() {
            if (this.f65520a != null) {
                if (this.f65521b != null) {
                    if (this.f65522c >= 0) {
                        if (this.f65523d != null) {
                            return new c(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f65522c);
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
            this.f65528i = cVar;
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
            this.f65522c = -1;
            this.f65520a = cVar.f65515e;
            this.f65521b = cVar.f65516f;
            this.f65522c = cVar.f65517g;
            this.f65523d = cVar.f65518h;
            this.f65524e = cVar.f65519i;
            this.f65525f = cVar.j.h();
            this.f65526g = cVar.k;
            this.f65527h = cVar.l;
            this.f65528i = cVar.m;
            this.j = cVar.n;
            this.k = cVar.o;
            this.l = cVar.p;
        }
    }
}

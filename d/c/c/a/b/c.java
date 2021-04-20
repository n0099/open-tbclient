package d.c.c.a.b;

import d.c.c.a.b.v;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final a0 f66305e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.w f66306f;

    /* renamed from: g  reason: collision with root package name */
    public final int f66307g;

    /* renamed from: h  reason: collision with root package name */
    public final String f66308h;
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
        this.f66305e = aVar.f66309a;
        this.f66306f = aVar.f66310b;
        this.f66307g = aVar.f66311c;
        this.f66308h = aVar.f66312d;
        this.i = aVar.f66313e;
        this.j = aVar.f66314f.c();
        this.k = aVar.f66315g;
        this.l = aVar.f66316h;
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
        return this.f66305e;
    }

    public String o(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String c2 = this.j.c(str);
        return c2 != null ? c2 : str2;
    }

    public com.bytedance.sdk.a.b.w q() {
        return this.f66306f;
    }

    public int r() {
        return this.f66307g;
    }

    public boolean s() {
        int i = this.f66307g;
        return i >= 200 && i < 300;
    }

    public String t() {
        return this.f66308h;
    }

    public String toString() {
        return "Response{protocol=" + this.f66306f + ", code=" + this.f66307g + ", message=" + this.f66308h + ", url=" + this.f66305e.a() + '}';
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
        public a0 f66309a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.a.b.w f66310b;

        /* renamed from: c  reason: collision with root package name */
        public int f66311c;

        /* renamed from: d  reason: collision with root package name */
        public String f66312d;

        /* renamed from: e  reason: collision with root package name */
        public u f66313e;

        /* renamed from: f  reason: collision with root package name */
        public v.a f66314f;

        /* renamed from: g  reason: collision with root package name */
        public d f66315g;

        /* renamed from: h  reason: collision with root package name */
        public c f66316h;
        public c i;
        public c j;
        public long k;
        public long l;

        public a() {
            this.f66311c = -1;
            this.f66314f = new v.a();
        }

        public a a(int i) {
            this.f66311c = i;
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
            this.f66316h = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f66315g = dVar;
            return this;
        }

        public a e(u uVar) {
            this.f66313e = uVar;
            return this;
        }

        public a f(v vVar) {
            this.f66314f = vVar.h();
            return this;
        }

        public a g(com.bytedance.sdk.a.b.w wVar) {
            this.f66310b = wVar;
            return this;
        }

        public a h(a0 a0Var) {
            this.f66309a = a0Var;
            return this;
        }

        public a i(String str) {
            this.f66312d = str;
            return this;
        }

        public a j(String str, String str2) {
            this.f66314f.b(str, str2);
            return this;
        }

        public c k() {
            if (this.f66309a != null) {
                if (this.f66310b != null) {
                    if (this.f66311c >= 0) {
                        if (this.f66312d != null) {
                            return new c(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f66311c);
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
            this.f66311c = -1;
            this.f66309a = cVar.f66305e;
            this.f66310b = cVar.f66306f;
            this.f66311c = cVar.f66307g;
            this.f66312d = cVar.f66308h;
            this.f66313e = cVar.i;
            this.f66314f = cVar.j.h();
            this.f66315g = cVar.k;
            this.f66316h = cVar.l;
            this.i = cVar.m;
            this.j = cVar.n;
            this.k = cVar.o;
            this.l = cVar.p;
        }
    }
}

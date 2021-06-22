package d.b.c.a.b;

import d.b.c.a.b.v;
import java.io.Closeable;
/* loaded from: classes6.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final a0 f69350e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.w f69351f;

    /* renamed from: g  reason: collision with root package name */
    public final int f69352g;

    /* renamed from: h  reason: collision with root package name */
    public final String f69353h;

    /* renamed from: i  reason: collision with root package name */
    public final u f69354i;
    public final v j;
    public final d k;
    public final c l;
    public final c m;
    public final c n;
    public final long o;
    public final long p;
    public volatile h q;

    public c(a aVar) {
        this.f69350e = aVar.f69355a;
        this.f69351f = aVar.f69356b;
        this.f69352g = aVar.f69357c;
        this.f69353h = aVar.f69358d;
        this.f69354i = aVar.f69359e;
        this.j = aVar.f69360f.c();
        this.k = aVar.f69361g;
        this.l = aVar.f69362h;
        this.m = aVar.f69363i;
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
        return this.f69350e;
    }

    public String o(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String c2 = this.j.c(str);
        return c2 != null ? c2 : str2;
    }

    public com.bytedance.sdk.a.b.w q() {
        return this.f69351f;
    }

    public int r() {
        return this.f69352g;
    }

    public boolean s() {
        int i2 = this.f69352g;
        return i2 >= 200 && i2 < 300;
    }

    public String t() {
        return this.f69353h;
    }

    public String toString() {
        return "Response{protocol=" + this.f69351f + ", code=" + this.f69352g + ", message=" + this.f69353h + ", url=" + this.f69350e.a() + '}';
    }

    public u v() {
        return this.f69354i;
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
        public a0 f69355a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.a.b.w f69356b;

        /* renamed from: c  reason: collision with root package name */
        public int f69357c;

        /* renamed from: d  reason: collision with root package name */
        public String f69358d;

        /* renamed from: e  reason: collision with root package name */
        public u f69359e;

        /* renamed from: f  reason: collision with root package name */
        public v.a f69360f;

        /* renamed from: g  reason: collision with root package name */
        public d f69361g;

        /* renamed from: h  reason: collision with root package name */
        public c f69362h;

        /* renamed from: i  reason: collision with root package name */
        public c f69363i;
        public c j;
        public long k;
        public long l;

        public a() {
            this.f69357c = -1;
            this.f69360f = new v.a();
        }

        public a a(int i2) {
            this.f69357c = i2;
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
            this.f69362h = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f69361g = dVar;
            return this;
        }

        public a e(u uVar) {
            this.f69359e = uVar;
            return this;
        }

        public a f(v vVar) {
            this.f69360f = vVar.h();
            return this;
        }

        public a g(com.bytedance.sdk.a.b.w wVar) {
            this.f69356b = wVar;
            return this;
        }

        public a h(a0 a0Var) {
            this.f69355a = a0Var;
            return this;
        }

        public a i(String str) {
            this.f69358d = str;
            return this;
        }

        public a j(String str, String str2) {
            this.f69360f.b(str, str2);
            return this;
        }

        public c k() {
            if (this.f69355a != null) {
                if (this.f69356b != null) {
                    if (this.f69357c >= 0) {
                        if (this.f69358d != null) {
                            return new c(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f69357c);
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
            this.f69363i = cVar;
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
            this.f69357c = -1;
            this.f69355a = cVar.f69350e;
            this.f69356b = cVar.f69351f;
            this.f69357c = cVar.f69352g;
            this.f69358d = cVar.f69353h;
            this.f69359e = cVar.f69354i;
            this.f69360f = cVar.j.h();
            this.f69361g = cVar.k;
            this.f69362h = cVar.l;
            this.f69363i = cVar.m;
            this.j = cVar.n;
            this.k = cVar.o;
            this.l = cVar.p;
        }
    }
}

package d.b.c.a.b;

import d.b.c.a.b.v;
import java.io.Closeable;
/* loaded from: classes6.dex */
public final class c implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final a0 f69246e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.a.b.w f69247f;

    /* renamed from: g  reason: collision with root package name */
    public final int f69248g;

    /* renamed from: h  reason: collision with root package name */
    public final String f69249h;

    /* renamed from: i  reason: collision with root package name */
    public final u f69250i;
    public final v j;
    public final d k;
    public final c l;
    public final c m;
    public final c n;
    public final long o;
    public final long p;
    public volatile h q;

    public c(a aVar) {
        this.f69246e = aVar.f69251a;
        this.f69247f = aVar.f69252b;
        this.f69248g = aVar.f69253c;
        this.f69249h = aVar.f69254d;
        this.f69250i = aVar.f69255e;
        this.j = aVar.f69256f.c();
        this.k = aVar.f69257g;
        this.l = aVar.f69258h;
        this.m = aVar.f69259i;
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
        return this.f69246e;
    }

    public String o(String str) {
        return p(str, null);
    }

    public String p(String str, String str2) {
        String c2 = this.j.c(str);
        return c2 != null ? c2 : str2;
    }

    public com.bytedance.sdk.a.b.w q() {
        return this.f69247f;
    }

    public int r() {
        return this.f69248g;
    }

    public boolean s() {
        int i2 = this.f69248g;
        return i2 >= 200 && i2 < 300;
    }

    public String t() {
        return this.f69249h;
    }

    public String toString() {
        return "Response{protocol=" + this.f69247f + ", code=" + this.f69248g + ", message=" + this.f69249h + ", url=" + this.f69246e.a() + '}';
    }

    public u v() {
        return this.f69250i;
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
        public a0 f69251a;

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.a.b.w f69252b;

        /* renamed from: c  reason: collision with root package name */
        public int f69253c;

        /* renamed from: d  reason: collision with root package name */
        public String f69254d;

        /* renamed from: e  reason: collision with root package name */
        public u f69255e;

        /* renamed from: f  reason: collision with root package name */
        public v.a f69256f;

        /* renamed from: g  reason: collision with root package name */
        public d f69257g;

        /* renamed from: h  reason: collision with root package name */
        public c f69258h;

        /* renamed from: i  reason: collision with root package name */
        public c f69259i;
        public c j;
        public long k;
        public long l;

        public a() {
            this.f69253c = -1;
            this.f69256f = new v.a();
        }

        public a a(int i2) {
            this.f69253c = i2;
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
            this.f69258h = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f69257g = dVar;
            return this;
        }

        public a e(u uVar) {
            this.f69255e = uVar;
            return this;
        }

        public a f(v vVar) {
            this.f69256f = vVar.h();
            return this;
        }

        public a g(com.bytedance.sdk.a.b.w wVar) {
            this.f69252b = wVar;
            return this;
        }

        public a h(a0 a0Var) {
            this.f69251a = a0Var;
            return this;
        }

        public a i(String str) {
            this.f69254d = str;
            return this;
        }

        public a j(String str, String str2) {
            this.f69256f.b(str, str2);
            return this;
        }

        public c k() {
            if (this.f69251a != null) {
                if (this.f69252b != null) {
                    if (this.f69253c >= 0) {
                        if (this.f69254d != null) {
                            return new c(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f69253c);
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
            this.f69259i = cVar;
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
            this.f69253c = -1;
            this.f69251a = cVar.f69246e;
            this.f69252b = cVar.f69247f;
            this.f69253c = cVar.f69248g;
            this.f69254d = cVar.f69249h;
            this.f69255e = cVar.f69250i;
            this.f69256f = cVar.j.h();
            this.f69257g = cVar.k;
            this.f69258h = cVar.l;
            this.f69259i = cVar.m;
            this.j = cVar.n;
            this.k = cVar.o;
            this.l = cVar.p;
        }
    }
}

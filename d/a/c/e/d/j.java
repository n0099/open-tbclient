package d.a.c.e.d;

import d.a.c.e.d.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {

    /* renamed from: c  reason: collision with root package name */
    public final c<T> f38872c;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38873e;

        public a(String str) {
            this.f38873e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f38872c.o(this.f38873e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38875e;

        public b(String str) {
            this.f38875e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f38872c.n(this.f38875e);
        }
    }

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.f38872c = cVar;
    }

    @Override // d.a.c.e.d.k
    public void a(String str) {
        if (this.f38855b instanceof e.b) {
            d.a.c.e.m.h.a().b(new a(str));
        }
        if (this.f38855b instanceof e.a) {
            d.a.c.e.m.h.a().b(new b(str));
        }
    }

    @Override // d.a.c.e.d.k
    public void g(String str) {
        this.f38872c.c(str);
    }

    @Override // d.a.c.e.d.d
    public g<T> i(String str) {
        return this.f38872c.f(str);
    }

    @Override // d.a.c.e.d.d
    public void j(g<T> gVar) {
        this.f38872c.b(gVar);
    }

    @Override // d.a.c.e.d.d
    public void l(String str) {
        this.f38872c.e(str);
    }

    @Override // d.a.c.e.d.d
    public void m(String str) {
        this.f38872c.a(str, true);
    }

    public c<T> n() {
        return this.f38872c;
    }
}

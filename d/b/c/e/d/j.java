package d.b.c.e.d;

import d.b.c.e.d.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {

    /* renamed from: c  reason: collision with root package name */
    public final c<T> f42193c;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42194e;

        public a(String str) {
            this.f42194e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f42193c.o(this.f42194e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42196e;

        public b(String str) {
            this.f42196e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f42193c.n(this.f42196e);
        }
    }

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.f42193c = cVar;
    }

    @Override // d.b.c.e.d.k
    public void a(String str) {
        if (this.f42176b instanceof e.b) {
            d.b.c.e.m.h.a().b(new a(str));
        }
        if (this.f42176b instanceof e.a) {
            d.b.c.e.m.h.a().b(new b(str));
        }
    }

    @Override // d.b.c.e.d.k
    public void g(String str) {
        this.f42193c.c(str);
    }

    @Override // d.b.c.e.d.d
    public g<T> i(String str) {
        return this.f42193c.f(str);
    }

    @Override // d.b.c.e.d.d
    public void j(g<T> gVar) {
        this.f42193c.b(gVar);
    }

    @Override // d.b.c.e.d.d
    public void l(String str) {
        this.f42193c.e(str);
    }

    @Override // d.b.c.e.d.d
    public void m(String str) {
        this.f42193c.a(str, true);
    }

    public c<T> n() {
        return this.f42193c;
    }
}

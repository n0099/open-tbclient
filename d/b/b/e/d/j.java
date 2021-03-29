package d.b.b.e.d;

import d.b.b.e.d.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {

    /* renamed from: c  reason: collision with root package name */
    public final c<T> f41696c;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41697e;

        public a(String str) {
            this.f41697e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f41696c.o(this.f41697e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41699e;

        public b(String str) {
            this.f41699e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f41696c.n(this.f41699e);
        }
    }

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.f41696c = cVar;
    }

    @Override // d.b.b.e.d.k
    public void a(String str) {
        if (this.f41679b instanceof e.b) {
            d.b.b.e.m.h.a().b(new a(str));
        }
        if (this.f41679b instanceof e.a) {
            d.b.b.e.m.h.a().b(new b(str));
        }
    }

    @Override // d.b.b.e.d.k
    public void g(String str) {
        this.f41696c.c(str);
    }

    @Override // d.b.b.e.d.d
    public g<T> i(String str) {
        return this.f41696c.f(str);
    }

    @Override // d.b.b.e.d.d
    public void j(g<T> gVar) {
        this.f41696c.b(gVar);
    }

    @Override // d.b.b.e.d.d
    public void l(String str) {
        this.f41696c.e(str);
    }

    @Override // d.b.b.e.d.d
    public void m(String str) {
        this.f41696c.a(str, true);
    }

    public c<T> n() {
        return this.f41696c;
    }
}

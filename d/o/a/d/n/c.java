package d.o.a.d.n;

import java.lang.ref.SoftReference;
/* loaded from: classes6.dex */
public class c<P, R> implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public P f66261e;

    /* renamed from: f  reason: collision with root package name */
    public R f66262f;

    /* renamed from: g  reason: collision with root package name */
    public int f66263g;

    /* renamed from: h  reason: collision with root package name */
    public SoftReference<a<P, R>> f66264h;

    /* renamed from: i  reason: collision with root package name */
    public c<?, P> f66265i;
    public c<R, ?> j;

    /* loaded from: classes6.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    public c(int i2, a<P, R> aVar, P p) {
        this.f66263g = i2;
        this.f66264h = new SoftReference<>(aVar);
        this.f66261e = p;
    }

    public static <P, R> c<P, R> c(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: d.o.a.d.n.c<P, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i2, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i2, aVar, null);
        this.j = cVar;
        cVar.f66265i = this;
        return cVar;
    }

    public <NR> c<R, NR> b(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void d() {
        c<?, P> cVar = this.f66265i;
        if (cVar != null) {
            cVar.d();
        } else {
            run();
        }
    }

    public final R e() {
        return this.f66262f;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f66263g == 0 && !k.s()) {
            d.o.a.d.k.b().n().post(this);
        } else if (this.f66263g == 1 && k.s()) {
            d.o.a.d.i.a().b(this);
        } else if (this.f66263g == 2 && k.s()) {
            d.o.a.d.i.a().f(this);
        } else {
            if (this.f66261e == null && (cVar = this.f66265i) != null) {
                this.f66261e = cVar.e();
            }
            a<P, R> aVar = this.f66264h.get();
            if (aVar == null) {
                return;
            }
            this.f66262f = aVar.a(this.f66261e);
            c<R, ?> cVar2 = this.j;
            if (cVar2 != null) {
                cVar2.run();
            }
        }
    }
}

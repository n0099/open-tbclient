package d.o.a.d.n;

import java.lang.ref.SoftReference;
/* loaded from: classes6.dex */
public class c<P, R> implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public P f66766e;

    /* renamed from: f  reason: collision with root package name */
    public R f66767f;

    /* renamed from: g  reason: collision with root package name */
    public int f66768g;

    /* renamed from: h  reason: collision with root package name */
    public SoftReference<a<P, R>> f66769h;
    public c<?, P> i;
    public c<R, ?> j;

    /* loaded from: classes6.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    public c(int i, a<P, R> aVar, P p) {
        this.f66768g = i;
        this.f66769h = new SoftReference<>(aVar);
        this.f66766e = p;
    }

    public static <P, R> c<P, R> c(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: d.o.a.d.n.c<P, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i, aVar, null);
        this.j = cVar;
        cVar.i = this;
        return cVar;
    }

    public <NR> c<R, NR> b(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void d() {
        c<?, P> cVar = this.i;
        if (cVar != null) {
            cVar.d();
        } else {
            run();
        }
    }

    public final R e() {
        return this.f66767f;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f66768g == 0 && !k.s()) {
            d.o.a.d.k.b().n().post(this);
        } else if (this.f66768g == 1 && k.s()) {
            d.o.a.d.i.a().b(this);
        } else if (this.f66768g == 2 && k.s()) {
            d.o.a.d.i.a().f(this);
        } else {
            if (this.f66766e == null && (cVar = this.i) != null) {
                this.f66766e = cVar.e();
            }
            a<P, R> aVar = this.f66769h.get();
            if (aVar == null) {
                return;
            }
            this.f66767f = aVar.a(this.f66766e);
            c<R, ?> cVar2 = this.j;
            if (cVar2 != null) {
                cVar2.run();
            }
        }
    }
}

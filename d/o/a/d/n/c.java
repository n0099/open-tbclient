package d.o.a.d.n;

import java.lang.ref.SoftReference;
/* loaded from: classes7.dex */
public class c<P, R> implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public P f70880e;

    /* renamed from: f  reason: collision with root package name */
    public R f70881f;

    /* renamed from: g  reason: collision with root package name */
    public int f70882g;

    /* renamed from: h  reason: collision with root package name */
    public SoftReference<a<P, R>> f70883h;

    /* renamed from: i  reason: collision with root package name */
    public c<?, P> f70884i;
    public c<R, ?> j;

    /* loaded from: classes7.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    public c(int i2, a<P, R> aVar, P p) {
        this.f70882g = i2;
        this.f70883h = new SoftReference<>(aVar);
        this.f70880e = p;
    }

    public static <P, R> c<P, R> c(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: d.o.a.d.n.c<P, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i2, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i2, aVar, null);
        this.j = cVar;
        cVar.f70884i = this;
        return cVar;
    }

    public <NR> c<R, NR> b(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void d() {
        c<?, P> cVar = this.f70884i;
        if (cVar != null) {
            cVar.d();
        } else {
            run();
        }
    }

    public final R e() {
        return this.f70881f;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f70882g == 0 && !k.s()) {
            d.o.a.d.k.b().n().post(this);
        } else if (this.f70882g == 1 && k.s()) {
            d.o.a.d.i.a().b(this);
        } else if (this.f70882g == 2 && k.s()) {
            d.o.a.d.i.a().f(this);
        } else {
            if (this.f70880e == null && (cVar = this.f70884i) != null) {
                this.f70880e = cVar.e();
            }
            a<P, R> aVar = this.f70883h.get();
            if (aVar == null) {
                return;
            }
            this.f70881f = aVar.a(this.f70880e);
            c<R, ?> cVar2 = this.j;
            if (cVar2 != null) {
                cVar2.run();
            }
        }
    }
}

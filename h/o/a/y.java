package h.o.a;

import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class y<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f68995e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f68996f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f68997g;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68998f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f68999g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f69000h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
            this.f68998f = iVar;
            this.f68999g = bVar;
            this.f69000h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            try {
                this.f69000h.call(th);
                this.f68998f.b(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f68998f.b(new CompositeException(th, th2));
            }
        }

        @Override // h.i
        public void c(T t) {
            try {
                this.f68999g.call(t);
                this.f68998f.c(t);
            } catch (Throwable th) {
                h.m.a.h(th, this, t);
            }
        }
    }

    public y(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        this.f68995e = hVar;
        this.f68996f = bVar;
        this.f68997g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar, this.f68996f, this.f68997g);
        iVar.a(aVar);
        this.f68995e.j(aVar);
    }
}

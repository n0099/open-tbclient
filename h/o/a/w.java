package h.o.a;

import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class w<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f68521e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f68522f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f68523g;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68524f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f68525g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f68526h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
            this.f68524f = iVar;
            this.f68525g = bVar;
            this.f68526h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            try {
                this.f68526h.call(th);
                this.f68524f.b(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f68524f.b(new CompositeException(th, th2));
            }
        }

        @Override // h.i
        public void c(T t) {
            try {
                this.f68525g.call(t);
                this.f68524f.c(t);
            } catch (Throwable th) {
                h.m.a.h(th, this, t);
            }
        }
    }

    public w(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        this.f68521e = hVar;
        this.f68522f = bVar;
        this.f68523g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar, this.f68522f, this.f68523g);
        iVar.a(aVar);
        this.f68521e.j(aVar);
    }
}

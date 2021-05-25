package h.o.a;

import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class w<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f68564e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f68565f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f68566g;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68567f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f68568g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f68569h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
            this.f68567f = iVar;
            this.f68568g = bVar;
            this.f68569h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            try {
                this.f68569h.call(th);
                this.f68567f.b(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f68567f.b(new CompositeException(th, th2));
            }
        }

        @Override // h.i
        public void c(T t) {
            try {
                this.f68568g.call(t);
                this.f68567f.c(t);
            } catch (Throwable th) {
                h.m.a.h(th, this, t);
            }
        }
    }

    public w(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        this.f68564e = hVar;
        this.f68565f = bVar;
        this.f68566g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar, this.f68565f, this.f68566g);
        iVar.a(aVar);
        this.f68564e.j(aVar);
    }
}

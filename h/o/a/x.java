package h.o.a;

import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class x<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f67832e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f67833f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f67834g;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f67835f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f67836g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f67837h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
            this.f67835f = iVar;
            this.f67836g = bVar;
            this.f67837h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            try {
                this.f67837h.call(th);
                this.f67835f.b(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f67835f.b(new CompositeException(th, th2));
            }
        }

        @Override // h.i
        public void c(T t) {
            try {
                this.f67836g.call(t);
                this.f67835f.c(t);
            } catch (Throwable th) {
                h.m.a.h(th, this, t);
            }
        }
    }

    public x(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        this.f67832e = hVar;
        this.f67833f = bVar;
        this.f67834g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar, this.f67833f, this.f67834g);
        iVar.a(aVar);
        this.f67832e.j(aVar);
    }
}

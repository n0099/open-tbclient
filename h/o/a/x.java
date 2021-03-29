package h.o.a;

import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class x<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f67837e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f67838f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f67839g;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f67840f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f67841g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f67842h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
            this.f67840f = iVar;
            this.f67841g = bVar;
            this.f67842h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            try {
                this.f67842h.call(th);
                this.f67840f.b(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f67840f.b(new CompositeException(th, th2));
            }
        }

        @Override // h.i
        public void c(T t) {
            try {
                this.f67841g.call(t);
                this.f67840f.c(t);
            } catch (Throwable th) {
                h.m.a.h(th, this, t);
            }
        }
    }

    public x(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        this.f67837e = hVar;
        this.f67838f = bVar;
        this.f67839g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar, this.f67838f, this.f67839g);
        iVar.a(aVar);
        this.f67837e.j(aVar);
    }
}

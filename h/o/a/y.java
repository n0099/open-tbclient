package h.o.a;

import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class y<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f68848e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f68849f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f68850g;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68851f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f68852g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f68853h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
            this.f68851f = iVar;
            this.f68852g = bVar;
            this.f68853h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            try {
                this.f68853h.call(th);
                this.f68851f.b(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f68851f.b(new CompositeException(th, th2));
            }
        }

        @Override // h.i
        public void c(T t) {
            try {
                this.f68852g.call(t);
                this.f68851f.c(t);
            } catch (Throwable th) {
                h.m.a.h(th, this, t);
            }
        }
    }

    public y(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        this.f68848e = hVar;
        this.f68849f = bVar;
        this.f68850g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar, this.f68849f, this.f68850g);
        iVar.a(aVar);
        this.f68848e.j(aVar);
    }
}

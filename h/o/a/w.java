package h.o.a;

import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes7.dex */
public final class w<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f67841e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f67842f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f67843g;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f67844f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f67845g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f67846h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
            this.f67844f = iVar;
            this.f67845g = bVar;
            this.f67846h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            try {
                this.f67846h.call(th);
                this.f67844f.b(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f67844f.b(new CompositeException(th, th2));
            }
        }

        @Override // h.i
        public void c(T t) {
            try {
                this.f67845g.call(t);
                this.f67844f.c(t);
            } catch (Throwable th) {
                h.m.a.h(th, this, t);
            }
        }
    }

    public w(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        this.f67841e = hVar;
        this.f67842f = bVar;
        this.f67843g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar, this.f67842f, this.f67843g);
        iVar.a(aVar);
        this.f67841e.j(aVar);
    }
}

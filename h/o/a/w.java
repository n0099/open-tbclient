package h.o.a;

import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes8.dex */
public final class w<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f71820e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f71821f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f71822g;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f71823f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f71824g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f71825h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
            this.f71823f = iVar;
            this.f71824g = bVar;
            this.f71825h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            try {
                this.f71825h.call(th);
                this.f71823f.b(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f71823f.b(new CompositeException(th, th2));
            }
        }

        @Override // h.i
        public void c(T t) {
            try {
                this.f71824g.call(t);
                this.f71823f.c(t);
            } catch (Throwable th) {
                h.m.a.h(th, this, t);
            }
        }
    }

    public w(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        this.f71820e = hVar;
        this.f71821f = bVar;
        this.f71822g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar, this.f71821f, this.f71822g);
        iVar.a(aVar);
        this.f71820e.j(aVar);
    }
}

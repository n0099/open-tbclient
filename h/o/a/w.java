package h.o.a;

import h.h;
import rx.exceptions.CompositeException;
/* loaded from: classes8.dex */
public final class w<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.h<T> f71924e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.b<? super T> f71925f;

    /* renamed from: g  reason: collision with root package name */
    public final h.n.b<Throwable> f71926g;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f71927f;

        /* renamed from: g  reason: collision with root package name */
        public final h.n.b<? super T> f71928g;

        /* renamed from: h  reason: collision with root package name */
        public final h.n.b<Throwable> f71929h;

        public a(h.i<? super T> iVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
            this.f71927f = iVar;
            this.f71928g = bVar;
            this.f71929h = bVar2;
        }

        @Override // h.i
        public void b(Throwable th) {
            try {
                this.f71929h.call(th);
                this.f71927f.b(th);
            } catch (Throwable th2) {
                h.m.a.e(th2);
                this.f71927f.b(new CompositeException(th, th2));
            }
        }

        @Override // h.i
        public void c(T t) {
            try {
                this.f71928g.call(t);
                this.f71927f.c(t);
            } catch (Throwable th) {
                h.m.a.h(th, this, t);
            }
        }
    }

    public w(h.h<T> hVar, h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        this.f71924e = hVar;
        this.f71925f = bVar;
        this.f71926g = bVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        a aVar = new a(iVar, this.f71925f, this.f71926g);
        iVar.a(aVar);
        this.f71924e.j(aVar);
    }
}

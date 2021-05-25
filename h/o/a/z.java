package h.o.a;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class z<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f68575e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f68576f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68577f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f68578g;

        /* renamed from: h  reason: collision with root package name */
        public T f68579h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f68580i;

        public a(h.i<? super T> iVar, g.a aVar) {
            this.f68577f = iVar;
            this.f68578g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.f68580i = th;
            this.f68578g.b(this);
        }

        @Override // h.i
        public void c(T t) {
            this.f68579h = t;
            this.f68578g.b(this);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.f68580i;
                if (th != null) {
                    this.f68580i = null;
                    this.f68577f.b(th);
                } else {
                    T t = this.f68579h;
                    this.f68579h = null;
                    this.f68577f.c(t);
                }
            } finally {
                this.f68578g.unsubscribe();
            }
        }
    }

    public z(h.c<T> cVar, h.g gVar) {
        this.f68575e = cVar;
        this.f68576f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f68576f.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f68575e.call(aVar);
    }
}

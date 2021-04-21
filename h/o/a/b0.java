package h.o.a;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class b0<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68858e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f68859f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68860f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f68861g;

        /* renamed from: h  reason: collision with root package name */
        public T f68862h;
        public Throwable i;

        public a(h.i<? super T> iVar, g.a aVar) {
            this.f68860f = iVar;
            this.f68861g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.i = th;
            this.f68861g.b(this);
        }

        @Override // h.i
        public void c(T t) {
            this.f68862h = t;
            this.f68861g.b(this);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.i;
                if (th != null) {
                    this.i = null;
                    this.f68860f.b(th);
                } else {
                    T t = this.f68862h;
                    this.f68862h = null;
                    this.f68860f.c(t);
                }
            } finally {
                this.f68861g.unsubscribe();
            }
        }
    }

    public b0(h.d<T> dVar, h.g gVar) {
        this.f68858e = dVar;
        this.f68859f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f68859f.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f68858e.call(aVar);
    }
}

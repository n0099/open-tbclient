package h.o.a;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class b0<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68711e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f68712f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68713f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f68714g;

        /* renamed from: h  reason: collision with root package name */
        public T f68715h;
        public Throwable i;

        public a(h.i<? super T> iVar, g.a aVar) {
            this.f68713f = iVar;
            this.f68714g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.i = th;
            this.f68714g.b(this);
        }

        @Override // h.i
        public void c(T t) {
            this.f68715h = t;
            this.f68714g.b(this);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.i;
                if (th != null) {
                    this.i = null;
                    this.f68713f.b(th);
                } else {
                    T t = this.f68715h;
                    this.f68715h = null;
                    this.f68713f.c(t);
                }
            } finally {
                this.f68714g.unsubscribe();
            }
        }
    }

    public b0(h.d<T> dVar, h.g gVar) {
        this.f68711e = dVar;
        this.f68712f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f68712f.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f68711e.call(aVar);
    }
}

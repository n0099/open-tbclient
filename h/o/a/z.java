package h.o.a;

import h.g;
import h.h;
/* loaded from: classes8.dex */
public final class z<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f71935e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f71936f;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f71937f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f71938g;

        /* renamed from: h  reason: collision with root package name */
        public T f71939h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f71940i;

        public a(h.i<? super T> iVar, g.a aVar) {
            this.f71937f = iVar;
            this.f71938g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.f71940i = th;
            this.f71938g.b(this);
        }

        @Override // h.i
        public void c(T t) {
            this.f71939h = t;
            this.f71938g.b(this);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.f71940i;
                if (th != null) {
                    this.f71940i = null;
                    this.f71937f.b(th);
                } else {
                    T t = this.f71939h;
                    this.f71939h = null;
                    this.f71937f.c(t);
                }
            } finally {
                this.f71938g.unsubscribe();
            }
        }
    }

    public z(h.c<T> cVar, h.g gVar) {
        this.f71935e = cVar;
        this.f71936f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f71936f.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f71935e.call(aVar);
    }
}

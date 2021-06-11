package h.o.a;

import h.g;
import h.h;
/* loaded from: classes8.dex */
public final class z<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f71831e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f71832f;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f71833f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f71834g;

        /* renamed from: h  reason: collision with root package name */
        public T f71835h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f71836i;

        public a(h.i<? super T> iVar, g.a aVar) {
            this.f71833f = iVar;
            this.f71834g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.f71836i = th;
            this.f71834g.b(this);
        }

        @Override // h.i
        public void c(T t) {
            this.f71835h = t;
            this.f71834g.b(this);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.f71836i;
                if (th != null) {
                    this.f71836i = null;
                    this.f71833f.b(th);
                } else {
                    T t = this.f71835h;
                    this.f71835h = null;
                    this.f71833f.c(t);
                }
            } finally {
                this.f71834g.unsubscribe();
            }
        }
    }

    public z(h.c<T> cVar, h.g gVar) {
        this.f71831e = cVar;
        this.f71832f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f71832f.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f71831e.call(aVar);
    }
}

package h.o.a;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class a0<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67704e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f67705f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f67706f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f67707g;

        /* renamed from: h  reason: collision with root package name */
        public T f67708h;
        public Throwable i;

        public a(h.i<? super T> iVar, g.a aVar) {
            this.f67706f = iVar;
            this.f67707g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.i = th;
            this.f67707g.b(this);
        }

        @Override // h.i
        public void c(T t) {
            this.f67708h = t;
            this.f67707g.b(this);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.i;
                if (th != null) {
                    this.i = null;
                    this.f67706f.b(th);
                } else {
                    T t = this.f67708h;
                    this.f67708h = null;
                    this.f67706f.c(t);
                }
            } finally {
                this.f67707g.unsubscribe();
            }
        }
    }

    public a0(h.d<T> dVar, h.g gVar) {
        this.f67704e = dVar;
        this.f67705f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f67705f.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f67704e.call(aVar);
    }
}

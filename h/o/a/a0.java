package h.o.a;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class a0<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67699e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f67700f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f67701f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f67702g;

        /* renamed from: h  reason: collision with root package name */
        public T f67703h;
        public Throwable i;

        public a(h.i<? super T> iVar, g.a aVar) {
            this.f67701f = iVar;
            this.f67702g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.i = th;
            this.f67702g.b(this);
        }

        @Override // h.i
        public void c(T t) {
            this.f67703h = t;
            this.f67702g.b(this);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.i;
                if (th != null) {
                    this.i = null;
                    this.f67701f.b(th);
                } else {
                    T t = this.f67703h;
                    this.f67703h = null;
                    this.f67701f.c(t);
                }
            } finally {
                this.f67702g.unsubscribe();
            }
        }
    }

    public a0(h.d<T> dVar, h.g gVar) {
        this.f67699e = dVar;
        this.f67700f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f67700f.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f67699e.call(aVar);
    }
}

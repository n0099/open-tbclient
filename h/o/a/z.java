package h.o.a;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class z<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67852e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f67853f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f67854f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f67855g;

        /* renamed from: h  reason: collision with root package name */
        public T f67856h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f67857i;

        public a(h.i<? super T> iVar, g.a aVar) {
            this.f67854f = iVar;
            this.f67855g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.f67857i = th;
            this.f67855g.b(this);
        }

        @Override // h.i
        public void c(T t) {
            this.f67856h = t;
            this.f67855g.b(this);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.f67857i;
                if (th != null) {
                    this.f67857i = null;
                    this.f67854f.b(th);
                } else {
                    T t = this.f67856h;
                    this.f67856h = null;
                    this.f67854f.c(t);
                }
            } finally {
                this.f67855g.unsubscribe();
            }
        }
    }

    public z(h.d<T> dVar, h.g gVar) {
        this.f67852e = dVar;
        this.f67853f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f67853f.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f67852e.call(aVar);
    }
}

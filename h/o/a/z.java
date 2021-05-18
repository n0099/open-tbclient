package h.o.a;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class z<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f68532e;

    /* renamed from: f  reason: collision with root package name */
    public final h.g f68533f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68534f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f68535g;

        /* renamed from: h  reason: collision with root package name */
        public T f68536h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f68537i;

        public a(h.i<? super T> iVar, g.a aVar) {
            this.f68534f = iVar;
            this.f68535g = aVar;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.f68537i = th;
            this.f68535g.b(this);
        }

        @Override // h.i
        public void c(T t) {
            this.f68536h = t;
            this.f68535g.b(this);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.f68537i;
                if (th != null) {
                    this.f68537i = null;
                    this.f68534f.b(th);
                } else {
                    T t = this.f68536h;
                    this.f68536h = null;
                    this.f68534f.c(t);
                }
            } finally {
                this.f68535g.unsubscribe();
            }
        }
    }

    public z(h.c<T> cVar, h.g gVar) {
        this.f68532e = cVar;
        this.f68533f = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f68533f.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f68532e.call(aVar);
    }
}

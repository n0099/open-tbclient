package h.o.a;

import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class x<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68841e;

    /* renamed from: f  reason: collision with root package name */
    public final long f68842f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f68843g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f68844h;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68845f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f68846g;

        /* renamed from: h  reason: collision with root package name */
        public final long f68847h;
        public final TimeUnit i;
        public T j;
        public Throwable k;

        public a(h.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.f68845f = iVar;
            this.f68846g = aVar;
            this.f68847h = j;
            this.i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.k = th;
            this.f68846g.c(this, this.f68847h, this.i);
        }

        @Override // h.i
        public void c(T t) {
            this.j = t;
            this.f68846g.c(this, this.f68847h, this.i);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.k;
                if (th != null) {
                    this.k = null;
                    this.f68845f.b(th);
                } else {
                    T t = this.j;
                    this.j = null;
                    this.f68845f.c(t);
                }
            } finally {
                this.f68846g.unsubscribe();
            }
        }
    }

    public x(h.d<T> dVar, long j, TimeUnit timeUnit, h.g gVar) {
        this.f68841e = dVar;
        this.f68844h = gVar;
        this.f68842f = j;
        this.f68843g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f68844h.createWorker();
        a aVar = new a(iVar, createWorker, this.f68842f, this.f68843g);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f68841e.call(aVar);
    }
}

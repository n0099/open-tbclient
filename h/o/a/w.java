package h.o.a;

import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class w<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67830e;

    /* renamed from: f  reason: collision with root package name */
    public final long f67831f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f67832g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f67833h;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f67834f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f67835g;

        /* renamed from: h  reason: collision with root package name */
        public final long f67836h;
        public final TimeUnit i;
        public T j;
        public Throwable k;

        public a(h.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.f67834f = iVar;
            this.f67835g = aVar;
            this.f67836h = j;
            this.i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.k = th;
            this.f67835g.c(this, this.f67836h, this.i);
        }

        @Override // h.i
        public void c(T t) {
            this.j = t;
            this.f67835g.c(this, this.f67836h, this.i);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.k;
                if (th != null) {
                    this.k = null;
                    this.f67834f.b(th);
                } else {
                    T t = this.j;
                    this.j = null;
                    this.f67834f.c(t);
                }
            } finally {
                this.f67835g.unsubscribe();
            }
        }
    }

    public w(h.d<T> dVar, long j, TimeUnit timeUnit, h.g gVar) {
        this.f67830e = dVar;
        this.f67833h = gVar;
        this.f67831f = j;
        this.f67832g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f67833h.createWorker();
        a aVar = new a(iVar, createWorker, this.f67831f, this.f67832g);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f67830e.call(aVar);
    }
}

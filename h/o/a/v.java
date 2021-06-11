package h.o.a;

import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class v<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f71812e;

    /* renamed from: f  reason: collision with root package name */
    public final long f71813f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f71814g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f71815h;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f71816f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f71817g;

        /* renamed from: h  reason: collision with root package name */
        public final long f71818h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f71819i;
        public T j;
        public Throwable k;

        public a(h.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.f71816f = iVar;
            this.f71817g = aVar;
            this.f71818h = j;
            this.f71819i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.k = th;
            this.f71817g.c(this, this.f71818h, this.f71819i);
        }

        @Override // h.i
        public void c(T t) {
            this.j = t;
            this.f71817g.c(this, this.f71818h, this.f71819i);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.k;
                if (th != null) {
                    this.k = null;
                    this.f71816f.b(th);
                } else {
                    T t = this.j;
                    this.j = null;
                    this.f71816f.c(t);
                }
            } finally {
                this.f71817g.unsubscribe();
            }
        }
    }

    public v(h.c<T> cVar, long j, TimeUnit timeUnit, h.g gVar) {
        this.f71812e = cVar;
        this.f71815h = gVar;
        this.f71813f = j;
        this.f71814g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f71815h.createWorker();
        a aVar = new a(iVar, createWorker, this.f71813f, this.f71814g);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f71812e.call(aVar);
    }
}

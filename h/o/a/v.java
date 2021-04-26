package h.o.a;

import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class v<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67833e;

    /* renamed from: f  reason: collision with root package name */
    public final long f67834f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f67835g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f67836h;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f67837f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f67838g;

        /* renamed from: h  reason: collision with root package name */
        public final long f67839h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f67840i;
        public T j;
        public Throwable k;

        public a(h.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.f67837f = iVar;
            this.f67838g = aVar;
            this.f67839h = j;
            this.f67840i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.k = th;
            this.f67838g.c(this, this.f67839h, this.f67840i);
        }

        @Override // h.i
        public void c(T t) {
            this.j = t;
            this.f67838g.c(this, this.f67839h, this.f67840i);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.k;
                if (th != null) {
                    this.k = null;
                    this.f67837f.b(th);
                } else {
                    T t = this.j;
                    this.j = null;
                    this.f67837f.c(t);
                }
            } finally {
                this.f67838g.unsubscribe();
            }
        }
    }

    public v(h.d<T> dVar, long j, TimeUnit timeUnit, h.g gVar) {
        this.f67833e = dVar;
        this.f67836h = gVar;
        this.f67834f = j;
        this.f67835g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f67836h.createWorker();
        a aVar = new a(iVar, createWorker, this.f67834f, this.f67835g);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f67833e.call(aVar);
    }
}

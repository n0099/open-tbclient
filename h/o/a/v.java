package h.o.a;

import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class v<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f68513e;

    /* renamed from: f  reason: collision with root package name */
    public final long f68514f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f68515g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f68516h;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68517f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f68518g;

        /* renamed from: h  reason: collision with root package name */
        public final long f68519h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f68520i;
        public T j;
        public Throwable k;

        public a(h.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.f68517f = iVar;
            this.f68518g = aVar;
            this.f68519h = j;
            this.f68520i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.k = th;
            this.f68518g.c(this, this.f68519h, this.f68520i);
        }

        @Override // h.i
        public void c(T t) {
            this.j = t;
            this.f68518g.c(this, this.f68519h, this.f68520i);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.k;
                if (th != null) {
                    this.k = null;
                    this.f68517f.b(th);
                } else {
                    T t = this.j;
                    this.j = null;
                    this.f68517f.c(t);
                }
            } finally {
                this.f68518g.unsubscribe();
            }
        }
    }

    public v(h.c<T> cVar, long j, TimeUnit timeUnit, h.g gVar) {
        this.f68513e = cVar;
        this.f68516h = gVar;
        this.f68514f = j;
        this.f68515g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f68516h.createWorker();
        a aVar = new a(iVar, createWorker, this.f68514f, this.f68515g);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f68513e.call(aVar);
    }
}

package h.o.a;

import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class v<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f71916e;

    /* renamed from: f  reason: collision with root package name */
    public final long f71917f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f71918g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f71919h;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f71920f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f71921g;

        /* renamed from: h  reason: collision with root package name */
        public final long f71922h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f71923i;
        public T j;
        public Throwable k;

        public a(h.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.f71920f = iVar;
            this.f71921g = aVar;
            this.f71922h = j;
            this.f71923i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.k = th;
            this.f71921g.c(this, this.f71922h, this.f71923i);
        }

        @Override // h.i
        public void c(T t) {
            this.j = t;
            this.f71921g.c(this, this.f71922h, this.f71923i);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.k;
                if (th != null) {
                    this.k = null;
                    this.f71920f.b(th);
                } else {
                    T t = this.j;
                    this.j = null;
                    this.f71920f.c(t);
                }
            } finally {
                this.f71921g.unsubscribe();
            }
        }
    }

    public v(h.c<T> cVar, long j, TimeUnit timeUnit, h.g gVar) {
        this.f71916e = cVar;
        this.f71919h = gVar;
        this.f71917f = j;
        this.f71918g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f71919h.createWorker();
        a aVar = new a(iVar, createWorker, this.f71917f, this.f71918g);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f71916e.call(aVar);
    }
}

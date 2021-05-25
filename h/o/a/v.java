package h.o.a;

import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class v<T> implements h.c<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.c<T> f68556e;

    /* renamed from: f  reason: collision with root package name */
    public final long f68557f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f68558g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f68559h;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68560f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f68561g;

        /* renamed from: h  reason: collision with root package name */
        public final long f68562h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f68563i;
        public T j;
        public Throwable k;

        public a(h.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.f68560f = iVar;
            this.f68561g = aVar;
            this.f68562h = j;
            this.f68563i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.k = th;
            this.f68561g.c(this, this.f68562h, this.f68563i);
        }

        @Override // h.i
        public void c(T t) {
            this.j = t;
            this.f68561g.c(this, this.f68562h, this.f68563i);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.k;
                if (th != null) {
                    this.k = null;
                    this.f68560f.b(th);
                } else {
                    T t = this.j;
                    this.j = null;
                    this.f68560f.c(t);
                }
            } finally {
                this.f68561g.unsubscribe();
            }
        }
    }

    public v(h.c<T> cVar, long j, TimeUnit timeUnit, h.g gVar) {
        this.f68556e = cVar;
        this.f68559h = gVar;
        this.f68557f = j;
        this.f68558g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f68559h.createWorker();
        a aVar = new a(iVar, createWorker, this.f68557f, this.f68558g);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f68556e.call(aVar);
    }
}

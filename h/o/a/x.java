package h.o.a;

import h.g;
import h.h;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class x<T> implements h.d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68988e;

    /* renamed from: f  reason: collision with root package name */
    public final long f68989f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f68990g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f68991h;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.i<T> implements h.n.a {

        /* renamed from: f  reason: collision with root package name */
        public final h.i<? super T> f68992f;

        /* renamed from: g  reason: collision with root package name */
        public final g.a f68993g;

        /* renamed from: h  reason: collision with root package name */
        public final long f68994h;
        public final TimeUnit i;
        public T j;
        public Throwable k;

        public a(h.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.f68992f = iVar;
            this.f68993g = aVar;
            this.f68994h = j;
            this.i = timeUnit;
        }

        @Override // h.i
        public void b(Throwable th) {
            this.k = th;
            this.f68993g.c(this, this.f68994h, this.i);
        }

        @Override // h.i
        public void c(T t) {
            this.j = t;
            this.f68993g.c(this, this.f68994h, this.i);
        }

        @Override // h.n.a
        public void call() {
            try {
                Throwable th = this.k;
                if (th != null) {
                    this.k = null;
                    this.f68992f.b(th);
                } else {
                    T t = this.j;
                    this.j = null;
                    this.f68992f.c(t);
                }
            } finally {
                this.f68993g.unsubscribe();
            }
        }
    }

    public x(h.d<T> dVar, long j, TimeUnit timeUnit, h.g gVar) {
        this.f68988e = dVar;
        this.f68991h = gVar;
        this.f68989f = j;
        this.f68990g = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.i<? super T> iVar) {
        g.a createWorker = this.f68991h.createWorker();
        a aVar = new a(iVar, createWorker, this.f68989f, this.f68990g);
        iVar.a(createWorker);
        iVar.a(aVar);
        this.f68988e.call(aVar);
    }
}

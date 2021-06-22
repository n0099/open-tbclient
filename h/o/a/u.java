package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes8.dex */
public class u<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f71906e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f71907f;

    /* renamed from: g  reason: collision with root package name */
    public final h.d<? extends T> f71908g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f71909h;

    /* loaded from: classes8.dex */
    public interface a<T> extends h.n.h<c<T>, Long, g.a, h.k> {
    }

    /* loaded from: classes8.dex */
    public interface b<T> extends h.n.i<c<T>, Long, T, g.a, h.k> {
    }

    /* loaded from: classes8.dex */
    public static final class c<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.d f71910e;

        /* renamed from: f  reason: collision with root package name */
        public final h.q.e<T> f71911f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f71912g;

        /* renamed from: h  reason: collision with root package name */
        public final h.d<? extends T> f71913h;

        /* renamed from: i  reason: collision with root package name */
        public final g.a f71914i;
        public final h.o.b.a j = new h.o.b.a();
        public boolean k;
        public long l;

        /* loaded from: classes8.dex */
        public class a extends h.j<T> {
            public a() {
            }

            @Override // h.e
            public void onCompleted() {
                c.this.f71911f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                c.this.f71911f.onError(th);
            }

            @Override // h.e
            public void onNext(T t) {
                c.this.f71911f.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                c.this.j.c(fVar);
            }
        }

        public c(h.q.e<T> eVar, b<T> bVar, h.u.d dVar, h.d<? extends T> dVar2, g.a aVar) {
            this.f71911f = eVar;
            this.f71912g = bVar;
            this.f71910e = dVar;
            this.f71913h = dVar2;
            this.f71914i = aVar;
        }

        public void b(long j) {
            boolean z;
            synchronized (this) {
                z = true;
                if (j != this.l || this.k) {
                    z = false;
                } else {
                    this.k = true;
                }
            }
            if (z) {
                if (this.f71913h == null) {
                    this.f71911f.onError(new TimeoutException());
                    return;
                }
                a aVar = new a();
                this.f71913h.I(aVar);
                this.f71910e.a(aVar);
            }
        }

        @Override // h.e
        public void onCompleted() {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.k) {
                    z = false;
                } else {
                    this.k = true;
                }
            }
            if (z) {
                this.f71910e.unsubscribe();
                this.f71911f.onCompleted();
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.k) {
                    z = false;
                } else {
                    this.k = true;
                }
            }
            if (z) {
                this.f71910e.unsubscribe();
                this.f71911f.onError(th);
            }
        }

        @Override // h.e
        public void onNext(T t) {
            long j;
            boolean z;
            synchronized (this) {
                if (!this.k) {
                    j = this.l + 1;
                    this.l = j;
                    z = true;
                } else {
                    j = this.l;
                    z = false;
                }
            }
            if (z) {
                this.f71911f.onNext(t);
                this.f71910e.a(this.f71912g.a(this, Long.valueOf(j), t, this.f71914i));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.j.c(fVar);
        }
    }

    public u(a<T> aVar, b<T> bVar, h.d<? extends T> dVar, h.g gVar) {
        this.f71906e = aVar;
        this.f71907f = bVar;
        this.f71908g = dVar;
        this.f71909h = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        g.a createWorker = this.f71909h.createWorker();
        jVar.add(createWorker);
        h.q.e eVar = new h.q.e(jVar);
        h.u.d dVar = new h.u.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.f71907f, dVar, this.f71908g, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.j);
        dVar.a(this.f71906e.a(cVar, 0L, createWorker));
        return cVar;
    }
}

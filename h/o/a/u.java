package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class u<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f68546e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f68547f;

    /* renamed from: g  reason: collision with root package name */
    public final h.d<? extends T> f68548g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f68549h;

    /* loaded from: classes7.dex */
    public interface a<T> extends h.n.h<c<T>, Long, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public interface b<T> extends h.n.i<c<T>, Long, T, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public static final class c<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.d f68550e;

        /* renamed from: f  reason: collision with root package name */
        public final h.q.e<T> f68551f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f68552g;

        /* renamed from: h  reason: collision with root package name */
        public final h.d<? extends T> f68553h;

        /* renamed from: i  reason: collision with root package name */
        public final g.a f68554i;
        public final h.o.b.a j = new h.o.b.a();
        public boolean k;
        public long l;

        /* loaded from: classes7.dex */
        public class a extends h.j<T> {
            public a() {
            }

            @Override // h.e
            public void onCompleted() {
                c.this.f68551f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                c.this.f68551f.onError(th);
            }

            @Override // h.e
            public void onNext(T t) {
                c.this.f68551f.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                c.this.j.c(fVar);
            }
        }

        public c(h.q.e<T> eVar, b<T> bVar, h.u.d dVar, h.d<? extends T> dVar2, g.a aVar) {
            this.f68551f = eVar;
            this.f68552g = bVar;
            this.f68550e = dVar;
            this.f68553h = dVar2;
            this.f68554i = aVar;
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
                if (this.f68553h == null) {
                    this.f68551f.onError(new TimeoutException());
                    return;
                }
                a aVar = new a();
                this.f68553h.I(aVar);
                this.f68550e.a(aVar);
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
                this.f68550e.unsubscribe();
                this.f68551f.onCompleted();
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
                this.f68550e.unsubscribe();
                this.f68551f.onError(th);
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
                this.f68551f.onNext(t);
                this.f68550e.a(this.f68552g.a(this, Long.valueOf(j), t, this.f68554i));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.j.c(fVar);
        }
    }

    public u(a<T> aVar, b<T> bVar, h.d<? extends T> dVar, h.g gVar) {
        this.f68546e = aVar;
        this.f68547f = bVar;
        this.f68548g = dVar;
        this.f68549h = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        g.a createWorker = this.f68549h.createWorker();
        jVar.add(createWorker);
        h.q.e eVar = new h.q.e(jVar);
        h.u.d dVar = new h.u.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.f68547f, dVar, this.f68548g, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.j);
        dVar.a(this.f68546e.a(cVar, 0L, createWorker));
        return cVar;
    }
}

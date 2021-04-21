package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class w<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f68979e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f68980f;

    /* renamed from: g  reason: collision with root package name */
    public final h.d<? extends T> f68981g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f68982h;

    /* loaded from: classes7.dex */
    public interface a<T> extends h.n.h<c<T>, Long, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public interface b<T> extends h.n.i<c<T>, Long, T, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public static final class c<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.d f68983e;

        /* renamed from: f  reason: collision with root package name */
        public final h.q.e<T> f68984f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f68985g;

        /* renamed from: h  reason: collision with root package name */
        public final h.d<? extends T> f68986h;
        public final g.a i;
        public final h.o.b.a j = new h.o.b.a();
        public boolean k;
        public long l;

        /* loaded from: classes7.dex */
        public class a extends h.j<T> {
            public a() {
            }

            @Override // h.e
            public void onCompleted() {
                c.this.f68984f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                c.this.f68984f.onError(th);
            }

            @Override // h.e
            public void onNext(T t) {
                c.this.f68984f.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                c.this.j.c(fVar);
            }
        }

        public c(h.q.e<T> eVar, b<T> bVar, h.u.d dVar, h.d<? extends T> dVar2, g.a aVar) {
            this.f68984f = eVar;
            this.f68985g = bVar;
            this.f68983e = dVar;
            this.f68986h = dVar2;
            this.i = aVar;
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
                if (this.f68986h == null) {
                    this.f68984f.onError(new TimeoutException());
                    return;
                }
                a aVar = new a();
                this.f68986h.L(aVar);
                this.f68983e.a(aVar);
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
                this.f68983e.unsubscribe();
                this.f68984f.onCompleted();
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
                this.f68983e.unsubscribe();
                this.f68984f.onError(th);
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
                this.f68984f.onNext(t);
                this.f68983e.a(this.f68985g.a(this, Long.valueOf(j), t, this.i));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.j.c(fVar);
        }
    }

    public w(a<T> aVar, b<T> bVar, h.d<? extends T> dVar, h.g gVar) {
        this.f68979e = aVar;
        this.f68980f = bVar;
        this.f68981g = dVar;
        this.f68982h = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        g.a createWorker = this.f68982h.createWorker();
        jVar.add(createWorker);
        h.q.e eVar = new h.q.e(jVar);
        h.u.d dVar = new h.u.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.f68980f, dVar, this.f68981g, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.j);
        dVar.a(this.f68979e.a(cVar, 0L, createWorker));
        return cVar;
    }
}

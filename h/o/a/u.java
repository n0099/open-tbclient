package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class u<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f67823e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f67824f;

    /* renamed from: g  reason: collision with root package name */
    public final h.d<? extends T> f67825g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f67826h;

    /* loaded from: classes7.dex */
    public interface a<T> extends h.n.h<c<T>, Long, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public interface b<T> extends h.n.i<c<T>, Long, T, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public static final class c<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.d f67827e;

        /* renamed from: f  reason: collision with root package name */
        public final h.q.e<T> f67828f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f67829g;

        /* renamed from: h  reason: collision with root package name */
        public final h.d<? extends T> f67830h;

        /* renamed from: i  reason: collision with root package name */
        public final g.a f67831i;
        public final h.o.b.a j = new h.o.b.a();
        public boolean k;
        public long l;

        /* loaded from: classes7.dex */
        public class a extends h.j<T> {
            public a() {
            }

            @Override // h.e
            public void onCompleted() {
                c.this.f67828f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                c.this.f67828f.onError(th);
            }

            @Override // h.e
            public void onNext(T t) {
                c.this.f67828f.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                c.this.j.c(fVar);
            }
        }

        public c(h.q.e<T> eVar, b<T> bVar, h.u.d dVar, h.d<? extends T> dVar2, g.a aVar) {
            this.f67828f = eVar;
            this.f67829g = bVar;
            this.f67827e = dVar;
            this.f67830h = dVar2;
            this.f67831i = aVar;
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
                if (this.f67830h == null) {
                    this.f67828f.onError(new TimeoutException());
                    return;
                }
                a aVar = new a();
                this.f67830h.I(aVar);
                this.f67827e.a(aVar);
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
                this.f67827e.unsubscribe();
                this.f67828f.onCompleted();
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
                this.f67827e.unsubscribe();
                this.f67828f.onError(th);
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
                this.f67828f.onNext(t);
                this.f67827e.a(this.f67829g.a(this, Long.valueOf(j), t, this.f67831i));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.j.c(fVar);
        }
    }

    public u(a<T> aVar, b<T> bVar, h.d<? extends T> dVar, h.g gVar) {
        this.f67823e = aVar;
        this.f67824f = bVar;
        this.f67825g = dVar;
        this.f67826h = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        g.a createWorker = this.f67826h.createWorker();
        jVar.add(createWorker);
        h.q.e eVar = new h.q.e(jVar);
        h.u.d dVar = new h.u.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.f67824f, dVar, this.f67825g, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.j);
        dVar.a(this.f67823e.a(cVar, 0L, createWorker));
        return cVar;
    }
}

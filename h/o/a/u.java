package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class u<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f68503e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f68504f;

    /* renamed from: g  reason: collision with root package name */
    public final h.d<? extends T> f68505g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f68506h;

    /* loaded from: classes7.dex */
    public interface a<T> extends h.n.h<c<T>, Long, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public interface b<T> extends h.n.i<c<T>, Long, T, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public static final class c<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.d f68507e;

        /* renamed from: f  reason: collision with root package name */
        public final h.q.e<T> f68508f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f68509g;

        /* renamed from: h  reason: collision with root package name */
        public final h.d<? extends T> f68510h;

        /* renamed from: i  reason: collision with root package name */
        public final g.a f68511i;
        public final h.o.b.a j = new h.o.b.a();
        public boolean k;
        public long l;

        /* loaded from: classes7.dex */
        public class a extends h.j<T> {
            public a() {
            }

            @Override // h.e
            public void onCompleted() {
                c.this.f68508f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                c.this.f68508f.onError(th);
            }

            @Override // h.e
            public void onNext(T t) {
                c.this.f68508f.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                c.this.j.c(fVar);
            }
        }

        public c(h.q.e<T> eVar, b<T> bVar, h.u.d dVar, h.d<? extends T> dVar2, g.a aVar) {
            this.f68508f = eVar;
            this.f68509g = bVar;
            this.f68507e = dVar;
            this.f68510h = dVar2;
            this.f68511i = aVar;
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
                if (this.f68510h == null) {
                    this.f68508f.onError(new TimeoutException());
                    return;
                }
                a aVar = new a();
                this.f68510h.I(aVar);
                this.f68507e.a(aVar);
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
                this.f68507e.unsubscribe();
                this.f68508f.onCompleted();
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
                this.f68507e.unsubscribe();
                this.f68508f.onError(th);
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
                this.f68508f.onNext(t);
                this.f68507e.a(this.f68509g.a(this, Long.valueOf(j), t, this.f68511i));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.j.c(fVar);
        }
    }

    public u(a<T> aVar, b<T> bVar, h.d<? extends T> dVar, h.g gVar) {
        this.f68503e = aVar;
        this.f68504f = bVar;
        this.f68505g = dVar;
        this.f68506h = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        g.a createWorker = this.f68506h.createWorker();
        jVar.add(createWorker);
        h.q.e eVar = new h.q.e(jVar);
        h.u.d dVar = new h.u.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.f68504f, dVar, this.f68505g, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.j);
        dVar.a(this.f68503e.a(cVar, 0L, createWorker));
        return cVar;
    }
}

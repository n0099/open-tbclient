package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class v<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f67816e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f67817f;

    /* renamed from: g  reason: collision with root package name */
    public final h.d<? extends T> f67818g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f67819h;

    /* loaded from: classes7.dex */
    public interface a<T> extends h.n.h<c<T>, Long, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public interface b<T> extends h.n.i<c<T>, Long, T, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public static final class c<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.d f67820e;

        /* renamed from: f  reason: collision with root package name */
        public final h.q.e<T> f67821f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f67822g;

        /* renamed from: h  reason: collision with root package name */
        public final h.d<? extends T> f67823h;
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
                c.this.f67821f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                c.this.f67821f.onError(th);
            }

            @Override // h.e
            public void onNext(T t) {
                c.this.f67821f.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                c.this.j.c(fVar);
            }
        }

        public c(h.q.e<T> eVar, b<T> bVar, h.u.d dVar, h.d<? extends T> dVar2, g.a aVar) {
            this.f67821f = eVar;
            this.f67822g = bVar;
            this.f67820e = dVar;
            this.f67823h = dVar2;
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
                if (this.f67823h == null) {
                    this.f67821f.onError(new TimeoutException());
                    return;
                }
                a aVar = new a();
                this.f67823h.J(aVar);
                this.f67820e.a(aVar);
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
                this.f67820e.unsubscribe();
                this.f67821f.onCompleted();
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
                this.f67820e.unsubscribe();
                this.f67821f.onError(th);
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
                this.f67821f.onNext(t);
                this.f67820e.a(this.f67822g.a(this, Long.valueOf(j), t, this.i));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.j.c(fVar);
        }
    }

    public v(a<T> aVar, b<T> bVar, h.d<? extends T> dVar, h.g gVar) {
        this.f67816e = aVar;
        this.f67817f = bVar;
        this.f67818g = dVar;
        this.f67819h = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        g.a createWorker = this.f67819h.createWorker();
        jVar.add(createWorker);
        h.q.e eVar = new h.q.e(jVar);
        h.u.d dVar = new h.u.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.f67817f, dVar, this.f67818g, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.j);
        dVar.a(this.f67816e.a(cVar, 0L, createWorker));
        return cVar;
    }
}

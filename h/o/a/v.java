package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class v<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f67821e;

    /* renamed from: f  reason: collision with root package name */
    public final b<T> f67822f;

    /* renamed from: g  reason: collision with root package name */
    public final h.d<? extends T> f67823g;

    /* renamed from: h  reason: collision with root package name */
    public final h.g f67824h;

    /* loaded from: classes7.dex */
    public interface a<T> extends h.n.h<c<T>, Long, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public interface b<T> extends h.n.i<c<T>, Long, T, g.a, h.k> {
    }

    /* loaded from: classes7.dex */
    public static final class c<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.d f67825e;

        /* renamed from: f  reason: collision with root package name */
        public final h.q.e<T> f67826f;

        /* renamed from: g  reason: collision with root package name */
        public final b<T> f67827g;

        /* renamed from: h  reason: collision with root package name */
        public final h.d<? extends T> f67828h;
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
                c.this.f67826f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                c.this.f67826f.onError(th);
            }

            @Override // h.e
            public void onNext(T t) {
                c.this.f67826f.onNext(t);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                c.this.j.c(fVar);
            }
        }

        public c(h.q.e<T> eVar, b<T> bVar, h.u.d dVar, h.d<? extends T> dVar2, g.a aVar) {
            this.f67826f = eVar;
            this.f67827g = bVar;
            this.f67825e = dVar;
            this.f67828h = dVar2;
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
                if (this.f67828h == null) {
                    this.f67826f.onError(new TimeoutException());
                    return;
                }
                a aVar = new a();
                this.f67828h.J(aVar);
                this.f67825e.a(aVar);
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
                this.f67825e.unsubscribe();
                this.f67826f.onCompleted();
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
                this.f67825e.unsubscribe();
                this.f67826f.onError(th);
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
                this.f67826f.onNext(t);
                this.f67825e.a(this.f67827g.a(this, Long.valueOf(j), t, this.i));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.j.c(fVar);
        }
    }

    public v(a<T> aVar, b<T> bVar, h.d<? extends T> dVar, h.g gVar) {
        this.f67821e = aVar;
        this.f67822f = bVar;
        this.f67823g = dVar;
        this.f67824h = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        g.a createWorker = this.f67824h.createWorker();
        jVar.add(createWorker);
        h.q.e eVar = new h.q.e(jVar);
        h.u.d dVar = new h.u.d();
        eVar.add(dVar);
        c cVar = new c(eVar, this.f67822f, dVar, this.f67823g, createWorker);
        eVar.add(cVar);
        eVar.setProducer(cVar.j);
        dVar.a(this.f67821e.a(cVar, 0L, createWorker));
        return cVar;
    }
}

package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes8.dex */
public final class i<T> implements d.a<T> {
    public static final h.n.f<h.d<? extends Notification<?>>, h.d<?>> j = new a();

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f71827e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> f71828f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f71829g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f71830h;

    /* renamed from: i  reason: collision with root package name */
    public final h.g f71831i;

    /* loaded from: classes8.dex */
    public static class a implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {

        /* renamed from: h.o.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1974a implements h.n.f<Notification<?>, Notification<?>> {
            public C1974a(a aVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.f
            /* renamed from: a */
            public Notification<?> call(Notification<?> notification) {
                return Notification.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: h.d<R>, h.d<?> */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            return dVar.k(new C1974a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f71832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.t.d f71833f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f71834g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f71835h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.u.d f71836i;

        /* loaded from: classes8.dex */
        public class a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public boolean f71837e;

            public a() {
            }

            public final void b() {
                long j;
                do {
                    j = b.this.f71835h.get();
                    if (j == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f71835h.compareAndSet(j, j - 1));
            }

            @Override // h.e
            public void onCompleted() {
                if (this.f71837e) {
                    return;
                }
                this.f71837e = true;
                unsubscribe();
                b.this.f71833f.onNext(Notification.a());
            }

            @Override // h.e
            public void onError(Throwable th) {
                if (this.f71837e) {
                    return;
                }
                this.f71837e = true;
                unsubscribe();
                b.this.f71833f.onNext(Notification.b(th));
            }

            @Override // h.e
            public void onNext(T t) {
                if (this.f71837e) {
                    return;
                }
                b.this.f71832e.onNext(t);
                b();
                b.this.f71834g.b(1L);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                b.this.f71834g.c(fVar);
            }
        }

        public b(h.j jVar, h.t.d dVar, h.o.b.a aVar, AtomicLong atomicLong, h.u.d dVar2) {
            this.f71832e = jVar;
            this.f71833f = dVar;
            this.f71834g = aVar;
            this.f71835h = atomicLong;
            this.f71836i = dVar2;
        }

        @Override // h.n.a
        public void call() {
            if (this.f71832e.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f71836i.a(aVar);
            i.this.f71827e.I(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {

        /* loaded from: classes8.dex */
        public class a extends h.j<Notification<?>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.j f71840e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h.j jVar, h.j jVar2) {
                super(jVar);
                this.f71840e = jVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.e
            /* renamed from: b */
            public void onNext(Notification<?> notification) {
                if (notification.i() && i.this.f71829g) {
                    this.f71840e.onCompleted();
                } else if (notification.j() && i.this.f71830h) {
                    this.f71840e.onError(notification.e());
                } else {
                    this.f71840e.onNext(notification);
                }
            }

            @Override // h.e
            public void onCompleted() {
                this.f71840e.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                this.f71840e.onError(th);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                fVar.request(Long.MAX_VALUE);
            }
        }

        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.j<? super Notification<?>> call(h.j<? super Notification<?>> jVar) {
            return new a(jVar, jVar);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.d f71842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.j f71843f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f71844g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f71845h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f71846i;
        public final /* synthetic */ AtomicBoolean j;

        /* loaded from: classes8.dex */
        public class a extends h.j<Object> {
            public a(h.j jVar) {
                super(jVar);
            }

            @Override // h.e
            public void onCompleted() {
                d.this.f71843f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                d.this.f71843f.onError(th);
            }

            @Override // h.e
            public void onNext(Object obj) {
                if (d.this.f71843f.isUnsubscribed()) {
                    return;
                }
                if (d.this.f71844g.get() > 0) {
                    d dVar = d.this;
                    dVar.f71845h.b(dVar.f71846i);
                    return;
                }
                d.this.j.compareAndSet(false, true);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                fVar.request(Long.MAX_VALUE);
            }
        }

        public d(i iVar, h.d dVar, h.j jVar, AtomicLong atomicLong, g.a aVar, h.n.a aVar2, AtomicBoolean atomicBoolean) {
            this.f71842e = dVar;
            this.f71843f = jVar;
            this.f71844g = atomicLong;
            this.f71845h = aVar;
            this.f71846i = aVar2;
            this.j = atomicBoolean;
        }

        @Override // h.n.a
        public void call() {
            this.f71842e.I(new a(this.f71843f));
        }
    }

    /* loaded from: classes8.dex */
    public class e implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f71848e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f71849f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f71850g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f71851h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f71852i;

        public e(i iVar, AtomicLong atomicLong, h.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, h.n.a aVar3) {
            this.f71848e = atomicLong;
            this.f71849f = aVar;
            this.f71850g = atomicBoolean;
            this.f71851h = aVar2;
            this.f71852i = aVar3;
        }

        @Override // h.f
        public void request(long j) {
            if (j > 0) {
                h.o.a.a.b(this.f71848e, j);
                this.f71849f.request(j);
                if (this.f71850g.compareAndSet(true, false)) {
                    this.f71851h.b(this.f71852i);
                }
            }
        }
    }

    public i(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar, boolean z, boolean z2, h.g gVar) {
        this.f71827e = dVar;
        this.f71828f = fVar;
        this.f71829g = z;
        this.f71830h = z2;
        this.f71831i = gVar;
    }

    public static <T> h.d<T> b(h.d<T> dVar) {
        return c(dVar, j);
    }

    public static <T> h.d<T> c(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar) {
        return h.d.b(new i(dVar, fVar, true, false, Schedulers.trampoline()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        g.a createWorker = this.f71831i.createWorker();
        jVar.add(createWorker);
        h.u.d dVar = new h.u.d();
        jVar.add(dVar);
        h.t.c<T, T> J = h.t.a.K().J();
        J.z(h.q.f.a());
        h.o.b.a aVar = new h.o.b.a();
        b bVar = new b(jVar, J, aVar, atomicLong, dVar);
        createWorker.b(new d(this, this.f71828f.call(J.j(new c())), jVar, atomicLong, createWorker, bVar, atomicBoolean));
        jVar.setProducer(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
    }
}

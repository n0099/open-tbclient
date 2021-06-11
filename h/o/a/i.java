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
    public final h.d<T> f71723e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> f71724f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f71725g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f71726h;

    /* renamed from: i  reason: collision with root package name */
    public final h.g f71727i;

    /* loaded from: classes8.dex */
    public static class a implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {

        /* renamed from: h.o.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1971a implements h.n.f<Notification<?>, Notification<?>> {
            public C1971a(a aVar) {
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
            return dVar.k(new C1971a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f71728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.t.d f71729f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f71730g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f71731h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.u.d f71732i;

        /* loaded from: classes8.dex */
        public class a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public boolean f71733e;

            public a() {
            }

            public final void b() {
                long j;
                do {
                    j = b.this.f71731h.get();
                    if (j == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f71731h.compareAndSet(j, j - 1));
            }

            @Override // h.e
            public void onCompleted() {
                if (this.f71733e) {
                    return;
                }
                this.f71733e = true;
                unsubscribe();
                b.this.f71729f.onNext(Notification.a());
            }

            @Override // h.e
            public void onError(Throwable th) {
                if (this.f71733e) {
                    return;
                }
                this.f71733e = true;
                unsubscribe();
                b.this.f71729f.onNext(Notification.b(th));
            }

            @Override // h.e
            public void onNext(T t) {
                if (this.f71733e) {
                    return;
                }
                b.this.f71728e.onNext(t);
                b();
                b.this.f71730g.b(1L);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                b.this.f71730g.c(fVar);
            }
        }

        public b(h.j jVar, h.t.d dVar, h.o.b.a aVar, AtomicLong atomicLong, h.u.d dVar2) {
            this.f71728e = jVar;
            this.f71729f = dVar;
            this.f71730g = aVar;
            this.f71731h = atomicLong;
            this.f71732i = dVar2;
        }

        @Override // h.n.a
        public void call() {
            if (this.f71728e.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f71732i.a(aVar);
            i.this.f71723e.I(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {

        /* loaded from: classes8.dex */
        public class a extends h.j<Notification<?>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.j f71736e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h.j jVar, h.j jVar2) {
                super(jVar);
                this.f71736e = jVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.e
            /* renamed from: b */
            public void onNext(Notification<?> notification) {
                if (notification.i() && i.this.f71725g) {
                    this.f71736e.onCompleted();
                } else if (notification.j() && i.this.f71726h) {
                    this.f71736e.onError(notification.e());
                } else {
                    this.f71736e.onNext(notification);
                }
            }

            @Override // h.e
            public void onCompleted() {
                this.f71736e.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                this.f71736e.onError(th);
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
        public final /* synthetic */ h.d f71738e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.j f71739f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f71740g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f71741h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f71742i;
        public final /* synthetic */ AtomicBoolean j;

        /* loaded from: classes8.dex */
        public class a extends h.j<Object> {
            public a(h.j jVar) {
                super(jVar);
            }

            @Override // h.e
            public void onCompleted() {
                d.this.f71739f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                d.this.f71739f.onError(th);
            }

            @Override // h.e
            public void onNext(Object obj) {
                if (d.this.f71739f.isUnsubscribed()) {
                    return;
                }
                if (d.this.f71740g.get() > 0) {
                    d dVar = d.this;
                    dVar.f71741h.b(dVar.f71742i);
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
            this.f71738e = dVar;
            this.f71739f = jVar;
            this.f71740g = atomicLong;
            this.f71741h = aVar;
            this.f71742i = aVar2;
            this.j = atomicBoolean;
        }

        @Override // h.n.a
        public void call() {
            this.f71738e.I(new a(this.f71739f));
        }
    }

    /* loaded from: classes8.dex */
    public class e implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f71744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f71745f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f71746g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f71747h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f71748i;

        public e(i iVar, AtomicLong atomicLong, h.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, h.n.a aVar3) {
            this.f71744e = atomicLong;
            this.f71745f = aVar;
            this.f71746g = atomicBoolean;
            this.f71747h = aVar2;
            this.f71748i = aVar3;
        }

        @Override // h.f
        public void request(long j) {
            if (j > 0) {
                h.o.a.a.b(this.f71744e, j);
                this.f71745f.request(j);
                if (this.f71746g.compareAndSet(true, false)) {
                    this.f71747h.b(this.f71748i);
                }
            }
        }
    }

    public i(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar, boolean z, boolean z2, h.g gVar) {
        this.f71723e = dVar;
        this.f71724f = fVar;
        this.f71725g = z;
        this.f71726h = z2;
        this.f71727i = gVar;
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
        g.a createWorker = this.f71727i.createWorker();
        jVar.add(createWorker);
        h.u.d dVar = new h.u.d();
        jVar.add(dVar);
        h.t.c<T, T> J = h.t.a.K().J();
        J.z(h.q.f.a());
        h.o.b.a aVar = new h.o.b.a();
        b bVar = new b(jVar, J, aVar, atomicLong, dVar);
        createWorker.b(new d(this, this.f71724f.call(J.j(new c())), jVar, atomicLong, createWorker, bVar, atomicBoolean));
        jVar.setProducer(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
    }
}

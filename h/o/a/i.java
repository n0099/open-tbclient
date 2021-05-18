package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public final class i<T> implements d.a<T> {
    public static final h.n.f<h.d<? extends Notification<?>>, h.d<?>> j = new a();

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68424e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> f68425f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f68426g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f68427h;

    /* renamed from: i  reason: collision with root package name */
    public final h.g f68428i;

    /* loaded from: classes7.dex */
    public static class a implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {

        /* renamed from: h.o.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1918a implements h.n.f<Notification<?>, Notification<?>> {
            public C1918a(a aVar) {
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
            return dVar.k(new C1918a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.t.d f68430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f68431g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f68432h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.u.d f68433i;

        /* loaded from: classes7.dex */
        public class a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public boolean f68434e;

            public a() {
            }

            public final void b() {
                long j;
                do {
                    j = b.this.f68432h.get();
                    if (j == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f68432h.compareAndSet(j, j - 1));
            }

            @Override // h.e
            public void onCompleted() {
                if (this.f68434e) {
                    return;
                }
                this.f68434e = true;
                unsubscribe();
                b.this.f68430f.onNext(Notification.a());
            }

            @Override // h.e
            public void onError(Throwable th) {
                if (this.f68434e) {
                    return;
                }
                this.f68434e = true;
                unsubscribe();
                b.this.f68430f.onNext(Notification.b(th));
            }

            @Override // h.e
            public void onNext(T t) {
                if (this.f68434e) {
                    return;
                }
                b.this.f68429e.onNext(t);
                b();
                b.this.f68431g.b(1L);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                b.this.f68431g.c(fVar);
            }
        }

        public b(h.j jVar, h.t.d dVar, h.o.b.a aVar, AtomicLong atomicLong, h.u.d dVar2) {
            this.f68429e = jVar;
            this.f68430f = dVar;
            this.f68431g = aVar;
            this.f68432h = atomicLong;
            this.f68433i = dVar2;
        }

        @Override // h.n.a
        public void call() {
            if (this.f68429e.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f68433i.a(aVar);
            i.this.f68424e.I(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {

        /* loaded from: classes7.dex */
        public class a extends h.j<Notification<?>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.j f68437e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h.j jVar, h.j jVar2) {
                super(jVar);
                this.f68437e = jVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.e
            /* renamed from: b */
            public void onNext(Notification<?> notification) {
                if (notification.i() && i.this.f68426g) {
                    this.f68437e.onCompleted();
                } else if (notification.j() && i.this.f68427h) {
                    this.f68437e.onError(notification.e());
                } else {
                    this.f68437e.onNext(notification);
                }
            }

            @Override // h.e
            public void onCompleted() {
                this.f68437e.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                this.f68437e.onError(th);
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

    /* loaded from: classes7.dex */
    public class d implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.d f68439e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.j f68440f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f68441g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f68442h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f68443i;
        public final /* synthetic */ AtomicBoolean j;

        /* loaded from: classes7.dex */
        public class a extends h.j<Object> {
            public a(h.j jVar) {
                super(jVar);
            }

            @Override // h.e
            public void onCompleted() {
                d.this.f68440f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                d.this.f68440f.onError(th);
            }

            @Override // h.e
            public void onNext(Object obj) {
                if (d.this.f68440f.isUnsubscribed()) {
                    return;
                }
                if (d.this.f68441g.get() > 0) {
                    d dVar = d.this;
                    dVar.f68442h.b(dVar.f68443i);
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
            this.f68439e = dVar;
            this.f68440f = jVar;
            this.f68441g = atomicLong;
            this.f68442h = aVar;
            this.f68443i = aVar2;
            this.j = atomicBoolean;
        }

        @Override // h.n.a
        public void call() {
            this.f68439e.I(new a(this.f68440f));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f68445e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f68446f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f68447g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f68448h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f68449i;

        public e(i iVar, AtomicLong atomicLong, h.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, h.n.a aVar3) {
            this.f68445e = atomicLong;
            this.f68446f = aVar;
            this.f68447g = atomicBoolean;
            this.f68448h = aVar2;
            this.f68449i = aVar3;
        }

        @Override // h.f
        public void request(long j) {
            if (j > 0) {
                h.o.a.a.b(this.f68445e, j);
                this.f68446f.request(j);
                if (this.f68447g.compareAndSet(true, false)) {
                    this.f68448h.b(this.f68449i);
                }
            }
        }
    }

    public i(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar, boolean z, boolean z2, h.g gVar) {
        this.f68424e = dVar;
        this.f68425f = fVar;
        this.f68426g = z;
        this.f68427h = z2;
        this.f68428i = gVar;
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
        g.a createWorker = this.f68428i.createWorker();
        jVar.add(createWorker);
        h.u.d dVar = new h.u.d();
        jVar.add(dVar);
        h.t.c<T, T> J = h.t.a.K().J();
        J.z(h.q.f.a());
        h.o.b.a aVar = new h.o.b.a();
        b bVar = new b(jVar, J, aVar, atomicLong, dVar);
        createWorker.b(new d(this, this.f68425f.call(J.j(new c())), jVar, atomicLong, createWorker, bVar, atomicBoolean));
        jVar.setProducer(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
    }
}

package h;

import h.g;
import h.o.a.b0;
import h.o.a.c0;
import h.o.a.x;
import h.o.a.y;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d<T> f68687a;

    /* loaded from: classes7.dex */
    public class a extends i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.n.b f68688f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.n.b f68689g;

        public a(h hVar, h.n.b bVar, h.n.b bVar2) {
            this.f68688f = bVar;
            this.f68689g = bVar2;
        }

        @Override // h.i
        public final void b(Throwable th) {
            try {
                this.f68688f.call(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // h.i
        public final void c(T t) {
            try {
                this.f68689g.call(t);
            } finally {
                unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f68690e;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f68692e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f68693f;

            /* renamed from: h.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1902a extends i<T> {
                public C1902a() {
                }

                @Override // h.i
                public void b(Throwable th) {
                    try {
                        a.this.f68692e.b(th);
                    } finally {
                        a.this.f68693f.unsubscribe();
                    }
                }

                @Override // h.i
                public void c(T t) {
                    try {
                        a.this.f68692e.c(t);
                    } finally {
                        a.this.f68693f.unsubscribe();
                    }
                }
            }

            public a(i iVar, g.a aVar) {
                this.f68692e = iVar;
                this.f68693f = aVar;
            }

            @Override // h.n.a
            public void call() {
                C1902a c1902a = new C1902a();
                this.f68692e.a(c1902a);
                h.this.j(c1902a);
            }
        }

        public b(g gVar) {
            this.f68690e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            g.a createWorker = this.f68690e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new a(iVar, createWorker));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.n.b f68696e;

        public c(h hVar, h.n.b bVar) {
            this.f68696e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            this.f68696e.call(th);
        }
    }

    /* loaded from: classes7.dex */
    public interface d<T> extends h.n.b<i<? super T>> {
    }

    public h(d<T> dVar) {
        this.f68687a = h.r.c.i(dVar);
    }

    public static <T> h.d<T> a(h<T> hVar) {
        return h.d.c(new c0(hVar.f68687a));
    }

    public static <T> h<T> b(d<T> dVar) {
        return new h<>(dVar);
    }

    public static <T> h<T> g(T t) {
        return h.o.d.h.n(t);
    }

    public final h<T> c(long j, TimeUnit timeUnit) {
        return d(j, timeUnit, Schedulers.computation());
    }

    public final h<T> d(long j, TimeUnit timeUnit, g gVar) {
        return b(new x(this.f68687a, j, timeUnit, gVar));
    }

    public final h<T> e(h.n.b<Throwable> bVar) {
        if (bVar != null) {
            return b(new y(this, Actions.a(), new c(this, bVar)));
        }
        throw new IllegalArgumentException("onError is null");
    }

    public final h<T> f(h.n.b<? super T> bVar) {
        if (bVar != null) {
            return b(new y(this, bVar, Actions.a()));
        }
        throw new IllegalArgumentException("onSuccess is null");
    }

    public final h<T> h(g gVar) {
        if (this instanceof h.o.d.h) {
            return ((h.o.d.h) this).o(gVar);
        }
        if (gVar != null) {
            return b(new b0(this.f68687a, gVar));
        }
        throw new NullPointerException("scheduler is null");
    }

    public final k i() {
        return k(Actions.a(), Actions.b());
    }

    public final k j(i<? super T> iVar) {
        if (iVar != null) {
            try {
                h.r.c.t(this, this.f68687a).call(iVar);
                return h.r.c.s(iVar);
            } catch (Throwable th) {
                h.m.a.e(th);
                try {
                    iVar.b(h.r.c.r(th));
                    return h.u.e.b();
                } catch (Throwable th2) {
                    h.m.a.e(th2);
                    RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    h.r.c.r(runtimeException);
                    throw runtimeException;
                }
            }
        }
        throw new IllegalArgumentException("te is null");
    }

    public final k k(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        if (bVar != null) {
            if (bVar2 != null) {
                return j(new a(this, bVar2, bVar));
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    public final h<T> l(g gVar) {
        if (this instanceof h.o.d.h) {
            return ((h.o.d.h) this).o(gVar);
        }
        return b(new b(gVar));
    }

    public final h.d<T> m() {
        return a(this);
    }
}

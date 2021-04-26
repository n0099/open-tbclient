package h;

import h.g;
import h.o.a.a0;
import h.o.a.v;
import h.o.a.w;
import h.o.a.z;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d<T> f67697a;

    /* loaded from: classes7.dex */
    public class a extends i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.n.b f67698f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.n.b f67699g;

        public a(h hVar, h.n.b bVar, h.n.b bVar2) {
            this.f67698f = bVar;
            this.f67699g = bVar2;
        }

        @Override // h.i
        public final void b(Throwable th) {
            try {
                this.f67698f.call(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // h.i
        public final void c(T t) {
            try {
                this.f67699g.call(t);
            } finally {
                unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f67700e;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f67702e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f67703f;

            /* renamed from: h.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1853a extends i<T> {
                public C1853a() {
                }

                @Override // h.i
                public void b(Throwable th) {
                    try {
                        a.this.f67702e.b(th);
                    } finally {
                        a.this.f67703f.unsubscribe();
                    }
                }

                @Override // h.i
                public void c(T t) {
                    try {
                        a.this.f67702e.c(t);
                    } finally {
                        a.this.f67703f.unsubscribe();
                    }
                }
            }

            public a(i iVar, g.a aVar) {
                this.f67702e = iVar;
                this.f67703f = aVar;
            }

            @Override // h.n.a
            public void call() {
                C1853a c1853a = new C1853a();
                this.f67702e.a(c1853a);
                h.this.j(c1853a);
            }
        }

        public b(g gVar) {
            this.f67700e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            g.a createWorker = this.f67700e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new a(iVar, createWorker));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.n.b f67706e;

        public c(h hVar, h.n.b bVar) {
            this.f67706e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            this.f67706e.call(th);
        }
    }

    /* loaded from: classes7.dex */
    public interface d<T> extends h.n.b<i<? super T>> {
    }

    public h(d<T> dVar) {
        this.f67697a = h.r.c.i(dVar);
    }

    public static <T> h.d<T> a(h<T> hVar) {
        return h.d.b(new a0(hVar.f67697a));
    }

    public static <T> h<T> b(d<T> dVar) {
        return new h<>(dVar);
    }

    public static <T> h<T> g(T t) {
        return h.o.d.g.n(t);
    }

    public final h<T> c(long j, TimeUnit timeUnit) {
        return d(j, timeUnit, Schedulers.computation());
    }

    public final h<T> d(long j, TimeUnit timeUnit, g gVar) {
        return b(new v(this.f67697a, j, timeUnit, gVar));
    }

    public final h<T> e(h.n.b<Throwable> bVar) {
        if (bVar != null) {
            return b(new w(this, Actions.a(), new c(this, bVar)));
        }
        throw new IllegalArgumentException("onError is null");
    }

    public final h<T> f(h.n.b<? super T> bVar) {
        if (bVar != null) {
            return b(new w(this, bVar, Actions.a()));
        }
        throw new IllegalArgumentException("onSuccess is null");
    }

    public final h<T> h(g gVar) {
        if (this instanceof h.o.d.g) {
            return ((h.o.d.g) this).o(gVar);
        }
        if (gVar != null) {
            return b(new z(this.f67697a, gVar));
        }
        throw new NullPointerException("scheduler is null");
    }

    public final k i() {
        return k(Actions.a(), Actions.b());
    }

    public final k j(i<? super T> iVar) {
        if (iVar != null) {
            try {
                h.r.c.t(this, this.f67697a).call(iVar);
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
        if (this instanceof h.o.d.g) {
            return ((h.o.d.g) this).o(gVar);
        }
        return b(new b(gVar));
    }

    public final h.d<T> m() {
        return a(this);
    }
}

package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import h.d;
import h.g;
import h.j;
import h.k;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes7.dex */
public final class ScalarSynchronousObservable<T> extends h.d<T> {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f68253g = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: f  reason: collision with root package name */
    public final T f68254f;

    /* loaded from: classes7.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements h.f, h.n.a {
        public static final long serialVersionUID = -2466317989629281651L;
        public final j<? super T> actual;
        public final h.n.f<h.n.a, k> onSchedule;
        public final T value;

        public ScalarAsyncProducer(j<? super T> jVar, T t, h.n.f<h.n.a, k> fVar) {
            this.actual = jVar;
            this.value = t;
            this.onSchedule = fVar;
        }

        @Override // h.n.a
        public void call() {
            j<? super T> jVar = this.actual;
            if (jVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.value;
            try {
                jVar.onNext(obj);
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onCompleted();
            } catch (Throwable th) {
                h.m.a.g(th, jVar, obj);
            }
        }

        @Override // h.f
        public void request(long j) {
            if (j >= 0) {
                if (j == 0 || !compareAndSet(false, true)) {
                    return;
                }
                this.actual.add(this.onSchedule.call(this));
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + "]";
        }
    }

    /* loaded from: classes7.dex */
    public class a implements h.n.f<h.n.a, k> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.o.c.b f68255e;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, h.o.c.b bVar) {
            this.f68255e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public k call(h.n.a aVar) {
            return this.f68255e.a(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements h.n.f<h.n.a, k> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f68256e;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68257e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f68258f;

            public a(b bVar, h.n.a aVar, g.a aVar2) {
                this.f68257e = aVar;
                this.f68258f = aVar2;
            }

            @Override // h.n.a
            public void call() {
                try {
                    this.f68257e.call();
                } finally {
                    this.f68258f.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, g gVar) {
            this.f68256e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public k call(h.n.a aVar) {
            g.a createWorker = this.f68256e.createWorker();
            createWorker.b(new a(this, aVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a<R> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.n.f f68259e;

        public c(h.n.f fVar) {
            this.f68259e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super R> jVar) {
            h.d dVar = (h.d) this.f68259e.call(ScalarSynchronousObservable.this.f68254f);
            if (dVar instanceof ScalarSynchronousObservable) {
                jVar.setProducer(ScalarSynchronousObservable.L(jVar, ((ScalarSynchronousObservable) dVar).f68254f));
            } else {
                dVar.J(h.q.f.c(jVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final T f68261e;

        public d(T t) {
            this.f68261e = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            jVar.setProducer(ScalarSynchronousObservable.L(jVar, this.f68261e));
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final T f68262e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<h.n.a, k> f68263f;

        public e(T t, h.n.f<h.n.a, k> fVar) {
            this.f68262e = t;
            this.f68263f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            jVar.setProducer(new ScalarAsyncProducer(jVar, this.f68262e, this.f68263f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class f<T> implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f68264e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68265f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68266g;

        public f(j<? super T> jVar, T t) {
            this.f68264e = jVar;
            this.f68265f = t;
        }

        @Override // h.f
        public void request(long j) {
            if (this.f68266g) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException("n >= required but it was " + j);
            } else if (j == 0) {
            } else {
                this.f68266g = true;
                j<? super T> jVar = this.f68264e;
                if (jVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.f68265f;
                try {
                    jVar.onNext(obj);
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    jVar.onCompleted();
                } catch (Throwable th) {
                    h.m.a.g(th, jVar, obj);
                }
            }
        }
    }

    public ScalarSynchronousObservable(T t) {
        super(h.r.c.h(new d(t)));
        this.f68254f = t;
    }

    public static <T> ScalarSynchronousObservable<T> K(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public static <T> h.f L(j<? super T> jVar, T t) {
        if (f68253g) {
            return new SingleProducer(jVar, t);
        }
        return new f(jVar, t);
    }

    public T M() {
        return this.f68254f;
    }

    public <R> h.d<R> N(h.n.f<? super T, ? extends h.d<? extends R>> fVar) {
        return h.d.c(new c(fVar));
    }

    public h.d<T> O(g gVar) {
        h.n.f bVar;
        if (gVar instanceof h.o.c.b) {
            bVar = new a(this, (h.o.c.b) gVar);
        } else {
            bVar = new b(this, gVar);
        }
        return h.d.c(new e(this.f68254f, bVar));
    }
}

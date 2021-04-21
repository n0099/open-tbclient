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
    public static final boolean f69411g = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: f  reason: collision with root package name */
    public final T f69412f;

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
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i == 0 || !compareAndSet(false, true)) {
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
        public final /* synthetic */ h.o.c.b f69413e;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, h.o.c.b bVar) {
            this.f69413e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public k call(h.n.a aVar) {
            return this.f69413e.a(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements h.n.f<h.n.a, k> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f69414e;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f69415e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f69416f;

            public a(b bVar, h.n.a aVar, g.a aVar2) {
                this.f69415e = aVar;
                this.f69416f = aVar2;
            }

            @Override // h.n.a
            public void call() {
                try {
                    this.f69415e.call();
                } finally {
                    this.f69416f.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, g gVar) {
            this.f69414e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public k call(h.n.a aVar) {
            g.a createWorker = this.f69414e.createWorker();
            createWorker.b(new a(this, aVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a<R> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.n.f f69417e;

        public c(h.n.f fVar) {
            this.f69417e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super R> jVar) {
            h.d dVar = (h.d) this.f69417e.call(ScalarSynchronousObservable.this.f69412f);
            if (dVar instanceof ScalarSynchronousObservable) {
                jVar.setProducer(ScalarSynchronousObservable.N(jVar, ((ScalarSynchronousObservable) dVar).f69412f));
            } else {
                dVar.L(h.q.f.c(jVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final T f69419e;

        public d(T t) {
            this.f69419e = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            jVar.setProducer(ScalarSynchronousObservable.N(jVar, this.f69419e));
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final T f69420e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<h.n.a, k> f69421f;

        public e(T t, h.n.f<h.n.a, k> fVar) {
            this.f69420e = t;
            this.f69421f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            jVar.setProducer(new ScalarAsyncProducer(jVar, this.f69420e, this.f69421f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class f<T> implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f69422e;

        /* renamed from: f  reason: collision with root package name */
        public final T f69423f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69424g;

        public f(j<? super T> jVar, T t) {
            this.f69422e = jVar;
            this.f69423f = t;
        }

        @Override // h.f
        public void request(long j) {
            if (this.f69424g) {
                return;
            }
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalStateException("n >= required but it was " + j);
            } else if (i == 0) {
            } else {
                this.f69424g = true;
                j<? super T> jVar = this.f69422e;
                if (jVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.f69423f;
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
        this.f69412f = t;
    }

    public static <T> ScalarSynchronousObservable<T> M(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public static <T> h.f N(j<? super T> jVar, T t) {
        if (f69411g) {
            return new SingleProducer(jVar, t);
        }
        return new f(jVar, t);
    }

    public T O() {
        return this.f69412f;
    }

    public <R> h.d<R> P(h.n.f<? super T, ? extends h.d<? extends R>> fVar) {
        return h.d.c(new c(fVar));
    }

    public h.d<T> Q(g gVar) {
        h.n.f bVar;
        if (gVar instanceof h.o.c.b) {
            bVar = new a(this, (h.o.c.b) gVar);
        } else {
            bVar = new b(this, gVar);
        }
        return h.d.c(new e(this.f69412f, bVar));
    }
}

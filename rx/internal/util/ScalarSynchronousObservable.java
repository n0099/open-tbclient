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
    public static final boolean f69137g = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: f  reason: collision with root package name */
    public final T f69138f;

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
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 >= 0) {
                if (i2 == 0 || !compareAndSet(false, true)) {
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
        public final /* synthetic */ h.o.c.b f69139e;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, h.o.c.b bVar) {
            this.f69139e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public k call(h.n.a aVar) {
            return this.f69139e.a(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements h.n.f<h.n.a, k> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f69140e;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f69141e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f69142f;

            public a(b bVar, h.n.a aVar, g.a aVar2) {
                this.f69141e = aVar;
                this.f69142f = aVar2;
            }

            @Override // h.n.a
            public void call() {
                try {
                    this.f69141e.call();
                } finally {
                    this.f69142f.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, g gVar) {
            this.f69140e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public k call(h.n.a aVar) {
            g.a createWorker = this.f69140e.createWorker();
            createWorker.b(new a(this, aVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a<R> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.n.f f69143e;

        public c(h.n.f fVar) {
            this.f69143e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super R> jVar) {
            h.d dVar = (h.d) this.f69143e.call(ScalarSynchronousObservable.this.f69138f);
            if (dVar instanceof ScalarSynchronousObservable) {
                jVar.setProducer(ScalarSynchronousObservable.K(jVar, ((ScalarSynchronousObservable) dVar).f69138f));
            } else {
                dVar.I(h.q.f.c(jVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final T f69145e;

        public d(T t) {
            this.f69145e = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            jVar.setProducer(ScalarSynchronousObservable.K(jVar, this.f69145e));
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final T f69146e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<h.n.a, k> f69147f;

        public e(T t, h.n.f<h.n.a, k> fVar) {
            this.f69146e = t;
            this.f69147f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            jVar.setProducer(new ScalarAsyncProducer(jVar, this.f69146e, this.f69147f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class f<T> implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f69148e;

        /* renamed from: f  reason: collision with root package name */
        public final T f69149f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f69150g;

        public f(j<? super T> jVar, T t) {
            this.f69148e = jVar;
            this.f69149f = t;
        }

        @Override // h.f
        public void request(long j) {
            if (this.f69150g) {
                return;
            }
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalStateException("n >= required but it was " + j);
            } else if (i2 == 0) {
            } else {
                this.f69150g = true;
                j<? super T> jVar = this.f69148e;
                if (jVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.f69149f;
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
        this.f69138f = t;
    }

    public static <T> ScalarSynchronousObservable<T> J(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public static <T> h.f K(j<? super T> jVar, T t) {
        if (f69137g) {
            return new SingleProducer(jVar, t);
        }
        return new f(jVar, t);
    }

    public T L() {
        return this.f69138f;
    }

    public <R> h.d<R> M(h.n.f<? super T, ? extends h.d<? extends R>> fVar) {
        return h.d.b(new c(fVar));
    }

    public h.d<T> N(g gVar) {
        h.n.f bVar;
        if (gVar instanceof h.o.c.b) {
            bVar = new a(this, (h.o.c.b) gVar);
        } else {
            bVar = new b(this, gVar);
        }
        return h.d.b(new e(this.f69138f, bVar));
    }
}

package rx.internal.util;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import h.d;
import h.g;
import h.j;
import h.k;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.producers.SingleProducer;
/* loaded from: classes8.dex */
public final class ScalarSynchronousObservable<T> extends h.d<T> {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f72593g = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: f  reason: collision with root package name */
    public final T f72594f;

    /* loaded from: classes8.dex */
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
            return "ScalarAsyncProducer[" + this.value + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements h.n.f<h.n.a, k> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.o.c.b f72595e;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, h.o.c.b bVar) {
            this.f72595e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public k call(h.n.a aVar) {
            return this.f72595e.a(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h.n.f<h.n.a, k> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f72596e;

        /* loaded from: classes8.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f72597e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f72598f;

            public a(b bVar, h.n.a aVar, g.a aVar2) {
                this.f72597e = aVar;
                this.f72598f = aVar2;
            }

            @Override // h.n.a
            public void call() {
                try {
                    this.f72597e.call();
                } finally {
                    this.f72598f.unsubscribe();
                }
            }
        }

        public b(ScalarSynchronousObservable scalarSynchronousObservable, g gVar) {
            this.f72596e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public k call(h.n.a aVar) {
            g.a createWorker = this.f72596e.createWorker();
            createWorker.b(new a(this, aVar, createWorker));
            return createWorker;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a<R> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.n.f f72599e;

        public c(h.n.f fVar) {
            this.f72599e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super R> jVar) {
            h.d dVar = (h.d) this.f72599e.call(ScalarSynchronousObservable.this.f72594f);
            if (dVar instanceof ScalarSynchronousObservable) {
                jVar.setProducer(ScalarSynchronousObservable.K(jVar, ((ScalarSynchronousObservable) dVar).f72594f));
            } else {
                dVar.I(h.q.f.c(jVar));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final T f72601e;

        public d(T t) {
            this.f72601e = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            jVar.setProducer(ScalarSynchronousObservable.K(jVar, this.f72601e));
        }
    }

    /* loaded from: classes8.dex */
    public static final class e<T> implements d.a<T> {

        /* renamed from: e  reason: collision with root package name */
        public final T f72602e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<h.n.a, k> f72603f;

        public e(T t, h.n.f<h.n.a, k> fVar) {
            this.f72602e = t;
            this.f72603f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            jVar.setProducer(new ScalarAsyncProducer(jVar, this.f72602e, this.f72603f));
        }
    }

    /* loaded from: classes8.dex */
    public static final class f<T> implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f72604e;

        /* renamed from: f  reason: collision with root package name */
        public final T f72605f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f72606g;

        public f(j<? super T> jVar, T t) {
            this.f72604e = jVar;
            this.f72605f = t;
        }

        @Override // h.f
        public void request(long j) {
            if (this.f72606g) {
                return;
            }
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalStateException("n >= required but it was " + j);
            } else if (i2 == 0) {
            } else {
                this.f72606g = true;
                j<? super T> jVar = this.f72604e;
                if (jVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.f72605f;
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
        this.f72594f = t;
    }

    public static <T> ScalarSynchronousObservable<T> J(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    public static <T> h.f K(j<? super T> jVar, T t) {
        if (f72593g) {
            return new SingleProducer(jVar, t);
        }
        return new f(jVar, t);
    }

    public T L() {
        return this.f72594f;
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
        return h.d.b(new e(this.f72594f, bVar));
    }
}

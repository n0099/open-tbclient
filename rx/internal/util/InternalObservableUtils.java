package rx.internal.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.d;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new rx.functions.g<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.g
        /* renamed from: a */
        public Long h(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new rx.functions.g<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.g
        /* renamed from: i */
        public Boolean h(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    };
    public static final q TO_ARRAY = new rx.functions.f<List<? extends rx.d<?>>, rx.d<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: fb */
        public rx.d<?>[] call(List<? extends rx.d<?>> list) {
            return (rx.d[]) list.toArray(new rx.d[list.size()]);
        }
    };
    static final o RETURNS_VOID = new o();
    public static final g COUNTER = new rx.functions.g<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.g
        /* renamed from: a */
        public Integer h(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    static final e ERROR_EXTRACTOR = new e();
    public static final rx.functions.b<Throwable> ERROR_NOT_IMPLEMENTED = new rx.functions.b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final d.b<Boolean, Object> IS_EMPTY = new rx.internal.operators.h(UtilityFunctions.cPf(), true);

    public static rx.functions.f<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    /* loaded from: classes2.dex */
    static final class b implements rx.functions.f<Object, Boolean> {
        final Object other;

        public b(Object obj) {
            this.other = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.f
        public Boolean call(Object obj) {
            return Boolean.valueOf(obj == this.other || (obj != null && obj.equals(this.other)));
        }
    }

    public static rx.functions.f<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d implements rx.functions.f<Object, Boolean> {
        final Class<?> clazz;

        public d(Class<?> cls) {
            this.clazz = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.f
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.clazz.isInstance(obj));
        }
    }

    public static rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> createRepeatDematerializer(rx.functions.f<? super rx.d<? extends Void>, ? extends rx.d<?>> fVar) {
        return new i(fVar);
    }

    /* loaded from: classes2.dex */
    static final class i implements rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> {
        final rx.functions.f<? super rx.d<? extends Void>, ? extends rx.d<?>> kDn;

        public i(rx.functions.f<? super rx.d<? extends Void>, ? extends rx.d<?>> fVar) {
            this.kDn = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: c */
        public rx.d<?> call(rx.d<? extends Notification<?>> dVar) {
            return this.kDn.call(dVar.d(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class o implements rx.functions.f<Object, Void> {
        o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: bv */
        public Void call(Object obj) {
            return null;
        }
    }

    public static <T, R> rx.functions.f<rx.d<T>, rx.d<R>> createReplaySelectorAndObserveOn(rx.functions.f<? super rx.d<T>, ? extends rx.d<R>> fVar, rx.g gVar) {
        return new p(fVar, gVar);
    }

    /* loaded from: classes2.dex */
    static final class p<T, R> implements rx.functions.f<rx.d<T>, rx.d<R>> {
        final rx.functions.f<? super rx.d<T>, ? extends rx.d<R>> kDo;
        final rx.g scheduler;

        public p(rx.functions.f<? super rx.d<T>, ? extends rx.d<R>> fVar, rx.g gVar) {
            this.kDo = fVar;
            this.scheduler = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: c */
        public rx.d<R> call(rx.d<T> dVar) {
            return this.kDo.call(dVar).a(this.scheduler);
        }
    }

    public static rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> createRetryDematerializer(rx.functions.f<? super rx.d<? extends Throwable>, ? extends rx.d<?>> fVar) {
        return new n(fVar);
    }

    /* loaded from: classes2.dex */
    static final class n implements rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> {
        final rx.functions.f<? super rx.d<? extends Throwable>, ? extends rx.d<?>> kDn;

        public n(rx.functions.f<? super rx.d<? extends Throwable>, ? extends rx.d<?>> fVar) {
            this.kDn = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: c */
        public rx.d<?> call(rx.d<? extends Notification<?>> dVar) {
            return this.kDn.call(dVar.d(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class e implements rx.functions.f<Notification<?>, Throwable> {
        e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: c */
        public Throwable call(Notification<?> notification) {
            return notification.cOa();
        }
    }

    public static <T> rx.functions.e<rx.observables.a<T>> createReplaySupplier(rx.d<T> dVar) {
        return new l(dVar);
    }

    /* loaded from: classes2.dex */
    static final class l<T> implements rx.functions.e<rx.observables.a<T>> {
        private final rx.d<T> kyh;

        l(rx.d<T> dVar) {
            this.kyh = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.e, java.util.concurrent.Callable
        /* renamed from: cOU */
        public rx.observables.a<T> call() {
            return this.kyh.cOj();
        }
    }

    public static <T> rx.functions.e<rx.observables.a<T>> createReplaySupplier(rx.d<T> dVar, int i2) {
        return new j(dVar, i2);
    }

    /* loaded from: classes2.dex */
    static final class j<T> implements rx.functions.e<rx.observables.a<T>> {
        private final int bufferSize;
        private final rx.d<T> kyh;

        j(rx.d<T> dVar, int i) {
            this.kyh = dVar;
            this.bufferSize = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.e, java.util.concurrent.Callable
        /* renamed from: cOU */
        public rx.observables.a<T> call() {
            return this.kyh.Ds(this.bufferSize);
        }
    }

    public static <T> rx.functions.e<rx.observables.a<T>> createReplaySupplier(rx.d<T> dVar, long j2, TimeUnit timeUnit, rx.g gVar) {
        return new k(dVar, j2, timeUnit, gVar);
    }

    /* loaded from: classes2.dex */
    static final class k<T> implements rx.functions.e<rx.observables.a<T>> {
        private final rx.d<T> kyh;
        private final rx.g scheduler;
        private final long time;
        private final TimeUnit unit;

        k(rx.d<T> dVar, long j, TimeUnit timeUnit, rx.g gVar) {
            this.unit = timeUnit;
            this.kyh = dVar;
            this.time = j;
            this.scheduler = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.e, java.util.concurrent.Callable
        /* renamed from: cOU */
        public rx.observables.a<T> call() {
            return this.kyh.a(this.time, this.unit, this.scheduler);
        }
    }

    public static <T> rx.functions.e<rx.observables.a<T>> createReplaySupplier(rx.d<T> dVar, int i2, long j2, TimeUnit timeUnit, rx.g gVar) {
        return new m(dVar, i2, j2, timeUnit, gVar);
    }

    /* loaded from: classes2.dex */
    static final class m<T> implements rx.functions.e<rx.observables.a<T>> {
        private final int bufferSize;
        private final rx.d<T> kyh;
        private final rx.g scheduler;
        private final long time;
        private final TimeUnit unit;

        m(rx.d<T> dVar, int i, long j, TimeUnit timeUnit, rx.g gVar) {
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = gVar;
            this.bufferSize = i;
            this.kyh = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.e, java.util.concurrent.Callable
        /* renamed from: cOU */
        public rx.observables.a<T> call() {
            return this.kyh.a(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    public static <T, R> rx.functions.g<R, T, R> createCollectorCaller(rx.functions.c<R, ? super T> cVar) {
        return new a(cVar);
    }

    /* loaded from: classes2.dex */
    static final class a<T, R> implements rx.functions.g<R, T, R> {
        final rx.functions.c<R, ? super T> kDm;

        public a(rx.functions.c<R, ? super T> cVar) {
            this.kDm = cVar;
        }

        @Override // rx.functions.g
        public R h(R r, T t) {
            this.kDm.g(r, t);
            return r;
        }
    }
}

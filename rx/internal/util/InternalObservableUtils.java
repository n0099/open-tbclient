package rx.internal.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.d;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.ad;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new h();
    public static final f OBJECT_EQUALS = new f();
    public static final q TO_ARRAY = new q();
    static final o RETURNS_VOID = new o();
    public static final g COUNTER = new g();
    static final e ERROR_EXTRACTOR = new e();
    public static final rx.functions.b<Throwable> ERROR_NOT_IMPLEMENTED = new rx.functions.b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final d.b<Boolean, Object> IS_EMPTY = new ad(UtilityFunctions.ccV(), true);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class g implements rx.functions.g<Integer, Object, Integer> {
        g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.g
        /* renamed from: a */
        public Integer j(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class h implements rx.functions.g<Long, Object, Long> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.g
        /* renamed from: a */
        public Long j(Long l, Object obj) {
            return Long.valueOf(l.longValue() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class f implements rx.functions.g<Object, Object, Boolean> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.g
        /* renamed from: k */
        public Boolean j(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class q implements rx.functions.f<List<? extends rx.d<?>>, rx.d<?>[]> {
        q() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: eC */
        public rx.d<?>[] call(List<? extends rx.d<?>> list) {
            return (rx.d[]) list.toArray(new rx.d[list.size()]);
        }
    }

    public static rx.functions.f<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b implements rx.functions.f<Object, Boolean> {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class i implements rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> {
        final rx.functions.f<? super rx.d<? extends Void>, ? extends rx.d<?>> iCX;

        public i(rx.functions.f<? super rx.d<? extends Void>, ? extends rx.d<?>> fVar) {
            this.iCX = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: f */
        public rx.d<?> call(rx.d<? extends Notification<?>> dVar) {
            return this.iCX.call(dVar.map(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class o implements rx.functions.f<Object, Void> {
        o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: bo */
        public Void call(Object obj) {
            return null;
        }
    }

    public static <T, R> rx.functions.f<rx.d<T>, rx.d<R>> createReplaySelectorAndObserveOn(rx.functions.f<? super rx.d<T>, ? extends rx.d<R>> fVar, rx.g gVar) {
        return new p(fVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class p<T, R> implements rx.functions.f<rx.d<T>, rx.d<R>> {
        final rx.functions.f<? super rx.d<T>, ? extends rx.d<R>> ivK;
        final rx.g scheduler;

        public p(rx.functions.f<? super rx.d<T>, ? extends rx.d<R>> fVar, rx.g gVar) {
            this.ivK = fVar;
            this.scheduler = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: f */
        public rx.d<R> call(rx.d<T> dVar) {
            return this.ivK.call(dVar).observeOn(this.scheduler);
        }
    }

    public static rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> createRetryDematerializer(rx.functions.f<? super rx.d<? extends Throwable>, ? extends rx.d<?>> fVar) {
        return new n(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class n implements rx.functions.f<rx.d<? extends Notification<?>>, rx.d<?>> {
        final rx.functions.f<? super rx.d<? extends Throwable>, ? extends rx.d<?>> iCX;

        public n(rx.functions.f<? super rx.d<? extends Throwable>, ? extends rx.d<?>> fVar) {
            this.iCX = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.f
        /* renamed from: f */
        public rx.d<?> call(rx.d<? extends Notification<?>> dVar) {
            return this.iCX.call(dVar.map(InternalObservableUtils.ERROR_EXTRACTOR));
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
            return notification.cbn();
        }
    }

    public static <T> rx.functions.e<rx.observables.c<T>> createReplaySupplier(rx.d<T> dVar) {
        return new l(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class l<T> implements rx.functions.e<rx.observables.c<T>> {
        private final rx.d<T> isM;

        l(rx.d<T> dVar) {
            this.isM = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.e, java.util.concurrent.Callable
        /* renamed from: ccL */
        public rx.observables.c<T> call() {
            return this.isM.replay();
        }
    }

    public static <T> rx.functions.e<rx.observables.c<T>> createReplaySupplier(rx.d<T> dVar, int i2) {
        return new j(dVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class j<T> implements rx.functions.e<rx.observables.c<T>> {
        private final int bufferSize;
        private final rx.d<T> isM;

        j(rx.d<T> dVar, int i) {
            this.isM = dVar;
            this.bufferSize = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.e, java.util.concurrent.Callable
        /* renamed from: ccL */
        public rx.observables.c<T> call() {
            return this.isM.replay(this.bufferSize);
        }
    }

    public static <T> rx.functions.e<rx.observables.c<T>> createReplaySupplier(rx.d<T> dVar, long j2, TimeUnit timeUnit, rx.g gVar) {
        return new k(dVar, j2, timeUnit, gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class k<T> implements rx.functions.e<rx.observables.c<T>> {
        private final rx.d<T> isM;
        private final rx.g scheduler;
        private final long time;
        private final TimeUnit unit;

        k(rx.d<T> dVar, long j, TimeUnit timeUnit, rx.g gVar) {
            this.unit = timeUnit;
            this.isM = dVar;
            this.time = j;
            this.scheduler = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.e, java.util.concurrent.Callable
        /* renamed from: ccL */
        public rx.observables.c<T> call() {
            return this.isM.replay(this.time, this.unit, this.scheduler);
        }
    }

    public static <T> rx.functions.e<rx.observables.c<T>> createReplaySupplier(rx.d<T> dVar, int i2, long j2, TimeUnit timeUnit, rx.g gVar) {
        return new m(dVar, i2, j2, timeUnit, gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class m<T> implements rx.functions.e<rx.observables.c<T>> {
        private final int bufferSize;
        private final rx.d<T> isM;
        private final rx.g scheduler;
        private final long time;
        private final TimeUnit unit;

        m(rx.d<T> dVar, int i, long j, TimeUnit timeUnit, rx.g gVar) {
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = gVar;
            this.bufferSize = i;
            this.isM = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.functions.e, java.util.concurrent.Callable
        /* renamed from: ccL */
        public rx.observables.c<T> call() {
            return this.isM.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    public static <T, R> rx.functions.g<R, T, R> createCollectorCaller(rx.functions.c<R, ? super T> cVar) {
        return new a(cVar);
    }

    /* loaded from: classes2.dex */
    static final class a<T, R> implements rx.functions.g<R, T, R> {
        final rx.functions.c<R, ? super T> iti;

        public a(rx.functions.c<R, ? super T> cVar) {
            this.iti = cVar;
        }

        @Override // rx.functions.g
        public R j(R r, T t) {
            this.iti.i(r, t);
            return r;
        }
    }
}

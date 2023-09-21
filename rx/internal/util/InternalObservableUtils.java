package rx.internal.util;

import com.baidu.tieba.cdc;
import com.baidu.tieba.ddc;
import com.baidu.tieba.edc;
import com.baidu.tieba.kcc;
import com.baidu.tieba.ncc;
import com.baidu.tieba.pgc;
import com.baidu.tieba.qdc;
import com.baidu.tieba.ycc;
import com.baidu.tieba.zcc;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new edc<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.edc
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new edc<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.edc
        public Boolean call(Object obj, Object obj2) {
            boolean z;
            if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    };
    public static final q TO_ARRAY = new ddc<List<? extends kcc<?>>, kcc<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ddc
        public kcc<?>[] call(List<? extends kcc<?>> list) {
            return (kcc[]) list.toArray(new kcc[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new edc<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.edc
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final ycc<Throwable> ERROR_NOT_IMPLEMENTED = new ycc<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ycc
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final kcc.b<Boolean, Object> IS_EMPTY = new qdc(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements ddc<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ddc
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements edc<R, T, R> {
        public final zcc<R, ? super T> a;

        public a(zcc<R, ? super T> zccVar) {
            this.a = zccVar;
        }

        @Override // com.baidu.tieba.edc
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements ddc<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ddc
        public Boolean call(Object obj) {
            boolean z;
            Object obj2 = this.a;
            if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements ddc<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ddc
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements ddc<kcc<? extends Notification<?>>, kcc<?>> {
        public final ddc<? super kcc<? extends Void>, ? extends kcc<?>> a;

        public i(ddc<? super kcc<? extends Void>, ? extends kcc<?>> ddcVar) {
            this.a = ddcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ddc
        public kcc<?> call(kcc<? extends Notification<?>> kccVar) {
            return this.a.call(kccVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements cdc<pgc<T>> {
        public final kcc<T> a;
        public final int b;

        public j(kcc<T> kccVar, int i) {
            this.a = kccVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cdc
        public pgc<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements cdc<pgc<T>> {
        public final TimeUnit a;
        public final kcc<T> b;
        public final long c;
        public final ncc d;

        public k(kcc<T> kccVar, long j, TimeUnit timeUnit, ncc nccVar) {
            this.a = timeUnit;
            this.b = kccVar;
            this.c = j;
            this.d = nccVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cdc
        public pgc<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements cdc<pgc<T>> {
        public final kcc<T> a;

        public l(kcc<T> kccVar) {
            this.a = kccVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cdc
        public pgc<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements cdc<pgc<T>> {
        public final long a;
        public final TimeUnit b;
        public final ncc c;
        public final int d;
        public final kcc<T> e;

        public m(kcc<T> kccVar, int i, long j, TimeUnit timeUnit, ncc nccVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = nccVar;
            this.d = i;
            this.e = kccVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cdc
        public pgc<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements ddc<kcc<? extends Notification<?>>, kcc<?>> {
        public final ddc<? super kcc<? extends Throwable>, ? extends kcc<?>> a;

        public n(ddc<? super kcc<? extends Throwable>, ? extends kcc<?>> ddcVar) {
            this.a = ddcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ddc
        public kcc<?> call(kcc<? extends Notification<?>> kccVar) {
            return this.a.call(kccVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements ddc<kcc<T>, kcc<R>> {
        public final ddc<? super kcc<T>, ? extends kcc<R>> a;
        public final ncc b;

        public p(ddc<? super kcc<T>, ? extends kcc<R>> ddcVar, ncc nccVar) {
            this.a = ddcVar;
            this.b = nccVar;
        }

        public kcc<R> call(kcc<T> kccVar) {
            return this.a.call(kccVar).s(this.b);
        }

        @Override // com.baidu.tieba.ddc
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((kcc) ((kcc) obj));
        }
    }

    public static <T, R> ddc<kcc<T>, kcc<R>> createReplaySelectorAndObserveOn(ddc<? super kcc<T>, ? extends kcc<R>> ddcVar, ncc nccVar) {
        return new p(ddcVar, nccVar);
    }

    public static <T> cdc<pgc<T>> createReplaySupplier(kcc<T> kccVar, int i2) {
        return new j(kccVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements ddc<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ddc
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> edc<R, T, R> createCollectorCaller(zcc<R, ? super T> zccVar) {
        return new a(zccVar);
    }

    public static ddc<kcc<? extends Notification<?>>, kcc<?>> createRepeatDematerializer(ddc<? super kcc<? extends Void>, ? extends kcc<?>> ddcVar) {
        return new i(ddcVar);
    }

    public static <T> cdc<pgc<T>> createReplaySupplier(kcc<T> kccVar) {
        return new l(kccVar);
    }

    public static ddc<kcc<? extends Notification<?>>, kcc<?>> createRetryDematerializer(ddc<? super kcc<? extends Throwable>, ? extends kcc<?>> ddcVar) {
        return new n(ddcVar);
    }

    public static ddc<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static ddc<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> cdc<pgc<T>> createReplaySupplier(kcc<T> kccVar, int i2, long j2, TimeUnit timeUnit, ncc nccVar) {
        return new m(kccVar, i2, j2, timeUnit, nccVar);
    }

    public static <T> cdc<pgc<T>> createReplaySupplier(kcc<T> kccVar, long j2, TimeUnit timeUnit, ncc nccVar) {
        return new k(kccVar, j2, timeUnit, nccVar);
    }
}

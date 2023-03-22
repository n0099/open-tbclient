package rx.internal.util;

import com.baidu.tieba.csa;
import com.baidu.tieba.dsa;
import com.baidu.tieba.fsa;
import com.baidu.tieba.gsa;
import com.baidu.tieba.hsa;
import com.baidu.tieba.mva;
import com.baidu.tieba.ora;
import com.baidu.tieba.rra;
import com.baidu.tieba.rsa;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new hsa<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hsa
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new hsa<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.hsa
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
    public static final q TO_ARRAY = new gsa<List<? extends ora<?>>, ora<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gsa
        public ora<?>[] call(List<? extends ora<?>> list) {
            return (ora[]) list.toArray(new ora[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new hsa<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hsa
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final csa<Throwable> ERROR_NOT_IMPLEMENTED = new csa<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.csa
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final ora.b<Boolean, Object> IS_EMPTY = new rsa(UtilityFunctions.a(), true);

    /* loaded from: classes9.dex */
    public static final class o implements gsa<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gsa
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T, R> implements hsa<R, T, R> {
        public final dsa<R, ? super T> a;

        public a(dsa<R, ? super T> dsaVar) {
            this.a = dsaVar;
        }

        @Override // com.baidu.tieba.hsa
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements gsa<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.gsa
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

    /* loaded from: classes9.dex */
    public static final class d implements gsa<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.gsa
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class i implements gsa<ora<? extends Notification<?>>, ora<?>> {
        public final gsa<? super ora<? extends Void>, ? extends ora<?>> a;

        public i(gsa<? super ora<? extends Void>, ? extends ora<?>> gsaVar) {
            this.a = gsaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gsa
        public ora<?> call(ora<? extends Notification<?>> oraVar) {
            return this.a.call(oraVar.h(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes9.dex */
    public static final class j<T> implements fsa<mva<T>> {
        public final ora<T> a;
        public final int b;

        public j(ora<T> oraVar, int i) {
            this.a = oraVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fsa
        public mva<T> call() {
            return this.a.p(this.b);
        }
    }

    /* loaded from: classes9.dex */
    public static final class k<T> implements fsa<mva<T>> {
        public final TimeUnit a;
        public final ora<T> b;
        public final long c;
        public final rra d;

        public k(ora<T> oraVar, long j, TimeUnit timeUnit, rra rraVar) {
            this.a = timeUnit;
            this.b = oraVar;
            this.c = j;
            this.d = rraVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fsa
        public mva<T> call() {
            return this.b.r(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes9.dex */
    public static final class l<T> implements fsa<mva<T>> {
        public final ora<T> a;

        public l(ora<T> oraVar) {
            this.a = oraVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fsa
        public mva<T> call() {
            return this.a.o();
        }
    }

    /* loaded from: classes9.dex */
    public static final class m<T> implements fsa<mva<T>> {
        public final long a;
        public final TimeUnit b;
        public final rra c;
        public final int d;
        public final ora<T> e;

        public m(ora<T> oraVar, int i, long j, TimeUnit timeUnit, rra rraVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = rraVar;
            this.d = i;
            this.e = oraVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fsa
        public mva<T> call() {
            return this.e.q(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes9.dex */
    public static final class n implements gsa<ora<? extends Notification<?>>, ora<?>> {
        public final gsa<? super ora<? extends Throwable>, ? extends ora<?>> a;

        public n(gsa<? super ora<? extends Throwable>, ? extends ora<?>> gsaVar) {
            this.a = gsaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gsa
        public ora<?> call(ora<? extends Notification<?>> oraVar) {
            return this.a.call(oraVar.h(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes9.dex */
    public static final class p<T, R> implements gsa<ora<T>, ora<R>> {
        public final gsa<? super ora<T>, ? extends ora<R>> a;
        public final rra b;

        public p(gsa<? super ora<T>, ? extends ora<R>> gsaVar, rra rraVar) {
            this.a = gsaVar;
            this.b = rraVar;
        }

        public ora<R> call(ora<T> oraVar) {
            return this.a.call(oraVar).k(this.b);
        }

        @Override // com.baidu.tieba.gsa
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((ora) ((ora) obj));
        }
    }

    public static <T, R> gsa<ora<T>, ora<R>> createReplaySelectorAndObserveOn(gsa<? super ora<T>, ? extends ora<R>> gsaVar, rra rraVar) {
        return new p(gsaVar, rraVar);
    }

    public static <T> fsa<mva<T>> createReplaySupplier(ora<T> oraVar, int i2) {
        return new j(oraVar, i2);
    }

    /* loaded from: classes9.dex */
    public static final class e implements gsa<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gsa
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> hsa<R, T, R> createCollectorCaller(dsa<R, ? super T> dsaVar) {
        return new a(dsaVar);
    }

    public static gsa<ora<? extends Notification<?>>, ora<?>> createRepeatDematerializer(gsa<? super ora<? extends Void>, ? extends ora<?>> gsaVar) {
        return new i(gsaVar);
    }

    public static <T> fsa<mva<T>> createReplaySupplier(ora<T> oraVar) {
        return new l(oraVar);
    }

    public static gsa<ora<? extends Notification<?>>, ora<?>> createRetryDematerializer(gsa<? super ora<? extends Throwable>, ? extends ora<?>> gsaVar) {
        return new n(gsaVar);
    }

    public static gsa<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static gsa<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> fsa<mva<T>> createReplaySupplier(ora<T> oraVar, int i2, long j2, TimeUnit timeUnit, rra rraVar) {
        return new m(oraVar, i2, j2, timeUnit, rraVar);
    }

    public static <T> fsa<mva<T>> createReplaySupplier(ora<T> oraVar, long j2, TimeUnit timeUnit, rra rraVar) {
        return new k(oraVar, j2, timeUnit, rraVar);
    }
}

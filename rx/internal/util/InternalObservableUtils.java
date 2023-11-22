package rx.internal.util;

import com.baidu.tieba.bkc;
import com.baidu.tieba.ckc;
import com.baidu.tieba.dkc;
import com.baidu.tieba.jjc;
import com.baidu.tieba.mjc;
import com.baidu.tieba.qnc;
import com.baidu.tieba.rkc;
import com.baidu.tieba.xjc;
import com.baidu.tieba.yjc;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new dkc<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dkc
        /* renamed from: b */
        public Long a(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new dkc<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dkc
        /* renamed from: b */
        public Boolean a(Object obj, Object obj2) {
            boolean z;
            if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    };
    public static final q TO_ARRAY = new ckc<List<? extends jjc<?>>, jjc<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public jjc<?>[] call(List<? extends jjc<?>> list) {
            return (jjc[]) list.toArray(new jjc[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new dkc<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dkc
        /* renamed from: b */
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final xjc<Throwable> ERROR_NOT_IMPLEMENTED = new xjc<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        public void a(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.xjc
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            a(th);
            throw null;
        }
    };
    public static final jjc.b<Boolean, Object> IS_EMPTY = new rkc(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements ckc<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements dkc<R, T, R> {
        public final yjc<R, ? super T> a;

        public a(yjc<R, ? super T> yjcVar) {
            this.a = yjcVar;
        }

        @Override // com.baidu.tieba.dkc
        public R a(R r, T t) {
            this.a.a(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements ckc<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
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
    public static final class d implements ckc<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements ckc<jjc<? extends Notification<?>>, jjc<?>> {
        public final ckc<? super jjc<? extends Void>, ? extends jjc<?>> a;

        public i(ckc<? super jjc<? extends Void>, ? extends jjc<?>> ckcVar) {
            this.a = ckcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public jjc<?> call(jjc<? extends Notification<?>> jjcVar) {
            return this.a.call(jjcVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements bkc<qnc<T>> {
        public final jjc<T> a;
        public final int b;

        public j(jjc<T> jjcVar, int i) {
            this.a = jjcVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public qnc<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements bkc<qnc<T>> {
        public final TimeUnit a;
        public final jjc<T> b;
        public final long c;
        public final mjc d;

        public k(jjc<T> jjcVar, long j, TimeUnit timeUnit, mjc mjcVar) {
            this.a = timeUnit;
            this.b = jjcVar;
            this.c = j;
            this.d = mjcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public qnc<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements bkc<qnc<T>> {
        public final jjc<T> a;

        public l(jjc<T> jjcVar) {
            this.a = jjcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public qnc<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements bkc<qnc<T>> {
        public final long a;
        public final TimeUnit b;
        public final mjc c;
        public final int d;
        public final jjc<T> e;

        public m(jjc<T> jjcVar, int i, long j, TimeUnit timeUnit, mjc mjcVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = mjcVar;
            this.d = i;
            this.e = jjcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public qnc<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements ckc<jjc<? extends Notification<?>>, jjc<?>> {
        public final ckc<? super jjc<? extends Throwable>, ? extends jjc<?>> a;

        public n(ckc<? super jjc<? extends Throwable>, ? extends jjc<?>> ckcVar) {
            this.a = ckcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public jjc<?> call(jjc<? extends Notification<?>> jjcVar) {
            return this.a.call(jjcVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements ckc<jjc<T>, jjc<R>> {
        public final ckc<? super jjc<T>, ? extends jjc<R>> a;
        public final mjc b;

        public p(ckc<? super jjc<T>, ? extends jjc<R>> ckcVar, mjc mjcVar) {
            this.a = ckcVar;
            this.b = mjcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public jjc<R> call(jjc<T> jjcVar) {
            return this.a.call(jjcVar).s(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements ckc<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: a */
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> ckc<jjc<T>, jjc<R>> createReplaySelectorAndObserveOn(ckc<? super jjc<T>, ? extends jjc<R>> ckcVar, mjc mjcVar) {
        return new p(ckcVar, mjcVar);
    }

    public static <T> bkc<qnc<T>> createReplaySupplier(jjc<T> jjcVar, int i2) {
        return new j(jjcVar, i2);
    }

    public static <T, R> dkc<R, T, R> createCollectorCaller(yjc<R, ? super T> yjcVar) {
        return new a(yjcVar);
    }

    public static ckc<jjc<? extends Notification<?>>, jjc<?>> createRepeatDematerializer(ckc<? super jjc<? extends Void>, ? extends jjc<?>> ckcVar) {
        return new i(ckcVar);
    }

    public static <T> bkc<qnc<T>> createReplaySupplier(jjc<T> jjcVar) {
        return new l(jjcVar);
    }

    public static ckc<jjc<? extends Notification<?>>, jjc<?>> createRetryDematerializer(ckc<? super jjc<? extends Throwable>, ? extends jjc<?>> ckcVar) {
        return new n(ckcVar);
    }

    public static ckc<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static ckc<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> bkc<qnc<T>> createReplaySupplier(jjc<T> jjcVar, int i2, long j2, TimeUnit timeUnit, mjc mjcVar) {
        return new m(jjcVar, i2, j2, timeUnit, mjcVar);
    }

    public static <T> bkc<qnc<T>> createReplaySupplier(jjc<T> jjcVar, long j2, TimeUnit timeUnit, mjc mjcVar) {
        return new k(jjcVar, j2, timeUnit, mjcVar);
    }
}

package rx.internal.util;

import com.baidu.tieba.i2c;
import com.baidu.tieba.j2c;
import com.baidu.tieba.l2c;
import com.baidu.tieba.m2c;
import com.baidu.tieba.n2c;
import com.baidu.tieba.u1c;
import com.baidu.tieba.x1c;
import com.baidu.tieba.y5c;
import com.baidu.tieba.z2c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new n2c<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n2c
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new n2c<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.n2c
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
    public static final q TO_ARRAY = new m2c<List<? extends u1c<?>>, u1c<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m2c
        public u1c<?>[] call(List<? extends u1c<?>> list) {
            return (u1c[]) list.toArray(new u1c[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new n2c<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n2c
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final i2c<Throwable> ERROR_NOT_IMPLEMENTED = new i2c<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i2c
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final u1c.b<Boolean, Object> IS_EMPTY = new z2c(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements m2c<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m2c
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements n2c<R, T, R> {
        public final j2c<R, ? super T> a;

        public a(j2c<R, ? super T> j2cVar) {
            this.a = j2cVar;
        }

        @Override // com.baidu.tieba.n2c
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements m2c<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.m2c
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
    public static final class d implements m2c<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.m2c
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements m2c<u1c<? extends Notification<?>>, u1c<?>> {
        public final m2c<? super u1c<? extends Void>, ? extends u1c<?>> a;

        public i(m2c<? super u1c<? extends Void>, ? extends u1c<?>> m2cVar) {
            this.a = m2cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m2c
        public u1c<?> call(u1c<? extends Notification<?>> u1cVar) {
            return this.a.call(u1cVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements l2c<y5c<T>> {
        public final u1c<T> a;
        public final int b;

        public j(u1c<T> u1cVar, int i) {
            this.a = u1cVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l2c
        public y5c<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements l2c<y5c<T>> {
        public final TimeUnit a;
        public final u1c<T> b;
        public final long c;
        public final x1c d;

        public k(u1c<T> u1cVar, long j, TimeUnit timeUnit, x1c x1cVar) {
            this.a = timeUnit;
            this.b = u1cVar;
            this.c = j;
            this.d = x1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l2c
        public y5c<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements l2c<y5c<T>> {
        public final u1c<T> a;

        public l(u1c<T> u1cVar) {
            this.a = u1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l2c
        public y5c<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements l2c<y5c<T>> {
        public final long a;
        public final TimeUnit b;
        public final x1c c;
        public final int d;
        public final u1c<T> e;

        public m(u1c<T> u1cVar, int i, long j, TimeUnit timeUnit, x1c x1cVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = x1cVar;
            this.d = i;
            this.e = u1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l2c
        public y5c<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements m2c<u1c<? extends Notification<?>>, u1c<?>> {
        public final m2c<? super u1c<? extends Throwable>, ? extends u1c<?>> a;

        public n(m2c<? super u1c<? extends Throwable>, ? extends u1c<?>> m2cVar) {
            this.a = m2cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m2c
        public u1c<?> call(u1c<? extends Notification<?>> u1cVar) {
            return this.a.call(u1cVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements m2c<u1c<T>, u1c<R>> {
        public final m2c<? super u1c<T>, ? extends u1c<R>> a;
        public final x1c b;

        public p(m2c<? super u1c<T>, ? extends u1c<R>> m2cVar, x1c x1cVar) {
            this.a = m2cVar;
            this.b = x1cVar;
        }

        public u1c<R> call(u1c<T> u1cVar) {
            return this.a.call(u1cVar).s(this.b);
        }

        @Override // com.baidu.tieba.m2c
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((u1c) ((u1c) obj));
        }
    }

    public static <T, R> m2c<u1c<T>, u1c<R>> createReplaySelectorAndObserveOn(m2c<? super u1c<T>, ? extends u1c<R>> m2cVar, x1c x1cVar) {
        return new p(m2cVar, x1cVar);
    }

    public static <T> l2c<y5c<T>> createReplaySupplier(u1c<T> u1cVar, int i2) {
        return new j(u1cVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements m2c<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m2c
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> n2c<R, T, R> createCollectorCaller(j2c<R, ? super T> j2cVar) {
        return new a(j2cVar);
    }

    public static m2c<u1c<? extends Notification<?>>, u1c<?>> createRepeatDematerializer(m2c<? super u1c<? extends Void>, ? extends u1c<?>> m2cVar) {
        return new i(m2cVar);
    }

    public static <T> l2c<y5c<T>> createReplaySupplier(u1c<T> u1cVar) {
        return new l(u1cVar);
    }

    public static m2c<u1c<? extends Notification<?>>, u1c<?>> createRetryDematerializer(m2c<? super u1c<? extends Throwable>, ? extends u1c<?>> m2cVar) {
        return new n(m2cVar);
    }

    public static m2c<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static m2c<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> l2c<y5c<T>> createReplaySupplier(u1c<T> u1cVar, int i2, long j2, TimeUnit timeUnit, x1c x1cVar) {
        return new m(u1cVar, i2, j2, timeUnit, x1cVar);
    }

    public static <T> l2c<y5c<T>> createReplaySupplier(u1c<T> u1cVar, long j2, TimeUnit timeUnit, x1c x1cVar) {
        return new k(u1cVar, j2, timeUnit, x1cVar);
    }
}

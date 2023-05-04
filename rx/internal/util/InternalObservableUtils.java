package rx.internal.util;

import com.baidu.tieba.a6b;
import com.baidu.tieba.b6b;
import com.baidu.tieba.c6b;
import com.baidu.tieba.j5b;
import com.baidu.tieba.j9b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.n6b;
import com.baidu.tieba.x5b;
import com.baidu.tieba.y5b;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new c6b<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c6b
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new c6b<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.c6b
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
    public static final q TO_ARRAY = new b6b<List<? extends j5b<?>>, j5b<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b6b
        public j5b<?>[] call(List<? extends j5b<?>> list) {
            return (j5b[]) list.toArray(new j5b[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new c6b<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c6b
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final x5b<Throwable> ERROR_NOT_IMPLEMENTED = new x5b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x5b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final j5b.b<Boolean, Object> IS_EMPTY = new n6b(UtilityFunctions.a(), true);

    /* loaded from: classes9.dex */
    public static final class o implements b6b<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b6b
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T, R> implements c6b<R, T, R> {
        public final y5b<R, ? super T> a;

        public a(y5b<R, ? super T> y5bVar) {
            this.a = y5bVar;
        }

        @Override // com.baidu.tieba.c6b
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements b6b<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.b6b
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
    public static final class d implements b6b<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.b6b
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class i implements b6b<j5b<? extends Notification<?>>, j5b<?>> {
        public final b6b<? super j5b<? extends Void>, ? extends j5b<?>> a;

        public i(b6b<? super j5b<? extends Void>, ? extends j5b<?>> b6bVar) {
            this.a = b6bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b6b
        public j5b<?> call(j5b<? extends Notification<?>> j5bVar) {
            return this.a.call(j5bVar.j(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes9.dex */
    public static final class j<T> implements a6b<j9b<T>> {
        public final j5b<T> a;
        public final int b;

        public j(j5b<T> j5bVar, int i) {
            this.a = j5bVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a6b
        public j9b<T> call() {
            return this.a.r(this.b);
        }
    }

    /* loaded from: classes9.dex */
    public static final class k<T> implements a6b<j9b<T>> {
        public final TimeUnit a;
        public final j5b<T> b;
        public final long c;
        public final m5b d;

        public k(j5b<T> j5bVar, long j, TimeUnit timeUnit, m5b m5bVar) {
            this.a = timeUnit;
            this.b = j5bVar;
            this.c = j;
            this.d = m5bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a6b
        public j9b<T> call() {
            return this.b.t(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes9.dex */
    public static final class l<T> implements a6b<j9b<T>> {
        public final j5b<T> a;

        public l(j5b<T> j5bVar) {
            this.a = j5bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a6b
        public j9b<T> call() {
            return this.a.q();
        }
    }

    /* loaded from: classes9.dex */
    public static final class m<T> implements a6b<j9b<T>> {
        public final long a;
        public final TimeUnit b;
        public final m5b c;
        public final int d;
        public final j5b<T> e;

        public m(j5b<T> j5bVar, int i, long j, TimeUnit timeUnit, m5b m5bVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = m5bVar;
            this.d = i;
            this.e = j5bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a6b
        public j9b<T> call() {
            return this.e.s(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes9.dex */
    public static final class n implements b6b<j5b<? extends Notification<?>>, j5b<?>> {
        public final b6b<? super j5b<? extends Throwable>, ? extends j5b<?>> a;

        public n(b6b<? super j5b<? extends Throwable>, ? extends j5b<?>> b6bVar) {
            this.a = b6bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b6b
        public j5b<?> call(j5b<? extends Notification<?>> j5bVar) {
            return this.a.call(j5bVar.j(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes9.dex */
    public static final class p<T, R> implements b6b<j5b<T>, j5b<R>> {
        public final b6b<? super j5b<T>, ? extends j5b<R>> a;
        public final m5b b;

        public p(b6b<? super j5b<T>, ? extends j5b<R>> b6bVar, m5b m5bVar) {
            this.a = b6bVar;
            this.b = m5bVar;
        }

        public j5b<R> call(j5b<T> j5bVar) {
            return this.a.call(j5bVar).m(this.b);
        }

        @Override // com.baidu.tieba.b6b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((j5b) ((j5b) obj));
        }
    }

    public static <T, R> b6b<j5b<T>, j5b<R>> createReplaySelectorAndObserveOn(b6b<? super j5b<T>, ? extends j5b<R>> b6bVar, m5b m5bVar) {
        return new p(b6bVar, m5bVar);
    }

    public static <T> a6b<j9b<T>> createReplaySupplier(j5b<T> j5bVar, int i2) {
        return new j(j5bVar, i2);
    }

    /* loaded from: classes9.dex */
    public static final class e implements b6b<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b6b
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> c6b<R, T, R> createCollectorCaller(y5b<R, ? super T> y5bVar) {
        return new a(y5bVar);
    }

    public static b6b<j5b<? extends Notification<?>>, j5b<?>> createRepeatDematerializer(b6b<? super j5b<? extends Void>, ? extends j5b<?>> b6bVar) {
        return new i(b6bVar);
    }

    public static <T> a6b<j9b<T>> createReplaySupplier(j5b<T> j5bVar) {
        return new l(j5bVar);
    }

    public static b6b<j5b<? extends Notification<?>>, j5b<?>> createRetryDematerializer(b6b<? super j5b<? extends Throwable>, ? extends j5b<?>> b6bVar) {
        return new n(b6bVar);
    }

    public static b6b<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static b6b<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> a6b<j9b<T>> createReplaySupplier(j5b<T> j5bVar, int i2, long j2, TimeUnit timeUnit, m5b m5bVar) {
        return new m(j5bVar, i2, j2, timeUnit, m5bVar);
    }

    public static <T> a6b<j9b<T>> createReplaySupplier(j5b<T> j5bVar, long j2, TimeUnit timeUnit, m5b m5bVar) {
        return new k(j5bVar, j2, timeUnit, m5bVar);
    }
}

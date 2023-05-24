package rx.internal.util;

import com.baidu.tieba.a8b;
import com.baidu.tieba.b8b;
import com.baidu.tieba.i7b;
import com.baidu.tieba.jbb;
import com.baidu.tieba.l7b;
import com.baidu.tieba.n8b;
import com.baidu.tieba.w7b;
import com.baidu.tieba.x7b;
import com.baidu.tieba.z7b;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes10.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new b8b<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b8b
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new b8b<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.b8b
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
    public static final q TO_ARRAY = new a8b<List<? extends i7b<?>>, i7b<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public i7b<?>[] call(List<? extends i7b<?>> list) {
            return (i7b[]) list.toArray(new i7b[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new b8b<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b8b
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final w7b<Throwable> ERROR_NOT_IMPLEMENTED = new w7b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w7b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final i7b.b<Boolean, Object> IS_EMPTY = new n8b(UtilityFunctions.a(), true);

    /* loaded from: classes10.dex */
    public static final class o implements a8b<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes10.dex */
    public static final class a<T, R> implements b8b<R, T, R> {
        public final x7b<R, ? super T> a;

        public a(x7b<R, ? super T> x7bVar) {
            this.a = x7bVar;
        }

        @Override // com.baidu.tieba.b8b
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes10.dex */
    public static final class b implements a8b<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.a8b
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

    /* loaded from: classes10.dex */
    public static final class d implements a8b<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.a8b
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes10.dex */
    public static final class i implements a8b<i7b<? extends Notification<?>>, i7b<?>> {
        public final a8b<? super i7b<? extends Void>, ? extends i7b<?>> a;

        public i(a8b<? super i7b<? extends Void>, ? extends i7b<?>> a8bVar) {
            this.a = a8bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public i7b<?> call(i7b<? extends Notification<?>> i7bVar) {
            return this.a.call(i7bVar.j(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes10.dex */
    public static final class j<T> implements z7b<jbb<T>> {
        public final i7b<T> a;
        public final int b;

        public j(i7b<T> i7bVar, int i) {
            this.a = i7bVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public jbb<T> call() {
            return this.a.r(this.b);
        }
    }

    /* loaded from: classes10.dex */
    public static final class k<T> implements z7b<jbb<T>> {
        public final TimeUnit a;
        public final i7b<T> b;
        public final long c;
        public final l7b d;

        public k(i7b<T> i7bVar, long j, TimeUnit timeUnit, l7b l7bVar) {
            this.a = timeUnit;
            this.b = i7bVar;
            this.c = j;
            this.d = l7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public jbb<T> call() {
            return this.b.t(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes10.dex */
    public static final class l<T> implements z7b<jbb<T>> {
        public final i7b<T> a;

        public l(i7b<T> i7bVar) {
            this.a = i7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public jbb<T> call() {
            return this.a.q();
        }
    }

    /* loaded from: classes10.dex */
    public static final class m<T> implements z7b<jbb<T>> {
        public final long a;
        public final TimeUnit b;
        public final l7b c;
        public final int d;
        public final i7b<T> e;

        public m(i7b<T> i7bVar, int i, long j, TimeUnit timeUnit, l7b l7bVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = l7bVar;
            this.d = i;
            this.e = i7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public jbb<T> call() {
            return this.e.s(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes10.dex */
    public static final class n implements a8b<i7b<? extends Notification<?>>, i7b<?>> {
        public final a8b<? super i7b<? extends Throwable>, ? extends i7b<?>> a;

        public n(a8b<? super i7b<? extends Throwable>, ? extends i7b<?>> a8bVar) {
            this.a = a8bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public i7b<?> call(i7b<? extends Notification<?>> i7bVar) {
            return this.a.call(i7bVar.j(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes10.dex */
    public static final class p<T, R> implements a8b<i7b<T>, i7b<R>> {
        public final a8b<? super i7b<T>, ? extends i7b<R>> a;
        public final l7b b;

        public p(a8b<? super i7b<T>, ? extends i7b<R>> a8bVar, l7b l7bVar) {
            this.a = a8bVar;
            this.b = l7bVar;
        }

        public i7b<R> call(i7b<T> i7bVar) {
            return this.a.call(i7bVar).m(this.b);
        }

        @Override // com.baidu.tieba.a8b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((i7b) ((i7b) obj));
        }
    }

    public static <T, R> a8b<i7b<T>, i7b<R>> createReplaySelectorAndObserveOn(a8b<? super i7b<T>, ? extends i7b<R>> a8bVar, l7b l7bVar) {
        return new p(a8bVar, l7bVar);
    }

    public static <T> z7b<jbb<T>> createReplaySupplier(i7b<T> i7bVar, int i2) {
        return new j(i7bVar, i2);
    }

    /* loaded from: classes10.dex */
    public static final class e implements a8b<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> b8b<R, T, R> createCollectorCaller(x7b<R, ? super T> x7bVar) {
        return new a(x7bVar);
    }

    public static a8b<i7b<? extends Notification<?>>, i7b<?>> createRepeatDematerializer(a8b<? super i7b<? extends Void>, ? extends i7b<?>> a8bVar) {
        return new i(a8bVar);
    }

    public static <T> z7b<jbb<T>> createReplaySupplier(i7b<T> i7bVar) {
        return new l(i7bVar);
    }

    public static a8b<i7b<? extends Notification<?>>, i7b<?>> createRetryDematerializer(a8b<? super i7b<? extends Throwable>, ? extends i7b<?>> a8bVar) {
        return new n(a8bVar);
    }

    public static a8b<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static a8b<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> z7b<jbb<T>> createReplaySupplier(i7b<T> i7bVar, int i2, long j2, TimeUnit timeUnit, l7b l7bVar) {
        return new m(i7bVar, i2, j2, timeUnit, l7bVar);
    }

    public static <T> z7b<jbb<T>> createReplaySupplier(i7b<T> i7bVar, long j2, TimeUnit timeUnit, l7b l7bVar) {
        return new k(i7bVar, j2, timeUnit, l7bVar);
    }
}

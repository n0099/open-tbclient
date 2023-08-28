package rx.internal.util;

import com.baidu.tieba.d8c;
import com.baidu.tieba.e8c;
import com.baidu.tieba.h8c;
import com.baidu.tieba.i8c;
import com.baidu.tieba.j8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.s7c;
import com.baidu.tieba.ubc;
import com.baidu.tieba.v8c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new j8c<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j8c
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new j8c<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.j8c
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
    public static final q TO_ARRAY = new i8c<List<? extends p7c<?>>, p7c<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i8c
        public p7c<?>[] call(List<? extends p7c<?>> list) {
            return (p7c[]) list.toArray(new p7c[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new j8c<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.j8c
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final d8c<Throwable> ERROR_NOT_IMPLEMENTED = new d8c<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.d8c
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final p7c.b<Boolean, Object> IS_EMPTY = new v8c(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements i8c<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i8c
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements j8c<R, T, R> {
        public final e8c<R, ? super T> a;

        public a(e8c<R, ? super T> e8cVar) {
            this.a = e8cVar;
        }

        @Override // com.baidu.tieba.j8c
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements i8c<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.i8c
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
    public static final class d implements i8c<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.i8c
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements i8c<p7c<? extends Notification<?>>, p7c<?>> {
        public final i8c<? super p7c<? extends Void>, ? extends p7c<?>> a;

        public i(i8c<? super p7c<? extends Void>, ? extends p7c<?>> i8cVar) {
            this.a = i8cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i8c
        public p7c<?> call(p7c<? extends Notification<?>> p7cVar) {
            return this.a.call(p7cVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements h8c<ubc<T>> {
        public final p7c<T> a;
        public final int b;

        public j(p7c<T> p7cVar, int i) {
            this.a = p7cVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h8c
        public ubc<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements h8c<ubc<T>> {
        public final TimeUnit a;
        public final p7c<T> b;
        public final long c;
        public final s7c d;

        public k(p7c<T> p7cVar, long j, TimeUnit timeUnit, s7c s7cVar) {
            this.a = timeUnit;
            this.b = p7cVar;
            this.c = j;
            this.d = s7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h8c
        public ubc<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements h8c<ubc<T>> {
        public final p7c<T> a;

        public l(p7c<T> p7cVar) {
            this.a = p7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h8c
        public ubc<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements h8c<ubc<T>> {
        public final long a;
        public final TimeUnit b;
        public final s7c c;
        public final int d;
        public final p7c<T> e;

        public m(p7c<T> p7cVar, int i, long j, TimeUnit timeUnit, s7c s7cVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = s7cVar;
            this.d = i;
            this.e = p7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h8c
        public ubc<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements i8c<p7c<? extends Notification<?>>, p7c<?>> {
        public final i8c<? super p7c<? extends Throwable>, ? extends p7c<?>> a;

        public n(i8c<? super p7c<? extends Throwable>, ? extends p7c<?>> i8cVar) {
            this.a = i8cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i8c
        public p7c<?> call(p7c<? extends Notification<?>> p7cVar) {
            return this.a.call(p7cVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements i8c<p7c<T>, p7c<R>> {
        public final i8c<? super p7c<T>, ? extends p7c<R>> a;
        public final s7c b;

        public p(i8c<? super p7c<T>, ? extends p7c<R>> i8cVar, s7c s7cVar) {
            this.a = i8cVar;
            this.b = s7cVar;
        }

        public p7c<R> call(p7c<T> p7cVar) {
            return this.a.call(p7cVar).s(this.b);
        }

        @Override // com.baidu.tieba.i8c
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((p7c) ((p7c) obj));
        }
    }

    public static <T, R> i8c<p7c<T>, p7c<R>> createReplaySelectorAndObserveOn(i8c<? super p7c<T>, ? extends p7c<R>> i8cVar, s7c s7cVar) {
        return new p(i8cVar, s7cVar);
    }

    public static <T> h8c<ubc<T>> createReplaySupplier(p7c<T> p7cVar, int i2) {
        return new j(p7cVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements i8c<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i8c
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> j8c<R, T, R> createCollectorCaller(e8c<R, ? super T> e8cVar) {
        return new a(e8cVar);
    }

    public static i8c<p7c<? extends Notification<?>>, p7c<?>> createRepeatDematerializer(i8c<? super p7c<? extends Void>, ? extends p7c<?>> i8cVar) {
        return new i(i8cVar);
    }

    public static <T> h8c<ubc<T>> createReplaySupplier(p7c<T> p7cVar) {
        return new l(p7cVar);
    }

    public static i8c<p7c<? extends Notification<?>>, p7c<?>> createRetryDematerializer(i8c<? super p7c<? extends Throwable>, ? extends p7c<?>> i8cVar) {
        return new n(i8cVar);
    }

    public static i8c<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static i8c<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> h8c<ubc<T>> createReplaySupplier(p7c<T> p7cVar, int i2, long j2, TimeUnit timeUnit, s7c s7cVar) {
        return new m(p7cVar, i2, j2, timeUnit, s7cVar);
    }

    public static <T> h8c<ubc<T>> createReplaySupplier(p7c<T> p7cVar, long j2, TimeUnit timeUnit, s7c s7cVar) {
        return new k(p7cVar, j2, timeUnit, s7cVar);
    }
}

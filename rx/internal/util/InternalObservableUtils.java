package rx.internal.util;

import com.baidu.tieba.a1c;
import com.baidu.tieba.b5c;
import com.baidu.tieba.c2c;
import com.baidu.tieba.l1c;
import com.baidu.tieba.m1c;
import com.baidu.tieba.o1c;
import com.baidu.tieba.p1c;
import com.baidu.tieba.q1c;
import com.baidu.tieba.x0c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new q1c<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new q1c<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.q1c
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
    public static final q TO_ARRAY = new p1c<List<? extends x0c<?>>, x0c<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public x0c<?>[] call(List<? extends x0c<?>> list) {
            return (x0c[]) list.toArray(new x0c[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new q1c<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final l1c<Throwable> ERROR_NOT_IMPLEMENTED = new l1c<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l1c
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final x0c.b<Boolean, Object> IS_EMPTY = new c2c(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements p1c<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements q1c<R, T, R> {
        public final m1c<R, ? super T> a;

        public a(m1c<R, ? super T> m1cVar) {
            this.a = m1cVar;
        }

        @Override // com.baidu.tieba.q1c
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements p1c<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.p1c
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
    public static final class d implements p1c<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.p1c
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements p1c<x0c<? extends Notification<?>>, x0c<?>> {
        public final p1c<? super x0c<? extends Void>, ? extends x0c<?>> a;

        public i(p1c<? super x0c<? extends Void>, ? extends x0c<?>> p1cVar) {
            this.a = p1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public x0c<?> call(x0c<? extends Notification<?>> x0cVar) {
            return this.a.call(x0cVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements o1c<b5c<T>> {
        public final x0c<T> a;
        public final int b;

        public j(x0c<T> x0cVar, int i) {
            this.a = x0cVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o1c
        public b5c<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements o1c<b5c<T>> {
        public final TimeUnit a;
        public final x0c<T> b;
        public final long c;
        public final a1c d;

        public k(x0c<T> x0cVar, long j, TimeUnit timeUnit, a1c a1cVar) {
            this.a = timeUnit;
            this.b = x0cVar;
            this.c = j;
            this.d = a1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o1c
        public b5c<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements o1c<b5c<T>> {
        public final x0c<T> a;

        public l(x0c<T> x0cVar) {
            this.a = x0cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o1c
        public b5c<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements o1c<b5c<T>> {
        public final long a;
        public final TimeUnit b;
        public final a1c c;
        public final int d;
        public final x0c<T> e;

        public m(x0c<T> x0cVar, int i, long j, TimeUnit timeUnit, a1c a1cVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = a1cVar;
            this.d = i;
            this.e = x0cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o1c
        public b5c<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements p1c<x0c<? extends Notification<?>>, x0c<?>> {
        public final p1c<? super x0c<? extends Throwable>, ? extends x0c<?>> a;

        public n(p1c<? super x0c<? extends Throwable>, ? extends x0c<?>> p1cVar) {
            this.a = p1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public x0c<?> call(x0c<? extends Notification<?>> x0cVar) {
            return this.a.call(x0cVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements p1c<x0c<T>, x0c<R>> {
        public final p1c<? super x0c<T>, ? extends x0c<R>> a;
        public final a1c b;

        public p(p1c<? super x0c<T>, ? extends x0c<R>> p1cVar, a1c a1cVar) {
            this.a = p1cVar;
            this.b = a1cVar;
        }

        public x0c<R> call(x0c<T> x0cVar) {
            return this.a.call(x0cVar).s(this.b);
        }

        @Override // com.baidu.tieba.p1c
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((x0c) ((x0c) obj));
        }
    }

    public static <T, R> p1c<x0c<T>, x0c<R>> createReplaySelectorAndObserveOn(p1c<? super x0c<T>, ? extends x0c<R>> p1cVar, a1c a1cVar) {
        return new p(p1cVar, a1cVar);
    }

    public static <T> o1c<b5c<T>> createReplaySupplier(x0c<T> x0cVar, int i2) {
        return new j(x0cVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements p1c<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> q1c<R, T, R> createCollectorCaller(m1c<R, ? super T> m1cVar) {
        return new a(m1cVar);
    }

    public static p1c<x0c<? extends Notification<?>>, x0c<?>> createRepeatDematerializer(p1c<? super x0c<? extends Void>, ? extends x0c<?>> p1cVar) {
        return new i(p1cVar);
    }

    public static <T> o1c<b5c<T>> createReplaySupplier(x0c<T> x0cVar) {
        return new l(x0cVar);
    }

    public static p1c<x0c<? extends Notification<?>>, x0c<?>> createRetryDematerializer(p1c<? super x0c<? extends Throwable>, ? extends x0c<?>> p1cVar) {
        return new n(p1cVar);
    }

    public static p1c<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static p1c<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> o1c<b5c<T>> createReplaySupplier(x0c<T> x0cVar, int i2, long j2, TimeUnit timeUnit, a1c a1cVar) {
        return new m(x0cVar, i2, j2, timeUnit, a1cVar);
    }

    public static <T> o1c<b5c<T>> createReplaySupplier(x0c<T> x0cVar, long j2, TimeUnit timeUnit, a1c a1cVar) {
        return new k(x0cVar, j2, timeUnit, a1cVar);
    }
}

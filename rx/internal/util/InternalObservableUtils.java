package rx.internal.util;

import com.baidu.tieba.b1c;
import com.baidu.tieba.c5c;
import com.baidu.tieba.d2c;
import com.baidu.tieba.m1c;
import com.baidu.tieba.n1c;
import com.baidu.tieba.p1c;
import com.baidu.tieba.q1c;
import com.baidu.tieba.r1c;
import com.baidu.tieba.y0c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new r1c<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r1c
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new r1c<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.r1c
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
    public static final q TO_ARRAY = new q1c<List<? extends y0c<?>>, y0c<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public y0c<?>[] call(List<? extends y0c<?>> list) {
            return (y0c[]) list.toArray(new y0c[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new r1c<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r1c
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final m1c<Throwable> ERROR_NOT_IMPLEMENTED = new m1c<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m1c
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final y0c.b<Boolean, Object> IS_EMPTY = new d2c(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements q1c<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements r1c<R, T, R> {
        public final n1c<R, ? super T> a;

        public a(n1c<R, ? super T> n1cVar) {
            this.a = n1cVar;
        }

        @Override // com.baidu.tieba.r1c
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements q1c<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.q1c
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
    public static final class d implements q1c<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.q1c
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements q1c<y0c<? extends Notification<?>>, y0c<?>> {
        public final q1c<? super y0c<? extends Void>, ? extends y0c<?>> a;

        public i(q1c<? super y0c<? extends Void>, ? extends y0c<?>> q1cVar) {
            this.a = q1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public y0c<?> call(y0c<? extends Notification<?>> y0cVar) {
            return this.a.call(y0cVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements p1c<c5c<T>> {
        public final y0c<T> a;
        public final int b;

        public j(y0c<T> y0cVar, int i) {
            this.a = y0cVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public c5c<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements p1c<c5c<T>> {
        public final TimeUnit a;
        public final y0c<T> b;
        public final long c;
        public final b1c d;

        public k(y0c<T> y0cVar, long j, TimeUnit timeUnit, b1c b1cVar) {
            this.a = timeUnit;
            this.b = y0cVar;
            this.c = j;
            this.d = b1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public c5c<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements p1c<c5c<T>> {
        public final y0c<T> a;

        public l(y0c<T> y0cVar) {
            this.a = y0cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public c5c<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements p1c<c5c<T>> {
        public final long a;
        public final TimeUnit b;
        public final b1c c;
        public final int d;
        public final y0c<T> e;

        public m(y0c<T> y0cVar, int i, long j, TimeUnit timeUnit, b1c b1cVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = b1cVar;
            this.d = i;
            this.e = y0cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p1c
        public c5c<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements q1c<y0c<? extends Notification<?>>, y0c<?>> {
        public final q1c<? super y0c<? extends Throwable>, ? extends y0c<?>> a;

        public n(q1c<? super y0c<? extends Throwable>, ? extends y0c<?>> q1cVar) {
            this.a = q1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public y0c<?> call(y0c<? extends Notification<?>> y0cVar) {
            return this.a.call(y0cVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements q1c<y0c<T>, y0c<R>> {
        public final q1c<? super y0c<T>, ? extends y0c<R>> a;
        public final b1c b;

        public p(q1c<? super y0c<T>, ? extends y0c<R>> q1cVar, b1c b1cVar) {
            this.a = q1cVar;
            this.b = b1cVar;
        }

        public y0c<R> call(y0c<T> y0cVar) {
            return this.a.call(y0cVar).s(this.b);
        }

        @Override // com.baidu.tieba.q1c
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((y0c) ((y0c) obj));
        }
    }

    public static <T, R> q1c<y0c<T>, y0c<R>> createReplaySelectorAndObserveOn(q1c<? super y0c<T>, ? extends y0c<R>> q1cVar, b1c b1cVar) {
        return new p(q1cVar, b1cVar);
    }

    public static <T> p1c<c5c<T>> createReplaySupplier(y0c<T> y0cVar, int i2) {
        return new j(y0cVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements q1c<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.q1c
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> r1c<R, T, R> createCollectorCaller(n1c<R, ? super T> n1cVar) {
        return new a(n1cVar);
    }

    public static q1c<y0c<? extends Notification<?>>, y0c<?>> createRepeatDematerializer(q1c<? super y0c<? extends Void>, ? extends y0c<?>> q1cVar) {
        return new i(q1cVar);
    }

    public static <T> p1c<c5c<T>> createReplaySupplier(y0c<T> y0cVar) {
        return new l(y0cVar);
    }

    public static q1c<y0c<? extends Notification<?>>, y0c<?>> createRetryDematerializer(q1c<? super y0c<? extends Throwable>, ? extends y0c<?>> q1cVar) {
        return new n(q1cVar);
    }

    public static q1c<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static q1c<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> p1c<c5c<T>> createReplaySupplier(y0c<T> y0cVar, int i2, long j2, TimeUnit timeUnit, b1c b1cVar) {
        return new m(y0cVar, i2, j2, timeUnit, b1cVar);
    }

    public static <T> p1c<c5c<T>> createReplaySupplier(y0c<T> y0cVar, long j2, TimeUnit timeUnit, b1c b1cVar) {
        return new k(y0cVar, j2, timeUnit, b1cVar);
    }
}

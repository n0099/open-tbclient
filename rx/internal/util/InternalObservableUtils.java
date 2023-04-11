package rx.internal.util;

import com.baidu.tieba.d5b;
import com.baidu.tieba.f1b;
import com.baidu.tieba.i1b;
import com.baidu.tieba.i2b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import com.baidu.tieba.w1b;
import com.baidu.tieba.x1b;
import com.baidu.tieba.y1b;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new y1b<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y1b
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new y1b<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.y1b
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
    public static final q TO_ARRAY = new x1b<List<? extends f1b<?>>, f1b<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x1b
        public f1b<?>[] call(List<? extends f1b<?>> list) {
            return (f1b[]) list.toArray(new f1b[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new y1b<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y1b
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final t1b<Throwable> ERROR_NOT_IMPLEMENTED = new t1b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t1b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final f1b.b<Boolean, Object> IS_EMPTY = new i2b(UtilityFunctions.a(), true);

    /* loaded from: classes9.dex */
    public static final class o implements x1b<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x1b
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T, R> implements y1b<R, T, R> {
        public final u1b<R, ? super T> a;

        public a(u1b<R, ? super T> u1bVar) {
            this.a = u1bVar;
        }

        @Override // com.baidu.tieba.y1b
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements x1b<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.x1b
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
    public static final class d implements x1b<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.x1b
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class i implements x1b<f1b<? extends Notification<?>>, f1b<?>> {
        public final x1b<? super f1b<? extends Void>, ? extends f1b<?>> a;

        public i(x1b<? super f1b<? extends Void>, ? extends f1b<?>> x1bVar) {
            this.a = x1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x1b
        public f1b<?> call(f1b<? extends Notification<?>> f1bVar) {
            return this.a.call(f1bVar.h(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes9.dex */
    public static final class j<T> implements w1b<d5b<T>> {
        public final f1b<T> a;
        public final int b;

        public j(f1b<T> f1bVar, int i) {
            this.a = f1bVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w1b
        public d5b<T> call() {
            return this.a.p(this.b);
        }
    }

    /* loaded from: classes9.dex */
    public static final class k<T> implements w1b<d5b<T>> {
        public final TimeUnit a;
        public final f1b<T> b;
        public final long c;
        public final i1b d;

        public k(f1b<T> f1bVar, long j, TimeUnit timeUnit, i1b i1bVar) {
            this.a = timeUnit;
            this.b = f1bVar;
            this.c = j;
            this.d = i1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w1b
        public d5b<T> call() {
            return this.b.r(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes9.dex */
    public static final class l<T> implements w1b<d5b<T>> {
        public final f1b<T> a;

        public l(f1b<T> f1bVar) {
            this.a = f1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w1b
        public d5b<T> call() {
            return this.a.o();
        }
    }

    /* loaded from: classes9.dex */
    public static final class m<T> implements w1b<d5b<T>> {
        public final long a;
        public final TimeUnit b;
        public final i1b c;
        public final int d;
        public final f1b<T> e;

        public m(f1b<T> f1bVar, int i, long j, TimeUnit timeUnit, i1b i1bVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = i1bVar;
            this.d = i;
            this.e = f1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w1b
        public d5b<T> call() {
            return this.e.q(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes9.dex */
    public static final class n implements x1b<f1b<? extends Notification<?>>, f1b<?>> {
        public final x1b<? super f1b<? extends Throwable>, ? extends f1b<?>> a;

        public n(x1b<? super f1b<? extends Throwable>, ? extends f1b<?>> x1bVar) {
            this.a = x1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x1b
        public f1b<?> call(f1b<? extends Notification<?>> f1bVar) {
            return this.a.call(f1bVar.h(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes9.dex */
    public static final class p<T, R> implements x1b<f1b<T>, f1b<R>> {
        public final x1b<? super f1b<T>, ? extends f1b<R>> a;
        public final i1b b;

        public p(x1b<? super f1b<T>, ? extends f1b<R>> x1bVar, i1b i1bVar) {
            this.a = x1bVar;
            this.b = i1bVar;
        }

        public f1b<R> call(f1b<T> f1bVar) {
            return this.a.call(f1bVar).k(this.b);
        }

        @Override // com.baidu.tieba.x1b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((f1b) ((f1b) obj));
        }
    }

    public static <T, R> x1b<f1b<T>, f1b<R>> createReplaySelectorAndObserveOn(x1b<? super f1b<T>, ? extends f1b<R>> x1bVar, i1b i1bVar) {
        return new p(x1bVar, i1bVar);
    }

    public static <T> w1b<d5b<T>> createReplaySupplier(f1b<T> f1bVar, int i2) {
        return new j(f1bVar, i2);
    }

    /* loaded from: classes9.dex */
    public static final class e implements x1b<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x1b
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> y1b<R, T, R> createCollectorCaller(u1b<R, ? super T> u1bVar) {
        return new a(u1bVar);
    }

    public static x1b<f1b<? extends Notification<?>>, f1b<?>> createRepeatDematerializer(x1b<? super f1b<? extends Void>, ? extends f1b<?>> x1bVar) {
        return new i(x1bVar);
    }

    public static <T> w1b<d5b<T>> createReplaySupplier(f1b<T> f1bVar) {
        return new l(f1bVar);
    }

    public static x1b<f1b<? extends Notification<?>>, f1b<?>> createRetryDematerializer(x1b<? super f1b<? extends Throwable>, ? extends f1b<?>> x1bVar) {
        return new n(x1bVar);
    }

    public static x1b<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static x1b<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> w1b<d5b<T>> createReplaySupplier(f1b<T> f1bVar, int i2, long j2, TimeUnit timeUnit, i1b i1bVar) {
        return new m(f1bVar, i2, j2, timeUnit, i1bVar);
    }

    public static <T> w1b<d5b<T>> createReplaySupplier(f1b<T> f1bVar, long j2, TimeUnit timeUnit, i1b i1bVar) {
        return new k(f1bVar, j2, timeUnit, i1bVar);
    }
}

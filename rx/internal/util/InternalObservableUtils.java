package rx.internal.util;

import com.baidu.tieba.b2b;
import com.baidu.tieba.c2b;
import com.baidu.tieba.e2b;
import com.baidu.tieba.f2b;
import com.baidu.tieba.g2b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.n1b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.q2b;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new g2b<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g2b
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new g2b<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.g2b
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
    public static final q TO_ARRAY = new f2b<List<? extends n1b<?>>, n1b<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f2b
        public n1b<?>[] call(List<? extends n1b<?>> list) {
            return (n1b[]) list.toArray(new n1b[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new g2b<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g2b
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final b2b<Throwable> ERROR_NOT_IMPLEMENTED = new b2b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b2b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final n1b.b<Boolean, Object> IS_EMPTY = new q2b(UtilityFunctions.a(), true);

    /* loaded from: classes9.dex */
    public static final class o implements f2b<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f2b
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T, R> implements g2b<R, T, R> {
        public final c2b<R, ? super T> a;

        public a(c2b<R, ? super T> c2bVar) {
            this.a = c2bVar;
        }

        @Override // com.baidu.tieba.g2b
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements f2b<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.f2b
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
    public static final class d implements f2b<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.f2b
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class i implements f2b<n1b<? extends Notification<?>>, n1b<?>> {
        public final f2b<? super n1b<? extends Void>, ? extends n1b<?>> a;

        public i(f2b<? super n1b<? extends Void>, ? extends n1b<?>> f2bVar) {
            this.a = f2bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f2b
        public n1b<?> call(n1b<? extends Notification<?>> n1bVar) {
            return this.a.call(n1bVar.h(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes9.dex */
    public static final class j<T> implements e2b<l5b<T>> {
        public final n1b<T> a;
        public final int b;

        public j(n1b<T> n1bVar, int i) {
            this.a = n1bVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.e2b
        public l5b<T> call() {
            return this.a.p(this.b);
        }
    }

    /* loaded from: classes9.dex */
    public static final class k<T> implements e2b<l5b<T>> {
        public final TimeUnit a;
        public final n1b<T> b;
        public final long c;
        public final q1b d;

        public k(n1b<T> n1bVar, long j, TimeUnit timeUnit, q1b q1bVar) {
            this.a = timeUnit;
            this.b = n1bVar;
            this.c = j;
            this.d = q1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.e2b
        public l5b<T> call() {
            return this.b.r(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes9.dex */
    public static final class l<T> implements e2b<l5b<T>> {
        public final n1b<T> a;

        public l(n1b<T> n1bVar) {
            this.a = n1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.e2b
        public l5b<T> call() {
            return this.a.o();
        }
    }

    /* loaded from: classes9.dex */
    public static final class m<T> implements e2b<l5b<T>> {
        public final long a;
        public final TimeUnit b;
        public final q1b c;
        public final int d;
        public final n1b<T> e;

        public m(n1b<T> n1bVar, int i, long j, TimeUnit timeUnit, q1b q1bVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = q1bVar;
            this.d = i;
            this.e = n1bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.e2b
        public l5b<T> call() {
            return this.e.q(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes9.dex */
    public static final class n implements f2b<n1b<? extends Notification<?>>, n1b<?>> {
        public final f2b<? super n1b<? extends Throwable>, ? extends n1b<?>> a;

        public n(f2b<? super n1b<? extends Throwable>, ? extends n1b<?>> f2bVar) {
            this.a = f2bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f2b
        public n1b<?> call(n1b<? extends Notification<?>> n1bVar) {
            return this.a.call(n1bVar.h(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes9.dex */
    public static final class p<T, R> implements f2b<n1b<T>, n1b<R>> {
        public final f2b<? super n1b<T>, ? extends n1b<R>> a;
        public final q1b b;

        public p(f2b<? super n1b<T>, ? extends n1b<R>> f2bVar, q1b q1bVar) {
            this.a = f2bVar;
            this.b = q1bVar;
        }

        public n1b<R> call(n1b<T> n1bVar) {
            return this.a.call(n1bVar).k(this.b);
        }

        @Override // com.baidu.tieba.f2b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((n1b) ((n1b) obj));
        }
    }

    public static <T, R> f2b<n1b<T>, n1b<R>> createReplaySelectorAndObserveOn(f2b<? super n1b<T>, ? extends n1b<R>> f2bVar, q1b q1bVar) {
        return new p(f2bVar, q1bVar);
    }

    public static <T> e2b<l5b<T>> createReplaySupplier(n1b<T> n1bVar, int i2) {
        return new j(n1bVar, i2);
    }

    /* loaded from: classes9.dex */
    public static final class e implements f2b<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f2b
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> g2b<R, T, R> createCollectorCaller(c2b<R, ? super T> c2bVar) {
        return new a(c2bVar);
    }

    public static f2b<n1b<? extends Notification<?>>, n1b<?>> createRepeatDematerializer(f2b<? super n1b<? extends Void>, ? extends n1b<?>> f2bVar) {
        return new i(f2bVar);
    }

    public static <T> e2b<l5b<T>> createReplaySupplier(n1b<T> n1bVar) {
        return new l(n1bVar);
    }

    public static f2b<n1b<? extends Notification<?>>, n1b<?>> createRetryDematerializer(f2b<? super n1b<? extends Throwable>, ? extends n1b<?>> f2bVar) {
        return new n(f2bVar);
    }

    public static f2b<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static f2b<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> e2b<l5b<T>> createReplaySupplier(n1b<T> n1bVar, int i2, long j2, TimeUnit timeUnit, q1b q1bVar) {
        return new m(n1bVar, i2, j2, timeUnit, q1bVar);
    }

    public static <T> e2b<l5b<T>> createReplaySupplier(n1b<T> n1bVar, long j2, TimeUnit timeUnit, q1b q1bVar) {
        return new k(n1bVar, j2, timeUnit, q1bVar);
    }
}

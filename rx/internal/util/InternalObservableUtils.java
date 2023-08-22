package rx.internal.util;

import com.baidu.tieba.b8c;
import com.baidu.tieba.c8c;
import com.baidu.tieba.f8c;
import com.baidu.tieba.g8c;
import com.baidu.tieba.h8c;
import com.baidu.tieba.n7c;
import com.baidu.tieba.q7c;
import com.baidu.tieba.sbc;
import com.baidu.tieba.t8c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new h8c<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h8c
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new h8c<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.h8c
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
    public static final q TO_ARRAY = new g8c<List<? extends n7c<?>>, n7c<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g8c
        public n7c<?>[] call(List<? extends n7c<?>> list) {
            return (n7c[]) list.toArray(new n7c[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new h8c<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h8c
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final b8c<Throwable> ERROR_NOT_IMPLEMENTED = new b8c<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b8c
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final n7c.b<Boolean, Object> IS_EMPTY = new t8c(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements g8c<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g8c
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements h8c<R, T, R> {
        public final c8c<R, ? super T> a;

        public a(c8c<R, ? super T> c8cVar) {
            this.a = c8cVar;
        }

        @Override // com.baidu.tieba.h8c
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements g8c<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.g8c
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
    public static final class d implements g8c<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.g8c
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements g8c<n7c<? extends Notification<?>>, n7c<?>> {
        public final g8c<? super n7c<? extends Void>, ? extends n7c<?>> a;

        public i(g8c<? super n7c<? extends Void>, ? extends n7c<?>> g8cVar) {
            this.a = g8cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g8c
        public n7c<?> call(n7c<? extends Notification<?>> n7cVar) {
            return this.a.call(n7cVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements f8c<sbc<T>> {
        public final n7c<T> a;
        public final int b;

        public j(n7c<T> n7cVar, int i) {
            this.a = n7cVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f8c
        public sbc<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements f8c<sbc<T>> {
        public final TimeUnit a;
        public final n7c<T> b;
        public final long c;
        public final q7c d;

        public k(n7c<T> n7cVar, long j, TimeUnit timeUnit, q7c q7cVar) {
            this.a = timeUnit;
            this.b = n7cVar;
            this.c = j;
            this.d = q7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f8c
        public sbc<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements f8c<sbc<T>> {
        public final n7c<T> a;

        public l(n7c<T> n7cVar) {
            this.a = n7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f8c
        public sbc<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements f8c<sbc<T>> {
        public final long a;
        public final TimeUnit b;
        public final q7c c;
        public final int d;
        public final n7c<T> e;

        public m(n7c<T> n7cVar, int i, long j, TimeUnit timeUnit, q7c q7cVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = q7cVar;
            this.d = i;
            this.e = n7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f8c
        public sbc<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements g8c<n7c<? extends Notification<?>>, n7c<?>> {
        public final g8c<? super n7c<? extends Throwable>, ? extends n7c<?>> a;

        public n(g8c<? super n7c<? extends Throwable>, ? extends n7c<?>> g8cVar) {
            this.a = g8cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g8c
        public n7c<?> call(n7c<? extends Notification<?>> n7cVar) {
            return this.a.call(n7cVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements g8c<n7c<T>, n7c<R>> {
        public final g8c<? super n7c<T>, ? extends n7c<R>> a;
        public final q7c b;

        public p(g8c<? super n7c<T>, ? extends n7c<R>> g8cVar, q7c q7cVar) {
            this.a = g8cVar;
            this.b = q7cVar;
        }

        public n7c<R> call(n7c<T> n7cVar) {
            return this.a.call(n7cVar).s(this.b);
        }

        @Override // com.baidu.tieba.g8c
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((n7c) ((n7c) obj));
        }
    }

    public static <T, R> g8c<n7c<T>, n7c<R>> createReplaySelectorAndObserveOn(g8c<? super n7c<T>, ? extends n7c<R>> g8cVar, q7c q7cVar) {
        return new p(g8cVar, q7cVar);
    }

    public static <T> f8c<sbc<T>> createReplaySupplier(n7c<T> n7cVar, int i2) {
        return new j(n7cVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements g8c<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g8c
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> h8c<R, T, R> createCollectorCaller(c8c<R, ? super T> c8cVar) {
        return new a(c8cVar);
    }

    public static g8c<n7c<? extends Notification<?>>, n7c<?>> createRepeatDematerializer(g8c<? super n7c<? extends Void>, ? extends n7c<?>> g8cVar) {
        return new i(g8cVar);
    }

    public static <T> f8c<sbc<T>> createReplaySupplier(n7c<T> n7cVar) {
        return new l(n7cVar);
    }

    public static g8c<n7c<? extends Notification<?>>, n7c<?>> createRetryDematerializer(g8c<? super n7c<? extends Throwable>, ? extends n7c<?>> g8cVar) {
        return new n(g8cVar);
    }

    public static g8c<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static g8c<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> f8c<sbc<T>> createReplaySupplier(n7c<T> n7cVar, int i2, long j2, TimeUnit timeUnit, q7c q7cVar) {
        return new m(n7cVar, i2, j2, timeUnit, q7cVar);
    }

    public static <T> f8c<sbc<T>> createReplaySupplier(n7c<T> n7cVar, long j2, TimeUnit timeUnit, q7c q7cVar) {
        return new k(n7cVar, j2, timeUnit, q7cVar);
    }
}

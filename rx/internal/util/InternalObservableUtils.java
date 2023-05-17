package rx.internal.util;

import com.baidu.tieba.a8b;
import com.baidu.tieba.h7b;
import com.baidu.tieba.ibb;
import com.baidu.tieba.k7b;
import com.baidu.tieba.m8b;
import com.baidu.tieba.v7b;
import com.baidu.tieba.w7b;
import com.baidu.tieba.y7b;
import com.baidu.tieba.z7b;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes10.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new a8b<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new a8b<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.a8b
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
    public static final q TO_ARRAY = new z7b<List<? extends h7b<?>>, h7b<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public h7b<?>[] call(List<? extends h7b<?>> list) {
            return (h7b[]) list.toArray(new h7b[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new a8b<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8b
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final v7b<Throwable> ERROR_NOT_IMPLEMENTED = new v7b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v7b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final h7b.b<Boolean, Object> IS_EMPTY = new m8b(UtilityFunctions.a(), true);

    /* loaded from: classes10.dex */
    public static final class o implements z7b<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes10.dex */
    public static final class a<T, R> implements a8b<R, T, R> {
        public final w7b<R, ? super T> a;

        public a(w7b<R, ? super T> w7bVar) {
            this.a = w7bVar;
        }

        @Override // com.baidu.tieba.a8b
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes10.dex */
    public static final class b implements z7b<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.z7b
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
    public static final class d implements z7b<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.z7b
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes10.dex */
    public static final class i implements z7b<h7b<? extends Notification<?>>, h7b<?>> {
        public final z7b<? super h7b<? extends Void>, ? extends h7b<?>> a;

        public i(z7b<? super h7b<? extends Void>, ? extends h7b<?>> z7bVar) {
            this.a = z7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public h7b<?> call(h7b<? extends Notification<?>> h7bVar) {
            return this.a.call(h7bVar.j(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes10.dex */
    public static final class j<T> implements y7b<ibb<T>> {
        public final h7b<T> a;
        public final int b;

        public j(h7b<T> h7bVar, int i) {
            this.a = h7bVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y7b
        public ibb<T> call() {
            return this.a.r(this.b);
        }
    }

    /* loaded from: classes10.dex */
    public static final class k<T> implements y7b<ibb<T>> {
        public final TimeUnit a;
        public final h7b<T> b;
        public final long c;
        public final k7b d;

        public k(h7b<T> h7bVar, long j, TimeUnit timeUnit, k7b k7bVar) {
            this.a = timeUnit;
            this.b = h7bVar;
            this.c = j;
            this.d = k7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y7b
        public ibb<T> call() {
            return this.b.t(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes10.dex */
    public static final class l<T> implements y7b<ibb<T>> {
        public final h7b<T> a;

        public l(h7b<T> h7bVar) {
            this.a = h7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y7b
        public ibb<T> call() {
            return this.a.q();
        }
    }

    /* loaded from: classes10.dex */
    public static final class m<T> implements y7b<ibb<T>> {
        public final long a;
        public final TimeUnit b;
        public final k7b c;
        public final int d;
        public final h7b<T> e;

        public m(h7b<T> h7bVar, int i, long j, TimeUnit timeUnit, k7b k7bVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = k7bVar;
            this.d = i;
            this.e = h7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.y7b
        public ibb<T> call() {
            return this.e.s(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes10.dex */
    public static final class n implements z7b<h7b<? extends Notification<?>>, h7b<?>> {
        public final z7b<? super h7b<? extends Throwable>, ? extends h7b<?>> a;

        public n(z7b<? super h7b<? extends Throwable>, ? extends h7b<?>> z7bVar) {
            this.a = z7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public h7b<?> call(h7b<? extends Notification<?>> h7bVar) {
            return this.a.call(h7bVar.j(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes10.dex */
    public static final class p<T, R> implements z7b<h7b<T>, h7b<R>> {
        public final z7b<? super h7b<T>, ? extends h7b<R>> a;
        public final k7b b;

        public p(z7b<? super h7b<T>, ? extends h7b<R>> z7bVar, k7b k7bVar) {
            this.a = z7bVar;
            this.b = k7bVar;
        }

        public h7b<R> call(h7b<T> h7bVar) {
            return this.a.call(h7bVar).m(this.b);
        }

        @Override // com.baidu.tieba.z7b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((h7b) ((h7b) obj));
        }
    }

    public static <T, R> z7b<h7b<T>, h7b<R>> createReplaySelectorAndObserveOn(z7b<? super h7b<T>, ? extends h7b<R>> z7bVar, k7b k7bVar) {
        return new p(z7bVar, k7bVar);
    }

    public static <T> y7b<ibb<T>> createReplaySupplier(h7b<T> h7bVar, int i2) {
        return new j(h7bVar, i2);
    }

    /* loaded from: classes10.dex */
    public static final class e implements z7b<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7b
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> a8b<R, T, R> createCollectorCaller(w7b<R, ? super T> w7bVar) {
        return new a(w7bVar);
    }

    public static z7b<h7b<? extends Notification<?>>, h7b<?>> createRepeatDematerializer(z7b<? super h7b<? extends Void>, ? extends h7b<?>> z7bVar) {
        return new i(z7bVar);
    }

    public static <T> y7b<ibb<T>> createReplaySupplier(h7b<T> h7bVar) {
        return new l(h7bVar);
    }

    public static z7b<h7b<? extends Notification<?>>, h7b<?>> createRetryDematerializer(z7b<? super h7b<? extends Throwable>, ? extends h7b<?>> z7bVar) {
        return new n(z7bVar);
    }

    public static z7b<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static z7b<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> y7b<ibb<T>> createReplaySupplier(h7b<T> h7bVar, int i2, long j2, TimeUnit timeUnit, k7b k7bVar) {
        return new m(h7bVar, i2, j2, timeUnit, k7bVar);
    }

    public static <T> y7b<ibb<T>> createReplaySupplier(h7b<T> h7bVar, long j2, TimeUnit timeUnit, k7b k7bVar) {
        return new k(h7bVar, j2, timeUnit, k7bVar);
    }
}

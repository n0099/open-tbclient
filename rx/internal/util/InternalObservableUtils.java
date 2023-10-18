package rx.internal.util;

import com.baidu.tieba.a7c;
import com.baidu.tieba.b7c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.k6c;
import com.baidu.tieba.oac;
import com.baidu.tieba.p7c;
import com.baidu.tieba.v6c;
import com.baidu.tieba.w6c;
import com.baidu.tieba.z6c;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new b7c<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b7c
        /* renamed from: b */
        public Long a(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new b7c<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b7c
        /* renamed from: b */
        public Boolean a(Object obj, Object obj2) {
            boolean z;
            if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    };
    public static final q TO_ARRAY = new a7c<List<? extends h6c<?>>, h6c<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public h6c<?>[] call(List<? extends h6c<?>> list) {
            return (h6c[]) list.toArray(new h6c[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new b7c<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b7c
        /* renamed from: b */
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final v6c<Throwable> ERROR_NOT_IMPLEMENTED = new v6c<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        public void a(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.v6c
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            a(th);
            throw null;
        }
    };
    public static final h6c.b<Boolean, Object> IS_EMPTY = new p7c(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements a7c<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements b7c<R, T, R> {
        public final w6c<R, ? super T> a;

        public a(w6c<R, ? super T> w6cVar) {
            this.a = w6cVar;
        }

        @Override // com.baidu.tieba.b7c
        public R a(R r, T t) {
            this.a.a(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements a7c<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
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
    public static final class d implements a7c<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements a7c<h6c<? extends Notification<?>>, h6c<?>> {
        public final a7c<? super h6c<? extends Void>, ? extends h6c<?>> a;

        public i(a7c<? super h6c<? extends Void>, ? extends h6c<?>> a7cVar) {
            this.a = a7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public h6c<?> call(h6c<? extends Notification<?>> h6cVar) {
            return this.a.call(h6cVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements z6c<oac<T>> {
        public final h6c<T> a;
        public final int b;

        public j(h6c<T> h6cVar, int i) {
            this.a = h6cVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z6c
        /* renamed from: a */
        public oac<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements z6c<oac<T>> {
        public final TimeUnit a;
        public final h6c<T> b;
        public final long c;
        public final k6c d;

        public k(h6c<T> h6cVar, long j, TimeUnit timeUnit, k6c k6cVar) {
            this.a = timeUnit;
            this.b = h6cVar;
            this.c = j;
            this.d = k6cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z6c
        /* renamed from: a */
        public oac<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements z6c<oac<T>> {
        public final h6c<T> a;

        public l(h6c<T> h6cVar) {
            this.a = h6cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z6c
        /* renamed from: a */
        public oac<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements z6c<oac<T>> {
        public final long a;
        public final TimeUnit b;
        public final k6c c;
        public final int d;
        public final h6c<T> e;

        public m(h6c<T> h6cVar, int i, long j, TimeUnit timeUnit, k6c k6cVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = k6cVar;
            this.d = i;
            this.e = h6cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z6c
        /* renamed from: a */
        public oac<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements a7c<h6c<? extends Notification<?>>, h6c<?>> {
        public final a7c<? super h6c<? extends Throwable>, ? extends h6c<?>> a;

        public n(a7c<? super h6c<? extends Throwable>, ? extends h6c<?>> a7cVar) {
            this.a = a7cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public h6c<?> call(h6c<? extends Notification<?>> h6cVar) {
            return this.a.call(h6cVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements a7c<h6c<T>, h6c<R>> {
        public final a7c<? super h6c<T>, ? extends h6c<R>> a;
        public final k6c b;

        public p(a7c<? super h6c<T>, ? extends h6c<R>> a7cVar, k6c k6cVar) {
            this.a = a7cVar;
            this.b = k6cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public h6c<R> call(h6c<T> h6cVar) {
            return this.a.call(h6cVar).s(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements a7c<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a7c
        /* renamed from: a */
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> a7c<h6c<T>, h6c<R>> createReplaySelectorAndObserveOn(a7c<? super h6c<T>, ? extends h6c<R>> a7cVar, k6c k6cVar) {
        return new p(a7cVar, k6cVar);
    }

    public static <T> z6c<oac<T>> createReplaySupplier(h6c<T> h6cVar, int i2) {
        return new j(h6cVar, i2);
    }

    public static <T, R> b7c<R, T, R> createCollectorCaller(w6c<R, ? super T> w6cVar) {
        return new a(w6cVar);
    }

    public static a7c<h6c<? extends Notification<?>>, h6c<?>> createRepeatDematerializer(a7c<? super h6c<? extends Void>, ? extends h6c<?>> a7cVar) {
        return new i(a7cVar);
    }

    public static <T> z6c<oac<T>> createReplaySupplier(h6c<T> h6cVar) {
        return new l(h6cVar);
    }

    public static a7c<h6c<? extends Notification<?>>, h6c<?>> createRetryDematerializer(a7c<? super h6c<? extends Throwable>, ? extends h6c<?>> a7cVar) {
        return new n(a7cVar);
    }

    public static a7c<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static a7c<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> z6c<oac<T>> createReplaySupplier(h6c<T> h6cVar, int i2, long j2, TimeUnit timeUnit, k6c k6cVar) {
        return new m(h6cVar, i2, j2, timeUnit, k6cVar);
    }

    public static <T> z6c<oac<T>> createReplaySupplier(h6c<T> h6cVar, long j2, TimeUnit timeUnit, k6c k6cVar) {
        return new k(h6cVar, j2, timeUnit, k6cVar);
    }
}

package rx.internal.util;

import com.baidu.tieba.akc;
import com.baidu.tieba.bkc;
import com.baidu.tieba.ckc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.pnc;
import com.baidu.tieba.qkc;
import com.baidu.tieba.wjc;
import com.baidu.tieba.xjc;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new ckc<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: b */
        public Long a(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new ckc<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
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
    public static final q TO_ARRAY = new bkc<List<? extends ijc<?>>, ijc<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public ijc<?>[] call(List<? extends ijc<?>> list) {
            return (ijc[]) list.toArray(new ijc[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new ckc<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckc
        /* renamed from: b */
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final wjc<Throwable> ERROR_NOT_IMPLEMENTED = new wjc<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        public void a(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.wjc
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            a(th);
            throw null;
        }
    };
    public static final ijc.b<Boolean, Object> IS_EMPTY = new qkc(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements bkc<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements ckc<R, T, R> {
        public final xjc<R, ? super T> a;

        public a(xjc<R, ? super T> xjcVar) {
            this.a = xjcVar;
        }

        @Override // com.baidu.tieba.ckc
        public R a(R r, T t) {
            this.a.a(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements bkc<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
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
    public static final class d implements bkc<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements bkc<ijc<? extends Notification<?>>, ijc<?>> {
        public final bkc<? super ijc<? extends Void>, ? extends ijc<?>> a;

        public i(bkc<? super ijc<? extends Void>, ? extends ijc<?>> bkcVar) {
            this.a = bkcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public ijc<?> call(ijc<? extends Notification<?>> ijcVar) {
            return this.a.call(ijcVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements akc<pnc<T>> {
        public final ijc<T> a;
        public final int b;

        public j(ijc<T> ijcVar, int i) {
            this.a = ijcVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.akc
        /* renamed from: a */
        public pnc<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements akc<pnc<T>> {
        public final TimeUnit a;
        public final ijc<T> b;
        public final long c;
        public final ljc d;

        public k(ijc<T> ijcVar, long j, TimeUnit timeUnit, ljc ljcVar) {
            this.a = timeUnit;
            this.b = ijcVar;
            this.c = j;
            this.d = ljcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.akc
        /* renamed from: a */
        public pnc<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements akc<pnc<T>> {
        public final ijc<T> a;

        public l(ijc<T> ijcVar) {
            this.a = ijcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.akc
        /* renamed from: a */
        public pnc<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements akc<pnc<T>> {
        public final long a;
        public final TimeUnit b;
        public final ljc c;
        public final int d;
        public final ijc<T> e;

        public m(ijc<T> ijcVar, int i, long j, TimeUnit timeUnit, ljc ljcVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = ljcVar;
            this.d = i;
            this.e = ijcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.akc
        /* renamed from: a */
        public pnc<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements bkc<ijc<? extends Notification<?>>, ijc<?>> {
        public final bkc<? super ijc<? extends Throwable>, ? extends ijc<?>> a;

        public n(bkc<? super ijc<? extends Throwable>, ? extends ijc<?>> bkcVar) {
            this.a = bkcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public ijc<?> call(ijc<? extends Notification<?>> ijcVar) {
            return this.a.call(ijcVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements bkc<ijc<T>, ijc<R>> {
        public final bkc<? super ijc<T>, ? extends ijc<R>> a;
        public final ljc b;

        public p(bkc<? super ijc<T>, ? extends ijc<R>> bkcVar, ljc ljcVar) {
            this.a = bkcVar;
            this.b = ljcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public ijc<R> call(ijc<T> ijcVar) {
            return this.a.call(ijcVar).s(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements bkc<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bkc
        /* renamed from: a */
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> bkc<ijc<T>, ijc<R>> createReplaySelectorAndObserveOn(bkc<? super ijc<T>, ? extends ijc<R>> bkcVar, ljc ljcVar) {
        return new p(bkcVar, ljcVar);
    }

    public static <T> akc<pnc<T>> createReplaySupplier(ijc<T> ijcVar, int i2) {
        return new j(ijcVar, i2);
    }

    public static <T, R> ckc<R, T, R> createCollectorCaller(xjc<R, ? super T> xjcVar) {
        return new a(xjcVar);
    }

    public static bkc<ijc<? extends Notification<?>>, ijc<?>> createRepeatDematerializer(bkc<? super ijc<? extends Void>, ? extends ijc<?>> bkcVar) {
        return new i(bkcVar);
    }

    public static <T> akc<pnc<T>> createReplaySupplier(ijc<T> ijcVar) {
        return new l(ijcVar);
    }

    public static bkc<ijc<? extends Notification<?>>, ijc<?>> createRetryDematerializer(bkc<? super ijc<? extends Throwable>, ? extends ijc<?>> bkcVar) {
        return new n(bkcVar);
    }

    public static bkc<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static bkc<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> akc<pnc<T>> createReplaySupplier(ijc<T> ijcVar, int i2, long j2, TimeUnit timeUnit, ljc ljcVar) {
        return new m(ijcVar, i2, j2, timeUnit, ljcVar);
    }

    public static <T> akc<pnc<T>> createReplaySupplier(ijc<T> ijcVar, long j2, TimeUnit timeUnit, ljc ljcVar) {
        return new k(ijcVar, j2, timeUnit, ljcVar);
    }
}

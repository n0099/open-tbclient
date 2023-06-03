package rx.internal.util;

import com.baidu.tieba.anb;
import com.baidu.tieba.bnb;
import com.baidu.tieba.imb;
import com.baidu.tieba.jqb;
import com.baidu.tieba.lmb;
import com.baidu.tieba.nnb;
import com.baidu.tieba.wmb;
import com.baidu.tieba.xmb;
import com.baidu.tieba.zmb;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new bnb<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bnb
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new bnb<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.bnb
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
    public static final q TO_ARRAY = new anb<List<? extends imb<?>>, imb<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.anb
        public imb<?>[] call(List<? extends imb<?>> list) {
            return (imb[]) list.toArray(new imb[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new bnb<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bnb
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final wmb<Throwable> ERROR_NOT_IMPLEMENTED = new wmb<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wmb
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final imb.b<Boolean, Object> IS_EMPTY = new nnb(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements anb<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.anb
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements bnb<R, T, R> {
        public final xmb<R, ? super T> a;

        public a(xmb<R, ? super T> xmbVar) {
            this.a = xmbVar;
        }

        @Override // com.baidu.tieba.bnb
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements anb<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.anb
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
    public static final class d implements anb<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.anb
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements anb<imb<? extends Notification<?>>, imb<?>> {
        public final anb<? super imb<? extends Void>, ? extends imb<?>> a;

        public i(anb<? super imb<? extends Void>, ? extends imb<?>> anbVar) {
            this.a = anbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.anb
        public imb<?> call(imb<? extends Notification<?>> imbVar) {
            return this.a.call(imbVar.j(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements zmb<jqb<T>> {
        public final imb<T> a;
        public final int b;

        public j(imb<T> imbVar, int i) {
            this.a = imbVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zmb
        public jqb<T> call() {
            return this.a.r(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements zmb<jqb<T>> {
        public final TimeUnit a;
        public final imb<T> b;
        public final long c;
        public final lmb d;

        public k(imb<T> imbVar, long j, TimeUnit timeUnit, lmb lmbVar) {
            this.a = timeUnit;
            this.b = imbVar;
            this.c = j;
            this.d = lmbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zmb
        public jqb<T> call() {
            return this.b.t(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements zmb<jqb<T>> {
        public final imb<T> a;

        public l(imb<T> imbVar) {
            this.a = imbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zmb
        public jqb<T> call() {
            return this.a.q();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements zmb<jqb<T>> {
        public final long a;
        public final TimeUnit b;
        public final lmb c;
        public final int d;
        public final imb<T> e;

        public m(imb<T> imbVar, int i, long j, TimeUnit timeUnit, lmb lmbVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = lmbVar;
            this.d = i;
            this.e = imbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zmb
        public jqb<T> call() {
            return this.e.s(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements anb<imb<? extends Notification<?>>, imb<?>> {
        public final anb<? super imb<? extends Throwable>, ? extends imb<?>> a;

        public n(anb<? super imb<? extends Throwable>, ? extends imb<?>> anbVar) {
            this.a = anbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.anb
        public imb<?> call(imb<? extends Notification<?>> imbVar) {
            return this.a.call(imbVar.j(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements anb<imb<T>, imb<R>> {
        public final anb<? super imb<T>, ? extends imb<R>> a;
        public final lmb b;

        public p(anb<? super imb<T>, ? extends imb<R>> anbVar, lmb lmbVar) {
            this.a = anbVar;
            this.b = lmbVar;
        }

        public imb<R> call(imb<T> imbVar) {
            return this.a.call(imbVar).m(this.b);
        }

        @Override // com.baidu.tieba.anb
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((imb) ((imb) obj));
        }
    }

    public static <T, R> anb<imb<T>, imb<R>> createReplaySelectorAndObserveOn(anb<? super imb<T>, ? extends imb<R>> anbVar, lmb lmbVar) {
        return new p(anbVar, lmbVar);
    }

    public static <T> zmb<jqb<T>> createReplaySupplier(imb<T> imbVar, int i2) {
        return new j(imbVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements anb<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.anb
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> bnb<R, T, R> createCollectorCaller(xmb<R, ? super T> xmbVar) {
        return new a(xmbVar);
    }

    public static anb<imb<? extends Notification<?>>, imb<?>> createRepeatDematerializer(anb<? super imb<? extends Void>, ? extends imb<?>> anbVar) {
        return new i(anbVar);
    }

    public static <T> zmb<jqb<T>> createReplaySupplier(imb<T> imbVar) {
        return new l(imbVar);
    }

    public static anb<imb<? extends Notification<?>>, imb<?>> createRetryDematerializer(anb<? super imb<? extends Throwable>, ? extends imb<?>> anbVar) {
        return new n(anbVar);
    }

    public static anb<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static anb<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> zmb<jqb<T>> createReplaySupplier(imb<T> imbVar, int i2, long j2, TimeUnit timeUnit, lmb lmbVar) {
        return new m(imbVar, i2, j2, timeUnit, lmbVar);
    }

    public static <T> zmb<jqb<T>> createReplaySupplier(imb<T> imbVar, long j2, TimeUnit timeUnit, lmb lmbVar) {
        return new k(imbVar, j2, timeUnit, lmbVar);
    }
}

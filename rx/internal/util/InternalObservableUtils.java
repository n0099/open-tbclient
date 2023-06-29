package rx.internal.util;

import com.baidu.tieba.atb;
import com.baidu.tieba.bxb;
import com.baidu.tieba.cub;
import com.baidu.tieba.ltb;
import com.baidu.tieba.mtb;
import com.baidu.tieba.otb;
import com.baidu.tieba.ptb;
import com.baidu.tieba.qtb;
import com.baidu.tieba.xsb;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new qtb<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qtb
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new qtb<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.qtb
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
    public static final q TO_ARRAY = new ptb<List<? extends xsb<?>>, xsb<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ptb
        public xsb<?>[] call(List<? extends xsb<?>> list) {
            return (xsb[]) list.toArray(new xsb[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new qtb<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qtb
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final ltb<Throwable> ERROR_NOT_IMPLEMENTED = new ltb<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ltb
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final xsb.b<Boolean, Object> IS_EMPTY = new cub(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements ptb<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ptb
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements qtb<R, T, R> {
        public final mtb<R, ? super T> a;

        public a(mtb<R, ? super T> mtbVar) {
            this.a = mtbVar;
        }

        @Override // com.baidu.tieba.qtb
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements ptb<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ptb
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
    public static final class d implements ptb<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ptb
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements ptb<xsb<? extends Notification<?>>, xsb<?>> {
        public final ptb<? super xsb<? extends Void>, ? extends xsb<?>> a;

        public i(ptb<? super xsb<? extends Void>, ? extends xsb<?>> ptbVar) {
            this.a = ptbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ptb
        public xsb<?> call(xsb<? extends Notification<?>> xsbVar) {
            return this.a.call(xsbVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements otb<bxb<T>> {
        public final xsb<T> a;
        public final int b;

        public j(xsb<T> xsbVar, int i) {
            this.a = xsbVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.otb
        public bxb<T> call() {
            return this.a.y(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements otb<bxb<T>> {
        public final TimeUnit a;
        public final xsb<T> b;
        public final long c;
        public final atb d;

        public k(xsb<T> xsbVar, long j, TimeUnit timeUnit, atb atbVar) {
            this.a = timeUnit;
            this.b = xsbVar;
            this.c = j;
            this.d = atbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.otb
        public bxb<T> call() {
            return this.b.A(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements otb<bxb<T>> {
        public final xsb<T> a;

        public l(xsb<T> xsbVar) {
            this.a = xsbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.otb
        public bxb<T> call() {
            return this.a.x();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements otb<bxb<T>> {
        public final long a;
        public final TimeUnit b;
        public final atb c;
        public final int d;
        public final xsb<T> e;

        public m(xsb<T> xsbVar, int i, long j, TimeUnit timeUnit, atb atbVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = atbVar;
            this.d = i;
            this.e = xsbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.otb
        public bxb<T> call() {
            return this.e.z(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements ptb<xsb<? extends Notification<?>>, xsb<?>> {
        public final ptb<? super xsb<? extends Throwable>, ? extends xsb<?>> a;

        public n(ptb<? super xsb<? extends Throwable>, ? extends xsb<?>> ptbVar) {
            this.a = ptbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ptb
        public xsb<?> call(xsb<? extends Notification<?>> xsbVar) {
            return this.a.call(xsbVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements ptb<xsb<T>, xsb<R>> {
        public final ptb<? super xsb<T>, ? extends xsb<R>> a;
        public final atb b;

        public p(ptb<? super xsb<T>, ? extends xsb<R>> ptbVar, atb atbVar) {
            this.a = ptbVar;
            this.b = atbVar;
        }

        public xsb<R> call(xsb<T> xsbVar) {
            return this.a.call(xsbVar).s(this.b);
        }

        @Override // com.baidu.tieba.ptb
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((xsb) ((xsb) obj));
        }
    }

    public static <T, R> ptb<xsb<T>, xsb<R>> createReplaySelectorAndObserveOn(ptb<? super xsb<T>, ? extends xsb<R>> ptbVar, atb atbVar) {
        return new p(ptbVar, atbVar);
    }

    public static <T> otb<bxb<T>> createReplaySupplier(xsb<T> xsbVar, int i2) {
        return new j(xsbVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements ptb<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ptb
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> qtb<R, T, R> createCollectorCaller(mtb<R, ? super T> mtbVar) {
        return new a(mtbVar);
    }

    public static ptb<xsb<? extends Notification<?>>, xsb<?>> createRepeatDematerializer(ptb<? super xsb<? extends Void>, ? extends xsb<?>> ptbVar) {
        return new i(ptbVar);
    }

    public static <T> otb<bxb<T>> createReplaySupplier(xsb<T> xsbVar) {
        return new l(xsbVar);
    }

    public static ptb<xsb<? extends Notification<?>>, xsb<?>> createRetryDematerializer(ptb<? super xsb<? extends Throwable>, ? extends xsb<?>> ptbVar) {
        return new n(ptbVar);
    }

    public static ptb<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static ptb<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> otb<bxb<T>> createReplaySupplier(xsb<T> xsbVar, int i2, long j2, TimeUnit timeUnit, atb atbVar) {
        return new m(xsbVar, i2, j2, timeUnit, atbVar);
    }

    public static <T> otb<bxb<T>> createReplaySupplier(xsb<T> xsbVar, long j2, TimeUnit timeUnit, atb atbVar) {
        return new k(xsbVar, j2, timeUnit, atbVar);
    }
}

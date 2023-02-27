package rx.internal.util;

import com.baidu.tieba.gna;
import com.baidu.tieba.hna;
import com.baidu.tieba.jna;
import com.baidu.tieba.kna;
import com.baidu.tieba.lna;
import com.baidu.tieba.qqa;
import com.baidu.tieba.sma;
import com.baidu.tieba.vma;
import com.baidu.tieba.vna;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes9.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new lna<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lna
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new lna<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.lna
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
    public static final q TO_ARRAY = new kna<List<? extends sma<?>>, sma<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kna
        public sma<?>[] call(List<? extends sma<?>> list) {
            return (sma[]) list.toArray(new sma[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new lna<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lna
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final gna<Throwable> ERROR_NOT_IMPLEMENTED = new gna<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gna
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final sma.b<Boolean, Object> IS_EMPTY = new vna(UtilityFunctions.a(), true);

    /* loaded from: classes9.dex */
    public static final class o implements kna<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kna
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T, R> implements lna<R, T, R> {
        public final hna<R, ? super T> a;

        public a(hna<R, ? super T> hnaVar) {
            this.a = hnaVar;
        }

        @Override // com.baidu.tieba.lna
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements kna<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.kna
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
    public static final class d implements kna<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.kna
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes9.dex */
    public static final class i implements kna<sma<? extends Notification<?>>, sma<?>> {
        public final kna<? super sma<? extends Void>, ? extends sma<?>> a;

        public i(kna<? super sma<? extends Void>, ? extends sma<?>> knaVar) {
            this.a = knaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kna
        public sma<?> call(sma<? extends Notification<?>> smaVar) {
            return this.a.call(smaVar.h(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes9.dex */
    public static final class j<T> implements jna<qqa<T>> {
        public final sma<T> a;
        public final int b;

        public j(sma<T> smaVar, int i) {
            this.a = smaVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jna
        public qqa<T> call() {
            return this.a.p(this.b);
        }
    }

    /* loaded from: classes9.dex */
    public static final class k<T> implements jna<qqa<T>> {
        public final TimeUnit a;
        public final sma<T> b;
        public final long c;
        public final vma d;

        public k(sma<T> smaVar, long j, TimeUnit timeUnit, vma vmaVar) {
            this.a = timeUnit;
            this.b = smaVar;
            this.c = j;
            this.d = vmaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jna
        public qqa<T> call() {
            return this.b.r(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes9.dex */
    public static final class l<T> implements jna<qqa<T>> {
        public final sma<T> a;

        public l(sma<T> smaVar) {
            this.a = smaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jna
        public qqa<T> call() {
            return this.a.o();
        }
    }

    /* loaded from: classes9.dex */
    public static final class m<T> implements jna<qqa<T>> {
        public final long a;
        public final TimeUnit b;
        public final vma c;
        public final int d;
        public final sma<T> e;

        public m(sma<T> smaVar, int i, long j, TimeUnit timeUnit, vma vmaVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = vmaVar;
            this.d = i;
            this.e = smaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jna
        public qqa<T> call() {
            return this.e.q(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes9.dex */
    public static final class n implements kna<sma<? extends Notification<?>>, sma<?>> {
        public final kna<? super sma<? extends Throwable>, ? extends sma<?>> a;

        public n(kna<? super sma<? extends Throwable>, ? extends sma<?>> knaVar) {
            this.a = knaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kna
        public sma<?> call(sma<? extends Notification<?>> smaVar) {
            return this.a.call(smaVar.h(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes9.dex */
    public static final class p<T, R> implements kna<sma<T>, sma<R>> {
        public final kna<? super sma<T>, ? extends sma<R>> a;
        public final vma b;

        public p(kna<? super sma<T>, ? extends sma<R>> knaVar, vma vmaVar) {
            this.a = knaVar;
            this.b = vmaVar;
        }

        public sma<R> call(sma<T> smaVar) {
            return this.a.call(smaVar).k(this.b);
        }

        @Override // com.baidu.tieba.kna
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((sma) ((sma) obj));
        }
    }

    public static <T, R> kna<sma<T>, sma<R>> createReplaySelectorAndObserveOn(kna<? super sma<T>, ? extends sma<R>> knaVar, vma vmaVar) {
        return new p(knaVar, vmaVar);
    }

    public static <T> jna<qqa<T>> createReplaySupplier(sma<T> smaVar, int i2) {
        return new j(smaVar, i2);
    }

    /* loaded from: classes9.dex */
    public static final class e implements kna<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kna
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> lna<R, T, R> createCollectorCaller(hna<R, ? super T> hnaVar) {
        return new a(hnaVar);
    }

    public static kna<sma<? extends Notification<?>>, sma<?>> createRepeatDematerializer(kna<? super sma<? extends Void>, ? extends sma<?>> knaVar) {
        return new i(knaVar);
    }

    public static <T> jna<qqa<T>> createReplaySupplier(sma<T> smaVar) {
        return new l(smaVar);
    }

    public static kna<sma<? extends Notification<?>>, sma<?>> createRetryDematerializer(kna<? super sma<? extends Throwable>, ? extends sma<?>> knaVar) {
        return new n(knaVar);
    }

    public static kna<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static kna<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> jna<qqa<T>> createReplaySupplier(sma<T> smaVar, int i2, long j2, TimeUnit timeUnit, vma vmaVar) {
        return new m(smaVar, i2, j2, timeUnit, vmaVar);
    }

    public static <T> jna<qqa<T>> createReplaySupplier(sma<T> smaVar, long j2, TimeUnit timeUnit, vma vmaVar) {
        return new k(smaVar, j2, timeUnit, vmaVar);
    }
}

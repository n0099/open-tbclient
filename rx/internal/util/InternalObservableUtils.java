package rx.internal.util;

import com.baidu.tieba.gbc;
import com.baidu.tieba.hbc;
import com.baidu.tieba.kbc;
import com.baidu.tieba.lbc;
import com.baidu.tieba.mbc;
import com.baidu.tieba.sac;
import com.baidu.tieba.vac;
import com.baidu.tieba.xec;
import com.baidu.tieba.ybc;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new mbc<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mbc
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new mbc<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.mbc
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
    public static final q TO_ARRAY = new lbc<List<? extends sac<?>>, sac<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public sac<?>[] call(List<? extends sac<?>> list) {
            return (sac[]) list.toArray(new sac[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new mbc<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mbc
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final gbc<Throwable> ERROR_NOT_IMPLEMENTED = new gbc<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gbc
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final sac.b<Boolean, Object> IS_EMPTY = new ybc(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements lbc<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements mbc<R, T, R> {
        public final hbc<R, ? super T> a;

        public a(hbc<R, ? super T> hbcVar) {
            this.a = hbcVar;
        }

        @Override // com.baidu.tieba.mbc
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements lbc<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.lbc
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
    public static final class d implements lbc<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.lbc
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements lbc<sac<? extends Notification<?>>, sac<?>> {
        public final lbc<? super sac<? extends Void>, ? extends sac<?>> a;

        public i(lbc<? super sac<? extends Void>, ? extends sac<?>> lbcVar) {
            this.a = lbcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public sac<?> call(sac<? extends Notification<?>> sacVar) {
            return this.a.call(sacVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements kbc<xec<T>> {
        public final sac<T> a;
        public final int b;

        public j(sac<T> sacVar, int i) {
            this.a = sacVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kbc
        public xec<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements kbc<xec<T>> {
        public final TimeUnit a;
        public final sac<T> b;
        public final long c;
        public final vac d;

        public k(sac<T> sacVar, long j, TimeUnit timeUnit, vac vacVar) {
            this.a = timeUnit;
            this.b = sacVar;
            this.c = j;
            this.d = vacVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kbc
        public xec<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements kbc<xec<T>> {
        public final sac<T> a;

        public l(sac<T> sacVar) {
            this.a = sacVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kbc
        public xec<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements kbc<xec<T>> {
        public final long a;
        public final TimeUnit b;
        public final vac c;
        public final int d;
        public final sac<T> e;

        public m(sac<T> sacVar, int i, long j, TimeUnit timeUnit, vac vacVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = vacVar;
            this.d = i;
            this.e = sacVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kbc
        public xec<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements lbc<sac<? extends Notification<?>>, sac<?>> {
        public final lbc<? super sac<? extends Throwable>, ? extends sac<?>> a;

        public n(lbc<? super sac<? extends Throwable>, ? extends sac<?>> lbcVar) {
            this.a = lbcVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public sac<?> call(sac<? extends Notification<?>> sacVar) {
            return this.a.call(sacVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements lbc<sac<T>, sac<R>> {
        public final lbc<? super sac<T>, ? extends sac<R>> a;
        public final vac b;

        public p(lbc<? super sac<T>, ? extends sac<R>> lbcVar, vac vacVar) {
            this.a = lbcVar;
            this.b = vacVar;
        }

        public sac<R> call(sac<T> sacVar) {
            return this.a.call(sacVar).s(this.b);
        }

        @Override // com.baidu.tieba.lbc
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((sac) ((sac) obj));
        }
    }

    public static <T, R> lbc<sac<T>, sac<R>> createReplaySelectorAndObserveOn(lbc<? super sac<T>, ? extends sac<R>> lbcVar, vac vacVar) {
        return new p(lbcVar, vacVar);
    }

    public static <T> kbc<xec<T>> createReplaySupplier(sac<T> sacVar, int i2) {
        return new j(sacVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements lbc<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lbc
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> mbc<R, T, R> createCollectorCaller(hbc<R, ? super T> hbcVar) {
        return new a(hbcVar);
    }

    public static lbc<sac<? extends Notification<?>>, sac<?>> createRepeatDematerializer(lbc<? super sac<? extends Void>, ? extends sac<?>> lbcVar) {
        return new i(lbcVar);
    }

    public static <T> kbc<xec<T>> createReplaySupplier(sac<T> sacVar) {
        return new l(sacVar);
    }

    public static lbc<sac<? extends Notification<?>>, sac<?>> createRetryDematerializer(lbc<? super sac<? extends Throwable>, ? extends sac<?>> lbcVar) {
        return new n(lbcVar);
    }

    public static lbc<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static lbc<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> kbc<xec<T>> createReplaySupplier(sac<T> sacVar, int i2, long j2, TimeUnit timeUnit, vac vacVar) {
        return new m(sacVar, i2, j2, timeUnit, vacVar);
    }

    public static <T> kbc<xec<T>> createReplaySupplier(sac<T> sacVar, long j2, TimeUnit timeUnit, vac vacVar) {
        return new k(sacVar, j2, timeUnit, vacVar);
    }
}

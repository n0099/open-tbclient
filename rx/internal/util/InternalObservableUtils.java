package rx.internal.util;

import com.baidu.tieba.bnb;
import com.baidu.tieba.cnb;
import com.baidu.tieba.enb;
import com.baidu.tieba.fnb;
import com.baidu.tieba.gnb;
import com.baidu.tieba.nmb;
import com.baidu.tieba.oqb;
import com.baidu.tieba.qmb;
import com.baidu.tieba.snb;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new gnb<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gnb
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new gnb<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.gnb
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
    public static final q TO_ARRAY = new fnb<List<? extends nmb<?>>, nmb<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fnb
        public nmb<?>[] call(List<? extends nmb<?>> list) {
            return (nmb[]) list.toArray(new nmb[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new gnb<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gnb
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final bnb<Throwable> ERROR_NOT_IMPLEMENTED = new bnb<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bnb
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final nmb.b<Boolean, Object> IS_EMPTY = new snb(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements fnb<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fnb
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements gnb<R, T, R> {
        public final cnb<R, ? super T> a;

        public a(cnb<R, ? super T> cnbVar) {
            this.a = cnbVar;
        }

        @Override // com.baidu.tieba.gnb
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements fnb<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.fnb
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
    public static final class d implements fnb<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.fnb
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements fnb<nmb<? extends Notification<?>>, nmb<?>> {
        public final fnb<? super nmb<? extends Void>, ? extends nmb<?>> a;

        public i(fnb<? super nmb<? extends Void>, ? extends nmb<?>> fnbVar) {
            this.a = fnbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fnb
        public nmb<?> call(nmb<? extends Notification<?>> nmbVar) {
            return this.a.call(nmbVar.j(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements enb<oqb<T>> {
        public final nmb<T> a;
        public final int b;

        public j(nmb<T> nmbVar, int i) {
            this.a = nmbVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.enb
        public oqb<T> call() {
            return this.a.r(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements enb<oqb<T>> {
        public final TimeUnit a;
        public final nmb<T> b;
        public final long c;
        public final qmb d;

        public k(nmb<T> nmbVar, long j, TimeUnit timeUnit, qmb qmbVar) {
            this.a = timeUnit;
            this.b = nmbVar;
            this.c = j;
            this.d = qmbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.enb
        public oqb<T> call() {
            return this.b.t(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements enb<oqb<T>> {
        public final nmb<T> a;

        public l(nmb<T> nmbVar) {
            this.a = nmbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.enb
        public oqb<T> call() {
            return this.a.q();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements enb<oqb<T>> {
        public final long a;
        public final TimeUnit b;
        public final qmb c;
        public final int d;
        public final nmb<T> e;

        public m(nmb<T> nmbVar, int i, long j, TimeUnit timeUnit, qmb qmbVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = qmbVar;
            this.d = i;
            this.e = nmbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.enb
        public oqb<T> call() {
            return this.e.s(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements fnb<nmb<? extends Notification<?>>, nmb<?>> {
        public final fnb<? super nmb<? extends Throwable>, ? extends nmb<?>> a;

        public n(fnb<? super nmb<? extends Throwable>, ? extends nmb<?>> fnbVar) {
            this.a = fnbVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fnb
        public nmb<?> call(nmb<? extends Notification<?>> nmbVar) {
            return this.a.call(nmbVar.j(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements fnb<nmb<T>, nmb<R>> {
        public final fnb<? super nmb<T>, ? extends nmb<R>> a;
        public final qmb b;

        public p(fnb<? super nmb<T>, ? extends nmb<R>> fnbVar, qmb qmbVar) {
            this.a = fnbVar;
            this.b = qmbVar;
        }

        public nmb<R> call(nmb<T> nmbVar) {
            return this.a.call(nmbVar).m(this.b);
        }

        @Override // com.baidu.tieba.fnb
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((nmb) ((nmb) obj));
        }
    }

    public static <T, R> fnb<nmb<T>, nmb<R>> createReplaySelectorAndObserveOn(fnb<? super nmb<T>, ? extends nmb<R>> fnbVar, qmb qmbVar) {
        return new p(fnbVar, qmbVar);
    }

    public static <T> enb<oqb<T>> createReplaySupplier(nmb<T> nmbVar, int i2) {
        return new j(nmbVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements fnb<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fnb
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> gnb<R, T, R> createCollectorCaller(cnb<R, ? super T> cnbVar) {
        return new a(cnbVar);
    }

    public static fnb<nmb<? extends Notification<?>>, nmb<?>> createRepeatDematerializer(fnb<? super nmb<? extends Void>, ? extends nmb<?>> fnbVar) {
        return new i(fnbVar);
    }

    public static <T> enb<oqb<T>> createReplaySupplier(nmb<T> nmbVar) {
        return new l(nmbVar);
    }

    public static fnb<nmb<? extends Notification<?>>, nmb<?>> createRetryDematerializer(fnb<? super nmb<? extends Throwable>, ? extends nmb<?>> fnbVar) {
        return new n(fnbVar);
    }

    public static fnb<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static fnb<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> enb<oqb<T>> createReplaySupplier(nmb<T> nmbVar, int i2, long j2, TimeUnit timeUnit, qmb qmbVar) {
        return new m(nmbVar, i2, j2, timeUnit, qmbVar);
    }

    public static <T> enb<oqb<T>> createReplaySupplier(nmb<T> nmbVar, long j2, TimeUnit timeUnit, qmb qmbVar) {
        return new k(nmbVar, j2, timeUnit, qmbVar);
    }
}

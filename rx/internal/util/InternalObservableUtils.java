package rx.internal.util;

import com.baidu.tieba.eoc;
import com.baidu.tieba.hoc;
import com.baidu.tieba.lsc;
import com.baidu.tieba.mpc;
import com.baidu.tieba.soc;
import com.baidu.tieba.toc;
import com.baidu.tieba.woc;
import com.baidu.tieba.xoc;
import com.baidu.tieba.yoc;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new yoc<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yoc
        /* renamed from: b */
        public Long a(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new yoc<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yoc
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
    public static final q TO_ARRAY = new xoc<List<? extends eoc<?>>, eoc<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public eoc<?>[] call(List<? extends eoc<?>> list) {
            return (eoc[]) list.toArray(new eoc[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new yoc<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yoc
        /* renamed from: b */
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final soc<Throwable> ERROR_NOT_IMPLEMENTED = new soc<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        public void a(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.soc
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            a(th);
            throw null;
        }
    };
    public static final eoc.b<Boolean, Object> IS_EMPTY = new mpc(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements xoc<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements yoc<R, T, R> {
        public final toc<R, ? super T> a;

        public a(toc<R, ? super T> tocVar) {
            this.a = tocVar;
        }

        @Override // com.baidu.tieba.yoc
        public R a(R r, T t) {
            this.a.a(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements xoc<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
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
    public static final class d implements xoc<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements xoc<eoc<? extends Notification<?>>, eoc<?>> {
        public final xoc<? super eoc<? extends Void>, ? extends eoc<?>> a;

        public i(xoc<? super eoc<? extends Void>, ? extends eoc<?>> xocVar) {
            this.a = xocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public eoc<?> call(eoc<? extends Notification<?>> eocVar) {
            return this.a.call(eocVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements woc<lsc<T>> {
        public final eoc<T> a;
        public final int b;

        public j(eoc<T> eocVar, int i) {
            this.a = eocVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public lsc<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements woc<lsc<T>> {
        public final TimeUnit a;
        public final eoc<T> b;
        public final long c;
        public final hoc d;

        public k(eoc<T> eocVar, long j, TimeUnit timeUnit, hoc hocVar) {
            this.a = timeUnit;
            this.b = eocVar;
            this.c = j;
            this.d = hocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public lsc<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements woc<lsc<T>> {
        public final eoc<T> a;

        public l(eoc<T> eocVar) {
            this.a = eocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public lsc<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements woc<lsc<T>> {
        public final long a;
        public final TimeUnit b;
        public final hoc c;
        public final int d;
        public final eoc<T> e;

        public m(eoc<T> eocVar, int i, long j, TimeUnit timeUnit, hoc hocVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = hocVar;
            this.d = i;
            this.e = eocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public lsc<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements xoc<eoc<? extends Notification<?>>, eoc<?>> {
        public final xoc<? super eoc<? extends Throwable>, ? extends eoc<?>> a;

        public n(xoc<? super eoc<? extends Throwable>, ? extends eoc<?>> xocVar) {
            this.a = xocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public eoc<?> call(eoc<? extends Notification<?>> eocVar) {
            return this.a.call(eocVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements xoc<eoc<T>, eoc<R>> {
        public final xoc<? super eoc<T>, ? extends eoc<R>> a;
        public final hoc b;

        public p(xoc<? super eoc<T>, ? extends eoc<R>> xocVar, hoc hocVar) {
            this.a = xocVar;
            this.b = hocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public eoc<R> call(eoc<T> eocVar) {
            return this.a.call(eocVar).s(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements xoc<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> xoc<eoc<T>, eoc<R>> createReplaySelectorAndObserveOn(xoc<? super eoc<T>, ? extends eoc<R>> xocVar, hoc hocVar) {
        return new p(xocVar, hocVar);
    }

    public static <T> woc<lsc<T>> createReplaySupplier(eoc<T> eocVar, int i2) {
        return new j(eocVar, i2);
    }

    public static <T, R> yoc<R, T, R> createCollectorCaller(toc<R, ? super T> tocVar) {
        return new a(tocVar);
    }

    public static xoc<eoc<? extends Notification<?>>, eoc<?>> createRepeatDematerializer(xoc<? super eoc<? extends Void>, ? extends eoc<?>> xocVar) {
        return new i(xocVar);
    }

    public static <T> woc<lsc<T>> createReplaySupplier(eoc<T> eocVar) {
        return new l(eocVar);
    }

    public static xoc<eoc<? extends Notification<?>>, eoc<?>> createRetryDematerializer(xoc<? super eoc<? extends Throwable>, ? extends eoc<?>> xocVar) {
        return new n(xocVar);
    }

    public static xoc<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static xoc<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> woc<lsc<T>> createReplaySupplier(eoc<T> eocVar, int i2, long j2, TimeUnit timeUnit, hoc hocVar) {
        return new m(eocVar, i2, j2, timeUnit, hocVar);
    }

    public static <T> woc<lsc<T>> createReplaySupplier(eoc<T> eocVar, long j2, TimeUnit timeUnit, hoc hocVar) {
        return new k(eocVar, j2, timeUnit, hocVar);
    }
}

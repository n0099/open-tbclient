package rx.internal.util;

import com.baidu.tieba.gob;
import com.baidu.tieba.hsb;
import com.baidu.tieba.job;
import com.baidu.tieba.lpb;
import com.baidu.tieba.uob;
import com.baidu.tieba.vob;
import com.baidu.tieba.xob;
import com.baidu.tieba.yob;
import com.baidu.tieba.zob;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new zob<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zob
        public Long call(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new zob<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.zob
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
    public static final q TO_ARRAY = new yob<List<? extends gob<?>>, gob<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yob
        public gob<?>[] call(List<? extends gob<?>> list) {
            return (gob[]) list.toArray(new gob[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new zob<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zob
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final uob<Throwable> ERROR_NOT_IMPLEMENTED = new uob<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uob
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final gob.b<Boolean, Object> IS_EMPTY = new lpb(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements yob<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yob
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements zob<R, T, R> {
        public final vob<R, ? super T> a;

        public a(vob<R, ? super T> vobVar) {
            this.a = vobVar;
        }

        @Override // com.baidu.tieba.zob
        public R call(R r, T t) {
            this.a.call(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements yob<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.yob
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
    public static final class d implements yob<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.yob
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements yob<gob<? extends Notification<?>>, gob<?>> {
        public final yob<? super gob<? extends Void>, ? extends gob<?>> a;

        public i(yob<? super gob<? extends Void>, ? extends gob<?>> yobVar) {
            this.a = yobVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yob
        public gob<?> call(gob<? extends Notification<?>> gobVar) {
            return this.a.call(gobVar.j(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements xob<hsb<T>> {
        public final gob<T> a;
        public final int b;

        public j(gob<T> gobVar, int i) {
            this.a = gobVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xob
        public hsb<T> call() {
            return this.a.r(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements xob<hsb<T>> {
        public final TimeUnit a;
        public final gob<T> b;
        public final long c;
        public final job d;

        public k(gob<T> gobVar, long j, TimeUnit timeUnit, job jobVar) {
            this.a = timeUnit;
            this.b = gobVar;
            this.c = j;
            this.d = jobVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xob
        public hsb<T> call() {
            return this.b.t(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements xob<hsb<T>> {
        public final gob<T> a;

        public l(gob<T> gobVar) {
            this.a = gobVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xob
        public hsb<T> call() {
            return this.a.q();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements xob<hsb<T>> {
        public final long a;
        public final TimeUnit b;
        public final job c;
        public final int d;
        public final gob<T> e;

        public m(gob<T> gobVar, int i, long j, TimeUnit timeUnit, job jobVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = jobVar;
            this.d = i;
            this.e = gobVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xob
        public hsb<T> call() {
            return this.e.s(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements yob<gob<? extends Notification<?>>, gob<?>> {
        public final yob<? super gob<? extends Throwable>, ? extends gob<?>> a;

        public n(yob<? super gob<? extends Throwable>, ? extends gob<?>> yobVar) {
            this.a = yobVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yob
        public gob<?> call(gob<? extends Notification<?>> gobVar) {
            return this.a.call(gobVar.j(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements yob<gob<T>, gob<R>> {
        public final yob<? super gob<T>, ? extends gob<R>> a;
        public final job b;

        public p(yob<? super gob<T>, ? extends gob<R>> yobVar, job jobVar) {
            this.a = yobVar;
            this.b = jobVar;
        }

        public gob<R> call(gob<T> gobVar) {
            return this.a.call(gobVar).m(this.b);
        }

        @Override // com.baidu.tieba.yob
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((gob) ((gob) obj));
        }
    }

    public static <T, R> yob<gob<T>, gob<R>> createReplaySelectorAndObserveOn(yob<? super gob<T>, ? extends gob<R>> yobVar, job jobVar) {
        return new p(yobVar, jobVar);
    }

    public static <T> xob<hsb<T>> createReplaySupplier(gob<T> gobVar, int i2) {
        return new j(gobVar, i2);
    }

    /* loaded from: classes2.dex */
    public static final class e implements yob<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yob
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> zob<R, T, R> createCollectorCaller(vob<R, ? super T> vobVar) {
        return new a(vobVar);
    }

    public static yob<gob<? extends Notification<?>>, gob<?>> createRepeatDematerializer(yob<? super gob<? extends Void>, ? extends gob<?>> yobVar) {
        return new i(yobVar);
    }

    public static <T> xob<hsb<T>> createReplaySupplier(gob<T> gobVar) {
        return new l(gobVar);
    }

    public static yob<gob<? extends Notification<?>>, gob<?>> createRetryDematerializer(yob<? super gob<? extends Throwable>, ? extends gob<?>> yobVar) {
        return new n(yobVar);
    }

    public static yob<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static yob<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> xob<hsb<T>> createReplaySupplier(gob<T> gobVar, int i2, long j2, TimeUnit timeUnit, job jobVar) {
        return new m(gobVar, i2, j2, timeUnit, jobVar);
    }

    public static <T> xob<hsb<T>> createReplaySupplier(gob<T> gobVar, long j2, TimeUnit timeUnit, job jobVar) {
        return new k(gobVar, j2, timeUnit, jobVar);
    }
}

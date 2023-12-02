package rx.internal.util;

import com.baidu.tieba.doc;
import com.baidu.tieba.goc;
import com.baidu.tieba.ksc;
import com.baidu.tieba.lpc;
import com.baidu.tieba.roc;
import com.baidu.tieba.soc;
import com.baidu.tieba.voc;
import com.baidu.tieba.woc;
import com.baidu.tieba.xoc;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes2.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new xoc<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: b */
        public Long a(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new xoc<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
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
    public static final q TO_ARRAY = new woc<List<? extends doc<?>>, doc<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public doc<?>[] call(List<? extends doc<?>> list) {
            return (doc[]) list.toArray(new doc[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new xoc<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xoc
        /* renamed from: b */
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final roc<Throwable> ERROR_NOT_IMPLEMENTED = new roc<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        public void a(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.roc
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            a(th);
            throw null;
        }
    };
    public static final doc.b<Boolean, Object> IS_EMPTY = new lpc(UtilityFunctions.a(), true);

    /* loaded from: classes2.dex */
    public static final class o implements woc<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T, R> implements xoc<R, T, R> {
        public final soc<R, ? super T> a;

        public a(soc<R, ? super T> socVar) {
            this.a = socVar;
        }

        @Override // com.baidu.tieba.xoc
        public R a(R r, T t) {
            this.a.a(r, t);
            return r;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements woc<Object, Boolean> {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
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
    public static final class d implements woc<Object, Boolean> {
        public final Class<?> a;

        public d(Class<?> cls) {
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.a.isInstance(obj));
        }
    }

    /* loaded from: classes2.dex */
    public static final class i implements woc<doc<? extends Notification<?>>, doc<?>> {
        public final woc<? super doc<? extends Void>, ? extends doc<?>> a;

        public i(woc<? super doc<? extends Void>, ? extends doc<?>> wocVar) {
            this.a = wocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public doc<?> call(doc<? extends Notification<?>> docVar) {
            return this.a.call(docVar.p(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes2.dex */
    public static final class j<T> implements voc<ksc<T>> {
        public final doc<T> a;
        public final int b;

        public j(doc<T> docVar, int i) {
            this.a = docVar;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.voc
        /* renamed from: a */
        public ksc<T> call() {
            return this.a.z(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class k<T> implements voc<ksc<T>> {
        public final TimeUnit a;
        public final doc<T> b;
        public final long c;
        public final goc d;

        public k(doc<T> docVar, long j, TimeUnit timeUnit, goc gocVar) {
            this.a = timeUnit;
            this.b = docVar;
            this.c = j;
            this.d = gocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.voc
        /* renamed from: a */
        public ksc<T> call() {
            return this.b.B(this.c, this.a, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public static final class l<T> implements voc<ksc<T>> {
        public final doc<T> a;

        public l(doc<T> docVar) {
            this.a = docVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.voc
        /* renamed from: a */
        public ksc<T> call() {
            return this.a.y();
        }
    }

    /* loaded from: classes2.dex */
    public static final class m<T> implements voc<ksc<T>> {
        public final long a;
        public final TimeUnit b;
        public final goc c;
        public final int d;
        public final doc<T> e;

        public m(doc<T> docVar, int i, long j, TimeUnit timeUnit, goc gocVar) {
            this.a = j;
            this.b = timeUnit;
            this.c = gocVar;
            this.d = i;
            this.e = docVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.voc
        /* renamed from: a */
        public ksc<T> call() {
            return this.e.A(this.d, this.a, this.b, this.c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n implements woc<doc<? extends Notification<?>>, doc<?>> {
        public final woc<? super doc<? extends Throwable>, ? extends doc<?>> a;

        public n(woc<? super doc<? extends Throwable>, ? extends doc<?>> wocVar) {
            this.a = wocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public doc<?> call(doc<? extends Notification<?>> docVar) {
            return this.a.call(docVar.p(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes2.dex */
    public static final class p<T, R> implements woc<doc<T>, doc<R>> {
        public final woc<? super doc<T>, ? extends doc<R>> a;
        public final goc b;

        public p(woc<? super doc<T>, ? extends doc<R>> wocVar, goc gocVar) {
            this.a = wocVar;
            this.b = gocVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public doc<R> call(doc<T> docVar) {
            return this.a.call(docVar).s(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements woc<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.woc
        /* renamed from: a */
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    public static <T, R> woc<doc<T>, doc<R>> createReplaySelectorAndObserveOn(woc<? super doc<T>, ? extends doc<R>> wocVar, goc gocVar) {
        return new p(wocVar, gocVar);
    }

    public static <T> voc<ksc<T>> createReplaySupplier(doc<T> docVar, int i2) {
        return new j(docVar, i2);
    }

    public static <T, R> xoc<R, T, R> createCollectorCaller(soc<R, ? super T> socVar) {
        return new a(socVar);
    }

    public static woc<doc<? extends Notification<?>>, doc<?>> createRepeatDematerializer(woc<? super doc<? extends Void>, ? extends doc<?>> wocVar) {
        return new i(wocVar);
    }

    public static <T> voc<ksc<T>> createReplaySupplier(doc<T> docVar) {
        return new l(docVar);
    }

    public static woc<doc<? extends Notification<?>>, doc<?>> createRetryDematerializer(woc<? super doc<? extends Throwable>, ? extends doc<?>> wocVar) {
        return new n(wocVar);
    }

    public static woc<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static woc<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> voc<ksc<T>> createReplaySupplier(doc<T> docVar, int i2, long j2, TimeUnit timeUnit, goc gocVar) {
        return new m(docVar, i2, j2, timeUnit, gocVar);
    }

    public static <T> voc<ksc<T>> createReplaySupplier(doc<T> docVar, long j2, TimeUnit timeUnit, goc gocVar) {
        return new k(docVar, j2, timeUnit, gocVar);
    }
}

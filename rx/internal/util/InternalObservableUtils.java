package rx.internal.util;

import h.d;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes7.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new h.n.g<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.g
        /* renamed from: b */
        public Long a(Long l2, Object obj) {
            return Long.valueOf(l2.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new h.n.g<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.g
        /* renamed from: b */
        public Boolean a(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    };
    public static final q TO_ARRAY = new h.n.f<List<? extends h.d<?>>, h.d<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?>[] call(List<? extends h.d<?>> list) {
            return (h.d[]) list.toArray(new h.d[list.size()]);
        }
    };
    public static final o RETURNS_VOID = new o();
    public static final g COUNTER = new h.n.g<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.g
        /* renamed from: b */
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    public static final e ERROR_EXTRACTOR = new e();
    public static final h.n.b<Throwable> ERROR_NOT_IMPLEMENTED = new h.n.b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        public void a(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.n.b
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            a(th);
            throw null;
        }
    };
    public static final d.b<Boolean, Object> IS_EMPTY = new h.o.a.k(UtilityFunctions.a(), true);

    /* loaded from: classes7.dex */
    public static final class a<T, R> implements h.n.g<R, T, R> {

        /* renamed from: a  reason: collision with root package name */
        public final h.n.c<R, ? super T> f68240a;

        public a(h.n.c<R, ? super T> cVar) {
            this.f68240a = cVar;
        }

        @Override // h.n.g
        public R a(R r, T t) {
            this.f68240a.a(r, t);
            return r;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements h.n.f<Object, Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final Object f68241e;

        public b(Object obj) {
            this.f68241e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(Object obj) {
            Object obj2 = this.f68241e;
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements h.n.f<Object, Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final Class<?> f68242e;

        public d(Class<?> cls) {
            this.f68242e = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.f68242e.isInstance(obj));
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements h.n.f<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    /* loaded from: classes7.dex */
    public static final class i implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.f<? super h.d<? extends Void>, ? extends h.d<?>> f68243e;

        public i(h.n.f<? super h.d<? extends Void>, ? extends h.d<?>> fVar) {
            this.f68243e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            return this.f68243e.call(dVar.l(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes7.dex */
    public static final class j<T> implements h.n.e<h.p.a<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.d<T> f68244e;

        /* renamed from: f  reason: collision with root package name */
        public final int f68245f;

        public j(h.d<T> dVar, int i) {
            this.f68244e = dVar;
            this.f68245f = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            return this.f68244e.v(this.f68245f);
        }
    }

    /* loaded from: classes7.dex */
    public static final class k<T> implements h.n.e<h.p.a<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f68246e;

        /* renamed from: f  reason: collision with root package name */
        public final h.d<T> f68247f;

        /* renamed from: g  reason: collision with root package name */
        public final long f68248g;

        /* renamed from: h  reason: collision with root package name */
        public final h.g f68249h;

        public k(h.d<T> dVar, long j, TimeUnit timeUnit, h.g gVar) {
            this.f68246e = timeUnit;
            this.f68247f = dVar;
            this.f68248g = j;
            this.f68249h = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            return this.f68247f.x(this.f68248g, this.f68246e, this.f68249h);
        }
    }

    /* loaded from: classes7.dex */
    public static final class l<T> implements h.n.e<h.p.a<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.d<T> f68250e;

        public l(h.d<T> dVar) {
            this.f68250e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            return this.f68250e.u();
        }
    }

    /* loaded from: classes7.dex */
    public static final class m<T> implements h.n.e<h.p.a<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final long f68251e;

        /* renamed from: f  reason: collision with root package name */
        public final TimeUnit f68252f;

        /* renamed from: g  reason: collision with root package name */
        public final h.g f68253g;

        /* renamed from: h  reason: collision with root package name */
        public final int f68254h;
        public final h.d<T> i;

        public m(h.d<T> dVar, int i, long j, TimeUnit timeUnit, h.g gVar) {
            this.f68251e = j;
            this.f68252f = timeUnit;
            this.f68253g = gVar;
            this.f68254h = i;
            this.i = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            return this.i.w(this.f68254h, this.f68251e, this.f68252f, this.f68253g);
        }
    }

    /* loaded from: classes7.dex */
    public static final class n implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.f<? super h.d<? extends Throwable>, ? extends h.d<?>> f68255e;

        public n(h.n.f<? super h.d<? extends Throwable>, ? extends h.d<?>> fVar) {
            this.f68255e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            return this.f68255e.call(dVar.l(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes7.dex */
    public static final class o implements h.n.f<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class p<T, R> implements h.n.f<h.d<T>, h.d<R>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.f<? super h.d<T>, ? extends h.d<R>> f68256e;

        /* renamed from: f  reason: collision with root package name */
        public final h.g f68257f;

        public p(h.n.f<? super h.d<T>, ? extends h.d<R>> fVar, h.g gVar) {
            this.f68256e = fVar;
            this.f68257f = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<R> call(h.d<T> dVar) {
            return this.f68256e.call(dVar).p(this.f68257f);
        }
    }

    public static <T, R> h.n.g<R, T, R> createCollectorCaller(h.n.c<R, ? super T> cVar) {
        return new a(cVar);
    }

    public static h.n.f<h.d<? extends Notification<?>>, h.d<?>> createRepeatDematerializer(h.n.f<? super h.d<? extends Void>, ? extends h.d<?>> fVar) {
        return new i(fVar);
    }

    public static <T, R> h.n.f<h.d<T>, h.d<R>> createReplaySelectorAndObserveOn(h.n.f<? super h.d<T>, ? extends h.d<R>> fVar, h.g gVar) {
        return new p(fVar, gVar);
    }

    public static <T> h.n.e<h.p.a<T>> createReplaySupplier(h.d<T> dVar) {
        return new l(dVar);
    }

    public static h.n.f<h.d<? extends Notification<?>>, h.d<?>> createRetryDematerializer(h.n.f<? super h.d<? extends Throwable>, ? extends h.d<?>> fVar) {
        return new n(fVar);
    }

    public static h.n.f<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static h.n.f<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> h.n.e<h.p.a<T>> createReplaySupplier(h.d<T> dVar, int i2) {
        return new j(dVar, i2);
    }

    public static <T> h.n.e<h.p.a<T>> createReplaySupplier(h.d<T> dVar, long j2, TimeUnit timeUnit, h.g gVar) {
        return new k(dVar, j2, timeUnit, gVar);
    }

    public static <T> h.n.e<h.p.a<T>> createReplaySupplier(h.d<T> dVar, int i2, long j2, TimeUnit timeUnit, h.g gVar) {
        return new m(dVar, i2, j2, timeUnit, gVar);
    }
}

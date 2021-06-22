package rx.internal.util;

import h.d;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static final class a<T, R> implements h.n.g<R, T, R> {

        /* renamed from: a  reason: collision with root package name */
        public final h.n.c<R, ? super T> f72574a;

        public a(h.n.c<R, ? super T> cVar) {
            this.f72574a = cVar;
        }

        @Override // h.n.g
        public R a(R r, T t) {
            this.f72574a.a(r, t);
            return r;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements h.n.f<Object, Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final Object f72575e;

        public b(Object obj) {
            this.f72575e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(Object obj) {
            Object obj2 = this.f72575e;
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements h.n.f<Object, Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final Class<?> f72576e;

        public d(Class<?> cls) {
            this.f72576e = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.f72576e.isInstance(obj));
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements h.n.f<Notification<?>, Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    /* loaded from: classes8.dex */
    public static final class i implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.f<? super h.d<? extends Void>, ? extends h.d<?>> f72577e;

        public i(h.n.f<? super h.d<? extends Void>, ? extends h.d<?>> fVar) {
            this.f72577e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            return this.f72577e.call(dVar.k(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes8.dex */
    public static final class j<T> implements h.n.e<h.p.a<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.d<T> f72578e;

        /* renamed from: f  reason: collision with root package name */
        public final int f72579f;

        public j(h.d<T> dVar, int i2) {
            this.f72578e = dVar;
            this.f72579f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            return this.f72578e.u(this.f72579f);
        }
    }

    /* loaded from: classes8.dex */
    public static final class k<T> implements h.n.e<h.p.a<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f72580e;

        /* renamed from: f  reason: collision with root package name */
        public final h.d<T> f72581f;

        /* renamed from: g  reason: collision with root package name */
        public final long f72582g;

        /* renamed from: h  reason: collision with root package name */
        public final h.g f72583h;

        public k(h.d<T> dVar, long j, TimeUnit timeUnit, h.g gVar) {
            this.f72580e = timeUnit;
            this.f72581f = dVar;
            this.f72582g = j;
            this.f72583h = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            return this.f72581f.w(this.f72582g, this.f72580e, this.f72583h);
        }
    }

    /* loaded from: classes8.dex */
    public static final class l<T> implements h.n.e<h.p.a<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.d<T> f72584e;

        public l(h.d<T> dVar) {
            this.f72584e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            return this.f72584e.t();
        }
    }

    /* loaded from: classes8.dex */
    public static final class m<T> implements h.n.e<h.p.a<T>> {

        /* renamed from: e  reason: collision with root package name */
        public final long f72585e;

        /* renamed from: f  reason: collision with root package name */
        public final TimeUnit f72586f;

        /* renamed from: g  reason: collision with root package name */
        public final h.g f72587g;

        /* renamed from: h  reason: collision with root package name */
        public final int f72588h;

        /* renamed from: i  reason: collision with root package name */
        public final h.d<T> f72589i;

        public m(h.d<T> dVar, int i2, long j, TimeUnit timeUnit, h.g gVar) {
            this.f72585e = j;
            this.f72586f = timeUnit;
            this.f72587g = gVar;
            this.f72588h = i2;
            this.f72589i = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            return this.f72589i.v(this.f72588h, this.f72585e, this.f72586f, this.f72587g);
        }
    }

    /* loaded from: classes8.dex */
    public static final class n implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.f<? super h.d<? extends Throwable>, ? extends h.d<?>> f72590e;

        public n(h.n.f<? super h.d<? extends Throwable>, ? extends h.d<?>> fVar) {
            this.f72590e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            return this.f72590e.call(dVar.k(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* loaded from: classes8.dex */
    public static final class o implements h.n.f<Object, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public static final class p<T, R> implements h.n.f<h.d<T>, h.d<R>> {

        /* renamed from: e  reason: collision with root package name */
        public final h.n.f<? super h.d<T>, ? extends h.d<R>> f72591e;

        /* renamed from: f  reason: collision with root package name */
        public final h.g f72592f;

        public p(h.n.f<? super h.d<T>, ? extends h.d<R>> fVar, h.g gVar) {
            this.f72591e = fVar;
            this.f72592f = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<R> call(h.d<T> dVar) {
            return this.f72591e.call(dVar).o(this.f72592f);
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

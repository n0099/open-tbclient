package rx.internal.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class InternalObservableUtils {
    public static final /* synthetic */ InternalObservableUtils[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final g COUNTER;
    public static final e ERROR_EXTRACTOR;
    public static final h.n.b<Throwable> ERROR_NOT_IMPLEMENTED;
    public static final d.b<Boolean, Object> IS_EMPTY;
    public static final h LONG_COUNTER;
    public static final f OBJECT_EQUALS;
    public static final o RETURNS_VOID;
    public static final q TO_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class a<T, R> implements h.n.g<R, T, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final h.n.c<R, ? super T> f76244a;

        public a(h.n.c<R, ? super T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76244a = cVar;
        }

        @Override // h.n.g
        public R a(R r, T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, r, t)) == null) {
                this.f76244a.a(r, t);
                return r;
            }
            return (R) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class b implements h.n.f<Object, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Object f76245e;

        public b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76245e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                Object obj2 = this.f76245e;
                return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class d implements h.n.f<Object, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Class<?> f76246e;

        public d(Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76246e = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Boolean call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? Boolean.valueOf(this.f76246e.isInstance(obj)) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class e implements h.n.f<Notification<?>, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Throwable call(Notification<?> notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, notification)) == null) ? notification.e() : (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class i implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.n.f<? super h.d<? extends Void>, ? extends h.d<?>> f76247e;

        public i(h.n.f<? super h.d<? extends Void>, ? extends h.d<?>> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76247e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? this.f76247e.call(dVar.k(InternalObservableUtils.RETURNS_VOID)) : (h.d) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class j<T> implements h.n.e<h.p.a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.d<T> f76248e;

        /* renamed from: f  reason: collision with root package name */
        public final int f76249f;

        public j(h.d<T> dVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76248e = dVar;
            this.f76249f = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f76248e.u(this.f76249f) : (h.p.a) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class k<T> implements h.n.e<h.p.a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f76250e;

        /* renamed from: f  reason: collision with root package name */
        public final h.d<T> f76251f;

        /* renamed from: g  reason: collision with root package name */
        public final long f76252g;

        /* renamed from: h  reason: collision with root package name */
        public final h.g f76253h;

        public k(h.d<T> dVar, long j, TimeUnit timeUnit, h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j), timeUnit, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76250e = timeUnit;
            this.f76251f = dVar;
            this.f76252g = j;
            this.f76253h = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f76251f.w(this.f76252g, this.f76250e, this.f76253h) : (h.p.a) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class l<T> implements h.n.e<h.p.a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.d<T> f76254e;

        public l(h.d<T> dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76254e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f76254e.t() : (h.p.a) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class m<T> implements h.n.e<h.p.a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final long f76255e;

        /* renamed from: f  reason: collision with root package name */
        public final TimeUnit f76256f;

        /* renamed from: g  reason: collision with root package name */
        public final h.g f76257g;

        /* renamed from: h  reason: collision with root package name */
        public final int f76258h;

        /* renamed from: i  reason: collision with root package name */
        public final h.d<T> f76259i;

        public m(h.d<T> dVar, int i2, long j, TimeUnit timeUnit, h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2), Long.valueOf(j), timeUnit, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76255e = j;
            this.f76256f = timeUnit;
            this.f76257g = gVar;
            this.f76258h = i2;
            this.f76259i = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.e
        /* renamed from: a */
        public h.p.a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f76259i.v(this.f76258h, this.f76255e, this.f76256f, this.f76257g) : (h.p.a) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class n implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.n.f<? super h.d<? extends Throwable>, ? extends h.d<?>> f76260e;

        public n(h.n.f<? super h.d<? extends Throwable>, ? extends h.d<?>> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76260e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? this.f76260e.call(dVar.k(InternalObservableUtils.ERROR_EXTRACTOR)) : (h.d) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class o implements h.n.f<Object, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public Void call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class p<T, R> implements h.n.f<h.d<T>, h.d<R>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.n.f<? super h.d<T>, ? extends h.d<R>> f76261e;

        /* renamed from: f  reason: collision with root package name */
        public final h.g f76262f;

        public p(h.n.f<? super h.d<T>, ? extends h.d<R>> fVar, h.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f76261e = fVar;
            this.f76262f = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<R> call(h.d<T> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? this.f76261e.call(dVar).o(this.f76262f) : (h.d) invokeL.objValue;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [rx.internal.util.InternalObservableUtils$h] */
    /* JADX WARN: Type inference failed for: r0v4, types: [rx.internal.util.InternalObservableUtils$f] */
    /* JADX WARN: Type inference failed for: r0v5, types: [rx.internal.util.InternalObservableUtils$q] */
    /* JADX WARN: Type inference failed for: r0v7, types: [rx.internal.util.InternalObservableUtils$g] */
    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2129760126, "Lrx/internal/util/InternalObservableUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2129760126, "Lrx/internal/util/InternalObservableUtils;");
                return;
            }
        }
        $VALUES = new InternalObservableUtils[0];
        LONG_COUNTER = new h.n.g<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.g
            /* renamed from: b */
            public Long a(Long l2, Object obj) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l2, obj)) == null) ? Long.valueOf(l2.longValue() + 1) : (Long) invokeLL.objValue;
            }
        };
        OBJECT_EQUALS = new h.n.g<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.g
            /* renamed from: b */
            public Boolean a(Object obj, Object obj2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, obj2)) == null) {
                    return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
                }
                return (Boolean) invokeLL.objValue;
            }
        };
        TO_ARRAY = new h.n.f<List<? extends h.d<?>>, h.d<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.f
            /* renamed from: a */
            public h.d<?>[] call(List<? extends h.d<?>> list) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, list)) == null) ? (h.d[]) list.toArray(new h.d[list.size()]) : (h.d[]) invokeL.objValue;
            }
        };
        RETURNS_VOID = new o();
        COUNTER = new h.n.g<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.g
            /* renamed from: b */
            public Integer a(Integer num, Object obj) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num, obj)) == null) ? Integer.valueOf(num.intValue() + 1) : (Integer) invokeLL.objValue;
            }
        };
        ERROR_EXTRACTOR = new e();
        ERROR_NOT_IMPLEMENTED = new h.n.b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public void a(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) {
                    throw new OnErrorNotImplementedException(th);
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // h.n.b
            public /* bridge */ /* synthetic */ void call(Throwable th) {
                a(th);
                throw null;
            }
        };
        IS_EMPTY = new h.o.a.k(UtilityFunctions.a(), true);
    }

    public InternalObservableUtils(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <T, R> h.n.g<R, T, R> createCollectorCaller(h.n.c<R, ? super T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new a(cVar) : (h.n.g) invokeL.objValue;
    }

    public static h.n.f<h.d<? extends Notification<?>>, h.d<?>> createRepeatDematerializer(h.n.f<? super h.d<? extends Void>, ? extends h.d<?>> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fVar)) == null) ? new i(fVar) : (h.n.f) invokeL.objValue;
    }

    public static <T, R> h.n.f<h.d<T>, h.d<R>> createReplaySelectorAndObserveOn(h.n.f<? super h.d<T>, ? extends h.d<R>> fVar, h.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, fVar, gVar)) == null) ? new p(fVar, gVar) : (h.n.f) invokeLL.objValue;
    }

    public static <T> h.n.e<h.p.a<T>> createReplaySupplier(h.d<T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar)) == null) ? new l(dVar) : (h.n.e) invokeL.objValue;
    }

    public static h.n.f<h.d<? extends Notification<?>>, h.d<?>> createRetryDematerializer(h.n.f<? super h.d<? extends Throwable>, ? extends h.d<?>> fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fVar)) == null) ? new n(fVar) : (h.n.f) invokeL.objValue;
    }

    public static h.n.f<Object, Boolean> equalsWith(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) ? new b(obj) : (h.n.f) invokeL.objValue;
    }

    public static h.n.f<Object, Boolean> isInstanceOf(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cls)) == null) ? new d(cls) : (h.n.f) invokeL.objValue;
    }

    public static InternalObservableUtils valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? (InternalObservableUtils) Enum.valueOf(InternalObservableUtils.class, str) : (InternalObservableUtils) invokeL.objValue;
    }

    public static InternalObservableUtils[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? (InternalObservableUtils[]) $VALUES.clone() : (InternalObservableUtils[]) invokeV.objValue;
    }

    public static <T> h.n.e<h.p.a<T>> createReplaySupplier(h.d<T> dVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, dVar, i2)) == null) ? new j(dVar, i2) : (h.n.e) invokeLI.objValue;
    }

    public static <T> h.n.e<h.p.a<T>> createReplaySupplier(h.d<T> dVar, long j2, TimeUnit timeUnit, h.g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{dVar, Long.valueOf(j2), timeUnit, gVar})) == null) ? new k(dVar, j2, timeUnit, gVar) : (h.n.e) invokeCommon.objValue;
    }

    public static <T> h.n.e<h.p.a<T>> createReplaySupplier(h.d<T> dVar, int i2, long j2, TimeUnit timeUnit, h.g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{dVar, Integer.valueOf(i2), Long.valueOf(j2), timeUnit, gVar})) == null) ? new m(dVar, i2, j2, timeUnit, gVar) : (h.n.e) invokeCommon.objValue;
    }
}

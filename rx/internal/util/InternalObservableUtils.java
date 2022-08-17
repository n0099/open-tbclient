package rx.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fv9;
import com.repackage.gv9;
import com.repackage.iv9;
import com.repackage.jv9;
import com.repackage.kv9;
import com.repackage.py9;
import com.repackage.ru9;
import com.repackage.uu9;
import com.repackage.uv9;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class InternalObservableUtils {
    public static final /* synthetic */ InternalObservableUtils[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final g COUNTER;
    public static final e ERROR_EXTRACTOR;
    public static final fv9<Throwable> ERROR_NOT_IMPLEMENTED;
    public static final ru9.b<Boolean, Object> IS_EMPTY;
    public static final h LONG_COUNTER;
    public static final f OBJECT_EQUALS;
    public static final o RETURNS_VOID;
    public static final q TO_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a<T, R> implements kv9<R, T, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final gv9<R, ? super T> a;

        public a(gv9<R, ? super T> gv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gv9Var;
        }

        @Override // com.repackage.kv9
        public R call(R r, T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, r, t)) == null) {
                this.a.call(r, t);
                return r;
            }
            return (R) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements jv9<Object, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object a;

        public b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.jv9
        public Boolean call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                Object obj2 = this.a;
                return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements jv9<Object, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<?> a;

        public d(Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cls;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.jv9
        public Boolean call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? Boolean.valueOf(this.a.isInstance(obj)) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class e implements jv9<Notification<?>, Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jv9
        public Throwable call(Notification<?> notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification)) == null) ? notification.e() : (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class i implements jv9<ru9<? extends Notification<?>>, ru9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jv9<? super ru9<? extends Void>, ? extends ru9<?>> a;

        public i(jv9<? super ru9<? extends Void>, ? extends ru9<?>> jv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jv9
        public ru9<?> call(ru9<? extends Notification<?>> ru9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ru9Var)) == null) ? this.a.call(ru9Var.h(InternalObservableUtils.RETURNS_VOID)) : (ru9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class j<T> implements iv9<py9<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ru9<T> a;
        public final int b;

        public j(ru9<T> ru9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ru9Var;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iv9
        public py9<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.p(this.b) : (py9) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class k<T> implements iv9<py9<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TimeUnit a;
        public final ru9<T> b;
        public final long c;
        public final uu9 d;

        public k(ru9<T> ru9Var, long j, TimeUnit timeUnit, uu9 uu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru9Var, Long.valueOf(j), timeUnit, uu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = timeUnit;
            this.b = ru9Var;
            this.c = j;
            this.d = uu9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iv9
        public py9<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.r(this.c, this.a, this.d) : (py9) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class l<T> implements iv9<py9<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ru9<T> a;

        public l(ru9<T> ru9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ru9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iv9
        public py9<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.o() : (py9) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class m<T> implements iv9<py9<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;
        public final TimeUnit b;
        public final uu9 c;
        public final int d;
        public final ru9<T> e;

        public m(ru9<T> ru9Var, int i, long j, TimeUnit timeUnit, uu9 uu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ru9Var, Integer.valueOf(i), Long.valueOf(j), timeUnit, uu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = timeUnit;
            this.c = uu9Var;
            this.d = i;
            this.e = ru9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iv9
        public py9<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e.q(this.d, this.a, this.b, this.c) : (py9) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class n implements jv9<ru9<? extends Notification<?>>, ru9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jv9<? super ru9<? extends Throwable>, ? extends ru9<?>> a;

        public n(jv9<? super ru9<? extends Throwable>, ? extends ru9<?>> jv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jv9
        public ru9<?> call(ru9<? extends Notification<?>> ru9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ru9Var)) == null) ? this.a.call(ru9Var.h(InternalObservableUtils.ERROR_EXTRACTOR)) : (ru9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class o implements jv9<Object, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jv9
        public Void call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class p<T, R> implements jv9<ru9<T>, ru9<R>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jv9<? super ru9<T>, ? extends ru9<R>> a;
        public final uu9 b;

        public p(jv9<? super ru9<T>, ? extends ru9<R>> jv9Var, uu9 uu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jv9Var, uu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jv9Var;
            this.b = uu9Var;
        }

        @Override // com.repackage.jv9
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((ru9) ((ru9) obj));
        }

        public ru9<R> call(ru9<T> ru9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ru9Var)) == null) ? this.a.call(ru9Var).k(this.b) : (ru9) invokeL.objValue;
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
        LONG_COUNTER = new kv9<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
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
            @Override // com.repackage.kv9
            public Long call(Long l2, Object obj) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, l2, obj)) == null) ? Long.valueOf(l2.longValue() + 1) : (Long) invokeLL.objValue;
            }
        };
        OBJECT_EQUALS = new kv9<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
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
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.repackage.kv9
            public Boolean call(Object obj, Object obj2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) {
                    return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
                }
                return (Boolean) invokeLL.objValue;
            }
        };
        TO_ARRAY = new jv9<List<? extends ru9<?>>, ru9<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
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
            @Override // com.repackage.jv9
            public ru9<?>[] call(List<? extends ru9<?>> list) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) ? (ru9[]) list.toArray(new ru9[list.size()]) : (ru9[]) invokeL.objValue;
            }
        };
        RETURNS_VOID = new o();
        COUNTER = new kv9<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
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
            @Override // com.repackage.kv9
            public Integer call(Integer num, Object obj) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, num, obj)) == null) ? Integer.valueOf(num.intValue() + 1) : (Integer) invokeLL.objValue;
            }
        };
        ERROR_EXTRACTOR = new e();
        ERROR_NOT_IMPLEMENTED = new fv9<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
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
            @Override // com.repackage.fv9
            public void call(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    throw new OnErrorNotImplementedException(th);
                }
            }
        };
        IS_EMPTY = new uv9(UtilityFunctions.a(), true);
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

    public static <T, R> kv9<R, T, R> createCollectorCaller(gv9<R, ? super T> gv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gv9Var)) == null) ? new a(gv9Var) : (kv9) invokeL.objValue;
    }

    public static jv9<ru9<? extends Notification<?>>, ru9<?>> createRepeatDematerializer(jv9<? super ru9<? extends Void>, ? extends ru9<?>> jv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jv9Var)) == null) ? new i(jv9Var) : (jv9) invokeL.objValue;
    }

    public static <T, R> jv9<ru9<T>, ru9<R>> createReplaySelectorAndObserveOn(jv9<? super ru9<T>, ? extends ru9<R>> jv9Var, uu9 uu9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jv9Var, uu9Var)) == null) ? new p(jv9Var, uu9Var) : (jv9) invokeLL.objValue;
    }

    public static <T> iv9<py9<T>> createReplaySupplier(ru9<T> ru9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, ru9Var)) == null) ? new l(ru9Var) : (iv9) invokeL.objValue;
    }

    public static jv9<ru9<? extends Notification<?>>, ru9<?>> createRetryDematerializer(jv9<? super ru9<? extends Throwable>, ? extends ru9<?>> jv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jv9Var)) == null) ? new n(jv9Var) : (jv9) invokeL.objValue;
    }

    public static jv9<Object, Boolean> equalsWith(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) ? new b(obj) : (jv9) invokeL.objValue;
    }

    public static jv9<Object, Boolean> isInstanceOf(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cls)) == null) ? new d(cls) : (jv9) invokeL.objValue;
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

    public static <T> iv9<py9<T>> createReplaySupplier(ru9<T> ru9Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, ru9Var, i2)) == null) ? new j(ru9Var, i2) : (iv9) invokeLI.objValue;
    }

    public static <T> iv9<py9<T>> createReplaySupplier(ru9<T> ru9Var, long j2, TimeUnit timeUnit, uu9 uu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{ru9Var, Long.valueOf(j2), timeUnit, uu9Var})) == null) ? new k(ru9Var, j2, timeUnit, uu9Var) : (iv9) invokeCommon.objValue;
    }

    public static <T> iv9<py9<T>> createReplaySupplier(ru9<T> ru9Var, int i2, long j2, TimeUnit timeUnit, uu9 uu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{ru9Var, Integer.valueOf(i2), Long.valueOf(j2), timeUnit, uu9Var})) == null) ? new m(ru9Var, i2, j2, timeUnit, uu9Var) : (iv9) invokeCommon.objValue;
    }
}

package rx.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e3a;
import com.baidu.tieba.gz9;
import com.baidu.tieba.j0a;
import com.baidu.tieba.jz9;
import com.baidu.tieba.uz9;
import com.baidu.tieba.vz9;
import com.baidu.tieba.xz9;
import com.baidu.tieba.yz9;
import com.baidu.tieba.zz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.exceptions.OnErrorNotImplementedException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class InternalObservableUtils {
    public static final /* synthetic */ InternalObservableUtils[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final g COUNTER;
    public static final e ERROR_EXTRACTOR;
    public static final uz9<Throwable> ERROR_NOT_IMPLEMENTED;
    public static final gz9.b<Boolean, Object> IS_EMPTY;
    public static final h LONG_COUNTER;
    public static final f OBJECT_EQUALS;
    public static final o RETURNS_VOID;
    public static final q TO_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a<T, R> implements zz9<R, T, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final vz9<R, ? super T> a;

        public a(vz9<R, ? super T> vz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz9Var;
        }

        @Override // com.baidu.tieba.zz9
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

    /* loaded from: classes9.dex */
    public static final class b implements yz9<Object, Boolean> {
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
        @Override // com.baidu.tieba.yz9
        public Boolean call(Object obj) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                Object obj2 = this.a;
                if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                    z = false;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class d implements yz9<Object, Boolean> {
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
        @Override // com.baidu.tieba.yz9
        public Boolean call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return Boolean.valueOf(this.a.isInstance(obj));
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class e implements yz9<Notification<?>, Throwable> {
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
        @Override // com.baidu.tieba.yz9
        public Throwable call(Notification<?> notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification)) == null) {
                return notification.e();
            }
            return (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class i implements yz9<gz9<? extends Notification<?>>, gz9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final yz9<? super gz9<? extends Void>, ? extends gz9<?>> a;

        public i(yz9<? super gz9<? extends Void>, ? extends gz9<?>> yz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public gz9<?> call(gz9<? extends Notification<?>> gz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gz9Var)) == null) {
                return this.a.call(gz9Var.h(InternalObservableUtils.RETURNS_VOID));
            }
            return (gz9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class j<T> implements xz9<e3a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final gz9<T> a;
        public final int b;

        public j(gz9<T> gz9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz9Var;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xz9
        public e3a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.p(this.b);
            }
            return (e3a) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class k<T> implements xz9<e3a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TimeUnit a;
        public final gz9<T> b;
        public final long c;
        public final jz9 d;

        public k(gz9<T> gz9Var, long j, TimeUnit timeUnit, jz9 jz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz9Var, Long.valueOf(j), timeUnit, jz9Var};
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
            this.b = gz9Var;
            this.c = j;
            this.d = jz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xz9
        public e3a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b.r(this.c, this.a, this.d);
            }
            return (e3a) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class l<T> implements xz9<e3a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final gz9<T> a;

        public l(gz9<T> gz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xz9
        public e3a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.o();
            }
            return (e3a) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class m<T> implements xz9<e3a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;
        public final TimeUnit b;
        public final jz9 c;
        public final int d;
        public final gz9<T> e;

        public m(gz9<T> gz9Var, int i, long j, TimeUnit timeUnit, jz9 jz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz9Var, Integer.valueOf(i), Long.valueOf(j), timeUnit, jz9Var};
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
            this.c = jz9Var;
            this.d = i;
            this.e = gz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xz9
        public e3a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e.q(this.d, this.a, this.b, this.c);
            }
            return (e3a) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class n implements yz9<gz9<? extends Notification<?>>, gz9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final yz9<? super gz9<? extends Throwable>, ? extends gz9<?>> a;

        public n(yz9<? super gz9<? extends Throwable>, ? extends gz9<?>> yz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public gz9<?> call(gz9<? extends Notification<?>> gz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gz9Var)) == null) {
                return this.a.call(gz9Var.h(InternalObservableUtils.ERROR_EXTRACTOR));
            }
            return (gz9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class o implements yz9<Object, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yz9
        public Void call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return null;
            }
            return (Void) invokeL.objValue;
        }

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
    }

    /* loaded from: classes9.dex */
    public static final class p<T, R> implements yz9<gz9<T>, gz9<R>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final yz9<? super gz9<T>, ? extends gz9<R>> a;
        public final jz9 b;

        public p(yz9<? super gz9<T>, ? extends gz9<R>> yz9Var, jz9 jz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz9Var, jz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz9Var;
            this.b = jz9Var;
        }

        public gz9<R> call(gz9<T> gz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gz9Var)) == null) {
                return this.a.call(gz9Var).k(this.b);
            }
            return (gz9) invokeL.objValue;
        }

        @Override // com.baidu.tieba.yz9
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((gz9) ((gz9) obj));
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
        LONG_COUNTER = new zz9<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
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
            @Override // com.baidu.tieba.zz9
            public Long call(Long l2, Object obj) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, l2, obj)) == null) {
                    return Long.valueOf(l2.longValue() + 1);
                }
                return (Long) invokeLL.objValue;
            }
        };
        OBJECT_EQUALS = new zz9<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
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
            @Override // com.baidu.tieba.zz9
            public Boolean call(Object obj, Object obj2) {
                InterceptResult invokeLL;
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) {
                    if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
                return (Boolean) invokeLL.objValue;
            }
        };
        TO_ARRAY = new yz9<List<? extends gz9<?>>, gz9<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
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
            @Override // com.baidu.tieba.yz9
            public gz9<?>[] call(List<? extends gz9<?>> list) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                    return (gz9[]) list.toArray(new gz9[list.size()]);
                }
                return (gz9[]) invokeL.objValue;
            }
        };
        RETURNS_VOID = new o();
        COUNTER = new zz9<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
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
            @Override // com.baidu.tieba.zz9
            public Integer call(Integer num, Object obj) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, num, obj)) == null) {
                    return Integer.valueOf(num.intValue() + 1);
                }
                return (Integer) invokeLL.objValue;
            }
        };
        ERROR_EXTRACTOR = new e();
        ERROR_NOT_IMPLEMENTED = new uz9<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
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
            @Override // com.baidu.tieba.uz9
            public void call(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    throw new OnErrorNotImplementedException(th);
                }
            }
        };
        IS_EMPTY = new j0a(UtilityFunctions.a(), true);
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

    public static <T, R> zz9<R, T, R> createCollectorCaller(vz9<R, ? super T> vz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, vz9Var)) == null) {
            return new a(vz9Var);
        }
        return (zz9) invokeL.objValue;
    }

    public static yz9<gz9<? extends Notification<?>>, gz9<?>> createRepeatDematerializer(yz9<? super gz9<? extends Void>, ? extends gz9<?>> yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yz9Var)) == null) {
            return new i(yz9Var);
        }
        return (yz9) invokeL.objValue;
    }

    public static <T> xz9<e3a<T>> createReplaySupplier(gz9<T> gz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, gz9Var)) == null) {
            return new l(gz9Var);
        }
        return (xz9) invokeL.objValue;
    }

    public static yz9<gz9<? extends Notification<?>>, gz9<?>> createRetryDematerializer(yz9<? super gz9<? extends Throwable>, ? extends gz9<?>> yz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, yz9Var)) == null) {
            return new n(yz9Var);
        }
        return (yz9) invokeL.objValue;
    }

    public static yz9<Object, Boolean> equalsWith(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) {
            return new b(obj);
        }
        return (yz9) invokeL.objValue;
    }

    public static yz9<Object, Boolean> isInstanceOf(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cls)) == null) {
            return new d(cls);
        }
        return (yz9) invokeL.objValue;
    }

    public static InternalObservableUtils valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            return (InternalObservableUtils) Enum.valueOf(InternalObservableUtils.class, str);
        }
        return (InternalObservableUtils) invokeL.objValue;
    }

    public static <T, R> yz9<gz9<T>, gz9<R>> createReplaySelectorAndObserveOn(yz9<? super gz9<T>, ? extends gz9<R>> yz9Var, jz9 jz9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, yz9Var, jz9Var)) == null) {
            return new p(yz9Var, jz9Var);
        }
        return (yz9) invokeLL.objValue;
    }

    public static <T> xz9<e3a<T>> createReplaySupplier(gz9<T> gz9Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, gz9Var, i2)) == null) {
            return new j(gz9Var, i2);
        }
        return (xz9) invokeLI.objValue;
    }

    public static <T> xz9<e3a<T>> createReplaySupplier(gz9<T> gz9Var, int i2, long j2, TimeUnit timeUnit, jz9 jz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{gz9Var, Integer.valueOf(i2), Long.valueOf(j2), timeUnit, jz9Var})) == null) {
            return new m(gz9Var, i2, j2, timeUnit, jz9Var);
        }
        return (xz9) invokeCommon.objValue;
    }

    public static <T> xz9<e3a<T>> createReplaySupplier(gz9<T> gz9Var, long j2, TimeUnit timeUnit, jz9 jz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{gz9Var, Long.valueOf(j2), timeUnit, jz9Var})) == null) {
            return new k(gz9Var, j2, timeUnit, jz9Var);
        }
        return (xz9) invokeCommon.objValue;
    }

    public static InternalObservableUtils[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return (InternalObservableUtils[]) $VALUES.clone();
        }
        return (InternalObservableUtils[]) invokeV.objValue;
    }
}

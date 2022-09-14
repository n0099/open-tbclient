package rx.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ex9;
import com.baidu.tieba.fx9;
import com.baidu.tieba.hx9;
import com.baidu.tieba.ix9;
import com.baidu.tieba.jx9;
import com.baidu.tieba.o0a;
import com.baidu.tieba.qw9;
import com.baidu.tieba.tw9;
import com.baidu.tieba.tx9;
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
    public static final ex9<Throwable> ERROR_NOT_IMPLEMENTED;
    public static final qw9.b<Boolean, Object> IS_EMPTY;
    public static final h LONG_COUNTER;
    public static final f OBJECT_EQUALS;
    public static final o RETURNS_VOID;
    public static final q TO_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a<T, R> implements jx9<R, T, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final fx9<R, ? super T> a;

        public a(fx9<R, ? super T> fx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fx9Var;
        }

        @Override // com.baidu.tieba.jx9
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
    public static final class b implements ix9<Object, Boolean> {
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
        @Override // com.baidu.tieba.ix9
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

    /* loaded from: classes9.dex */
    public static final class d implements ix9<Object, Boolean> {
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
        @Override // com.baidu.tieba.ix9
        public Boolean call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? Boolean.valueOf(this.a.isInstance(obj)) : (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class e implements ix9<Notification<?>, Throwable> {
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
        @Override // com.baidu.tieba.ix9
        public Throwable call(Notification<?> notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, notification)) == null) ? notification.e() : (Throwable) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class i implements ix9<qw9<? extends Notification<?>>, qw9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ix9<? super qw9<? extends Void>, ? extends qw9<?>> a;

        public i(ix9<? super qw9<? extends Void>, ? extends qw9<?>> ix9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ix9
        public qw9<?> call(qw9<? extends Notification<?>> qw9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qw9Var)) == null) ? this.a.call(qw9Var.h(InternalObservableUtils.RETURNS_VOID)) : (qw9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class j<T> implements hx9<o0a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final qw9<T> a;
        public final int b;

        public j(qw9<T> qw9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qw9Var;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hx9
        public o0a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.p(this.b) : (o0a) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class k<T> implements hx9<o0a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TimeUnit a;
        public final qw9<T> b;
        public final long c;
        public final tw9 d;

        public k(qw9<T> qw9Var, long j, TimeUnit timeUnit, tw9 tw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw9Var, Long.valueOf(j), timeUnit, tw9Var};
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
            this.b = qw9Var;
            this.c = j;
            this.d = tw9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hx9
        public o0a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.r(this.c, this.a, this.d) : (o0a) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class l<T> implements hx9<o0a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final qw9<T> a;

        public l(qw9<T> qw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qw9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hx9
        public o0a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.o() : (o0a) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class m<T> implements hx9<o0a<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;
        public final TimeUnit b;
        public final tw9 c;
        public final int d;
        public final qw9<T> e;

        public m(qw9<T> qw9Var, int i, long j, TimeUnit timeUnit, tw9 tw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw9Var, Integer.valueOf(i), Long.valueOf(j), timeUnit, tw9Var};
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
            this.c = tw9Var;
            this.d = i;
            this.e = qw9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hx9
        public o0a<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e.q(this.d, this.a, this.b, this.c) : (o0a) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class n implements ix9<qw9<? extends Notification<?>>, qw9<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ix9<? super qw9<? extends Throwable>, ? extends qw9<?>> a;

        public n(ix9<? super qw9<? extends Throwable>, ? extends qw9<?>> ix9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ix9
        public qw9<?> call(qw9<? extends Notification<?>> qw9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qw9Var)) == null) ? this.a.call(qw9Var.h(InternalObservableUtils.ERROR_EXTRACTOR)) : (qw9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class o implements ix9<Object, Void> {
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
        @Override // com.baidu.tieba.ix9
        public Void call(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class p<T, R> implements ix9<qw9<T>, qw9<R>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ix9<? super qw9<T>, ? extends qw9<R>> a;
        public final tw9 b;

        public p(ix9<? super qw9<T>, ? extends qw9<R>> ix9Var, tw9 tw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix9Var, tw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix9Var;
            this.b = tw9Var;
        }

        @Override // com.baidu.tieba.ix9
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((qw9) ((qw9) obj));
        }

        public qw9<R> call(qw9<T> qw9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qw9Var)) == null) ? this.a.call(qw9Var).k(this.b) : (qw9) invokeL.objValue;
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
        LONG_COUNTER = new jx9<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
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
            @Override // com.baidu.tieba.jx9
            public Long call(Long l2, Object obj) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, l2, obj)) == null) ? Long.valueOf(l2.longValue() + 1) : (Long) invokeLL.objValue;
            }
        };
        OBJECT_EQUALS = new jx9<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
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
            @Override // com.baidu.tieba.jx9
            public Boolean call(Object obj, Object obj2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) {
                    return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
                }
                return (Boolean) invokeLL.objValue;
            }
        };
        TO_ARRAY = new ix9<List<? extends qw9<?>>, qw9<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
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
            @Override // com.baidu.tieba.ix9
            public qw9<?>[] call(List<? extends qw9<?>> list) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) ? (qw9[]) list.toArray(new qw9[list.size()]) : (qw9[]) invokeL.objValue;
            }
        };
        RETURNS_VOID = new o();
        COUNTER = new jx9<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
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
            @Override // com.baidu.tieba.jx9
            public Integer call(Integer num, Object obj) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, num, obj)) == null) ? Integer.valueOf(num.intValue() + 1) : (Integer) invokeLL.objValue;
            }
        };
        ERROR_EXTRACTOR = new e();
        ERROR_NOT_IMPLEMENTED = new ex9<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
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
            @Override // com.baidu.tieba.ex9
            public void call(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    throw new OnErrorNotImplementedException(th);
                }
            }
        };
        IS_EMPTY = new tx9(UtilityFunctions.a(), true);
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

    public static <T, R> jx9<R, T, R> createCollectorCaller(fx9<R, ? super T> fx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fx9Var)) == null) ? new a(fx9Var) : (jx9) invokeL.objValue;
    }

    public static ix9<qw9<? extends Notification<?>>, qw9<?>> createRepeatDematerializer(ix9<? super qw9<? extends Void>, ? extends qw9<?>> ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ix9Var)) == null) ? new i(ix9Var) : (ix9) invokeL.objValue;
    }

    public static <T, R> ix9<qw9<T>, qw9<R>> createReplaySelectorAndObserveOn(ix9<? super qw9<T>, ? extends qw9<R>> ix9Var, tw9 tw9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ix9Var, tw9Var)) == null) ? new p(ix9Var, tw9Var) : (ix9) invokeLL.objValue;
    }

    public static <T> hx9<o0a<T>> createReplaySupplier(qw9<T> qw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, qw9Var)) == null) ? new l(qw9Var) : (hx9) invokeL.objValue;
    }

    public static ix9<qw9<? extends Notification<?>>, qw9<?>> createRetryDematerializer(ix9<? super qw9<? extends Throwable>, ? extends qw9<?>> ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ix9Var)) == null) ? new n(ix9Var) : (ix9) invokeL.objValue;
    }

    public static ix9<Object, Boolean> equalsWith(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) ? new b(obj) : (ix9) invokeL.objValue;
    }

    public static ix9<Object, Boolean> isInstanceOf(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cls)) == null) ? new d(cls) : (ix9) invokeL.objValue;
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

    public static <T> hx9<o0a<T>> createReplaySupplier(qw9<T> qw9Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, qw9Var, i2)) == null) ? new j(qw9Var, i2) : (hx9) invokeLI.objValue;
    }

    public static <T> hx9<o0a<T>> createReplaySupplier(qw9<T> qw9Var, long j2, TimeUnit timeUnit, tw9 tw9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{qw9Var, Long.valueOf(j2), timeUnit, tw9Var})) == null) ? new k(qw9Var, j2, timeUnit, tw9Var) : (hx9) invokeCommon.objValue;
    }

    public static <T> hx9<o0a<T>> createReplaySupplier(qw9<T> qw9Var, int i2, long j2, TimeUnit timeUnit, tw9 tw9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{qw9Var, Integer.valueOf(i2), Long.valueOf(j2), timeUnit, tw9Var})) == null) ? new m(qw9Var, i2, j2, timeUnit, tw9Var) : (hx9) invokeCommon.objValue;
    }
}

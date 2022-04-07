package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class yy9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes7.dex */
    public class a extends zy9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz9 b;
        public final /* synthetic */ iz9 c;

        public a(yy9 yy9Var, iz9 iz9Var, iz9 iz9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy9Var, iz9Var, iz9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iz9Var;
            this.c = iz9Var2;
        }

        @Override // com.repackage.zy9
        public final void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.b.call(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // com.repackage.zy9
        public final void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements iz9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz9 a;

        public b(yy9 yy9Var, iz9 iz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yy9Var, iz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.iz9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c<T> extends iz9<zy9<? super T>> {
        @Override // com.repackage.iz9
        /* synthetic */ void call(T t);
    }

    public yy9(c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c3a.i(cVar);
    }

    public static <T> uy9<T> a(yy9<T> yy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yy9Var)) == null) ? uy9.a(new n0a(yy9Var.a)) : (uy9) invokeL.objValue;
    }

    public static <T> yy9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new yy9<>(cVar) : (yy9) invokeL.objValue;
    }

    public static <T> yy9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? f1a.m(t) : (yy9) invokeL.objValue;
    }

    public final yy9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (yy9) invokeJL.objValue;
    }

    public final yy9<T> d(long j, TimeUnit timeUnit, xy9 xy9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, xy9Var})) == null) ? b(new i0a(this.a, j, timeUnit, xy9Var)) : (yy9) invokeCommon.objValue;
    }

    public final yy9<T> e(iz9<Throwable> iz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iz9Var)) == null) {
            if (iz9Var != null) {
                return b(new j0a(this, Actions.a(), new b(this, iz9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (yy9) invokeL.objValue;
    }

    public final yy9<T> f(iz9<? super T> iz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iz9Var)) == null) {
            if (iz9Var != null) {
                return b(new j0a(this, iz9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (yy9) invokeL.objValue;
    }

    public final yy9<T> h(xy9 xy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xy9Var)) == null) {
            if (this instanceof f1a) {
                return ((f1a) this).n(xy9Var);
            }
            if (xy9Var != null) {
                return b(new m0a(this.a, xy9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (yy9) invokeL.objValue;
    }

    public final bz9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (bz9) invokeV.objValue;
    }

    public final bz9 j(zy9<? super T> zy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zy9Var)) == null) {
            if (zy9Var != null) {
                try {
                    c3a.t(this, this.a).call(zy9Var);
                    return c3a.s(zy9Var);
                } catch (Throwable th) {
                    gz9.e(th);
                    try {
                        zy9Var.b(c3a.r(th));
                        return s3a.b();
                    } catch (Throwable th2) {
                        gz9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        c3a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (bz9) invokeL.objValue;
    }

    public final bz9 k(iz9<? super T> iz9Var, iz9<Throwable> iz9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, iz9Var, iz9Var2)) == null) {
            if (iz9Var != null) {
                if (iz9Var2 != null) {
                    return j(new a(this, iz9Var2, iz9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (bz9) invokeLL.objValue;
    }

    public final uy9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (uy9) invokeV.objValue;
    }
}

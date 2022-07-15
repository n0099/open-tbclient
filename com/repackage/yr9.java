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
public class yr9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes7.dex */
    public class a extends zr9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ is9 b;
        public final /* synthetic */ is9 c;

        public a(yr9 yr9Var, is9 is9Var, is9 is9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr9Var, is9Var, is9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = is9Var;
            this.c = is9Var2;
        }

        @Override // com.repackage.zr9
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

        @Override // com.repackage.zr9
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
    public class b implements is9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ is9 a;

        public b(yr9 yr9Var, is9 is9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr9Var, is9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = is9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.is9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c<T> extends is9<zr9<? super T>> {
        @Override // com.repackage.is9
        /* synthetic */ void call(T t);
    }

    public yr9(c<T> cVar) {
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
        this.a = bw9.i(cVar);
    }

    public static <T> ur9<T> a(yr9<T> yr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yr9Var)) == null) ? ur9.a(new mt9(yr9Var.a)) : (ur9) invokeL.objValue;
    }

    public static <T> yr9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new yr9<>(cVar) : (yr9) invokeL.objValue;
    }

    public static <T> yr9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? eu9.m(t) : (yr9) invokeL.objValue;
    }

    public final yr9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (yr9) invokeJL.objValue;
    }

    public final yr9<T> d(long j, TimeUnit timeUnit, xr9 xr9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, xr9Var})) == null) ? b(new ht9(this.a, j, timeUnit, xr9Var)) : (yr9) invokeCommon.objValue;
    }

    public final yr9<T> e(is9<Throwable> is9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, is9Var)) == null) {
            if (is9Var != null) {
                return b(new it9(this, Actions.a(), new b(this, is9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (yr9) invokeL.objValue;
    }

    public final yr9<T> f(is9<? super T> is9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, is9Var)) == null) {
            if (is9Var != null) {
                return b(new it9(this, is9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (yr9) invokeL.objValue;
    }

    public final yr9<T> h(xr9 xr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xr9Var)) == null) {
            if (this instanceof eu9) {
                return ((eu9) this).n(xr9Var);
            }
            if (xr9Var != null) {
                return b(new lt9(this.a, xr9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (yr9) invokeL.objValue;
    }

    public final bs9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (bs9) invokeV.objValue;
    }

    public final bs9 j(zr9<? super T> zr9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, zr9Var)) == null) {
            if (zr9Var != null) {
                try {
                    bw9.t(this, this.a).call(zr9Var);
                    return bw9.s(zr9Var);
                } catch (Throwable th) {
                    gs9.e(th);
                    try {
                        zr9Var.b(bw9.r(th));
                        return rw9.b();
                    } catch (Throwable th2) {
                        gs9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        bw9.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (bs9) invokeL.objValue;
    }

    public final bs9 k(is9<? super T> is9Var, is9<Throwable> is9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, is9Var, is9Var2)) == null) {
            if (is9Var != null) {
                if (is9Var2 != null) {
                    return j(new a(this, is9Var2, is9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (bs9) invokeLL.objValue;
    }

    public final ur9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (ur9) invokeV.objValue;
    }
}

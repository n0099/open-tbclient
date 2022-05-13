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
/* loaded from: classes5.dex */
public class ay9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes5.dex */
    public class a extends by9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky9 b;
        public final /* synthetic */ ky9 c;

        public a(ay9 ay9Var, ky9 ky9Var, ky9 ky9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay9Var, ky9Var, ky9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky9Var;
            this.c = ky9Var2;
        }

        @Override // com.repackage.by9
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

        @Override // com.repackage.by9
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

    /* loaded from: classes5.dex */
    public class b implements ky9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky9 a;

        public b(ay9 ay9Var, ky9 ky9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay9Var, ky9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ky9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c<T> extends ky9<by9<? super T>> {
        @Override // com.repackage.ky9
        /* synthetic */ void call(T t);
    }

    public ay9(c<T> cVar) {
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
        this.a = d2a.i(cVar);
    }

    public static <T> wx9<T> a(ay9<T> ay9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ay9Var)) == null) ? wx9.a(new oz9(ay9Var.a)) : (wx9) invokeL.objValue;
    }

    public static <T> ay9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new ay9<>(cVar) : (ay9) invokeL.objValue;
    }

    public static <T> ay9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? g0a.m(t) : (ay9) invokeL.objValue;
    }

    public final ay9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (ay9) invokeJL.objValue;
    }

    public final ay9<T> d(long j, TimeUnit timeUnit, zx9 zx9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, zx9Var})) == null) ? b(new jz9(this.a, j, timeUnit, zx9Var)) : (ay9) invokeCommon.objValue;
    }

    public final ay9<T> e(ky9<Throwable> ky9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ky9Var)) == null) {
            if (ky9Var != null) {
                return b(new kz9(this, Actions.a(), new b(this, ky9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (ay9) invokeL.objValue;
    }

    public final ay9<T> f(ky9<? super T> ky9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ky9Var)) == null) {
            if (ky9Var != null) {
                return b(new kz9(this, ky9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (ay9) invokeL.objValue;
    }

    public final ay9<T> h(zx9 zx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zx9Var)) == null) {
            if (this instanceof g0a) {
                return ((g0a) this).n(zx9Var);
            }
            if (zx9Var != null) {
                return b(new nz9(this.a, zx9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (ay9) invokeL.objValue;
    }

    public final dy9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (dy9) invokeV.objValue;
    }

    public final dy9 j(by9<? super T> by9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, by9Var)) == null) {
            if (by9Var != null) {
                try {
                    d2a.t(this, this.a).call(by9Var);
                    return d2a.s(by9Var);
                } catch (Throwable th) {
                    iy9.e(th);
                    try {
                        by9Var.b(d2a.r(th));
                        return t2a.b();
                    } catch (Throwable th2) {
                        iy9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        d2a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (dy9) invokeL.objValue;
    }

    public final dy9 k(ky9<? super T> ky9Var, ky9<Throwable> ky9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, ky9Var, ky9Var2)) == null) {
            if (ky9Var != null) {
                if (ky9Var2 != null) {
                    return j(new a(this, ky9Var2, ky9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (dy9) invokeLL.objValue;
    }

    public final wx9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (wx9) invokeV.objValue;
    }
}

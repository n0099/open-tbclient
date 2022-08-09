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
public class tu9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes7.dex */
    public class a extends uu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv9 b;
        public final /* synthetic */ dv9 c;

        public a(tu9 tu9Var, dv9 dv9Var, dv9 dv9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu9Var, dv9Var, dv9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dv9Var;
            this.c = dv9Var2;
        }

        @Override // com.repackage.uu9
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

        @Override // com.repackage.uu9
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
    public class b implements dv9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv9 a;

        public b(tu9 tu9Var, dv9 dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu9Var, dv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.dv9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c<T> extends dv9<uu9<? super T>> {
        @Override // com.repackage.dv9
        /* synthetic */ void call(T t);
    }

    public tu9(c<T> cVar) {
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
        this.a = wy9.i(cVar);
    }

    public static <T> pu9<T> a(tu9<T> tu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tu9Var)) == null) ? pu9.a(new hw9(tu9Var.a)) : (pu9) invokeL.objValue;
    }

    public static <T> tu9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new tu9<>(cVar) : (tu9) invokeL.objValue;
    }

    public static <T> tu9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? zw9.m(t) : (tu9) invokeL.objValue;
    }

    public final tu9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (tu9) invokeJL.objValue;
    }

    public final tu9<T> d(long j, TimeUnit timeUnit, su9 su9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, su9Var})) == null) ? b(new cw9(this.a, j, timeUnit, su9Var)) : (tu9) invokeCommon.objValue;
    }

    public final tu9<T> e(dv9<Throwable> dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dv9Var)) == null) {
            if (dv9Var != null) {
                return b(new dw9(this, Actions.a(), new b(this, dv9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (tu9) invokeL.objValue;
    }

    public final tu9<T> f(dv9<? super T> dv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dv9Var)) == null) {
            if (dv9Var != null) {
                return b(new dw9(this, dv9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (tu9) invokeL.objValue;
    }

    public final tu9<T> h(su9 su9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, su9Var)) == null) {
            if (this instanceof zw9) {
                return ((zw9) this).n(su9Var);
            }
            if (su9Var != null) {
                return b(new gw9(this.a, su9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (tu9) invokeL.objValue;
    }

    public final wu9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (wu9) invokeV.objValue;
    }

    public final wu9 j(uu9<? super T> uu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uu9Var)) == null) {
            if (uu9Var != null) {
                try {
                    wy9.t(this, this.a).call(uu9Var);
                    return wy9.s(uu9Var);
                } catch (Throwable th) {
                    bv9.e(th);
                    try {
                        uu9Var.b(wy9.r(th));
                        return mz9.b();
                    } catch (Throwable th2) {
                        bv9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        wy9.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (wu9) invokeL.objValue;
    }

    public final wu9 k(dv9<? super T> dv9Var, dv9<Throwable> dv9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, dv9Var, dv9Var2)) == null) {
            if (dv9Var != null) {
                if (dv9Var2 != null) {
                    return j(new a(this, dv9Var2, dv9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (wu9) invokeLL.objValue;
    }

    public final pu9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (pu9) invokeV.objValue;
    }
}

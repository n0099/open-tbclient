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
public class bv9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes5.dex */
    public class a extends cv9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv9 b;
        public final /* synthetic */ lv9 c;

        public a(bv9 bv9Var, lv9 lv9Var, lv9 lv9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv9Var, lv9Var, lv9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lv9Var;
            this.c = lv9Var2;
        }

        @Override // com.repackage.cv9
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

        @Override // com.repackage.cv9
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
    public class b implements lv9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv9 a;

        public b(bv9 bv9Var, lv9 lv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv9Var, lv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.lv9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c<T> extends lv9<cv9<? super T>> {
        @Override // com.repackage.lv9
        /* synthetic */ void call(T t);
    }

    public bv9(c<T> cVar) {
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
        this.a = ez9.i(cVar);
    }

    public static <T> xu9<T> a(bv9<T> bv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bv9Var)) == null) ? xu9.a(new pw9(bv9Var.a)) : (xu9) invokeL.objValue;
    }

    public static <T> bv9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new bv9<>(cVar) : (bv9) invokeL.objValue;
    }

    public static <T> bv9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? hx9.m(t) : (bv9) invokeL.objValue;
    }

    public final bv9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (bv9) invokeJL.objValue;
    }

    public final bv9<T> d(long j, TimeUnit timeUnit, av9 av9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, av9Var})) == null) ? b(new kw9(this.a, j, timeUnit, av9Var)) : (bv9) invokeCommon.objValue;
    }

    public final bv9<T> e(lv9<Throwable> lv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lv9Var)) == null) {
            if (lv9Var != null) {
                return b(new lw9(this, Actions.a(), new b(this, lv9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (bv9) invokeL.objValue;
    }

    public final bv9<T> f(lv9<? super T> lv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lv9Var)) == null) {
            if (lv9Var != null) {
                return b(new lw9(this, lv9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (bv9) invokeL.objValue;
    }

    public final bv9<T> h(av9 av9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, av9Var)) == null) {
            if (this instanceof hx9) {
                return ((hx9) this).n(av9Var);
            }
            if (av9Var != null) {
                return b(new ow9(this.a, av9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (bv9) invokeL.objValue;
    }

    public final ev9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (ev9) invokeV.objValue;
    }

    public final ev9 j(cv9<? super T> cv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cv9Var)) == null) {
            if (cv9Var != null) {
                try {
                    ez9.t(this, this.a).call(cv9Var);
                    return ez9.s(cv9Var);
                } catch (Throwable th) {
                    jv9.e(th);
                    try {
                        cv9Var.b(ez9.r(th));
                        return uz9.b();
                    } catch (Throwable th2) {
                        jv9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        ez9.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (ev9) invokeL.objValue;
    }

    public final ev9 k(lv9<? super T> lv9Var, lv9<Throwable> lv9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, lv9Var, lv9Var2)) == null) {
            if (lv9Var != null) {
                if (lv9Var2 != null) {
                    return j(new a(this, lv9Var2, lv9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (ev9) invokeLL.objValue;
    }

    public final xu9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (xu9) invokeV.objValue;
    }
}

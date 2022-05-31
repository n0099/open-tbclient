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
public class uu9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes7.dex */
    public class a extends vu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ev9 b;
        public final /* synthetic */ ev9 c;

        public a(uu9 uu9Var, ev9 ev9Var, ev9 ev9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu9Var, ev9Var, ev9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ev9Var;
            this.c = ev9Var2;
        }

        @Override // com.repackage.vu9
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

        @Override // com.repackage.vu9
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
    public class b implements ev9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ev9 a;

        public b(uu9 uu9Var, ev9 ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uu9Var, ev9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ev9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ev9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c<T> extends ev9<vu9<? super T>> {
        @Override // com.repackage.ev9
        /* synthetic */ void call(T t);
    }

    public uu9(c<T> cVar) {
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
        this.a = xy9.i(cVar);
    }

    public static <T> qu9<T> a(uu9<T> uu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uu9Var)) == null) ? qu9.a(new iw9(uu9Var.a)) : (qu9) invokeL.objValue;
    }

    public static <T> uu9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new uu9<>(cVar) : (uu9) invokeL.objValue;
    }

    public static <T> uu9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? ax9.m(t) : (uu9) invokeL.objValue;
    }

    public final uu9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (uu9) invokeJL.objValue;
    }

    public final uu9<T> d(long j, TimeUnit timeUnit, tu9 tu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, tu9Var})) == null) ? b(new dw9(this.a, j, timeUnit, tu9Var)) : (uu9) invokeCommon.objValue;
    }

    public final uu9<T> e(ev9<Throwable> ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ev9Var)) == null) {
            if (ev9Var != null) {
                return b(new ew9(this, Actions.a(), new b(this, ev9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (uu9) invokeL.objValue;
    }

    public final uu9<T> f(ev9<? super T> ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ev9Var)) == null) {
            if (ev9Var != null) {
                return b(new ew9(this, ev9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (uu9) invokeL.objValue;
    }

    public final uu9<T> h(tu9 tu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tu9Var)) == null) {
            if (this instanceof ax9) {
                return ((ax9) this).n(tu9Var);
            }
            if (tu9Var != null) {
                return b(new hw9(this.a, tu9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (uu9) invokeL.objValue;
    }

    public final xu9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (xu9) invokeV.objValue;
    }

    public final xu9 j(vu9<? super T> vu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vu9Var)) == null) {
            if (vu9Var != null) {
                try {
                    xy9.t(this, this.a).call(vu9Var);
                    return xy9.s(vu9Var);
                } catch (Throwable th) {
                    cv9.e(th);
                    try {
                        vu9Var.b(xy9.r(th));
                        return nz9.b();
                    } catch (Throwable th2) {
                        cv9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        xy9.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (xu9) invokeL.objValue;
    }

    public final xu9 k(ev9<? super T> ev9Var, ev9<Throwable> ev9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, ev9Var, ev9Var2)) == null) {
            if (ev9Var != null) {
                if (ev9Var2 != null) {
                    return j(new a(this, ev9Var2, ev9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (xu9) invokeLL.objValue;
    }

    public final qu9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (qu9) invokeV.objValue;
    }
}

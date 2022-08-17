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
public class vu9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes7.dex */
    public class a extends wu9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv9 b;
        public final /* synthetic */ fv9 c;

        public a(vu9 vu9Var, fv9 fv9Var, fv9 fv9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu9Var, fv9Var, fv9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fv9Var;
            this.c = fv9Var2;
        }

        @Override // com.repackage.wu9
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

        @Override // com.repackage.wu9
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
    public class b implements fv9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv9 a;

        public b(vu9 vu9Var, fv9 fv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu9Var, fv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fv9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c<T> extends fv9<wu9<? super T>> {
        @Override // com.repackage.fv9
        /* synthetic */ void call(T t);
    }

    public vu9(c<T> cVar) {
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
        this.a = yy9.i(cVar);
    }

    public static <T> ru9<T> a(vu9<T> vu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vu9Var)) == null) ? ru9.a(new jw9(vu9Var.a)) : (ru9) invokeL.objValue;
    }

    public static <T> vu9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new vu9<>(cVar) : (vu9) invokeL.objValue;
    }

    public static <T> vu9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? bx9.m(t) : (vu9) invokeL.objValue;
    }

    public final vu9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (vu9) invokeJL.objValue;
    }

    public final vu9<T> d(long j, TimeUnit timeUnit, uu9 uu9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, uu9Var})) == null) ? b(new ew9(this.a, j, timeUnit, uu9Var)) : (vu9) invokeCommon.objValue;
    }

    public final vu9<T> e(fv9<Throwable> fv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fv9Var)) == null) {
            if (fv9Var != null) {
                return b(new fw9(this, Actions.a(), new b(this, fv9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (vu9) invokeL.objValue;
    }

    public final vu9<T> f(fv9<? super T> fv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fv9Var)) == null) {
            if (fv9Var != null) {
                return b(new fw9(this, fv9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (vu9) invokeL.objValue;
    }

    public final vu9<T> h(uu9 uu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uu9Var)) == null) {
            if (this instanceof bx9) {
                return ((bx9) this).n(uu9Var);
            }
            if (uu9Var != null) {
                return b(new iw9(this.a, uu9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (vu9) invokeL.objValue;
    }

    public final yu9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (yu9) invokeV.objValue;
    }

    public final yu9 j(wu9<? super T> wu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wu9Var)) == null) {
            if (wu9Var != null) {
                try {
                    yy9.t(this, this.a).call(wu9Var);
                    return yy9.s(wu9Var);
                } catch (Throwable th) {
                    dv9.e(th);
                    try {
                        wu9Var.b(yy9.r(th));
                        return oz9.b();
                    } catch (Throwable th2) {
                        dv9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        yy9.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (yu9) invokeL.objValue;
    }

    public final yu9 k(fv9<? super T> fv9Var, fv9<Throwable> fv9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, fv9Var, fv9Var2)) == null) {
            if (fv9Var != null) {
                if (fv9Var2 != null) {
                    return j(new a(this, fv9Var2, fv9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (yu9) invokeLL.objValue;
    }

    public final ru9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (ru9) invokeV.objValue;
    }
}

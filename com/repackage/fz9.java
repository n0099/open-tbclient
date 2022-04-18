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
/* loaded from: classes6.dex */
public class fz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public class a extends gz9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz9 b;
        public final /* synthetic */ pz9 c;

        public a(fz9 fz9Var, pz9 pz9Var, pz9 pz9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz9Var, pz9Var, pz9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pz9Var;
            this.c = pz9Var2;
        }

        @Override // com.repackage.gz9
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

        @Override // com.repackage.gz9
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

    /* loaded from: classes6.dex */
    public class b implements pz9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz9 a;

        public b(fz9 fz9Var, pz9 pz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz9Var, pz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.pz9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c<T> extends pz9<gz9<? super T>> {
        @Override // com.repackage.pz9
        /* synthetic */ void call(T t);
    }

    public fz9(c<T> cVar) {
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
        this.a = j3a.i(cVar);
    }

    public static <T> bz9<T> a(fz9<T> fz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fz9Var)) == null) ? bz9.a(new u0a(fz9Var.a)) : (bz9) invokeL.objValue;
    }

    public static <T> fz9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new fz9<>(cVar) : (fz9) invokeL.objValue;
    }

    public static <T> fz9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? m1a.m(t) : (fz9) invokeL.objValue;
    }

    public final fz9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (fz9) invokeJL.objValue;
    }

    public final fz9<T> d(long j, TimeUnit timeUnit, ez9 ez9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, ez9Var})) == null) ? b(new p0a(this.a, j, timeUnit, ez9Var)) : (fz9) invokeCommon.objValue;
    }

    public final fz9<T> e(pz9<Throwable> pz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pz9Var)) == null) {
            if (pz9Var != null) {
                return b(new q0a(this, Actions.a(), new b(this, pz9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (fz9) invokeL.objValue;
    }

    public final fz9<T> f(pz9<? super T> pz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pz9Var)) == null) {
            if (pz9Var != null) {
                return b(new q0a(this, pz9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (fz9) invokeL.objValue;
    }

    public final fz9<T> h(ez9 ez9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ez9Var)) == null) {
            if (this instanceof m1a) {
                return ((m1a) this).n(ez9Var);
            }
            if (ez9Var != null) {
                return b(new t0a(this.a, ez9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (fz9) invokeL.objValue;
    }

    public final iz9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (iz9) invokeV.objValue;
    }

    public final iz9 j(gz9<? super T> gz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gz9Var)) == null) {
            if (gz9Var != null) {
                try {
                    j3a.t(this, this.a).call(gz9Var);
                    return j3a.s(gz9Var);
                } catch (Throwable th) {
                    nz9.e(th);
                    try {
                        gz9Var.b(j3a.r(th));
                        return z3a.b();
                    } catch (Throwable th2) {
                        nz9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        j3a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (iz9) invokeL.objValue;
    }

    public final iz9 k(pz9<? super T> pz9Var, pz9<Throwable> pz9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, pz9Var, pz9Var2)) == null) {
            if (pz9Var != null) {
                if (pz9Var2 != null) {
                    return j(new a(this, pz9Var2, pz9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (iz9) invokeLL.objValue;
    }

    public final bz9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (bz9) invokeV.objValue;
    }
}

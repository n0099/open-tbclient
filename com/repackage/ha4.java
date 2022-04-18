package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ha4 {
    public static /* synthetic */ Interceptable $ic;
    public static ha4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public x94 a;

    public ha4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new x94();
    }

    public static ha4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ha4 ha4Var = b;
            if (ha4Var != null) {
                return ha4Var;
            }
            synchronized (ha4.class) {
                if (b == null) {
                    b = new ha4();
                }
            }
            return b;
        }
        return (ha4) invokeV.objValue;
    }

    public t94 a(ja4 ja4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ja4Var)) == null) {
            if (ja4Var == null) {
                return null;
            }
            return new oa4(ja4Var, false);
        }
        return (t94) invokeL.objValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        boolean e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                e = this.a.e(str);
            }
            return e;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean d(String str) {
        InterceptResult invokeL;
        boolean f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                f = this.a.f(str);
            }
            return f;
        }
        return invokeL.booleanValue;
    }

    public synchronized void e(fa4 fa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fa4Var) == null) {
            synchronized (this) {
                this.a.c(fa4Var);
            }
        }
    }

    public synchronized <T> void f(ja4<T> ja4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ja4Var) == null) {
            synchronized (this) {
                ja4Var.s(false);
                this.a.h(ja4Var);
            }
        }
    }

    public synchronized void g(fa4 fa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fa4Var) == null) {
            synchronized (this) {
                this.a.i(fa4Var);
            }
        }
    }
}

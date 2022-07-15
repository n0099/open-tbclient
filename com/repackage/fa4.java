package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fa4 {
    public static /* synthetic */ Interceptable $ic;
    public static fa4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public v94 a;

    public fa4() {
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
        this.a = new v94();
    }

    public static fa4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            fa4 fa4Var = b;
            if (fa4Var != null) {
                return fa4Var;
            }
            synchronized (fa4.class) {
                if (b == null) {
                    b = new fa4();
                }
            }
            return b;
        }
        return (fa4) invokeV.objValue;
    }

    public r94 a(ha4 ha4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ha4Var)) == null) {
            if (ha4Var == null) {
                return null;
            }
            return new ma4(ha4Var, false);
        }
        return (r94) invokeL.objValue;
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

    public synchronized void e(da4 da4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, da4Var) == null) {
            synchronized (this) {
                this.a.c(da4Var);
            }
        }
    }

    public synchronized <T> void f(ha4<T> ha4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ha4Var) == null) {
            synchronized (this) {
                ha4Var.s(false);
                this.a.h(ha4Var);
            }
        }
    }

    public synchronized void g(da4 da4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, da4Var) == null) {
            synchronized (this) {
                this.a.i(da4Var);
            }
        }
    }
}

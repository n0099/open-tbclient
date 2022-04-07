package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ia4 {
    public static /* synthetic */ Interceptable $ic;
    public static ia4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public y94 a;

    public ia4() {
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
        this.a = new y94();
    }

    public static ia4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ia4 ia4Var = b;
            if (ia4Var != null) {
                return ia4Var;
            }
            synchronized (ia4.class) {
                if (b == null) {
                    b = new ia4();
                }
            }
            return b;
        }
        return (ia4) invokeV.objValue;
    }

    public u94 a(ka4 ka4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ka4Var)) == null) {
            if (ka4Var == null) {
                return null;
            }
            return new pa4(ka4Var, false);
        }
        return (u94) invokeL.objValue;
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

    public synchronized void e(ga4 ga4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ga4Var) == null) {
            synchronized (this) {
                this.a.c(ga4Var);
            }
        }
    }

    public synchronized <T> void f(ka4<T> ka4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ka4Var) == null) {
            synchronized (this) {
                ka4Var.s(false);
                this.a.h(ka4Var);
            }
        }
    }

    public synchronized void g(ga4 ga4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ga4Var) == null) {
            synchronized (this) {
                this.a.i(ga4Var);
            }
        }
    }
}

package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ga4 {
    public static /* synthetic */ Interceptable $ic;
    public static ga4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public w94 a;

    public ga4() {
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
        this.a = new w94();
    }

    public static ga4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ga4 ga4Var = b;
            if (ga4Var != null) {
                return ga4Var;
            }
            synchronized (ga4.class) {
                if (b == null) {
                    b = new ga4();
                }
            }
            return b;
        }
        return (ga4) invokeV.objValue;
    }

    public s94 a(ia4 ia4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ia4Var)) == null) {
            if (ia4Var == null) {
                return null;
            }
            return new na4(ia4Var, false);
        }
        return (s94) invokeL.objValue;
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

    public synchronized void e(ea4 ea4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ea4Var) == null) {
            synchronized (this) {
                this.a.c(ea4Var);
            }
        }
    }

    public synchronized <T> void f(ia4<T> ia4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ia4Var) == null) {
            synchronized (this) {
                ia4Var.s(false);
                this.a.h(ia4Var);
            }
        }
    }

    public synchronized void g(ea4 ea4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ea4Var) == null) {
            synchronized (this) {
                this.a.i(ea4Var);
            }
        }
    }
}

package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sa4 {
    public static /* synthetic */ Interceptable $ic;
    public static sa4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public ia4 a;

    public sa4() {
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
        this.a = new ia4();
    }

    public static sa4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            sa4 sa4Var = b;
            if (sa4Var != null) {
                return sa4Var;
            }
            synchronized (sa4.class) {
                if (b == null) {
                    b = new sa4();
                }
            }
            return b;
        }
        return (sa4) invokeV.objValue;
    }

    public ea4 a(ua4 ua4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ua4Var)) == null) {
            if (ua4Var == null) {
                return null;
            }
            return new za4(ua4Var, false);
        }
        return (ea4) invokeL.objValue;
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

    public synchronized void e(qa4 qa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qa4Var) == null) {
            synchronized (this) {
                this.a.c(qa4Var);
            }
        }
    }

    public synchronized <T> void f(ua4<T> ua4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ua4Var) == null) {
            synchronized (this) {
                ua4Var.s(false);
                this.a.h(ua4Var);
            }
        }
    }

    public synchronized void g(qa4 qa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, qa4Var) == null) {
            synchronized (this) {
                this.a.i(qa4Var);
            }
        }
    }
}

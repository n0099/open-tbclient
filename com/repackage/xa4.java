package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xa4 {
    public static /* synthetic */ Interceptable $ic;
    public static xa4 b;
    public transient /* synthetic */ FieldHolder $fh;
    public na4 a;

    public xa4() {
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
        this.a = new na4();
    }

    public static xa4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            xa4 xa4Var = b;
            if (xa4Var != null) {
                return xa4Var;
            }
            synchronized (xa4.class) {
                if (b == null) {
                    b = new xa4();
                }
            }
            return b;
        }
        return (xa4) invokeV.objValue;
    }

    public ja4 a(za4 za4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, za4Var)) == null) {
            if (za4Var == null) {
                return null;
            }
            return new eb4(za4Var, false);
        }
        return (ja4) invokeL.objValue;
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

    public synchronized void e(va4 va4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, va4Var) == null) {
            synchronized (this) {
                this.a.c(va4Var);
            }
        }
    }

    public synchronized <T> void f(za4<T> za4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, za4Var) == null) {
            synchronized (this) {
                za4Var.s(false);
                this.a.h(za4Var);
            }
        }
    }

    public synchronized void g(va4 va4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, va4Var) == null) {
            synchronized (this) {
                this.a.i(va4Var);
            }
        }
    }
}

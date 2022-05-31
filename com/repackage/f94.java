package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f94 {
    public static /* synthetic */ Interceptable $ic;
    public static f94 b;
    public transient /* synthetic */ FieldHolder $fh;
    public v84 a;

    public f94() {
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
        this.a = new v84();
    }

    public static f94 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            f94 f94Var = b;
            if (f94Var != null) {
                return f94Var;
            }
            synchronized (f94.class) {
                if (b == null) {
                    b = new f94();
                }
            }
            return b;
        }
        return (f94) invokeV.objValue;
    }

    public r84 a(h94 h94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h94Var)) == null) {
            if (h94Var == null) {
                return null;
            }
            return new m94(h94Var, false);
        }
        return (r84) invokeL.objValue;
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

    public synchronized void e(d94 d94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, d94Var) == null) {
            synchronized (this) {
                this.a.c(d94Var);
            }
        }
    }

    public synchronized <T> void f(h94<T> h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h94Var) == null) {
            synchronized (this) {
                h94Var.s(false);
                this.a.h(h94Var);
            }
        }
    }

    public synchronized void g(d94 d94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, d94Var) == null) {
            synchronized (this) {
                this.a.i(d94Var);
            }
        }
    }
}

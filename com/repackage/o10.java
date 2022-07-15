package com.repackage;

import android.content.Context;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public final class o10 {
    public static /* synthetic */ Interceptable $ic;
    public static o10 a;
    public transient /* synthetic */ FieldHolder $fh;

    public o10() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static o10 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (o10.class) {
                    if (a == null) {
                        a = new o10();
                    }
                }
            }
            return a;
        }
        return (o10) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.27" : (String) invokeV.objValue;
    }

    public void c(Context context, p10<e40> p10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, p10Var) == null) {
            d(context, p10Var, Looper.getMainLooper());
        }
    }

    public void d(Context context, p10<e40> p10Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, p10Var, looper) == null) {
            n10.e(context).i(p10Var, looper);
        }
    }

    public void e(Context context, p10<List<f40>> p10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, p10Var) == null) {
            f(context, p10Var, Looper.getMainLooper());
        }
    }

    public void f(Context context, p10<List<f40>> p10Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, p10Var, looper) == null) {
            n10.e(context).m(p10Var, looper);
        }
    }
}

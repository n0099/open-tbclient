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
public final class m10 {
    public static /* synthetic */ Interceptable $ic;
    public static m10 a;
    public transient /* synthetic */ FieldHolder $fh;

    public m10() {
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

    public static m10 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (m10.class) {
                    if (a == null) {
                        a = new m10();
                    }
                }
            }
            return a;
        }
        return (m10) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.27" : (String) invokeV.objValue;
    }

    public void c(Context context, n10<c40> n10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, n10Var) == null) {
            d(context, n10Var, Looper.getMainLooper());
        }
    }

    public void d(Context context, n10<c40> n10Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, n10Var, looper) == null) {
            l10.e(context).i(n10Var, looper);
        }
    }

    public void e(Context context, n10<List<d40>> n10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, n10Var) == null) {
            f(context, n10Var, Looper.getMainLooper());
        }
    }

    public void f(Context context, n10<List<d40>> n10Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, n10Var, looper) == null) {
            l10.e(context).m(n10Var, looper);
        }
    }
}

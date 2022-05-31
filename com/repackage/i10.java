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
public final class i10 {
    public static /* synthetic */ Interceptable $ic;
    public static i10 a;
    public transient /* synthetic */ FieldHolder $fh;

    public i10() {
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

    public static i10 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (i10.class) {
                    if (a == null) {
                        a = new i10();
                    }
                }
            }
            return a;
        }
        return (i10) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.27" : (String) invokeV.objValue;
    }

    public void c(Context context, j10<y30> j10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, j10Var) == null) {
            d(context, j10Var, Looper.getMainLooper());
        }
    }

    public void d(Context context, j10<y30> j10Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, j10Var, looper) == null) {
            h10.e(context).i(j10Var, looper);
        }
    }

    public void e(Context context, j10<List<z30>> j10Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, j10Var) == null) {
            f(context, j10Var, Looper.getMainLooper());
        }
    }

    public void f(Context context, j10<List<z30>> j10Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, j10Var, looper) == null) {
            h10.e(context).m(j10Var, looper);
        }
    }
}

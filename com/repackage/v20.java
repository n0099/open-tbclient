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
/* loaded from: classes7.dex */
public final class v20 {
    public static /* synthetic */ Interceptable $ic;
    public static v20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public v20() {
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

    public static v20 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (v20.class) {
                    if (a == null) {
                        a = new v20();
                    }
                }
            }
            return a;
        }
        return (v20) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "0.8.27" : (String) invokeV.objValue;
    }

    public void c(Context context, w20<l50> w20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, w20Var) == null) {
            d(context, w20Var, Looper.getMainLooper());
        }
    }

    public void d(Context context, w20<l50> w20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, w20Var, looper) == null) {
            u20.e(context).i(w20Var, looper);
        }
    }

    public void e(Context context, w20<List<m50>> w20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, w20Var) == null) {
            f(context, w20Var, Looper.getMainLooper());
        }
    }

    public void f(Context context, w20<List<m50>> w20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, w20Var, looper) == null) {
            u20.e(context).m(w20Var, looper);
        }
    }
}

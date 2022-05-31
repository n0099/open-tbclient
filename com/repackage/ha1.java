package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class ha1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ha1() {
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

    public void a(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) {
        }
    }

    public boolean b(Context context, ja1 ja1Var, da1 da1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ja1Var, da1Var)) == null) ? d(context, ja1Var, da1Var) : invokeLLL.booleanValue;
    }

    public abstract boolean c(Context context, ja1 ja1Var, da1 da1Var);

    public final boolean d(Context context, ja1 ja1Var, da1 da1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, ja1Var, da1Var)) == null) ? c(context, ja1Var, da1Var) : invokeLLL.booleanValue;
    }
}

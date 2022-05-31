package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v34 extends s34<tl2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755282118, "Lcom/repackage/v34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755282118, "Lcom/repackage/v34;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public v34() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static v34 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new v34() : (v34) invokeV.objValue;
    }

    @Override // com.repackage.s34
    public boolean b(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, tl2Var, ql2Var, hz2Var, jSONObject)) == null) ? e(context, tl2Var, ql2Var, hz2Var) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tl2Var, ql2Var, hz2Var)) == null) {
            hw1.i("map", "MapUpdateAction start");
            boolean update = p34.b().update(context, tl2Var);
            hw1.i("map", "MapUpdateAction end");
            return update;
        }
        return invokeLLLL.booleanValue;
    }
}

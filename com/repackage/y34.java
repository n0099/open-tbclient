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
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class y34 extends s34<tl2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755192745, "Lcom/repackage/y34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755192745, "Lcom/repackage/y34;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public y34() {
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

    public static y34 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new y34() : (y34) invokeV.objValue;
    }

    @Override // com.repackage.s34
    public boolean b(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, tl2Var, ql2Var, hz2Var, jSONObject)) == null) ? e(context, tl2Var, ql2Var, hz2Var, jSONObject) : invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tl2Var, ql2Var, hz2Var, jSONObject)) == null) {
            hw1.i("map", "GetScaleAction start");
            pl1 A = uk2.U().A(tl2Var.c);
            if (!(A instanceof nl1)) {
                hw1.c("map", "WebViewManager is null");
                return false;
            }
            q44 d = p34.b().c((nl1) A).d(tl2Var.b);
            if (d == null) {
                hw1.c("map", "can not find map by id " + tl2Var.b);
                return false;
            }
            try {
                jSONObject.put(AnimationProperty.SCALE, d.l.getMap().getMapStatus().zoom);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            hw1.i("map", "GetScaleAction end");
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}

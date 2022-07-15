package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tm2;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class s44<T extends tm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s44() {
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

    public abstract boolean b(Context context, T t, qm2 qm2Var, h03 h03Var, JSONObject jSONObject);

    public boolean c(Context context, T t, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, t, qm2Var, h03Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!b(context, t, qm2Var, h03Var, jSONObject)) {
                qm2Var.d(1001);
                hx1.c("map", "doAction fail");
                return false;
            }
            if (jSONObject.length() <= 0) {
                jSONObject = null;
            }
            qm2Var.e(jSONObject);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}

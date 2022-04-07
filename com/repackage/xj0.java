package com.repackage;

import com.baidu.nadcore.model.ParseError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public mo0 b;
    public String c;

    public xj0() {
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

    public static xj0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            xj0 xj0Var = new xj0();
            xj0Var.a = jSONObject.optInt("download_state");
            JSONObject optJSONObject = jSONObject.optJSONObject("app_info");
            if (optJSONObject != null) {
                try {
                    xj0Var.b = mo0.c(optJSONObject);
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }
            xj0Var.c = jSONObject.optString("download_hint");
            return xj0Var;
        }
        return (xj0) invokeL.objValue;
    }
}

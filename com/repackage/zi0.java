package com.repackage;

import com.baidu.nadcore.model.ParseError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public qn0 b;
    public String c;

    public zi0() {
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

    public static zi0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            zi0 zi0Var = new zi0();
            zi0Var.a = jSONObject.optInt("download_state");
            JSONObject optJSONObject = jSONObject.optJSONObject("app_info");
            if (optJSONObject != null) {
                try {
                    zi0Var.b = qn0.c(optJSONObject);
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }
            zi0Var.c = jSONObject.optString("download_hint");
            return zi0Var;
        }
        return (zi0) invokeL.objValue;
    }
}

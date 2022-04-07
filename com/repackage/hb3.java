package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.InputType;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public boolean e;

    public hb3() {
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

    @NonNull
    public static hb3 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            hb3 hb3Var = new hb3();
            if (jSONObject == null) {
                return hb3Var;
            }
            hb3Var.a = jSONObject.optString("SSID");
            hb3Var.b = jSONObject.optString("BSSID");
            hb3Var.e = jSONObject.optBoolean("maunal");
            hb3Var.d = jSONObject.optString(InputType.PASSWORD);
            hb3Var.c = jSONObject.optString("identity");
            return hb3Var;
        }
        return (hb3) invokeL.objValue;
    }
}

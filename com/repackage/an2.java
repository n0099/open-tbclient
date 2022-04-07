package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class an2 implements iq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cn2 a;
    public int b;
    public int c;
    public int d;
    public float e;

    public an2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = -16777216;
        this.d = -1;
        this.e = 0.0f;
    }

    @Override // com.repackage.iq2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("radius")) {
            cn2 cn2Var = new cn2();
            this.a = cn2Var;
            cn2Var.a(jSONObject);
            if (this.a.isValid()) {
                this.b = wm2.a(jSONObject.optString("color"), 0);
                this.c = wm2.a(jSONObject.optString("fillColor"), -16777216);
                this.d = jSONObject.optInt("radius", -1);
                this.e = Math.abs(wm2.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // com.repackage.iq2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cn2 cn2Var = this.a;
            return (cn2Var == null || !cn2Var.isValid() || this.d == -1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "coordinate ->" + this.a + "color ->" + this.b + "fillColor ->" + this.c + "radius ->" + this.d + "strokeWidth ->" + this.e;
        }
        return (String) invokeV.objValue;
    }
}

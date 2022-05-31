package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xl2 extends tl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public am2 z;

    public xl2() {
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

    @Override // com.repackage.tl2, com.repackage.xu1, com.repackage.gp2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        jSONObject.optString("cb");
        double optDouble = jSONObject.optDouble("latitude");
        double optDouble2 = jSONObject.optDouble("longitude");
        jSONObject.optString("guideKey");
        jSONObject.optString("guideIcon");
        if (Double.isNaN(optDouble) || Double.isNaN(optDouble2) || optDouble < -90.0d || optDouble > 90.0d || optDouble2 < -180.0d || optDouble2 > 180.0d) {
            return;
        }
        am2 am2Var = new am2();
        this.z = am2Var;
        am2Var.a(jSONObject);
    }

    @Override // com.repackage.xu1, com.repackage.gp2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.z != null : invokeV.booleanValue;
    }
}

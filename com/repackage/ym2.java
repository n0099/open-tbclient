package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ym2 extends vm2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cn2 A;
    public double B;
    public int C;
    public String z;

    public ym2() {
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
        this.z = "";
        this.C = 1000;
    }

    @Override // com.repackage.vm2, com.repackage.zv1, com.repackage.iq2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.z = jSONObject.optString("markerId");
        cn2 cn2Var = new cn2();
        this.A = cn2Var;
        cn2Var.a(jSONObject.optJSONObject("destination"));
        jSONObject.optBoolean("autoRotate");
        this.B = jSONObject.optDouble(AnimationProperty.ROTATE);
        this.C = Math.abs(jSONObject.optInt("duration", this.C));
    }

    @Override // com.repackage.zv1, com.repackage.iq2
    public boolean isValid() {
        InterceptResult invokeV;
        cn2 cn2Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.z) || (cn2Var = this.A) == null || !cn2Var.isValid()) ? false : true : invokeV.booleanValue;
    }
}

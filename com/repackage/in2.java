package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class in2 extends gn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public ArrayList<String> B;
    public String z;

    public in2() {
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
        this.A = "";
    }

    @Override // com.repackage.gn2, com.repackage.kw1, com.repackage.tq2
    public void a(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (jSONObject.has(AnimationProperty.SCALE)) {
            this.k = jSONObject.optDouble(AnimationProperty.SCALE, 18.0d);
        }
        if (jSONObject.has("name")) {
            this.z = jSONObject.optString("name");
        }
        if (jSONObject.has("address")) {
            this.A = jSONObject.optString("address");
        }
        if (jSONObject.has("ignoredApps") && (optJSONArray = jSONObject.optJSONArray("ignoredApps")) != null) {
            int length = optJSONArray.length();
            this.B = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                this.B.add(optJSONArray.optString(i));
            }
        }
        if (jSONObject.has("naviPreference")) {
            jSONObject.optInt("naviPreference", -1);
        }
    }

    @Override // com.repackage.kw1, com.repackage.tq2
    public boolean isValid() {
        InterceptResult invokeV;
        nn2 nn2Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (TextUtils.isEmpty(this.c) || (nn2Var = this.j) == null || !nn2Var.isValid()) ? false : true : invokeV.booleanValue;
    }
}

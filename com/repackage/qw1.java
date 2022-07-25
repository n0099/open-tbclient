package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class qw1 extends uv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int D;
    public String E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qw1() {
        super("coverView", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = "";
    }

    @Override // com.repackage.uv1, com.repackage.wv1, com.repackage.yv1, com.repackage.hq2
    public void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.D = jSONObject.optInt("scrollTop");
        JSONObject jSONObject3 = this.j;
        if (jSONObject3 != null) {
            this.E = jSONObject3.optString("overflowY");
        }
        oq2 oq2Var = this.h;
        if (oq2Var == null || (jSONObject2 = this.j) == null) {
            return;
        }
        oq2Var.i(jSONObject2.optBoolean("fixed", false));
    }
}
